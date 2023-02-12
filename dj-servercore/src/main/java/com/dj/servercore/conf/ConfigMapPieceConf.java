package com.dj.servercore.conf;

import com.dj.domain.config.ConfigMapPiece;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.math.RandomUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

public class ConfigMapPieceConf extends BaseConfigConf<ConfigMapPiece> {

	public ConfigMapPieceConf() {
		super(IConfProvider.CONFIG_MAPPIECE);
	}

	private ImmutableMap<Integer, ConfigMapPiece> mapPieceMap;

	private Map<Integer, Integer> allWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		allWeightedMap.clear();
		mapPieceMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
		for (ConfigMapPiece item : dataList) {
			allWeightedMap.put(item.getItemGet(), item.getWeight());
		}
	}

	public ImmutableMap<Integer, ConfigMapPiece> getMapPieceMap() {
		return getConfig(mapPieceMap);
	}


	public int getMapPiece() {
		// 随机类型
		return RandomUtil.weightedRandom(allWeightedMap);
	}

	public Map<Integer, Integer> getWeightedMap() {
		return allWeightedMap;
	}
}
