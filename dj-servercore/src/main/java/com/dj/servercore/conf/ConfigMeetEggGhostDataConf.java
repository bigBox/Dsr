package com.dj.servercore.conf;

import com.dj.domain.config.ConfigMeetEggGhostData;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

public class ConfigMeetEggGhostDataConf extends BaseConfigConf<ConfigMeetEggGhostData> {

	public ConfigMeetEggGhostDataConf() {
		super(IConfProvider.CONFIG_MEETEGGGHOSTDATA);
	}

	private ImmutableMap<Integer, ConfigMeetEggGhostData> makeDataMap;

	private Map<Integer, Integer> weightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		makeDataMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());

		weightedMap.clear();
		for (ConfigMeetEggGhostData item : dataList) {
			weightedMap.put(item.getID(), item.getProb());
		}
	}

	public Map<Integer, Integer> getWeightedMap() {
		return getConfig(weightedMap);
	}

	public ConfigMeetEggGhostData getMeetEggGhostData(int id) {
		if(makeDataMap.containsKey(id)) {
			return getConfig(id, makeDataMap);
		}else{
			return null;
		}
	}
}
