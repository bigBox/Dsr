package com.dj.servercore.action;

import com.dj.protobuf.CommonException;
import com.dj.servercore.action.adapter.ActionAdapter;
import com.dj.servercore.action.base.BaseActionManager;
import com.dj.servercore.event.AbsEventManager;
import com.dj.servercore.server.netty.channel.inf.IChannelServerManager;
import com.dj.servercore.task.msg.MyMsg;

/**
 * @author zcq
 * @ClassName: GameActionHandler
 * @Description: 游戏服行为处理器
 * @date 2019年8月7日
 */
public class GameActionHandler extends ActionAdapter<BaseActionManager, IChannelServerManager> {

    public GameActionHandler(BaseActionManager actionManager, IChannelServerManager channelManager) {
        super(actionManager, channelManager);
    }

    @Override
    public void handler(MyMsg msg) {
        if (msg == null) {
            return;
        }
        long roleID = 0;
        try {
            roleID = actionManager.doAction(msg);
        } catch (CommonException e) {
            logError(msg.getContent(), e);
        } catch (Exception e) {
            logError(msg.getContent(), e);
        } finally {
            msg.returnResultBuilder();
            if (roleID > 0) {
                AbsEventManager.commitRoleEvent(roleID);
            }
        }
    }
}
