package com.dj.serverapi.dao.item;

import com.dj.domain.entity.robot.item.RobotItem6;
import com.dj.domain.type.AccessType;
import com.dj.domain.type.ItemType;
import com.dj.domain.util.lib.QueryParamMap;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.item.inf.IItemType;
import com.dj.serverapi.dao.item.inf.IRobotItem6Dao;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: PlayerItem6Dao
 * @Description: 道具
 * @author zcq
 * @date 2019年6月25日
 */
@Component
public class RobotItem6Dao extends BaseCacheDao<RobotItem6> implements IRobotItem6Dao, IItemType {

	@Override
	public List<RobotItem6> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}

	@Override
	public int getItemType() {
		return ItemType.type6;
	}
}
