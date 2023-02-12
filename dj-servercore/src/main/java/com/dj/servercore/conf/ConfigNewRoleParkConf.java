package com.dj.servercore.conf;

import com.dj.domain.config.ConfigNewRoleItem;
import com.dj.domain.config.ConfigNewRolePark;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigNewRoleParkConf extends BaseConfigConf<ConfigNewRolePark> {

	public ConfigNewRoleParkConf() {
		super(IConfProvider.CONFIG_NEWROLEPARK);
	}

	private ImmutableMap<Integer, ConfigNewRolePark> newRoleParkMap;

	private int newRoleGreen = 0;

	@Override
	public void onLoadOver() {
		newRoleParkMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());

		newRoleGreen = 0;
		for (ConfigNewRolePark config : newRoleParkMap.values()){
			newRoleGreen+=config.getGreen();
		}
	}

	public ImmutableMap<Integer, ConfigNewRolePark> getNewRoleParkMap() {
		return getConfig(newRoleParkMap);
	}

	public int getNewRoleGreen(){
		return getConfig(newRoleGreen);
	}

	public ConfigNewRolePark getNewRolePark(int id) {
		if(newRoleParkMap.containsKey(id)) {
			return getConfig(id, newRoleParkMap);
		}else{
			return null;
		}
	}
}
