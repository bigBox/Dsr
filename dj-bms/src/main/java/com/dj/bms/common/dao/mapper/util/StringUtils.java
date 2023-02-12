package com.dj.bms.common.dao.mapper.util;

/**
 * @Author: zcq
 * @Date: 2019/10/16 22:35
 */
public class StringUtils {

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }
}
