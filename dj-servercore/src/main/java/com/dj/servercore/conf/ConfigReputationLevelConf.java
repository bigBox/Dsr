package com.dj.servercore.conf;

import com.dj.domain.config.ConfigReputationLevel;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigReputationLevelConf extends BaseConfigConf<ConfigReputationLevel> {

	public ConfigReputationLevelConf() {
		super(IConfProvider.CONFIG_REPUTATIONLEVEL);
	}

	private ImmutableMap<Integer, ConfigReputationLevel> reputationLevelMap;

	@Override
	public void onLoadOver() {
		reputationLevelMap = MapUtil.listToImmMap(dataList, obj -> obj.getId());
	}

	public ConfigReputationLevel getReputationLevel(int level) {
		if(reputationLevelMap.containsKey(level)) {
			return getConfig(level, reputationLevelMap, false);
		}else{
			return null;
		}
	}

	public ImmutableMap<Integer, ConfigReputationLevel> getReputationLevelMap() {
		return getConfig(reputationLevelMap);
	}
}
