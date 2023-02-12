package com.dj.serverplayer.listener;

import java.util.List;

import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.data.game.SceneCellUnit;
import com.dj.domain.event.RobMapEvent;
import com.dj.protobuf.common.SceneUpdateType;
import com.dj.protobuf.datetime.DateTime;
import com.dj.protobuf.item.GridItem;
import com.dj.protobuf.item.ItemUpdateNtf;
import com.dj.protobuf.rob.ERobCellType;
import com.dj.protobuf.rob.RobCell;
import com.dj.protobuf.rob.RobMapNtf;
import com.dj.protobuf.rob.RobNewTreasureNtf;
import com.dj.serverapi.helper.OnlineHelper;
import com.dj.servercore.event.AbsEventListener;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.InitHandler;
import com.dj.serverplayer.manager.ChannelManager;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.domain.util.ThreadUtil;
import com.dj.domain.util.Utility;
import com.dj.serverplayer.manager.ServiceManager;
import com.google.common.collect.Lists;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SingleEventListener extends AbsEventListener {

    @Subscribe
    @AllowConcurrentEvents
    public void listenRobMapEvent(RobMapEvent event) {
        try {
            RobMapNtf.Builder builder = RobMapNtf.newBuilder();
            RobCell.Builder cellBuilder = RobCell.newBuilder();
            if (event.getType() == SceneUpdateType.Total_VALUE) {
                List<SceneCellUnit> list = event.getCellMap().allValues();
                List<RobCell> cells = Lists.newArrayListWithExpectedSize(list.size());
                list.forEach(value->{
                    if(ERobCellType.forNumber(value.getType()) != null) {
                        cells.add(value.toRobCell(cellBuilder));
                    }
                });
                builder.addAllCells(cells);
                builder.setType(SceneUpdateType.Total);
            } else {
                List<RobCell> cells = Lists.newArrayListWithExpectedSize(1);
                if((event.getUpdateCell() != null)&&(ERobCellType.forNumber(event.getUpdateCell().getType()) != null)) {
                    cells.add(event.getUpdateCell().toRobCell(cellBuilder));
                }
                if((event.getLightCell() != null)&&(ERobCellType.forNumber(event.getLightCell().getType()) != null)) {
                	cells.add(event.getLightCell().toRobCell(cellBuilder));
                }
                builder.addAllCells(cells);
                builder.setType(SceneUpdateType.Update);
            }
            int gateID = OnlineHelper.getInstance().getOnlineGateID(event.getRoleID());
            ChannelManager.getInstance().sendPlayerSingleToGate(gateID, event.getRoleID(), builder.build());
            // 大宝点推送
            if(event.getTreasureCell() != null) {
            	RobNewTreasureNtf.Builder robNewTreasureNtf = RobNewTreasureNtf.newBuilder();
            	robNewTreasureNtf.setX(event.getTreasureCell().getX());
            	robNewTreasureNtf.setY(event.getTreasureCell().getY());
            	ChannelManager.getInstance().sendPlayerSingleToGate(gateID, event.getRoleID(), robNewTreasureNtf.build());
            }
            // 进入地图消耗道具推送
            if (event.getType() == SceneUpdateType.Total_VALUE) {
            	ThreadUtil.sleep(500);
            	InitHandler initHandler = SpringContext.getBean(InitHandler.class);
                // 扣除金币和道具
                initHandler.costGold(event.getRoleID(), event.getCfg().getInputGoldNum(), ResourceBillEnum.robJoinMap);
            	int itemID = event.getCfg().getInputItemId();
                int itemNum = event.getCfg().getInputItemNum();
                // 道具变更消息整理一起再推送
                ItemUpdateNtf.Builder itemUpdateNtf = ItemUpdateNtf.newBuilder();
                itemUpdateNtf.setVersion("");
                itemUpdateNtf.setCol(ConfManager.getInstance().getConfigItemsConf().getItemType(itemID));
                itemUpdateNtf.setVisible(false);
                GridItem.Builder itemBuilder = GridItem.newBuilder();
                DateTime.Builder updateTime = DateTime.newBuilder().setValue(System.currentTimeMillis());
                for (int i = 0; i < itemNum; i++) {
                	initHandler.costItem(event.getRoleID(), itemID+i, 1, ResourceBillEnum.robJoinMap, false, false);
                	itemBuilder.setItemId(itemID+i);
                	itemBuilder.setCount((int)ServiceManager.getItemService().getItemCount(event.getRoleID(), itemID+i));
                	itemBuilder.setEffectsId(0);
                	itemBuilder.setEffectsLevel(0);
                	itemBuilder.setEffectsPosition(0);
                	itemBuilder.setUpdateTime(updateTime);
                	itemUpdateNtf.addUpdateData(itemBuilder.build());
                }
        		ChannelManager.getInstance().sendPlayerBasicToGate(gateID, event.getRoleID(), itemUpdateNtf.build());
            }
            
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            returnEvent(event);
        }
    }
}
