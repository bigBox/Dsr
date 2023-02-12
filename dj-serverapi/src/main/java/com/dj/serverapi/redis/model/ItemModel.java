package com.dj.serverapi.redis.model;

import java.util.List;
import java.util.Map;

import com.dj.domain.RedisKeys;
import com.dj.domain.data.ItemBill;
import com.dj.domain.data.ItemInteractLog;
import com.dj.serverapi.redis.base.InitModel;
import com.dj.servercore.redis.RedisTemplate;
import com.google.common.collect.Lists;

/**
 * @author zcq
 * @ClassName: ItemModel
 * @Description: 物品流通， 物品来源
 * @date 2019年8月7日
 */
public class ItemModel extends InitModel {

    public ItemModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_ITEM, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        this.data.set(RedisKeys.KEY_ITEM_BILL, Lists.newArrayList());
        this.data.initNewSubMap(RedisKeys.KEY_ITEM_RECORD_SOURCE);
        this.data.initNewSubMap(RedisKeys.KEY_ITEM_MAP_PIECE);
        this.data.set(RedisKeys.KEY_ITEM_INTERACT_LOG, Lists.newArrayList());
    }

    @Override
    protected void onLoadOver() {
        if (!this.data.isExists(RedisKeys.KEY_INIT_TIME)) {
            this.data.set(RedisKeys.KEY_INIT_TIME, 0l);
        }
        if (!this.data.isExists(RedisKeys.KEY_ITEM_BILL)) {
            this.data.set(RedisKeys.KEY_ITEM_BILL, Lists.newArrayList());
        }
        if (!this.data.isExists(RedisKeys.KEY_ITEM_RECORD_SOURCE)) {
            this.data.initNewSubMap(RedisKeys.KEY_ITEM_RECORD_SOURCE);
        }
        if (!this.data.isExists(RedisKeys.KEY_ITEM_MAP_PIECE)) {
        	this.data.initNewSubMap(RedisKeys.KEY_ITEM_MAP_PIECE);
        }
        if (!this.data.isExists(RedisKeys.KEY_ITEM_INTERACT_LOG)) {
        	this.data.set(RedisKeys.KEY_ITEM_INTERACT_LOG, Lists.newArrayList());
        }
    }

    public List<ItemBill> getItemBillList() {
        return this.data.get(RedisKeys.KEY_ITEM_BILL);
    }

    public List<Integer> getItemRecordSource(int itemID) {
        if (!this.data.isExistsSubMapItem(RedisKeys.KEY_ITEM_RECORD_SOURCE, itemID)) {
            this.data.addSubMapItem(RedisKeys.KEY_ITEM_RECORD_SOURCE, itemID, Lists.newArrayListWithExpectedSize(3));
        }
        return this.data.getSubMapItem(RedisKeys.KEY_ITEM_RECORD_SOURCE, itemID);
    }
    
    public Map<Integer, Long> getItemMapPiece(){
    	return this.data.get(RedisKeys.KEY_ITEM_MAP_PIECE);
    }
    
    public List<ItemInteractLog> getItemInteractLog(){
    	return this.data.get(RedisKeys.KEY_ITEM_INTERACT_LOG);
    }
}
