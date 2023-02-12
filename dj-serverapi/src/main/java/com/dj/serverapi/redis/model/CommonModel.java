package com.dj.serverapi.redis.model;

import java.util.List;
import java.util.Map;

import com.dj.domain.RedisKeys;
import com.dj.domain.data.AttrBill;
import com.dj.serverapi.redis.base.InitModel;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.Lists;

/**
 * @author zcq
 * @ClassName: CommonModel
 * @Description: 通用数据，属性变更，客户端自定义数据，每天帮小寻鉴定标记
 * @date 2019年8月7日
 */
public class CommonModel extends InitModel {

    public CommonModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_COMMON, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        initTime();
        // 通用属性变更
        this.data.set(RedisKeys.KEY_COMMON_ATTR_BILL, Lists.newArrayList());
        // 任务类型状态
        this.data.initNewSubMap(RedisKeys.KEY_COMMON_ACCEPT_TYPE_TASK);
        // 客户端自定义数据
        this.data.initNewSubMap(RedisKeys.KEY_COMMON_CLIENT_DATA);
    }

    @Override
    protected void onLoadOver() {
    	// 客户端自定义数据
        if (!this.data.isExists(RedisKeys.KEY_COMMON_CLIENT_DATA)) {
            this.data.initNewSubMap(RedisKeys.KEY_COMMON_CLIENT_DATA);
        }
        Long initTime = getInitTime();
        if (initTime == null) {
            initTime();
        }
        if (!DateUtil.isToday(getInitTime())) {
            resetInitTime();
            setVerifyXiaoXun(false);
            setParkDrawPrize(false);
        }
    }

    public List<AttrBill> getAttrBillList() {
        return this.data.get(RedisKeys.KEY_COMMON_ATTR_BILL);
    }

    public boolean getVerifyXiaoXun() {
        if (this.data.isExists(RedisKeys.KEY_COMMON_VERIFY_XIAOXUN)) {
            return this.data.get(RedisKeys.KEY_COMMON_VERIFY_XIAOXUN);
        }
        return false;
    }

    public void setVerifyXiaoXun(boolean value) {
        this.data.set(RedisKeys.KEY_COMMON_VERIFY_XIAOXUN, value);
    }

    public int getAcceptTypeTask(int taskType) {
    	Map<Integer, Integer> map = this.data.get(RedisKeys.KEY_COMMON_ACCEPT_TYPE_TASK);
    	return MapUtil.getIntValue(map, taskType);
    }
    
    public void setAcceptTypeTask(int taskType, int value) {
    	Map<Integer, Integer> map = this.data.get(RedisKeys.KEY_COMMON_ACCEPT_TYPE_TASK);
    	map.put(taskType, value);
    }

    public Map<String, Integer> getClientData() {
        return this.data.get(RedisKeys.KEY_COMMON_CLIENT_DATA);
    }
    
    public boolean getParkDrawPrize() {
    	if (this.data.isExists(RedisKeys.KEY_COMMON_PARK_DRAW_PRIZE)) {
    		return this.data.get(RedisKeys.KEY_COMMON_PARK_DRAW_PRIZE);
    	}
    	return false;
    }
    
    public void setParkDrawPrize(boolean value) {
    	this.data.set(RedisKeys.KEY_COMMON_PARK_DRAW_PRIZE, value);
    }

}
