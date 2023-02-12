package com.dj.servercore.conf;

import java.util.HashMap;
import java.util.Map;

import com.dj.domain.config.ConfigCollectionItems;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class ConfigCollectionItemsConf extends BaseConfigConf<ConfigCollectionItems> {

	public ConfigCollectionItemsConf() {
		super(IConfProvider.CONFIG_COLLECTIONITEMS);
	}

	private ImmutableMap<Integer, ConfigCollectionItems> collectionItemMap;

	private Map<Integer, Map<Integer, ConfigCollectionItems>> antiqueMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		collectionItemMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
		antiqueMap.clear();
		for(ConfigCollectionItems item : dataList) {
			Map<Integer, ConfigCollectionItems> map = antiqueMap.get(item.getAntiqueId());
			if(map == null) {
				map = Maps.newHashMap();
				antiqueMap.put(item.getAntiqueId(), map);
			}
			map.put(item.getID(), item);
		}
	}

	public ImmutableMap<Integer, ConfigCollectionItems> getCollectionItemsMap() {
		return getConfig(collectionItemMap);
	}

	public ConfigCollectionItems getCollectionItems(int id) {
		return getConfig(id, collectionItemMap, false);
	}
	
	public Map<Integer, Map<Integer, ConfigCollectionItems>> getAntiqueMap() {
		return getConfig(antiqueMap);
	}

	public Map<Integer, ConfigCollectionItems> getAntique(int id) {
		if(antiqueMap.containsKey(id)) {
			return getConfig(id, antiqueMap);
		}else{
			return new HashMap<>();
		}
	}
}
