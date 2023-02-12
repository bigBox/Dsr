package com.dj.serverapi.dao.item;

import com.dj.domain.type.AccessType;
import com.dj.domain.type.ItemType;
import com.dj.domain.entity.player.item.PlayerItem1;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.item.inf.IItemType;
import com.dj.serverapi.dao.item.inf.IPlayerItem1Dao;
import com.dj.domain.util.lib.QueryParamMap;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: PlayerItem1Dao
 * @Description: 植物
 * @author zcq
 * @date 2019年6月25日
 */
@Component
public class PlayerItem1Dao extends BaseCacheDao<PlayerItem1> implements IPlayerItem1Dao, IItemType {

	@Override
	public List<PlayerItem1> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}

	@Override
	public int getItemType() {
		return ItemType.type1;
	}
}
