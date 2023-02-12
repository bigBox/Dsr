package com.dj.servercore.conf;

import java.util.HashMap;
import java.util.Map;

import com.dj.domain.constant.ConstantGame;
import com.dj.domain.enums.ItemColor;
import com.dj.domain.type.ItemType;
import com.dj.domain.config.ConfigItems;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.servercore.conf.base.BaseConfigConf;
import com.dj.servercore.conf.base.IConfProvider;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.MapUtils;

public class ConfigItemsConf extends BaseConfigConf<ConfigItems> {

	public ConfigItemsConf() {
		super(IConfProvider.CONFIG_ITEMS);
	}

	private Map<Integer, ConfigItems> itemMap = Maps.newHashMap();
	private Map<Integer, Integer> itemType = Maps.newHashMap();
	private Map<String, String> itemName = Maps.newHashMap();
	private Map<Integer, ConfigItems> item1Map = Maps.newHashMap();
	private Map<Integer, ConfigItems> item2Map = Maps.newHashMap();
	private Map<Integer, ConfigItems> item3Map = Maps.newHashMap();
	private Map<Integer, ConfigItems> item4Map = Maps.newHashMap();
	private Map<Integer, ConfigItems> item5Map = Maps.newHashMap();
	private Map<Integer, ConfigItems> item6Map = Maps.newHashMap();
	private Map<Integer, ConfigItems> item7Map = Maps.newHashMap();
	private Map<Integer, ConfigItems> item100Map = Maps.newHashMap();

	private Map<Integer, Map<Integer, Integer>> verifyMap = Maps.newHashMap();
	@Override
	public void onLoadOver() {
		// 添加钻石
		ConfigItems configitems = new ConfigItems();
		configitems.setID(ConstantGame.DIAMOND);
		configitems.setGold(1000);
		dataList.add(configitems);
		itemMap.clear();
		itemType.clear();
		itemName.clear();
		item1Map.clear();
		item2Map.clear();
		item3Map.clear();
		item4Map.clear();
		item5Map.clear();
		item6Map.clear();
		item7Map.clear();
		item100Map.clear();
		verifyMap.clear();

		for (ConfigItems item : dataList) {
			itemMap.put(item.getID(), item);
			itemType.put(item.getID(), item.getWarehouseType());
			itemName.put(String.valueOf(item.getID()), item.getName());
			switch (item.getWarehouseType()) {
			case ItemType.type1:
				item1Map.put(item.getID(), item);
				break;
			case ItemType.type2:
				item2Map.put(item.getID(), item);
				break;
			case ItemType.type3:
				item3Map.put(item.getID(), item);
				break;
			case ItemType.type4:
				item4Map.put(item.getID(), item);
				break;
			case ItemType.type5:
				item5Map.put(item.getID(), item);
				break;
			case ItemType.type6:
				item6Map.put(item.getID(), item);
				break;
			case ItemType.type7:
				item7Map.put(item.getID(), item);
				break;
			case ItemType.type100:
				item100Map.put(item.getID(), item);
				break;
			}
			// 图鉴配置
			if ((item.getWarehouseType() == 5)
					&& (item.getColor() != ItemColor.color1.getColor())
					&& (item.getVerify() > 0)) {
				Map<Integer, Integer> map = verifyMap.get(item.getVerify());
				if(map == null){
					map = new HashMap<Integer, Integer>();
				}
				map.put(item.getColor(), item.getID());
				verifyMap.put(item.getVerify(), map);
			}
		}
	}

	public ConfigItems getItem(int id) {
		if(itemMap.containsKey(id)) {
			return getConfig(id, itemMap);
		}else{
			return null;
		}
	}

	public ConfigItems getItem(int id, boolean check) {
		if(itemMap.containsKey(id)) {
			return getConfig(id, itemMap, check);
		}else{
			return null;
		}
	}

	public Integer getItemIdByType(int id, int color) {
		if(verifyMap.containsKey(id)) {
			Map<Integer, Integer> map = getConfig(id, verifyMap);
			if(map != null && map.containsKey(color)){
				return map.get(color);
			}
		}
		return 0;
	}
	public Map<Integer, ConfigItems> getItemMap() {
		return getConfig(itemMap);
	}

	public Map<Integer, ConfigItems> getTypeItem(int type) {
		Map<Integer, ConfigItems> resultMap = null;
		switch (type) {
		case ItemType.type1:
			resultMap = item1Map;
			break;
		case ItemType.type2:
			resultMap = item2Map;
			break;
		case ItemType.type3:
			resultMap = item3Map;
			break;
		case ItemType.type4:
			resultMap = item4Map;
			break;
		case ItemType.type5:
			resultMap = item5Map;
			break;
		case ItemType.type6:
			resultMap = item6Map;
			break;
		case ItemType.type7:
			resultMap = item7Map;
			break;
		case ItemType.type100:
			resultMap = item100Map;
			break;
		}
		return resultMap;
	}

	public int getItemType(int itemID) {
		if (itemType.containsKey(itemID)) {
			return getConfig(itemID, itemType);
		} else {
			return 0;
		}
	}

	public String getItemName(String itemID) {
		return MapUtils.getString(itemName, itemID, itemID);
	}

	public void addCollectionItem(ConfigItems item) {
		if (itemMap.containsKey(item.getID())) {
			throw new CommonException(ErrorID.COMMON_CONFIG_ERROR, item.getID());
		}
		itemMap.put(item.getID(), item);
		itemType.put(item.getID(), item.getWarehouseType());
		itemName.put(String.valueOf(item.getID()), item.getName());
		item100Map.put(item.getID(), item);
	}
}
