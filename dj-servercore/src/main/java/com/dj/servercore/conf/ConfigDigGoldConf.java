package com.dj.servercore.conf;

import com.dj.domain.config.ConfigDigGold;
import com.dj.domain.constant.ConstantGame;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.math.RandomUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConfigDigGoldConf extends BaseConfigConf<ConfigDigGold> {

	public ConfigDigGoldConf() {
		super(IConfProvider.CONFIG_DIGGOLD);
	}

	private ImmutableMap<Integer, ConfigDigGold> digGoldMap;

	private Map<Integer, Integer> allWeightedMap = Maps.newHashMap();

	private Map<Integer, Double> layerWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		allWeightedMap.clear();
		digGoldMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
		for (ConfigDigGold item : dataList) {
			allWeightedMap.put(item.getType(), item.getWeight());
		}
		double mineLayerResourceRatio = 1.05D;//+ (double)(ConfigSundryConf.mineLayerResourceRatio/100)
		double curRatio = 1.00D;
		for(int i = 1; i <= ConstantGame.MINE_Y; i++){
			layerWeightedMap.put(i, curRatio);
			curRatio = curRatio * mineLayerResourceRatio;
		}
	}

	public ImmutableMap<Integer, ConfigDigGold> getDigGoldMap() {
		return getConfig(digGoldMap);
	}

	public ConfigDigGold getDigGold(int type) {
		List<ConfigDigGold> list = new ArrayList<>();
		for (ConfigDigGold config : digGoldMap.values()) {
			if(config.getType() == type){
				list.add(config);
			}
		}
		int id = 0;
		if(list.size() > 1) {
			id = RandomUtil.nextInt(list.size());
		}
		return list.get(id);
	}

	public Map<Integer, Integer> getLayerWeight(int layer) {
		// 挖矿非资源系数
		double layRatio = 1.00D;
		if(layerWeightedMap.containsKey(layer)){
			layRatio = layerWeightedMap.get(layer);
		}
		Map<Integer, Integer> weightMap = Maps.newHashMapWithExpectedSize(20);
		for (ConfigDigGold config : digGoldMap.values()) {
			if (config.getWeight() > 0) {
				if(ConfigSundryConf.mineLayerEmptyWeight.containsKey(config.getType())){
					weightMap.put(config.getType(), config.getWeight());
				}else {
					weightMap.put(config.getType(), (int) (config.getWeight() * layRatio));
				}
			}
		}
		// 挖矿空资源权重
		//weightMap.putAll(ConfigSundryConf.mineLayerEmptyWeight);
		return weightMap;
	}

	public Map<Integer, Integer> getWeightedMap() {
		return allWeightedMap;
	}
}
