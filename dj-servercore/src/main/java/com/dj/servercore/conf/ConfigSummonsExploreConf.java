package com.dj.servercore.conf;

import java.util.Map;

import com.dj.domain.config.ConfigSummonExplore;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class ConfigSummonsExploreConf extends BaseConfigConf<ConfigSummonExplore> {

	public ConfigSummonsExploreConf() {
		super(IConfProvider.CONFIG_SUMMONSEXPLORE);
	}

	private ImmutableMap<Integer, ConfigSummonExplore> summonExploreMap;
	private Map<Integer, Integer>                      allWeightMap = Maps.newHashMap();
	private Map<Integer, Integer>                      eventWeightMap = Maps.newHashMap();
	private Map<Integer, Integer>                      investWeightMap = Maps.newHashMap();
	private Map<Integer, Map<Integer, Integer>>        matrialWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		summonExploreMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
		
		eventWeightMap.clear();
		investWeightMap.clear();
		matrialWeightedMap.clear();
		for (ConfigSummonExplore configSummonExplore : dataList) {
			allWeightMap.put(configSummonExplore.getID(), configSummonExplore.getPro());
			if(configSummonExplore.getInvest() == 0) {
				eventWeightMap.put(configSummonExplore.getID(), configSummonExplore.getPro());
			} else {
				investWeightMap.put(configSummonExplore.getID(), configSummonExplore.getPro());
			}
			if (StringUtil.isNotEmpty(configSummonExplore.getMatrial1())) {
				Map<Integer, Integer> tmpMap = Maps.newHashMapWithExpectedSize(5);
				String[] arr1 = configSummonExplore.getMatrial1().split(";");
				for (String str1 : arr1) {
					String[] arr2 = str1.split("-");
					MapUtil.fundInt(tmpMap, Integer.parseInt(arr2[0]), Integer.parseInt(arr2[1]));
				}
				matrialWeightedMap.put(configSummonExplore.getID(), tmpMap);
			}
		}
	}

	public ConfigSummonExplore getSummonExplore(int id) {
		if(summonExploreMap.containsKey(id)) {
			return getConfig(id, summonExploreMap);
		}else{
			return null;
		}
	}

	public Map<Integer, Integer> getAllWeightMap() {
		return getConfig(allWeightMap);
	}

	public Map<Integer, Integer> getEventWeightMap() {
		return getConfig(eventWeightMap);
	}

	public Map<Integer, Integer> getInvestWeightMap() {
		return getConfig(investWeightMap);
	}
	
	public Map<Integer, Integer> getMatrialWeighted(int id) {
		if(matrialWeightedMap.containsKey(id)) {
			return getConfig(id, matrialWeightedMap, false);
		}else{
			return null;
		}
	}
	
}
