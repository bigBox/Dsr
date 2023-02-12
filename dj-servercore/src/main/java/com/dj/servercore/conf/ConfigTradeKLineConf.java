//package com.dj.servercore.conf;
//
//import com.dj.domain.config.ConfigTradeKLine;
//import com.dj.servercore.conf.base.BaseConfigConf;
//import com.dj.servercore.conf.base.IConfProvider;
//import com.dj.domain.util.collection.MapUtil;
//import com.google.common.collect.ImmutableMap;
//
//public class ConfigTradeKLineConf extends BaseConfigConf<ConfigTradeKLine> {
//
//	public ConfigTradeKLineConf() {
//		super(IConfProvider.CONFIG_TRADEKLINE);
//	}
//
//	private ImmutableMap<Integer, ConfigTradeKLine> tradeKLineMap;
//
//	@Override
//	public void onLoadOver() {
//		tradeKLineMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
//	}
//
//	public ImmutableMap<Integer, ConfigTradeKLine> getTradeKLineMap() {
//		return getConfig(tradeKLineMap);
//	}
//
//	public ConfigTradeKLine getTradeKLine(int id) {
//		if(tradeKLineMap.containsKey(id)) {
//			return getConfig(id, tradeKLineMap);
//		}else{
//			return null;
//		}
//	}
//}
