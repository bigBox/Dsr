package com.dj.servercore.conf;

import com.dj.domain.config.ConfigNewRoleShowTableInfo;
import com.dj.domain.util.collection.MapUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;

public class ConfigNewRoleShowTableInfoConf extends BaseConfigConf<ConfigNewRoleShowTableInfo> {

	public ConfigNewRoleShowTableInfoConf() {
		super(IConfProvider.CONFIG_NEWROLESHOWTABLEINFO);
	}

	private ImmutableMap<Integer, ConfigNewRoleShowTableInfo> newRoleShowTableInfoMap;

	@Override
	public void onLoadOver() {
		newRoleShowTableInfoMap = MapUtil.listToImmMap(dataList, obj -> obj.getId());
	}

	public ImmutableMap<Integer, ConfigNewRoleShowTableInfo> getNewRoleShowTableInfoMap() {
		return getConfig(newRoleShowTableInfoMap);
	}

	public ConfigNewRoleShowTableInfo getNewRoleShowTableInfo(int id) {
		if(newRoleShowTableInfoMap.containsKey(id)) {
			return getConfig(id, newRoleShowTableInfoMap);
		}else{
			return null;
		}
	}
}
