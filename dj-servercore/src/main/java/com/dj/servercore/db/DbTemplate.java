package com.dj.servercore.db;

import com.dj.domain.enums.MySqlRule;
import com.ibatis.sqlmap.client.SqlMapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DbTemplate {

    private static DbTemplate INSTANCE;

    public DbTemplate() {
        INSTANCE = this;
    }

    public static final DbTemplate getInstance() {
        return INSTANCE;
    }

    private static String globalCls = "GlobalGuild,GlobalGuildMember,GlobalTradeHistory,GlobalTradeHistoryImport,GlobalTradeOrder,GlobalTradeRecord,GlobalTradeStock";

    private static String robotCls = "RobotItem,RobotItem1,RobotItem2,RobotItem3,RobotItem4,RobotItem5,RobotItem6,RobotItem7,RobotItem100,RobotFactory,RobotFarm,RobotObstacle,RobotRole,RobotShowTable,RobotShowTableInfo,RobotShowTableMoney,RobotVerify,RobotVerifyHistory";

    public static SqlMapClient getSqlmapClient(String cls) {
        if (globalCls.contains(cls)) {
            return sqlMapClientMap.get(MySqlRule.Global);
        }
        if (robotCls.contains(cls)) {
            return sqlMapClientMap.get(MySqlRule.Robot);
        }
        return sqlMapClientMap.get(MySqlRule.Player);
    }

    private static Map<MySqlRule, SqlMapClient> sqlMapClientMap = new HashMap<>(3);

    @Autowired
    private SqlMapClient playerSqlMapClient;
    @Autowired
    private SqlMapClient globalSqlMapClient;
    @Autowired
    private SqlMapClient robotSqlMapClient;

    public void initSqlMapClient() {
        sqlMapClientMap.put(MySqlRule.Player, playerSqlMapClient);
        sqlMapClientMap.put(MySqlRule.Global, globalSqlMapClient);
        sqlMapClientMap.put(MySqlRule.Robot, robotSqlMapClient);
    }
}
