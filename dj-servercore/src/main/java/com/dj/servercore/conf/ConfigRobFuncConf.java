package com.dj.servercore.conf;

import java.util.Map;

import com.dj.domain.config.ConfigRobFunc;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class ConfigRobFuncConf extends BaseConfigConf<ConfigRobFunc> {

	public ConfigRobFuncConf() {
		super(IConfProvider.CONFIG_ROBFUNC);
	}

	private ImmutableMap<Integer, ConfigRobFunc> funcMap;
	private Map<Integer, Integer> funcWeightedMap = Maps.newHashMap();
	
	private Map<Integer, Map<Integer, Integer>> matrialWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		funcMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());

		funcWeightedMap.clear();
		matrialWeightedMap.clear();
		for (ConfigRobFunc item : dataList) {
			if(item.getPro() > 0) {
				funcWeightedMap.put(item.getID(), item.getPro());
			}
			if (StringUtil.isNotEmpty(item.getMatrial1())) {
				Map<Integer, Integer> tmpMap = Maps.newHashMapWithExpectedSize(5);
				String[] arr1 = item.getMatrial1().split(";");
				for (String str1 : arr1) {
					String[] arr2 = str1.split("-");
					MapUtil.fundInt(tmpMap, Integer.parseInt(arr2[0]), Integer.parseInt(arr2[1]));
				}
				matrialWeightedMap.put(item.getID(), tmpMap);
			}
		}
	}

	public ConfigRobFunc getFunc(int id) {
		if(funcMap.containsKey(id)) {
			return getConfig(id, funcMap);
		}else{
			return null;
		}
	}

	public Map<Integer, Integer> getFuncWeighted() {
		return getConfig(funcWeightedMap);
	}
	
	public Map<Integer, Integer> getMatrialWeighted(int id) {
		if(matrialWeightedMap.containsKey(id)) {
			return getConfig(id, matrialWeightedMap, false);
		}else{
			return null;
		}
	}
}
