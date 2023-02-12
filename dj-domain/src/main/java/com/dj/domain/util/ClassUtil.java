package com.dj.domain.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;

/**
 * <p>类操作工具</p>
 *
 * @author zcq
 * 2019年3月14日
 */
public class ClassUtil {
    /**
     * @param target
     * @return List<String>
     * @Description 得到指定类路径下的所有类全路径
     */
    public static List<String> getAllClassInPackage(Class<?> target) {
        String classpathst = target.getResource("").getPath().replaceAll("%20", " ");
        List<String> ret = new LinkedList<String>();
        if (classpathst.startsWith("file:/")) {
            classpathst = classpathst.substring(classpathst.indexOf("file:/") + "file:/".length());
        }
        if (classpathst.indexOf(".jar") != -1) {
            classpathst = classpathst.substring(0, classpathst.indexOf(".jar") + ".jar".length());
        }
        File classPath = new File(classpathst);
        if (!classPath.exists())
            return ret;
        try {
            if (classPath.isDirectory()) {
                File[] files = classPath.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            String name = file.getName();
                            if (name.indexOf(".class") == -1 && name.indexOf(".java") == -1) {
                                continue;
                            }
                            if (name.indexOf(".class") != -1) {
                                name = name.substring(0, name.indexOf(".class"));
                            }
                            if (name.indexOf(".java") != -1) {
                                name = name.substring(0, name.indexOf(".java"));
                            }
                            // 内部类跳过
                            if (name.indexOf("$") == -1) {
                                ret.add(name);
                            }
                        }
                    }
                }
            } else {
                FileInputStream fis = new FileInputStream(classPath);
                JarInputStream jis = new JarInputStream(fis, false);
                JarEntry e;
                while ((e = jis.getNextJarEntry()) != null) {
                    String name = e.getName();
                    if (name.indexOf(".class") == -1 && name.indexOf(".java") == -1) {
                        continue;
                    }
                    if (name.indexOf(".class") != -1) {
                        name = name.substring(name.lastIndexOf('/') + 1, name.indexOf(".class"));
                        if (name.indexOf(".java") != -1) {
                            name = name.substring(0, name.indexOf(".java"));
                        }
                        // 内部类跳过
                        if (name.indexOf("$") == -1) {
                            ret.add(name);
                        }
                    }
                    jis.closeEntry();
                }
                jis.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    /**
     * @param target
     * @return List<String>
     * @Description 得到1级子包名
     */
    public static List<String> getDirectSubPackage(Class<?> target) {
        String classpathst = target.getResource("").getPath().replaceAll("%20", " ");
        List<String> ret = new LinkedList<String>();
        if (classpathst.startsWith("file:/")) {
            classpathst = classpathst.substring(classpathst.indexOf("file:/") + "file:/".length());
        }
        if (classpathst.indexOf(".jar") != -1) {
            classpathst = classpathst.substring(0, classpathst.indexOf(".jar") + ".jar".length());
        }
        File classPath = new File(classpathst);
        if (!classPath.exists())
            return ret;
        try {
            if (classPath.isDirectory()) {
                File[] files = classPath.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isDirectory()) {
                            ret.add(file.getName());
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ret;
    }

    /**
     * @param packageName         包名
     * @param isIncludeSubPackage 获取到的类名是否带包路径
     * @return List<String>
     * @Description 从包package中获取所有的Class的类名
     */
    public static List<String> getAllClassesNameByPackageName(String packageName, boolean isIncludeSubPackage) {
        if (packageName == null)
            return null;
        List<String> result = new LinkedList<String>();
        Set<Class<?>> pp = ClassUtil.getAllClassInPackageIncludeSub(packageName);
        for (Class<?> c : pp) {
            // 是否带包名
            if (isIncludeSubPackage) {
                if (c.getCanonicalName() != null) {
                    result.add(c.getCanonicalName());
                }
            } else {
                if (c.getSimpleName() != null) {
                    result.add(c.getSimpleName());
                }
            }
        }
        return result;
    }

    /**
     * @param pack 包package
     * @return Set<Class < ?>>
     * @Description 从包package中获取所有的Class
     */
    private static Set<Class<?>> getAllClassInPackageIncludeSub(String pack) {
        // 第一个class类的集合
        Set<Class<?>> classes = new LinkedHashSet<Class<?>>();
        // 是否循环迭代
        boolean recursive = true;
        // 获取包的名字 并进行替换
        String packageName = pack;
        String packageDirName = packageName.replace('.', '/');
        // 定义一个枚举的集合 并进行循环来处理这个目录下的things
        Enumeration<URL> dirs;
        try {
            dirs = Thread.currentThread().getContextClassLoader().getResources(packageDirName);
            // 循环迭代下去
            while (dirs.hasMoreElements()) {
                // 获取下一个元素
                URL url = dirs.nextElement();
                // 得到协议的名称
                String protocol = url.getProtocol();
                // 如果是以文件的形式保存在服务器上
                if ("file".equals(protocol)) {
                    // 获取包的物理路径
                    String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                    // 以文件的方式扫描整个包下的文件 并添加到集合中
                    findAndAddClassesInPackageByFile(packageName, filePath, recursive, classes);
                } else if ("jar".equals(protocol)) {
                    // 如果是jar包文件
                    // 定义一个JarFile
                    // logger.info("jar类型的扫描");
                    JarFile jar;
                    try {
                        // 获取jar
                        jar = ((JarURLConnection) url.openConnection()).getJarFile();
                        // 从此jar包 得到一个枚举类
                        Enumeration<JarEntry> entries = jar.entries();
                        // 同样的进行循环迭代
                        while (entries.hasMoreElements()) {
                            // 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
                            JarEntry entry = entries.nextElement();
                            String name = entry.getName();
                            // 如果是以/开头的
                            if (name.charAt(0) == '/') {
                                // 获取后面的字符串
                                name = name.substring(1);
                            }
                            // 如果前半部分和定义的包名相同
                            if (name.startsWith(packageDirName)) {
                                int idx = name.lastIndexOf('/');
                                // 如果以"/"结尾 是一个包
                                if (idx != -1) {
                                    // 获取包名 把"/"替换成"."
                                    packageName = name.substring(0, idx).replace('/', '.');
                                }
                                // 如果可以迭代下去 并且是一个包
                                if ((idx != -1) || recursive) {
                                    // 如果是一个.class文件 而且不是目录
                                    if (name.endsWith(".class") && !entry.isDirectory()) {
                                        // 去掉后面的".class" 获取真正的类名
                                        String className = name.substring(packageName.length() + 1, name.length() - 6);
                                        try {
                                            // 添加到classes
                                            classes.add(Class.forName(packageName + '.' + className));
                                        } catch (ClassNotFoundException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        // log.error("在扫描用户定义视图时从jar包获取文件出错");
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classes;
    }

    /**
     * @param packageName
     * @param packagePath
     * @param recursive
     * @param classes
     * @return void
     * @Description 以文件的形式来获取包下的所有Class
     */
    private static void findAndAddClassesInPackageByFile(String packageName, String packagePath, final boolean recursive, Set<Class<?>> classes) {
        // 获取此包的目录 建立一个File
        File dir = new File(packagePath);
        // 如果不存在或者 也不是目录就直接返回
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }
        // 如果存在 就获取包下的所有文件 包括目录
        // 自定义过滤规则 如果可以循环(包含子目录) 或则是以.class结尾的文件(编译好的java类文件)
        File[] dirfiles = dir.listFiles(file -> (recursive && file.isDirectory()) || (file.getName().endsWith(".class")));
        // 循环所有文件
        if (dirfiles != null) {
            for (File file : dirfiles) {
                // 如果是目录 则继续扫描
                if (file.isDirectory()) {
                    findAndAddClassesInPackageByFile(packageName + "." + file.getName(), file.getAbsolutePath(), recursive, classes);
                } else {
                    // 如果是java类文件 去掉后面的.class 只留下类名
                    String className = file.getName().substring(0, file.getName().length() - 6);
                    try {
                        // 添加到集合中去
                        classes.add(Class.forName(packageName + '.' + className));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * @param clz
     * @return String
     * @Description 获取类的绝对路径
     */
    @SuppressWarnings("rawtypes")
    public static String getAbsolutePath(Class clz) {
        try {
            Path path = Paths.get(clz.getProtectionDomain().getCodeSource().getLocation().toURI());
            if (path != null) {
                if (path.getFileName() != null) {
                    if (path.getFileName().toString().endsWith(".jar")) {
                        // 截取路径中的jar包名
                        path = path.getRoot().resolve(path.subpath(0, path.getNameCount() - 1));
                    }
                }
                // logger.info("path={}", path);
                if (Files.exists(path)) {
                    return path.toAbsolutePath().toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param fieldName 字段名
     * @param o         对象
     * @return Object
     * @Description 根据字段名获取对象中字段的具体信息
     */
    public static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String firstLetter = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + firstLetter + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter);
            Object value = method.invoke(o);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 利用反射获取某个属性的值
     *
     * @param name
     * @param object
     * @return
     */
    public static Object getFieldValue2(String name, Object object) {
        try {
            Field field = object.getClass().getDeclaredField(name);
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setFieldValueByName(String fieldName, Object target, Object fieldValue) {
        try {
            Map<String, java.lang.reflect.Field> fieldMap = ClassUtil.findInstanceFields(target.getClass());
            if (fieldMap.containsKey(fieldName)) {
                java.lang.reflect.Field field = fieldMap.get(fieldName);
                field.setAccessible(true);
                field.set(target, fieldValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param typeClass
     * @return Map<String, java.lang.reflect.Field>
     * @Description 查找类的字段
     */
    public static Map<String, java.lang.reflect.Field> findInstanceFields(Class<?> typeClass) {
        LinkedHashMap<String, java.lang.reflect.Field> fieldMap = new LinkedHashMap<String, java.lang.reflect.Field>();
        fillFieldsMap(fieldMap, typeClass);
        return fieldMap;
    }

    /**
     * @param fieldMap
     * @param typeClass
     * @return void
     * @Description 填充类的字段进map, 其中static以及transient字段需排除
     */
    private static void fillFieldsMap(Map<String, java.lang.reflect.Field> fieldMap, Class<?> typeClass) {
        if (Object.class != typeClass.getSuperclass())
            fillFieldsMap(fieldMap, typeClass.getSuperclass());
        for (java.lang.reflect.Field f : typeClass.getDeclaredFields()) {
            int mod = f.getModifiers();
            if (!Modifier.isStatic(mod) && !Modifier.isTransient(mod))
                fieldMap.put(f.getName(), f);
        }
    }

    /**
     * 利用反射，扫描出此类所有属性(包含父类中子类没有重写的属性)
     *
     * @param klass       指定类.
     * @param annotations 标识属性的注解
     * @return 返回此类所有属性.
     */
    public static Field[] scanAllField(final Class<?> klass, List<Class<?>> annotations) {
        // 为了返回是有序的添加过程，这里使用LinkedHashMap
        Map<String, Field> fieldMap = new LinkedHashMap<String, Field>();
        scanField(klass, fieldMap, annotations);
        return fieldMap.values().toArray(new Field[fieldMap.size()]);
    }

    /**
     * 递归的方式拉取属性，这样父类的属性就在上面了...
     *
     * @param klass       类
     * @param fieldMap    所有属性集合
     * @param annotations 标识属性的注解
     */
    private static void scanField(final Class<?> klass, Map<String, Field> fieldMap, List<Class<?>> annotations) {
        Class<?> superClass = klass.getSuperclass();
        if (!Object.class.equals(superClass)) {
            scanField(superClass, fieldMap, annotations);
        }
        // 属性判定
        for (Field f : klass.getDeclaredFields()) {
            // Static和Final的不要
            if (Modifier.isStatic(f.getModifiers()) || Modifier.isFinal(f.getModifiers())) {
                continue;
            }
            // 子类已重写或内部类中的不要
            if (fieldMap.containsKey(f.getName()) || f.getName().startsWith("this$")) {
                continue;
            }
            // 没有指定的注解不要
            for (Annotation a : f.getAnnotations()) {
                if (annotations.contains(a.annotationType())) {
                    fieldMap.put(f.getName(), f);
                    break;
                }
            }
        }
    }
}