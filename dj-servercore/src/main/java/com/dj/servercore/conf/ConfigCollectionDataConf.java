package com.dj.servercore.conf;

import com.dj.domain.config.ConfigCollectionData;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigCollectionDataConf extends BaseConfigConf<ConfigCollectionData> {

	public ConfigCollectionDataConf() {
		super(IConfProvider.CONFIG_COLLECTIONDATA);
	}

	private ImmutableMap<Integer, ConfigCollectionData> collectionDataMap;

	@Override
	public void onLoadOver() {
		collectionDataMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigCollectionData> getCollectionDataMap() {
		return getConfig(collectionDataMap);
	}

	public ConfigCollectionData getCollectionData(int id) {
		if(collectionDataMap.containsKey(id)) {
			return getConfig(id, collectionDataMap);
		}else {
			return null;
		}
	}
}
