package com.dj.servercore.conf;

import com.dj.domain.config.ConfigMiniMall;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigMiniMallConf extends BaseConfigConf<ConfigMiniMall> {

	public ConfigMiniMallConf() {
		super(IConfProvider.CONFIG_MINIMALL);
	}

	private ImmutableMap<Integer, ConfigMiniMall> miniMallMap;

	@Override
	public void onLoadOver() {
		miniMallMap = MapUtil.listToImmMap(dataList, obj -> obj.getId());
	}

	public ImmutableMap<Integer, ConfigMiniMall> getMiniMallMap() {
		return getConfig(miniMallMap);
	}

	public ConfigMiniMall getMiniMall(int id) {
		if(miniMallMap.containsKey(id)) {
			return getConfig(id, miniMallMap);
		}else{
			return null;
		}
	}
}
