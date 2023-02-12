package com.dj.servercore.conf;

import com.dj.domain.config.ConfigOnPoetry;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigOnPoetryConf extends BaseConfigConf<ConfigOnPoetry> {

	public ConfigOnPoetryConf() {
		super(IConfProvider.CONFIG_ONPOETRY);
	}

	private ImmutableMap<Integer, ConfigOnPoetry> onPoetryMap;

	@Override
	public void onLoadOver() {
		onPoetryMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigOnPoetry> getOnPoetryMap() {
		return getConfig(onPoetryMap);
	}
	
	public ConfigOnPoetry getOnPoetry(int id) {
		if(onPoetryMap.containsKey(id)) {
			return getConfig(id, onPoetryMap);
		}else{
			return null;
		}
	}
}
