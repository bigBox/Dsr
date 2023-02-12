package com.dj.serverglobal.handler;

import com.dj.domain.config.ConfigMeetEggDropItems;
import com.dj.domain.config.ConfigMeetEggGhostData;
import com.dj.domain.data.guildBattle.GuildBattleBuildGame;
import com.dj.domain.data.guildBattle.GuildBattleRole;
import com.dj.domain.data.guildBattle.GuildBattleRoom;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.math.RandomUtil;
import com.dj.protobuf.CommonException;
import com.dj.protobuf.ErrorIDOuterClass;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.guildBattle.*;
import com.dj.serverapi.ServiceProvider;
import com.dj.serverapi.helper.MessageHelper;
import com.dj.servercore.conf.ConfigMeetEggDropItemsConf;
import com.dj.servercore.conf.ConfigMeetEggGhostDataConf;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.serverglobal.manager.ChannelManager;
import com.dj.serverglobal.manager.ConfManager;
import com.dj.serverglobal.manager.ServiceManager;
import com.dj.serverglobal.worker.GuildBattleGameWorker;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @ClassName: GlobalGuildBattleHandler  
* @Description: 商会战斗 
* @author zcq 
* @date 2020年7月31日
 */
@Slf4j
@Component
public class GlobalGuildBattleHandler extends ServiceManager {
	private static String DROP_TIMEID = "%s_%d_%d";
	/**
	 * 商会战斗建筑列表
	 * @param roleID
	 * @param req
	 */
	public void battleBuildList(long roleID, BattleBuildListReq req, BattleBuildListRsp.Builder builder) {
		GuildBattleRoom room = GuildBattleGameWorker.getWorker().getRoom(roleID);
		if(room == null) {
			log.error("room == null battleBuildList roleID:{}", roleID);
			throw new CommonException(ErrorID.BATTLE_NO_MATCH);
		}
		Map<Integer, GuildBattleBuildGame> buildMap = room.getBuildGameMap();
		MessageHelper.toBattleBuildList(buildMap, builder);
		builder.setRoomTime(ConfigSundryConf.guildBattleRoomTime);
	}

	/**
	 * 占领战斗建筑
	 * @param roleID
	 * @param req
	 */
	public void holdBattleBuild(long roleID, HoldBattleBuildReq req) {
		checkBattleTime(roleID);
		GuildBattleBuildGame buildGame = GuildBattleGameWorker.getWorker().getRoom(roleID).getBuildGame(req.getBuildID());
		// 有人占领了, 则不能直接占领，需要攻占
		if(buildGame.getHoldRoleID() > 0) {
			if(buildGame.getHoldRoleID() == roleID) {
				// 自己占领了
				log.error("holdBattleBuild buildGame.getHoldRoleID() == roleID roleID:{}", roleID);
				throw new CommonException(ErrorID.BATTLE_BUILD_ME_HOLD);
			}
			log.error("holdBattleBuild buildGame.getHoldRoleID() > 0 roleID:{}", roleID);
			// 别人占领了
			throw new CommonException(ErrorID.BATTLE_BUILD_HAS_HOLD);
		}
    	if(buildGame.isInGame()) {
			log.error("holdBattleBuild buildGame.isInGame() is true roleID:{}", roleID);
    		throw new CommonException(ErrorID.BATTLE_BUILD_IN_GAME);
		}
		GuildBattleGameWorker.getWorker().giveUpHoldBattleBuild(roleID);
		buildGame.setHoldRoleID(roleID);
		Date nowDate = DateUtil.getCurrentDate();
		buildGame.setRewardDate(nowDate);
		buildGame.setGameEndDate(nowDate);
		GuildBattleGameWorker.getWorker().getRoom(roleID).setBattleRoleBuild(roleID, req.getBuildID());
		// 更新建筑
    	BattleBuildUpdateNtf.Builder battleBuildUpdateNtfBuilder = BattleBuildUpdateNtf.newBuilder();
    	GuildBattleBuildInfo.Builder guildBattleBuilder = GuildBattleBuildInfo.newBuilder();
    	PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(roleID);
    	GuildBattleBuildInfo buildInfo = buildGame.toGuildBattleBuildInfo(guildBattleBuilder, playerRole.toBaseRoleInfo());
    	battleBuildUpdateNtfBuilder.setBuild(buildInfo);
    	BattleBuildUpdateNtf battleBuildUpdateNtf = battleBuildUpdateNtfBuilder.build();
    	ChannelManager.getInstance().sendGlobalGuildBattleToGate(playerRole.getGateServerID(), roleID, battleBuildUpdateNtf);
	}

	/**
	 * 攻占战斗建筑
	 * @param roleID
	 * @param req
	 */
	public void captureBattleBuild(long roleID, CaptureBattleBuildReq req) {
		checkBattleTime(roleID);
		GuildBattleBuildGame buildGame = GuildBattleGameWorker.getWorker().getRoom(roleID).getBuildGame(req.getBuildID());
		if(buildGame.getHoldRoleID() == 0) {
			// 无人占领
			log.error("captureBattleBuild buildGame.getHoldRoleID() == 0 roleID:{}", roleID);
			throw new CommonException(ErrorID.BATTLE_BUILD_NO_HOLD);
		}
		if(buildGame.getHoldRoleID() == roleID) {
			// 自己占领了
			log.error("captureBattleBuild buildGame.getHoldRoleID() == roleID roleID:{}", roleID);
			throw new CommonException(ErrorID.BATTLE_BUILD_ME_HOLD);
		}
		if(buildGame.isInGame() || buildGame.isInXxCapture()) {
			log.error("captureBattleBuild buildGame.isInGame()  || buildGame.isInXxCapture() roleID:{}", roleID);
    		throw new CommonException(ErrorID.BATTLE_BUILD_IN_GAME);
		}
		buildGame.setCaptureRoleID(roleID);
		PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(buildGame.getHoldRoleID());
		if(playerRole.isOnline()) {
			CaptureBattleBuildNtf.Builder captureBattleBuildNtf = CaptureBattleBuildNtf.newBuilder();
			captureBattleBuildNtf.setBuildID(req.getBuildID());
			playerRole = ServiceProvider.getPlayerService().getPlayer(buildGame.getHoldRoleID());
			ChannelManager.getInstance().sendGlobalGuildBattleToGate(playerRole.getGateServerID(), buildGame.getHoldRoleID(), captureBattleBuildNtf.build());
		}
	}
	
	/**
	 * 房间时间判断
	 * @param roleID
	 */
	private void checkBattleTime(long roleID) {
		Date nowDate = DateUtil.getCurrentDate();
		// 房间时间判断
		GuildBattleRoom room = GuildBattleGameWorker.getWorker().getRoom(roleID);
		if(room == null){
			log.error("checkBattleTime room == null roleID:{}", roleID);
			throw new CommonException(ErrorID.BATTLE_ROOM_TIME_STOP);
		}
		if(room.getRoomEndDate().getTime() <= nowDate.getTime()) {
			log.error("checkBattleTime room.getRoomEndDate().getTime() <= nowDate.getTime() roleID:{}", roleID);
			throw new CommonException(ErrorID.BATTLE_ROOM_TIME_STOP);
		}
		// 战斗CD
		Date battleCDEnd = room.getBattleRole(roleID).getBattleCDEnd();
		if(battleCDEnd != null && battleCDEnd.getTime() > nowDate.getTime()) {
			log.error("checkBattleTime battleCDEnd != null && battleCDEnd.getTime() > nowDate.getTime() roleID:{}", roleID);
			throw new CommonException(ErrorID.BATTLE_ROLE_IN_CD);
		}
	}

	/**
	 * 玩家开始接鸡蛋
	 * @param roleID
	 * @param req
	 */
	public void startBattleMeetEgg(long roleID, StartBattleMeetEggReq req, StartBattleMeetEggNtf.Builder builder) {
		checkBattleTime(roleID);
		GuildBattleRoom room = GuildBattleGameWorker.getWorker().getRoom(roleID);
		GuildBattleBuildGame buildGame = room.getBuildGame(req.getBuildID());
		if(buildGame.getHoldRoleID() == 0) {
			// 无人占领
			log.error("startBattleMeetEgg buildGame.getHoldRoleID() == 0 roleID:{}", roleID);
			throw new CommonException(ErrorID.BATTLE_BUILD_NO_HOLD);
		}
		GuildBattleRole battleRole = room.getBattleRole(roleID);
		// 当前建筑不是是玩家占领的，并且玩家是攻占方，则放弃以前的占据据点
		if(battleRole.getBuildID() != req.getBuildID() && buildGame.getCaptureRoleID() == roleID) {
			GuildBattleGameWorker.getWorker().giveUpHoldBattleBuild(roleID);
		}
		room.setBattleRoleBuild(roleID, req.getBuildID());
		// 占领方不是自己，则是攻占方
		if(buildGame.getHoldRoleID() != roleID) {
			buildGame.setCaptureRoleID(roleID);
		}
		buildGame.setGameRoleID(roleID);
		room.putBattleRole(buildGame.getRobotRoleID(), req.getBuildID());
		buildGame.setGameStartDate(DateUtil.getCurrentDate());
		buildGame.setGameEndDate(null);
		buildGame.setInGame(true);
		buildGame.setPositionX(req.getPositionX());
		// 生成掉落物
		ConfigMeetEggGhostDataConf ghostDataConf = ConfManager.getInstance().getConfigMeetEggGhostDataConf();
		if(ghostDataConf == null){
			log.error("startBattleMeetEgg ghostDataConf == null roleID:{}", roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		BattleMeetEggDropItem.Builder dropItemBuilder = BattleMeetEggDropItem.newBuilder();
		List<BattleMeetEggDropItem>   dropItems       = Lists.newArrayListWithExpectedSize(3);
		for(int i=1; i<=3; i++ ) {
			int                        ghostId       = RandomUtil.weightedRandom(ghostDataConf.getWeightedMap());
			ConfigMeetEggGhostData     ghostData     = ghostDataConf.getMeetEggGhostData(ghostId);
			ConfigMeetEggDropItemsConf dropItemsConf = ConfManager.getInstance().getConfigMeetEggDropItemsConf();
			ConfigMeetEggDropItems dropItem = dropItemsConf.getMeetEggRandomDropItems(ghostData.getSubType());
			Date nowDate = DateUtil.getCurrentDate();
			String nowStr = DateUtil.formatDate(nowDate, DateUtil.STYLE20);
			String dropTimeID = String.format(DROP_TIMEID, nowStr, dropItem.getID(), i);
			dropItemBuilder.setTimeID(dropTimeID);
			dropItemBuilder.setDropID(dropItem.getID());
			dropItemBuilder.setLeftSeconds(i);
			dropItems.add(dropItemBuilder.build());
		}
		builder.addAllDropItems(dropItems);
	}

	/**
	 * 变化平底锅的位置
	 * @param roleID
	 * @param req
	 */
	public void battleChangeMeetX(long roleID, BattleChangeMeetXReq req) {
		GuildBattleBuildGame buildGame = GuildBattleGameWorker.getWorker().getRoom(roleID).getRoleBuildGame(roleID);
        if (buildGame == null) {
			log.error("battleChangeMeetX buildGame == null roleID:{}", roleID);
            return;
        }
        buildGame.setPositionX(req.getPositionX());
        buildGame.setDirectionX(req.getDirectionX());
	}

	/**
	 * 接到了掉落物
	 * @param roleID
	 * @param req
	 */
	public void battleMeetDrop(long roleID, BattleMeetDropReq req, BattleMeetDropRsp.Builder builder) {
		GuildBattleBuildGame buildGame = GuildBattleGameWorker.getWorker().getRoom(roleID).getRoleBuildGame(roleID);
        if (buildGame == null) {
			log.error("battleMeetDrop buildGame == null roleID:{}", roleID);
            return;
        }
        long nowTime = System.currentTimeMillis();
        String[] arr = req.getTimeID().split("_");
        int dropID = Integer.parseInt(arr[1]);
		ConfigMeetEggDropItemsConf conf = ConfManager.getInstance().getConfigMeetEggDropItemsConf();
		if(conf == null){
			log.error("battleMeetDrop conf == null roleID:{}", roleID);
			throw new CommonException(ErrorIDOuterClass.ErrorID.SYSTEM_CONFIG_NOT_EXISTS);
		}
		ConfigMeetEggDropItems meetEggDropItems = conf.getMeetEggDropItems(dropID);
		if(meetEggDropItems.getSubType() > 0){
			// 结算积分
			int score = meetEggDropItems.getScore();
			buildGame.setGameScore(buildGame.getGameScore() + score);
			builder.setMeetScore(score);
			builder.setTotalScore(buildGame.getGameScore());
		}else {
			buildGame.setGameEndDate(DateUtil.getCurrentDate());
			buildGame.setInGame(false);
			builder.setMeetScore(0);
			builder.setTotalScore(buildGame.getGameScore());
			builder.putAllMeetItemMap(buildGame.getMeetItemMap());
		}
	}

}
