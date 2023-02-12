package com.dj.servercore.conf;

import com.dj.domain.config.ConfigFarmParkAnimal;
import com.dj.domain.config.ConfigFarmZooAnimal;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;

public class ConfigFarmZooAnimalConf extends BaseConfigConf<ConfigFarmZooAnimal> {

	public ConfigFarmZooAnimalConf() {
		super(IConfProvider.CONFIG_FARMZOOANIMAL);
	}

	private ImmutableMap<Integer, ConfigFarmZooAnimal> animalMap;

	private ImmutableMap<Integer, ConfigFarmZooAnimal> animalProMap;

	@Override
	public void onLoadOver() {
		animalMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
		animalProMap = MapUtil.listToImmMap(dataList, obj -> obj.getProductId());
	}

	public ConfigFarmZooAnimal getAnimal(int id) {
		if(animalMap.containsKey(id)) {
			return getConfig(id, animalMap, false);
		}else {
			return null;
		}
	}


	public ConfigFarmZooAnimal getAnimalByProId(int id) {
		if(animalProMap.containsKey(id)) {
			return getConfig(id, animalProMap, false);
		}else {
			return null;
		}
	}
}
