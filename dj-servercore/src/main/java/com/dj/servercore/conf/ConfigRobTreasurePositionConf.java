package com.dj.servercore.conf;

import com.dj.domain.config.ConfigRobTreasurePosition;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;

public class ConfigRobTreasurePositionConf extends BaseConfigConf<ConfigRobTreasurePosition> {

	public ConfigRobTreasurePositionConf() {
		super(IConfProvider.CONFIG_ROBTREASUREPOSITION);
	}

	private ImmutableMap<Integer, ConfigRobTreasurePosition> cellMap;

	@Override
	public void onLoadOver() {
		cellMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigRobTreasurePosition> getCellMap() {
		return getConfig(cellMap);
	}

	public ConfigRobTreasurePosition getCell(int id) {
		if(cellMap.containsKey(id)) {
			return getConfig(id, cellMap);
		}else{
			return null;
		}
	}

}
