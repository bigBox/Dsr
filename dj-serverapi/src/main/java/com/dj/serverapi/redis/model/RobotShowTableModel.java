package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.domain.entity.robot.RobotShowTable;
import com.dj.domain.entity.robot.RobotShowTableMoney;
import com.dj.domain.util.DateUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.serverapi.redis.base.InitModel;
import com.dj.servercore.redis.RedisTemplate;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author zcq
 * @ClassName: ShowTableModel
 * @Description: 展厅
 * @date 2019年8月7日
 */
public class RobotShowTableModel extends InitModel {

    public RobotShowTableModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_ROBOT_SHOW_TABLE, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
    	initTime();
    	
        this.data.initNewSubMap(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_0);
        this.data.initNewSubMap(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_1);
        this.data.initNewSubMap(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_2);
        this.data.initNewSubMap(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_3);
        
        // 展厅点赞
        this.data.initNewSubMap(RedisKeys.KEY_ROBOT_SHOW_TABLE_SUPPORT);
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
        if(!this.data.isExists(RedisKeys.KEY_ROBOT_SHOW_TABLE_MONEY)) {
            RobotShowTableMoney showTableMoney = new RobotShowTableMoney(uniqueId);
    		setShowTableMoney(showTableMoney);
        }
    }
    
    public Map<Long, List<Integer>> getShowTableSupport() {
    	return this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_SUPPORT);
    }

    public void setShowTables(List<RobotShowTable> showTables) {
        Map<Integer, RobotShowTable> col0 = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_0);
        Map<Integer, RobotShowTable> col1 = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_1);
        Map<Integer, RobotShowTable> col2 = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_2);
        Map<Integer, RobotShowTable> col3 = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_3);
        col0.clear();
        col1.clear();
        col2.clear();
        col3.clear();
        for (RobotShowTable playerShowTable : showTables) {
            switch (playerShowTable.getType()) {
                case 0:// 宝物
                    col0.put(playerShowTable.getIndex(), playerShowTable);
                    break;
                case 1:// 水族馆
                    col1.put(playerShowTable.getIndex(), playerShowTable);
                    break;
                case 2:// 标本
                    col2.put(playerShowTable.getIndex(), playerShowTable);
                    break;
                case 3:// 字画（废弃）
                    col3.put(playerShowTable.getIndex(), playerShowTable);
                    break;
            }
        }
    }

    public Map<Integer, RobotShowTable> getShowTable(int type, int page) {
        Map<Integer, RobotShowTable> colMap = null;
        switch (type) {
            case 0:// 宝物
                colMap = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_0);
                break;
            case 1:// 水族馆
                colMap = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_1);
                break;
            case 2:// 标本
                colMap = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_2);
                break;
            case 3:// 字画（废弃）
                colMap = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_3);
                break;
            default://默认宝物
                colMap = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_0);
                break;
        }
        if(colMap == null) {
        	return null;
        }
        Map<Integer, RobotShowTable> resultMap = Maps.newHashMapWithExpectedSize(colMap.size());
        for(Map.Entry<Integer, RobotShowTable> entry : colMap.entrySet()){
            if(entry.getValue().getPage() == page){
                resultMap.put(entry.getKey(), entry.getValue());
            }
        }
        return resultMap;
    }

    public void showTablePutOn(RobotShowTable showTable) {
        Map<Integer, RobotShowTable> resultMap = null;
        switch (showTable.getType()) {
            case 0:// 宝物，字画
                resultMap = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_0);
                break;
            case 1:// 水族馆
                resultMap = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_1);
                break;
            case 2:// 标本
                resultMap = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_2);
                break;
            case 3:// 字画（废弃）
                resultMap = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_3);
                break;
        }
        if (resultMap == null) {
            throw new CommonException(ErrorID.SYSTEM_PARAM_ERROR);
        }
        resultMap.put(showTable.getIndex(), showTable);
    }

    public void showTablePutDown(RobotShowTable showTable) {
        Map<Integer, RobotShowTable> resultMap = null;
        switch (showTable.getType()) {
            case 0:// 宝物，字画
                resultMap = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_0);
                break;
            case 1:// 水族馆
                resultMap = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_1);
                break;
            case 2:// 标本
                resultMap = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_2);
                break;
            case 3:// 字画（废弃）
                resultMap = this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_COL_3);
                break;
        }
        if (resultMap == null) {
            throw new CommonException(ErrorID.SYSTEM_PARAM_ERROR);
        }
        resultMap.remove(showTable.getIndex());
    }

    public RobotShowTableMoney getShowTableMoney() {
        return this.data.get(RedisKeys.KEY_ROBOT_SHOW_TABLE_MONEY);
    }

    public void setShowTableMoney(RobotShowTableMoney showTableMoney) {
        this.data.set(RedisKeys.KEY_ROBOT_SHOW_TABLE_MONEY, showTableMoney);
    }
}
