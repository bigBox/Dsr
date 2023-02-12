package com.dj.domain.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSONObject;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.dj.domain.util.collection.ListUtil;
import com.dj.domain.util.lib.DataPair;
import com.dj.domain.util.math.NumberUtil;


/**
 * @author zcq
 * @ClassName: DateUtil
 * @Description: 日期工具
 * @date 2019年8月7日
 */
public class DateUtil {
    /**
     * yyyy-MM-dd
     */
    public static final String DATEPATTERN = "yyyy-MM-dd";
    /**
     * yyyyMMdd
     */
    public static final String DATEPATTERN2 = "yyyyMMdd";
    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String VIEW_STYLE_NORMAL = "yyyy-MM-dd HH:mm";
    /**
     * MM月dd日 HH:mm:ss
     */
    public static final String STYLE3 = "MM月dd日 HH:mm:ss";
    /**
     * yyyy-MM-dd kk:mm:ss
     */
    public static final String STYLE4 = "yyyy-MM-dd HH:mm:ss";
    /**
     * HH:mm
     */
    public static final String STYLE5 = "HH:mm";
    /**
     * MM月dd日 HH:mm
     */
    public static final String STYLE6 = "MM月dd日 HH:mm";
    /**
     * yyyyMMddhhmmss
     */
    public static final String STYLE7 = "yyyyMMddHHmmss";
    /**
     * HHmm
     */
    public static final String STYLE8 = "HHmm";
    /**
     * yyyy-MM-dd 00:00:00
     */
    public static final String STYLE9 = "yyyy-MM-dd 00:00:00";
    /**
     * yyyy-MM-dd kk:mm:ss
     */
    public static final String STYLE10 = "yyyy-MM-dd'T'HH:mm:ss";
    /**
     * yyyyMMddHHmm
     */
    public static final String STYLE11 = "yyyyMMddHHmm";
    /**
     * yyyy-MM-dd HH:00:00
     */
    public static final String STYLE13 = "yyyy-MM-dd HH:00:00";
    /**
     * yyyy-MM-dd HH
     */
    public static final String STYLE14 = "yyyy-MM-dd HH";
    /**
     * yyyy-MM-dd HH:mm
     */
    public static final String STYLE15 = "yyyy-MM-dd HH:mm";
    /**
     * yyyyMMddHH
     */
    public static final String STYLE16 = "yyyyMMddHH";
    /**
     * yyyy-MM-dd HH:mm:ss.SSS
     */
    public static final String STYLE17 = "yyyy-MM-dd HH:mm:ss.SSS";
    /**
     * yyyy-MM
     */
    public static final String STYLE18 = "yyyy-MM";
    /**
     * MM月dd日
     */
    public static final String STYLE19 = "MM月dd日";
    /**
     * yyyyMMddhhmmssSSS
     */
    public static final String STYLE20 = "yyyyMMddHHmmssSSS";

    /**
     * 一分钟对应的毫秒数
     */
    public static final int ONEMINUTE_2_MILLI = 60000;
    /**
     * 两分钟对应的毫秒数
     */
    public static final int TWOMINUTE_2_MILLI = 120000;
    /**
     * 十分钟对应的毫秒数
     */
    public static final int TENMINUTE_2_MILLI = 600000;
    /**
     * 半小时对应的毫秒数
     */
    public static final int HALFHOUR_2_MILLI = 1800000;
    /**
     * 一小时对应的毫秒数
     */
    public static final int ONEHOUR_2_MILLI = 3600000;
    /**
     * 一天对应的毫秒数
     */
    public static final int ONEDAY_2_MILLI = 86400000;
    /**
     * 一周对应的毫秒数
     */
    public static final int ONEWEEK_2_MILLI = 604800000;

    /**
     * 一分钟对应的秒数
     */
    public static final int ONEMINUTE_2_SECOND = 60;
    /**
     * 十分钟对应的秒数
     */
    public static final int TENMINUTE_2_SECOND = 600;
    /**
     * 半小时对应的秒数
     */
    public static final int HALFHOUR_2_SECOND = 1800;
    /**
     * 一小时对应的秒数
     */
    public static final int ONEHOUR_2_SECOND = 3600;
    /**
     * 一天对应的秒数
     */
    public static final int ONEDAY_2_SECOND = 86400;
    /**
     * 一周对应的秒数
     */
    public static final int ONEWEEK_2_SECOND = 604800;

    /**
     * @return Date
     * @Title getCurrentDate
     * @Description 当前时间
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * @return long
     * @Title getCurrentTimeMillis
     * @Description 当前时间
     */
    public static long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }

    /**
     * @return Timestamp
     * @Title getCurrentTimestamp
     * @Description 当前时间
     */
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * 当前日期(年月日) yyyy-MM-dd
     */
    public static String getNowDate() {
        return formatDate(getCurrentTimestamp(), DATEPATTERN);
    }

    /**
     * 明天日期(年月日) yyyy-MM-dd
     */
    public static String getTomorrowDate() {
        return formatDate(DateTime.now().plusDays(1).toDate(), DATEPATTERN);
    }

    /**
     * 当前日期(年月日) yyyyMMdd
     */
    public static String getNowDate2() {
        return formatDate(getCurrentTimestamp(), DATEPATTERN2);
    }

    /**
     * 当前时间 yyyyMMddHHmmss
     */
    public static String getNowTime() {
        return formatDate(getCurrentTimestamp(), STYLE7);
    }
    /**
     * 当前时间 yyyy-MM-dd HH:mm:ss
     */
    public static String getNowTime2() {
    	return formatDate(getCurrentTimestamp(), STYLE4);
    }

    /**
     * 当前周数(年+周)
     */
    public static String getNowWeek() {
        DateTime dt = DateTime.now();
        StringBuilder sb = new StringBuilder(6);
        return sb.append(dt.getWeekyear()).append(dt.getWeekOfWeekyear()).toString();
    }

    public static String getNowHour() {
        return formatDate(getCurrentTimestamp(), STYLE16);
    }

    /**
     * 当前月数(年+月)
     */
    public static String getNowMonth() {
        DateTime dt = DateTime.now();
        StringBuilder sb = new StringBuilder(6);
        return sb.append(dt.getYear()).append(dt.getMonthOfYear()).toString();
    }

    /**
     * 昨天日期(年月日) yyyy-MM-dd
     */
    public static String getYesterDate() {
        return formatDate(DateTime.now().plusDays(-1).toDate(), DATEPATTERN);
    }

    /**
     * 昨天日期(年月日) yyyyMMdd
     */
    public static String getYesterDate2() {
        return formatDate(DateTime.now().plusDays(-1).toDate(), DATEPATTERN2);
    }

    /**
     * 上周周数(年+周)
     */
    public static String getYesterWeek() {
        DateTime dt = DateTime.now().plusWeeks(-1);
        StringBuilder sb = new StringBuilder(6);
        return sb.append(dt.getWeekyear()).append(dt.getWeekOfWeekyear()).toString();
    }

    /**
     * 上月月数(年+月)
     */
    public static String getYesterMonth() {
        DateTime dt = DateTime.now().plusMonths(-1);
        StringBuilder sb = new StringBuilder(6);
        return sb.append(dt.getYear()).append(dt.getMonthOfYear()).toString();
    }

    /**
     * 获得当前的小时和分数组合的字符串
     *
     * @return
     */
    public static String getNowHourMinString() {
        return formatDate(new Date(), STYLE8);
    }

    /**
     * @param unit  时间单位(如TimeUnit.DAYS)
     * @param value 时间值(接上:1-当前时间加一天 -1-当前时间减一天)
     * @return Date
     * @Title getDateWithTime
     * @Description 获得当前时间plus指定TimeUnit单位的value时间后的时间
     */
    public static Date getDateWithTime(TimeUnit unit, int value) {
        return plusTime(getCurrentDate(), unit, value);
    }

    /**
     * @param date  指定时间
     * @param unit  时间单位(如TimeUnit.DAYS)
     * @param value 时间值(接上:1-当前时间加一天 -1-当前时间减一天)
     * @return Date
     * @Title getDateWithTime
     * @Description 获得指定时间plus指定TimeUnit单位的value时间后的时间
     */
    public static Date getDateWithTime(Date date, TimeUnit unit, int value) {
        return plusTime(date, unit, value);
    }

    /**
     * @param unit  时间单位(如TimeUnit.DAYS)
     * @param value 时间值(接上:1-当前时间加一天 -1-当前时间减一天)
     * @return Date
     * @Title getTimestampWithTime
     * @Description 获得当前时间plus指定TimeUnit单位的value时间后的时间
     */
    public static Date getTimestampWithTime(TimeUnit unit, int value) {
        return plusTime(getCurrentTimestamp(), unit, value);
    }

    /**
     * @param timestamp 指定时间
     * @param unit      时间单位(如TimeUnit.DAYS)
     * @param value     时间值(接上:1-当前时间加一天 -1-当前时间减一天)
     * @return Date
     * @Title getTimestampWithTime
     * @Description 获得指定时间plus指定TimeUnit单位的value时间后的时间
     */
    public static Date getTimestampWithTime(Timestamp timestamp, TimeUnit unit, int value) {
        return plusTime(timestamp, unit, value);
    }

    /**
     * @param originTime 指定时间
     * @param unit       时间单位
     * @param value      增加的值 可正可负
     * @return Timestamp
     * @Title plusTime
     * @Description 指定时间增加指定时间单位的值
     */
    public static Timestamp plusTime(Timestamp originTime, TimeUnit unit, int value) {
        if (unit == null) {
            return originTime;
        }
        DateTime dt = new DateTime(originTime.getTime());
        DateTime ret = dt;
        switch (unit) {
            case DAYS:
                ret = dt.plusDays(value);
                break;
            case HOURS:
                ret = dt.plusHours(value);
                break;
            case MICROSECONDS:
                ret = dt.plusMillis(value / 1000);
                break;
            case MILLISECONDS:
                ret = dt.plusMillis(value);
                break;
            case MINUTES:
                ret = dt.plusMinutes(value);
                break;
            case NANOSECONDS:
                ret = dt.plusMillis(value / 1000 / 1000);
                break;
            case SECONDS:
                ret = dt.plusSeconds(value);
                break;
            default:
                break;
        }
        return new Timestamp(ret.getMillis());
    }

    /**
     * @param originTime 指定时间
     * @param unit       时间单位
     * @param value      增加的值 可正可负
     * @return Date
     * @Title plusTime
     * @Description 指定时间增加指定时间单位的值
     */
    public static Date plusTime(Date originTime, TimeUnit unit, int value) {
        if (unit == null) {
            return originTime;
        }
        DateTime dt = new DateTime(originTime.getTime());
        DateTime ret = dt;
        switch (unit) {
            case DAYS:
                ret = dt.plusDays(value);
                break;
            case HOURS:
                ret = dt.plusHours(value);
                break;
            case MICROSECONDS:
                ret = dt.plusMillis(value / 1000);
                break;
            case MILLISECONDS:
                ret = dt.plusMillis(value);
                break;
            case MINUTES:
                ret = dt.plusMinutes(value);
                break;
            case NANOSECONDS:
                ret = dt.plusMillis(value / 1000 / 1000);
                break;
            case SECONDS:
                ret = dt.plusSeconds(value);
                break;
            default:
                break;
        }
        return ret.toDate();
    }

    /**
     * 获得当前时间过去一段时间的时间
     *
     * @param unit
     * @param value
     * @return
     */
    public static Date plusNow(TimeUnit unit, int value) {
        return plusTime(new Date(), unit, value);
    }

    /**
     * @param date  指定时间
     * @param unit  时间单位
     * @param value 增加的值 可正可负
     * @return Date
     * @Title plusTime
     * @Description 指定时间增加指定时间单位的值
     */
    public static String plusTime(String date, String style, TimeUnit unit, int value) {
        if (style == null) {
            style = VIEW_STYLE_NORMAL;
        }
        if (date == null) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormat.forPattern(style);
        DateTime dt = DateTime.parse(date, formatter);
        DateTime ret = dt;
        switch (unit) {
            case DAYS:
                ret = dt.plusDays(value);
                break;
            case HOURS:
                ret = dt.plusHours(value);
                break;
            case MICROSECONDS:
                ret = dt.plusMillis(value / 1000);
                break;
            case MILLISECONDS:
                ret = dt.plusMillis(value);
                break;
            case MINUTES:
                ret = dt.plusMinutes(value);
                break;
            case NANOSECONDS:
                ret = dt.plusMillis(value / 1000 / 1000);
                break;
            case SECONDS:
                ret = dt.plusSeconds(value);
                break;
            default:
                break;
        }
        return ret.toString(formatter);
    }

    /**
     * @param originTime 初始时间
     * @param years      增加X年时间-默认以365天计算
     * @param months     增加X月时间-默认以30天计算
     * @param days       增加X天时间
     * @param hours      增加X小时时间
     * @param minutes    增加X分钟时间
     * @param seconds    增加X秒时间
     * @return Date 返回类型
     * @Title: plusTime
     * @Description: 得到相对指定时间 指定年月日时分秒后的时间
     */
    public static Date plusTime(Date originTime, int years, int months, int days, int hours, int minutes, int seconds) {
        DateTime dt = new DateTime(originTime.getTime());
        return dt.plusYears(years).plusMonths(months).plusDays(days).plusHours(hours).plusMinutes(minutes)
                .plusSeconds(seconds).toDate();
    }

    /**
     * @param originTime 初始时间
     * @param years      增加X年时间-默认以365天计算
     * @param months     增加X月时间-默认以30天计算
     * @param days       增加X天时间
     * @param hours      增加X小时时间
     * @param minutes    增加X分钟时间
     * @param seconds    增加X秒时间
     * @return Timestamp 返回类型
     * @Title: plusTime
     * @Description: 得到相对指定时间 指定年月日时分秒后的时间
     */
    public static Timestamp plusTime(Timestamp originTime, int years, int months, int days, int hours, int minutes,
                                     int seconds) {
        DateTime dt = new DateTime(originTime.getTime());
        return new Timestamp(dt.plusYears(years).plusMonths(months).plusDays(days).plusHours(hours).plusMinutes(minutes)
                .plusSeconds(seconds).getMillis());
    }

    /**
     * 将Date格式化显示为String
     *
     * @param date Date
     * @return String
     */
    public static String formatDate(Date date) {
        return formatDate(date, DATEPATTERN);
    }

    /**
     * 将Date格式化显示为String
     *
     * @param date  Date
     * @param style String 样式
     * @return String
     */
    public static String formatDate(Date date, String style) {
        if (style == null) {
            style = DATEPATTERN;
        }
        if (date == null) {
            date = new Date();
        }
        return new DateTime(date.getTime()).toString(style);
    }

    /**
     * 将Timestamp格式化显示为String
     *
     * @param timestamp Timestamp
     * @param style     String 样式
     * @return String
     */
    public static String formatDate(Timestamp timestamp, String style) {
        if (style == null) {
            style = STYLE3;
        }
        return new DateTime(timestamp.getTime()).toString(style);
    }

    /**
     * 将GregorianCalendar格式化显示为String
     *
     * @param gregorianCalendar GregorianCalendar
     * @return String
     */
    public static String formatDate(GregorianCalendar gregorianCalendar) {
        return formatDate(gregorianCalendar, DATEPATTERN);
    }

    /**
     * 将GregorianCalendar格式化显示为String
     *
     * @param gregorianCalendar GregorianCalendar
     * @param style             String 样式
     * @return String
     */
    public static String formatDate(GregorianCalendar gregorianCalendar, String style) {
        return formatDate(gregorianCalendar.getTime(), style);
    }

    /**
     * 将一种时间格式字符串转化成另外一种时间格式字符串
     */
    public static String formatDate(String dateStr, String formStyle, String toStyle) {
        Date date = DateUtil.parseDate(dateStr, formStyle);
        return new DateTime(date.getTime()).toString(toStyle);
    }

    /**
     * 将字符串转为 Date，格式化样式为参数
     */
    public static Date parseDate(String date, String style) {
        if (style == null) {
            style = STYLE4;
        }
        if (date == null) {
            return new Date();
        }
        DateTimeFormatter formatter = DateTimeFormat.forPattern(style);
        return DateTime.parse(date, formatter).toDate();
    }

    public static Timestamp parseTimestamp(String date) {
        return new Timestamp(parseDate(date, STYLE4).getTime());
    }

    public static Timestamp parseTimestamp(String date, String style) {
        return new Timestamp(parseDate(date, style).getTime());
    }

    /**
     * 日期字符串是否合法 true 合法 ， false 非法
     */
    public static boolean isRightDate(String date, String style) {
        if (style == null) {
            style = DATEPATTERN;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(style);
        try {
            simpleDateFormat.parse(date);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * 根据long型 返回 XX小时XX分XX秒
     *
     * @param
     * @return
     */
    public static String showDifferTimeString(long longTime) {
        if (longTime <= 0) {
            return "0秒";
        }

        StringBuilder stb = new StringBuilder();

        if (longTime >= ONEDAY_2_MILLI) {
            long day = longTime / ONEDAY_2_MILLI;
            stb.append(day + "天");
        }

        if (longTime >= ONEHOUR_2_MILLI) {
            long hour = (longTime / ONEHOUR_2_MILLI) % 24;
            if (hour > 0) {
                stb.append(hour + "小时");
            }
        }

        if (longTime >= ONEMINUTE_2_MILLI) {
            long minute = (longTime / ONEMINUTE_2_MILLI) % 60;
            if (minute > 0) {
                stb.append(minute + "分钟");
            }
        }

        if (longTime >= 1000) {
            long second = longTime / 1000 % 60;
            if (second > 0) {
                stb.append(second + "秒");
            }
        }

        return stb.toString();
    }

    public static int differTime(long longTime, int type) {
        long between = longTime / 1000;
        switch (type) {
            case 0:// 分钟
                return (int) (between / 60);
            case 1:// 小时
                return (int) (between / 3600);
            default:
                return (int) between;
        }
    }

    /**
     * 判断是否在两个整点区间中
     *
     * @param
     * @param
     * @return
     */
    public static boolean checkBetweenTwoClock(int beginTime, int endTime) {
        if (beginTime == endTime) {
            return true;
        }

        GregorianCalendar now = new GregorianCalendar();
        int nowhour = now.get(Calendar.HOUR_OF_DAY);
        if (beginTime > endTime) {// 跨日
            return nowhour >= beginTime || nowhour < endTime;
        } else {// 一天以内
            return nowhour >= beginTime && nowhour < endTime;
        }

    }

    /**
     * 返回两个时间是否相隔超过一天
     */
    public static boolean isDifferOneDay(Date d1, Date d2) {
        long dt = d1.getTime() - d2.getTime();
        return Math.abs(dt) < ONEDAY_2_SECOND;
    }

    /**
     * @param date 指定时间
     * @return Date
     * @Title getDateBegin
     * @Description 获取指定时间所在一天的开始时间
     */
    public static Date getDateBegin(Date date) {
        if (date == null) {
            return null;
        }
        return new DateTime(date.getTime()).withTimeAtStartOfDay().toDate();
    }

    /**
     * @param date 指定时间
     * @return Date
     * @Title getDateBegin
     * @Description 获取指定时间所在一天的开始时间
     */
    public static Date getDateBegin(GregorianCalendar date) {
        if (date == null) {
            return null;
        }
        return new DateTime(date.getTime()).withTimeAtStartOfDay().toDate();
    }

    /**
     * @param date 指定时间
     * @return Timestamp
     * @Title getDateBegin
     * @Description 获取指定时间所在一天的开始时间
     */
    public static Timestamp getDateBegin(Timestamp date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(new DateTime(date.getTime()).withTimeAtStartOfDay().getMillis());
    }

    /**
     * @param date 指定时间
     * @return Date
     * @Title getDateEnd
     * @Description 获取指定时间所在一天的结束时间
     */
    public static Date getDateEnd(Date date) {
        if (date == null) {
            return null;
        }
        return new DateTime(date.getTime()).plusDays(1).withTimeAtStartOfDay().plusMillis(-1000).toDate();
    }

    /**
     * @param date 指定时间
     * @return Timestamp
     * @Title getDateEnd
     * @Description 获取指定时间所在一天的结束时间
     */
    public static Timestamp getDateEnd(GregorianCalendar date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(
                new DateTime(date.getTime()).plusDays(1).withTimeAtStartOfDay().plusMillis(-1000).getMillis());
    }

    /**
     * @param date 指定时间
     * @return Timestamp
     * @Title getDateEnd
     * @Description 获取指定时间所在一天的结束时间
     */
    public static Timestamp getDateEnd(Timestamp date) {
        if (date == null) {
            return null;
        }
        return new Timestamp(
                new DateTime(date.getTime()).plusDays(1).withTimeAtStartOfDay().plusMillis(-1000).getMillis());
    }

    /**
     * 获取输入的日期所在周的第一天和最后一天<br>
     *
     * @param date
     */
    public static Date[] getWeekBeginAndEndDayByNow(Date date) {
        Date[] result = new Date[2];
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.setTime(date);
        // begin
        cal.set(Calendar.DAY_OF_WEEK, cal.getActualMinimum(Calendar.DAY_OF_WEEK));
        cal.add(Calendar.DAY_OF_YEAR, +1);
        // 默认星期天为一周的开始
        result[0] = cal.getTime();
        // end
        cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
        cal.add(Calendar.DAY_OF_YEAR, +1);
        // 默认星期六为一周的结束
        result[1] = cal.getTime();
        return result;
    }

    /**
     * 得到指定月份的最大天数
     *
     * @param date
     * @return
     */
    public static int getMonthMaxDay(Date date) {
        Calendar cal = Calendar.getInstance(Locale.CHINA);
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    // 得到本周开始,按中国的习惯周一为一周的开始
    public static GregorianCalendar getWeekBegin() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (gregorianCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        gregorianCalendar.set(Calendar.HOUR_OF_DAY, 0);
        gregorianCalendar.set(Calendar.MINUTE, 0);
        gregorianCalendar.set(Calendar.SECOND, 0);
        return gregorianCalendar;
    }

    /**
     * 获取输入的日期所在周的第一天,按中国的习惯周一为一周的开始
     *
     * @return
     */
    public static GregorianCalendar getWeekBegin(Date commitDate) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(commitDate);
        if (gregorianCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        gregorianCalendar.set(Calendar.HOUR_OF_DAY, 0);
        gregorianCalendar.set(Calendar.MINUTE, 0);
        gregorianCalendar.set(Calendar.SECOND, 0);
        return gregorianCalendar;
    }

    public static Date getLastWeekDateBegin() {
        return new Date(DateUtil.getLastWeekBegin().getTimeInMillis());
    }

    // 得到上周开始,按中国的习惯周一为一周的开始
    public static GregorianCalendar getLastWeekBegin() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (gregorianCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        gregorianCalendar.set(Calendar.HOUR_OF_DAY, 0);
        gregorianCalendar.set(Calendar.MINUTE, 0);
        gregorianCalendar.set(Calendar.SECOND, 0);
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, -7);
        return gregorianCalendar;
    }

    public static Date getLastWeekDateEnd() {
        return new Date(DateUtil.getLastWeekEnd().getTimeInMillis());
    }

    // 得到上周末,按中国的习惯周一为一周的开始
    public static GregorianCalendar getLastWeekEnd() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (gregorianCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            gregorianCalendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        gregorianCalendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        gregorianCalendar.set(Calendar.HOUR_OF_DAY, 0);
        gregorianCalendar.set(Calendar.MINUTE, 0);
        gregorianCalendar.set(Calendar.SECOND, 0);
        gregorianCalendar.add(Calendar.DAY_OF_MONTH, -7);
        return gregorianCalendar;
    }

    // 得到上月月末
    public static GregorianCalendar getLastMonthEnd() {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(Calendar.DATE, 1);// 日，设为一号
        gregorianCalendar.add(Calendar.DATE, -1);// 减一为上月最后一天
        return gregorianCalendar;
    }

    public static Date getLastMonthDateEnd() {
        DateTime now = DateTime.now();
        int days = now.getDayOfMonth();
        return new Date(now.plusDays(-days + 1).withTimeAtStartOfDay().plusMillis(-1000).getMillis());
    }

    public static Date getLastMonthBegin() {
        DateTime now = DateTime.now().plusMonths(-1);
        int days = now.getDayOfMonth();
        return new Date(now.plusDays(-days + 1).withTimeAtStartOfDay().getMillis());
    }

    public static Date getCurrentMonthBegin() {
        DateTime now = DateTime.now();
        int days = now.getDayOfMonth();
        return new Date(now.plusDays(-days + 1).withTimeAtStartOfDay().getMillis());
    }

    public static Date getCurrentMonthDateEnd() {
        DateTime now = DateTime.now().plusMonths(1);
        int days = now.getDayOfMonth();
        return new Date(now.plusDays(-days + 1).withTimeAtStartOfDay().plusMillis(-1000).getMillis());
    }

    // 得到当前月份的月头
    public static Timestamp getMonthBegin(GregorianCalendar date) {
        if (date == null) {
            return null;
        }
        DateTime now = new DateTime(date);
        int days = now.getDayOfMonth();
        return new Timestamp(now.plusDays(-days + 1).withTimeAtStartOfDay().getMillis());
    }

    // 得到当前月份的月尾
    public static Timestamp getMonthEnd(GregorianCalendar date) {
        if (date == null) {
            return null;
        }
        DateTime now = new DateTime(date).plusMonths(1);
        int days = now.getDayOfMonth();
        return new Timestamp(now.plusDays(-days + 1).withTimeAtStartOfDay().plusMillis(-1000).getMillis());
    }

    /**
     * 获取时间月初
     */
    public static String getMinMonthDate(Date date, String style) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return formatDate(calendar.getTime(), style);
    }

    /**
     * 获取时间月末
     */
    public static String getMaxMonthDate(Date date, String style) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return formatDate(getDateEnd(calendar.getTime()), style);
    }

    /**
     * 得到两个时间之间相差的天数 后一个时间晚于前一个时间
     *
     * @param time1
     * @param time2
     * @return
     */
    public static long getDistanceDays(long time1, long time2) {
        if (time2 > time1) {
            return (time2 - time1) / ONEDAY_2_MILLI;
        } else {
            return (time1 - time2) / ONEDAY_2_MILLI;
        }
    }

    /**
     * 得到两个时间之间相差的分钟数 后一个时间晚于前一个时间
     *
     * @param time1
     * @param time2
     * @return
     */
    public static long getDistanceMinutess(long time1, long time2) {
        if (time2 > time1) {
            return (time2 - time1) / ONEMINUTE_2_MILLI;
        } else {
            return (time1 - time2) / ONEMINUTE_2_MILLI;
        }
    }

    /**
     * 返回两个时间是否同一天
     *
     * @param
     * @param
     * @return
     */
    public static boolean isSameDay(Date d1, Date d2) {
        int days = Days.daysBetween(new DateTime(d1), new DateTime(d2)).getDays();
        return days == 0;
    }

    /**
     * 返回两个时间是否同一天
     *
     * @param
     * @param
     * @return
     */
    public static boolean isSameDay(Timestamp t1, Timestamp t2) {
        int days = Days.daysBetween(new DateTime(t1), new DateTime(t2)).getDays();
        return days == 0;
    }

    /**
     * 返回参数与当天是否同一天
     *
     * @param date
     * @return
     */
    public static boolean isSameDayOfToday(Date date) {
        return isSameDay(new Date(), date);
    }

    /**
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return boolean
     * @Title isSameWeek
     * @Description 判定两个时间是否在同一周(周一为一周的开始)
     */
    public static boolean isSameWeek(Timestamp startDate, Timestamp endDate) {
        DateTime start = new DateTime(startDate.getTime());
        DateTime end = new DateTime(endDate.getTime());
        return isSameWeek(start, end);
    }

    /**
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return boolean
     * @Title isSameWeek
     * @Description 判定两个时间是否在同一周(周一为一周的开始)
     */
    public static boolean isSameWeek(Date startDate, Date endDate) {
        DateTime start = new DateTime(startDate.getTime());
        DateTime end = new DateTime(endDate.getTime());
        return isSameWeek(start, end);
    }

    public static boolean isSameWeek(DateTime start, DateTime end) {
        if (start.getWeekyear() != end.getWeekyear()) {
            return false;
        }
        return start.getWeekOfWeekyear() == end.getWeekOfWeekyear();
    }

    /**
     * 将时间转换为int表现形式
     *
     * @param time
     * @return
     */
    public static int convertDate2Int4Hour(Date time) {
        return NumberUtil.parseInt(formatDate(time, "yyyyMMddHH"));
    }

    /**
     * 将时间转换为int表现形式
     *
     * @param time
     * @return
     */
    public static int convertDate2Int4Day(Date time) {
        return NumberUtil.parseInt(formatDate(time, "yyyyMMdd"));
    }

    /**
     * 将时间转换为int表现形式
     *
     * @param time
     * @return
     */
    public static int convertDate2Int4Month(Date time) {
        return NumberUtil.parseInt(formatDate(time, "yyyyMM"));
    }

    /**
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return int
     * @Title daysBetween
     * @Description 获取两个时间间隔的天数
     */
    public static int daysBetween(Date startDate, Date endDate) {
        return Days.daysBetween(new DateTime(startDate), new DateTime(endDate)).getDays();
    }

    /**
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return int
     * @Title daysBetween
     * @Description 获取两个时间间隔的天数
     */
    public static int daysBetween(Timestamp startDate, Timestamp endDate) {
        return Days.daysBetween(new DateTime(startDate), new DateTime(endDate)).getDays();
    }

    /**
     * 那个时间距离今天的天数
     *
     * @param theDate
     * @return
     */
    public static int daysBetweenNow(long theDate) {
        return Days.daysBetween(new DateTime(theDate), new DateTime()).getDays();
    }

    /**
     * 某天和今天相距的天数
     *
     * @param theDate
     * @return
     */
    public static int daysBetweenToday(long theDate) {
        return Days.daysBetween(new DateTime(theDate).withTimeAtStartOfDay(), new DateTime().withTimeAtStartOfDay()).getDays();
    }

    /**
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return int
     * @Title hoursBetween
     * @Description 获取两个时间间隔的小时
     */
    public static int hoursBetween(Date startDate, Date endDate) {
        return Hours.hoursBetween(new DateTime(startDate), new DateTime(endDate)).getHours();
    }

    /**
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return int
     * @Title hoursBetween
     * @Description 获取两个时间间隔的小时
     */
    public static int hoursBetween(Timestamp startDate, Timestamp endDate) {
        return Hours.hoursBetween(new DateTime(startDate), new DateTime(endDate)).getHours();
    }

    /**
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return int
     * @Title minutesBetween
     * @Description 获取两个时间间隔的分钟
     */
    public static int minutesBetween(Date startDate, Date endDate) {
        return Minutes.minutesBetween(new DateTime(startDate), new DateTime(endDate)).getMinutes();
    }

    /**
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return int
     * @Title minutesBetween
     * @Description 获取两个时间间隔的分钟
     */
    public static int minutesBetween(Timestamp startDate, Timestamp endDate) {
        return Minutes.minutesBetween(new DateTime(startDate), new DateTime(endDate)).getMinutes();
    }

    /**
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return int
     * @Title secondsBetween
     * @Description 获取两个时间间隔的秒数
     */
    public static int secondsBetween(Date startDate, Date endDate) {
        return Seconds.secondsBetween(new DateTime(startDate), new DateTime(endDate)).getSeconds();
    }

    /**
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return int
     * @Title secondsBetween
     * @Description 获取两个时间间隔的秒数
     */
    public static int secondsBetween(Timestamp startDate, Timestamp endDate) {
        return Seconds.secondsBetween(new DateTime(startDate), new DateTime(endDate)).getSeconds();
    }

    /**
     *	获取当前时间距离结束时间差多少分钟
     *
     * @return
     */
    public static int getMinsByNow_EndTime(Timestamp endTime) {
        Timestamp now = getCurrentTimestamp();
        int num = (int) ((endTime.getTime() - now.getTime()) / 1000);
        if (num < 0) {
            return 0;
        }
        // 剩余xxx秒的时候为1分钟，x分xx秒显示为（x+1）分钟
        return num = (num + 60) / 60;
    }

    // 取得一年中的第x周的，周一到周日，以int返回
    public static int[] getWeek(int nums) {
        int[] result = new int[2];
        GregorianCalendar calandar = new GregorianCalendar();
        calandar.set(Calendar.WEEK_OF_YEAR, nums);// 切换到第x周
        calandar.add(Calendar.DAY_OF_MONTH, 1);// 按习惯我们是周一为起点
        result[0] = DateUtil.convertDate2Int4Day(calandar.getTime());
        calandar.add(Calendar.DAY_OF_MONTH, 6);// 计算周日
        result[1] = DateUtil.convertDate2Int4Day(calandar.getTime());
        return result;
    }

    /**
     * @param endTime 结束的时间
     * @param unit    时间单位
     * @return int
     * @Title getElapsedTime
     * @Description endTime到现在逝去的时间
     */
    public static final long getElapsedTime(long endTime, TimeUnit unit) {
        return getElapsedTime(System.currentTimeMillis(), endTime, unit);
    }

    /**
     * @param baseTime
     * @param endTime
     * @param unit
     * @return
     * @Title: getElapsedTime
     * @Description: endTime到baseTime逝去的时间 baseTime>=endTime
     */
    public static final long getElapsedTime(long baseTime, long endTime, TimeUnit unit) {
        long ret = 0L;
        switch (unit) {
            case DAYS:
                ret = Days.daysBetween(new DateTime(endTime), new DateTime(baseTime)).getDays();
                break;
            case HOURS:
                ret = Hours.hoursBetween(new DateTime(endTime), new DateTime(baseTime)).getHours();
                break;
            case MICROSECONDS:
                ret = Seconds.secondsBetween(new DateTime(endTime), new DateTime(baseTime)).getSeconds() * 1000 * 1000L;
                break;
            case MILLISECONDS:
                ret = Seconds.secondsBetween(new DateTime(endTime), new DateTime(baseTime)).getSeconds() * 1000L;
                break;
            case MINUTES:
                ret = Minutes.minutesBetween(new DateTime(endTime), new DateTime(baseTime)).getMinutes();
                break;
            case NANOSECONDS:
                ret = Seconds.secondsBetween(new DateTime(endTime), new DateTime(baseTime)).getSeconds() * 1000 * 1000 * 1000L;
                break;
            case SECONDS:
                ret = Seconds.secondsBetween(new DateTime(endTime), new DateTime(baseTime)).getSeconds();
                break;
            default:
                break;

        }
        return ret;
    }

    /**
     * @param time
     * @return boolean
     * @Title isToday
     * @Description 根据时间戳判断是不是今天
     */
    public static final boolean isToday(long time) {
        return getStartOfTheDay(getCurrentTimeMillis()) == getStartOfTheDay(time);
    }

    /**
     * @param time
     * @return boolean
     * @Title isYesterday
     * @Description 根据时间戳判断是不是昨天
     */
    public static final boolean isYesterday(long time) {
        return getStartOfTheDay(getCurrentTimeMillis(), -1) == getStartOfTheDay(time);
    }

    /**
     * @param time
     * @return boolean
     * @Title isTomorrow
     * @Description 根据时间戳判断是不是明天
     */
    public static final boolean isTomorrow(long time) {
        return getStartOfTheDay(getCurrentTimeMillis(), 1) == getStartOfTheDay(time);
    }

    /**
     * @return Date
     * @Title getTodayStartTime
     * @Description 获取今天开始时间戳
     */
    public static Date getTodayStartTime() {
        return DateTime.now().withTimeAtStartOfDay().toDate();
    }

    /**
     * @return Date
     * @Title getYesterdayStartTime
     * @Description 获取昨天开始时间戳
     */
    public static Date getYesterdayStartTime() {
        return DateTime.now().plusDays(-1).withTimeAtStartOfDay().toDate();
    }

    /**
     * @return Date
     * @Title getTomorrowStartTime
     * @Description 获取明天开始时间戳
     */
    public static Date getTomorrowStartTime() {
        return DateTime.now().plusDays(1).withTimeAtStartOfDay().toDate();
    }

    /**
     * @param time 指定时间
     * @return long
     * @Title getStartOfTheDay
     * @Description 根据时间戳获取指定时间的起始时间戳
     */
    public static final long getStartOfTheDay(long time) {
        return new DateTime(time).withTimeAtStartOfDay().getMillis();
    }

    /**
     * @param time 指定时间
     * @param days 增加或减少的天数
     * @return long
     * @Title getStartOfTheDay
     * @Description 根据时间戳(+ days)获取指定时间的起始时间戳
     */
    public static final long getStartOfTheDay(long time, int days) {
        return new DateTime(time).plusDays(days).withTimeAtStartOfDay().getMillis();
    }

    /**
     * 通过日期字符串或者时间戳
     */
    public static Long getTime(String dateString) {
        Long time = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            time = sdf.parse(dateString).getTime();
        } catch (ParseException e) {
        	e.printStackTrace();
        }
        return time;
    }

    /**
     * 通过日期字符串或者时间戳
     */
    public static Long getHourTime(String dateString) {
        Long time = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
            time = sdf.parse(dateString).getTime();
        } catch (ParseException e) {
        	e.printStackTrace();
        }
        return time;
    }

    /**
     * 获取星期几 星期日=7 星期一=1
     */
    public static int getDayOfWeek(long time) {
        return new DateTime(time).dayOfWeek().get();
    }

    public static int getDayOfWeekWestern(long time) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeInMillis(time);
        return gregorianCalendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     * yyyyMMddHHmm 的格式化
     *
     * @param date
     * @return
     */
    public static Date parseDateUseStyle11(String date) {
        return parseDate(date, STYLE11);
    }

    /**
     * 计算当前时间 到某个整点的秒数
     *
     * @param hour
     * @return
     */
    public static int getSecondsUtilHour(int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return secondsBetween(new Date(), calendar.getTime());
    }

    /**
     * 获得当前的小时数
     *
     * @return
     */
    public static int getCurrentHour() {
        return new DateTime().getHourOfDay();
    }

    /**
     * 获得今天某个整点的时间
     *
     * @param hour
     * @param secOffset 秒数的偏移
     * @return
     */
    public static Date getTodayTheHour(int hour, int secOffset) {
        DateTime dateTime = new DateTime();
        if (hour == 24) {
            return dateTime.plusDays(1).withTimeAtStartOfDay().plusSeconds(secOffset).toDate();
        }
        return dateTime.withTimeAtStartOfDay().withHourOfDay(hour).plusSeconds(secOffset).toDate();
    }

    /**
     * 获得今天某个
     *
     * @param secOffset
     * @param hourOffset
     * @return
     */
    public static Date getTheTimeByPlusHour(int hourOffset, int secOffset) {
        DateTime dateTime = new DateTime();
        int hour = dateTime.getHourOfDay();
        return dateTime.withTimeAtStartOfDay().withHourOfDay(hour).plusHours(hourOffset).plusSeconds(secOffset).toDate();
    }

    /**
     * 获得下一个这个时间的date
     *
     * @param dataPair obj1 小时 , obj2 分钟
     * @return
     */
    public static Date getNextTime(DataPair<Integer, Integer> dataPair) {
        int hour = dataPair.getObj1();
        int min = dataPair.getObj2();
        DateTime dateTime = new DateTime();
        int hourOfDay = dateTime.getHourOfDay();
        int minOfHour = dateTime.getMinuteOfHour();
        if (hourOfDay > hour || (hourOfDay == hour && minOfHour >= min)) {
            // 已经过去了， 回不去了。 | 过去一秒也算过去
            // 使用明天的时间
            return dateTime.withTimeAtStartOfDay().plusDays(1).withHourOfDay(hour).withMinuteOfHour(min).toDate();
        }
        // 用今天的时间即可。
        return dateTime.withTimeAtStartOfDay().withHourOfDay(hourOfDay).withMinuteOfHour(min).toDate();
    }

    /**
     * 获取下一个 这个星期的时间 ， 如果今天是周一， 给入的参数是 1,4 那么返回的是周四的时间， 今天不会返回
     *
     * @param dateList 可写 1-7 对应着
     * @return
     */
    public static Date getNextTime(List<BigInteger> dateList) {
        DateTime dateTime = new DateTime();
        int dayOfWeek = dateTime.getDayOfWeek();
        int theDay = -1, firstDay = -1;
        for (BigInteger bigInteger : dateList) {
            int t = bigInteger.intValue();
            if (firstDay == -1 || firstDay > t) {
                firstDay = t;
            }
            if (t > dayOfWeek && (theDay == -1 || theDay > t)) {
                theDay = t;
            }
        }
        if (theDay > 0) {
            // 向后的几天
            return dateTime.plusDays(theDay - dayOfWeek).withTimeAtStartOfDay().toDate();
        }
        // 下周
        return dateTime.plusWeeks(1).minusDays(dayOfWeek - firstDay).withTimeAtStartOfDay().toDate();
    }

    /**
     * 是否是周末
     *
     * @return
     */
    public static boolean isWeekend() {
        int tmp = new DateTime().getDayOfWeek();
        return tmp == DateTimeConstants.SATURDAY || tmp == DateTimeConstants.SUNDAY;
    }

    /**
     * 获取当天指定时刻的时间
     *
     * @param pattern HH:mm:ss
     * @return
     */
    public static Date getCurDayAssign(String pattern) {
        String[] strs = pattern.split(":");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(strs[0]));
        cal.set(Calendar.MINUTE, Integer.parseInt(strs[1]));
        cal.set(Calendar.SECOND, Integer.parseInt(strs[2]));
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取当前时间距离指定周中的时间
     *
     * @param date
     * @param weeks
     * @return
     */
    public static Date getDayOnWeeks2(Date date, List<BigInteger> weeks) {
        List<Integer> list = ListUtil.convertType(weeks, o -> o.intValue());
        return getDayOnWeeks(date, list);
    }

    /**
     * 获取当前时间距离指定周中的时间
     *
     * @param date
     * @param weeks
     * @return
     */
    public static Date getDayOnWeeks(Date date, List<Integer> weeks) {
        if (weeks.isEmpty())
            return date;
        Collections.sort(weeks);
        int maxWeek = weeks.get(weeks.size() - 1);
        int curWeek = getDayOfWeek(date.getTime());
        int diffDays = 0;
        if (curWeek > maxWeek) {
            diffDays = 7 - curWeek + weeks.get(0);
        } else {
            for (int week : weeks) {
                if (week >= curWeek) {
                    diffDays = week - curWeek;
                    break;
                }
            }
        }
        return getDateWithTime(date, TimeUnit.DAYS, diffDays);
    }

    /**
     * 检测两个分钟是否在一个区间里面
     *
     * @param minutes
     * @param
     * @param interval
     * @return
     */
    public static boolean checkInSamePartOfDay(int minutes, int theMinutes, int interval) {
        int a = minutes / interval;
        int b = theMinutes / interval;
        return a == b;
    }

    /**
     * 获取两个时间在日历上相差的天数
     *
     * @param time1
     * @param time2
     * @return
     */
    public static int getDiffDays(long time1, long time2) {
        if (time1 > time2) {
            long tmp = time1;
            time1 = time2;
            time2 = tmp;
        }
        return daysBetween(new Date(getStartOfTheDay(time1)), new Date(getStartOfTheDay(time2)));
    }

    public static long unixTimeInSecond() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * @return true 法定节假日 false 正常工作日或者周末
     */
    public static boolean getHolidayRequest() {
        String httpUrl = "http://tool.bitefu.net/jiari/?d=" + getNowDate2();
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            StringBuffer sbf = new StringBuffer();
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
            }
            reader.close();
            connection.disconnect();
            String result = sbf.toString();
            //返回结果0工作日 1 假日 2节日
            if("2".equalsIgnoreCase(result)){
                return true;
            }else if("1".equalsIgnoreCase(result)){
                return false;
            }else if("0".equalsIgnoreCase(result)){
                return false;
            }else {
                //第一个接口失效的情况下，读取第二个备用接口
                httpUrl = "http://timor.tech/api/holiday/info/" + getNowDate();
                URL url1 = new URL(httpUrl);
                HttpURLConnection connection1 = (HttpURLConnection)url1.openConnection();
                connection1.setRequestMethod("GET");
                connection1.connect();
                InputStream is1 = connection1.getInputStream();
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(is1, "UTF-8"));
                StringBuffer sbf1 = new StringBuffer();
                String strRead1 = null;
                while ((strRead1 = reader1.readLine()) != null) {
                    sbf1.append(strRead1);
                    sbf1.append("\r\n");
                }
                reader1.close();
                connection1.disconnect();
                result = sbf1.toString();
                JSONObject jsonObjectResult = JSONObject.parseObject(result);
                if(!StringUtil.isEmpty(jsonObjectResult.getString("holiday"))){
                    return true;
                }else {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

//    public static void main(String[] args) {
//        //System.out.println(isSameWeek(DateTime.now(), DateTime.now().plusDays(-3)));
//        //System.out.println(getNowWeek());
//        //System.out.println(getYesterWeek());
//        //System.out.println(getYesterMonth());
//        //System.out.println(getElapsedTime(System.currentTimeMillis(), 1530210418000L, TimeUnit.MINUTES));
//        // System.out.println(daysBetween(new Date(1511243598000L), new
//        // Date()));
//        // // 上月月头月尾
//        // Date lastMonthBegin = DateUtil.getLastMonthBegin();
//        // Date lastMonthDateEnd = DateUtil.getLastMonthDateEnd();
//        // System.out.println(lastMonthBegin);
//        // System.out.println(lastMonthDateEnd);
//        //
//        // // 本月月头月尾
//        // Date currentMonthBegin = DateUtil.getCurrentMonthBegin();
//        // Date currentMonthDateEnd = DateUtil.getCurrentMonthDateEnd();
//        // System.out.println(currentMonthBegin);
//        // System.out.println(currentMonthDateEnd);
//        // System.out.println(DateUtil.getTodayTheHour(24, 2));
//
//        // System.out.println(checkInSamePartOfDay(480, 490, 60));
//
//        //List<BigInteger> list = Lists.newArrayList(BigInteger.valueOf(1), BigInteger.valueOf(4));
//        //Date date = getNextTime(list);
//        //System.out.println(date);
//        //System.out.println(getHolidayRequest());
//    }
}
