package com.dj.servercore.conf;

import com.dj.domain.config.ConfigAchievement;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigAchievementConf extends BaseConfigConf<ConfigAchievement> {

	public ConfigAchievementConf() {
		super(IConfProvider.CONFIG_ACHIEVEMENT);
	}

	private ImmutableMap<Integer, ConfigAchievement> achievementMap;

	@Override
	public void onLoadOver() {
		achievementMap = MapUtil.listToImmMap(dataList, obj -> obj.getId());
	}

	public ConfigAchievement getAchievement(int level) {
		if(achievementMap.containsKey(level)) {
			return getConfig(level, achievementMap, false);
		}else {
			return null;
		}
	}

	public ImmutableMap<Integer, ConfigAchievement> getAchievementMap() {
		return getConfig(achievementMap);
	}
}
