package com.dj.servercore.conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dj.domain.config.ConfigEventList;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.Maps;

public class ConfigEventListConf extends BaseConfigConf<ConfigEventList> {

	public ConfigEventListConf() {
		super(IConfProvider.CONFIG_EVENTLIST);
	}

	private Map<Integer, Map<ConfigEventList, Integer>> allWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		allWeightedMap.clear();
		for (ConfigEventList item : dataList) {
			Map<ConfigEventList, Integer> tmpMap = allWeightedMap.get(item.getType());
			if (tmpMap == null) {
				tmpMap = Maps.newHashMap();
				allWeightedMap.put(item.getType(), tmpMap);
			}
			tmpMap.put(item, item.getWeight());
		}
	}

	public List<ConfigEventList> getDataList() {
		return getConfig(dataList);
	}

	public Map<ConfigEventList, Integer> getWeightedMap(int type) {
		if(allWeightedMap.containsKey(type)) {
			return getConfig(type, allWeightedMap);
		}else{
			return new HashMap<>();
		}
	}
}
