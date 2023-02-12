package com.dj.servercore.conf.base;

/**
 * @author zcq
 * @description 配置提供者
 * @date 2019年4月12日
 */
public class ConfProvider {

    private static IConfProvider configConfProvider;

    private static void checkObjectNull(Object object) {
        if (object != null) {
            throw new RuntimeException("object cannot set twice .... ");
        }
    }

    public static void setConfigConfProvider(IConfProvider configConfProvider) {
        checkObjectNull(ConfProvider.configConfProvider);
        ConfProvider.configConfProvider = configConfProvider;
    }

    public static IConfProvider getConfigConfProvider() {
        return configConfProvider;
    }
}
