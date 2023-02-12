package com.dj.servercore.conf;

import com.dj.domain.config.ConfigNewRoleItem;
import com.dj.domain.util.collection.MapUtil;
import com.dj.domain.util.math.RandomUtil;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

public class ConfigNewRoleItemConf extends BaseConfigConf<ConfigNewRoleItem> {

	public ConfigNewRoleItemConf() {
		super(IConfProvider.CONFIG_NEWROLEITEM);
	}

	private ImmutableMap<Integer, ConfigNewRoleItem> newRoleItemMap;

	@Override
	public void onLoadOver() {
		newRoleItemMap = MapUtil.listToImmMap(dataList, obj -> obj.getId());
	}

	public ImmutableMap<Integer, ConfigNewRoleItem> getNewRoleItemMap() {
		return getConfig(newRoleItemMap);
	}
	
	public Map<Integer, Integer> getRandomReward(){
		Map<Integer, Integer> rewardMap = Maps.newHashMapWithExpectedSize(10);
		for (int i = 0; i < 10; i++) {
			int index = RandomUtil.nextInt(newRoleItemMap.size());
			int count = RandomUtil.nextInt(10)+1;
			ConfigNewRoleItem item = newRoleItemMap.get(index);
			rewardMap.put(item.getItemId(), count);
		}
		return rewardMap;
	}

	public ConfigNewRoleItem getNewRoleItem(int id) {
		if(newRoleItemMap.containsKey(id)) {
			return getConfig(id, newRoleItemMap);
		}else{
			return null;
		}
	}
}
