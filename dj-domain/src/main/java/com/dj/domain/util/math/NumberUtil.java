package com.dj.domain.util.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Description: 格式化显示数值
 */
@SuppressWarnings("deprecation")
public class NumberUtil {
	private final static String PATTEN1 = "000";

	/**
	 * 字符串转整数，默认值为0
	 * 
	 * @param num String
	 * @return int
	 */

	public static int parseInt(String num) {
		return parseInt(num, 0);
	}

	/**
	 * 字符串转整数，默认值为参数
	 * 
	 * @param num           String
	 * @param defaultValues int
	 * @return int
	 */
	public static int parseInt(String num, int defaultValues) {
		if (num == null || num.equals("")) {
			return defaultValues;
		}
		try {
			return Integer.parseInt(num);
		} catch (Exception ex) {
			return defaultValues;
		}
	}

	/**
	 * 字符串转整数，默认值为参数
	 * 
	 * @param num           String
	 * @param defaultValues int
	 * @return int
	 */
	public static int parseInt(Object num, int defaultValues) {
		if (num == null) {
			return defaultValues;
		}
		return parseInt(num.toString(), defaultValues);
	}

	public static long parseLong(String num) {
		return parseLong(num, 0);
	}

	public static long parseLong(String num, long defaultValues) {
		if (num == null || num.equals("")) {
			return defaultValues;
		}
		try {
			return Long.parseLong(num);
		} catch (Exception ex) {
			return defaultValues;
		}
	}

	public static short parseShort(String num) {
		return parseShort(num, (short) 0);
	}

	public static short parseShort(String num, short defaultValues) {
		if (num == null || num.equals("")) {
			return defaultValues;
		}
		try {
			return Short.parseShort(num);
		} catch (Exception ex) {
			return defaultValues;
		}
	}

	public static float parseFloat(String num) {
		return parseFloat(num, 0);
	}

	public static boolean contains(int[] array, int values) {
		if (array == null || array.length < 1)
			return false;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == values)
				return true;
		}
		return false;
	}

	/**
	 * 字符串转浮点数，默认值为参数
	 * 
	 * @param num           String
	 * @param defaultValues float
	 * @return float
	 */
	public static float parseFloat(String num, float defaultValues) {
		if (num == null || num.equals("")) {
			return defaultValues;
		}
		try {
			return Float.parseFloat(num);
		} catch (Exception ex) {
			return defaultValues;
		}
	}

	/**
	 * 格式化显示实数
	 * 
	 * @param number  float
	 * @param pattern String
	 * @return String
	 */
	public static String formatDecimal(Float number, String pattern) {
		if (number == null)
			number = 0f;
		try {
			if (pattern == null || pattern.equals("")) {
				pattern = PATTEN1;
			}
			DecimalFormat decimalFormat = new DecimalFormat(pattern);
			return decimalFormat.format(number);
		} catch (Exception ex) {
			return "---";
		}
	}

	/**
	 * 格式化显示数字
	 * 
	 * @param number  int
	 * @param pattern String
	 * @return String
	 */
	public static String formatDecimal(int number, String pattern) {
		try {
			if (pattern == null || pattern.equals("")) {
				pattern = PATTEN1;
			}
			DecimalFormat decimalFormat = new DecimalFormat(pattern);
			return decimalFormat.format(number);
		} catch (Exception ex) {
			return "---";
		}
	}

	/**
	 * 显示百分率参数
	 * 
	 * @param originValue :原数值显示；
	 * @param base        ：基数；默认是100；
	 * @return
	 */
	public static float getFloatPercentValue(int originValue, int base) {
		java.math.BigDecimal denominator = BigDecimal.valueOf(base);
		java.math.BigDecimal numerator = BigDecimal.valueOf(originValue);
		numerator = numerator.divide(denominator, 6, BigDecimal.ROUND_HALF_DOWN);
		return numerator.floatValue();
	}

	/**
	 * 显示百分率参数
	 * 
	 * @param originValue :原数值显示；
	 * @param base        ：基数；默认是100；
	 * @return
	 */
	public static float getFloatPercentValue(float originValue, int base) {
		java.math.BigDecimal denominator = new java.math.BigDecimal(base);
		java.math.BigDecimal numerator = new java.math.BigDecimal(originValue);
		numerator = numerator.divide(denominator, 6, BigDecimal.ROUND_HALF_DOWN);
		return numerator.floatValue();
	}

	/**
	 * 返回指定位数上的数值
	 * 
	 * @param original
	 * @param position
	 * @return
	 */
	public static int getValueByPosition(int original, int position) {
		String result = String.valueOf(original);
		if (position <= 0)
			return 0;
		if (String.valueOf(original).length() >= position) {
			StringBuilder tmp = new StringBuilder(result);
			result = tmp.reverse().substring(position - 1, position);
		} else {
			return 0;
		}
		return Integer.valueOf(result);
	}

	/**
	 * 显示金额用逗号分隔 如-32521.325显示效果为：-32,521.325
	 */
	public static String moneyShow(String moneyS) {
		String[] money = moneyS.split("\\.");
		StringBuilder sb = new StringBuilder();
		String moneyString = null;
		if (money[0].startsWith("-")) {
			sb.append("-");
			moneyString = money[0].substring(1);
		} else {
			moneyString = money[0];
		}
		int a = moneyString.length() / 3;
		if (a > 0) {
			sb.append(moneyString, 0, moneyString.length() - 3 * a);
			for (int i = a; i > 0; i--) {
				if (sb.length() > 0 && !(sb.length() == 1 && sb.toString().startsWith("-"))) {
					sb.append(",");
				}
				sb.append(moneyString, moneyString.length() - 3 * i, moneyString.length() - 3 * (i - 1));
			}
		} else {
			sb.append(moneyString);
		}
		if (money.length > 1) {
			return sb.toString() + "." + money[1];
		}
		return sb.toString();
	}

	// 显示比例
	public static String showRate(float upvalue, float downvalue) {
		if (downvalue == 0) {
			return "0%";
		}
		return NumberUtil.formatDecimal(upvalue * 100 / downvalue, "###.##") + "%";
	}

	/**
	 * 限定 l 必须大于等于0
	 * 
	 * @param l
	 * @return
	 */
	public static long getN(long l) {
		if (l < 0) {
			return 0;
		}
		return l;
	}

	/**
	 *
	 * @param bigInteger
	 * @return
	 */
	public static int getInt(BigInteger bigInteger) {
		return bigInteger == null ? 0 : bigInteger.intValue();
	}

	/***
	 * 值是否为1
	 * 
	 * @param bigInteger
	 * @return
	 */
	public static boolean isEquals1(BigInteger bigInteger) {
		return bigInteger != null && bigInteger.intValue() == 1;
	}

	/**
	 * 值是否为 0
	 * 
	 * @param bigInteger
	 * @return
	 */
	public static boolean isEquals0(BigInteger bigInteger) {
		return bigInteger != null && bigInteger.intValue() == 0;
	}

	/**
	 * 如果参数是一个null值， 则返回0 ， 否则返回该值
	 * 
	 * @param integer
	 * @return
	 */
	public static int nullToZero(Integer integer) {
		return integer == null ? 0 : integer;
	}

	/**
	 * 获取num 在 list 里面最接近的那个数值
	 * 
	 * @param num
	 * @param list
	 * @return
	 */
	public static int getNearestNumber(int num, List<BigInteger> list) {
		if (list == null || list.isEmpty()) {
			return -1;
		}
		int closed = -1;
		int result = -1;
		for (BigInteger bigInteger : list) {
			int t = bigInteger.intValue();
			int a = Math.abs(num - t);
			if (closed == -1) {
				result = t;
				closed = a;
			} else {
				if (a < closed) {
					closed = a;
					result = t;
				}
			}
		}
		return result;
	}

//	public static void main(String[] args) {
//		System.out.println(formatDecimal((float) 1019999.5335, ".00"));
//	}
}
