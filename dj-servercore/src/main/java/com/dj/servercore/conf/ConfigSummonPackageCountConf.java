package com.dj.servercore.conf;

import com.dj.domain.config.ConfigSummonPackageCount;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

public class ConfigSummonPackageCountConf extends BaseConfigConf<ConfigSummonPackageCount> {

	public ConfigSummonPackageCountConf() {
		super(IConfProvider.CONFIG_SUMMON_PACKAGE_COUNT);
	}

	private ImmutableMap<Integer, ConfigSummonPackageCount> summonPackageCounMap;

	private Map<Integer, Integer> allWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		summonPackageCounMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());

		allWeightedMap.clear();
		for (ConfigSummonPackageCount item : dataList) {
			allWeightedMap.put(item.getID(), item.getWeight());
		}
	}

	public ImmutableMap<Integer, ConfigSummonPackageCount> getSummonMap() {
		return getConfig(summonPackageCounMap);
	}

	public ConfigSummonPackageCount getSummonPackageCount(int id) {
		if(summonPackageCounMap.containsKey(id)) {
			return getConfig(id, summonPackageCounMap);
		}else{
			return summonPackageCounMap.get(0);
		}
	}

	public Map<Integer, Integer> getWeighted() {
		return allWeightedMap;
	}

}
