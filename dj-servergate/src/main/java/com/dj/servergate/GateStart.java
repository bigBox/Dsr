package com.dj.servergate;

import com.dj.domain.constant.ConstantServer;
import com.dj.servercore.ServerStart;
import com.dj.servercore.server.SocketServerWS;
import com.dj.servercore.server.base.AbsServer;
import com.dj.servergate.server.GateServer;

/**
 * @author zcq
 * @ClassName: GateStart
 * @Description: 网关启动入口类
 * @date 2019年6月25日
 */
public class GateStart extends ServerStart {
    public GateStart(String[] args) {
        super(ConstantServer.defaultNettyServerConfig, args);
    }

    public static void main(String[] args) {
        GateStart gs = new GateStart(args);
        gs.start();
    }

    @Override
    protected AbsServer getServer(String[] args) {
        SocketServerWS server = null;
        if (args == null || args.length == 0) {
            server = GateServer.getInstance();
        } else if (args.length == 1) {
            server = GateServer.getInstance(args[0]);
        }
        return server;
    }
}
