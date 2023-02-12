package com.dj.servercore.conf;

import com.dj.domain.config.ConfigRobInit;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;

public class ConfigRobInitConf extends BaseConfigConf<ConfigRobInit> {

	public ConfigRobInitConf() {
		super(IConfProvider.CONFIG_ROBINIT);
	}

	private ImmutableMap<Integer, ConfigRobInit> cellMap;

	@Override
	public void onLoadOver() {
		cellMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigRobInit> getCellMap() {
		return getConfig(cellMap);
	}

	public ConfigRobInit getCell(int id) {
		if(cellMap.containsKey(id)) {
			return getConfig(id, cellMap);
		}else{
			return null;
		}
	}
}
