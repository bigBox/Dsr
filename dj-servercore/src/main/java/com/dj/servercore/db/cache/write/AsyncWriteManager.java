package com.dj.servercore.db.cache.write;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;

import com.dj.domain.util.ThreadUtil;
import com.dj.domain.util.Utility;
import com.ibatis.sqlmap.client.SqlMapClient;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AsyncWriteManager {

	private ScheduledExecutorService scheduledExecutor = Executors.newSingleThreadScheduledExecutor();

	/**
	 *	数据回写周期
	 */
	@Getter
	private long writePeriod = 5 * 60 * 1000;

	private int writerSize = 1;

	private SqlMapClient sqlMapClient;

	private Writer[] writers;

	private ConcurrentMap<Long, AsyncWriteDataContainer> dataContainers = new ConcurrentHashMap<>();

	public void setWritePeriod(long writePeriod) {
		this.writePeriod = writePeriod * 60 * 1000;
	}

	public void setWriterSize(int writerSize) {
		this.writerSize = writerSize;
	}

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public void init() {
		// 校验必要变量
		if (writePeriod < 1 * 60 * 1000)
			throw new RuntimeException("clean gap must more than 1 minute,[cleanGap > 1].");
		if (writerSize <= 0)
			throw new RuntimeException("size of writer must more than 0,[writerSize > 0].");
		if (null == sqlMapClient)
			throw new RuntimeException("ibatis SqlMapClient can't be null.");

		log.info("writePeriod {}, minute {}", writePeriod, writePeriod / 60 / 1000);
		// 启动回写并发实例
		writers = new Writer[writerSize];
		for (int i = 0; i < writerSize; i++) {
			writers[i] = new Writer("AsyncWriteManager-Writer-" + i);
		}
		// 启动清理线程
		Thread cleanThread = new Thread(() -> {
			for (;;) {
				try {
					Thread.sleep(writePeriod);
					int cleanedCount = 0;
					for (AsyncWriteDataContainer dataContainer : dataContainers.values()) {
						if (cleanDataContainer(dataContainer.getIdentity(), dataContainer)) {
							cleanedCount++;
						}
					}
					log.info("AsyncWriteManager:cleaned {}, remain {}", cleanedCount, dataContainers.size());
				} catch (Exception e) {
					log.error(Utility.getTraceString(e));
				}
			}
		}, "AsyncWriteManager-Cleaner");
		cleanThread.setDaemon(true);
		cleanThread.start();
	}

	public void close() {
		log.info("server stop info:data container close...");
		for (AsyncWriteDataContainer dataContainer : dataContainers.values()) {
			try {
				dataContainer.close();
			} catch (Exception e) {
				log.error(Utility.getTraceString(e));
			}
		}
		log.info("server stop info:start to data sync...");
		for (;;) {
			ThreadUtil.sleep(5000);
			long syncSize = getSyncSize();
			if (syncSize <= 0) {
				boolean writing = false;
				for (Writer writer : writers) {
					if (writer.isWriting()) {
						writing = true;
						break;
					}
				}
				if (!writing)
					break;
			}
			log.info("server stop info:data sync remain " + syncSize);
		}
		log.info("server stop info:data sync finished.");
	}

	private long getSyncSize() {
		long syncSize = 0;
		for (Writer writer : writers) {
			syncSize += writer.getBalance();
		}
		return syncSize;
	}

	/**
	 *	根据指定id获取一个{@link AsyncWriteDataContainer}
	 * 
	 * @param identity
	 * @return
	 */
	public AsyncWriteDataContainer getDataContainer(long identity) {
		AsyncWriteDataContainer dataContainer = dataContainers.get(identity);
		if (null == dataContainer) {
			dataContainer = new AsyncWriteDataContainer(identity, this);
			dataContainers.put(identity, dataContainer);
		}
		return dataContainer;
	}

	/**
	 *	关闭指定id的{@link AsyncWriteDataContainer}
	 * 
	 * @param identity
	 */
	public void flushDataContainer(long identity) {
		AsyncWriteDataContainer dataContainer = dataContainers.get(identity);
		if (null != dataContainer) {
			dataContainer.flush();
		}
	}

	/**
	 *	移除指定id的{@link AsyncWriteDataContainer}}
	 * 
	 * @param identity
	 * @param dataContainer
	 */
	public boolean cleanDataContainer(long identity, AsyncWriteDataContainer dataContainer) {
		boolean cleaned = false;
		if (null != dataContainer && dataContainer.canClean()) {
			dataContainer.flush();
			dataContainer.sync();
			dataContainers.remove(identity);
			cleaned = true;
		}
		return cleaned;
	}

	/**
	 *	刷新同步指定id的所有数据变化并关闭关联的{@link AsyncWriteDataContainer}
	 * 
	 * @param identity
	 */
	public void flushSyncAllData(long identity) {
		AsyncWriteDataContainer dataContainer = dataContainers.get(identity);
		if (null != dataContainer) {
			dataContainer.flush();
			dataContainer.sync();
		}
	}

	private Writer getWriter() {
		Writer lowest = null;
		long prebalance = 0;
		for (Writer writer : writers) {
			if (null == lowest) {
				lowest = writer;
				prebalance = writer.getBalance();
			} else {
				long balance = writer.getBalance();
				if (balance < prebalance) {
					lowest = writer;
					prebalance = balance;
				}
			}
		}
		return lowest;
	}

	/**
	 *	分发一个数据回写请求
	 * 
	 * @param dataContainer
	 */
	public void accept2write(AsyncWriteDataContainer dataContainer) {
		getWriter().accept(dataContainer);
	}

	/**
	 *	获取定时调度器
	 * 
	 * @return
	 */
	public ScheduledExecutorService getScheduledExecutor() {
		return this.scheduledExecutor;
	}

	public SqlMapClient getSqlMapClient() {
		return this.sqlMapClient;
	}

	private class Writer implements Runnable {
		private LinkedBlockingQueue<AsyncWriteDataContainer> writeQueue = new LinkedBlockingQueue<>();
		private volatile boolean writing = false;

		public Writer(String name) {
			new Thread(this, name).start();
		}

		public long getBalance() {
			return writeQueue.size();
		}

		public boolean isWriting() {
			return writing;
		}

		public void accept(AsyncWriteDataContainer dataContainer) {
			this.writeQueue.add(dataContainer);
		}

		@Override
		public void run() {
			while (true) {
				try {
					AsyncWriteDataContainer dataContainer = writeQueue.take();
					writing = true;
					sync(dataContainer);
				} catch (Exception e) {
					log.error(Utility.getTraceString(e));
				} finally {
					writing = false;
				}
			}
		}

		protected void sync(AsyncWriteDataContainer dataContainer) {
			dataContainer.sync();
		}
	}
}
