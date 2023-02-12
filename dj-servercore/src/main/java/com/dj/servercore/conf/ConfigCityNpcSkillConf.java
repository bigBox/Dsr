package com.dj.servercore.conf;

import java.util.Map;

import com.dj.domain.config.ConfigCityNpcSkill;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

public class ConfigCityNpcSkillConf extends BaseConfigConf<ConfigCityNpcSkill> {

	public ConfigCityNpcSkillConf() {
		super(IConfProvider.CONFIG_CITY_NPC_SKILL);
	}

	private ImmutableMap<Integer, ConfigCityNpcSkill> cityNpcSkillMap;
	private Map<Integer, Integer> npcSkillWeightedMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		cityNpcSkillMap = MapUtil.listToImmMap(dataList, obj -> obj.getID());
		npcSkillWeightedMap.clear();
		//for(ConfigCityNpcSkill cityNpcSkill : dataList) {
		//	npcSkillWeightedMap.put(cityNpcSkill.getID(), cityNpcSkill.getProb());
		//}
	}

	public ImmutableMap<Integer, ConfigCityNpcSkill> getCityNpcSkillMap() {
		return getConfig(cityNpcSkillMap);
	}

	public ConfigCityNpcSkill getCityNpcSkill(int id) {
		if(cityNpcSkillMap.containsKey(id)) {
			return getConfig(id, cityNpcSkillMap);
		}else {
			return null;
		}

	}
	
	public Map<Integer, Integer> getNpcSkillWeightedMap(){
		return getConfig(npcSkillWeightedMap);
	}
}
