//package com.dj.servercore.conf;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import com.dj.domain.config.ConfigSummonOutput;
//import com.dj.servercore.conf.base.BaseConfigConf;
//import com.dj.servercore.conf.base.IConfProvider;
//import com.dj.domain.util.collection.MapUtil;
//import com.google.common.collect.ImmutableMap;
//import com.google.common.collect.Maps;
//
//public class ConfigSummonsOutputConf extends BaseConfigConf<ConfigSummonOutput> {
//
//	public ConfigSummonsOutputConf() {
//		super(IConfProvider.CONFIG_SUMMONSOUTPUT);
//	}
//
//	private ImmutableMap<Integer, ConfigSummonOutput> summonMap;
//	private Map<Integer, Map<Integer, Integer>> allWeightedMap = Maps.newHashMap();
//
//	@Override
//	public void onLoadOver() {
//		this.summonMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
//
//		allWeightedMap.clear();
//		for (ConfigSummonOutput item : dataList) {
//			Map<Integer, Integer> tmpMap = allWeightedMap.get(item.getType());
//			if (tmpMap == null) {
//				tmpMap = Maps.newHashMap();
//				allWeightedMap.put(item.getType(), tmpMap);
//			}
//			tmpMap.put(item.getID(), item.getWeight());
//		}
//	}
//
//	public ConfigSummonOutput getSummon(int id) {
//		if(summonMap.containsKey(id)) {
//			return getConfig(id, summonMap);
//		}else{
//			return null;
//		}
//	}
//
//	public Map<Integer, Integer> getWeighted(int type) {
//		if(allWeightedMap.containsKey(type)) {
//			return getConfig(type, allWeightedMap);
//		}else{
//			return new HashMap<>();
//		}
//	}
//}
