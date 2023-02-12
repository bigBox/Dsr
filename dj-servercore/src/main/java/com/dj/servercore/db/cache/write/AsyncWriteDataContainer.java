package com.dj.servercore.db.cache.write;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.dj.domain.base.IEntity;
import com.dj.servercore.db.base.EntityMetaData;
import com.dj.servercore.db.base.IbatisStatementMapper;
import com.dj.domain.util.GsonUtil;
import com.dj.domain.util.Utility;
import com.ibatis.sqlmap.client.SqlMapClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AsyncWriteDataContainer {

    private long identity;

    private AsyncWriteManager asyncWriteManager;

    private Runnable triggerTask = () -> {
        flush();
        reschedule();
    };

    /**
     *	已变更需要回写的数据
     */
    private LinkedHashMap<String, EntityOperate> entityOperates = new LinkedHashMap<>();
    private Object dataUpdateLock = new Object();
    private Object dataSyncLock = new Object();

    private long lastOperateTime = System.currentTimeMillis();
    private boolean closed = false;

    /**
     *	最终需要回写的数据
     */
    private LinkedHashMap<String, EntityOperate> saveOperates = null;

    public AsyncWriteDataContainer(long identity, AsyncWriteManager asyncWriteManager) {
        this.identity = identity;
        this.asyncWriteManager = asyncWriteManager;
        reschedule();
    }

    public long getIdentity() {
        return this.identity;
    }

    public void updateLastOperateTime() {
        this.lastOperateTime = System.currentTimeMillis();
    }

    /**
     *	保存一个新增的数据
     *
     * @param entity
     */
    public void insert(IEntity entity) {
        synchronized (dataUpdateLock) {
            if (closed)
                return;
            EntityOperate entityOperate = getEntityOperate(getKey(entity), entityOperates);
            entityOperate.insert(entity, true);
            updateLastOperateTime();
        }
    }

    /**
     *	保存一个修改过的数据
     *
     * @param entity
     */
    public void update(IEntity entity) {
        synchronized (dataUpdateLock) {
            if (closed)
                return;
            EntityOperate entityOperate = getEntityOperate(getKey(entity), entityOperates);
            entityOperate.update(entity, true);
            updateLastOperateTime();
        }
    }

    /**
     *	删除一个数据
     *
     * @param entity
     */
    public void delete(IEntity entity) {
        synchronized (dataUpdateLock) {
            if (closed)
                return;
            EntityOperate entityOperate = getEntityOperate(getKey(entity), entityOperates);
            entityOperate.delete(entity, true);
            updateLastOperateTime();
        }
    }

    public void flush() {
        log.info("roleID {}", identity);
        LinkedHashMap<String, EntityOperate> flushOperates = null;
        synchronized (dataUpdateLock) {
            if (entityOperates.size() > 0) {
                flushOperates = entityOperates;
                entityOperates = new LinkedHashMap<>();
            }
        }
        if (null != flushOperates) {
            synchronized (this) {
                if (null == saveOperates) {
                    saveOperates = flushOperates;
                } else {
                    // 合并要保存的数据
                    for (EntityOperate entityOperate : flushOperates.values()) {
                        try {
                            EntityOperate existOperate;
                            IEntity entity;
                            // 新增
                            entity = entityOperate.getInsert();
                            if (null != entity) {
                                existOperate = getEntityOperate(entityOperate.getId(), saveOperates);
                                existOperate.insert(entity, false);
                            }
                            // 修改
                            entity = entityOperate.getUpdate();
                            if (null != entity) {
                                existOperate = getEntityOperate(entityOperate.getId(), saveOperates);
                                existOperate.update(entity, false);
                            }
                            // 删除
                            entity = entityOperate.getDelete();
                            if (null != entity) {
                                existOperate = getEntityOperate(entityOperate.getId(), saveOperates);
                                existOperate.delete(entity, false);
                            }
                        } catch (Exception e) {
                            log.error(Utility.getTraceString(e));
                        }
                    }
                }
                asyncWriteManager.accept2write(this);
            }
        }
    }

    /**
     *	开始一个新的回写调度
     */
    private void reschedule() {
        synchronized (dataUpdateLock) {
            if (!closed) {
                asyncWriteManager.getScheduledExecutor().schedule(triggerTask, asyncWriteManager.getWritePeriod(), TimeUnit.SECONDS);
            }
        }
    }

    /**
     *	判定是否可以丢弃
     *
     * @return
     */
    public boolean canClean() {
        synchronized (this) {
            synchronized (dataUpdateLock) {
                if (!this.closed) {
                    this.closed = (null == saveOperates) && ((System.currentTimeMillis() - lastOperateTime) > asyncWriteManager.getWritePeriod());
                }
            }
        }
        return this.closed;
    }

    public void close() {
        log.info("roleID {}", identity);
        synchronized (dataUpdateLock) {
            this.closed = true;
        }
        flush();
    }

    public void sync() {
        log.info("roleID {}", identity);
        LinkedHashMap<String, EntityOperate> syncOperates = null;
        synchronized (this) {
            if (null != saveOperates) {
                syncOperates = saveOperates;
                saveOperates = null;
            }
        }
        synchronized (dataSyncLock) {
            if (null != syncOperates) {
                Map<String, List<EntityOperate>> groups = new HashMap<>();
                for (EntityOperate operate : syncOperates.values()) {
                    String className = operate.getEntityClassName();
                    if(!className.isEmpty()) {
                        List<EntityOperate> group = groups.get(className);
                        if (null == group) {
                            group = new ArrayList<>();
                            groups.put(operate.getEntityClassName(), group);
                        }
                        group.add(operate);
                    }
                }
                SqlMapClient sqlMapClient = asyncWriteManager.getSqlMapClient();
                try {
                    sqlMapClient.startTransaction();
                    for (List<EntityOperate> operates : groups.values()) {
                        try {
                            sqlMapClient.startBatch();
                            for (EntityOperate operate : operates) {
                                execute(operate, sqlMapClient);
                            }
                            sqlMapClient.executeBatch();
                            sqlMapClient.commitTransaction();
                        } catch (Exception e) {
                            log.error(Utility.getTraceString(e));
                            // 批量同步失败时的处理逻辑 1.单独处理每一个实体变更 2.丢弃产生失败的那个实体变更（主要是insert）
                            for (EntityOperate operate : operates) {
                                try {
                                    execute(operate, sqlMapClient);
                                    sqlMapClient.commitTransaction();
                                } catch (Exception e2) {
                                	log.error(GsonUtil.toJson(operate));
                                    log.error(Utility.getTraceString(e2));
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    log.error(Utility.getTraceString(e));
                } finally {
                    try {
                        sqlMapClient.endTransaction();
                    } catch (SQLException e) {
                        log.error(Utility.getTraceString(e));
                    }
                }
            }
        }
    }

    private void execute(EntityOperate operate, SqlMapClient sqlMapClient) throws SQLException {
        log.info("roleID {}", identity);
        IEntity entity = operate.getInsert();
        if (null != entity) {
            log.info("【insert {}】 {} ", EntityMetaData.getEntityName(entity), GsonUtil.toJson(entity));
            sqlMapClient.insert(IbatisStatementMapper.createStatement(IbatisStatementMapper.INSERT_OP, EntityMetaData.getEntityName(entity)), entity);
        }
        entity = operate.getUpdate();
        if (null != entity) {
            log.info("【update {}】 {} ", EntityMetaData.getEntityName(entity), GsonUtil.toJson(entity));
            sqlMapClient.update(IbatisStatementMapper.createStatement(IbatisStatementMapper.UPDATE_OP, EntityMetaData.getEntityName(entity)), entity);
        }
        entity = operate.getDelete();
        if (null != entity) {
            log.info("【delete {}】 {} ", EntityMetaData.getEntityName(entity), GsonUtil.toJson(entity));
            sqlMapClient.delete(IbatisStatementMapper.createStatement(IbatisStatementMapper.DELETE_OP, EntityMetaData.getEntityName(entity)), entity);
        }
    }

    private EntityOperate getEntityOperate(String entityId, LinkedHashMap<String, EntityOperate> operates) {
        EntityOperate entityOperate = operates.get(entityId);
        if (null == entityOperate) {
            entityOperate = new EntityOperate(entityId);
            operates.put(entityId, entityOperate);
        }
        return entityOperate;
    }

    /**
     *	构造回写数据的唯一标记
     *
     * @param entity
     * @return
     */
    private String getKey(IEntity entity) {
        return (new StringBuilder(entity.getClass().getSimpleName()).append(entity.getPrimaryKeyValue())).toString();
    }
}
