package com.dj.servercore.conf;

import com.dj.domain.config.ConfigCityList;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;

public class ConfigCityListConf extends BaseConfigConf<ConfigCityList> {

	public ConfigCityListConf() {
		super(IConfProvider.CONFIG_CITY_LIST);
	}

	private ImmutableMap<Integer, ConfigCityList> cityListMap;

	@Override
	public void onLoadOver() {
		cityListMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigCityList> getCityNpcMap() {
		return getConfig(cityListMap);
	}

	public ConfigCityList getCityNpc(int id) {
		if(cityListMap.containsKey(id)) {
			return getConfig(id, cityListMap);
		}else {
			return null;
		}
	}
}
