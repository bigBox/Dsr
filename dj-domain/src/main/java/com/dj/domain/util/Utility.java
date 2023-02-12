package com.dj.domain.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dj.domain.util.math.RandomUtil;
import org.apache.commons.lang3.ArrayUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Utility {

    public static String convert(String utfString) {
        StringBuilder sb = new StringBuilder();
        int i;
        int pos = 0;
        while ((i = utfString.indexOf("\\u", pos)) != -1) {
            sb.append(utfString, pos, i);
            if (i + 5 < utfString.length()) {
                pos = i + 6;
                sb.append((char) Integer.parseInt(utfString.substring(i + 2, i + 6), 16));
            }
        }
        return sb.toString();
    }

    public static int binarySearch(int[] srcArray, int key) {
        return binarySearch(srcArray, 0, srcArray.length - 1, key);
    }

    public static int binarySearch(int[] srcArray, int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        if (srcArray[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return binarySearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binarySearch(srcArray, start, mid - 1, key);
        }
        return -1;
    }

    public static int binarySearch(long[] srcArray, long key) {
        return binarySearch(srcArray, 0, srcArray.length - 1, key);
    }

    public static int binarySearch(long[] srcArray, int start, int end, long key) {
        int mid = (end - start) / 2 + start;
        if (srcArray[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return binarySearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binarySearch(srcArray, start, mid - 1, key);
        }
        return -1;
    }

    public static boolean isInt(Type type) {
        return type == int.class || type == Integer.class;
    }

    public static boolean isString(Type type) {
        return type == String.class;
    }

    public static boolean isLong(Type type) {
        return type == long.class || type == Long.class;
    }

    public static String exeBash(String[] bashs) {
        String[] s = ArrayUtils.EMPTY_STRING_ARRAY;
        s = ArrayUtils.add(s, "bash");
        // s = (String[]) ArrayUtils.add(s, "-c");
        String[] retBashs = ArrayUtils.addAll(s, bashs);
        try {
            Process pro = Runtime.getRuntime().exec(retBashs);
            BufferedReader read = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            StringBuilder result = new StringBuilder();
            String line;
            log.info("exec bash: {}", Arrays.toString(bashs));
            while ((line = read.readLine()) != null) {
                result.append(line);
                result.append("\n");
                log.info("{}", line);
            }
            // 读取标准错误流
            BufferedReader brError = new BufferedReader(new InputStreamReader(pro.getErrorStream()));
            String errline;
            while ((errline = brError.readLine()) != null) {
                log.error("{}", errline);
            }
            int code = pro.waitFor();
            log.info("exec bash={},result={},output={}", retBashs, code, result.toString());
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("exec bash={},error={}", retBashs, e.getMessage());
        }
        return "0";
    }

    public static void exeBashCommand(String[] commands) {
        try {
            Process pro = Runtime.getRuntime().exec(commands);
            pro.waitFor();
            log.info("exec bash={}", GsonUtil.toJson(commands));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("exec bash={},error={}", Arrays.toString(commands), e.getMessage());
        }
    }

    public static String exeCmd(String[] cmds) {
        InputStream in;
        try {
            Process pro = Runtime.getRuntime().exec(cmds);
            pro.waitFor();
            in = pro.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(in));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = read.readLine()) != null) {
                result.append(line);
            }
            log.info("exec cmds={},result={}", cmds, result);
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("exec cmds={},error={}", cmds, e.getMessage());
        }
        return "0";
    }

    /***
     * true:already in using false:not using
     *
     * @param port
     */
    public static boolean isLocalPortUsing(int port) {
        boolean flag = true;
        try {
            flag = isPortUsing("127.0.0.1", port);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return flag;
    }

    /***
     * true:already in using false:not using
     *
     * @param host
     * @param port
     * @throws UnknownHostException
     */
    public static boolean isPortUsing(String host, int port) throws UnknownHostException {
        boolean flag = false;
        InetAddress theAddress = InetAddress.getByName(host);
        try (Socket socket = new Socket(theAddress, port)) {
            flag = true;
        } catch (IOException e) {
            log.error("host={},post={} is not using!", host, port);
        }
        return flag;
    }

    public static String getStr4SQLINParam(Object[] objects) {
        List<Object> valueList = Arrays.asList(objects);
        return valueList.toString().replace("[", "(").replace("]", ")");
    }

    /**
     * Trace保留的行数
     **/
    private static final int TRACE_NUM = 32;

    public static String getTraceString(Throwable e) {
        if (e == null)
            return "NULL";
        StackTraceElement[] stackTrace = e.getStackTrace();
        StringBuffer sb = new StringBuffer(512);
        String msg = e.getMessage();
        msg = msg == null ? "NULL" : msg;
        sb.append("##Message:" + msg + "##\n");
        sb.append("##Exception:" + e.toString() + "##\n");
        int i = 1;
        for (StackTraceElement stack : stackTrace) {
            if (i++ > TRACE_NUM)
                break;
            sb.append(stack.toString() + "\n");
        }
        return sb.toString();
    }

//    static class ConditionTest {
//
//        public static void main(String[] args) {
//            Lock lock = new ReentrantLock();
//            Condition condition = lock.newCondition();
//            new Thread(() -> {
//                lock.lock();
//                try {
//                    System.out.println(new Date() + "\tThread 1 is waiting");
//                    try {
//                        long waitTime = condition.awaitNanos(TimeUnit.SECONDS.toNanos(2));
//                        System.out.println(new Date() + "\tThread 1 remaining time " + waitTime);
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//                    System.out.println(new Date() + "\tThread 1 is waken up");
//                } finally {
//                    lock.unlock();
//                }
//            }).start();
//
//            new Thread(() -> {
//                lock.lock();
//                try {
//                    System.out.println(new Date() + "\tThread 2 is running");
//                    try {
//                        Thread.sleep(4000);
//                    } catch (Exception ex) {
//                        ex.printStackTrace();
//                    }
//                    condition.signal();
//                    System.out.println(new Date() + "\tThread 2 ended");
//                } finally {
//                    lock.unlock();
//                }
//            }).start();
//        }
//    }

    // public static String getProtocolBufferString(GeneratedMessage msg) {
    // return msg != null ? replaceBlank(msg.toString()) : "";
    // }

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * MD5 加密-大写
     */
    public static String getMD5Up(String s) {
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char[] str = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * MD5 加密-小写
     */
    public static String getMD5Low(String str) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("NoSuchAlgorithmException caught!");
            System.exit(-1);
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer(32);
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString();
    }

    public static String getMD5Low(byte[] bytes) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bytes);
        } catch (NoSuchAlgorithmException e) {
            log.error(getTraceString(e));
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer(32);
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            else
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
        }
        return md5StrBuff.toString();
    }

    public static String getVerificationCode(int count) {
        StringBuilder value = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            value.append(RandomUtil.nextInt(1, 9));
        }
        return value.toString();
    }
}
