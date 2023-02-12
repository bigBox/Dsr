package com.dj.domain.util;

import com.google.protobuf.Message;
import com.googlecode.protobuf.format.JsonFormat;

import java.io.*;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    /**
     * wml不能正常显示的字符,|间隔
     */
    public static String WAP_BLACK_CHAR = ">|<";

    /**
     * 校验是否是英文字母和数字组成的字符串 <br>
     * a-zA-Z【英文字母】 <br>
     * 0-9【数字】 <br>
     * \u4E00-\u9FA5【中文】 <br>
     * \ufe30-\uffa0【全角字符，全角的中文标点符号如，】 <br>
     * <p>
     * 一个正则表达式，只含有汉字、数字、字母、下划线不能以下划线开头和结尾： <br>
     * ^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$ 其中： ^ 与字符串开始的地方匹配 (?!_) 不能以_开头
     * (?!.*?_$) 不能以_结尾 a-zA-Z0-9_\u4e00-\u9fa5]+ 至少一个汉字、数字、字母、下划线 $ 与字符串结束的地方匹配
     * <p>
     * \u4E00-\u9FA5
     */
    public static boolean isValidRecStr(String content) {
        Pattern p = Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9_]+$");
        Matcher m = p.matcher(content);
        return m.matches();
    }

    /**
     * 校验是否是英文字母、中文和数字组成的字符串 a-zA-Z【英文字母】 0-9【数字】 \u4E00-\u9FA5【中文】
     * \ufe30-\uffa0【全角字符，全角的中文标点符号如，】，本工程中不需要
     * <p>
     * 一个正则表达式，只含有汉字、数字、字母、下划线不能以下划线开头和结尾：
     * ^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4e00-\u9fa5]+$ 其中： ^ 与字符串开始的地方匹配 (?!_) 不能以_开头
     * (?!.*?_$) 不能以_结尾 a-zA-Z0-9_\u4e00-\u9fa5]+ 至少一个汉字、数字、字母、下划线 $ 与字符串结束的地方匹配
     * <p>
     * kpup3 ?kp?b3?k,g10ё ????v?U
     */
    public static boolean isValidRecInCnStr(String content) {
        Pattern p = Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4E00-\u9FA5]+$");
        Matcher m = p.matcher(content);
        return m.matches();
    }

    // 字符串对于wap显示是否可以安全显示中文,白名单
    public static boolean isWhiteChar4Wap(String content) {
        String fuhao = "\\?,.;:!@#$%^*\\(\\)\\[\\]_\\+\\-=？￥！，。；：‘’“”—·（）《》【】、| ~…╭∩╮（︶︿︶） ⊙﹏⊙◎╯╰↖ω↗﹂﹁﹃︻︼︵︷︿︹︽_ˉ~≧▽≦╯▽╰﹄~︾︺﹀︸︶〗﹃ ㄒ ﹌﹋﹏╬═☆";
        Pattern p = Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9_\u4E00-\u9FA5" + fuhao + "]+$");
        Matcher m = p.matcher(content);
        return m.matches();
    }

    // 字符串对于wap显示是否可以安全显示中文,黑名单
    public static boolean isBlackChar4Wap(String content, String pattern) {
        if (pattern == null || pattern.trim().length() == 0) {
            pattern = WAP_BLACK_CHAR;
        }
        Pattern p = Pattern.compile(pattern);
        return p.matcher(content).find();
    }

    /**
     * 校验是否是英文字母组成的字符串
     */
    public static boolean isEnglishString(String content) {
        Pattern p = Pattern.compile("^[a-zA-Z]+$");
        Matcher m = p.matcher(content);
        return m.matches();
    }

    /**
     * 校验是否是中文组成的字符串
     */
    public static boolean isChineseStr(String content) {
        Pattern p = Pattern.compile("[\u4E00-\u9FA5]+$");
        Matcher m = p.matcher(content);
        return m.matches();
    }

    /**
     * 校验是否含有中文
     */
    public static boolean isIncludeChinese(String content) {
        Pattern p = Pattern.compile("[\u4E00-\u9FA5]");
        Matcher m = p.matcher(content);
        return m.find();
    }

    /**
     * 校验是否是中文和英文组成的字符串
     */
    public static boolean isChineseEnglishStr(String content) {
        Pattern p = Pattern.compile("[\u4E00-\u9FA5a-zA-Z]+$");
        Matcher m = p.matcher(content);
        return m.matches();
    }

    /**
     * 校验是否是中文英文和数字组成的字符串
     */
    public static boolean isChineseEnglishNumberStr(String content) {
        Pattern p = Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9\u4e00-\u9fa5]+$");
        Matcher m = p.matcher(content);
        return m.matches();
    }

    /**
     * 校验是否是英文和数字组成的字符串
     */
    public static boolean isEnglishNumberStr(String content) {
        Pattern p = Pattern.compile("^(?!_)(?!.*?_$)[a-zA-Z0-9]+$");
        Matcher m = p.matcher(content);
        return m.matches();
    }

    /**
     * 计算字符串长度， 1个单字当为中文时为：2字符，当为英文时为1字符
     *
     * @param content
     * @return
     */
    public static int countLen(String content) {
        int length = 0;
        char[] ch = content.toCharArray();
        for (char c : ch) {
            if (isChinese(c)) {
                length += 2;
            } else {
                length++;
            }
        }
        return length;
    }

    /**
     * 是否是中文字符<br>
     * GENERAL_PUNCTUATION 判断中文的“号<br>
     * CJK_SYMBOLS_AND_PUNCTUATION 判断中文的。号<br>
     * HALFWIDTH_AND_FULLWIDTH_FORMS 判断中文的，号<br>
     *
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    /**
     * 校验是否是合法的email
     */
    public static boolean isEmail(String email) {
        // "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
        // "^[\\w]+(\\.[\\w]+)*@[\\w]+(\\.[\\w]+)+$"
        Pattern p = Pattern.compile(
                "\\b(^['_A-Za-z0-9-]+(\\.['_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    // 除了html标签，其他内容去空格
    public static String delSpaceExcludeHtml(String info) {
        StringBuilder result = new StringBuilder(info);
        boolean del = true;// 是否可以删除
        for (int i = 0; i < result.length(); i++) {
            char c = result.charAt(i);
            if (c == '<') {
                del = false;
            } else if (c == '>') {
                del = true;
            }
            if (del) {
                // 标签外
                if (c == ' ' || c == '\t' || c == '\n' || c == '\r') {
                    result.deleteCharAt(i);
                    i--;
                    continue;
                }
            } else {
                // 标签内
                if (c == '\t' || c == '\n' || c == '\r') {
                    result.deleteCharAt(i);
                    result.insert(i, ' ');
                    c = ' ';
                }
                if (c == ' ') {
                    // 此处在标签内，有<>做边界，可不担心越界
                    if (result.charAt(i - 1) == ' ') {
                        result.deleteCharAt(i);
                        i--;
                        continue;
                    }
                }
            }
        }
        return result.toString().replaceAll(" />", "/>");
    }

    // replace(str,查找字符串,替换字符串)
    public static String replace(String str, String pattern, String replace) {
        if (replace == null) {
            replace = "";
        }
        int s = 0, e = 0;
        StringBuilder result = new StringBuilder(str.length() * 2);
        while ((e = str.indexOf(pattern, s)) >= 0) {
            result.append(str, s, e);
            result.append(replace);
            s = e + pattern.length();
        }
        result.append(str.substring(s));
        return result.toString();
    }

    /**
     * 校验是否是合法的数字
     */
    public static boolean isNumberStr(String content) {
        if (content == null)
            return false;
        Pattern p = Pattern.compile("^(-?\\d+)|((-?\\d+)(\\.\\d+))$");
        Matcher m = p.matcher(content);
        return m.matches();
    }

    /**
     * 字符串数组中是否包含指定的字符串
     */
    public static boolean isInvolve(String seed, String[] allContent) {
        if (allContent == null || seed == null) {
            return false;
        }
        for (String string : allContent) {
            if (string.trim().equals(seed)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 用于显示限定长度的字符串，返回的字符串类似：为什么花儿这样红...<br>
     * 一个中文算2个长度，两个英文算1个长度
     *
     * @param srcSt
     * @param length
     * @return
     */
    public static String showShortContent(String srcSt, int length) {
        if (srcSt == null) {
            return "";
        }
        String t = cutShortContent(srcSt, length);
        if (srcSt.length() != t.length()) {
            return t + "...";
        } else {
            return srcSt;
        }
    }

    public static String cutShortContent(String srcSt, int length) {
        if (srcSt == null) {
            return "";
        }
        // 假设全中文占2，还是不够length，直接返回
        if (srcSt.length() << 1 <= length) {
            return srcSt;
        }
        int _length = 0;
        int index = 0;
        char[] ch = srcSt.toCharArray();
        for (char c : ch) {
            if (isChinese(c)) {
                _length += 2;
            } else {
                _length++;
            }
            if (_length >= length) {
                if (_length == length) {
                    index++;
                }
                break;
            }
            index++;
        }
        if (index >= srcSt.length()) {
            return srcSt;
        } else {
            int dt = 0;
            // 需要决定让几位供省略号使用
            int site = 2;
            // 回退第一位
            if (isChinese(srcSt.charAt(index))) {
                dt += 2;
            } else {
                dt++;
            }
            // 回退第2位
            if (isChinese(srcSt.charAt(index - 1))) {
                dt += 2;
            } else {
                dt++;
            }
            if (dt < 3) {
                site = 3;
            }
            if ((index - site < 1)) {
                return "";
            } else {
                return String.valueOf(srcSt.subSequence(0, index - site));
            }
        }
    }

    /**
     * 每隔一定长度向字符串插入特定字符
     *
     * @param srcSt
     * @param length
     * @return
     */
    public static String insertSthToContent(String srcSt, int length, String seed) {
        // 假设全中文占2，还是不够length，直接返回
        if (srcSt.length() << 1 <= length) {
            return srcSt;
        }
        int index = 0;
        char[] ch = srcSt.toCharArray();
        StringBuilder result = new StringBuilder();
        boolean ignore = false;
        for (int i = 0; i < ch.length; i++) {
            // 不能破坏内容中的标签对
            if (ch[i] == '<' && !ignore) {
                ignore = true;
                continue;
            }
            if (ch[i] == '>' && ignore) {
                ignore = false;
                continue;
            }
            if (ignore) {
                continue;
            }
            if (isChinese(ch[i])) {
                index += 2;
            } else {
                index++;
            }
            result.append(ch[i]);
            if (index >= length && i < ch.length - 1) {
                result.append(seed);
                index = 0;
            }
        }
        return result.toString();
    }

    /**
     * 将字符串的部分内容替换为隐藏
     *
     * @param src   String
     * @param start int
     * @param end   int
     * @return String
     */
    public static String hidePart(String src, int start, int end, char replaceChar) {
        if (src == null || end <= start) {
            return src;
        }
        if (end > src.length()) {
            end = src.length();
        }
        if (start < 0) {
            start = 0;
        }
        char[] cs = src.toCharArray();
        for (int i = start; i < end; i++) {
            cs[i] = replaceChar;
        }
        return new String(cs);
    }

    /**
     * 左或右填充成指定长度的字符串
     *
     * @param value
     * @param bits   位数
     * @param seed   填充种子
     * @param direct true左填充 false右填充
     * @return
     */
    public static String fillStringByseed(String value, int bits, char seed, boolean direct) {
        if (value == null || value.length() >= bits) {
            return value;
        }
        char[] rs = new char[bits];
        int temp = bits - value.length();
        if (direct) {// true左填充
            System.arraycopy(value.toCharArray(), 0, rs, temp, value.length());
            for (int i = 0; i < temp; i++) {
                rs[i] = seed;
            }
        } else {// false右填充
            System.arraycopy(value.toCharArray(), 0, rs, 0, value.length());
            for (int i = value.length(); i < bits; i++) {
                rs[i] = seed;
            }
        }
        return new String(rs);
    }

    // 是否包含危险字符,是否有sql注入的潜在危险
    public static boolean contianIllegal(String parm) {
        parm = parm.toLowerCase();
        return parm.indexOf("'") != -1 || parm.indexOf("＇") != -1 || parm.indexOf(" where ") != -1
                || parm.indexOf("select ") != -1 || parm.indexOf("delete ") != -1 || parm.indexOf("insert ") != -1
                || parm.indexOf("update ") != -1;
    }

    /**
     * 字节码转换成16进制字符串
     *
     * @param b 输入要转换的字节码
     * @return String 返回转换后的16进制字符串
     */
    public static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = hs + ":";
        }
        return hs.toUpperCase();
    }

    public static String byte2String(byte[] b) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            stringBuffer.append(b[i]);
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            stringBuffer.setLength(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /**
     * string集合转为string数组
     *
     * @param list
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static String[] listToStringArray(List list) {
        if (list == null) {
            return null;
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = (String) list.get(i);
        }
        return result;
    }

    /**
     * 通过给定的字条截取字符串
     */
    public static String cutStringBychar(String content, String startFix, String endFix) {
        int startPos = content.indexOf(startFix);
        int endPos = content.indexOf(endFix);
        if (startPos != -1 && endPos != -1) {
            startPos = startPos + startFix.length();
            if (startPos < endPos) {
                content = content.substring(startPos, endPos);
                return content;
            }
        }
        return null;
    }

    /**
     * 将字符串的部分内容替换为隐藏
     *
     * @param src   String
     * @param start int
     * @param end   int
     * @return String
     */
    public static String hidePart(String src, int start, int end) {
        if (src == null || end <= start) {
            return src;
        }
        if (end > src.length()) {
            end = src.length();
        }
        if (start < 0) {
            start = 0;
        }
        StringBuilder result = new StringBuilder();
        result.append(src, 0, start);
        for (int i = 0; i < end - start; i++) {
            result.append("*");
        }
        result.append(src.substring(end));
        return result.toString();
    }

    /**
     * @Description 检测字符串是否为null,"",空格
     * @author Lucifer
     * @date 2012-3-9 下午5:45:25
     */
    public static boolean isBlank(String str) {
        return ((str == null) || (str.length() == 0) || (str.trim().equals("")));
    }

    public static boolean isEmpty(String str) {
        return ((str == null) || (str.isEmpty()));
    }

    public static boolean isNotEmpty(String str) {
        return (!(isEmpty(str)));
    }

    public static boolean isNotEmpty0Null(String str) {
        return (!(isEmpty(str))) && !("0".equals(str)) && !("null".equals(str));
    }

    // 网上copy http://blog.csdn.net/fjfdszj/archive/2009/07/03/4320190.aspx

    /**
     * 货币数值转换为中文大写
     */
    public static String money2Chstr(double value) {
        if (value <= 0) {
            return "";
        }
        char[] hunit = {'拾', '佰', '仟'};// 段内位置表示
        char[] vunit = {'万', '亿'}; // 段名表示
        char[] digit = {'零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'}; // 数字表示
        long midVal = (long) (value * 100); // 转化成整形
        String valStr = String.valueOf(midVal); // 转化成字符串
        String head = valStr.substring(0, valStr.length() - 2); // 取整数部分
        String rail = valStr.substring(valStr.length() - 2); // 取小数部分
        String prefix = ""; // 整数部分转化的结果
        String suffix = ""; // 小数部分转化的结果
        if (valStr.length() > 17) {
            return "数值过大！";// 解决问题1,超过千亿的问题。
        }
        // 处理小数点后面的数
        if (rail.equals("00")) { // 如果小数部分为0
            suffix = "整";
        } else {
            suffix = digit[rail.charAt(0) - '0'] + "角" + digit[rail.charAt(1) - '0'] + "分"; // 否则把角分转化出来
        }
        // 处理小数点前面的数
        char[] chDig = head.toCharArray(); // 把整数部分转化成字符数组
        char zero = '0'; // 标志'0'表示出现过0
        byte zeroSerNum = 0; // 连续出现0的次数
        for (int i = 0; i < chDig.length; i++) { // 循环处理每个数字
            int idx = (chDig.length - i - 1) % 4; // 取段内位置
            int vidx = (chDig.length - i - 1) / 4; // 取段位置
            if (chDig[i] == '0') { // 如果当前字符是0
                zeroSerNum++; // 连续0次数递增
                if (zero == '0' && idx != 0) { // 标志 ,连续零，仅读一次零，
                    zero = digit[0]; // 解决问题2,当一个零位于第0位时，不输出“零”，仅输出“段名”.
                } else if (idx == 0 && vidx > 0 && zeroSerNum < 4) {
                    prefix += vunit[vidx - 1];
                    zero = '0';
                }
                continue;
            }
            zeroSerNum = 0; // 连续0次数清零
            if (zero != '0') { // 如果标志不为0,则加上,例如万,亿什么的
                prefix += zero;
                zero = '0';
            }
            // 取到该位对应数组第几位。
            int position = chDig[i] - '0';
            if (position == 1 && i == 0 && idx == 1)// 解决问题3 ,即处理10读"拾",而不读"壹拾"
            {
            } else {
                prefix += digit[position]; // 转化该数字表示
            }
            if (idx > 0) // 段内位置表示的值
                prefix += hunit[idx - 1];
            if (idx == 0 && vidx > 0) { // 段名表示的值
                prefix += vunit[vidx - 1]; // 段结束位置应该加上段名如万,亿
            }
        }
        if (prefix.length() > 0)
            prefix += '圆'; // 如果整数部分存在,则有圆的字样
        return prefix + suffix; // 返回正确表示
    }

    public static List<String> stringArrayToList(String[] array) {
        if (array == null) {
            return null;
        }
        List<String> result = new LinkedList<String>();
        for (String string : array) {
            result.add(string);
        }
        return result;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void diffentList(List old, List bl) {
        if (bl == null || bl.size() < 1) {
            return;
        }
        List cl = new LinkedList();
        for (Object str : bl) {
            if (old.contains(str)) {
                cl.add(str);
            }
        }
        bl.removeAll(cl);
    }

    public static String convertStreamToString(InputStream is) throws Exception {
        return convertStreamToString(is, "utf-8");
    }

    /*
     * To convert the InputStream to String we use the BufferedReader.readLine()
     * method. We iterate until the BufferedReader return null which means there's
     * no more data to read. Each line will appended to a StringBuilder and returned
     * as String.
     */

    public static String convertStreamToString(InputStream is, String encoding) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, encoding));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                if (sb.length() < 1) {
                    sb.append(line);
                } else {
                    sb.append("\n" + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static InputStream string2InputStream(String str) {
        return new ByteArrayInputStream(str.getBytes());
    }

    public static int[] string2ASCII(String s) {// 字符串转换为ASCII码
        if (s == null || "".equals(s)) {
            return null;
        }
        char[] chars = s.toCharArray();
        int[] asciiArray = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            asciiArray[i] = char2ASCII(chars[i]);
        }
        return asciiArray;
    }

    public static int char2ASCII(char c) {
        return c;
    }

    public static String getIntArrayString(int[] intArray) {
        return getIntArrayString(intArray, ",");
    }

    public static String getIntArrayString(int[] intArray, String delimiter) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            sb.append(intArray[i]);
            sb.append(delimiter);
        }
        return sb.toString();
    }

    // 转化为单字节数组
    public static int[] str2SingleChar(String str) {
        int[] rt = null;
        try (ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes("gb2312"))) {
            List<Integer> list = new LinkedList<Integer>();
            int result = -1;
            while ((result = in.read()) != -1) {
                list.add(result);
            }
            rt = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                rt[i] = list.get(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rt;
    }

    // 单字节数组转string
    public static String singleChar2Str(int[] a) {
        String result = null;
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            for (Integer value : a) {
                out.write(value);
            }
            result = out.toString("gb2312");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String hexString = "0123456789ABCDEF";

    /*
     * 将字符串编码成16进制数字,适用于所有字符（包括中文）
     */
    public static String str2Hex(String str) {
        // 根据默认编码获取字节数组
        byte[] bytes = str.getBytes();
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        // 将字节数组中每个字节拆解成2位16进制整数
        for (int i = 0; i < bytes.length; i++) {
            sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
            sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
        }
        return sb.toString();
    }

    // 16进制数字转字符串
    public static String hex2Str(String hexStr) {
        if (null == hexStr || "".equals(hexStr) || (hexStr.length()) % 2 != 0) {
            return null;
        }
        int byteLength = hexStr.length() / 2;
        byte[] bytes = new byte[byteLength];
        int temp = 0;
        for (int i = 0; i < byteLength; i++) {
            temp = hex2Dec(hexStr.charAt(2 * i)) * 16 + hex2Dec(hexStr.charAt(2 * i + 1));
            bytes[i] = (byte) (temp < 128 ? temp : temp - 256);
        }
        return new String(bytes);
    }

    private static int hex2Dec(char ch) {
        if (ch == '0')
            return 0;
        if (ch == '1')
            return 1;
        if (ch == '2')
            return 2;
        if (ch == '3')
            return 3;
        if (ch == '4')
            return 4;
        if (ch == '5')
            return 5;
        if (ch == '6')
            return 6;
        if (ch == '7')
            return 7;
        if (ch == '8')
            return 8;
        if (ch == '9')
            return 9;
        if (ch == 'a')
            return 10;
        if (ch == 'A')
            return 10;
        if (ch == 'B')
            return 11;
        if (ch == 'b')
            return 11;
        if (ch == 'C')
            return 12;
        if (ch == 'c')
            return 12;
        if (ch == 'D')
            return 13;
        if (ch == 'd')
            return 13;
        if (ch == 'E')
            return 14;
        if (ch == 'e')
            return 14;
        if (ch == 'F')
            return 15;
        if (ch == 'f')
            return 15;
        else
            return -1;
    }

//    public static void main(String[] args) throws Exception {
//        String test = "{cproid}{cs025700003}{cpid}{875}{csmscenter}{+8613800220500}{cregcondition}{0}{cconsumebill}{0;|;0}{cnetworkid}{10}{cver}{1}{cimsi}{460022220428195}";
//        // string转换为单字节int数组
//        int[] rt = str2SingleChar(test);
//        // int数组拼成串
//        String result = getIntArrayString(rt);
//        System.out.println(result);
//        System.out.println(singleChar2Str(rt));
//        byte[] b = {8, -114, -33, -52, -16, -93, 35, 16, -114, -33, -52, -16, -93, 35, 24, -68, 9, 32, 10, 40, 3, 49,
//                -86, -91, -120, 0, 85, 1, 0, 0, 57, 10, -88, -120, 0, 85, 1, 0, 0};
//        String hex = byte2hexNoMH(b);
//        System.out.println(hex);
//        byte[] c = hexStringToBytes(hex);
//        System.out.println(Arrays.toString(c));
//        System.out.println(firstChar2upperCase("playerBus"));
//    }

    /**
     * 字符串的首字母大写
     *
     * @param str
     * @return
     */
    public static String firstChar2upperCase(String str) {
        byte[] chars = str.getBytes();
        chars[0] = (byte) ((char) chars[0] - 'a' + 'A');
        return new String(chars);
    }

    /**
     * 字符串的首字母小写
     *
     * @param str
     * @return
     */
    public static String firstChar2lowerCase(String str) {
        byte[] chars = str.getBytes();
        chars[0] = (byte) ((char) chars[0] - 'A' + 'a');
        return new String(chars);
    }

    private static byte charToByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    /**
     * @param hexString 0100
     * @return
     * @Description:16进制字符串转二进制流
     * @author Lucifer
     * @date 2012-11-20 下午01:56:46
     */
    public static byte[] hexStringToBytes(String hexString) {
        if (hexString == null || hexString.equals("")) {
            return null;
        }
        hexString = hexString.toUpperCase();
        int length = hexString.length() / 2;
        char[] hexChars = hexString.toCharArray();
        byte[] d = new byte[length];
        for (int i = 0; i < length; i++) {
            int pos = i * 2;
            d[i] = (byte) (charToByte(hexChars[pos]) << 4 | charToByte(hexChars[pos + 1]) & 0xff);
        }
        return d;
    }

    /**
     * @Description:二进制流转换字符串
     * @author Lucifer
     * @date 2012-11-20 下午01:58:22
     */
    public static String byte2hexNoMH(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs = hs + "0" + stmp;
            else
                hs = hs + stmp;
            if (n < b.length - 1)
                hs = hs + "";
        }
        return hs.toUpperCase();
    }

    /**
     * 截取字符串 null则返回空串
     */
    public static final String substring(String message, int maxLength) {
        return (message == null) ? "" : (message.length() > maxLength ? message.substring(0, maxLength) : message);
    }

    private static final char SEPARATOR = '_';

    public static String toCamelCase(String s) {
        if (s == null) {
            return null;
        }
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s.length());
        boolean upperCase = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0) {
                upperCase = true;
            }
            if (c == SEPARATOR) {
                upperCase = true;
            } else if (upperCase) {
                sb.append(Character.toUpperCase(c));
                upperCase = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 去空格，如为null则转化为空字符串
     */
    public static String trim(String str) {
        if (str == null) {
            return "";
        }
        return str.trim();
    }

    public static String trim(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return trim(obj.toString());
        }
    }

    public static String msg2Json(Message msg) {
        JsonFormat jsonFormat = new JsonFormat();
        String json = jsonFormat.printToString(msg);
        return json;
    }

    public static String genGetMethodName(Field field) {
        int len = field.getName().length();
        if (field.getType() == boolean.class) {
            StringBuilder sb = new StringBuilder(len + 1);
            sb.append("is").append(field.getName());
            if (Character.isLowerCase(sb.charAt(2))) {
                sb.setCharAt(2, Character.toUpperCase(sb.charAt(2)));
            }
            return sb.toString();
        } else {
            StringBuilder sb = new StringBuilder(len + 3);
            sb.append("get").append(field.getName());
            if (Character.isLowerCase(sb.charAt(3))) {
                sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
            }
            return sb.toString();
        }
    }

    public static String genSetMethodName(Field field) {
        int len = field.getName().length();
        StringBuilder sb = new StringBuilder(len + 3);
        sb.append("set").append(field.getName());
        if (Character.isLowerCase(sb.charAt(3))) {
            sb.setCharAt(3, Character.toUpperCase(sb.charAt(3)));
        }
        return sb.toString();
    }

    /**
     * 将一个字符串由驼峰式命名变成分割符分隔单词
     *
     * <pre>
     *  lowerWord("helloWorld", '_') => "hello_world"
     * </pre>
     *
     * @param cs 字符串
     * @param c  分隔符
     * @return 转换后字符串
     */
    public static String lowerWord(CharSequence cs, char c) {
        int len = cs.length();
        StringBuilder sb = new StringBuilder(len + 5);
        for (int i = 0; i < len; i++) {
            char ch = cs.charAt(i);
            if (Character.isUpperCase(ch)) {
                if (i > 0)
                    sb.append(c);
                sb.append(Character.toLowerCase(ch));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    /**
     * 获取随机字符串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";// 含有字符和数字的字符串
        Random random = new Random();// 随机类初始化
        StringBuffer sb = new StringBuffer();// StringBuffer类生成，为了拼接字符串
        for (int i = 0; i < length; ++i) {
            int number = random.nextInt(62);// [0,62)
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
