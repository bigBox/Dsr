package com.dj.servercore.conf;

import com.dj.domain.config.ConfigOutsidesFunc;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

public class ConfigOutsidesFuncConf extends BaseConfigConf<ConfigOutsidesFunc> {

	public ConfigOutsidesFuncConf() {
		super(IConfProvider.CONFIG_OUTSIDESFUNC);
	}

	private ImmutableMap<Integer, ConfigOutsidesFunc> funcMap;

	private Map<Integer, Map<Integer, Integer>> weightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		funcMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());

		weightedMap.clear();
		for (ConfigOutsidesFunc item : dataList) {
			if (StringUtil.isNotEmpty(item.getMatrial1())) {
				Map<Integer, Integer> tmpMap = Maps.newHashMapWithExpectedSize(5);
				String[] arr1 = item.getMatrial1().split(";");
				for (String str1 : arr1) {
					String[] arr2 = str1.split("-");
					MapUtil.fundInt(tmpMap, Integer.parseInt(arr2[0]), Integer.parseInt(arr2[0]));
				}
				weightedMap.put(item.getID(), tmpMap);
			}
		}
	}

	public ConfigOutsidesFunc getFunc(int id) {
		if(funcMap.containsKey(id)) {
			return getConfig(id, funcMap);
		}else{
			return null;
		}
	}

	public Map<Integer, Integer> getWeighted(int id) {
		if(weightedMap.containsKey(id)) {
			return getConfig(id, weightedMap);
		}else{
			return new HashMap<>();
		}
	}
}
