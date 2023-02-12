package com.dj.serverapi.dao.item;

import com.dj.domain.entity.robot.item.RobotItem1;
import com.dj.domain.type.AccessType;
import com.dj.domain.type.ItemType;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.item.inf.IItemType;
import com.dj.serverapi.dao.item.inf.IRobotItem1Dao;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: RobotItem1Dao
 * @Description: 植物
 * @author zcq
 * @date 2019年6月25日
 */
@Component
public class RobotItem1Dao extends BaseCacheDao<RobotItem1> implements IRobotItem1Dao, IItemType {

	@Override
	public List<RobotItem1> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}

	@Override
	public int getItemType() {
		return ItemType.type1;
	}
}
