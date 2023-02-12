package com.dj.servercore.conf;

import com.dj.domain.config.ConfigFactory;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigFactoryConf extends BaseConfigConf<ConfigFactory> {

	public ConfigFactoryConf() {
		super(IConfProvider.CONFIG_FACTORY);
	}

	private ImmutableMap<Integer, ConfigFactory> factoryMap;

	@Override
	public void onLoadOver() {
		factoryMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigFactory> getFactoryMap() {
		return getConfig(factoryMap);
	}

	public ConfigFactory getFactory(int id) {
		if(factoryMap.containsKey(id)) {
			return getConfig(id, factoryMap);
		}else{
			return null;
		}
	}
}
