package com.dj.servercore.conf;

import java.util.Map;
import java.util.Set;

import com.dj.domain.config.ConfigRobCfg;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

public class ConfigRobCfgConf extends BaseConfigConf<ConfigRobCfg> {

	public ConfigRobCfgConf() {
		super(IConfProvider.CONFIG_ROBCFG);
	}

	private ImmutableMap<Integer, ConfigRobCfg> cfgMap;
	
	private Set<Integer> mapPieceSet = Sets.newHashSet();

	@Override
	public void onLoadOver() {
		cfgMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
		mapPieceSet.clear();
		for (ConfigRobCfg configRobCfg : dataList) {
			int itemID = configRobCfg.getInputItemId();
	        int count = configRobCfg.getInputItemNum();
	        for (int i = 0; i < count-1; i++) {
				mapPieceSet.add(itemID+i);
			}
		}
	}

	public ConfigRobCfg getCfg(int id) {
		if(cfgMap.containsKey(id)) {
			return getConfig(id, cfgMap);
		}else{
			return null;
		}
	}

	public Map<Integer, ConfigRobCfg> getCfgMap() {
		return cfgMap;
	}

	public Set<Integer> getMapPieceSet(){
		return getConfig(mapPieceSet);
	}
}
