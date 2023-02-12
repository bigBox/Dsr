package com.dj.domain.util.math;

import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * 辅助数学算法,组合算法<br>
 * 
 * 
 */
public class MathUtil {
	/**
	 * 组合算法,Cmn从n个数字中选择m个数字<br>
	 * 本程序的思路是开一个数组，其下标表示1到m个数，数组元素的值为1表示其下标<br>
	 * 代表的数被选中，为0则没选中。<br>
	 * 首先初始化，将数组前n个元素置1，表示第一个组合为前n个数。<br>
	 * 然后从左到右扫描数组元素值的“10”组合，找到第一个“10”组合后将其变为<br>
	 * “01”组合，同时将其左边的所有“1”全部移动到数组的最左端。<br>
	 * 当第一个“1”移动到数组的m-n的位置，即n个“1”全部移动到最右端时，就得<br>
	 * 到了最后一个组合。<br>
	 * 例如求5中选3的组合：<br>
	 * 1 1 1 0 0 //1,2,3<br>
	 * 1 1 0 1 0 //1,2,4<br>
	 * 1 0 1 1 0 //1,3,4<br>
	 * 0 1 1 1 0 //2,3,4<br>
	 * 1 1 0 0 1 //1,2,5<br>
	 * 1 0 1 0 1 //1,3,5<br>
	 * 0 1 1 0 1 //2,3,5<br>
	 * 1 0 0 1 1 //1,4,5<br>
	 * 0 1 0 1 1 //2,4,5<br>
	 * 0 0 1 1 1 //3,4,5<br>
	 * 
	 * @param a
	 * @param m
	 * @return
	 */
	public static List<String> combine(int[] a, int m) {
		int n = a.length;
		if (m > n) {
			System.out.println("错误！数组a中只有" + n + "个元素。" + m + "大于" + 2 + "!!!");
			return null;
		}
		List<String> result = new LinkedList<String>();
		byte[] bs = new byte[n];
		// 初始化
		for (int i = 0; i < m; i++) {
			bs[i] = 1;
		}
		boolean flag;
		boolean tempFlag;
		int pos;
		int sum;
		// 首先找到第一个10组合，然后变成01，同时将左边所有的1移动到数组的最左边
		do {
			sum = 0;
			pos = 0;
			tempFlag = true;
			result.add(dump2(bs, a, m));
			for (int i = 0; i < n - 1; i++) {
				if (bs[i] == 1 && bs[i + 1] == 0) {
					bs[i] = 0;
					bs[i + 1] = 1;
					pos = i;
					break;
				}
			}
			// 将左边的1全部移动到数组的最左边
			for (int i = 0; i < pos; i++) {
				if (bs[i] == 1) {
					sum++;
				}
			}
			for (int i = 0; i < pos; i++) {
				if (i < sum) {
					bs[i] = 1;
				} else {
					bs[i] = 0;
				}
			}
			// 检查是否所有的1都移动到了最右边
			for (int i = n - m; i < n; i++) {
				if (bs[i] == 0) {
					tempFlag = false;
					break;
				}
			}
			flag = tempFlag == false;
		} while (flag);
		result.add(dump2(bs, a, m));
		return result;
	}

	private static String dump2(byte[] bs, int[] a, int m) {
		StringBuilder stb = new StringBuilder();
		for (int i = 0; i < bs.length; i++) {
			if (bs[i] == 1) {
				stb.append(a[i] + ",");
			}
		}
		stb.deleteCharAt(stb.length() - 1);
		return stb.toString();
	}

	/**
	 * 将传入的小数保留若干位返回
	 * 
	 * @param number
	 * @param pattern
	 * @return
	 */
	public static double formatDecimal(Double number, String pattern) {
		if (number == null)
			number = 0.0;
		try {
			if (pattern == null || pattern.equals("")) {
				pattern = "000";
			}
			DecimalFormat decimalFormat = new DecimalFormat(pattern);
			return Double.valueOf(decimalFormat.format(number));
		} catch (Exception ex) {
			return -1;
		}
	}

	/**
	 * 获取2数相除的百分比形式
	 * 
	 * @param fenzi 分子
	 * @param fenmu 分母
	 * @param format 格式，如###.####,代表小数点后保留4位
	 * @return
	 */
	public static double getPercentage(int fenzi, int fenmu, String format) {
		return formatDecimal(fenmu == 0 ? 0 : fenzi * 1.0 / fenmu * 100, format);
	}

	/**
	 * 获取2数相除的百分比形式
	 * 
	 * @param fenzi  分子
	 * @param fenmu  分母
	 * @param format  格式，如###.####,代表小数点后保留4位
	 * @return
	 */
	public static double getPercentage(long fenzi, int fenmu, String format) {
		return formatDecimal(fenmu == 0 ? 0 : fenzi * 1.0 / fenmu * 100, format);
	}

	/**
	 * 获取2数相除的百分比形式
	 * 
	 * @param fenzi   分子
	 * @param fenmu  分母
	 * @param format   格式，如###.####,代表小数点后保留4位
	 * @return
	 */
	public static double getPercentage(double fenzi, int fenmu, String format) {
		return formatDecimal(fenmu == 0 ? 0 : fenzi * 1.0 / fenmu * 100, format);
	}

	/**
	 * 获取两数相除的商，如果分母是0，返回商为0
	 * 
	 * @param fenzi
	 * @param fenmu
	 * @return
	 */
	public static double getShang(long fenzi, long fenmu) {
		return MathUtil.formatDecimal(fenmu == 0 ? 0 : fenzi * 1.0 / fenmu,"###.####");
	}

	public static double getShang(long fenzi, long fenmu, String format) {
		return MathUtil.formatDecimal(fenmu == 0 ? 0 : fenzi * 1.0 / fenmu, format);
	}

	/**
	 * 获取两书相除的商，如果分母是0，返回商为0
	 * 
	 * @param fenzi
	 * @param fenmu
	 * @return
	 */
	public static double getShang(double fenzi, long fenmu) {
		return MathUtil.formatDecimal(fenmu == 0 ? 0 : fenzi / fenmu,"###.####");
	}

	public static double getShang(double fenzi, long fenmu, String format) {
		return MathUtil.formatDecimal(fenmu == 0 ? 0 : fenzi / fenmu, format);
	}

	public static float range(float base, float min, float max) {
		if (base <= min) {
			return min;
		} else if (base >= max) {
			return max;
		}
		return base;
	}

	public static int sigma(int start, int end, int prop) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += prop;
		}
		return sum;
	}

//	public static void main(String[] args) {
//		int[] num = new int[] { 5, 1, 7, 4, 2 };
//		int m = 3;
//		Arrays.sort(num);
//		long l = System.currentTimeMillis();
//		List<String> list = combine(num, m);
//		for (String string : list) {
//			System.out.println(string);
//		}
//		System.out.println("C" + num.length + m + "组合结果" + list.size());
//		System.out.println(System.currentTimeMillis() - l);
//		System.out.println((float) (MathUtil.formatDecimal(1000000.898, "0.00")));
//	}
}
