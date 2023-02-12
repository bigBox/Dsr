package com.dj.servercore.conf;

import com.dj.domain.config.ConfigFarmParkPlant;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigFarmParkPlantConf extends BaseConfigConf<ConfigFarmParkPlant> {

	public ConfigFarmParkPlantConf() {
		super(IConfProvider.CONFIG_FARMPARKPLANT);
	}

	private ImmutableMap<Integer, ConfigFarmParkPlant> plantMap;

	@Override
	public void onLoadOver() {
		plantMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ConfigFarmParkPlant getPlant(int id) {
		if(plantMap.containsKey(id)) {
			return getConfig(id, plantMap);
		}else {
			return null;
		}
	}
}
