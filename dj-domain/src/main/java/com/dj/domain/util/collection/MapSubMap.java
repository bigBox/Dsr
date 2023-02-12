package com.dj.domain.util.collection;

import com.dj.domain.util.inf.IDataProvider;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
public class MapSubMap<K, SK, V> {

	private Map<K, Map<SK, V>> selfMap;

	public MapSubMap() {
		selfMap = new HashMap<>();
	}

	/**
	 * 获得一个值
	 * 
	 * @param k
	 * @param sk
	 * @return
	 */
	public V get(K k, SK sk) {
		Map<SK, V> subMap = selfMap.get(k);
		if (subMap == null) {
			return null;
		}
		return subMap.get(sk);
	}

	/**
	 * 放入一个元素到 子map中
	 * 
	 * @param k
	 * @param sk
	 * @param v
	 */
	public void put(K k, SK sk, V v) {
		getOrCreateSubMap(k).put(sk, v);
	}

	/**
	 * 
	 * @param k
	 * @return
	 */
	public Map<SK, V> getOrCreateSubMap(K k) {
		Map<SK, V> subMap = selfMap.get(k);
		if (subMap == null) {
			subMap = new HashMap<>();
			selfMap.put(k, subMap);
		}
		return subMap;
	}

	public Collection<V> values(K k) {
		Map<SK, V> subMap = selfMap.get(k);
		if (subMap == null) {
			return null;
		}
		return subMap.values();
	}

	public Set<K> keys(){
		return selfMap.keySet();
	}

	/**
	 * 转换一下 value 的类型， 一般情况下也许用不到这个方法
	 * 
	 * @param k
	 * @param sk
	 * @param dataProvider
	 * @deprecated 未经实验的方法
	 */
	public void convertValueType(K k, SK sk, IDataProvider<V, V> dataProvider) {
		put(k, sk, dataProvider.getData(get(k, sk)));
	}

	public boolean containsKey(K k){
		return selfMap.containsKey(k);
	}

	public void clear() {
		selfMap.clear();
	}

	/**
	 * 所有的值列表
	 * @return
	 */
	public List<V> allValues(){
		List<V> list = selfMap.keySet().stream().map(a -> selfMap.get(a)).map(a -> a.values()).flatMap(a -> a.stream()).collect(Collectors.toList());
		return list;
	}
}
