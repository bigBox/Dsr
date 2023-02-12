package com.dj.serverapi.dao.item;

import java.util.List;

import org.springframework.stereotype.Component;

import com.dj.domain.type.AccessType;
import com.dj.domain.type.ItemType;
import com.dj.domain.entity.player.item.PlayerItem7;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.item.inf.IItemType;
import com.dj.serverapi.dao.item.inf.IPlayerItem7Dao;
import com.dj.domain.util.lib.QueryParamMap;

/**
 * @ClassName: PlayerItem7Dao
 * @Description: 宝贝
 * @author zcq
 * @date 2019年6月25日
 */
@Component
public class PlayerItem7Dao extends BaseCacheDao<PlayerItem7> implements IPlayerItem7Dao, IItemType {

	@Override
	public List<PlayerItem7> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}

	@Override
	public int getItemType() {
		return ItemType.type7;
	}
}
