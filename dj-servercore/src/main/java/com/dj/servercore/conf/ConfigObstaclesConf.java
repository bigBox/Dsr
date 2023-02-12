package com.dj.servercore.conf;

import com.dj.domain.config.ConfigObstacles;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigObstaclesConf extends BaseConfigConf<ConfigObstacles> {

	public ConfigObstaclesConf() {
		super(IConfProvider.CONFIG_OBSTACLES);
	}

	private ImmutableMap<Integer, ConfigObstacles> obstaclesMap;

	@Override
	public void onLoadOver() {
		obstaclesMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ConfigObstacles getObstacles(int id) {
		if(obstaclesMap.containsKey(id)) {
			return getConfig(id, obstaclesMap);
		}else{
			return null;
		}
	}
}
