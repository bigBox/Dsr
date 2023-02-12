package com.dj.servercore.conf;

import com.dj.domain.config.ConfigNewRoleShowTableItem;
import com.dj.domain.config.ConfigObstacleCell;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigObstacleCellConf extends BaseConfigConf<ConfigObstacleCell> {

	public ConfigObstacleCellConf() {
		super(IConfProvider.CONFIG_OBSTACLECELL);
	}

	private ImmutableMap<Integer, ConfigObstacleCell> cellMap;

	@Override
	public void onLoadOver() {
		cellMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ConfigObstacleCell getCell(int id) {
		if(cellMap.containsKey(id)) {
			return getConfig(id, cellMap);
		}else{
			return null;
		}
	}
}
