package com.dj.serverapi.dao.item;

import com.dj.domain.entity.robot.item.RobotItem100;
import com.dj.domain.type.AccessType;
import com.dj.domain.type.ItemType;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.item.inf.IItemType;
import com.dj.serverapi.dao.item.inf.IRobotItem100Dao;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: PlayerItem100Dao
 * @Description: 不进仓库的物品
 * @author zcq
 * @date 2019年6月25日
 */
@Component
public class RobotItem100Dao extends BaseCacheDao<RobotItem100> implements IRobotItem100Dao, IItemType {

	@Override
	public List<RobotItem100> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}

	@Override
	public int getItemType() {
		return ItemType.type100;
	}
}
