package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.serverapi.redis.base.InitModel;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.domain.util.DateUtil;

/**
 * @author zcq
 * @ClassName: OtherModel
 * @Description: 其他， 每天进入挖矿的次数
 * @date 2019年8月7日
 */
public class OtherModel extends InitModel {

    public OtherModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_OTHER, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        initTime();
    }

    @Override
    protected void onLoadOver() {
        // 如果初始化时间不是今天就重置
        if (!DateUtil.isToday(getInitTime())) {
            resetInitTime();
            // 每天进入挖矿次数
            this.data.set(RedisKeys.KEY_OTHER_MINE_COUNT, 0);
            // 每天自动鉴定次数
            this.data.set(RedisKeys.KEY_OTHER_VERIFY_COUNT, 0);
        }
    }

    public int getAddMineCount() {
        int mineCount = this.data.get(RedisKeys.KEY_OTHER_MINE_COUNT);
        mineCount = mineCount + 1;
        this.data.set(RedisKeys.KEY_OTHER_MINE_COUNT, mineCount);
        return mineCount;
    }
    
    public int getVerifyCount() {
    	return this.data.get(RedisKeys.KEY_OTHER_VERIFY_COUNT);
    }
    
    public void addVerifyCount() {
    	int verifyCount = this.data.get(RedisKeys.KEY_OTHER_VERIFY_COUNT);
    	verifyCount = verifyCount + 1;
        this.data.set(RedisKeys.KEY_OTHER_VERIFY_COUNT, verifyCount);
    }
}
