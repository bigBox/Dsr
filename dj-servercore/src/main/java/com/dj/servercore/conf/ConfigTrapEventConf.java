package com.dj.servercore.conf;//package com.dj.servercore.conf;

import java.util.Map;

import com.dj.domain.config.ConfigTrapEvent;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class ConfigTrapEventConf extends BaseConfigConf<ConfigTrapEvent> {

	public ConfigTrapEventConf() {
		super(IConfProvider.CONFIG_TRAP_EVENT);
	}

	private ImmutableMap<Integer, ConfigTrapEvent> trapMap;

	private Map<Integer, Map<Integer, Integer>> allWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		trapMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());

		allWeightedMap.clear();
		for (ConfigTrapEvent item : dataList) {
			Map<Integer, Integer> tmpMap = allWeightedMap.get(item.getType());
			if (tmpMap == null) {
				tmpMap = Maps.newHashMap();
				allWeightedMap.put(item.getType(), tmpMap);
			}
			tmpMap.put(item.getID(), item.getWeight());
		}
	}

	public ConfigTrapEvent getTrap(int id) {
		if(trapMap.containsKey(id)) {
			return getConfig(id, trapMap);
		}else{
			return null;
		}
	}

	public Map<Integer, Integer> getWeighted(int type) {
		if(allWeightedMap.containsKey(type)) {
			return getConfig(type, allWeightedMap);
		}else{
			return null;
		}
	}
}
