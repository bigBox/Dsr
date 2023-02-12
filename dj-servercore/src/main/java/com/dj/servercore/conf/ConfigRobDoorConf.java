//package com.dj.servercore.conf;
//
//import com.dj.domain.config.ConfigRobDoor;
//import com.dj.servercore.conf.base.BaseConfigConf;
//import com.dj.servercore.conf.base.IConfProvider;
//import com.dj.domain.util.collection.MapUtil;
//import com.google.common.collect.ImmutableMap;
//
//public class ConfigRobDoorConf extends BaseConfigConf<ConfigRobDoor> {
//
//	public ConfigRobDoorConf() {
//		super(IConfProvider.CONFIG_ROBDOOR);
//	}
//
//	private ImmutableMap<Integer, ConfigRobDoor> robDoorMap;
//
//	@Override
//	public void onLoadOver() {
//		robDoorMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
//	}
//
//	public ImmutableMap<Integer, ConfigRobDoor> getRobDoorMap() {
//		return getConfig(robDoorMap);
//	}
//
//	public ConfigRobDoor getRobDoor(int id) {
//		if(robDoorMap.containsKey(id)) {
//			return getConfig(id, robDoorMap);
//		}else{
//			return null;
//		}
//	}
//}
