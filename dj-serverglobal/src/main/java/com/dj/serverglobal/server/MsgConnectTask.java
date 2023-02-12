package com.dj.serverglobal.server;

import com.dj.servercore.action.GlobalActionHandler;
import com.dj.servercore.task.AbstractConnectTask;
import com.dj.servercore.task.msg.MsgDispatcher;
import com.dj.serverglobal.manager.ActionManager;
import com.dj.serverglobal.manager.ChannelManager;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MsgConnectTask extends AbstractConnectTask {

    private final static GlobalActionHandler action = new GlobalActionHandler(ActionManager.getInstance(), ChannelManager.getInstance());

    static {
        msgDispatcher = new MsgDispatcher(action);
    }

    @Override
    public void resetProperties() {

    }
}
