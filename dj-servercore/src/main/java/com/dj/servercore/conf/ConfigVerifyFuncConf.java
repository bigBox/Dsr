package com.dj.servercore.conf;

import java.util.Map;

import com.dj.domain.config.ConfigVerifyFunc;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.lib.DataPair;
import com.dj.domain.util.math.RandomUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class ConfigVerifyFuncConf extends BaseConfigConf<ConfigVerifyFunc> {

	public ConfigVerifyFuncConf() {
		super(IConfProvider.CONFIG_VERIFYFUNC);
	}

	private ImmutableMap<Object, ConfigVerifyFunc> verifyFuncMap;

	private Map<Integer, Map<Integer, Integer>> allWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		verifyFuncMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
		allWeightedMap.clear();
		for (ConfigVerifyFunc item : dataList) {
			Map<Integer, Integer> weightedMap = Maps.newHashMapWithExpectedSize(3);
			if(item.getPro_A() > 0) {
				weightedMap.put(2, item.getPro_A());
			}
			if(item.getPro_B() > 0) {
				weightedMap.put(4, item.getPro_B());
			}
			if((item.getResume() == 10)&&(item.getPro_C() > 0)) {
				weightedMap.put(5, item.getPro_C());
			}
			allWeightedMap.put(item.getID(), weightedMap);
		}
	}

	public ConfigVerifyFunc getConfigVerifyFunc(int id) {
		if(verifyFuncMap.containsKey(id)) {
			return getConfig(id, verifyFuncMap);
		}else{
			return null;
		}
	}

	public Integer getProResult(int id) {
		if(allWeightedMap.containsKey(id)) {
			Map<Integer, Integer> weightedMap = getConfig(id, allWeightedMap);
			if (weightedMap != null && weightedMap.size() > 0) {
				return RandomUtil.weightedRandom(weightedMap);
			}
		}
		return 0;
	}

	public Integer getProExp(int id) {
		if(verifyFuncMap.containsKey(id)) {
			return getConfig(id, verifyFuncMap).getExp();
		}else{
			return 0;
		}
	}
}
