package com.dj.servercore.executor;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import com.dj.domain.ServerThread;
import com.dj.servercore.pool.MyThreadFactory;
import com.dj.servercore.server.SocketServer;
import com.dj.servercore.task.AbstractTask;
import com.dj.domain.util.Utility;
import com.google.common.collect.Maps;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderedQueuePoolExecutor {
    private int corePoolSize;

    private Map<Integer, LinkedBlockingQueue<AbstractTask>> queueMap;

    private Map<Integer, ExecutorService> excutorMap;

    public OrderedQueuePoolExecutor(String name) {
        if (SocketServer.getServerConfig() != null) {
            this.corePoolSize = SocketServer.getThreadNum();
        } else {
            this.corePoolSize = ServerThread.SERVER_THREAD_NUM;
        }
        this.queueMap = Maps.newHashMapWithExpectedSize(corePoolSize);
        this.excutorMap = Maps.newHashMapWithExpectedSize(corePoolSize);
        for (int i = 0; i < corePoolSize; i++) {
            final LinkedBlockingQueue<AbstractTask> queue = new LinkedBlockingQueue<>(256);
            queueMap.put(i, queue);
            ExecutorService excutor = Executors.newSingleThreadExecutor(new MyThreadFactory(name + "-OrderedQueuePoolExecutor" + i + "-"));
            excutorMap.put(i, excutor);
            excutor.execute(() -> {
                while (true) {
                    AbstractTask task = null;
                    try {
                        task = queue.take();
                        task.run();
                    } catch (Throwable e) {
                        log.error(Utility.getTraceString(e));
                    } finally {
                        AbstractTask.returnTask(task);
                    }
                }
            });
        }
    }

    public void addTask(long key, AbstractTask task) {
        int queueID = (int) (key % corePoolSize);
        if (queueID < 0) {
            queueID = -queueID;
        }
        LinkedBlockingQueue<AbstractTask> queue = queueMap.get(queueID);
        if (queue == null) {
            return;
        }
        try {
            queue.add(task);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
    }

    public void shutdown() {
        for (Map.Entry<Integer, ExecutorService> entry : excutorMap.entrySet()) {
            entry.getValue().shutdown();
        }
    }
}
