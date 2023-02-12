package com.dj.servercore.task.msg;

import com.dj.protobuf.Module;
import com.dj.servercore.action.adapter.IMsgAction;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.servercore.task.AbstractTask;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;

import io.netty.channel.ChannelHandlerContext;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings({"rawtypes", "unchecked", "deprecation"})
public class MyMsg extends AbstractTask {

    private Module module;

    private int cmd;

    private ChannelHandlerContext channel;

    private GeneratedMessageV3 content;

    private GeneratedMessageV3.Builder resultBuilder;

    private long roleID;

    /**
     * @Field action : 处理器
     */
    private IMsgAction action;

    @Override
    public void run() {
        try {
            action.handler(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void resetProperties() {
        module = null;
        cmd = 0;
        channel = null;
        content = null;
        resultBuilder = null;
        roleID = 0;
        action = null;
    }

    @Override
    protected void reset() {
        resetProperties();
    }

    public <T> T getContent(Class<T> type) {
        return type.cast(content);
    }

    public <T extends GeneratedMessageV3.Builder> T getResultBuilder(Class<? extends GeneratedMessageV3> type) {
        try {
            resultBuilder = (GeneratedMessageV3.Builder) type.getMethod("newBuilder").invoke(null);
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
        }
        return (T) resultBuilder;
    }

    public void returnResultBuilder() {
        if (channel != null && resultBuilder != null) {
            try {
                channel.writeAndFlush(resultBuilder.build());
            } catch (Exception e) {
                log.error(Utility.getTraceString(e));
            }
        }
    }

    public int getServerID() {
        return channel.attr(ServerAttribute.serverID).get();
    }
}
