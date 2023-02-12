package com.dj.servercore.task;

import com.dj.protobuf.ServerType;
import com.dj.protobuf.ProtobufCmdPool;
import com.dj.servercore.server.netty.channel.BaseGateChannelManager;
import com.dj.servercore.task.msg.MsgDispatcher;
import com.dj.servercore.task.msg.MyMsg;

import com.dj.domain.util.Utility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractClientTask extends AbstractTask {

    protected static final ProtobufCmdPool CMD_POOL = ProtobufCmdPool.INSTANCE;

    protected static BaseGateChannelManager channelManager;

    /**
     * @Field msgDispatcher : 消息分发器
     */
    @Getter
    protected static MsgDispatcher msgDispatcher;

    protected MyMsg msg;

    @Override
    public void run() {
        try {
            ServerType serverType = CMD_POOL.getServerType(msg.getCmd());
            if (serverType.equals(ServerType.GATE)) {
                // 网关自行处理
                msgDispatcher.dispatch(msg);
            } else {
                switch (serverType) {
                    case PLAYER:
                        break;
                    case GAME:
                        break;
                    case GLOBAL:
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
        	log.info(Utility.getTraceString(e));
        }
    }

    @Override
    protected void reset() {
        resetProperties();
    }
}
