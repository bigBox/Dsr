package com.dj.domain.util;

import com.google.common.collect.Lists;
import lombok.NonNull;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.io.FileHandler;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

@SuppressWarnings("deprecation")
public class XmlUtil {
    /**
     * @param file xml文件
     * @return XMLConfiguration
     * @Title getXMLConfiguration
     * @Description 获取一个commons.configuration2.XMLConfiguration实例, 并加载指定Xml文件
     */
    @NonNull
    public static XMLConfiguration getXMLConfiguration(String file) {
        XMLConfiguration config = new XMLConfiguration();
        FileHandler handler = new FileHandler(config);
        handler.setFileName(file);
        try {
            handler.load();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return config;
    }

    @NonNull
    public static XMLConfiguration getXMLConfiguration2(String url) {
        XMLConfiguration config = new XMLConfiguration();
        FileHandler handler = new FileHandler(config);
        try {
            handler.setURL(new URL(url));
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            handler.load();
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return config;
    }

    @NonNull
    public static XMLConfiguration getXMLConfiguration(InputStream in) {
        XMLConfiguration config = new XMLConfiguration();
        FileHandler handler = new FileHandler(config);
        try {
            handler.load(in);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return config;
    }

    /**
     * @param config XMLConfiguration
     * @param cls    Bean对应的类
     * @return T
     * @Title getXMLConfigurationBean
     * @Description 使用XMLConfiguration获取一个xml对应的Bean
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> T getXMLConfigurationBean(XMLConfiguration config, Class<T> cls) {
        T instance = null;
        try {
            instance = cls.newInstance();
            Map<String, java.lang.reflect.Field> fieldMap = ClassUtil.findInstanceFields(cls);
            for (Map.Entry<String, java.lang.reflect.Field> entry : fieldMap.entrySet()) {
                Field field = entry.getValue();
                if (field.getType().equals(List.class)) {
                    // 字段是列表类型
                    ClassUtil.setFieldValueByName(field.getName(), instance, getXMLConfigurationList(config, field.getName(), (Class) ((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0]));
                } else if (config.containsKey(field.getName())) {
                    // 字段是普通类型
                    ClassUtil.setFieldValueByName(field.getName(), instance, config.get(field.getType(), field.getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    /**
     * @param config
     * @param keyName
     * @param cls
     * @return List<T>
     * @Title getXMLConfigurationList
     * @Description 使用XMLConfiguration获取一个xml中列表对应的Bean List
     */
    @NonNull
    public static <T> List<T> getXMLConfigurationList(XMLConfiguration config, String keyName, Class<T> cls) {
        List<T> ret = Lists.newArrayList();
        List<Field> fieldList = Lists.newArrayList(ClassUtil.findInstanceFields(cls).values());
        StringBuilder sb = new StringBuilder();
        try {
            // 使用第一个字段去xml中获取到list的size
            int size = config.getList(String.class, sb.append(keyName).append(".").append(fieldList.get(0).getName()).toString()).size();
            for (int i = 0; i < size; i++) {
                sb.delete(0, sb.length());
                T instance = cls.newInstance();
                for (int j = 0; j < fieldList.size(); j++) {
                    sb.delete(0, sb.length());
                    // 赋值
                    String propertyName = sb.append(keyName).append("(").append(i).append(").").append(fieldList.get(j).getName()).toString();
                    if (config.containsKey(propertyName)) {
                        ClassUtil.setFieldValueByName(fieldList.get(j).getName(), instance, config.get(fieldList.get(j).getType(), propertyName));
                    }
                }
                ret.add(instance);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }
}
