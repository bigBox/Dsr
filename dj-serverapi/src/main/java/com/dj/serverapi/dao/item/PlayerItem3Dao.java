package com.dj.serverapi.dao.item;

import com.dj.domain.type.AccessType;
import com.dj.domain.type.ItemType;
import com.dj.domain.entity.player.item.PlayerItem3;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.item.inf.IItemType;
import com.dj.serverapi.dao.item.inf.IPlayerItem3Dao;
import com.dj.domain.util.lib.QueryParamMap;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ClassName: PlayerItem3Dao
 * @Description: 食品
 * @author zcq
 * @date 2019年6月25日
 */
@Component
public class PlayerItem3Dao extends BaseCacheDao<PlayerItem3> implements IPlayerItem3Dao, IItemType {

	@Override
	public List<PlayerItem3> readDbData(long roleID) {
		QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
		queryParams.put("roleID", roleID);
		return selectList(queryParams, roleID, AccessType.DIRECT_DB);
	}

	@Override
	public int getItemType() {
		return ItemType.type3;
	}
}
