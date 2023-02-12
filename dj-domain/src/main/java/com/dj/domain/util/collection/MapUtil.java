package com.dj.domain.util.collection;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.dj.domain.util.GsonUtil;
import com.dj.domain.util.inf.IArgumentRunnable;
import com.dj.domain.util.inf.IDataProvider;
import com.dj.domain.util.math.RandomUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * map 的工具类
 */
public class MapUtil {

	/**
	 * 
	 * @param k
	 * @param v
	 * @return
	 */
	public static <K, V> Map<K, V> newSingleEleMap(K k, V v) {
		Map<K, V> map = Maps.newHashMapWithExpectedSize(1);
		map.put(k, v);
		return map;
	}

	/**
	 * 将Map转化为字符索引 符合JSON规范
	 */
	public static final <T> Map<String, T> toStringIndex(Map<Object, T> map) {
		Map<String, T> newMap = Maps.newHashMapWithExpectedSize(map.size());
		for (Entry<Object, T> entry : map.entrySet()) {
			Object key = entry.getKey();
			if (key instanceof String) {
				break;
			}
			newMap.put(String.valueOf(key), entry.getValue());
		}
		return newMap;
	}

	/**
	 * 合并列表中相同的项 并增加计数 返回 Map: id=>num
	 */
	public static final Map<Integer, Integer> mergeList(List<Integer> list) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		if (list != null && !list.isEmpty()) {
			for (int id : list) {
				Integer num = map.get(id);
				num = num == null ? 1 : num + 1;
				map.put(id, num);
			}
		}
		return map;
	}

	/**
	 * 构造Map
	 */
	@SuppressWarnings("unchecked")
	public static final <K, V> Map<K, V> asMap(Object... keyValues) {
		Map<K, V> map = Maps.newHashMapWithExpectedSize(keyValues.length / 2);
		boolean isKey = true;
		K key = null;
		for (Object item : keyValues) {
			if (isKey) {
				key = (K) item;
				isKey = false;
			} else {
				map.put(key, (V) item);
				isKey = true;
			}
		}
		return map;
	}

	/**
	 * 把一个集合转换成map , 返回map 是无序的
	 * 
	 * @param collection
	 * @param            <K>
	 * @param            <V>
	 * @return
	 */
	public static final <K, V> Map<K, V> asMap(Collection<V> collection, IDataProvider<K, V> keyGetter) {
		if (collection == null) {
			return null;
		}
		Map<K, V> map = new HashMap<>(collection.size());
		for (V v : collection) {
			K k = keyGetter.getData(v);
			map.put(k, v);
		}
		return map;
	}

	/**
	 * 获取子map 若为空 则新建
	 */
	public static final <K1, K2, V> Map<K2, V> getSubMap(Map<K1, HashMap<K2, V>> map, K1 key) {
		HashMap<K2, V> subMap = map.get(key);
		if (subMap == null) {
			subMap = new HashMap<K2, V>();
			map.put(key, subMap);
		}
		return subMap;
	}

	/**
	 * 增加某个key下value的值 无则插入
	 */
	public static final <K> void increaseMapValue(Map<K, Integer> map, K key, int inc) {
		if (inc > 0) {
			Integer value = map.get(key);
			value = (value == null) ? inc : value + inc;
			map.put(key, value);
		}
	}

	/**
	 * 队列比较
	 * 
	 * @param   <T>
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
	 * 积累值
	 * <p>
	 * 如果map 里面如果有这个key 对应的值， 则给累加起来
	 * 
	 * @param map
	 * @param key
	 * @param value
	 */
	public static void fundInt(Map<Integer, Integer> map, BigInteger key, BigInteger value) {
		fundInt(map, key.intValue(), value.intValue());
	}

	/**
	 * 抽回值
	 * 
	 * @param map
	 * @param key
	 * @param value
	 */
	public static void defundInt(Map<Integer, Integer> map, BigInteger key, BigInteger value) {
		defundInt(map, key.intValue(), value.intValue());
	}

	public static void defundInt(Map<Integer, Integer> map, int key, int value) {
		fundInt(map, key, value * -1);
	}

	/**
	 * 积累值
	 * <p>
	 * 如果map 里面如果有这个key 对应的值， 则给累加起来
	 * 
	 * @param map
	 * @param key
	 * @param value
	 */
	public static void fundInt(Map<Integer, Integer> map, int key, int value) {
		Integer oldValue = map.get(key);
		if (oldValue == null) {
			map.put(key, value);
		} else {
			map.put(key, oldValue + value);
		}
	}

	public static void fundInt(Map<Integer, Long> map, int key, long value) {
		Long oldValue = map.get(key);
		if (oldValue == null) {
			map.put(key, value);
		} else {
			map.put(key, oldValue + value);
		}
	}

	public static void fundString(Map<String, Long> map, String key, long value) {
		Long oldValue = map.get(key);
		if (oldValue == null) {
			map.put(key, value);
		} else {
			map.put(key, oldValue + value);
		}
	}

	public static void fundStringInt(Map<String, Integer> map, String key, int value) {
		Integer oldValue = map.get(key);
		if (oldValue == null) {
			map.put(key, value);
		} else {
			map.put(key, oldValue + value);
		}
	}

	public static void fundDouble(Map<String, Double> map, String key, double value) {
		Double oldValue = map.get(key);
		if (oldValue == null) {
			map.put(key, value);
		} else {
			map.put(key, oldValue + value);
		}
	}

	/**
	 * 把 subMap 的值累加到 map 上面
	 * 
	 * @param map
	 * @param subMap
	 */
	public static void fundInt(Map<Integer, Integer> map, Map<Integer, Integer> subMap) {
		for (Entry<Integer, Integer> item : subMap.entrySet()) {
			Integer integer = map.get(item.getKey());
			if (integer == null) {
				map.put(item.getKey(), item.getValue());
			} else {
				map.put(item.getKey(), item.getValue() + integer);
			}
		}
	}

	/**
	 * 把 subMap 的值累加到 map 上面
	 * 
	 * @param map
	 * @param subMap
	 */
	public static void fundIntLongMap(Map<Integer, Long> map, Map<Integer, Long> subMap) {
		for (Entry<Integer, Long> item : subMap.entrySet()) {
			Long longValue = map.get(item.getKey());
			if (longValue == null) {
				map.put(item.getKey(), item.getValue());
			} else {
				map.put(item.getKey(), item.getValue() + longValue);
			}
		}
	}

	/**
	 * 将一个list 转换成map , 需要提供一个生成id的方法
	 * 
	 * @param list
	 * @param convert
	 * @return
	 */
	public static <K, V> ImmutableMap<K, V> listToImmMap(List<V> list, IDataProvider<K, V> convert) {
		return listToImmMap(list, convert, true);
	}

	/**
	 * 将一个list 转换成map , 需要提供一个生成id的方法
	 * 
	 * @param list
	 * @param convert
	 * @param ignoreNull 忽略null 值
	 * @return
	 */
	public static <K, V> ImmutableMap<K, V> listToImmMap(List<V> list, IDataProvider<K, V> convert, boolean ignoreNull) {
		if (list == null || convert == null) {
			return null;
		}
		ImmutableMap.Builder<K, V> builder = ImmutableMap.builder();
		for (V v : list) {
			K k = convert.getData(v);
			if (ignoreNull && k == null) {
				continue;
			}
			builder.put(k, v);
		}
		return builder.build();
	}

	/**
	 * @Description 将List转化为ImmutableMap<K, List<V>>复合数据结构
	 * @param list
	 * @param convert
	 * @return ImmutableMap<K,List<V>>
	 */
	public static <K, V> ImmutableMap<K, ImmutableList<V>> listToImmMapWithList(List<V> list, IDataProvider<K, V> convert) {
		if (list == null || convert == null) {
			return null;
		}
		Map<K, ImmutableList.Builder<V>> tmpMap = Maps.newHashMap();
		for (V v : list) {
			if (!tmpMap.containsKey(convert.getData(v))) {
				tmpMap.put(convert.getData(v), ImmutableList.builder());
			}
			tmpMap.get(convert.getData(v)).add(v);
		}
		ImmutableMap.Builder<K, ImmutableList<V>> tmpMapBuilder = ImmutableMap.builder();
		for (Map.Entry<K, ImmutableList.Builder<V>> entry : tmpMap.entrySet()) {
			tmpMapBuilder.put(entry.getKey(), entry.getValue().build());
		}
		return tmpMapBuilder.build();
	}

	/**
	 * @Title listToImmMapWithMap
	 * @Description 将List转化为ImmutableMap<K, Map<X, V>>复合数据结构
	 * @param list
	 * @param convert
	 * @param convert2
	 * @return ImmutableMap<K,Map<X,V>>
	 */
	public static <K, V, X> ImmutableMap<K, ImmutableMap<X, V>> listToImmMapWithMap(List<V> list, IDataProvider<K, V> convert, IDataProvider<X, V> convert2) {
		if (list == null || convert == null) {
			return null;
		}
		Map<K, ImmutableMap.Builder<X, V>> tmpMap = Maps.newHashMap();
		for (V v : list) {
			if (!tmpMap.containsKey(convert.getData(v))) {
				tmpMap.put(convert.getData(v), ImmutableMap.builder());
			}
			tmpMap.get(convert.getData(v)).put(convert2.getData(v), v);
		}
		ImmutableMap.Builder<K, ImmutableMap<X, V>> tmpMapBuilder = ImmutableMap.builder();
		for (Map.Entry<K, ImmutableMap.Builder<X, V>> entry : tmpMap.entrySet()) {
			tmpMapBuilder.put(entry.getKey(), entry.getValue().build());
		}
		return tmpMapBuilder.build();
	}

	public static <K, V, X, Y> ImmutableMap<K, Map<X, Map<Y, V>>> listToImmMapWithSubMap(List<V> list, IDataProvider<K, V> convert, IDataProvider<X, V> convert2, IDataProvider<Y, V> convert3) {
		if (list == null || convert == null) {
			return null;
		}
		Map<K, Map<X, Map<Y, V>>> tmpMap = Maps.newHashMap();
		for (V v : list) {
			if (!tmpMap.containsKey(convert.getData(v))) {
				tmpMap.put(convert.getData(v), Maps.newHashMap());
			}
			if (!tmpMap.get(convert.getData(v)).containsKey(convert2.getData(v))) {
				tmpMap.get(convert.getData(v)).put(convert2.getData(v), Maps.newHashMap());
			}
			if (!tmpMap.get(convert.getData(v)).get(convert2.getData(v)).containsKey(convert3.getData(v))) {
				tmpMap.get(convert.getData(v)).get(convert2.getData(v)).put(convert3.getData(v), v);
			}
		}
		return ImmutableMap.copyOf(tmpMap);
	}

	/**
	 * 对这个map的所有key进行求和
	 * 
	 * @param map
	 * @return
	 */
	public static int sumMapKeys(Map<Integer, ?> map) {
		if (map == null || map.isEmpty()) {
			return 0;
		}
		return map.keySet().stream().reduce(Integer::sum).orElse(0);
	}

	/**
	 * 对所有的 值进行求和
	 * 
	 * @param map
	 * @return
	 */
	public static int sumMapValues(Map<?, Integer> map) {
		if (map == null || map.isEmpty()) {
			return 0;
		}
		int count = 0;
		for (Integer item : map.values()) {
			if (item != null) {
				count += item;
			}
		}
		return count;
	}

	public static long sumMapLongValues(Map<?, Long> map) {
		if (map == null || map.isEmpty()) {
			return 0;
		}
		long count = 0;
		for (Long item : map.values()) {
			if (item != null) {
				count += item;
			}
		}
		return count;
	}

	/**
	 * 将map 转换成邮件需要的字符串形式。。。
	 * <p>
	 * 我当初为啥要把附件做成这样， 而不是直接是一个map ...
	 * <p>
	 * !!! 本方法在处理代金卷的时候会 除以100 !!!
	 * 
	 * @param map
	 * @param lpId 代金卷的id/ 本方法在处理代金卷的时候会 除以100
	 * @return
	 */
	public static String[] mapToMailAttachments(Map<Integer, Integer> map, int lpId) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		String[] strings = new String[map.size()];
		int index = 0;
		for (Entry<Integer, Integer> item : map.entrySet()) {
			if (lpId == item.getKey()) {
				// 代金券， / 100
				strings[index++] = String.format("%d:%.2f", item.getKey(), item.getValue() / 100.0F);
			} else {
				strings[index++] = String.format("%d:%d", item.getKey(), item.getValue());
			}
		}
		return strings;
	}

	/**
	 * 清除map , 但是保留一个元素
	 * 
	 * @param map
	 * @param k   被排除的元素(不会清理的元素)
	 */
	public static <K, V> void clearExcept(Map<K, V> map, K k) {
		if (map == null || map.isEmpty()) {
			return;
		}
		Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<K, V> entry = iterator.next();
			if ((k == null && entry.getKey() == null) || (k != null && k.equals(entry.getKey()))) {
				continue;
			}
			iterator.remove();
		}
	}

	/**
	 * 移动迭代器
	 * 
	 * @param iterator
	 * @param target   要移动到的位置
	 */
	public static boolean moveIterator(Iterator<?> iterator, int target) {
		int i = 0;
		target--;
		while (i++ < target) {
			if (!iterator.hasNext()) {
				return false;
			}
			iterator.next();
		}
		return iterator.hasNext();
	}

	/**
	 * 从map中获取指定的key对应的值， 如果该key不存在，则返回0
	 * 
	 * @param map
	 * @param key
	 * @return
	 */
	public static int getIntValue(Map<Integer, Integer> map, int key) {
		Integer integer = map.get(key);
		return integer == null ? 0 : integer;
	}

	public static long getLongValue(Map<Integer, Long> map, int key) {
		Long l = map.get(key);
		return l == null ? 0 : l;
	}

	public static Map<String, String> mapStringToMap(String str) {
		String[] strs = str.split(",");
		Map<String, String> map = new HashMap<String, String>();
		for (String string : strs) {
			String key = string.split("=")[0];
			String value = string.split("=")[1];
			map.put(key, value);
		}
		return map;
	}
	public static Map<Integer, Integer> mapStringToMap1(String str) {
		String[] strs = str.split(";");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (String string : strs) {
			String[] arr = string.split("-");
			String key = arr[0];
			String value = arr[1];
			map.put(Integer.parseInt(key), Integer.parseInt(value));
		}
		return map;
	}
	
//	public static void main(String[] args) {
////		String str = "{\"540030001\":2}";
////		System.out.println(GsonUtil.fromJson(str, Map.class));
//
//		Map<Integer, Integer> map = Maps.newHashMap();
//		map.put(501, 50);
//		map.put(301, 30);
//		map.put(101, 10);
//		map.put(601, 60);
//		map.put(11, 1);
//		map.put(401, 40);
//		map = sortMapByValues(map);
//		System.out.println(map.toString());
//	}
	
	public static Map<Integer, Integer> stringToMap(String str) {
		String[] strs = str.split(",");
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (String string : strs) {
			String[] arr = string.split(":");
			String key = arr[0];
			String value = arr[1];
			map.put(Integer.parseInt(key), Integer.parseInt(value));
		}
		return map;
	}

	public static Map<Integer, Integer> stringToMap(String str,String split1,String split2) {
		String[] strs = str.split(split1);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (String string : strs) {
			String[] arr = string.split(split2);
			String key = arr[0];
			String value = arr[1];
			map.put(Integer.parseInt(key), Integer.parseInt(value));
		}
		return map;
	}
	/**
	 * 把map 转换成字符串
	 * 
	 * @param map
	 * @return
	 */
	public static String mapToString(Map<Integer, Integer> map) {
		StringBuilder builder = new StringBuilder();
		if (map != null && map.size() > 0) {
			for (Entry<Integer, Integer> entry : map.entrySet()) {
				builder.append(entry.getKey());
				builder.append("-");
				builder.append(entry.getValue());
				builder.append(";");
			}
			builder.setLength(builder.length() - 1);
		}
		return builder.toString();
	}

	/**
	 * 准对 map 的 key做一些行为
	 * 
	 * @param map
	 * @param k
	 * @param create
	 * @param work
	 * @param <K>
	 * @param <V>
	 * @return v 值
	 */
	public static <K, V> V opr(Map<K, V> map, K k, IDataProvider<V, K> create, IArgumentRunnable<V> work) {
		if (map == null) {
			return null;
		}
		V v = map.get(k);
		if (v == null) {
			v = create.getData(k);
			map.put(k, v);
		}
		if (work != null) {
			work.run(v);
		}
		return v;
	}

	/**
	 * 从map中随机一个值
	 * 
	 * @param map
	 * @param <K>
	 * @param <V>
	 * @return
	 */
	public static <K, V> V randomValue(Map<K, V> map) {
		if (map.isEmpty()) {
			return null;
		}
		int the = RandomUtil.nextInt(map.size());
		int i = 0;
		for (V v : map.values()) {
			if (i++ == the) {
				return v;
			}
		}
		return null;
	}

	/**
	 * 将json转成map且与paramMap想加
	 * 
	 * @param str
	 * @param paramMap
	 * @return
	 */
	public static Map<Integer, Integer> updateMapType(String str, Map<Integer, Integer> paramMap) {
		@SuppressWarnings("unchecked")
		Map<String, Double> tempMap = GsonUtil.fromJson(str, Map.class);
		for (String key : tempMap.keySet()) {
			MapUtil.fundInt(paramMap, Integer.parseInt(key), tempMap.get(key).intValue());
		}
		return paramMap;
	}

	/**
	 * 根据value获得key
	 * 
	 * @param value
	 * @param paramMap
	 * @return
	 */
	public static String getValueByKey(String value, Map<String, String> paramMap) {
		for (Entry<String, String> entry : paramMap.entrySet()) {
			if (entry.getValue().equals(value)) {
				return entry.getKey();
			}
		}
		return null;
	}

	/**
	 * 获取LinkedHashMap第一个entry
	 * 
	 * @param map
	 * @return
	 */
	public static <K, V> Entry<K, V> getHead(Map<K, V> map) {
		return map.entrySet().iterator().next();
	}

	/**
	 * 获取LinkedHashMap最后一个entry
	 * 
	 * @param map
	 * @return
	 */
	public static <K, V> Entry<K, V> getTail(Map<K, V> map) {
		Iterator<Entry<K, V>> iterator = map.entrySet().iterator();
		Entry<K, V> tail = null;
		while (iterator.hasNext()) {
			tail = iterator.next();
		}
		return tail;
	}

	/**
	 * 删除map中指定value
	 * 
	 * @param map
	 * @param value
	 */
	public static <K> void removeByIntegerValue(Map<K, Integer> map, int value) {
		Iterator<Integer> it = map.values().iterator();
		while (it.hasNext()) {
			int i = it.next();
			if (i == value) {
				it.remove();
			}
		}
	}

	public static <K, V> Map<K, V> listToMap(List<V> list, IDataProvider<K, V> convert) {
		if (list == null || convert == null) {
			return null;
		}
		Map<K, V> map = Maps.newHashMapWithExpectedSize(list.size());
		for (V v : list) {
			K k = convert.getData(v);
			if (k == null) {
				continue;
			}
			map.put(k, v);
		}
		return map;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <K extends Comparable, V extends Comparable> Map<K, V> sortMapByValues(Map<K, V> map) {
        HashMap<K, V> finalOut = new LinkedHashMap<>();
        map.entrySet().stream().sorted((p1, p2) -> p1.getValue().compareTo(p2.getValue()))
        .collect(Collectors.toList()).forEach(ele -> finalOut.put(ele.getKey(), ele.getValue()));
        return finalOut;
    }
}
