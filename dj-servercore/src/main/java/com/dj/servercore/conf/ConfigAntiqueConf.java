package com.dj.servercore.conf;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dj.domain.config.ConfigAntique;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

public class ConfigAntiqueConf extends BaseConfigConf<ConfigAntique> {

	public ConfigAntiqueConf() {
		super(IConfProvider.CONFIG_ANTIQUE);
	}

	/**
	 * 套装
	 */
	private List<Set<Integer>> suitList = Lists.newArrayList();
	/**
	 * 合成，子图列表
	 */
	private Map<Integer, Set<Integer>> composeMap = Maps.newHashMap();
	/**
	 * 合成，子图个数
	 */
	private Map<Integer, Integer> composeCountMap = Maps.newHashMap();

	@Override
	public void onLoadOver() {
		suitList.clear();
		composeMap.clear();
		composeCountMap.clear();
		for (ConfigAntique antique : dataList) {
			if (antique.getComposeID() > 0) {
				Set<Integer> compose = composeMap.get(antique.getComposeID());
				if (compose == null) {
					compose = Sets.newHashSet();
					composeMap.put(antique.getComposeID(), compose);
				}
				addSub(compose, antique.getId());
				addSub(compose, antique.getSub1());
				addSub(compose, antique.getSub2());
				addSub(compose, antique.getSub3());
				addSub(compose, antique.getSub4());
				addSub(compose, antique.getSub5());
				addSub(compose, antique.getSub6());
				addSub(compose, antique.getSub7());
				composeCountMap.put(antique.getComposeID(), antique.getNum());
			} else {
				Set<Integer> suit = Sets.newHashSet();
				suitList.add(suit);
				addSub(suit, antique.getId());
				addSub(suit, antique.getSub1());
				addSub(suit, antique.getSub2());
				addSub(suit, antique.getSub3());
				addSub(suit, antique.getSub4());
				addSub(suit, antique.getSub5());
				addSub(suit, antique.getSub6());
				addSub(suit, antique.getSub7());
			}
		}
//		for (Set<Integer> suit : suitList) {
//			log.info("套装 {}", suit.toString());
//		}
//		for (Map.Entry<Integer, Set<Integer>> entry : composeMap.entrySet()) {
//			log.info("合成ID {}, 子物品 {} {}", entry.getKey(), composeCountMap.get(entry.getKey()), entry.getValue().toString());
//		}
	}

	public List<Set<Integer>> getSuitList() {
		return getConfig(suitList);
	}

	/**
	 * 添加合成子图
	 * 
	 * @param sets
	 * @param subID
	 */
	private void addSub(Set<Integer> sets, int subID) {
		if (subID > 0) {
			sets.add(subID);
		}
	}

	/**
	 * 获取合成子图列表
	 * 
	 * @param composeID
	 * @return
	 */
	public Set<Integer> getComposeSub(int composeID) {
		if(composeMap.containsKey(composeID)) {
			return getConfig(composeID, composeMap);
		}else {
			return new HashSet<>();
		}
	}

	/**
	 * 获取合成子图个数
	 * 
	 * @param composeID
	 * @return
	 */
	public int getComposeCount(int composeID) {
		if(composeCountMap.containsKey(composeID)) {
			return getConfig(composeID, composeCountMap);
		}else {
			return 0;
		}
	}
}
