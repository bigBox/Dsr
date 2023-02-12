package com.dj.servercore.conf;

import com.dj.domain.config.ConfigVirtualItems;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigVirtualItemsConf extends BaseConfigConf<ConfigVirtualItems> {

	public ConfigVirtualItemsConf() {
		super(IConfProvider.CONFIG_VIRTUAL_ITEMS);
	}

	private ImmutableMap<Integer, ConfigVirtualItems> virtualItemsMap;

	@Override
	public void onLoadOver() {
		virtualItemsMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigVirtualItems> getVirtualItemsMap() {
		return getConfig(virtualItemsMap);
	}

	public ConfigVirtualItems getVirtualItem(int id) {
		if(virtualItemsMap.containsKey(id)) {
			return getConfig(id, virtualItemsMap, false);
		}else{
			return null;
		}
	}
}
