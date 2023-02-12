package com.dj.servercore.conf;

import com.dj.domain.config.ConfigStaminaCfg;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigStaminaCfgConf extends BaseConfigConf<ConfigStaminaCfg> {

	public ConfigStaminaCfgConf() {
		super(IConfProvider.CONFIG_STAMINACFG);
	}

	private ImmutableMap<Integer, ConfigStaminaCfg> staminaCfgMap;

	@Override
	public void onLoadOver() {
		staminaCfgMap = MapUtil.listToImmMap(dataList, obj -> obj.getLevel());
	}

	public ConfigStaminaCfg getStaminaCfg(int level) {
		if(staminaCfgMap.containsKey(level)) {
			return getConfig(level, staminaCfgMap, false);
		}else{
			return null;
		}
	}
}
