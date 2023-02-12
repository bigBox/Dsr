package com.dj.serverplayer;

import com.dj.domain.constant.ConstantServer;
import com.dj.servercore.ServerStart;
import com.dj.servercore.server.SocketServer;
import com.dj.servercore.server.base.AbsServer;
import com.dj.serverplayer.server.PlayerServer;

/**
 * @author zcq
 * @ClassName: PlayerStart
 * @Description: 玩家服务器启动入口类
 * @date 2019年6月25日
 */
public class PlayerStart extends ServerStart {
    public PlayerStart(String[] args) {
        super(ConstantServer.defaultInnerServerConfig, args);
    }

    public static void main(String[] args) {
        PlayerStart ps = new PlayerStart(args);
        ps.start();
    }

    @Override
    protected AbsServer getServer(String[] args) {
        SocketServer server;
        if (args == null || args.length == 0) {
            server = PlayerServer.getInstance();
        } else {
            server = PlayerServer.getInstance(args[0]);
        }
        return server;
    }
}
