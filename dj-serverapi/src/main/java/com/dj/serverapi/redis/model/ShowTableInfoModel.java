package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.domain.entity.player.PlayerShowTableInfo;
import com.dj.serverapi.redis.base.InitModel;
import com.dj.servercore.redis.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zcq
 * @ClassName: ShowTableModel
 * @Description: 展厅
 * @date 2019年8月7日
 */
public class ShowTableInfoModel extends InitModel {

    public ShowTableInfoModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_SHOW_TABLE_INFO, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
    	initTime();
    }
    
    @Override
    protected void onLoadOver() {

    }

    public PlayerShowTableInfo getShowTableInfo(int page) {
        Map<Integer, PlayerShowTableInfo> showTableInfos = this.data.get(RedisKeys.KEY_SHOW_TABLE_INFO);
        if(showTableInfos != null) {
            return showTableInfos.get(page);
        }
        return null;
    }

    public void setShowTableInfo(PlayerShowTableInfo showTableInfo){
        Map<Integer, PlayerShowTableInfo> showTableInfos = this.data.get(RedisKeys.KEY_SHOW_TABLE_INFO);
        if(showTableInfos == null) {
            showTableInfos = new HashMap<>();
        }
        showTableInfos.put(showTableInfo.getPage(), showTableInfo);
        this.data.set(RedisKeys.KEY_SHOW_TABLE_INFO, showTableInfos);
    }
}
