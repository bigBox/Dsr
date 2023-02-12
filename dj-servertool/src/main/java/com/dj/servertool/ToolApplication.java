package com.dj.servertool;

//import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.dj.servercore.server.SocketServer;
import com.dj.servercore.server.config.InnerServerConfig;
import com.dj.servercore.server.config.LocalConfig;
import com.dj.servertool.core.manager.ConfManager;
import com.dj.servertool.core.server.NettyHandler;
import com.dj.servertool.core.server.NettySocket;
import com.dj.servertool.core.server.ServerProperties;

import cn.stylefeng.roses.core.config.MybatisDataSourceAutoConfiguration;
import cn.stylefeng.roses.core.config.WebAutoConfiguration;
import cn.stylefeng.roses.core.util.SpringContextHolder;

/**
 * @author zcq
 * @ClassName: ToolApplication
 * @Description: 工具启动入口类 ， 以springboot框架基础启动
 * @date 2019年6月25日
 */
@SpringBootApplication(exclude = {WebAutoConfiguration.class, MybatisDataSourceAutoConfiguration.class})
@ComponentScan("com.dj.servertool.module.mapper")
@EnableScheduling
//@Slf4j
public class ToolApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolApplication.class, args);
        try {
            // 服务器配置
            ServerProperties serverProperties = SpringContextHolder.getBean(ServerProperties.class);
            // 加载远程配置
            InnerServerConfig serverConfig = new InnerServerConfig();
            serverConfig.setServerCdnUrl(serverProperties.getCdnUrl());
            SocketServer.setServerConfig(serverConfig);
            ConfManager.getInstance().load(LocalConfig.isUseRemoteJson());
            // 连接socket
            String wsUrl = String.format("ws://%s:%d", serverProperties.getGateIP(), serverProperties.getGatePort());
            //log.info(wsUrl);
            NettyHandler.initClient(new NettySocket(wsUrl));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
