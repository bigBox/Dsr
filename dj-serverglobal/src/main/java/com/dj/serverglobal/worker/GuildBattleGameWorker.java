package com.dj.serverglobal.worker;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.dj.domain.config.ConfigMeetEggDropItems;
import com.dj.domain.config.ConfigMeetEggGhostData;
import com.dj.domain.enums.TaskActionEnum;
import com.dj.domain.data.guildBattle.GuildBattleBuildGame;
import com.dj.domain.data.guildBattle.GuildBattleRole;
import com.dj.domain.data.guildBattle.GuildBattleRoom;
import com.dj.domain.entity.global.GlobalGuild;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.guildBattle.BattleBuildUpdateNtf;
import com.dj.protobuf.guildBattle.BattleHoldScoreNtf;
import com.dj.protobuf.guildBattle.BattleMeetEggDropItem;
import com.dj.protobuf.guildBattle.BattleMeetEggDropNtf;
import com.dj.protobuf.guildBattle.BattleMeetEggStopNtf;
import com.dj.protobuf.guildBattle.BattleOverNtf;
import com.dj.protobuf.guildBattle.ExitBattleMeetEggRsp;
import com.dj.protobuf.guildBattle.GuildBattleBuildInfo;
import com.dj.serverapi.ServiceProvider;
import com.dj.servercore.conf.ConfigMeetEggDropItemsConf;
import com.dj.servercore.conf.ConfigMeetEggGhostDataConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.serverglobal.manager.ChannelManager;
import com.dj.serverglobal.manager.ConfManager;
import com.dj.serverglobal.manager.DataManager;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.Utility;
import com.dj.domain.util.math.RandomUtil;
import com.dj.serverglobal.manager.EventManager;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zcq
 * @ClassName: MeetEggWorker
 * @Description: 商会战斗游戏线程
 * @date 2019年6月25日
 */
@Slf4j
public class GuildBattleGameWorker extends Thread {

    private static GuildBattleGameWorker worker = new GuildBattleGameWorker();

    public static GuildBattleGameWorker getWorker() {
        return worker;
    }
    
    @Getter
    private Map<Long, GuildBattleRoom> roomMap = Maps.newHashMap();

    public GuildBattleGameWorker() {
    	super(GuildBattleGameWorker.class.getSimpleName());
    }

    /**
     *	下落时间(毫秒)
     */
    public static int dropMilliSecond;
    
    private static String DROP_TIMEID = "%s_%d_%d";
    
    public void createRoom(long roleID, long matchRoleID) {
		GuildBattleRoom room = roomMap.get(roleID);
		if(room == null) {
			room = new GuildBattleRoom(roleID, matchRoleID);
		}else {
			room.setMatchRoleID(matchRoleID);
		}
		room.setRoomEndDate(DateUtil.plusNow(TimeUnit.SECONDS, ConfigSundryConf.guildBattleRoomTime));
		room.initBattleRoom();
		roomMap.put(roleID, room);
	}
    
    public GuildBattleRoom getRoom(long roleID) {
    	return roomMap.get(roleID);
    }

    @Override
    public void run() {
		ConfigMeetEggGhostDataConf conf = ConfManager.getInstance().getConfigMeetEggGhostDataConf();
		if(conf == null){
			log.error("GuildBattleGameWorker conf == null");
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
        List<Integer> randomFlyScond = Lists.newArrayListWithExpectedSize(5);
        BattleMeetEggStopNtf.Builder stopNtf = BattleMeetEggStopNtf.newBuilder();
        List<BattleMeetEggDropItem> dropItems = Lists.newArrayListWithExpectedSize(5);
        BattleMeetEggDropItem.Builder dropItemBuilder = BattleMeetEggDropItem.newBuilder();
        BattleMeetEggDropNtf.Builder builder = BattleMeetEggDropNtf.newBuilder();
        BattleHoldScoreNtf.Builder battleHoldScoreNtf = BattleHoldScoreNtf.newBuilder();
        BattleOverNtf.Builder battleOverNtf = BattleOverNtf.newBuilder();
        while (true) {
            try {
                sleep(ConfigSundryConf.meetEggWorkerHeartBeat);
                // 下落时间 = 高度/下落速度
                dropMilliSecond = (int) ((ConfigSundryConf.meetEggHeight / (float) ConfigSundryConf.meetEggDropMoveSpeed) * 1000);
                // 飞行时间 = 宽度/飞行速度
                int flySecond = (int) ((ConfigSundryConf.meetEggWidth * 2) / (float) ConfigSundryConf.meetEggFlyMoveSpeed);
                Date nowDate = DateUtil.getCurrentDate();
                String nowStr = DateUtil.formatDate(nowDate, DateUtil.STYLE20);
                // 遍历房间
                for(Iterator<Map.Entry<Long, GuildBattleRoom>> roomIt = roomMap.entrySet().iterator(); roomIt.hasNext();) {
                	GuildBattleRoom room = roomIt.next().getValue();
                	PlayerRole roomRole = ServiceProvider.getPlayerService().getPlayer(room.getRoleID());
                	// 遍历房间里的建筑
                	if(room.getRoomEndDate().getTime() > nowDate.getTime()) {
                		// 战斗中
                		for (Map.Entry<Integer, GuildBattleBuildGame> gameEntry : room.getBuildGameMap().entrySet()) {
                            GuildBattleBuildGame buildGame = gameEntry.getValue();
                            PlayerRole gameRole = ServiceProvider.getPlayerService().getPlayer(room.getRoleID());
                            if(buildGame.getGameStartDate() != null) {
                                // 时间到了
                                if (DateUtil.secondsBetween(buildGame.getGameStartDate(), nowDate) >= ConfigSundryConf.guildBattleMeetEggGameTime) {
                                	buildGame.setGameStartDate(null);
                                	if(buildGame.getHoldRoleID() == buildGame.getGameRoleID()) {
                                		// 玩家自己是占领方
                                		stopNtf.setHoldScore(buildGame.getHoldScore());
                                		stopNtf.setCaptureScore(buildGame.getRobotScore());
                                	}else {
                                		stopNtf.setHoldScore(buildGame.getRobotScore());
                                		stopNtf.setCaptureScore(buildGame.getCaptureScore());
                                	}
                                	stopNtf.putRoleBattleCD(buildGame.getHoldRoleID(), ConfigSundryConf.guildBattleGameCD);
                                	stopNtf.putRoleBattleCD(buildGame.getCaptureRoleID(), ConfigSundryConf.guildBattleGameCD);
                                    ChannelManager.getInstance().sendGlobalGuildBattleToGate(gameRole.getGateServerID(), gameRole.getRoleID(), stopNtf.build());
                                    doBattleResult(buildGame);
                                    continue;
                                }
                                // 离上次飞行出现时间小于1秒
                                if (nowDate.getTime() - buildGame.getLastFlyTime() < ConfigSundryConf.meetEggFlySpeed) {
                                    continue;
                                }
                                // 生成精灵
                                int ghostId = RandomUtil.weightedRandom(conf.getWeightedMap());
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
                                buildGame.setLastFlyTime(nowDate.getTime());
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
                                ChannelManager.getInstance().sendGlobalGuildBattleToGate(gameRole.getGateServerID(), gameRole.getRoleID(), builder.build());
                            }else if(buildGame.getHoldRoleID() == room.getRoleID() && buildGame.getRewardDate() != null){
                            	if(room.getRoomEndDate().getTime() > nowDate.getTime()) {
                            		// 占据产出比分
                                	if(DateUtil.secondsBetween(buildGame.getRewardDate(), nowDate) >= 60) {
                                		buildGame.setRewardDate(nowDate);
                                		int score = 100;
                                		room.setRewardScore(room.getRewardScore()+score);
                                		battleHoldScoreNtf.setRoleID(roomRole.getRoleID());
                                		battleHoldScoreNtf.setScore(score);
                                		battleHoldScoreNtf.setTotalScore(room.getRewardScore());
                                		ChannelManager.getInstance().sendGlobalGuildBattleToGate(roomRole.getGateServerID(), roomRole.getRoleID(), battleHoldScoreNtf.build());
                                	}
                            	}
                            }else if(buildGame.getHoldRoleID() == room.getMatchRoleID() && buildGame.getRewardDate() != null){
                            	if(room.getRoomEndDate().getTime() > nowDate.getTime()) {
                            		// 占据产出比分
                                	if(DateUtil.secondsBetween(buildGame.getRewardDate(), nowDate) >= 60) {
                                		buildGame.setRewardDate(nowDate);
                                		int score = 50;
                                		room.setMatchRewardScore(room.getMatchRewardScore()+score);
                                		battleHoldScoreNtf.setRoleID(room.getMatchRoleID());
                                		battleHoldScoreNtf.setScore(score);
                                		battleHoldScoreNtf.setTotalScore(room.getMatchRewardScore());
                                		ChannelManager.getInstance().sendGlobalGuildBattleToGate(roomRole.getGateServerID(), roomRole.getRoleID(), battleHoldScoreNtf.build());
                                	}
                            	}
                            }
                        }
            		}else {
            			// 战斗结束
            			battleOverNtf.setScore(room.getRewardScore());
            			battleOverNtf.setMatchScore(room.getMatchRewardScore());
            			if(room.getRewardScore() >= room.getMatchRewardScore()) {
            				// 添加商会积分
            				int score = 100;
            				GlobalGuild guild = DataManager.INSTANCE.addGuildExp(roomRole.getRoleID(), roomRole.getGuildId(), score, false);
            				battleOverNtf.setExp(guild.getExperience());
            				battleOverNtf.setLevel(guild.getLevel());
            				battleOverNtf.setWinGuildID(roomRole.getGuildId());
            			}else {
            				battleOverNtf.setWinGuildID(0);
            			}
            			ChannelManager.getInstance().sendGlobalGuildBattleToGate(roomRole.getGateServerID(), roomRole.getRoleID(), battleOverNtf.build());
            			roomIt.remove();
            		}
                }
                
            } catch (Exception e) {
                log.error(Utility.getTraceString(e));
            }
        }
    }

    /**
	 * 放弃已经占领的建筑
	 * @param roleID
	 */
	public void giveUpHoldBattleBuild(long roleID) {
		GuildBattleRoom room = getRoom(roleID);
    	GuildBattleRole battleRole = room.getBattleRole(roleID);
    	if(battleRole.getBuildID() > 0) {
    		GuildBattleBuildGame buildGame = room.getBuildGame(battleRole.getBuildID());
    		buildGame.setHoldRoleID(0);
    		room.setBattleRoleBuild(roleID, 0);
    		// 更新建筑
        	BattleBuildUpdateNtf.Builder battleBuildUpdateNtfBuilder = BattleBuildUpdateNtf.newBuilder();
        	GuildBattleBuildInfo.Builder guildBattleBuilder = GuildBattleBuildInfo.newBuilder();
        	GuildBattleBuildInfo buildInfo = buildGame.toGuildBattleBuildInfo(guildBattleBuilder, null);
        	battleBuildUpdateNtfBuilder.setBuild(buildInfo);
        	BattleBuildUpdateNtf battleBuildUpdateNtf = battleBuildUpdateNtfBuilder.build();
        	PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
        	ChannelManager.getInstance().sendGlobalGuildBattleToGate(playerRole.getGateServerID(), roleID, battleBuildUpdateNtf);
    	}
	}

    /**
     * 退出接鸡蛋游戏
     * @param roleID
     */
    public void exitBattleMeetEgg(long roleID, ExitBattleMeetEggRsp.Builder builder) {
    	GuildBattleRoom room = getRoom(roleID);
    	GuildBattleBuildGame buildGame = room.getRoleBuildGame(roleID);
    	if(buildGame.getHoldRoleID() == buildGame.getGameRoleID()) {
    		// 玩家自己是占领方
    		builder.setHoldScore(buildGame.getHoldScore());
    		builder.setCaptureScore(buildGame.getRobotScore());
    	}else {
    		builder.setHoldScore(buildGame.getRobotScore());
    		builder.setCaptureScore(buildGame.getCaptureScore());
    	}
    	builder.putRoleBattleCD(buildGame.getHoldRoleID(), ConfigSundryConf.guildBattleGameCD);
    	builder.putRoleBattleCD(buildGame.getCaptureRoleID(), ConfigSundryConf.guildBattleGameCD);
    	buildGame.setGameScore(-1);
    	doBattleResult(buildGame);
    }
    
    /**
     * 战斗结果
     * @param buildGame
     */
    private void doBattleResult(GuildBattleBuildGame buildGame) {
    	// 重置战斗CD
    	GuildBattleRoom room = getRoom(buildGame.getGameRoleID());
    	room.addBattleCD(ConfigSundryConf.guildBattleGameCD);
    	// 判断胜负
    	log.info("gameRoleID:{}, holdRoleID:{}, captureRoleID:{}", buildGame.getGameRoleID(), buildGame.getHoldRoleID(), buildGame.getCaptureRoleID());
    	long winRoleID = buildGame.getHoldRoleID();
    	long failRoleID = buildGame.getCaptureRoleID();
    	if(buildGame.getHoldScore() < buildGame.getCaptureScore()) {
    		winRoleID = buildGame.getCaptureRoleID();
    		failRoleID = buildGame.getHoldRoleID();
    	}
    	log.info("gameRoleID:{}, winRoleID:{}, failRoleID:{}", buildGame.getGameRoleID(), winRoleID, failRoleID);
    	// 胜利者是玩家自己, 开始计算产生商会积分奖励时间
    	if(winRoleID == room.getRoleID()) {
    		buildGame.setRewardDate(DateUtil.getCurrentDate());
    	}else {
    		buildGame.setRewardDate(null);
    	}
    	// 胜的一方占领建筑
    	buildGame.setHoldRoleID(winRoleID);
    	room.setBattleRoleBuild(winRoleID, buildGame.getBuildID());
    	room.setBattleRoleBuild(failRoleID, 0);
    	// 建筑更新推送
    	BattleBuildUpdateNtf.Builder battleBuildUpdateNtfBuilder = BattleBuildUpdateNtf.newBuilder();
    	GuildBattleBuildInfo.Builder guildBattleBuilder = GuildBattleBuildInfo.newBuilder();
    	PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(winRoleID);
    	GuildBattleBuildInfo buildInfo = buildGame.toGuildBattleBuildInfo(guildBattleBuilder, playerRole.toBaseRoleInfo());
    	battleBuildUpdateNtfBuilder.setBuild(buildInfo);
    	BattleBuildUpdateNtf battleBuildUpdateNtf = battleBuildUpdateNtfBuilder.build();
    	// 胜利方
    	ChannelManager.getInstance().sendGlobalGuildBattleToGate(playerRole.getGateServerID(), winRoleID, battleBuildUpdateNtf);
    	// 失败方
    	playerRole = ServiceProvider.getPlayerService().getPlayer(failRoleID);
    	ChannelManager.getInstance().sendGlobalGuildBattleToGate(playerRole.getGateServerID(), failRoleID, battleBuildUpdateNtf);
    	// 房间重置
    	buildGame.setGameRoleID(0);
    	buildGame.setGameScore(0);
    	buildGame.setHoldScore(0);
    	buildGame.setCaptureRoleID(0);
    	buildGame.setCaptureScore(0);
    	buildGame.setRobotScore(0);
    	buildGame.setGameStartDate(null);
    	buildGame.setGameEndDate(DateUtil.getCurrentDate());
    	buildGame.setInGame(false);
    	buildGame.setInXxCapture(false);
		EventManager.postTaskActionEvent(winRoleID, TaskActionEnum.JOIN_GUILD_BATTLE, 1);
		EventManager.postTaskActionEvent(failRoleID, TaskActionEnum.JOIN_GUILD_BATTLE, 1);
		EventManager.commitRoleEvent(winRoleID);
		EventManager.commitRoleEvent(failRoleID);
    }

	public void exitBattleBuildList(long roleID) {
		roomMap.remove(roleID);
	}
}
