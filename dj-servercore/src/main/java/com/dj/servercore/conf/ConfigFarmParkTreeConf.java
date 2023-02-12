package com.dj.servercore.conf;

import com.dj.domain.config.ConfigFarmParkTree;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;

public class ConfigFarmParkTreeConf extends BaseConfigConf<ConfigFarmParkTree> {

	public ConfigFarmParkTreeConf() {
		super(IConfProvider.CONFIG_FARMPARKTREE);
	}

	private ImmutableMap<Integer, ConfigFarmParkTree> plantMap;

	@Override
	public void onLoadOver() {
		plantMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ConfigFarmParkTree getPlant(int id) {
		if(plantMap.containsKey(id)) {
			return getConfig(id, plantMap);
		}else {
			return null;
		}
	}
}
