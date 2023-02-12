//package com.dj.servercore.conf;
//
//import java.util.Map;
//
//import com.dj.domain.config.ConfigRobEvent;
//import com.dj.servercore.conf.base.BaseConfigConf;
//import com.dj.servercore.conf.base.IConfProvider;
//import com.dj.domain.util.collection.MapUtil;
//import com.google.common.collect.ImmutableMap;
//import com.google.common.collect.Maps;
//
//public class ConfigRobEventConf extends BaseConfigConf<ConfigRobEvent> {
//
//	public ConfigRobEventConf() {
//		super(IConfProvider.CONFIG_ROBEVENT);
//	}
//
//	private ImmutableMap<Integer, ConfigRobEvent> robMap;
//
//	private Map<Integer, Map<Integer, Integer>> allWeightedMap = Maps.newHashMap();
//
//	@Override
//	public void onLoadOver() {
//		robMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
//
//		allWeightedMap.clear();
//		for (ConfigRobEvent item : dataList) {
//			Map<Integer, Integer> tmpMap = allWeightedMap.get(item.getType());
//			if (tmpMap == null) {
//				tmpMap = Maps.newHashMap();
//				allWeightedMap.put(item.getType(), tmpMap);
//			}
//			tmpMap.put(item.getID(), item.getWeight());
//		}
//	}
//
//	public ConfigRobEvent getRob(int id) {
//		if(robMap.containsKey(id)) {
//			return getConfig(id, robMap);
//		}else{
//			return null;
//		}
//	}
//
//	public Map<Integer, Integer> getWeighted(int type) {
//		if(allWeightedMap.containsKey(type)) {
//			return getConfig(type, allWeightedMap);
//		}else{
//			return null;
//		}
//	}
//}
