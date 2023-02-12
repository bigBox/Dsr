package com.dj.servergate.manager;

import com.dj.servercore.quartz.AbstractQuartzManager;
import com.dj.servergate.quartz.KeepAliveJob;
import com.dj.servergate.quartz.OnlineJob;
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
        // 保持逻辑服心跳
        KeepAliveJob.init();
        //在线人数
        OnlineJob.init();
    }
}
