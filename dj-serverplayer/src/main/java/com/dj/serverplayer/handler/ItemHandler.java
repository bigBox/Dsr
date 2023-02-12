package com.dj.serverplayer.handler;

import com.dj.domain.config.ConfigItems;
import com.dj.domain.config.ConfigNewRoleItem;
import com.dj.domain.entity.player.item.PlayerItem5;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.item.ItemRemoveReq;
import com.dj.servercore.conf.ConfigItemsConf;
import com.dj.servercore.conf.ConfigNewRoleItemConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.serverplayer.handler.base.BaseHandler;
import com.dj.serverplayer.manager.ConfManager;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author zcq
 * @description 物品业务处理
 * @date 2019年4月2日
 */
@Component
@Slf4j
public class ItemHandler extends BaseHandler {

	/**
	 * 获取物品列表
	 *
	 * @param roleID
	 * @param type
	 * @return
	 */
	//public List<GridItem> getItemList(long roleID, int type) {
	//	List<?> lists = null;
	//	List<GridItem> resultList = Lists.newArrayList();
	//	switch (type) {
	//	case ItemType.type1:
	//		lists = playerItem1Dao.cacheLoadAll(roleID);
	//		break;
	//	case ItemType.type2:
	//		lists = playerItem2Dao.cacheLoadAll(roleID);
	//		break;
	//	case ItemType.type3:
	//		lists = playerItem3Dao.cacheLoadAll(roleID);
	//		break;
	//	case ItemType.type4:
	//		lists = playerItem4Dao.cacheLoadAll(roleID);
	//		break;
	//	case ItemType.type5:
	//		lists = playerItem5Dao.cacheLoadAll(roleID);
	//		break;
	//	case ItemType.type6:
	//		lists = playerItem6Dao.cacheLoadAll(roleID);
	//		break;
	//	case ItemType.type7:
	//		lists = playerItem7Dao.cacheLoadAll(roleID);
	//		break;
	//	case ItemType.type100:
	//		lists = playerItem100Dao.cacheLoadAll(roleID);
	//		break;
	//	}
	//	if(lists != null && lists.size() > 0) {
	//		GridItem.Builder builder = GridItem.newBuilder();
	//		lists.forEach(obj -> {
	//			IPlayerItem item = (IPlayerItem) obj;
	//			resultList.add(item.toGridItem(builder));
	//		});
	//	}
	//	return resultList;
	//}

	/**
	 * 删除物品
	 *
	 * @param roleID
	 * @param req
	 */
	public void itemRemove(long roleID, ItemRemoveReq req) {
		costItem(roleID, req.getItemId(), req.getCount(), ResourceBillEnum.itemRemove);
		ConfigItemsConf conf = ConfManager.getInstance().getConfigItemsConf();
		if(conf == null){
			log.error("itemRemove conf == null roleID:{}", roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigItems item = conf.getItem(req.getItemId());
		if(ObjectUtils.isNotEmpty(item)) {
			addGold(roleID, item.getRecyclePrice() * req.getCount(), ResourceBillEnum.itemRemove);
		}
	}

	/**
	 * 初始化玩家物品
	 *
	 * @param roleID
	 */
	public void initNewRoleItem(long roleID) {
		ConfigNewRoleItemConf conf = ConfManager.getInstance().getConfigNewRoleItemConf();
		if(conf == null){
			log.error("initNewRoleItem ConfigNewRoleItemConf conf == null roleID:{}", roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigItemsConf itemsConf = ConfManager.getInstance().getConfigItemsConf();
		if(itemsConf == null){
			log.error("initNewRoleItem ConfigItemsConf itemsConf == null roleID:{}", roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		try {
			ImmutableMap<Integer, ConfigNewRoleItem> newRoleItemMap = conf.getNewRoleItemMap();
			for (ConfigNewRoleItem config : newRoleItemMap.values()) {
				ConfigItems item = itemsConf.getItem(config.getItemId(), false);
				if (ObjectUtils.isNotEmpty(item)) {
					addItem(roleID, config.getItemId(), config.getCount(), ResourceBillEnum.initNewRoleItem, false, false);
				}
			}
			List<PlayerItem5> items5 = playerItem5Dao.cacheLoadAll(roleID);
			if(items5 != null && items5.size() > 0) {
				verifyService.initNewRoleVerify(roleID, items5);
			}
		}catch (Exception e){
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 添加超级人物品
	 * @param roleID
	 */
	public void addSupermanItem(long roleID) {
		ConfigItemsConf itemsConf = ConfManager.getInstance().getConfigItemsConf();
		if(itemsConf == null){
			log.error("addSupermanItem ConfigItemsConf itemsConf == null roleID:{}", roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		Map<Integer, ConfigItems> itemMap = itemsConf.getItemMap();
        for(Map.Entry<Integer, ConfigItems> entry : itemMap.entrySet()) {
			addItem(roleID, entry.getKey(), 100, ResourceBillEnum.addSupermanItem, true, false);
		}
		List<PlayerItem5> items5 = playerItem5Dao.cacheLoadAll(roleID);
		if(items5 != null && items5.size() > 0) {
			verifyService.initNewRoleVerify(roleID, items5);
		}
	}

	/**
	 * 初始化小寻物品
	 *
	 * @param roleID
	 */
	public void initXiaoXunItem(long roleID) {
		Map<Integer, Integer> xiaoxunItem = ConfigSundryConf.xiaoxunItem;
		ConfigItemsConf itemsConf = ConfManager.getInstance().getConfigItemsConf();
		if(itemsConf == null){
			log.error("initXiaoXunItem ConfigItemsConf itemsConf == null roleID:{}", roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		try {
			for (Map.Entry<Integer, Integer> entry : xiaoxunItem.entrySet()) {
				ConfigItems item = itemsConf.getItem(entry.getKey(), false);
				if (ObjectUtils.isNotEmpty(item)) {
					addRobotItem(roleID, entry.getKey(), entry.getValue(), ResourceBillEnum.initXiaoXunItem, false, false);
				}
			}
		}catch (Exception e){
			log.error(e.getMessage());
		}
	}
}
