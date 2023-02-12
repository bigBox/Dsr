package com.dj.servercore.conf;

import com.dj.domain.config.ConfigExpLevelCfg;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigExpLevelCfgConf extends BaseConfigConf<ConfigExpLevelCfg> {

	public ConfigExpLevelCfgConf() {
		super(IConfProvider.CONFIG_EXPLEVELCFG);
	}

	private ImmutableMap<Integer, ConfigExpLevelCfg> expLevelCfgMap;

	@Override
	public void onLoadOver() {
		expLevelCfgMap = MapUtil.listToImmMap(dataList, obj -> obj.getLevel());
	}

	public ConfigExpLevelCfg getExpLevelCfg(int level) {
		if(expLevelCfgMap.containsKey(level)) {
			return getConfig(level, expLevelCfgMap, false);
		}else{
			return null;
		}
	}

	public ImmutableMap<Integer, ConfigExpLevelCfg> getExpLevelCfgMap() {
		return getConfig(expLevelCfgMap);
	}
}
