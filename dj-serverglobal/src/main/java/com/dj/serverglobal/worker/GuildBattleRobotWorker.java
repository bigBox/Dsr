package com.dj.serverglobal.worker;

import java.util.Iterator;
import java.util.Map;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.data.guildBattle.GuildBattleBuildGame;
import com.dj.domain.data.guildBattle.GuildBattleRoom;
import com.dj.domain.entity.player.PlayerRole;
import com.dj.protobuf.guildBattle.BattleMeetScoreNtf;
import com.dj.protobuf.guildBattle.CaptureBattleBuildNtf;
import com.dj.serverapi.ServiceProvider;
import com.dj.servercore.conf.ConfigSundryConf;
import com.dj.serverglobal.manager.ChannelManager;
import com.dj.domain.util.DateUtil;
import com.dj.domain.util.Utility;
import com.dj.domain.util.math.RandomUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName: GuildBattleMatchWorker
 * @Description: 商会战斗机器人线程
 * @author zcq
 * @date 2020年7月31日
 */
@Slf4j
public class GuildBattleRobotWorker extends Thread {

	private static GuildBattleRobotWorker worker = new GuildBattleRobotWorker();

	public static GuildBattleRobotWorker getWorker() {
		return worker;
	}

	public GuildBattleRobotWorker() {
		super(GuildBattleRobotWorker.class.getSimpleName());
	}

	@Override
	public void run() {
		BattleMeetScoreNtf.Builder battleMeetScoreNtf = BattleMeetScoreNtf.newBuilder();
		CaptureBattleBuildNtf.Builder captureBattleBuildNtf = CaptureBattleBuildNtf.newBuilder();
		while (true) {
			try {
				sleep(ConfigSundryConf.guildBattleRobotWorkerHeartBeat);
				// 遍历房间
				for (Iterator<Map.Entry<Long, GuildBattleRoom>> roomIt = GuildBattleGameWorker.getWorker().getRoomMap().entrySet().iterator(); roomIt.hasNext();) {
					GuildBattleRoom room = roomIt.next().getValue();
					// 遍历房间里的建筑
					for (Map.Entry<Integer, GuildBattleBuildGame> gameEntry : room.getBuildGameMap().entrySet()) {
						GuildBattleBuildGame buildGame = gameEntry.getValue();
						if (buildGame.getGameStartDate() != null) {
							// 接鸡蛋中机器人得分
							int score = RandomUtil.nextInt(1, 3);
							buildGame.setRobotScore(buildGame.getRobotScore() + score);
							battleMeetScoreNtf.setRoleID(buildGame.getRobotRoleID());
							battleMeetScoreNtf.setMeetScore(score);
							battleMeetScoreNtf.setTotalScore(buildGame.getRobotScore());
							PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(buildGame.getGameRoleID());
							ChannelManager.getInstance().sendGlobalGuildBattleToGate(playerRole.getGateServerID(), playerRole.getRoleID(), battleMeetScoreNtf.build());
						} else if (buildGame.getHoldRoleID() == room.getRoleID() && buildGame.isInGame() == false && buildGame.isInXxCapture() == false) {
							// 不在游戏中超过2分钟，小寻就来挑战
							PlayerRole playerRole = ServiceProvider.getPlayerService().getPlayer(buildGame.getHoldRoleID());
							if (playerRole.isOnline() == true && DateUtil.secondsBetween(buildGame.getGameEndDate(),DateUtil.getCurrentDate()) >= 120) {
								buildGame.setInXxCapture(true);
								buildGame.setCaptureRoleID(GlobalRoleID.getXiaoXun());
								captureBattleBuildNtf.setBuildID(gameEntry.getKey());
								PlayerRole xxRole = ServiceProvider.getPlayerService().getPlayer(GlobalRoleID.getXiaoXun());
								captureBattleBuildNtf.setCaptureRoleInfo(xxRole.toBaseRoleInfo());
								ChannelManager.getInstance().sendGlobalGuildBattleToGate(playerRole.getGateServerID(),playerRole.getRoleID(), captureBattleBuildNtf.build());
							}
						}
					}
				}
			} catch (Exception e) {
				log.error(Utility.getTraceString(e));
			}
		}
	}
}
