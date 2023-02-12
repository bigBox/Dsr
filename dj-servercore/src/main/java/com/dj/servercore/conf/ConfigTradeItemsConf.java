package com.dj.servercore.conf;

import com.dj.domain.constant.ConstantGame;
import com.dj.domain.config.ConfigTradeItems;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigTradeItemsConf extends BaseConfigConf<ConfigTradeItems> {

	public ConfigTradeItemsConf() {
		super(IConfProvider.CONFIG_TRADEITEMS);
	}

	private ImmutableMap<Integer, ConfigTradeItems> tradeItemsMap;

	@Override
	public void onLoadOver() {
		// 添加钻石
		ConfigTradeItems configTradeItems = new ConfigTradeItems();
		configTradeItems.setID(ConstantGame.DIAMOND);
		configTradeItems.setItemName("钻石");
		configTradeItems.setType(5);
		configTradeItems.setPlaceType(1);
		dataList.add(configTradeItems);
		tradeItemsMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigTradeItems> getTradeItemsMap() {
		return getConfig(tradeItemsMap);
	}

	public ConfigTradeItems getTradeItems(int id) {
		if(tradeItemsMap.containsKey(id)) {
			return getConfig(id, tradeItemsMap);
		}else{
			return null;
		}
	}
}
