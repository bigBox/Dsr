package com.dj.servergame.handler;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.config.ConfigRobCfg;
import com.dj.domain.entity.robot.RobotFactory;
import com.dj.domain.entity.robot.RobotObstacle;
import com.dj.domain.enums.PlayerAttrEnum;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.entity.player.*;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.item.*;
import com.dj.protobuf.obstacle.ObstaclesListReq;
import com.dj.protobuf.obstacle.ObstaclesListRsp;
import com.dj.protobuf.scene.OtomeVector3D;
import com.dj.protobuf.scene.ScenePosReq;
import com.dj.protobuf.scene.ScenePosRsp;
import com.dj.protobuf.showtable.*;
import com.dj.serverapi.ServiceProvider;
import com.dj.servercore.conf.ConfigRobCfgConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servergame.manager.EventManager;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.collection.MapUtil;
import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class GameHomeHandler extends ServiceProvider {

    /**
     *	获取主页建筑位置
     *
     * @param roleID
     * @param builder
     */
    public void getScenePos(long roleID, ScenePosReq req, ScenePosRsp.Builder builder) {
        if(req.getRoleId() != GlobalRoleID.getXiaoXun()) {
            List<PlayerFactory> factorys = gameService.getFactory(req.getRoleId());
            if (factorys != null) {
                Map<Integer, OtomeVector3D> pos = Maps.newHashMapWithExpectedSize(factorys.size());
                OtomeVector3D.Builder       pp  = OtomeVector3D.newBuilder();
                factorys.forEach(factory -> {
                    pp.setX(factory.getPointX());
                    pp.setY(factory.getPointY());
                    pos.put(factory.getFactoryID(), pp.build());
                });
                builder.putAllPos(pos);
            }
        }else {
            List<RobotFactory> factorys = gameService.getRobotFactory(roleID);
            if (factorys != null) {
                Map<Integer, OtomeVector3D> pos = Maps.newHashMapWithExpectedSize(factorys.size());
                OtomeVector3D.Builder       pp  = OtomeVector3D.newBuilder();
                factorys.forEach(factory -> {
                    pp.setX(factory.getPointX());
                    pp.setY(factory.getPointY());
                    pos.put(factory.getFactoryID(), pp.build());
                });
                builder.putAllPos(pos);
            }
        }
    }

    /**
     *	获取荒地列表
     *
     * @param roleID
     * @param builder
     */
    public void getObstaclesList(long roleID, ObstaclesListReq req, ObstaclesListRsp.Builder builder) {
        if(req.getRoleId() != GlobalRoleID.getXiaoXun()) {
            List<PlayerObstacle> obstacles = gameService.getObstacle(roleID);
            if (obstacles != null) {
                Map<Integer, Integer> land = Maps.newHashMapWithExpectedSize(obstacles.size());
                obstacles.forEach(obstacle -> {
                    land.put(obstacle.getObstacleID(), obstacle.getIsOpen());
                });
                builder.putAllLand(land);
            }
        }else {
            List<RobotObstacle> obstacles = gameService.getRobotObstacle(roleID);
            if (obstacles != null) {
                Map<Integer, Integer> land = Maps.newHashMapWithExpectedSize(obstacles.size());
                obstacles.forEach(obstacle -> {
                    land.put(obstacle.getObstacleID(), obstacle.getIsOpen());
                });
                builder.putAllLand(land);
            }
        }
    }

    /**
     *	获取展厅
     *
     * @param roleID
     * @param type
     * @param page
     * @param builder
     */
    public void getShowTable(long roleID, int type, int page, ShowTableRsp.Builder builder) {
        Map<Integer, PlayerShowTable> showTables = showTableService.getShowTable(roleID, type, page);
        ShowTableGrids.Builder showTableGrids = ShowTableGrids.newBuilder();
        if (showTables != null && showTables.size() > 0) {
        	Date nowDate = DateUtil.getCurrentDate();
            Map<Integer, ShowTableItem> itemMap = Maps.newHashMapWithExpectedSize(showTables.size());
            ShowTableItem.Builder tableBuilder = ShowTableItem.newBuilder();
            showTables.forEach((key, value)->{
            	 itemMap.put(value.getIndex(), value.toShowTableItem(tableBuilder, nowDate));
            });
            showTableGrids.putAllGrids(itemMap);
        }
        PlayerShowTableMoney showTableMoney = showTableService.getShowTableMoney(roleID);
        int money = showTableMoney.getMoney(type);
        if(money < 0) {
        	money = 0;
        }
        showTableGrids.setMoney(money);
        showTableGrids.setResetTime(DateTime.newBuilder().setValue(showTableMoney.getResetTime()));
        builder.setGrids(showTableGrids);
    }


    /**
     * 展厅点赞
     * @param roleID
     * @param req
     */
	public void showTableSupport(long roleID, ShowTableSupportReq req) {
		showTableService.showTableSupport(roleID, req.getRoleId(), req.getType());
		// 为好友添加声望
        ServiceProvider.getCommonService().addAttrBill(req.getRoleId(), PlayerAttrEnum.RENOWN.getKey(), 10, ResourceBillEnum.showTableSupport);
        EventManager.postSyncAttrEvent(req.getRoleId());
        EventManager.commitRoleEvent(req.getRoleId());
	}
	
	/**
	 * 获取好友家道具数量
	 * @param roleID
	 * @param req
	 * @param builder
	 */
	public void itemFriend(long roleID, ItemFriendReq req, ItemFriendRsp.Builder builder) {
		Map<Integer, Long> mapPieceMap = itemService.getItemCount(req.getRoleId());
		if(roleID == req.getRoleId()) {
			if(buffService.getNpcSkill(roleID).getSkillID() == 1) {
				//所有宝藏图最少的3个地图碎片各补2张
				mapPieceMap = MapUtil.sortMapByValues(mapPieceMap);
        		int mapCount = 0;
        		for(Map.Entry<Integer, Long> ctEntry : mapPieceMap.entrySet()) {
        			itemService.addItemBill(roleID, ctEntry.getKey(), 2, ResourceBillEnum.npcSkill1, true, true);
        			mapCount++;
        			if(mapCount >= 3) {
        				break;
        			}
        		}
                EventManager.postSyncItemEvent(roleID);

				buffService.setNpcSkill(roleID, 0, 0);
			}
		}
		for (Integer itemID : req.getItemIdList()) {
            Long itemCount = mapPieceMap.get(itemID);
            if(itemCount != null) {
                builder.putItemCount(itemID, itemCount.intValue());
            }else {
                builder.putItemCount(itemID, 0);
            }
		}
	}

	/**
	 * 和好友互动物品
	 * @param roleID
	 * @param req
	 */
	public void itemInteract(long roleID, ItemInteractReq req) {
		if(req.getCount() > 0) {
			long count = itemService.getItemCount(roleID, req.getItemId());
			// 赠与
			if(req.getCount() > count) {
				throw new CommonException(ErrorID.COMMON_PLAYER_ITEM_LESS, "roleID:" + roleID + ", costItem:" + req.getItemId() + ", count:" + count);
			}
			// 自己扣物品
			itemService.addItemBill(roleID, req.getItemId(), -req.getCount(), ResourceBillEnum.itemInteract, true, false);
            EventManager.postSyncItemEvent(roleID);
			// 好友加物品
			itemService.addItemBill(req.getRoleId(), req.getItemId(), req.getCount(), ResourceBillEnum.itemInteract, true, false);
            EventManager.postSyncItemEvent(req.getRoleId());
		}else {
			long count = itemService.getItemCount(req.getRoleId(), req.getItemId());
			if(count == 1) {
				throw new CommonException(ErrorID.FRIEND_LEAVE_LITTLE);
			}
			// 借用
			if(-req.getCount() > count) {
				throw new CommonException(ErrorID.COMMON_PLAYER_ITEM_LESS, "roleID:" + req.getRoleId() + ", costItem:" + req.getItemId() + ", count:" + count);
			}
			// 自己加物品
			itemService.addItemBill(roleID, req.getItemId(), -req.getCount(), ResourceBillEnum.itemInteract, true, false);
            EventManager.postSyncItemEvent(roleID);
			// 好友扣物品
			itemService.addItemBill(req.getRoleId(), req.getItemId(), req.getCount(), ResourceBillEnum.itemInteract, true, false);
            EventManager.postSyncItemEvent(req.getRoleId());
		}
		itemService.addItemInteractLog(req.getRoleId(), req.getItemId(), req.getCount(), roleID, req.getPs());
        
		EventManager.postSyncItemInteractEvent(req.getRoleId());
        EventManager.commitRoleEvent(roleID);
        EventManager.commitRoleEvent(req.getRoleId());
	}

    /**
     *	获取展厅
     *
     * @param roleID
     * @param page
     * @param builder
     */
    public void getShowTableInfo(long roleID, int type, int page, GetShowTableInfoRsp.Builder builder) {
        PlayerShowTableInfo showTableInfo = showTableService.getShowTableInfo(roleID, type, page);
        if(showTableInfo != null){
            builder.setRoleId(roleID);
            builder.setType(type);
            builder.setPage(page);
            builder.setInfo(showTableInfo.getInfo());
        }else {
            builder.setRoleId(roleID);
            builder.setType(type);
            builder.setPage(page);
            builder.setInfo("");
        }
    }

    /**
     *	获取展厅
     *
     * @param roleID
     * @param page
     * @param info
     */
    public void saveShowTableInfo(long roleID, int type, int page, String info) {
        PlayerShowTableInfo showTableInfo = showTableService.getShowTableInfo(roleID, type, page);
        if (showTableInfo != null) {
            showTableInfo.setInfo(info);
        }else {
            showTableInfo = new PlayerShowTableInfo();
            showTableInfo.setRoleID(roleID);
            showTableInfo.setType(type);
            showTableInfo.setPage(page);
            showTableInfo.setInfo(info);
        }
        showTableService.setShowTableInfo(roleID, showTableInfo);
    }

    public void playerMapItem(long roleID, PlayerMapItemReq req, PlayerMapItemRsp.Builder builder) {
        ConfigRobCfgConf conf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_ROBCFG);
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        Map<Integer, ConfigRobCfg> cfgMap = conf.getCfgMap();
        Map<Integer, Long> mapPieceMap = itemService.getItemCount(req.getRoleId());
        for(Integer mapId : cfgMap.keySet()){
            ConfigRobCfg robCfg = cfgMap.get(mapId);
            int itemID = robCfg.getInputItemId();
            int itemNum = robCfg.getInputItemNum();
            Long minCount = Long.MAX_VALUE;
            for (int i = 0; i < itemNum-1; i++) {
                Long count = mapPieceMap.get(itemID+i);
                if((count != null)&&(count < minCount)) {
                    minCount = count;
                }
            }
            builder.putItemCount(mapId, minCount.intValue());
        }
    }
}
