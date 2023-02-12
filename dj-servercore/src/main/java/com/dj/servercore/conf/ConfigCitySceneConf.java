package com.dj.servercore.conf;

import com.dj.domain.config.ConfigCityScene;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;

public class ConfigCitySceneConf extends BaseConfigConf<ConfigCityScene> {

	public ConfigCitySceneConf() {
		super(IConfProvider.CONFIG_CITY_SCENE);
	}

	private ImmutableMap<Integer, ConfigCityScene> citySceneMap;

	@Override
	public void onLoadOver() {
		citySceneMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigCityScene> getCitySceneMap() {
		return getConfig(citySceneMap);
	}

	public ConfigCityScene getCityScene(int id) {
		if(citySceneMap.containsKey(id)) {
			return getConfig(id, citySceneMap);
		}else {
			return null;
		}
	}

}
