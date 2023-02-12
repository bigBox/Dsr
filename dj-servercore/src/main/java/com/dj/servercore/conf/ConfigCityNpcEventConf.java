package com.dj.servercore.conf;

import com.dj.domain.config.ConfigCityNpcEvent;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;

public class ConfigCityNpcEventConf extends BaseConfigConf<ConfigCityNpcEvent> {

	public ConfigCityNpcEventConf() {
		super(IConfProvider.CONFIG_CITY_NPC_EVENT);
	}

	private ImmutableMap<Integer, ConfigCityNpcEvent> cityNpcEventMap;

	@Override
	public void onLoadOver() {
		cityNpcEventMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigCityNpcEvent> getCityNpcEventMap() {
		return getConfig(cityNpcEventMap);
	}

	public ConfigCityNpcEvent getCityNpcEvent(int id) {
		if(cityNpcEventMap.containsKey(id)) {
			return getConfig(id, cityNpcEventMap);
		}else {
			return null;
		}
	}

	public int getCityEventNpcId(int id) {
		if(cityNpcEventMap.containsKey(id)) {
			return getConfig(id, cityNpcEventMap).getNpc();
		}else {
			return 0;
		}
	}

	public int getCityNpcEventId(int id) {
		if(cityNpcEventMap.containsKey(id)) {
			return getConfig(id, cityNpcEventMap).getEvent();
		}else {
			return 100;
		}
	}
}
