package com.dj.servercore.conf;

import com.dj.domain.config.ConfigMiniGame;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigMiniGameConf extends BaseConfigConf<ConfigMiniGame> {

	public ConfigMiniGameConf() {
		super(IConfProvider.CONFIG_MINIGAME);
	}

	private ImmutableMap<Integer, ConfigMiniGame> miniGameMap;

	@Override
	public void onLoadOver() {
		miniGameMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigMiniGame> getMiniGameMap() {
		return getConfig(miniGameMap);
	}

	public ConfigMiniGame getMiniGame(int id) {
		if(miniGameMap.containsKey(id)) {
			return getConfig(id, miniGameMap);
		}else{
			return null;
		}
	}
}
