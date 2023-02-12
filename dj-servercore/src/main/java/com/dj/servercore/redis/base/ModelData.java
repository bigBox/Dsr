package com.dj.servercore.redis.base;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.dj.domain.util.inf.IArgumentRunnable;
import com.google.common.collect.Maps;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ModelData {
	/** 数据MAP */
	private HashMap<String, Object> dataMap;
	/** 最后修改的时间 */
	private long modified = 0;

	public ModelData() {
		this.dataMap = Maps.newHashMap();
	}

	/**
	 *	设置数据
	 */
	public void set(String key, Object value) {
		this.dataMap.put(key, value);
	}

	/**
	 *	获取数据
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(String key) {
		return (T) this.dataMap.get(key);
	}

	/**
	 * key value是否存在
	 */
	public boolean isExists(String key) {
		return this.dataMap.get(key) != null;
	}

	/**
	 * submap key value是否存在
	 */
	public boolean isExistsSubMapItem(String mapKey, int id) {
		if (this.isExists(mapKey)) {
			return this.getSubMap(mapKey).containsKey(id);
		}
		return false;
	}

	/**
	 *	子 map 是否是空的
	 * 
	 * @param mapKey
	 * @return
	 */
	public boolean isSubMapEmpty(String mapKey) {
		return getSubMap(mapKey).isEmpty();
	}

	/**
	 *	移除数据
	 */
	public Object remove(String key) {
		return this.dataMap.remove(key);
	}

	/**
	 *	初始化子MAP
	 */
	public <K, V> void initNewSubMap(String mapKey) {
		this.dataMap.put(mapKey, new HashMap<K, V>());
	}

	/**
	 *	获取子MAP
	 */
	@SuppressWarnings("unchecked")
	public <K, V> HashMap<K, V> getSubMap(String mapKey) {
		return (HashMap<K, V>) this.dataMap.get(mapKey);
	}

	/**
	 *	清空子MAP
	 */
	public void clearSubMap(String mapKey) {
		this.getSubMap(mapKey).clear();
	}

	/**
	 *	添加数据到子MAP
	 */
	public <K, V> void addSubMapItem(String mapKey, K key, V value) {
		this.getSubMap(mapKey).put(key, value);
	}

	/**
	 *	获取子MAP中的数据
	 */
	@SuppressWarnings("unchecked")
	public <K, V> V getSubMapItem(String mapKey, K key) {
		return (V) this.getSubMap(mapKey).get(key);
	}

	/**
	 *	更新子MAP中的数据
	 */
	public <K, V> void updateSubMapItem(String mapKey, K key, V value) {
		this.getSubMap(mapKey).put(key, value);
	}

	/**
	 *	移除子MAP中的数据
	 */
	@SuppressWarnings("unchecked")
	public <K, V> V removeSubMapItem(String mapKey, K key) {
		return (V) this.getSubMap(mapKey).remove(key);
	}

	/**
	 *	移除子map中的若干个数据
	 * 
	 * @param mapKey
	 * @param keys
	 */
	public <K> void removeSubMapItems(String mapKey, Collection<K> keys) {
		for (K k : keys) {
			this.getSubMap(mapKey).remove(k);
		}
	}

	/**
	 *	获得某个 子 map 的所有值
	 * 
	 * @param mapKey
	 * @return
	 */
	public <V> Collection<V> getSubMapItems(String mapKey) {
		Map<?, V> map = this.getSubMap(mapKey);
		return map.values();
	}

	/**
	 *	遍历子map
	 * 
	 * @param mapKey  子map的key
	 * @param action  要做的行为 ，可以进行删除操作
	 */
	public <K, V> void foreachSubMap(String mapKey, IArgumentRunnable<Iterator<Entry<K, V>>> action) {
		Map<K, V> map = getSubMap(mapKey);
		if (map == null || map.isEmpty()) {
			return;
		}
		Iterator<Entry<K, V>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			action.run(iterator);
		}
	}
}
