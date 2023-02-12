package com.dj.servercore;

import org.apache.commons.configuration2.XMLConfiguration;

import com.dj.servercore.server.base.AbsServer;
import com.dj.servercore.server.config.InnerServerConfig;
import com.dj.domain.util.XmlUtil;

import lombok.Data;

/**
 * @author zcq
 * @ClassName: ServerStart
 * @Description: 服务器启动抽象类
 * @date 2019年6月25日
 */
@Data
public abstract class ServerStart {

    /**
     * @Fields server:服务器实例
     */
    private AbsServer server;

    public ServerStart(String defaultPath, String[] args) {
        // 初始化日志
        initLogPath(defaultPath, args);
        // 获取服务器实例
        server = getServer(args);
    }

    public void start() {
        try {
            Thread serverThread = new Thread(server);
            serverThread.setName("Server-" + AbsServer.getServerConfig().getName() + AbsServer.getServerConfig().getId());
            serverThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract AbsServer getServer(String[] args);

    private static void initLogPath(String basePath, String[] args) {
        String path = basePath;
        if (args != null && args.length > 0) {
            path = args[0];
        }
        XMLConfiguration config = XmlUtil.getXMLConfiguration(path);
        InnerServerConfig serverConfig = XmlUtil.getXMLConfigurationBean(config, InnerServerConfig.class);
        System.setProperty("logPath", serverConfig.getLogPath());
        System.setProperty("serverName", serverConfig.getName().toLowerCase());
        System.setProperty("serverId", String.valueOf(serverConfig.getId()));
        System.setProperty("logFilePath", serverConfig.getLogPath() + "/" + serverConfig.getName().toLowerCase() + serverConfig.getId());
        /**
         * | Standard Level | intLevel | | :------------ | :------------ | | OFF | 0 | |
         * FATAL | 100 | | ERROR | 200 | | WARN | 300 | | INFO | 400 | | DEBUG | 500 | |
         * TRACE | 600 | | ALL | Integer.MAX_VALUE |
         */
        System.setProperty("logLevel", serverConfig.isFormal() ? "499" : String.valueOf(Integer.MAX_VALUE));
    }
}
