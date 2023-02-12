package com.dj.servercore.conf;

import com.dj.domain.config.ConfigPoolFishs;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigPoolFishsConf extends BaseConfigConf<ConfigPoolFishs> {

	public ConfigPoolFishsConf() {
		super(IConfProvider.CONFIG_POOLFISHS);
	}

	private ImmutableMap<Integer, ConfigPoolFishs> poolFishsMap;

	@Override
	public void onLoadOver() {
		poolFishsMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ConfigPoolFishs getPoolFish(int id) {
		if(poolFishsMap.containsKey(id)) {
			return getConfig(id, poolFishsMap);
		}else{
			return null;
		}
	}
}
