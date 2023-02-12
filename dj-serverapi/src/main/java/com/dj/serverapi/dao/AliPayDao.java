package com.dj.serverapi.dao;

import com.dj.domain.type.AccessType;
import com.dj.domain.entity.player.AliPay;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.inf.IAliPayDao;
import com.dj.domain.util.lib.QueryParamMap;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AliPayDao extends BaseCacheDao<AliPay> implements IAliPayDao {

    @Override
    public List<AliPay> readDbData(long roleID) {
        long timeStamp   = System.currentTimeMillis()-30*86400000;
        QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
        queryParams.put("roleID", roleID);
        queryParams.put("timeStamp", timeStamp);
        List<AliPay> list = selectList(queryParams, roleID, AccessType.DIRECT_DB);
        return list;
    }
}
