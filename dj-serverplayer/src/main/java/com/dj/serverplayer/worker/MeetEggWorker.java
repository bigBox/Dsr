package com.dj.serverplayer.worker;

import com.dj.domain.config.ConfigMeetEggDropItems;
import com.dj.domain.config.ConfigMeetEggGhostData;
import com.dj.domain.config.ConfigTasks;
import com.dj.domain.data.meetEgg.MeetEggRoom;
import com.dj.domain.entity.player.PlayerGameScoreRank;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.enums.ResourceBillEnum;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.type.AccessType;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.dj.domain.util.math.RandomUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.meetEgg.ExitMeetEggRsp;
import com.dj.protobuf.meetEgg.MeetEggDropItem;
import com.dj.protobuf.meetEgg.MeetEggDropNtf;
import com.dj.protobuf.meetEgg.MeetEggStopNtf;
import com.dj.serverapi.dao.PlayerGameScoreRankDao;
import com.dj.serverapi.dao.PlayerRoleDao;
import com.dj.servercore.conf.ConfigMeetEggDropItemsConf;
import com.dj.servercore.conf.ConfigMeetEggGhostDataConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.servercore.spring.SpringContext;
import com.dj.serverplayer.handler.InitHandler;
import com.dj.serverplayer.handler.TaskHandler;
import com.dj.serverplayer.manager.ChannelManager;
import com.dj.serverplayer.manager.ConfManager;
import com.dj.serverplayer.manager.EventManager;
import com.dj.serverplayer.manager.ServiceManager;
import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zcq
 * @ClassName: MeetEggWorker
 * @Description: 接鸡蛋工作线程, 单机玩法，一个玩家一个房间
 * @date 2019年6月25日
 */
@Slf4j
@Component
public class MeetEggWorker extends Thread {

    @Autowired
    public PlayerGameScoreRankDao playerGameScoreRankDao;

    @Autowired
    public PlayerRoleDao playerRoleDao;

    private static MeetEggWorker worker = new MeetEggWorker();

    public static MeetEggWorker getWorker() {
        return worker;
    }
    
    public MeetEggWorker() {
    	super(MeetEggWorker.class.getSimpleName());
    }

    @Getter
    private Map<Long, MeetEggRoom> roomMap = new ConcurrentHashMap<Long, MeetEggRoom>();

    /**
     *	下落时间(毫秒)
     */
    public static int dropMilliSecond;
    
    
    private static String DROP_TIMEID = "%s_%d_%d";

    @Override
    public void run() {
        if(playerGameScoreRankDao == null){
            playerGameScoreRankDao = SpringContext.getBean(PlayerGameScoreRankDao.class);
        }
        if(playerRoleDao == null){
            playerRoleDao = SpringContext.getBean(PlayerRoleDao.class);
        }
        ConfigMeetEggGhostDataConf conf = ConfManager.getInstance().getConfigMeetEggGhostDataConf();
        if(conf == null){
            throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
        }
        Map<Integer, Integer> weightedMap = conf.getWeightedMap();
        if(weightedMap == null || weightedMap.size() == 0){
            return;
        }
        List<Integer> randomFlyScond = Lists.newArrayListWithExpectedSize(5);
        MeetEggStopNtf.Builder stopNtf = MeetEggStopNtf.newBuilder();
        List<MeetEggDropItem> dropItems = Lists.newArrayListWithExpectedSize(5);
        MeetEggDropItem.Builder dropItemBuilder = MeetEggDropItem.newBuilder();
        MeetEggDropNtf.Builder builder = MeetEggDropNtf.newBuilder();
        while (true) {
            try {
                sleep(ConfigSundryConf.meetEggWorkerHeartBeat);
                if (roomMap.size() > 0) {
                    // 下落时间 = 高度/下落速度
                    dropMilliSecond = (int) ((ConfigSundryConf.meetEggHeight / (float) ConfigSundryConf.meetEggDropMoveSpeed) * 1000);
                    // 飞行时间 = 宽度/飞行速度
                    int flySecond = (int) ((ConfigSundryConf.meetEggWidth * 2) / (float) ConfigSundryConf.meetEggFlyMoveSpeed);
                    Date nowDate = DateUtil.getCurrentDate();
                    String nowStr = DateUtil.formatDate(nowDate, DateUtil.STYLE20);
                    for (Iterator<Map.Entry<Long, MeetEggRoom>> it = roomMap.entrySet().iterator(); it.hasNext();) {
                        Map.Entry<Long, MeetEggRoom> entry = it.next();
                        MeetEggRoom room = entry.getValue();
                        // 2结束 1暂停， 0开始
                        if (room.getState() == 1) {
                            continue;
                        }
                        // 时间到了
                        if ((room.getState() == 2)||(DateUtil.secondsBetween(room.getStartDate(), nowDate) >= ConfigSundryConf.meetEggGameTime + room.getPauseSecond())) {
                            int totalScore = room.getTotalScore();
                            if(totalScore > 0){
                                PlayerGameScoreRank playerGameScoreRank = playerGameScoreRankDao.cacheQuery(room.getRoleID(), room.getRoleID());
                                if(ObjectUtils.isEmpty(playerGameScoreRank)){
                                    playerGameScoreRank = new PlayerGameScoreRank(room.getRoleID());
                                    playerGameScoreRank.setScore(totalScore);
                                    PlayerRole playerRole = playerRoleDao.cacheQuery(room.getRoleID(), room.getRoleID());
                                    if(playerRole != null) {
                                        playerGameScoreRank.setRoleName(playerRole.getRoleName());
                                    }
                                    playerGameScoreRankDao.cacheInsert(playerGameScoreRank, room.getRoleID());
                                }else {
                                    if(totalScore > playerGameScoreRank.getScore()) {
                                        playerGameScoreRank.setScore(totalScore);
                                        playerGameScoreRankDao.cacheUpdate(playerGameScoreRank, room.getRoleID());
                                    }
                                }
                            }

                            stopNtf.setTotalScore(totalScore);
                            List<PlayerGameScoreRank> playerGameScoreRanks = playerGameScoreRankDao.getAll(room.getRoleID(), AccessType.DIRECT_DB);
                            Collections.sort(playerGameScoreRanks);
                            int index = 1;
                            boolean myself = false;
                            for(PlayerGameScoreRank playerScoreRank : playerGameScoreRanks){
                                if(index <= 100){
                                    if(playerScoreRank.getRoleID() == room.getRoleID()){
                                        stopNtf.setMyself(playerScoreRank.toPlayerScoreRank(index));
                                        myself = true;
                                    }
                                    stopNtf.addRanks(playerScoreRank.toPlayerScoreRank(index++));
                                } else{
                                    if(!myself){
                                        PlayerGameScoreRank playerGameScoreRank = playerGameScoreRankDao.cacheQuery(room.getRoleID(), room.getRoleID());
                                        if(!ObjectUtils.isEmpty(playerGameScoreRank)) {
                                            stopNtf.setMyself(playerGameScoreRank.toPlayerScoreRank(101));
                                        }
                                    }
                                    break;
                                }

                            }

                            ChannelManager.getInstance().sendPlayerSingleToGate(room.getGateServerID(), room.getRoleID(), stopNtf.build());
                            removeRoom(room.getRoleID(), null);
                            EventManager.commitRoleEvent(room.getRoleID());
                            continue;
                        }
                        // 离上次飞行出现时间小于1秒
                        if (nowDate.getTime() - room.getLastFlyTime() < ConfigSundryConf.meetEggFlySpeed) {
                            continue;
                        }
                        // 生成掉落物
                        int ghostId = RandomUtil.weightedRandom(weightedMap);
                        ConfigMeetEggGhostData ghostData = conf.getMeetEggGhostData(ghostId);
                        int dropLimitSecond = RandomUtil.nextInt(2) + 1;
                        if (flySecond < dropLimitSecond) {
                            continue;
                        }
                        ConfigMeetEggDropItemsConf dropItemsConf = ConfManager.getInstance().getConfigMeetEggDropItemsConf();
                        ConfigMeetEggDropItems dropItem = dropItemsConf.getMeetEggRandomDropItems(ghostData.getSubType());
                        // 生成随机掉落时间
                        randomFlyScond.clear();
                        for (int i = 0; i < flySecond; i++) {
                            randomFlyScond.add(i);
                        }
                        dropItems.clear();
                        dropItemBuilder.clear();
                        int dropLimitCount = ghostData.getDropLimit();
                        for (int i = 0; i < dropLimitCount; i++) {
                            // 保证随机时间不重复
                            int index = RandomUtil.nextInt(randomFlyScond.size());
                            String dropTimeID = String.format(DROP_TIMEID, nowStr, dropItem.getID(), randomFlyScond.get(index));
                            dropItemBuilder.setTimeID(dropTimeID);
                            dropItemBuilder.setDropID(dropItem.getID());
                            dropItemBuilder.setLeftSeconds(randomFlyScond.get(index));
                            randomFlyScond.remove(index);
                            dropItems.add(dropItemBuilder.build());
                            //log.info("roleID {}, ghostData {}, dropItem {}, timeID {}", room.getRoleID(), ghostId, dropItem.getID(), dropTimeID);
                        }
                        room.setLastFlyTime(nowDate.getTime());
                        // 推送掉落物给前端
                        builder.clear();
                        // 2向右，1向左
                        int directionX = 1;
                        int positionX = RandomUtil.nextInt(2*ConfigSundryConf.meetEggWidth);
                        if (positionX < ConfigSundryConf.meetEggWidth) {
                            directionX = 2;
                        }
                        builder.setId(ghostId);
                        builder.setDirectionX(directionX);
                        builder.setPositionX(positionX);
                        builder.addAllDropItems(dropItems);
                        ChannelManager.getInstance().sendPlayerSingleToGate(room.getGateServerID(), entry.getKey(), builder.build());
                    }
                }
            } catch (Exception e) {
                log.error(Utility.getTraceString(e));
            }
        }
    }

    /**
     *	添加房间
     *
     * @param roleID
     * @param room
     */
    public void addRoom(long roleID, MeetEggRoom room) {
        roomMap.put(roleID, room);
    }

    /**
     *	删除房间
     *
     * @param roleID
     */
    public void removeRoom(long roleID, ExitMeetEggRsp.Builder builder) {
        MeetEggRoom room = roomMap.get(roleID);
        if (room == null) {
            return;
        }
        int totalScore = room.getTotalScore();
        if(builder != null) {
        	builder.setTotalScore(totalScore);
        }
        log.info("roleID {}, room {}", roleID, room.toString());
        if (totalScore > 0) {
            // 添加经验和金币
            SpringContext.getBean(InitHandler.class).addExp(roleID, totalScore, ResourceBillEnum.meetEggGrantReward);
            SpringContext.getBean(InitHandler.class).addGold(roleID, totalScore, ResourceBillEnum.meetEggGrantReward);
            // 更新该建筑接鸡蛋的积分
            ServiceManager.getMeetEggSingleService().updateMeetEggBuild(roleID, room.getBuildID(), room.getStartDate().getTime(), totalScore);
            // 添加队列
            // QueueHelper.getInstance().addMeetEggSingleQueue(roleID);
        }
        roomMap.remove(roleID);
        ConfigTasks configTasks = SpringContext.getBean(TaskHandler.class).checkTaskAction(roleID, TaskActionEnum.MINI_GAME_SCORE);
        if((configTasks != null) && (configTasks.getExtraParam() > 0)) {
            if(totalScore >= configTasks.getExtraParam()) {
                EventManager.postTaskActionEvent(roleID, TaskActionEnum.MINI_GAME_SCORE, 1);
                EventManager.commitRoleEvent(roleID);
            }
        }
        //if((configTasks != null) && (StringUtil.isNotEmpty(configTasks.getExtraParam()))) {
        //    int score = Integer.getInteger(configTasks.getExtraParam());
        //    if(totalScore >= score) {
        //        EventManager.postTaskActionEvent(roleID, TaskActionEnum.MINI_GAME_SCORE, 1);
        //        EventManager.commitRoleEvent(roleID);
        //    }
        //}
    }
}
