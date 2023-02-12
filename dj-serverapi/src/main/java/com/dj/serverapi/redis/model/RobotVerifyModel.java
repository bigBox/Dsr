package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.domain.data.Verify;
import com.dj.domain.entity.robot.RobotVerify;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.base.BaseModel;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zcq
 * @ClassName: RobotVerifyModel
 * @Description: 鉴定
 * @date 2019年10月9日
 */
public class RobotVerifyModel extends BaseModel {

    public RobotVerifyModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_ROBOT_VERIFY, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        this.data.set(RedisKeys.KEY_ROBOT_VERIFY_LIST, Lists.newLinkedList());
        this.data.set(RedisKeys.KEY_ROBOT_VERIFY_UPDATE, Lists.newArrayList());
    }

    public List<Verify> getVerifyList() {
        return this.data.get(RedisKeys.KEY_ROBOT_VERIFY_LIST);
    }

    public void setVerifyQueue(List<RobotVerify> list) {
        this.data.set(RedisKeys.KEY_ROBOT_VERIFY_QUEUE, list);
    }

    public List<RobotVerify> getVerifyQueue() {
        return this.data.get(RedisKeys.KEY_ROBOT_VERIFY_QUEUE);
    }

    public List<RobotVerify> getVerifyUpdate() {
        return this.data.get(RedisKeys.KEY_ROBOT_VERIFY_UPDATE);
    }
}
