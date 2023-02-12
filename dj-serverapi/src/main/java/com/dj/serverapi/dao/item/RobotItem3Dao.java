package com.dj.serverapi.dao.item;

import com.dj.domain.entity.robot.item.RobotItem3;
import com.dj.domain.type.AccessType;
import com.dj.domain.type.ItemType;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.item.inf.IItemType;
import com.dj.serverapi.dao.item.inf.IRobotItem3Dao;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: RobotItem3Dao
 * @Description: 食品
 * @author zcq
 * @date 2019年6月25日
 */
@Component
public class RobotItem3Dao extends BaseCacheDao<RobotItem3> implements IRobotItem3Dao, IItemType {

	@Override
	public List<RobotItem3> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}

	@Override
	public int getItemType() {
		return ItemType.type3;
	}
}
