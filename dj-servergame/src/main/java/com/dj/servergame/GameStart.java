package com.dj.servergame;

import com.dj.domain.constant.ConstantServer;
import com.dj.servercore.ServerStart;
import com.dj.servercore.server.SocketServer;
import com.dj.servercore.server.base.AbsServer;
import com.dj.servergame.server.GameServer;

/**
 * @author zcq
 * @ClassName: GameStart
 * @Description: 游戏服务器启动入口类， 多人玩法的战斗服
 * @date 2019年6月25日
 */
public class GameStart extends ServerStart {
    public GameStart(String[] args) {
        super(ConstantServer.defaultInnerServerConfig, args);
    }

    public static void main(String[] args) {
        GameStart ps = new GameStart(args);
        ps.start();
    }

    @Override
    protected AbsServer getServer(String[] args) {
        SocketServer server = null;
        if (args == null || args.length == 0) {
            server = GameServer.getInstance();
        } else if (args.length >= 1) {
            server = GameServer.getInstance(args[0]);
        }
        return server;
    }
}
