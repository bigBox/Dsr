package com.dj.servercore.server.base;

import com.dj.servercore.server.config.ServerConfig;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zcq
 * @description 服务器初始化
 * @date 2019年3月14日
 */
@Data
public abstract class AbsServer implements Runnable {

    @Setter
    @Getter
    protected static ServerConfig serverConfig;
    @Setter
    @Getter
    private static long startTime = 0;
    @Getter
    @Setter
    private static long stopTime = 0;

    protected AbsServer() {
        init();
    }

    protected AbsServer(ServerConfig config) {
        serverConfig = config;
        if (serverConfig != null) {
            init();
        }
    }

    protected void init() {

    }
}
