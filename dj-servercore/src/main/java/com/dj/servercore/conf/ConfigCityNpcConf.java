package com.dj.servercore.conf;

import com.dj.domain.config.ConfigCityNpc;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;

public class ConfigCityNpcConf extends BaseConfigConf<ConfigCityNpc> {

	public ConfigCityNpcConf() {
		super(IConfProvider.CONFIG_CITY_NPC);
	}

	private ImmutableMap<Integer, ConfigCityNpc> cityNpcMap;

	@Override
	public void onLoadOver() {
		cityNpcMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigCityNpc> getCityNpcMap() {
		return getConfig(cityNpcMap);
	}

	public ConfigCityNpc getCityNpc(int id) {
		if(cityNpcMap.containsKey(id)) {
			return getConfig(id, cityNpcMap);
		}else {
			return null;
		}
	}
}
