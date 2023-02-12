package com.dj.servercore.conf;

import com.dj.domain.config.ConfigMonthCard;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;

public class ConfigMonthCardConf extends BaseConfigConf<ConfigMonthCard> {

	public ConfigMonthCardConf() {
		super(IConfProvider.CONFIG_MONTHCARD);
	}

	private ImmutableMap<Integer, ConfigMonthCard> monthCardMap;

	@Override
	public void onLoadOver() {
		monthCardMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
	}

	public ImmutableMap<Integer, ConfigMonthCard> getMonthCardMap() {
		return getConfig(monthCardMap);
	}

	public ConfigMonthCard getMonthCard(int id) {
		if(monthCardMap.containsKey(id)) {
			return getConfig(id, monthCardMap);
		}else{
			return null;
		}
	}
}
