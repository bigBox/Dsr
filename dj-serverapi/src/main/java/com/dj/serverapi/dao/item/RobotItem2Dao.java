package com.dj.serverapi.dao.item;

import com.dj.domain.entity.robot.item.RobotItem2;
import com.dj.domain.type.AccessType;
import com.dj.domain.type.ItemType;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.item.inf.IItemType;
import com.dj.serverapi.dao.item.inf.IRobotItem2Dao;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zcq
 * @ClassName: RobotItem2Dao
 * @Description: 动物
 * @date 2019年6月25日
 */
@Component
public class RobotItem2Dao extends BaseCacheDao<RobotItem2> implements IRobotItem2Dao, IItemType {

    @Override
    public List<RobotItem2> readDbData(long roleID) {
        QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
        queryParams.put("roleID", roleID);
        return selectList(queryParams, roleID, AccessType.DIRECT_DB);
    }

    @Override
    public int getItemType() {
        return ItemType.type2;
    }
}
