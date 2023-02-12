package com.dj.servercore.action;

import com.dj.protobuf.CommonException;
import com.dj.servercore.action.adapter.ActionAdapter;
import com.dj.servercore.action.base.BaseActionManager;
import com.dj.servercore.server.netty.channel.inf.IChannelUserManager;
import com.dj.servercore.task.msg.MyMsg;

/**
 * @author zcq
 * @ClassName: GateActionHandler
 * @Description: 网关服行为处理器
 * @date 2019年8月7日
 */
public class GateActionHandler extends ActionAdapter<BaseActionManager, IChannelUserManager> {

    public GateActionHandler(BaseActionManager actionManager, IChannelUserManager channelManager) {
        super(actionManager, channelManager);
    }

    @Override
    public void handler(MyMsg msg) {
        if (msg == null) {
            return;
        }
        try {
            actionManager.doAction(msg);
        } catch (CommonException e) {
            logError(msg.getContent(), e);
        } catch (Exception e) {
            logError(msg.getContent(), e);
        } finally {
            msg.returnResultBuilder();
        }
    }
}
