package com.dj.servergame.server;

import com.dj.servercore.action.GameActionHandler;
import com.dj.servercore.task.AbstractConnectTask;
import com.dj.servercore.task.msg.MsgDispatcher;
import com.dj.servergame.manager.ActionManager;
import com.dj.servergame.manager.ChannelManager;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MsgConnectTask extends AbstractConnectTask {

    private final static GameActionHandler action = new GameActionHandler(ActionManager.getInstance(), ChannelManager.getInstance());

    static {
        msgDispatcher = new MsgDispatcher(action);
    }

    @Override
    public void resetProperties() {

    }
}
