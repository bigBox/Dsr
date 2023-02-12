package com.dj.servergate.quartz;

import com.dj.protobuf.ServerType;
import com.dj.servercore.quartz.AbstractQuartzJob;
import com.dj.servergate.manager.ChannelManager;
import com.dj.servergate.manager.QuartzManager;
import com.dj.servergate.server.GateServer;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;

@Slf4j
public class OnlineJob extends AbstractQuartzJob {

    public OnlineJob() {
        setName(OnlineJob.class.getSimpleName());
        setDescription("在线人数");
        setNeedCancelAfterWork(false);
        setRetryAfter3MinOnError(false);
    }

    @Override
    protected void run(JobExecutionContext jobContext) {
        long channelSize = ChannelManager.getInstance().getChannelSize();
        log.info("serverType:{}, serverID:{}, onlineCount:{}", ServerType.GATE, GateServer.getServerConfig().getId(), channelSize);
    }

    public static void init() {
        QuartzManager.getInstance().addJob("maintain_online", "group_job_maintain", OnlineJob.class, 60 * 1000L);
    }
}
