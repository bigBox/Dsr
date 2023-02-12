package com.dj.serverglobal;

import com.dj.domain.constant.ConstantServer;
import com.dj.servercore.ServerStart;
import com.dj.servercore.server.SocketServer;
import com.dj.servercore.server.base.AbsServer;
import com.dj.serverglobal.server.GlobalServer;

/**
 * @author zcq
 * @ClassName: GlobalStart
 * @Description: 全局服务器启动入口类
 * @date 2019年6月25日
 */
public class GlobalStart extends ServerStart {
    public GlobalStart(String[] args) {
        super(ConstantServer.defaultInnerServerConfig, args);
    }

    public static void main(String[] args) {
        GlobalStart ps = new GlobalStart(args);
        ps.start();
    }

    @Override
    protected AbsServer getServer(String[] args) {
        SocketServer server = null;
        if (args == null || args.length == 0) {
            server = GlobalServer.getInstance();
        } else if (args.length >= 1) {
            server = GlobalServer.getInstance(args[0]);
        }
        return server;
    }
}
