package com.dj.serverapi.redis.model;

import com.dj.domain.RedisKeys;
import com.dj.domain.data.meetEgg.MeetEggBuild;
import com.dj.servercore.redis.RedisTemplate;
import com.dj.servercore.redis.base.BaseModel;

import java.util.Map;

/**
 * @author zcq
 * @ClassName: MeetEggSingleModel
 * @Description: 单人接鸡蛋
 * @date 2019年8月7日
 */
public class MeetEggSingleModel extends BaseModel {

    public MeetEggSingleModel(Long roleID, RedisTemplate lockTemplate, RedisTemplate redisTemplate, Boolean lock) {
        super(RedisKeys.KEY_MEET_EGG_SINGLE, roleID, lockTemplate, redisTemplate, lock);
    }

    @Override
    protected void init() {
        this.data.initNewSubMap(RedisKeys.KEY_MEET_EGG_BUILD);
    }

    public Map<Integer, MeetEggBuild> getMeetEggBuildMap() {
        return this.data.get(RedisKeys.KEY_MEET_EGG_BUILD);
    }

    public MeetEggBuild getMeetEggBuild(int buildID) {
        return this.data.getSubMapItem(RedisKeys.KEY_MEET_EGG_BUILD, buildID);
    }

    public void updateMeetEggBuild(int buildID, long meetEggTime, int score) {
        MeetEggBuild build = this.data.getSubMapItem(RedisKeys.KEY_MEET_EGG_BUILD, buildID);
        if (build == null) {
            build = new MeetEggBuild(buildID, meetEggTime, score, meetEggTime);
            this.data.addSubMapItem(RedisKeys.KEY_MEET_EGG_BUILD, buildID, build);
        } else {
            build.setMeetEggTime(meetEggTime);
            build.setScore(score);
            build.setLastRewardTime(meetEggTime);
        }
    }
}
