package com.dj.servercore.conf;

import com.dj.domain.config.ConfigFarmParkAnimal;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigFarmParkAnimalConf extends BaseConfigConf<ConfigFarmParkAnimal> {

	public ConfigFarmParkAnimalConf() {
		super(IConfProvider.CONFIG_FARMPARKANIMAL);
	}

	private ImmutableMap<Integer, ConfigFarmParkAnimal> animalMap;

	private ImmutableMap<Integer, ConfigFarmParkAnimal> animalProMap;
	@Override
	public void onLoadOver() {
		animalMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
		animalProMap = MapUtil.listToImmMap(dataList, obj -> obj.getProductId());
	}

	public ConfigFarmParkAnimal getAnimal(int id) {
		if(animalMap.containsKey(id)) {
			return getConfig(id, animalMap, false);
		}else {
			return null;
		}
	}

	public ConfigFarmParkAnimal getAnimalByProId(int id) {
		if(animalProMap.containsKey(id)) {
			return getConfig(id, animalProMap, false);
		}else {
			return null;
		}
	}
}
