package com.dj.serverplayer.server;

import com.dj.servercore.action.PlayerActionHandler;
import com.dj.servercore.task.AbstractConnectTask;
import com.dj.servercore.task.msg.MsgDispatcher;
import com.dj.serverplayer.manager.ActionManager;
import com.dj.serverplayer.manager.ChannelManager;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MsgConnectTask extends AbstractConnectTask {

    private final static PlayerActionHandler action = new PlayerActionHandler(ActionManager.getInstance(), ChannelManager.getInstance());

    static {
        msgDispatcher = new MsgDispatcher(action);
    }

    @Override
    public void resetProperties() {

    }
}
