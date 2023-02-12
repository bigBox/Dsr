package com.dj.servercore.conf;

import com.dj.domain.config.ConfigFarmCulture;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigFarmCultureConf extends BaseConfigConf<ConfigFarmCulture> {

	public ConfigFarmCultureConf() {
		super(IConfProvider.CONFIG_FARMCULTURE);
	}

	private ImmutableMap<Integer, ConfigFarmCulture> plantMap;

	@Override
	public void onLoadOver() {
		plantMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ConfigFarmCulture getPlant(int id) {
		if(plantMap.containsKey(id)) {
			return getConfig(id, plantMap);
		}else {
			return null;
		}
	}
}
