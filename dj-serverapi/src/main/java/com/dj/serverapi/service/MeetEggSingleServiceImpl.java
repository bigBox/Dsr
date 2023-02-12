package com.dj.serverapi.service;

import com.dj.domain.data.meetEgg.MeetEggBuild;
import com.dj.serverapi.redis.model.MeetEggSingleModel;
import com.dj.serverapi.service.inf.IMeetEggSingleService;
import com.dj.servercore.redis.base.BaseService;
import com.dj.domain.util.DateUtil;

import java.util.Date;
import java.util.Map;

public class MeetEggSingleServiceImpl extends BaseService implements IMeetEggSingleService {

    @Override
    public MeetEggBuild getMeetEggBuild(long roleID, int buildID) {
        return getReadModel(roleID, MeetEggSingleModel.class).getMeetEggBuild(buildID);
    }

    @Override
    public boolean hasMeetEggReward(long roleID, Date nowDate) {
        Map<Integer, MeetEggBuild> buildMap = getReadModel(roleID, MeetEggSingleModel.class).getMeetEggBuildMap();
        for (MeetEggBuild build : buildMap.values()) {
            if (build.getScore() > 0 && DateUtil.isToday(build.getMeetEggTime())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getMeetEggReward(long roleID, Date nowDate) {
        Map<Integer, MeetEggBuild> buildMap = getReadModel(roleID, MeetEggSingleModel.class).getMeetEggBuildMap();
        int score = 0;
        for (MeetEggBuild build : buildMap.values()) {
            if (build.getScore() > 0 && DateUtil.isToday(build.getMeetEggTime())) {
                if (build.getLastRewardTime() > 0) {
                    Date lastRewardTime = new Date(build.getLastRewardTime());
                    int hours = DateUtil.hoursBetween(lastRewardTime, nowDate);
                    if (hours <= 24) {
                        score += hours * build.getScore();
                    }
                }
            }
        }
        return score;
    }

    @Override
    public void updateMeetEggBuild(long roleID, int buildID, long meetEggTime, int score) {
        getWriteModel(roleID, MeetEggSingleModel.class).updateMeetEggBuild(buildID, meetEggTime, score);
    }

    @Override
    public void updateMeetEggLastRewardTime(long roleID, long lastRewardTime) {
        Map<Integer, MeetEggBuild> buildMap = getWriteModel(roleID, MeetEggSingleModel.class).getMeetEggBuildMap();
        for (MeetEggBuild build : buildMap.values()) {
            build.setLastRewardTime(lastRewardTime);
        }
    }
}
