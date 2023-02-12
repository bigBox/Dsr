package com.dj.servercore.conf;

import com.dj.domain.config.ConfigItem2Count;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigItem2CountConf extends BaseConfigConf<ConfigItem2Count> {

	public ConfigItem2CountConf() {
		super(IConfProvider.CONFIG_ITEM2COUNT);
	}

	private ImmutableMap<Integer, ConfigItem2Count> item2CountMap;

	@Override
	public void onLoadOver() {
		item2CountMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigItem2Count> getItem2CountMap() {
		return getConfig(item2CountMap);
	}

	public ConfigItem2Count getItem2Count(int id) {
		if(item2CountMap.containsKey(id)) {
			return getConfig(id, item2CountMap, false);
		}else{
			return null;
		}
	}
}
