package com.dj.client;

import java.util.List;
import java.util.Scanner;

import com.dj.domain.constant.ConstantGame;
import com.dj.protobuf.ProtobufCmdPool;
import com.dj.protobuf.book.BookAllTypeReq;
import com.dj.protobuf.book.BookInfoReq;
import com.dj.protobuf.book.BookRewardReq;
import com.dj.protobuf.book.BookType;
import com.dj.protobuf.buffer.EDrawTodayType;
import com.dj.protobuf.buffer.MonthCardDrawReq;
import com.dj.protobuf.buffer.MonthCardReq;
import com.dj.protobuf.character.ChangeClientDataReq;
import com.dj.protobuf.character.CheckWordReq;
import com.dj.protobuf.character.LeaveHistoryReq;
import com.dj.protobuf.character.UsePowerBarAddStaminaReq;
import com.dj.protobuf.chat.ChatSendReq;
import com.dj.protobuf.chat.EChatChannel;
import com.dj.protobuf.city.AnswerOption;
import com.dj.protobuf.city.NpcListReq;
import com.dj.protobuf.city.NpcOnPoetryInfoReq;
import com.dj.protobuf.city.NpcOnPoetryReq;
import com.dj.protobuf.city.NpcTriggerEventReq;
import com.dj.protobuf.city.NpcVisitReq;
import com.dj.protobuf.city.NpcWantThingReq;
import com.dj.protobuf.collection.CollectionExchangeRewardReq;
import com.dj.protobuf.collection.CollectionListReq;
import com.dj.protobuf.friend.FriendListReq;
import com.dj.protobuf.friend.FriendSearchReq;
import com.dj.protobuf.gm.GmCommandReq;
import com.dj.protobuf.guild.CreateGuildReq;
import com.dj.protobuf.guild.GuildApplyReq;
import com.dj.protobuf.guildBattle.BattleBuildListReq;
import com.dj.protobuf.guildBattle.CaptureBattleBuildReq;
import com.dj.protobuf.guildBattle.HoldBattleBuildReq;
import com.dj.protobuf.guildBattle.SignUpGuildBattleReq;
import com.dj.protobuf.guildBattle.StartBattleMeetEggReq;
import com.dj.protobuf.guildTask.GuildTaskAcceptReq;
import com.dj.protobuf.guildTask.GuildTaskListReq;
import com.dj.protobuf.item.ItemFriendReq;
import com.dj.protobuf.item.ItemInteractHistoryReq;
import com.dj.protobuf.item.ItemInteractReq;
import com.dj.protobuf.item.ItemListReq;
import com.dj.protobuf.leaderboard.RankSelfNearbyReq;
import com.dj.protobuf.leaderboard.RankTopNReq;
import com.dj.protobuf.leaderboard.RankType;
import com.dj.protobuf.login.CreateAccountReq;
import com.dj.protobuf.login.HeartbeatInfo;
import com.dj.protobuf.login.ServerStopNtf;
import com.dj.protobuf.login.UserLoginReq;
import com.dj.protobuf.meetEgg.MeetEggPauseStartReq;
import com.dj.protobuf.meetEgg.StartMeetEggReq;
import com.dj.protobuf.outside.OutsideBatchReq;
import com.dj.protobuf.park.CellPoint;
import com.dj.protobuf.park.ParkDrawHoneyReq;
import com.dj.protobuf.park.ParkDrawPrizeReq;
import com.dj.protobuf.park.ParkHarvestAnimalReq;
import com.dj.protobuf.park.ParkHarvestPlantReq;
import com.dj.protobuf.park.ParkInfoReq;
import com.dj.protobuf.park.ParkPlaceAnimalReq;
import com.dj.protobuf.park.ParkPlacePlantReq;
import com.dj.protobuf.rob.RobMapReq;
import com.dj.protobuf.rob.RobUseSkillReq;
import com.dj.protobuf.scene.ESceneRebornPos;
import com.dj.protobuf.scene.JoinSceneReq;
import com.dj.protobuf.server.UpdateConfigReq;
import com.dj.protobuf.server.UpdateConnectLogicReq;
import com.dj.protobuf.showtable.ShowTableChangePositionReq;
import com.dj.protobuf.showtable.ShowTableSupportReq;
import com.dj.protobuf.summon.SummonInfoReq;
import com.dj.protobuf.summon.SummonInvestReq;
import com.dj.protobuf.summon.SummonMailRefreshReq;
import com.dj.protobuf.summon.SummonMailRewardReq;
import com.dj.protobuf.summon.SummonPickupInvestRewardReq;
import com.dj.protobuf.summon.SummonReq;
import com.dj.protobuf.summon.SummonSendReq;
import com.dj.protobuf.task.*;
import com.dj.protobuf.trade.StockListReq;
import com.dj.protobuf.trade.TradeHistoryReq;
import com.dj.protobuf.trade.TradeTopNReq;
import com.dj.protobuf.trade.TradeType;
import com.dj.protobuf.trade.TradeUseReq;
import com.dj.protobuf.verify.VerifiedQueueReq;
import com.dj.protobuf.verify.VerifyDequeueReq;
import com.dj.protobuf.verify.VerifyEnqueueReq;
import com.dj.protobuf.verify.VerifyItemReq;
import com.dj.protobuf.verify.VerifySpeedupReq;
import com.dj.protobuf.verify.VerifyUseCardReq;
import com.dj.protobuf.verify.VerifyingQueueReq;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.ThreadUtil;
import com.google.common.collect.Lists;
import com.google.protobuf.GeneratedMessageV3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientHandler {
	private static ClientSocket clientSocket = null;

	@SuppressWarnings({ "resource"})
	public static void initClient(ClientSocket cs, boolean doLoop) throws InterruptedException {
		if (clientSocket != null) {
			clientSocket.close();
			clientSocket = null;
		}
		cs.connectBlocking();
		clientSocket = cs;

		if (!doLoop) {
			return;
		}
		// ??????????????????
		UserLoginReq.Builder login = UserLoginReq.newBuilder();
		login.setAccount("xia");
		login.setPassword("1");
		sendMsg(login.build());

		ThreadUtil.sleep(3000);
		log.info("??????????????????");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				String str = scanner.nextLine().trim();
				if (str.equalsIgnoreCase("exit")) {
					log.info("?????????????????????");
					System.exit(0);
					break;
				}
				String[] arr = str.split(" ");
				String commond = arr[0];
				String[] args = new String[arr.length - 1];
				for (int i = 1; i < arr.length; i++) {
					args[i - 1] = arr[i];
				}
				switch (commond) {
				case "heart":
					HeartbeatInfo.Builder heart = HeartbeatInfo.newBuilder();
					sendMsg(heart.build());
					break;
				case "updateConfig":
					UpdateConfigReq.Builder builder = UpdateConfigReq.newBuilder();
					builder.setJsonConfigName(args[0] + ".json");
					sendMsg(builder.build());
					break;
				case "ServerStopNtf":
					ServerStopNtf.Builder serverStopNtf = ServerStopNtf.newBuilder();
					sendMsg(serverStopNtf.build());
					break;
				case "UpdateConnectLogicReq":
					UpdateConnectLogicReq.Builder builder1 = UpdateConnectLogicReq.newBuilder();
					sendMsg(builder1.build());
					break;
				case "register":
					CreateAccountReq.Builder builder2 = CreateAccountReq.newBuilder();
					builder2.setAccount(args[0]);
					builder2.setPassword("1");
					//builder2.setName("?????????");
					//builder2.setIdCard("342921198912271134");
					sendMsg(builder2.build());
					break;
				case "login":
					UserLoginReq.Builder builder3 = UserLoginReq.newBuilder();
					builder3.setAccount(args[0]);
					builder3.setPassword("1");
					sendMsg(builder3.build());
					break;
				case "gm":
					GmCommandReq.Builder gm = GmCommandReq.newBuilder();
					gm.setCmd(args[0].replaceAll("@", " "));
					sendMsg(gm.build());
					break;
				case "ItemListReq":
					ItemListReq.Builder item = ItemListReq.newBuilder();
					item.setCol(Integer.parseInt(args[0]));
					sendMsg(item.build());
					break;
				case "ParkInfoReq":// ?????????????????????
					ParkInfoReq.Builder builder4 = ParkInfoReq.newBuilder();
					builder4.setRoleId(Long.parseLong(args[0]));
					sendMsg(builder4.build());
					break;
				case "ParkPlacePlantReq":// ????????????
					ParkPlacePlantReq.Builder parkPlacePlantReq = ParkPlacePlantReq.newBuilder();
					parkPlacePlantReq.setX(Integer.parseInt(args[0]));
					parkPlacePlantReq.setY(Integer.parseInt(args[1]));
					parkPlacePlantReq.setPlantID(Integer.parseInt(args[2]));
					sendMsg(parkPlacePlantReq.build());
					break;
				case "ParkHarvestPlantReq":// ????????????
					ParkHarvestPlantReq.Builder parkHarvestPlantReq = ParkHarvestPlantReq.newBuilder();
					List<CellPoint> points = Lists.newArrayListWithCapacity(1);
					CellPoint.Builder point = CellPoint.newBuilder();
					point.setX(0);
					point.setY(0);
					points.add(point.build());
					CellPoint.Builder point1 = CellPoint.newBuilder();
					point1.setX(0);
					point1.setY(1);
					points.add(point1.build());
					parkHarvestPlantReq.addAllPoints(points);
					sendMsg(parkHarvestPlantReq.build());
					break;
					case "ParkPlaceTreeReq":// ??????
						ParkPlaceTreeReq.Builder parkPlaceTreeReq = ParkPlaceTreeReq.newBuilder();
						parkPlaceTreeReq.setX(Integer.parseInt(args[0]));
						parkPlaceTreeReq.setY(Integer.parseInt(args[1]));
						parkPlaceTreeReq.setPlantID(Integer.parseInt(args[2]));
						sendMsg(parkPlaceTreeReq.build());
						break;
					case "ParkHarvestTreeReq":// ??????
						ParkHarvestTreeReq.Builder parkHarvestTreeReq = ParkHarvestTreeReq.newBuilder();
						List<CellPoint> points = Lists.newArrayListWithCapacity(1);
						CellPoint.Builder point = CellPoint.newBuilder();
						point.setX(0);
						point.setY(0);
						points.add(point.build());
						CellPoint.Builder point1 = CellPoint.newBuilder();
						point1.setX(0);
						point1.setY(1);
						points.add(point1.build());
						parkHarvestTreeReq.addAllPoints(points);
						sendMsg(parkHarvestTreeReq.build());
						break;
				case "ParkPlaceAnimalReq":// ????????????
					ParkPlaceAnimalReq.Builder parkPlaceAnimalReq = ParkPlaceAnimalReq.newBuilder();
					parkPlaceAnimalReq.setAnimalID(Integer.parseInt(args[0]));
					sendMsg(parkPlaceAnimalReq.build());
					break;
				case "ParkHarvestAnimalReq":// ????????????
					ParkHarvestAnimalReq.Builder parkHarvestAnimalReq = ParkHarvestAnimalReq.newBuilder();
					sendMsg(parkHarvestAnimalReq.build());
					break;
				case "ParkDrawHoneyReq":// ????????????
					ParkDrawHoneyReq.Builder parkDrawHoneyReq = ParkDrawHoneyReq.newBuilder();
					sendMsg(parkDrawHoneyReq.build());
					break;
				case "ParkDrawPrizeReq":// ??????
					ParkDrawPrizeReq.Builder parkDrawPrizeReq = ParkDrawPrizeReq.newBuilder();
					sendMsg(parkDrawPrizeReq.build());
					break;
				case "StartMeetEggReq":// ???????????????
					StartMeetEggReq.Builder startMeetEggReq = StartMeetEggReq.newBuilder();
					startMeetEggReq.setBuildID(7101);
					startMeetEggReq.setPositionX(0);
					sendMsg(startMeetEggReq.build());
					break;
				case "MeetEggPauseStartReq":// ????????????
					MeetEggPauseStartReq.Builder meetEggPauseStartReq = MeetEggPauseStartReq.newBuilder();
					meetEggPauseStartReq.setState(Integer.parseInt(args[0]));
					sendMsg(meetEggPauseStartReq.build());
					break;
				case "TradeUseReq":// ??????
					TradeUseReq.Builder tradeUseReq = TradeUseReq.newBuilder();
					tradeUseReq.setType(TradeType.Purchase);
					tradeUseReq.setOrderId(500030035);
					tradeUseReq.setId(5);
					tradeUseReq.setNum(1);
					sendMsg(tradeUseReq.build());
					break;
				case "TradeTopNReq":
					TradeTopNReq.Builder tradeTopNReq = TradeTopNReq.newBuilder();
					tradeTopNReq.setType(TradeType.forNumber(Integer.parseInt(args[0])));
					tradeTopNReq.setOrderId(Integer.parseInt(args[1]));
					sendMsg(tradeTopNReq.build());
					break;
				case "TaskListReq":// ????????????
					TaskListReq.Builder taskListReq = TaskListReq.newBuilder();
					sendMsg(taskListReq.build());
					break;
				case "TaskStateListReq":// ????????????????????????
					TaskStateListReq.Builder taskStateListReq = TaskStateListReq.newBuilder();
					sendMsg(taskStateListReq.build());
					break;
				case "TaskAcceptReq":// ????????????
					TaskAcceptReq.Builder taskAcceptReq = TaskAcceptReq.newBuilder();
					taskAcceptReq.setType(ETaskType.forNumber(Integer.parseInt(args[0])));
					taskAcceptReq.setTaskId(Integer.parseInt(args[1]));
					sendMsg(taskAcceptReq.build());
					break;
				case "TaskRemoveReq":// ????????????
					TaskRemoveReq.Builder taskRemoveReq = TaskRemoveReq.newBuilder();
					taskRemoveReq.setType(ETaskType.forNumber(Integer.parseInt(args[0])));
					taskRemoveReq.setTaskId(Integer.parseInt(args[1]));
					sendMsg(taskRemoveReq.build());
					break;
				case "TaskFirstReq":// ??????????????????
					TaskFirstReq.Builder taskFirstReq = TaskFirstReq.newBuilder();
					taskFirstReq.setTaskId(Integer.parseInt(args[0]));
					taskFirstReq.setType(ETaskType.forNumber(Integer.parseInt(args[1])));
					sendMsg(taskFirstReq.build());
					break;
				case "TaskRefreshReq":// ????????????
					TaskRefreshReq.Builder taskRefreshReq = TaskRefreshReq.newBuilder();
					taskRefreshReq.setType(ETaskType.forNumber(Integer.parseInt(args[1])));
					sendMsg(taskRefreshReq.build());
					break;
				case "TaskRewardReq":// ??????????????????
					TaskRewardReq.Builder taskRewardReq = TaskRewardReq.newBuilder();
					taskRewardReq.setTaskId(Integer.parseInt(args[0]));
					taskRewardReq.setType(ETaskType.forNumber(Integer.parseInt(args[1])));
					sendMsg(taskRewardReq.build());
					break;
				case "VerifiedQueueReq":// ??????-?????????????????????
					VerifiedQueueReq.Builder verifiedQueueReq = VerifiedQueueReq.newBuilder();
					sendMsg(verifiedQueueReq.build());
					break;
				case "VerifyingQueueReq":// ??????-?????????????????????
					VerifyingQueueReq.Builder verifyingQueueReq = VerifyingQueueReq.newBuilder();
					verifyingQueueReq.setRoleId(Long.parseLong(args[0]));
					sendMsg(verifyingQueueReq.build());
					break;
				case "VerifyItemReq":// ?????????????????????
					VerifyItemReq.Builder verifyItemReq = VerifyItemReq.newBuilder();
					verifyItemReq.setRoleId(Long.parseLong(args[0]));
					verifyItemReq.setIndex(Integer.parseInt(args[1]));
					verifyItemReq.setItemId(Integer.parseInt(args[2]));
					sendMsg(verifyItemReq.build());
					break;
				case "VerifyDequeueReq":
					VerifyDequeueReq.Builder verifyDequeueReq = VerifyDequeueReq.newBuilder();
					verifyDequeueReq.setIndex(Integer.parseInt(args[0]));
					sendMsg(verifyDequeueReq.build());
					break;
				case "VerifyEequeueReq":
					VerifyEnqueueReq.Builder verifyEnqueueReq = VerifyEnqueueReq.newBuilder();
					verifyEnqueueReq.setIndex(Integer.parseInt(args[0]));
					verifyEnqueueReq.setItemId(Integer.parseInt(args[1]));
					sendMsg(verifyEnqueueReq.build());
					break;
				case "VerifyUseCardReq":
					VerifyUseCardReq.Builder verifyUseCardReq = VerifyUseCardReq.newBuilder();
					verifyUseCardReq.setIndex(Integer.parseInt(args[0]));
					verifyUseCardReq.setCardID(Integer.parseInt(args[1]));
					verifyUseCardReq.setCardCount(Integer.parseInt(args[2]));
					sendMsg(verifyUseCardReq.build());
					break;
				case "VerifySpeedupReq":
					VerifySpeedupReq.Builder verifySpeedupReq = VerifySpeedupReq.newBuilder();
					verifySpeedupReq.setIndex(Integer.parseInt(args[0]));
					verifySpeedupReq.setSpeedupCard(Integer.parseInt(args[1]));
					verifySpeedupReq.setCardCount(Integer.parseInt(args[2]));
					sendMsg(verifySpeedupReq.build());
					break;
				case "RankTopNReq":
					RankTopNReq.Builder rankTopNReq = RankTopNReq.newBuilder();
					rankTopNReq.setType(RankType.forNumber(Integer.parseInt(args[0])));
					sendMsg(rankTopNReq.build());
					break;
				case "StockListReq":
					StockListReq.Builder stockListReq = StockListReq.newBuilder();
					stockListReq.addOrderIds(500030001);
					sendMsg(stockListReq.build());
					break;
				case "TradeHistoryReq":
					TradeHistoryReq.Builder tradeHistoryReq = TradeHistoryReq.newBuilder();
					tradeHistoryReq.setOrderId(Integer.parseInt(args[0]));
					sendMsg(tradeHistoryReq.build());
					break;
				case "RankSelfNearbyReq":
					RankSelfNearbyReq.Builder rankSelfNearbyReq = RankSelfNearbyReq.newBuilder();
					rankSelfNearbyReq.setType(RankType.forNumber(Integer.parseInt(args[0])));
					sendMsg(rankSelfNearbyReq.build());
					break;
				case "ShowTableChangePositionReq":
					ShowTableChangePositionReq.Builder showTableChangePositionReq = ShowTableChangePositionReq
							.newBuilder();
					showTableChangePositionReq.setType(Integer.parseInt(args[0]));
					showTableChangePositionReq.setIndex1(Integer.parseInt(args[1]));
					showTableChangePositionReq.setIndex2(Integer.parseInt(args[2]));
					sendMsg(showTableChangePositionReq.build());
					break;
				case "ChatSendReq":
					ChatSendReq.Builder chatSendReq = ChatSendReq.newBuilder();
					chatSendReq.setRoleID(Integer.parseInt(args[0]));
					chatSendReq.setChannel(EChatChannel.forNumber(Integer.parseInt(args[1])));
					chatSendReq.setContent(args[2]);
					sendMsg(chatSendReq.build());
					break;
				case "JoinSceneReq":
					JoinSceneReq.Builder joinSceneReq = JoinSceneReq.newBuilder();
					joinSceneReq.setId(Integer.parseInt(args[0]));
					joinSceneReq.setPassword("");
					joinSceneReq.setPos(ESceneRebornPos.RebornPos);
					sendMsg(joinSceneReq.build());
					break;
				case "ChangeClientDataReq":
					ChangeClientDataReq.Builder changeClientDataReq = ChangeClientDataReq.newBuilder();
					changeClientDataReq.setKey(args[0]);
					changeClientDataReq.setValue(Integer.parseInt(args[1]));
					sendMsg(changeClientDataReq.build());
					break;
				case "RobMapReq":
					RobMapReq.Builder robMapReq = RobMapReq.newBuilder();
					robMapReq.setMapId(Integer.parseInt(args[0]));
					robMapReq.setEnterCondition(2);
					robMapReq.setFloor(1);
					sendMsg(robMapReq.build());
					break;
				case "RobUseSkillReq":
					RobUseSkillReq.Builder robUseSkillReq = RobUseSkillReq.newBuilder();
					robUseSkillReq.setSkillId(1);
					robUseSkillReq.setTargetX(Integer.parseInt(args[0]));
					robUseSkillReq.setTargetY(Integer.parseInt(args[1]));
					sendMsg(robUseSkillReq.build());
					break;
				case "SummonInfoReq":// ??????????????????
					SummonInfoReq.Builder summonInfoReq = SummonInfoReq.newBuilder();
					summonInfoReq.setRoleId(Long.parseLong("10001"));
					sendMsg(summonInfoReq.build());
					break;
				case "SummonReq":// ????????????
					SummonReq.Builder summonReq = SummonReq.newBuilder();
					sendMsg(summonReq.build());
					break;
				case "SummonRetainReq":// ????????????
					SummonRetainReq.Builder summonRetainReq = SummonRetainReq.newBuilder();
					sendMsg(summonRetainReq.build());
					break;
				case "SummonSendReq":// ????????????
					SummonSendReq.Builder summonSendReq = SummonSendReq.newBuilder();
					sendMsg(summonSendReq.build());
					break;
				case "SummonMailRewardReq":// ??????????????????
					SummonMailRewardReq.Builder summonMailRewardReq = SummonMailRewardReq.newBuilder();
					summonMailRewardReq.setIndex(Integer.parseInt(args[0]));
					sendMsg(summonMailRewardReq.build());
					break;
				case "SummonMailRefreshReq":// ??????????????????
					SummonMailRefreshReq.Builder summonMailRefreshReq = SummonMailRefreshReq.newBuilder();
					summonMailRefreshReq.setIndex(Integer.parseInt(args[0]));
					sendMsg(summonMailRefreshReq.build());
					break;
				case "SummonInvestReq":// ????????????
					SummonInvestReq.Builder summonInvestReq = SummonInvestReq.newBuilder();
					summonInvestReq.setIndex(Integer.parseInt(args[0]));
					summonInvestReq.setGaveUp(Boolean.valueOf(args[1]));
					sendMsg(summonInvestReq.build());
					break;
				case "SummonPickupInvestRewardReq":// ????????????????????????
					SummonPickupInvestRewardReq.Builder summonPickupInvestRewardReq = SummonPickupInvestRewardReq.newBuilder();
					summonPickupInvestRewardReq.setRoleId(Long.parseLong(args[0]));
					sendMsg(summonPickupInvestRewardReq.build());
					break;
				case "OutsideBatchReq":// ????????????
					OutsideBatchReq.Builder outsideBatchReq = OutsideBatchReq.newBuilder();
					outsideBatchReq.setCount1(Integer.parseInt(args[0]));
					outsideBatchReq.setCount2(Integer.parseInt(args[1]));
					outsideBatchReq.setCount3(Integer.parseInt(args[2]));
					sendMsg(outsideBatchReq.build());
					break;
				case "UsePowerBarAddStaminaReq":// ????????????????????????
					UsePowerBarAddStaminaReq.Builder usePowerBarAddStaminaReq = UsePowerBarAddStaminaReq.newBuilder();
					usePowerBarAddStaminaReq.setCount(Integer.parseInt(args[0]));
					sendMsg(usePowerBarAddStaminaReq.build());
					break;
				case "FriendSearchReq":// ????????????
					FriendSearchReq.Builder friendSearchReq = FriendSearchReq.newBuilder();
					friendSearchReq.setId(Long.parseLong(args[0]));
					friendSearchReq.setName(args[1]);
					sendMsg(friendSearchReq.build());
					break;
				case "FriendListReq":// ????????????
					FriendListReq.Builder friendListReq = FriendListReq.newBuilder();
					sendMsg(friendListReq.build());
					break;
				case "CreateGuildReq":// ????????????
					CreateGuildReq.Builder createGuildReq = CreateGuildReq.newBuilder();
					createGuildReq.setName(args[0]);
					createGuildReq.setTokenID(ConstantGame.TOKEN);
					createGuildReq.setTokenCount(Integer.parseInt(args[1]));
					sendMsg(createGuildReq.build());
					break;
				case "GuildApplyReq":// ??????????????????
					GuildApplyReq.Builder guildApplyReq = GuildApplyReq.newBuilder();
					guildApplyReq.setGuildId(Long.parseLong(args[0]));
					guildApplyReq.setTokenID(ConstantGame.TOKEN);
					guildApplyReq.setTokenCount(Integer.parseInt(args[1]));
					sendMsg(guildApplyReq.build());
					break;
				case "GuildTaskListReq":// ????????????????????????
					GuildTaskListReq.Builder guildTaskListReq = GuildTaskListReq.newBuilder();
					sendMsg(guildTaskListReq.build());
					break;
				case "GuildTaskAcceptReq":// ??????????????????
					GuildTaskAcceptReq.Builder guildTaskAcceptReq = GuildTaskAcceptReq.newBuilder();
					guildTaskAcceptReq.setTaskId(Integer.parseInt(args[0]));
					sendMsg(guildTaskAcceptReq.build());
					break;
				case "ShowTableSupportReq":// ????????????
					ShowTableSupportReq.Builder showTableSupportReq = ShowTableSupportReq.newBuilder();
					showTableSupportReq.setRoleId(Long.parseLong(args[0]));
					sendMsg(showTableSupportReq.build());
					break;
				case "SignUpGuildBattleReq":// ??????????????????
					SignUpGuildBattleReq.Builder signUpGuildBattleReq = SignUpGuildBattleReq.newBuilder();
					sendMsg(signUpGuildBattleReq.build());
					break;
				case "BattleBuildListReq":// ????????????????????????
					BattleBuildListReq.Builder battleBuildListReq = BattleBuildListReq.newBuilder();
					sendMsg(battleBuildListReq.build());
					break;
				case "HoldBattleBuildReq":// ??????????????????
					HoldBattleBuildReq.Builder holdBattleBuildReq = HoldBattleBuildReq.newBuilder();
					holdBattleBuildReq.setBuildID(Integer.parseInt(args[0]));
					sendMsg(holdBattleBuildReq.build());
					break;
				case "CaptureBattleBuildReq":// ??????????????????
					CaptureBattleBuildReq.Builder captureBattleBuildReq = CaptureBattleBuildReq.newBuilder();
					captureBattleBuildReq.setBuildID(Integer.parseInt(args[0]));
					sendMsg(captureBattleBuildReq.build());
					break;
				case "StartBattleMeetEggReq":// ?????????????????????
					StartBattleMeetEggReq.Builder startBattleMeetEggReq = StartBattleMeetEggReq.newBuilder();
					startBattleMeetEggReq.setBuildID(Integer.parseInt(args[0]));
					startBattleMeetEggReq.setPositionX(0);
					sendMsg(startBattleMeetEggReq.build());
					break;
				case "MonthCardReq":// ??????????????????
					MonthCardReq.Builder monthCardReq = MonthCardReq.newBuilder();
					sendMsg(monthCardReq.build());
					break;
				case "MonthCardDrawReq":// ??????????????????
					MonthCardDrawReq.Builder monthCardDrawReq = MonthCardDrawReq.newBuilder();
					monthCardDrawReq.setType(EDrawTodayType.forNumber(Integer.parseInt(args[0])));
					sendMsg(monthCardDrawReq.build());
					break;
				case "checkWord":// ???????????????
					CheckWordReq.Builder checkWordReq = CheckWordReq.newBuilder();
					checkWordReq.setWord(args[0]);
					sendMsg(checkWordReq.build());
					break;
				case "BookAllTypeReq":// ????????????????????????
					BookAllTypeReq.Builder bookAllTypeReq = BookAllTypeReq.newBuilder();
					sendMsg(bookAllTypeReq.build());
					break;
				case "BookInfoReq":// ?????????????????????????????????
					BookInfoReq.Builder bookInfoReq = BookInfoReq.newBuilder();
					for(int i=0; i<args.length; i++){
						bookInfoReq.addType(BookType.forNumber(Integer.parseInt(args[i])));
					}
					sendMsg(bookInfoReq.build());
					break;
				case "BookRewardReq":// ??????????????????????????????
					BookRewardReq.Builder bookRewardReq = BookRewardReq.newBuilder();
					bookRewardReq.setItemId(Integer.parseInt(args[0]));
					sendMsg(bookRewardReq.build());
					break;
				case "CollectionListReq":// ??????
					CollectionListReq.Builder collectionListReq = CollectionListReq.newBuilder();
					collectionListReq.setType(Integer.parseInt(args[0]));
					sendMsg(collectionListReq.build());
					break;
				case "CollectionExchangeRewardReq":// ??????????????????
					CollectionExchangeRewardReq.Builder collectionExchangeRewardReq = CollectionExchangeRewardReq.newBuilder();
					collectionExchangeRewardReq.setId(Integer.parseInt(args[0]));
					sendMsg(collectionExchangeRewardReq.build());
					break;
				case "NpcListReq":// npc??????
					NpcListReq.Builder npcListReq = NpcListReq.newBuilder();
					npcListReq.setCityID(Integer.parseInt(args[0]));
					sendMsg(npcListReq.build());
					break;
				case "NpcVisitReq":// ??????npc
					NpcVisitReq.Builder npcVisitReq = NpcVisitReq.newBuilder();
					npcVisitReq.setFactoryID(Integer.parseInt(args[0]));
					sendMsg(npcVisitReq.build());
					break;
				case "NpcTriggerEventReq":// npc????????????
					NpcTriggerEventReq.Builder npcTriggerEventReq = NpcTriggerEventReq.newBuilder();
					npcTriggerEventReq.setNpcID(Integer.parseInt(args[0]));
					sendMsg(npcTriggerEventReq.build());
					break;
				case "ItemFriendReq":// ???????????????????????????
					ItemFriendReq.Builder itemFriendReq = ItemFriendReq.newBuilder();
					itemFriendReq.setRoleId(Long.parseLong(args[0]));
					//600020001-1;600020002-1;600020003-1;600020004-1;600020005-1;600020006-1
					itemFriendReq.addItemId(600020001);
					itemFriendReq.addItemId(600020002);
					itemFriendReq.addItemId(600020003);
					itemFriendReq.addItemId(600020004);
					itemFriendReq.addItemId(600020005);
					itemFriendReq.addItemId(600020006);
					sendMsg(itemFriendReq.build());
					break;
				case "ItemInteractReq":// ?????????????????????
					ItemInteractReq.Builder itemInteractReq = ItemInteractReq.newBuilder();
					itemInteractReq.setRoleId(Long.parseLong(args[0]));
					itemInteractReq.setItemId(Integer.parseInt(args[1]));
					itemInteractReq.setCount(Integer.parseInt(args[2]));
					itemInteractReq.setPs(args[3]);
					sendMsg(itemInteractReq.build());
					break;
				case "ItemInteractHistoryReq":// ?????????????????????????????????
					ItemInteractHistoryReq.Builder itemInteractHistoryReq = ItemInteractHistoryReq.newBuilder();
					sendMsg(itemInteractHistoryReq.build());
					break;
				case "NpcOnPoetryInfoReq":// ???????????????????????????????????????
					NpcOnPoetryInfoReq.Builder npcOnPoetryInfoReq = NpcOnPoetryInfoReq.newBuilder();
					sendMsg(npcOnPoetryInfoReq.build());
					break;
				case "NpcOnPoetryReq":// ??????????????????????????????
					NpcOnPoetryReq.Builder npcOnPoetryReq = NpcOnPoetryReq.newBuilder();
					npcOnPoetryReq.setAnswer(AnswerOption.forNumber(Integer.parseInt(args[0])));
					sendMsg(npcOnPoetryReq.build());
					break;
				case "NpcWantThingReq":// ?????????
					NpcWantThingReq.Builder npcWantThingReq = NpcWantThingReq.newBuilder();
					npcWantThingReq.setAnswer(Integer.parseInt(args[0]));
					sendMsg(npcWantThingReq.build());
					break;
				case "LeaveHistoryReq":// ????????????????????????
					LeaveHistoryReq.Builder leaveHistoryReq = LeaveHistoryReq.newBuilder();
					leaveHistoryReq.setType(Integer.parseInt(args[0]));
					sendMsg(leaveHistoryReq.build());
					break;
				default:
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void sendMsg(GeneratedMessageV3 msg) {
		log.info("????????????");
		log.info(msg.getClass().getSimpleName());
		log.info(StringUtil.msg2Json(msg));
		log.info("-----------");
		ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
		int cmd = ProtobufCmdPool.INSTANCE.getCmd(msg.getClass());   
		byteBuf.writeShortLE(cmd);
		byte[] data = msg.toByteArray();
		byteBuf.writeIntLE(data.length);
		byteBuf.writeBytes(data);
		byte[] sendData = new byte[byteBuf.readableBytes()];
		byteBuf.readBytes(sendData);
		clientSocket.send(sendData);
	}
}
