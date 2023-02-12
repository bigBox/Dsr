package com.dj.servercore.conf;

import com.dj.domain.config.ConfigSummons;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

public class ConfigSummonsConf extends BaseConfigConf<ConfigSummons> {

	public ConfigSummonsConf() {
		super(IConfProvider.CONFIG_SUMMONS);
	}

	private ImmutableMap<Integer, ConfigSummons> summonMap;

	private Map<Integer, Map<Integer, Integer>> allWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		summonMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());

		allWeightedMap.clear();
		for (ConfigSummons item : dataList) {
			Map<Integer, Integer> tmpMap = allWeightedMap.get(item.getLevel());
			if (tmpMap == null) {
				tmpMap = Maps.newHashMap();
				allWeightedMap.put(item.getLevel(), tmpMap);
			}
			tmpMap.put(item.getID(), item.getRate());
		}
	}

	public ImmutableMap<Integer, ConfigSummons> getSummonMap() {
		return getConfig(summonMap);
	}

	public ConfigSummons getSummon(int id) {
		if(summonMap.containsKey(id)) {
			return getConfig(id, summonMap);
		}else{
			return null;
		}
	}

	public Map<Integer, Integer> getWeighted(int level) {
		if(allWeightedMap.containsKey(level)) {
			return getConfig(level, allWeightedMap);
		}else{
			return null;
		}
	}

}
