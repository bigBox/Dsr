package com.dj.servercore;

import java.sql.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.domain.util.ArrayUtil;
import com.dj.domain.util.DateUtil;

public class Checker {
    /**
     *	接口名 英文 数字
     */
    public static final Pattern apiPattern = Pattern.compile("^[A-Za-z0-9]+$");
    /**
     *	平台用户名 英文 数字
     */
    public static final Pattern accountNamePattern = Pattern.compile("^[a-zA-Z0-9_\\-\\.\\_]+$");
    /**
     *	邮箱
     */
    public static final Pattern userNamePattern = Pattern.compile("^[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9\\-]+(\\.[a-zA-Z0-9\\-]+)+$");

    public static final Pattern punctuationPattern = Pattern.compile("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]$");

    /** 用户名 英文 数字 下划线 */
    // public static final Pattern userNamePattern =
    // Pattern.compile("^[a-zA-Z0-9@\\._]+$");
    /** 昵称 中文 */
    // public static final Pattern nickNamePattern =
    // Pattern.compile("^[\u4e00-\u9fa5]{2,6}$");
    /**
     *	昵称 中文 英文 标点符号
     */
    public static final Pattern nickNamePattern = Pattern.compile("^[\u4e00-\u9fa50-9A-Za-z]{2,6}$");
    /**
     *	邮件的标题和内容的检测
     */
    public static final Pattern mailTCPattern = Pattern.compile("^[\u4e00-\u9fa50-9A-Za-z\\.，……＿ -‘=& * ～ ~【 ★ 】/. ’ ↓ * # @ ￥ ^ $（ ）《》。|？： — ；、 · 。 ：! “ ！ % ”]*$");
    /**
     *	无效的内容 匹配
     */
    public static final Pattern invaildContentPattern = Pattern.compile("^[^\u4e00-\u9fa50-9A-Za-z\\.，……＿ -‘=& * ～ ~【 ★ 】/. ’ ↓ * # @ ￥ ^ $（ ）《》。|？： — ；、 · 。 ：! “ ！ % ”]*$");
    /**
     *	公会名称 中文
     */
    public static final Pattern guildNamePattern = Pattern.compile("^[\u4e00-\u9fa50-9A-Za-z]{2,5}$");
    /**
     *	房间名 英文 数字 下划线 半角空格 中文
     */
    public static final Pattern roomNamePattern = Pattern.compile("^[a-zA-Z0-9_\u0020\u4e00-\u9fa5]{3,32}$");
    /**
     *	消息 空白字符
     */
    public static final Pattern messagePattern = Pattern.compile("\\s");
    /**
     *	数字
     */
    public static final Pattern numbericPattern = Pattern.compile("[0-9]*");
    /**
     *	大陆手机号
     */
    public static final Pattern cellChinaPattern = Pattern.compile("^((13[0-9])|(15[^4])|(19[0-9])|(18[0-9])|(17[0-9])|(16[0-9])|(147))\\d{8}$");
    /**
     *	香港手机号
     */
    public static final Pattern cellHKPattern = Pattern.compile("^(5|6|8|9)\\d{7}$");
    /**
     *	手机号的最后一层判定
     */
    public static final Pattern cellLastPatter = Pattern.compile("^[1][3-8]\\d{9}$|^([6|9])\\d{7}$|^[0][9]\\d{8}$|^[6]([8|6])\\d{5}$");
    /**
     *	大陆手机号
     */
    public static final Pattern cardNoChinaPattern = Pattern.compile("^\\d{6}(18|19|20)?\\d{2}(0[1-9]|1[012])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|[xX])$");
    /**
     *	真实姓名的正则表达式
     */
    public static final Pattern realNamePattern = Pattern.compile("^[\\u4E00-\\u9FA5A-Za-z]+$");
    /**
     * ip 的匹配表达式
     */
    public static final Pattern IP_PATTERN = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$");
    /**
     *	正确的qq号正则表达式
     */
    public static final Pattern qqPattern = Pattern.compile("[1-9][0-9]{4,12}");
    /**
     *	正确的微信号正则表达式
     */
    public static final Pattern wechatPattern = Pattern.compile("^[a-zA-Z0-9_-]{5,19}$");

    public static boolean isPunctuation(String api) {
        return (api != null) && punctuationPattern.matcher(api).matches();
    }

    /**
     *	是否是合法的接口名
     */
    public static boolean isValidApiName(String api) {
        return (api != null) && apiPattern.matcher(api).matches();
    }

    /**
     *	是否是合法的cdkey
     */
    public static boolean isValidCdkey(String cdkey) {
        return (cdkey != null) && apiPattern.matcher(cdkey).matches();
    }

    /**
     *	是否是合法的QQ或微信
     */
    public static boolean isValidQQorWechat(String api) {
        boolean qqCheck = (api != null) && qqPattern.matcher(api).matches();
        boolean wechatCheck = (api != null) && wechatPattern.matcher(api).matches();
        return qqCheck || wechatCheck;
    }

    /**
     *	是否是合法的平台用户名
     */
    public static boolean isValidAccountName(String api) {
        return (api != null) && accountNamePattern.matcher(api).matches();
    }

    /**
     *	是否是合法的内容
     */
    public static boolean isValidContent(String content, String filterString) {
        boolean flag = (content != null) && nickNamePattern.matcher(content).matches();
        if (flag) {
            Pattern filter = Pattern.compile(filterString);
            return !filter.matcher(content).find();
        }
        return flag;
    }

    /**
     *	是否是合法的房间名
     */
    public static boolean isValidRoomName(String roomName) {
        return (roomName != null) && roomNamePattern.matcher(roomName).matches();
    }

    /**
     *	是否是合法的昵称
     */
    public static boolean isValidNickName(String nickName) {
        return (nickName != null) && nickNamePattern.matcher(nickName).matches();
    }

    /**
     *	是否是合法的公会名称
     */
    public static boolean isValidGuildName(String guildName) {
        return (guildName != null) && guildNamePattern.matcher(guildName).matches();
    }

    public static boolean isValidRealName(String realName) {
        return (realName != null) && realNamePattern.matcher(realName).matches();
    }

    /**
     *	是否是合法的大陆手机号
     */
    public static boolean isValidChinaCellNo(String cellNo) {
        return (cellNo != null) && cellChinaPattern.matcher(cellNo).matches();
    }

    /**
     *	是否是合法的香港手机号
     */
    public static boolean isValidHkCellNo(String cellNo) {
        return (cellNo != null) && cellHKPattern.matcher(cellNo).matches();
    }

    /**
     *	是否是合法的密码
     */
    public static boolean isValidPass(String pass) {
        return (pass != null) && nickNamePattern.matcher(pass).matches();
    }

    /**
     *	是否是合法的大陆身份证号码
     */
    public static boolean isValidChinaCardNo(String cardNo) {
        return (cardNo != null) && cardNoChinaPattern.matcher(cardNo).matches();
    }

    /**
     *	这个值是否是真
     *
     * @param flag
     * @return
     */
    public static boolean isTrue(Boolean flag) {
        return flag != null && flag.booleanValue();
    }

    /**
     *	过滤非法字符
     */
    public static String filterIllegalChars(String message) {
        return messagePattern.matcher(message).replaceAll("");
    }

    /**
     *	检测 不能为空
     */
    public static void checkNotNull(Object... params) {
        for (Object i : params) {
            if (i == null) {
                throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
            }
        }
    }

    public static boolean checkNotNull(Object params) {
        return params != null;
    }

    /**
     *	检测 配置不能为空
     */
    public static void checkConfigNotNull(String message, Object... params) {
        for (Object i : params) {
            if (i == null) {
                throw new CommonException(ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
            }
        }
    }

    /**
     *	检测大于零
     */
    public static void checkLongGreaterThanZero(long... params) {
        if (ArrayUtil.isNullOrEmpty(params)) {
            return;
        }
        for (long i : params) {
            if (i < 1L) {
                throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
            }
        }
    }

    /**
     *	检测大于等于零
     */
    public static void checkLongGreaterOrEqualZero(long... params) {
        if (ArrayUtil.isNullOrEmpty(params)) {
            return;
        }
        for (long i : params) {
            if (i < 0) {
                throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
            }
        }
    }

    /**
     *	检测大于零
     */
    public static void checkGreaterThanZero(int... params) {
        if (ArrayUtil.isNullOrEmpty(params)) {
            return;
        }
        for (int i : params) {
            if (i < 1) {
                throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
            }
        }
    }

    /**
     *	检测大于等于零
     */
    public static void checkGreaterOrEqualZero(int... params) {
        if (ArrayUtil.isNullOrEmpty(params)) {
            return;
        }
        for (int i : params) {
            if (i < 0) {
                throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
            }
        }
    }

    public static void checkNumberic(String para) {
        if (!isNumeric(para)) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
    }

    public static boolean checkHarvestFrequency(long lastTime) {
        return (DateUtil.getCurrentTimeMillis() - lastTime) > 1000;
    }

    // 根据玩家注册时间检测持续时间的功能使用
    public static void checkFunctionByLastTime(long para1, int para2) {
        if (DateUtil.plusTime(new Date(para1), TimeUnit.MILLISECONDS, para2).getTime() < DateUtil.getCurrentTimeMillis()) {
            throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        }
    }

    // 根据玩家等级检测功能使用
    public static void checkFunctionByLvl(int para1, int para2) {
        if (para1 < para2) {
            throw new CommonException(ErrorID.SYSTEM_REQUEST_ERROR);
        }
    }

    // 检查num是否在范围内
    public static void checkNumRange(int num, int start, int end) {
        if (num < start || num > end) {
            throw new CommonException(ErrorID.COMMON_PARAM_ERROR);
        }
    }

    // 检查str是否纯数字
    public static boolean isNumeric(String str) {
        return numbericPattern.matcher(str).matches();
    }

//    public static void main(String[] args) {
//        System.out.println(isValidChinaCellNo("16607256672"));
//        System.out.println(isValidRealName("zcq"));
//        System.out.println(isValidChinaCellNo("18186214271"));
//        try {
//            InetAddress inetAddress = InetAddress.getLocalHost();
//            System.out.println(inetAddress.getHostName());
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Checker.isValidNickName("'''abcfed*"));
//        System.out.println(isPunctuation("139 17188840"));
//        System.out.println(isValidChinaCellNo("13917188840"));
//        System.out.println(isNumeric("999"));
//        System.out.println(Checker.isValidAccountName("9e5e8de814276d5e"));
//        int duration = 7200;
//        System.out.print(DateUtil.plusTime(DateUtil.getDateBegin(DateUtil.getCurrentTimestamp()), TimeUnit.SECONDS,
//                ((int) (DateUtil.getElapsedTime(DateUtil.getDateBegin(DateUtil.getCurrentTimestamp()).getTime(),
//                        TimeUnit.SECONDS) / duration) + 1) * duration).getTime());
//        System.out.println(isValidContent("去丫网久游!$%gf大胜大", "垃圾游戏|关门倒闭|还不如回去玩|去久游|去丫网|经营不善|早关早好|破游戏|这鸟游戏|不要充钱|不要充值"));
//        System.out.println(isValidContent("爱德华.等落魄", "垃圾游戏|关门倒闭|还不如回去玩|去久游|去丫网|经营不善|早关早好|破游戏|这鸟游戏|不要充钱|不要充值"));
//        System.out.println(isValidContent("爱德华.等落魄", "垃圾游戏|关门倒闭|还不如回去玩|去久游|去丫网|经营不善|早关早好|破游戏|这鸟游戏|不要充钱|不要充值"));
//        System.out.println(isValidContent("爱德华.等落魄", "垃圾游戏|关门倒闭|还不如回去玩|去久游|去丫网|经营不善|早关早好|破游戏|这鸟游戏|不要充钱|不要充值"));
//    }
}
