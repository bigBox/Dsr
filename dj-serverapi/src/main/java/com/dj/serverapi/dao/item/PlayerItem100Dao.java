package com.dj.serverapi.dao.item;

import com.dj.domain.type.AccessType;
import com.dj.domain.type.ItemType;
import com.dj.domain.entity.player.item.PlayerItem100;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.item.inf.IItemType;
import com.dj.serverapi.dao.item.inf.IPlayerItem100Dao;
import com.dj.domain.util.lib.QueryParamMap;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: PlayerItem100Dao
 * @Description: 不进仓库的物品
 * @author zcq
 * @date 2019年6月25日
 */
@Component
public class PlayerItem100Dao extends BaseCacheDao<PlayerItem100> implements IPlayerItem100Dao, IItemType {

	@Override
	public List<PlayerItem100> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}

	@Override
	public int getItemType() {
		return ItemType.type100;
	}
}
