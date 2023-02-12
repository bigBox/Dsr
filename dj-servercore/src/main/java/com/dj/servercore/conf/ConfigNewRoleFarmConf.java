package com.dj.servercore.conf;

import com.dj.domain.config.ConfigNewRoleFarm;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;

public class ConfigNewRoleFarmConf extends BaseConfigConf<ConfigNewRoleFarm> {

	public ConfigNewRoleFarmConf() {
		super(IConfProvider.CONFIG_NEWROLEFARM);
	}

	private ImmutableMap<Integer, ConfigNewRoleFarm> newRoleFarmMap;

	@Override
	public void onLoadOver() {
		newRoleFarmMap = MapUtil.listToImmMap(dataList, obj -> obj.getId());
	}

	public ImmutableMap<Integer, ConfigNewRoleFarm> getNewRoleFarmMap() {
		return getConfig(newRoleFarmMap);
	}

	public ConfigNewRoleFarm getNewRoleFarm(int id) {
		if(newRoleFarmMap.containsKey(id)) {
			return getConfig(id, newRoleFarmMap);
		}else{
			return null;
		}
	}
}
