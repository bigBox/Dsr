//package com.dj.servercore.conf;
//
//import java.util.List;
//import java.util.Map;
//
//import com.dj.domain.config.ConfigRobTreasure;
//import com.dj.servercore.conf.base.BaseConfigConf;
//import com.dj.servercore.conf.base.IConfProvider;
//import com.dj.domain.util.collection.MapUtil;
//import com.google.common.collect.ImmutableMap;
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//
//public class ConfigRobTreasureConf extends BaseConfigConf<ConfigRobTreasure> {
//
//	public ConfigRobTreasureConf() {
//		super(IConfProvider.CONFIG_ROBTREASURE);
//	}
//
//	private ImmutableMap<String, ConfigRobTreasure> treasureMap;
//
//	// 101:第一轮必出稀有概率
//	private List<ConfigRobTreasure> treasure101 = Lists.newArrayList();
//	// 第二轮（出2-8个宝物 ）901出所有宝物概率。
//	private List<ConfigRobTreasure> treasure901 = Lists.newArrayList();
//
//	@Override
//	public void onLoadOver() {
//		treasureMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
//		treasure101.clear();
//		treasure901.clear();
//		for (ConfigRobTreasure configRobTreasure : dataList) {
//			if(configRobTreasure.getID().startsWith("101")) {
//				treasure101.add(configRobTreasure);
//			}else {
//				treasure901.add(configRobTreasure);
//			}
//		}
//	}
//
//	public ConfigRobTreasure getTreasure(String id) {
//		if(treasureMap.containsKey(id)) {
//			return getConfig(id, treasureMap);
//		}else{
//			return null;
//		}
//	}
//
//	public Map<Integer, Integer> getWeighted101(int mapID, int floor) {
//		Map<Integer, Integer> weightedMap = Maps.newHashMap();
//		for (ConfigRobTreasure treasure : treasure101) {
////			if (treasure.getMapID_1() != mapID || treasure.getFloor_3() != floor) {
////				continue;
////			}
//			weightedMap.put(treasure.getItemGet(), treasure.getWeight());
//		}
//		return weightedMap;
//	}
//
//	public Map<Integer, Integer> getWeighted901(int mapID, int floor) {
//		Map<Integer, Integer> weightedMap = Maps.newHashMap();
//		for (ConfigRobTreasure treasure : treasure901) {
////			if (treasure.getMapID_1() != mapID || treasure.getFloor_3() != floor) {
////				continue;
////			}
//			weightedMap.put(treasure.getItemGet(), treasure.getWeight());
//		}
//		return weightedMap;
//	}
//}
