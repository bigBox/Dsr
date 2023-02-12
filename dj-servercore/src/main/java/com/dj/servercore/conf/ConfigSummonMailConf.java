//package com.dj.servercore.conf;
//
//import com.dj.domain.config.ConfigSummonMail;
//import com.dj.servercore.conf.base.BaseConfigConf;
//import com.dj.servercore.conf.base.IConfProvider;
//import com.dj.domain.util.collection.MapUtil;
//import com.google.common.collect.ImmutableMap;
//
//public class ConfigSummonMailConf extends BaseConfigConf<ConfigSummonMail> {
//
//	public ConfigSummonMailConf() {
//		super(IConfProvider.CONFIG_SUMMONMAIL);
//	}
//
//	private ImmutableMap<Integer, ConfigSummonMail> summonMailMap;
//
//	@Override
//	public void onLoadOver() {
//		summonMailMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
//	}
//
//	public ImmutableMap<Integer, ConfigSummonMail> getSummonMailMap() {
//		return getConfig(summonMailMap);
//	}
//
//	public ConfigSummonMail getSummonMail(int id) {
//		if(summonMailMap.containsKey(id)) {
//			return getConfig(id, summonMailMap);
//		}else{
//			return null;
//		}
//	}
//}
