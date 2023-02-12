package com.dj.servercore.conf;

import com.dj.domain.config.ConfigShowTableLevel;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigShowTableLevelConf extends BaseConfigConf<ConfigShowTableLevel> {

	public ConfigShowTableLevelConf() {
		super(IConfProvider.CONFIG_SHOWTABLELEVEL);
	}

	private ImmutableMap<Integer, ConfigShowTableLevel> showTableLevelMap;

	@Override
	public void onLoadOver() {
		showTableLevelMap = MapUtil.listToImmMap(dataList, obj -> obj.getId());
	}

	public ConfigShowTableLevel getShowTableLevel(int level) {
		if(showTableLevelMap.containsKey(level)) {
			return getConfig(level, showTableLevelMap, false);
		}else{
			return null;
		}
	}

	public ImmutableMap<Integer, ConfigShowTableLevel> getShowTableLevelMap() {
		return getConfig(showTableLevelMap);
	}
}
