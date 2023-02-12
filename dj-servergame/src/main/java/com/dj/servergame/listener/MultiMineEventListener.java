package com.dj.servergame.listener;

import java.util.List;

import com.dj.domain.data.game.MineRole;
import com.dj.domain.data.game.MineRoom;
import com.dj.domain.data.game.SceneCellUnit;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.event.JoinSceneNtfEvent;
import com.dj.domain.event.SceneMapNtfEvent;
import com.dj.domain.event.SceneMovementNtfEvent;
import com.dj.domain.event.SceneUseSkillNtfEvent;
import com.dj.protobuf.common.SceneUpdateType;
import com.dj.protobuf.scene.JoinSceneNtf;
import com.dj.protobuf.scene.SceneCell;
import com.dj.protobuf.scene.SceneMapNtf;
import com.dj.protobuf.scene.SceneMovementNtf;
import com.dj.protobuf.scene.SceneUseSkillNtf;
import com.dj.serverapi.ServiceProvider;
import com.dj.servercore.event.AbsEventListener;
import com.dj.servercore.spring.SpringContext;
import com.dj.servergame.handler.GameMineHandler;
import com.dj.servergame.manager.ChannelManager;
import com.dj.domain.util.Utility;
import com.google.common.collect.Lists;
import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: MultiMineEventListener
 * @Description: 多人挖矿事件监听器
 * @date 2019年6月25日
 */
@Slf4j
public class MultiMineEventListener extends AbsEventListener {

    /**
     * 挖矿地图变更推送
     *
     * @param event
     */
    @Subscribe
    @AllowConcurrentEvents
    public void listenSceneMapNtfEvent(SceneMapNtfEvent event) {
        try {
            SceneMapNtf.Builder builder = SceneMapNtf.newBuilder();
            SceneCell.Builder cellBuilder = SceneCell.newBuilder();
            builder.setType(event.getType());
            if (event.getType() == SceneUpdateType.Total) {
                long mapOwnerRoleID = GameMineHandler.getMapOwnerRoleID(event.getMapOwner());
                List<SceneCellUnit> list;
                if (GameMineHandler.checkIsXXMine(event.getMapOwner())) {
                    list = ServiceProvider.getGameMineService().getMineCellXXList(mapOwnerRoleID);
                } else {
                    list = ServiceProvider.getGameMineService().getMineCellList(mapOwnerRoleID);
                }
                List<SceneCell> cells = Lists.newArrayList();
                if(list != null && list.size() > 0){
                    for(SceneCellUnit unit : list){
                        cells.add(unit.toSceneCell(cellBuilder));
                    }
                }
                builder.addAllCells(cells);
                SceneMapNtf sceneMapNtf = builder.build();
                PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(event.getRoleID());
                ChannelManager.getInstance().sendGameMultiToGate(playerRole.getGateServerID(), playerRole.getRoleID(), sceneMapNtf);
            } else {
                List<SceneCell> cells = Lists.newArrayListWithExpectedSize(event.getList().size());
                if(event.getList() != null && event.getList().size() > 0){
                    for(SceneCellUnit unit : event.getList()){
                        cells.add(unit.toSceneCell(cellBuilder));
                    }
                }
                builder.addAllCells(cells);
                SceneMapNtf sceneMapNtf = builder.build();
                MineRoom mineRoom = SpringContext.getBean(GameMineHandler.class).getMineRoomMap().get(event.getMapOwner());
                for (MineRole mineRole : mineRoom.getMineRoleMap().values()) {
                    PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(mineRole.getRoleID());
                    ChannelManager.getInstance().sendGameMultiToGate(playerRole.getGateServerID(), playerRole.getRoleID(), sceneMapNtf);
                }
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            returnEvent(event);
        }
    }

    /**
     * 挖矿地图上人物加入推送
     *
     * @param event
     */
    @Subscribe
    @AllowConcurrentEvents
    public void listenJoinSceneNtfEvent(JoinSceneNtfEvent event) {
        try {
            JoinSceneNtf.Builder builder = JoinSceneNtf.newBuilder();
            PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(event.getMineRole().getRoleID());
            builder.setJoinRoleInfo(SpringContext.getBean(GameMineHandler.class).getSceneRoleInfo(playerRole, event.getMineRole()));
            JoinSceneNtf joinSceneNtf = builder.build();
            MineRoom mineRoom = SpringContext.getBean(GameMineHandler.class).getMineRoomMap().get(event.getMapOwner());
            for (MineRole mineRole : mineRoom.getMineRoleMap().values()) {
                playerRole = ServiceProvider.getPlayerService().getPlayer(mineRole.getRoleID());
                ChannelManager.getInstance().sendGameMultiToGate(playerRole.getGateServerID(), playerRole.getRoleID(), joinSceneNtf);
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            returnEvent(event);
        }
    }

    /**
     * 挖矿地图上人物移动推送
     *
     * @param event
     */
    @Subscribe
    @AllowConcurrentEvents
    public void listenSceneMovementNtfEvent(SceneMovementNtfEvent event) {
        try {
            SceneMovementNtf.Builder builder = SceneMovementNtf.newBuilder();
            builder.setRoleId(event.getRoleID());
            builder.setMoveType(event.getReq().getMoveType());
            builder.setPos(event.getReq().getPos());
            builder.setSpeed(event.getReq().getSpeed());
            builder.setDirection(event.getReq().getDirection());
            SceneMovementNtf sceneMovementNtf = builder.build();
            MineRoom mineRoom = SpringContext.getBean(GameMineHandler.class).getMineRoomMap().get(event.getMapOwner());
            for (MineRole mineRole : mineRoom.getMineRoleMap().values()) {
                PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(mineRole.getRoleID());
                ChannelManager.getInstance().sendGameMultiToGate(playerRole.getGateServerID(), playerRole.getRoleID(), sceneMovementNtf);
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            returnEvent(event);
        }
    }

    /**
     * 挖矿地图上人物使用技能推送
     *
     * @param event
     */
    @Subscribe
    @AllowConcurrentEvents
    public void listenSceneUseSkillNtfEvent(SceneUseSkillNtfEvent event) {
        try {
            SceneUseSkillNtf.Builder builder = SceneUseSkillNtf.newBuilder();
            builder.setType(event.getReq().getType());
            builder.setSkillId(event.getReq().getSkillId());
            builder.setSkillCount(event.getReq().getSkillCount());
            builder.setSrcRoleId(event.getRoleID());
            builder.setScrRolePos(event.getMineRole().getPosition());
            builder.setSrcRoleDirection(event.getReq().getSrcRoleDirection());
            builder.setTargetRolePos(event.getReq().getTargetPos());
            builder.setTargetRoleId(event.getReq().getTargetRoleId());
            builder.setTargetRoleDirection(event.getReq().getTargetRoleDirection());
            builder.setTargetPos(event.getReq().getTargetPos());
            SceneUseSkillNtf sceneUseSkillNtf = builder.build();
            MineRoom mineRoom = SpringContext.getBean(GameMineHandler.class).getMineRoomMap().get(event.getMapOwner());
            for (MineRole mineRole : mineRoom.getMineRoleMap().values()) {
                PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(mineRole.getRoleID());
                ChannelManager.getInstance().sendGameMultiToGate(playerRole.getGateServerID(), playerRole.getRoleID(), sceneUseSkillNtf);
            }
        } catch (Exception e) {
            log.error(Utility.getTraceString(e));
            returnEvent(event);
        }
    }
}
