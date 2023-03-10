package com.dj.servercore.db.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zcq
 * @description 具体数据库操作到ibatis statement的映射器
 * @date 2019年3月26日
 */
public class IbatisStatementMapper {

    public static final String INSERT_OP = "insert";

    public static final String UPDATE_OP = "update";

    public static final String DELETE_OP = "delete";

    public static final String SELECT_SINGLE_OP = "selectSingle";

    public static final String RECORDS_COUNT_OP = "selectRecordsCount";

    public static final String SELECT_MULTI_PAGING_OP = "selectMultiPaging";

    public static final String SELECT_ALL_OP = "selectAll";

    public static final String SELECT_MULTI_OP = "selectMulti";

    public static final String SELECT_SINGLE_PARAMS_OP = "selectSingleByParams";

    private static final Map<String, Map<String, String>> STATEMENT_MAP = new ConcurrentHashMap<String, Map<String, String>>();

    public static String createStatement(String prefix, String poClassName) {
        Map<String, String> entityMap = STATEMENT_MAP.get(poClassName);
        if (null == entityMap) {
            entityMap = new HashMap<>(2);
            STATEMENT_MAP.put(poClassName, entityMap);
        }
        String stagement = entityMap.get(prefix);
        if (null == stagement) {
            stagement = prefix + poClassName;
            entityMap.put(prefix, stagement);
        }
        return poClassName + "." + stagement;
    }
}
