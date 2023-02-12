package com.dj.servercore.conf;

import com.dj.domain.config.ConfigGuildLevel;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigGuildLevelConf extends BaseConfigConf<ConfigGuildLevel> {

	public ConfigGuildLevelConf() {
		super(IConfProvider.CONFIG_GUILDLEVEL);
	}

	private ImmutableMap<Integer, ConfigGuildLevel> guildLevelMap;

	@Override
	public void onLoadOver() {
		guildLevelMap = MapUtil.listToImmMap(dataList, obj -> obj.getLevel());
	}

	public ConfigGuildLevel getGuildLevel(int level) {
		if(guildLevelMap.containsKey(level)) {
			return getConfig(level, guildLevelMap, false);
		}else{
			return null;
		}
	}

	public ImmutableMap<Integer, ConfigGuildLevel> getGuildLevelMap() {
		return getConfig(guildLevelMap);
	}
}
