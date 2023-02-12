package com.dj.servergate.server;

import com.dj.servercore.action.GateActionHandler;
import com.dj.servercore.task.AbstractClientTask;
import com.dj.servercore.task.msg.MsgDispatcher;
import com.dj.servergate.manager.ActionManager;
import com.dj.servergate.manager.ChannelManager;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MsgClientTask extends AbstractClientTask {

    private final static GateActionHandler action = new GateActionHandler(ActionManager.getInstance(), ChannelManager.getInstance());

    static {
        channelManager = ChannelManager.getInstance();
        msgDispatcher = new MsgDispatcher(action);
    }

    @Override
    public void resetProperties() {

    }
}
