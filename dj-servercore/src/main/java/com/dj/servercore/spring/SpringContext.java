package com.dj.servercore.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zcq
 * @ClassName: SpringContext
 * @Description: spring 上下文
 * @date 2019年6月25日
 */
public class SpringContext {

    public static ApplicationContext applicationContext;

    public static void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }
}
