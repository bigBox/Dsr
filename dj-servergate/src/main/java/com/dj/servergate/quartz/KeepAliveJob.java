package com.dj.servergate.quartz;

import org.quartz.JobExecutionContext;

import com.dj.protobuf.ServerType;
import com.dj.protobuf.server.KeepAlive4GameReq;
import com.dj.protobuf.server.KeepAlive4GlobalReq;
import com.dj.protobuf.server.KeepAlive4PlayerReq;
import com.dj.servercore.quartz.AbstractQuartzJob;
import com.dj.servergate.manager.ChannelManager;
import com.dj.servergate.manager.QuartzManager;

public class KeepAliveJob extends AbstractQuartzJob {
    private static KeepAlive4PlayerReq player = KeepAlive4PlayerReq.newBuilder().build();
    private static KeepAlive4GameReq game = KeepAlive4GameReq.newBuilder().build();
    private static KeepAlive4GlobalReq global = KeepAlive4GlobalReq.newBuilder().build();

    public KeepAliveJob() {
        setName(KeepAliveJob.class.getSimpleName());
        setDescription("内部服务器心跳信息");
        setNeedCancelAfterWork(false);
        setRetryAfter3MinOnError(false);
    }

    @Override
    protected void run(JobExecutionContext jobContext) {
        // 玩家服心跳
        ChannelManager.getInstance().sendToAllConnectServer(ServerType.PLAYER, player);
        // 游戏服心跳
        ChannelManager.getInstance().sendToAllConnectServer(ServerType.GAME, game);
        // 全局服心跳
        ChannelManager.getInstance().sendToAllConnectServer(ServerType.GLOBAL, global);
    }

    public static void init() {
        QuartzManager.getInstance().addJob("maintain_keep_alive", "group_job_maintain", KeepAliveJob.class, 20 * 1000L);
    }
}
