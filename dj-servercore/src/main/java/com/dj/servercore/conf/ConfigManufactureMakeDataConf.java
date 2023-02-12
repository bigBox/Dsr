package com.dj.servercore.conf;

import com.dj.domain.config.ConfigManufactureMakeData;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigManufactureMakeDataConf extends BaseConfigConf<ConfigManufactureMakeData> {

	public ConfigManufactureMakeDataConf() {
		super(IConfProvider.CONFIG_MANUFACTUREMAKEDATA);
	}

	private ImmutableMap<Integer, ConfigManufactureMakeData> manufactureMakeDataMap;

	@Override
	public void onLoadOver() {
		manufactureMakeDataMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ConfigManufactureMakeData getManufactureMakeData(int id) {
		if(manufactureMakeDataMap.containsKey(id)) {
			return getConfig(id, manufactureMakeDataMap);
		}else{
			return null;
		}
	}

	public ImmutableMap<Integer, ConfigManufactureMakeData> getManufactureMakeDataMap() {
		return getConfig(manufactureMakeDataMap);
	}
}
