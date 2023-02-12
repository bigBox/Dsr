package com.dj.serverplayer.manager;

import com.dj.servercore.quartz.AbstractQuartzManager;
import com.dj.serverplayer.quartz.OnlineJob;
import com.dj.serverplayer.quartz.ParkGrazeJob;
import com.dj.serverplayer.quartz.StaminaRecoverJob;
import com.dj.serverplayer.quartz.SummonTravelJob;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@Setter(AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
public class QuartzManager extends AbstractQuartzManager {
    public QuartzManager() {
        setInstance(this);
    }

    public static void init() {
        new QuartzManager();
        QuartzManager.getInstance().initJob();
        QuartzManager.getInstance().start();
    }

    @Override
    public void initJob() {
        // 在线人数
        OnlineJob.init();
        // 精灵旅行
        SummonTravelJob.init();
        // 生态园动物吃草
        ParkGrazeJob.init();
        // 接鸡蛋发放奖励
//      MeetEggGrantRewardJob.init();
        // 体力恢复
        StaminaRecoverJob.init();
    }
}
