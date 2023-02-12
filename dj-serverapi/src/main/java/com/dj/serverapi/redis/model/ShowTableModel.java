package com.dj.serverapi.redis.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dj.domain.RedisKeys;
import com.dj.domain.entity.player.PlayerShowTable;
import com.dj.domain.entity.player.PlayerShowTableMoney;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.serverapi.redis.base.InitModel;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.domain.util.DateUtil;
import com.google.common.collect.Maps;

/**
 * @author zcq
 * @ClassName: ShowTableModel
 * @Description: 展厅
 * @date 2019年8月7日
 */
public class ShowTableModel extends InitModel {

    public ShowTableModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_SHOW_TABLE, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
    	initTime();
    	
        this.data.initNewSubMap(RedisKeys.KEY_SHOW_TABLE_COL_0);
        this.data.initNewSubMap(RedisKeys.KEY_SHOW_TABLE_COL_1);
        this.data.initNewSubMap(RedisKeys.KEY_SHOW_TABLE_COL_2);
        this.data.initNewSubMap(RedisKeys.KEY_SHOW_TABLE_COL_3);
        
        // 展厅点赞
        this.data.initNewSubMap(RedisKeys.KEY_SHOW_TABLE_SUPPORT);
    }
    
    @Override
    protected void onLoadOver() {
        Long initTime = getInitTime();
        if (initTime == null) {
            initTime();
        }
        if (!DateUtil.isToday(getInitTime())) {
        	resetInitTime();
        	Map<Long, List<Integer>> supportMap = getShowTableSupport();
        	supportMap.clear();
        }
        if(!this.data.isExists(RedisKeys.KEY_SHOW_TABLE_MONEY)) {
    		PlayerShowTableMoney showTableMoney = new PlayerShowTableMoney(uniqueId);
    		setShowTableMoney(showTableMoney);
        }
    }
    
    public Map<Long, List<Integer>> getShowTableSupport() {
    	return this.data.get(RedisKeys.KEY_SHOW_TABLE_SUPPORT);
    }

    public void setShowTables(List<PlayerShowTable> showTables) {
        Map<Integer, Map<Integer, PlayerShowTable>> colMap0 = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_0);
        Map<Integer, PlayerShowTable> colMap1 = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_1);
        Map<Integer, PlayerShowTable> colMap2 = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_2);
        Map<Integer, PlayerShowTable> colMap3 = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_3);
        colMap0.clear();
        colMap1.clear();
        colMap2.clear();
        colMap3.clear();
        for (PlayerShowTable playerShowTable : showTables) {
            switch (playerShowTable.getType()) {
                case 1:// 水族馆
                    colMap1.put(playerShowTable.getIndex(), playerShowTable);
                    break;
                case 2:// 标本
                    colMap2.put(playerShowTable.getIndex(), playerShowTable);
                    break;
                case 3:// 字画（废弃）
                    colMap3.put(playerShowTable.getIndex(), playerShowTable);
                    break;
                case 0:// 宝物
                default://默认宝物
                    if(colMap0.containsKey(playerShowTable.getPage())) {
                        Map<Integer, PlayerShowTable>colMap = colMap0.get(playerShowTable.getPage());
                        if(colMap != null) {
                            colMap.put(playerShowTable.getIndex(), playerShowTable);
                        }
                    }else{
                        Map<Integer, PlayerShowTable>colMap = new HashMap<>();
                        colMap.put(playerShowTable.getIndex(), playerShowTable);
                        colMap0.put(playerShowTable.getPage(), colMap);
                    }
                    break;
            }
        }
    }

    public Map<Integer, PlayerShowTable> getShowTable(int type, int page) {
        Map<Integer, PlayerShowTable> colMap = null;
        switch (type) {
            case 1:// 水族馆
                colMap = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_1);
                break;
            case 2:// 标本
                colMap = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_2);
                break;
            case 3:// 字画（废弃）
                colMap = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_3);
                break;
            case 0:// 宝物
            default://默认宝物
                Map<Integer, Map<Integer, PlayerShowTable>> colMap0 = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_0);
                if(colMap0.containsKey(page)){
                    colMap = colMap0.get(page);
                }else {
                    colMap = new HashMap<>();
                    colMap0.put(page, colMap);
                }
                break;
        }
        if(colMap == null) {
        	return null;
        }
        Map<Integer, PlayerShowTable> resultMap = Maps.newHashMapWithExpectedSize(colMap.size());
        for(Map.Entry<Integer, PlayerShowTable> entry : colMap.entrySet()){
            if(entry.getValue().getPage() == page){
                resultMap.put(entry.getKey(), entry.getValue());
            }
        }
        return resultMap;
    }

    public void showTablePutOn(PlayerShowTable showTable) {
        Map<Integer, PlayerShowTable> resultMap = null;
        switch (showTable.getType()) {
            case 1:// 水族馆
                resultMap = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_1);
                break;
            case 2:// 标本
                resultMap = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_2);
                break;
            case 3:// 字画（废弃）
                resultMap = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_3);
                break;
            case 0:// 宝物，字画
            default://默认宝物
                Map<Integer, Map<Integer, PlayerShowTable>> colMap0 = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_0);
                if (colMap0 == null) {
                    throw new CommonException(ErrorID.SYSTEM_PARAM_ERROR);
                }
                if(colMap0.containsKey(showTable.getPage())){
                    resultMap = colMap0.get(showTable.getPage());
                }else{
                    resultMap = new HashMap<>();
                    colMap0.put(showTable.getPage(), resultMap);
                }
                break;
        }
        if (resultMap == null) {
            throw new CommonException(ErrorID.SYSTEM_PARAM_ERROR);
        }
        resultMap.put(showTable.getIndex(), showTable);
    }

    public void showTablePutDown(PlayerShowTable showTable) {
        Map<Integer, PlayerShowTable> resultMap = null;
        switch (showTable.getType()) {
            case 1:// 水族馆
                resultMap = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_1);
                break;
            case 2:// 标本
                resultMap = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_2);
                break;
            case 3:// 字画（废弃）
                resultMap = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_3);
                break;
            case 0:// 宝物，字画
            default://默认宝物
                Map<Integer, Map<Integer, PlayerShowTable>> colMap0 = this.data.get(RedisKeys.KEY_SHOW_TABLE_COL_0);
                if (colMap0 == null) {
                    throw new CommonException(ErrorID.SYSTEM_PARAM_ERROR);
                }
                if(colMap0.containsKey(showTable.getPage())){
                    resultMap = colMap0.get(showTable.getPage());
                }
                break;
        }
        if (resultMap == null) {
            throw new CommonException(ErrorID.SYSTEM_PARAM_ERROR);
        }
        resultMap.remove(showTable.getIndex());
    }

    public PlayerShowTableMoney getShowTableMoney() {
        return this.data.get(RedisKeys.KEY_SHOW_TABLE_MONEY);
    }

    public void setShowTableMoney(PlayerShowTableMoney showTableMoney) {
        this.data.set(RedisKeys.KEY_SHOW_TABLE_MONEY, showTableMoney);
    }
}
