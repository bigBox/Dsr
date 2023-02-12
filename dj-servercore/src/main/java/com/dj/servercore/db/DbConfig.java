package com.dj.servercore.db;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DbConfig {
    private String url;
    private String user;
    private String password;
    private String driverClass;
    private int initialPoolSize;
    private int minPoolSize;
    private int maxPoolSize;
    private int acquireIncrement;
    private int maxIdleTime;
    private int maxStatements;
    private int maxStatementsPerConnection;
    private String preferredTestQuery;

    public boolean isEmpty() {
        return url == null || user == null;
    }

    public DbConfig(String url, String user, String password, String driverClass, int initialPoolSize, int minPoolSize, int maxPoolSize) {
        super();
        this.url = url;
        this.user = user;
        this.password = password;
        this.driverClass = driverClass;
        this.initialPoolSize = initialPoolSize;
        this.minPoolSize = minPoolSize;
        this.maxPoolSize = maxPoolSize;
    }
}
