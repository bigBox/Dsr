package com.dj.serverapi.dao.base;

import com.dj.domain.type.AccessType;
import com.dj.domain.base.IEntity;
import com.dj.serverapi.redis.CommonRedis;
import com.dj.servercore.db.base.AbsDao;

import java.util.List;

public abstract class BaseCacheDao<P extends IEntity> extends AbsDao<P> {

    @Override
    public String getAccessType() {
        return AccessType.DIRECT_DB;
    }

    protected long readModuleID(String tableID) {
        return CommonRedis.getInstance().readModuleID(tableID);
    }

    public List<P> readDbData(long identity) {
        return null;
    }
}
