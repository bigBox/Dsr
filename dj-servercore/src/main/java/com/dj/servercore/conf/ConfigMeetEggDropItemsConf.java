package com.dj.servercore.conf;

import com.dj.domain.config.ConfigMeetEggDropItems;
import com.dj.domain.config.ConfigMeetEggGhostData;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.math.RandomUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConfigMeetEggDropItemsConf extends BaseConfigConf<ConfigMeetEggDropItems> {

	public ConfigMeetEggDropItemsConf() {
		super(IConfProvider.CONFIG_MEETEGGDROPITEMS);
	}

	private ImmutableMap<Integer, ConfigMeetEggDropItems> dropMap;

	private Map<Integer, List<Integer>> subTypeMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		dropMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());

		subTypeMap.clear();
		for (ConfigMeetEggDropItems item : dataList) {
			List<Integer> subTypeList;
			if(subTypeMap.containsKey(item.getSubType())){
				subTypeList = subTypeMap.get(item.getSubType());
				subTypeList.add(item.getID());
			}else {
				subTypeList = new ArrayList<>();
				subTypeList.add(item.getID());
			}
			subTypeMap.put(item.getSubType(), subTypeList);
		}
	}

	public ConfigMeetEggDropItems getMeetEggDropItems(int itemId) {
		if(dropMap.containsKey(itemId)) {
			return getConfig(itemId, dropMap);
		}else{
			return null;
		}
	}

	public ConfigMeetEggDropItems getMeetEggRandomDropItems(int subType) {
		if(subTypeMap.containsKey(subType)) {
			List<Integer> subTypeList = subTypeMap.get(subType);
			Integer itemId = RandomUtil.getRandomListElement(subTypeList);
			if(dropMap.containsKey(itemId)) {
				return getConfig(itemId, dropMap);
			}
		}
		return null;
	}
}
