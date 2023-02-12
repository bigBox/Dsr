package com.dj.servercore.conf;

import com.dj.domain.config.ConfigNewRoleShowTableItem;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;

public class ConfigNewRoleShowTableItemConf extends BaseConfigConf<ConfigNewRoleShowTableItem> {

	public ConfigNewRoleShowTableItemConf() {
		super(IConfProvider.CONFIG_NEWROLESHOWTABLEITEM);
	}

	private ImmutableMap<Integer, ConfigNewRoleShowTableItem> newRoleShowTableItemMap;

	@Override
	public void onLoadOver() {
		newRoleShowTableItemMap = MapUtil.listToImmMap(dataList, obj -> obj.getId());
	}

	public ImmutableMap<Integer, ConfigNewRoleShowTableItem> getNewRoleShowTableItemMap() {
		return getConfig(newRoleShowTableItemMap);
	}

	public ConfigNewRoleShowTableItem getNewRoleShowTableItem(int id) {
		if(newRoleShowTableItemMap.containsKey(id)) {
			return getConfig(id, newRoleShowTableItemMap);
		}else{
			return null;
		}
	}
}
