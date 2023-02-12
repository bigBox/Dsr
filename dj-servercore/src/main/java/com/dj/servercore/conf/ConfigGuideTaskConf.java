package com.dj.servercore.conf;

import com.dj.domain.config.ConfigGuideTask;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigGuideTaskConf extends BaseConfigConf<ConfigGuideTask> {

	public ConfigGuideTaskConf() {
		super(IConfProvider.CONFIG_GUIDETASK);
	}

	private ImmutableMap<Integer, ConfigGuideTask> guideTaskMap;

	@Override
	public void onLoadOver() {
		guideTaskMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigGuideTask> getGuideTaskMap() {
		return getConfig(guideTaskMap);
	}

	public ConfigGuideTask getGuideTask(int id) {
		if(guideTaskMap.containsKey(id)) {
			return getConfig(id, guideTaskMap);
		}else{
			return null;
		}
	}
}
