package com.dj.servercore.db.sqlMapClient;

import com.dj.servercore.db.DbConfig;
import com.dj.servercore.db.base.DBParam;
import com.dj.servercore.server.SocketServer;
import com.dj.servercore.server.config.InnerServerConfig;
import org.apache.commons.dbcp2.BasicDataSource;

public class MySqlMapClient extends SqlMapClientFactoryBean {

    public MySqlMapClient(DBParam dbParam, String dbKey) {
        InnerServerConfig serverConfig = SocketServer.getServerConfig();
        DbConfig dbConfig = serverConfig.getDbConfig(dbKey);
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbParam.driverClassName);
        dataSource.setUrl(dbConfig.getUrl());
        dataSource.setUsername(dbConfig.getUser());
        dataSource.setPassword(dbConfig.getPassword());
        dataSource.setInitialSize(dbParam.initialSize);
        dataSource.setMaxTotal(dbParam.maxActive);
        dataSource.setMinIdle(dbParam.minIdle);
        dataSource.setMaxWaitMillis(dbParam.maxWait);
        dataSource.setRemoveAbandonedOnBorrow(dbParam.removeAbandoned);
        dataSource.setRemoveAbandonedOnMaintenance(dbParam.removeAbandoned);
        dataSource.setRemoveAbandonedTimeout(dbParam.removeAbandonedTimeout);
        dataSource.setConnectionProperties(dbParam.connectionProperties);
        this.setConfigLocation(dbParam.configLocation);
        this.setDataSource(dataSource);
    }
}
