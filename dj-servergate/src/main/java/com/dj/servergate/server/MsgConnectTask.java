package com.dj.servergate.server;

import com.dj.servercore.action.GateActionHandler;
import com.dj.servercore.task.AbstractConnectTask;
import com.dj.servercore.task.msg.MsgDispatcher;
import com.dj.servergate.manager.ActionManager;
import com.dj.servergate.manager.ChannelManager;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MsgConnectTask extends AbstractConnectTask {

    private final static GateActionHandler action = new GateActionHandler(ActionManager.getInstance(), ChannelManager.getInstance());

    static {
        msgDispatcher = new MsgDispatcher(action);
    }

    @Override
    public void resetProperties() {

    }
}
