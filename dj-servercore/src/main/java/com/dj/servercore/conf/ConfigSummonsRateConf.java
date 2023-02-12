package com.dj.servercore.conf;

import com.dj.domain.config.ConfigSummonsRate;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

public class ConfigSummonsRateConf extends BaseConfigConf<ConfigSummonsRate> {

	public ConfigSummonsRateConf() {
		super(IConfProvider.CONFIG_SUMMONS_RATE);
	}

	private ImmutableMap<Integer, ConfigSummonsRate> summonMap;

	private Map<Integer, Integer> allWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		summonMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());

		allWeightedMap.clear();
		for (ConfigSummonsRate item : dataList) {
			allWeightedMap.put(item.getID(), item.getRate());
		}
	}

	public ImmutableMap<Integer, ConfigSummonsRate> getSummonMap() {
		return summonMap;
	}

	public ConfigSummonsRate getSummon(int id) {
		if(summonMap.containsKey(id)) {
			return getConfig(id, summonMap);
		}else{
			return null;
		}
	}

	public Integer getRate(int level) {
		if(allWeightedMap.containsKey(level)) {
			return allWeightedMap.get(level);
		}else{
			return null;
		}
	}

}
