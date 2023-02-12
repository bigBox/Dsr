package com.dj.serverplayer.helper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.config.ConfigFarmParkAnimal;
import com.dj.domain.data.game.ParkAnimalUnit;
import com.dj.domain.data.summon.SummonData;
import com.dj.domain.entity.player.PlayerLeaveHistory;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.park.*;
import com.dj.servercore.conf.ConfigFarmParkAnimalConf;
import com.dj.servercore.conf.base.ConfProvider;
import com.dj.servercore.conf.base.IConfProvider;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.InitHandler;
import com.dj.serverplayer.handler.ParkHandler;
import com.dj.serverplayer.manager.ChannelManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.dj.domain.util.DateUtil;
import com.google.common.collect.Lists;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: QueueHelper
 * @Description: 队列助手
 * @date 2019年6月25日
 */
@Slf4j
public class QueueHelper {

    private static QueueHelper instance = new QueueHelper();

    public static QueueHelper getInstance() {
        return instance;
    }

    /**
     * 生态园动物吃草队列
     */
    @Getter
    private List<Long> grazeQueue = Lists.newLinkedList();
    /**
     * 精灵旅行邮件队列
     */
    @Getter
    private List<Long> travelQueue = Lists.newLinkedList();
    /**
     * 单机接鸡蛋队列
     */
    @Getter
    private List<Long> meetEggSingleQueue = Lists.newLinkedList();

    /**
     * 添加队列
     *
     * @param roleID
     */
    public void addQueue(long roleID) {
//        addGrazeQueue(roleID);
//        addTravelQueue(roleID);
//        addMeetEggSingleQueue(roleID);
    }

    /**
     * 添加生态园动物吃草队列
     *
     * @param roleID
     */
    public void addGrazeQueue(long roleID) {
        if (!grazeQueue.contains(roleID)) {
            Map<String, ParkAnimalUnit> parkAnimalUnitMap = ServiceManager.getParkService().getParkAnimalMap(roleID);
            if (parkAnimalUnitMap != null && parkAnimalUnitMap.size() >= 0) {
                grazeQueue.add(roleID);
                log.info("roleID {}", roleID);
                animalEatPlant(roleID);
            }
        }
    }

    /**
     * 添加精灵旅行邮件队列
     *
     * @param roleID
     */
    public void addTravelQueue(long roleID) {
        if (!travelQueue.contains(roleID)) {
            SummonData summonData = ServiceManager.getSummonService().getSummon(roleID);
            if ((summonData != null) && (summonData.getSendTime() > 0)) {
                travelQueue.add(roleID);
                log.info("roleID {}", roleID);
            }
        }
    }

    /**
     * 添加单机接鸡蛋队列
     *
     * @param roleID
     */
    public void addMeetEggSingleQueue(long roleID) {
        if (!meetEggSingleQueue.contains(roleID)) {
            Date nowDate = new Date();
            boolean reward = ServiceManager.getMeetEggSingleService().hasMeetEggReward(roleID, nowDate);
            if (reward) {
                meetEggGrantReward(roleID, nowDate);
                meetEggSingleQueue.add(roleID);
                log.info("roleID {}", roleID);
            }
        }
    }

    /**
     * 移除队列
     *
     * @param roleID
     */
    public void removeQueue(long roleID) {
        removeGrazeQueue(roleID);
        removeTravelQueue(roleID);
        removeMeetEggSingleQueue(roleID);
    }

    /**
     * 移除生态园动物吃草队列
     *
     * @param roleID
     */
    public void removeGrazeQueue(long roleID) {
        if (grazeQueue.contains(roleID)) {
            grazeQueue.remove(roleID);
            log.info("roleID {}", roleID);
        }
    }

    /**
     * 移除精灵旅行邮件队列
     *
     * @param roleID
     */
    public void removeTravelQueue(long roleID) {
        if (travelQueue.contains(roleID)) {
            travelQueue.remove(roleID);
            log.info("roleID {}", roleID);
        }
    }

    /**
     * 移除单机接鸡蛋队列
     *
     * @param roleID
     */
    public void removeMeetEggSingleQueue(long roleID) {
        if (meetEggSingleQueue.contains(roleID)) {
            meetEggSingleQueue.remove(roleID);
            log.info("roleID {}", roleID);
        }
    }

    /**
     * 动物吃草
     *
     * @param roleID
     */
    public synchronized boolean animalEatPlant(long roleID) {
        PlayerRole playerRole = ServiceManager.getPlayerService().getPlayer(roleID);
        boolean graze = ServiceManager.getParkService().animalEatPlant(roleID, cellList -> {
            // 生态园地图变化推送
            ParkCellNtf.Builder builder = ParkCellNtf.newBuilder();
            builder.addAllCells(cellList);
            ChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), builder.build());
        }, animalUnit -> {
            if(animalUnit.getStatus() == ParkStatus.Hunger_VALUE){
                ConfigFarmParkAnimalConf animalConf = ConfProvider.getConfigConfProvider().getConfigConf(IConfProvider.CONFIG_FARMPARKANIMAL);
                if(animalConf == null){
                    throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
                }
                ConfigFarmParkAnimal config = animalConf.getAnimal(animalUnit.getAnimalID());
                ParkAnimalNtf.Builder parkAnimalNtf = ParkAnimalNtf.newBuilder();
                parkAnimalNtf.addAnimals(animalUnit.toParkAnimal(config));
                ChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), parkAnimalNtf.build());
            }else {
                // 生态园动物成熟变化推送
                ParkAnimalMatureNtf.Builder animalMatureNtf = ParkAnimalMatureNtf.newBuilder();
                animalMatureNtf.setAnimalTimeID(animalUnit.getAnimalTimeID());
                animalMatureNtf.setAnimalID(animalUnit.getAnimalID());
                ChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), animalMatureNtf.build());
            }
        }, ecology -> {
            // 生态值退化
            SpringContext.getBean(ParkHandler.class).changeEcology(roleID, -ecology, ResourceBillEnum.animalEatPlant);
        }, animalLeave -> {
        	// 添加离开历史记录
	        PlayerLeaveHistory leaveHistory = new PlayerLeaveHistory(roleID);
	        //leaveHistory.setId(ServiceManager.readModuleID(TableID.TABLE_LEAVE_HISTORY));
	        leaveHistory.setType(100);
	        leaveHistory.setLeaveID(animalLeave.getAnimalID());
	        leaveHistory.setPlaceTime(new Date(animalLeave.getPlaceTime().getValue()));
	        SpringContext.getBean(InitHandler.class).playerLeaveHistoryDao.cacheInsert(leaveHistory, roleID);
        	// 稀有动物离开推送
        	ParkAnimalAutoLeaveNtf.Builder leaveNtf = ParkAnimalAutoLeaveNtf.newBuilder();
        	leaveNtf.setAnimal(animalLeave);
        	ChannelManager.getInstance().sendPlayerSingleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), leaveNtf.build());
        });
        return graze;
    }

    /**
     * 发放单机接鸡蛋奖励
     *
     * @param roleID
     * @param nowDate
     */
    public synchronized void meetEggGrantReward(long roleID, Date nowDate) {
        int reward = ServiceManager.getMeetEggSingleService().getMeetEggReward(roleID, nowDate);
        if (reward > 0) {
            SpringContext.getBean(InitHandler.class).addGold(roleID, reward, ResourceBillEnum.meetEggGrantReward);
            ServiceManager.getMeetEggSingleService().updateMeetEggLastRewardTime(roleID, nowDate.getTime());
            log.info("roleID {}, reward {}, time {}", roleID, reward, DateUtil.formatDate(nowDate, DateUtil.STYLE4));
        }
    }
}
