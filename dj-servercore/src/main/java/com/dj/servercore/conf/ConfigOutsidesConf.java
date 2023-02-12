package com.dj.servercore.conf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dj.domain.config.ConfigOutsides;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.Maps;

public class ConfigOutsidesConf extends BaseConfigConf<ConfigOutsides> {

	public ConfigOutsidesConf() {
		super(IConfProvider.CONFIG_OUTSIDES);
	}

	private Map<Integer, Map<ConfigOutsides, Integer>> allWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		allWeightedMap.clear();
		for (ConfigOutsides item : dataList) {
			Map<ConfigOutsides, Integer> tmpMap = allWeightedMap.get(item.getType());
			if (tmpMap == null) {
				tmpMap = Maps.newHashMap();
				allWeightedMap.put(item.getType(), tmpMap);
			}
			tmpMap.put(item, item.getWeight());
		}
	}

	public List<ConfigOutsides> getDataList() {
		return getConfig(dataList);
	}

	public Map<ConfigOutsides, Integer> getWeightedMap(int type) {
		if(allWeightedMap.containsKey(type)) {
			return getConfig(type, allWeightedMap);
		}else{
			return new HashMap<>();
		}
	}
}
