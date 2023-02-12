package com.dj.serverapi.dao.item;

import com.dj.domain.type.AccessType;
import com.dj.domain.type.ItemType;
import com.dj.domain.entity.player.item.PlayerItem2;
import com.dj.serverapi.dao.base.BaseCacheDao;
import com.dj.serverapi.dao.item.inf.IItemType;
import com.dj.serverapi.dao.item.inf.IPlayerItem2Dao;
import com.dj.domain.util.lib.QueryParamMap;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zcq
 * @ClassName: PlayerItem2Dao
 * @Description: 动物
 * @date 2019年6月25日
 */
@Component
public class PlayerItem2Dao extends BaseCacheDao<PlayerItem2> implements IPlayerItem2Dao, IItemType {

    @Override
    public List<PlayerItem2> readDbData(long roleID) {
        QueryParamMap<String, Object> queryParams = new QueryParamMap<>(1);
        queryParams.put("roleID", roleID);
        return selectList(queryParams, roleID, AccessType.DIRECT_DB);
    }

    @Override
    public int getItemType() {
        return ItemType.type2;
    }
}
