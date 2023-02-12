package com.dj.domain.util.collection;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

//import org.apache.commons.collections.CollectionUtils;
//import org.apache.commons.collections.Transformer;

import com.google.common.collect.ImmutableList;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;

/**
 * list 的工具类
 *
 */
@SuppressWarnings({"unchecked","deprecation"})
public class ListUtil {

	/**
	 *	对一个list 进行封装， 简化一些操作和代码内容而已。。
	 * <p>
	 *	持续连接的list
	 */
	public static class SequentList<T> {
		private List<T> list;

		public SequentList(List<T> list) {
			this.list = list;
		}

		public SequentList<T> add(T t) {
			list.add(t);
			return this;
		}

		public List<T> realObj() {
			return this.list;
		}
	}

	public static <V> ImmutableList<V> listToImmutableList(List<V> list) {
		if (list == null) {
			return null;
		}
		ImmutableList.Builder<V> builder = ImmutableList.builder();
		for (V v : list) {
			builder.add(v);
		}
		return builder.build();
	}

	/**
	 * 
	 *	转换类型用的
	 */
	public interface ListTypeConveter<T, X> {
		T convert(X obj);
	}

	/**
	 * new 一个 持续连接的list
	 * 
	 * @param list
	 * @return
	 */
	public static <T> SequentList<T> newSequentList(List<T> list) {
		return new SequentList<>(list);
	}

	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static <T> List<T> newList(T obj) {
		List<T> list = new ArrayList<>();
		list.add(obj);
		return list;
	}

	/**
	 *	如果传入的参数是null ，则会new 一个ArrayList 并返回, 否则的话， 返回原列表
	 * <p>
	 *	无论怎么样, t(not null) 总是会被添加到列表中
	 * 
	 * @param list
	 * @param t
	 * @param <T>
	 * @see java.util.ArrayList
	 * @return
	 */
	public static <T> List<T> checkList(List<T> list, T t) {
		if (list == null) {
			list = new ArrayList<>();
		}
		if (t != null) {
			list.add(t);
		}
		return list;
	}

	/**
	 *	如果转换出来的对象是一个null, 则会无视
	 * 
	 * @param list
	 * @param conveter
	 * @return
	 */
	public static <T, X> List<T> convertType(List<X> list, ListTypeConveter<T, X> conveter) {
		if (list == null) {
			return null;
		}
		List<T> resultList = new ArrayList<>(list.size());
		for (X item : list) {
			T t = conveter.convert(item);
			if (t != null) {
				resultList.add(t);
			}
		}
		return resultList;
	}

	// 将StringList转为intList
	public static List<Integer> ConvertToIntegerList(List<String> inList) {
		List<Integer> iList = new LinkedList<Integer>();
		if (inList != null) {
			CollectionUtils.collect(inList, new Transformer() {
				public java.lang.Object transform(java.lang.Object input) {
					return new Integer((String) input);
				}
			}, iList);
		}
		return iList;
	}

	// 将StringList转为longList
	public static List<Long> ConvertToLongList(List<String> inList) {
		List<Long> iList = new LinkedList<Long>();
		if (inList != null) {
			CollectionUtils.collect(inList, new Transformer() {
				public java.lang.Object transform(java.lang.Object input) {
					return new Long((String) input);
				}
			}, iList);
		}
		return iList;
	}

	/**
	 *	将逗号分隔的字符串转成 List
	 * 
	 * @param commaString
	 * @return 参数null则返回空列表
	 */
	public static final List<Integer> commaStringToList(String commaString) {
		List<Integer> list = new LinkedList<Integer>();
		if (commaString != null && !commaString.trim().isEmpty()) {
			for (String id : commaString.split(",")) {
				list.add(Integer.parseInt(id));
			}
		}
		return list;
	}

	public static final List<Integer> commaStringToList(String commaString, String splitStr) {
		List<Integer> list = new LinkedList<Integer>();
		if (commaString != null && !commaString.trim().isEmpty()) {
			for (String id : commaString.split(splitStr)) {
				list.add(Integer.parseInt(id));
			}
		}
		return list;
	}

	public static final List<Long> commaStringToLongList(String commaString, String splitStr) {
		List<Long> list = new LinkedList<Long>();
		if (commaString != null && !commaString.trim().isEmpty()) {
			for (String id : commaString.split(splitStr)) {
				list.add(Long.parseLong(id));
			}
		}
		return list;
	}
	/**
	 *	将逗号分隔的字符串转成 List
	 * 
	 * @return 参数null则返回空列表
	 */
	public static final List<Long> commaStringToLongList(String commaString) {
		List<Long> list = new LinkedList<Long>();
		if (commaString != null && !commaString.trim().isEmpty()) {
			for (String id : commaString.split(",")) {
				list.add(Long.parseLong(id));
			}
		}
		return list;
	}

	/**
	 *	将逗号分隔的字符串转成 List
	 * 
	 * @return 参数null则返回空列表
	 */
	public static final List<String> commaStringToStringList(String commaString) {
		List<String> list = new LinkedList<String>();
		if (commaString != null && !commaString.trim().isEmpty()) {
			for (String id : commaString.split(",")) {
				list.add(id);
			}
		}
		return list;
	}
	

	/**
	 *	将List转成 逗号分隔的字符串
	 * 
	 * @return 空列表则返回null
	 */
	public static final String listToCommaString(List<Integer> list) {
		String commaString = null;
		if (list != null && !list.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			for (int id : list) {
				sb.append(id).append(",");
			}
			commaString = sb.substring(0, sb.length() - 1);
		}
		return commaString;
	}

	/**
	 *	将List转成 逗号分隔的字符串
	 * 
	 * @return 空列表则返回null
	 */
	public static final String listLongToCommaString(List<Long> list) {
		String commaString = null;
		if (list != null && !list.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			for (long l : list) {
				sb.append(l).append(",");
			}
			commaString = sb.substring(0, sb.length() - 1);
		}
		return commaString;
	}
	/**
	 *	将List转成 逗号分隔的字符串
	 * 
	 * @return 空列表则返回null
	 */
	public static final String listStringToCommaString(List<String> list) {
		String commaString = null;
		if (list != null && !list.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			for (String s : list) {
				sb.append(s).append(",");
			}
			commaString = sb.substring(0, sb.length() - 1);
		}
		return commaString;
	}

	/**
	 *	将list以split分割拼成字符串
	 */
	public static final String listToStringWithSplit(List<String> list, String split) {
		String commaString = null;
		if (list != null && !list.isEmpty()) {
			StringBuffer sb = new StringBuffer();
			for (String s : list) {
				sb.append(s).append(split);
			}
			commaString = sb.substring(0, sb.length() - split.length());
		}
		return commaString;
	}

	/**
	 *	将整形数组转成字符数组 忽略null
	 */
	public static final List<String> toStringList(List<Integer> list) {
		List<String> stringList = new LinkedList<String>();
		for (Integer i : list) {
			stringList.add(Integer.toString(i));
		}
		return stringList;
	}

	/**
	 *	将集合转化为LIST
	 * 
	 * @return 返回的一个全新的list
	 */
	public static final <T> List<T> toList(Collection<T> set) {
		List<T> list = new LinkedList<T>();
		for (T i : set) {
			list.add(i);
		}
		return list;
	}

	/**
	 *	去除列表中重复项
	 */
	public static final List<Integer> distinctList(List<Integer> list) {
		HashSet<Integer> h = new HashSet<Integer>(list);
		list.clear();
		list.addAll(h);
		return list;
	}

	/**
	 *	队列比较
	 * 
	 * @param <T>
	 * @param a
	 * @param b
	 * @return
	 */
	public static <T extends Comparable<T>> boolean compare(List<T> a, List<T> b) {
		if (a.size() != b.size())
			return false;
		Collections.sort(a);
		Collections.sort(b);
		for (int i = 0; i < a.size(); i++) {
			if (!a.get(i).equals(b.get(i)))
				return false;
		}
		return true;
	}

	/**
	 *	包含方法
	 * 
	 * @param list
	 * @param val
	 * @return
	 */
	public static boolean contains(List<BigInteger> list, int val) {
		if (list == null || list.isEmpty()) {
			return false;
		}
		for (BigInteger bigInteger : list) {
			if (bigInteger.intValue() == val) {
				return true;
			}
		}
		return false;
	}

	/**
	 *	检测这个列表里面是否包含了某个元素
	 * 
	 * @param list
	 * @param obj
	 * @param <T>
	 * @return
	 */
	public static <T> boolean checkContains(List<T> list, T obj) {
		if (list == null || list.isEmpty()) {
			return false;
		}
		return list.contains(obj);
	}

	/**
	 *	检查字符串是否包含字符串列表中的某个
	 * @param str
	 * @param list
	 * @return
	 */
	public static boolean checkContains(String str, List<String> list) {
		if (str == null || list == null || list.isEmpty()) {
			return false;
		}
		for (String s : list) {
			if (str.contains(s)) {
				return true;
			}
		}
		return false;
	}

	/**
	 *	转数组
	 * 
	 * @param list
	 * @return
	 */
	public static int[] toArray(List<BigInteger> list) {
		if (list == null || list.isEmpty()) {
			return new int[0];
		}
		int[] array = new int[list.size()];
		int index = 0;
		for (BigInteger item : list) {
			array[index++] = item.intValue();
		}
		return array;
	}

	/**
	 * xx. xx
	 * 
	 * @param strings
	 * @param sp   连接符
	 * @return
	 */
	public static String join(String[] strings, String sp) {
		if (strings == null || strings.length <= 0) {
			return "";
		}
		StringBuilder stringBuilder = new StringBuilder();
		boolean flag = false;
		for (String item : strings) {
			if (flag) {
				stringBuilder.append(sp);
			}
			stringBuilder.append(item);
			flag = true;
		}
		return stringBuilder.toString();
	}

	/**
	 *	计算一个list的和
	 * 
	 * @param list
	 * @return
	 */
	public static int sum(List<Integer> list) {
		if (list == null || list.isEmpty()) {
			return 0;
		}
		int total = 0;
		for (Integer item : list) {
			if (item != null) {
				total += item;
			}
		}
		return total;
	}

	/**
	 *
	 * @param list
	 * @return
	 */
	public static int max(List<BigInteger> list) {
		if (list == null || list.isEmpty()) {
			return 0;
		}
		int max = list.get(0).intValue();
		for (BigInteger bigInteger : list) {
			if (bigInteger.intValue() > max) {
				max = bigInteger.intValue();
			}
		}
		return max;
	}

	public static <T> boolean isEmptyOrNull(List<T> list) {
		return list == null || list.isEmpty();
	}
}
