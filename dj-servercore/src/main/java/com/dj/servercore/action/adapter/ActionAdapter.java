package com.dj.servercore.action.adapter;

import com.dj.servercore.action.base.BaseActionManager;
import com.dj.servercore.server.netty.channel.inf.IChannelBaseManager;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: ActionAdapter
 * @Description: action适配器
 * @date 2019年8月6日
 */
@Slf4j
@AllArgsConstructor
public abstract class ActionAdapter<A extends BaseActionManager, C extends IChannelBaseManager> implements IMsgAction {

    /**
     * @Field actionManager : action管理器
     */
    protected A actionManager;
    /**
     * @Field channelManager : channel管理器
     */
    protected C channelManager;

    protected void logError(GeneratedMessageV3 msg, Exception e) {
        String content = StringUtil.msg2Json(msg);
        String error = Utility.getTraceString(e);
        log.error("clz {}, content {}, error {}", msg.getClass().getSimpleName(), content, error);
        //WechatUtil.writeActionException(AbsServer.getServerConfig().getTag(), AbsServer.getServerConfig().getName(), AbsServer.getServerConfig().getId(), msg.getClass().getSimpleName(), content, error);
    }
}
