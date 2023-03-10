package com.dj.protobuf;

import java.util.HashMap;
import java.util.Map;

import com.dj.protobuf.alipay.AliPayPreReq;
import com.dj.protobuf.alipay.AliPayPreRsp;
import com.dj.protobuf.alipay.AliPayQueryReq;
import com.dj.protobuf.alipay.AliPayQueryRsp;
import com.dj.protobuf.book.*;
import com.dj.protobuf.buffer.MonthCardDrawReq;
import com.dj.protobuf.buffer.MonthCardDrawRsp;
import com.dj.protobuf.buffer.MonthCardNtf;
import com.dj.protobuf.buffer.MonthCardReq;
import com.dj.protobuf.character.ChangeClientDataReq;
import com.dj.protobuf.character.ChangeClientDataRsp;
import com.dj.protobuf.character.ChangeNameReq;
import com.dj.protobuf.character.ChangeNameRsp;
import com.dj.protobuf.character.ChangeSignatureReq;
import com.dj.protobuf.character.ChangeSignatureRsp;
import com.dj.protobuf.character.CheckWordReq;
import com.dj.protobuf.character.CheckWordRsp;
import com.dj.protobuf.character.LeaveHistoryReq;
import com.dj.protobuf.character.LeaveHistoryRsp;
import com.dj.protobuf.character.UsePowerBarAddStaminaReq;
import com.dj.protobuf.character.UsePowerBarAddStaminaRsp;
import com.dj.protobuf.chat.ChatSendNtf;
import com.dj.protobuf.chat.ChatSendReq;
import com.dj.protobuf.chat.ChatSendRsp;
import com.dj.protobuf.city.*;
import com.dj.protobuf.collection.CollectionExchangeRewardReq;
import com.dj.protobuf.collection.CollectionExchangeRewardRsp;
import com.dj.protobuf.collection.CollectionListReq;
import com.dj.protobuf.collection.CollectionListRsp;
import com.dj.protobuf.collection.CollectionUpdateNtf;
import com.dj.protobuf.forward.ForwardChatSendNtf;
import com.dj.protobuf.forward.ForwardGameHomeReq;
import com.dj.protobuf.forward.ForwardGameHomeRsp;
import com.dj.protobuf.forward.ForwardGameMiniReq;
import com.dj.protobuf.forward.ForwardGameMiniRsp;
import com.dj.protobuf.forward.ForwardGameMultiReq;
import com.dj.protobuf.forward.ForwardGameMultiRsp;
import com.dj.protobuf.forward.ForwardGameParkReq;
import com.dj.protobuf.forward.ForwardGameParkRsp;
import com.dj.protobuf.forward.ForwardGlobalGuildBattleReq;
import com.dj.protobuf.forward.ForwardGlobalGuildBattleRsp;
import com.dj.protobuf.forward.ForwardGlobalGuildReq;
import com.dj.protobuf.forward.ForwardGlobalGuildRsp;
import com.dj.protobuf.forward.ForwardGlobalRankReq;
import com.dj.protobuf.forward.ForwardGlobalRankRsp;
import com.dj.protobuf.forward.ForwardPlayerBasicReq;
import com.dj.protobuf.forward.ForwardPlayerBasicRsp;
import com.dj.protobuf.forward.ForwardPlayerFriendReq;
import com.dj.protobuf.forward.ForwardPlayerFriendRsp;
import com.dj.protobuf.forward.ForwardPlayerGmReq;
import com.dj.protobuf.forward.ForwardPlayerGmRsp;
import com.dj.protobuf.forward.ForwardPlayerHomeReq;
import com.dj.protobuf.forward.ForwardPlayerHomeRsp;
import com.dj.protobuf.forward.ForwardPlayerInitReq;
import com.dj.protobuf.forward.ForwardPlayerInitRsp;
import com.dj.protobuf.forward.ForwardPlayerSingleReq;
import com.dj.protobuf.forward.ForwardPlayerSingleRsp;
import com.dj.protobuf.forward.GameLogoutReq;
import com.dj.protobuf.forward.LogoutReq;
import com.dj.protobuf.friend.*;
import com.dj.protobuf.gm.*;
import com.dj.protobuf.guide.GetGuideRewardReq;
import com.dj.protobuf.guide.GetGuideRewardRsp;
import com.dj.protobuf.guide.GuideInfoReq;
import com.dj.protobuf.guide.GuideInfoRsp;
import com.dj.protobuf.guide.UpdateGuideProcessReq;
import com.dj.protobuf.guide.UpdateGuideProcessRsp;
import com.dj.protobuf.guild.ChangeGuildNameNtf;
import com.dj.protobuf.guild.ChangeGuildNameReq;
import com.dj.protobuf.guild.CreateGuildReq;
import com.dj.protobuf.guild.CreateGuildRsp;
import com.dj.protobuf.guild.GuildAdjustPostReq;
import com.dj.protobuf.guild.GuildAdjustPostRsp;
import com.dj.protobuf.guild.GuildApplyListReq;
import com.dj.protobuf.guild.GuildApplyListRsp;
import com.dj.protobuf.guild.GuildApplyNtf;
import com.dj.protobuf.guild.GuildApplyReq;
import com.dj.protobuf.guild.GuildApplyRsp;
import com.dj.protobuf.guild.GuildApproveNtf;
import com.dj.protobuf.guild.GuildApproveReq;
import com.dj.protobuf.guild.GuildApproveRsp;
import com.dj.protobuf.guild.GuildAttrClientNtf;
import com.dj.protobuf.guild.GuildKickReq;
import com.dj.protobuf.guild.GuildKickRsp;
import com.dj.protobuf.guild.GuildListReq;
import com.dj.protobuf.guild.GuildListRsp;
import com.dj.protobuf.guild.GuildMemberListReq;
import com.dj.protobuf.guild.GuildMemberListRsp;
import com.dj.protobuf.guild.GuildModifySummaryReq;
import com.dj.protobuf.guild.GuildModifySummaryRsp;
import com.dj.protobuf.guild.GuildQuitNtf;
import com.dj.protobuf.guild.GuildSearchReq;
import com.dj.protobuf.guild.GuildSearchRsp;
import com.dj.protobuf.guild.QuitGuildReq;
import com.dj.protobuf.guild.QuitGuildRsp;
import com.dj.protobuf.guildBattle.BattleBuildListReq;
import com.dj.protobuf.guildBattle.BattleBuildListRsp;
import com.dj.protobuf.guildBattle.BattleBuildUpdateNtf;
import com.dj.protobuf.guildBattle.BattleChangeMeetXReq;
import com.dj.protobuf.guildBattle.BattleChangeMeetXRsp;
import com.dj.protobuf.guildBattle.BattleHoldScoreNtf;
import com.dj.protobuf.guildBattle.BattleMeetDropReq;
import com.dj.protobuf.guildBattle.BattleMeetDropRsp;
import com.dj.protobuf.guildBattle.BattleMeetEggDropNtf;
import com.dj.protobuf.guildBattle.BattleMeetEggStopNtf;
import com.dj.protobuf.guildBattle.BattleMeetScoreNtf;
import com.dj.protobuf.guildBattle.BattleOverNtf;
import com.dj.protobuf.guildBattle.CaptureBattleBuildNtf;
import com.dj.protobuf.guildBattle.CaptureBattleBuildReq;
import com.dj.protobuf.guildBattle.CaptureBattleBuildRsp;
import com.dj.protobuf.guildBattle.ExitBattleBuildListReq;
import com.dj.protobuf.guildBattle.ExitBattleBuildListRsp;
import com.dj.protobuf.guildBattle.ExitBattleMeetEggReq;
import com.dj.protobuf.guildBattle.ExitBattleMeetEggRsp;
import com.dj.protobuf.guildBattle.GuildBattleMatchSucessNtf;
import com.dj.protobuf.guildBattle.HoldBattleBuildReq;
import com.dj.protobuf.guildBattle.HoldBattleBuildRsp;
import com.dj.protobuf.guildBattle.SignUpGuildBattleReq;
import com.dj.protobuf.guildBattle.SignUpGuildBattleRsp;
import com.dj.protobuf.guildBattle.StartBattleMeetEggNtf;
import com.dj.protobuf.guildBattle.StartBattleMeetEggReq;
import com.dj.protobuf.guildTask.*;
import com.dj.protobuf.item.*;
import com.dj.protobuf.leaderboard.RankGuildInfoNtf;
import com.dj.protobuf.leaderboard.RankSelfNearbyReq;
import com.dj.protobuf.leaderboard.RankSelfNearbyRsp;
import com.dj.protobuf.leaderboard.RankStockInfoNtf;
import com.dj.protobuf.leaderboard.RankTopNReq;
import com.dj.protobuf.leaderboard.RoleRankCommonInfoNtf;
import com.dj.protobuf.login.*;
import com.dj.protobuf.mall.MallBuyReq;
import com.dj.protobuf.mall.MallBuyRsp;
import com.dj.protobuf.mall.MallListReq;
import com.dj.protobuf.mall.MallListRsp;
import com.dj.protobuf.manufacture.ManufactureActionReq;
import com.dj.protobuf.manufacture.ManufactureActionRsp;
import com.dj.protobuf.manufacture.ManufactureBatchPickupReq;
import com.dj.protobuf.manufacture.ManufactureBatchPickupRsp;
import com.dj.protobuf.manufacture.ManufactureInfoReq;
import com.dj.protobuf.manufacture.ManufactureInfoRsp;
import com.dj.protobuf.manufacture.ManufactureSpeedupReq;
import com.dj.protobuf.manufacture.ManufactureSpeedupRsp;
import com.dj.protobuf.meetEgg.ChangeMeetXReq;
import com.dj.protobuf.meetEgg.ChangeMeetXRsp;
import com.dj.protobuf.meetEgg.ExitMeetEggReq;
import com.dj.protobuf.meetEgg.ExitMeetEggRsp;
import com.dj.protobuf.meetEgg.MeetDropReq;
import com.dj.protobuf.meetEgg.MeetDropRsp;
import com.dj.protobuf.meetEgg.MeetEggDropNtf;
import com.dj.protobuf.meetEgg.MeetEggPauseStartReq;
import com.dj.protobuf.meetEgg.MeetEggPauseStartRsp;
import com.dj.protobuf.meetEgg.MeetEggStopNtf;
import com.dj.protobuf.meetEgg.StartMeetEggReq;
import com.dj.protobuf.meetEgg.StartMeetEggRsp;
import com.dj.protobuf.obstacle.ObstaclesListReq;
import com.dj.protobuf.obstacle.ObstaclesListRsp;
import com.dj.protobuf.obstacle.ObstaclesOpenupReq;
import com.dj.protobuf.obstacle.ObstaclesOpenupRsp;
import com.dj.protobuf.outside.OutsideBatchReq;
import com.dj.protobuf.outside.OutsideBatchRsp;
import com.dj.protobuf.outside.OutsideGuideReq;
import com.dj.protobuf.outside.OutsideGuideRsp;
import com.dj.protobuf.outside.OutsideReq;
import com.dj.protobuf.outside.OutsideRsp;
import com.dj.protobuf.park.*;
import com.dj.protobuf.rob.*;
import com.dj.protobuf.scene.CheckSceneReq;
import com.dj.protobuf.scene.CheckSceneRsp;
import com.dj.protobuf.scene.JoinSceneNtf;
import com.dj.protobuf.scene.JoinSceneReq;
import com.dj.protobuf.scene.JoinSceneRsp;
import com.dj.protobuf.scene.LeaveSceneNtf;
import com.dj.protobuf.scene.LeaveSceneReq;
import com.dj.protobuf.scene.LeaveSceneRsp;
import com.dj.protobuf.scene.SceneMapNtf;
import com.dj.protobuf.scene.SceneMovementNtf;
import com.dj.protobuf.scene.SceneMovementReq;
import com.dj.protobuf.scene.SceneMovementRsp;
import com.dj.protobuf.scene.ScenePosReq;
import com.dj.protobuf.scene.ScenePosRsp;
import com.dj.protobuf.scene.ScenePosUpdateReq;
import com.dj.protobuf.scene.ScenePosUpdateRsp;
import com.dj.protobuf.scene.SceneUseSkillNtf;
import com.dj.protobuf.scene.SceneUseSkillReq;
import com.dj.protobuf.scene.SceneUseSkillRsp;
import com.dj.protobuf.server.KeepAlive4GameReq;
import com.dj.protobuf.server.KeepAlive4GameRsp;
import com.dj.protobuf.server.KeepAlive4GlobalReq;
import com.dj.protobuf.server.KeepAlive4GlobalRsp;
import com.dj.protobuf.server.KeepAlive4PlayerReq;
import com.dj.protobuf.server.KeepAlive4PlayerRsp;
import com.dj.protobuf.server.ReadPlayerItemReq;
import com.dj.protobuf.server.ReadPlayerItemRsp;
import com.dj.protobuf.server.RegisterGate2GameReq;
import com.dj.protobuf.server.RegisterGate2GameRsp;
import com.dj.protobuf.server.RegisterGate2GlobalReq;
import com.dj.protobuf.server.RegisterGate2GlobalRsp;
import com.dj.protobuf.server.RegisterGate2PlayerReq;
import com.dj.protobuf.server.RegisterGate2PlayerRsp;
import com.dj.protobuf.server.UpdateConfig4GameReq;
import com.dj.protobuf.server.UpdateConfig4GameRsp;
import com.dj.protobuf.server.UpdateConfig4GlobalReq;
import com.dj.protobuf.server.UpdateConfig4GlobalRsp;
import com.dj.protobuf.server.UpdateConfig4PlayerReq;
import com.dj.protobuf.server.UpdateConfig4PlayerRsp;
import com.dj.protobuf.server.UpdateConfigReq;
import com.dj.protobuf.server.UpdateConfigRsp;
import com.dj.protobuf.server.UpdateConnectLogicReq;
import com.dj.protobuf.server.UpdateConnectLogicRsp;
import com.dj.protobuf.showtable.*;
import com.dj.protobuf.summon.*;
import com.dj.protobuf.task.*;
import com.dj.protobuf.trade.StockListReq;
import com.dj.protobuf.trade.StockListRsp;
import com.dj.protobuf.trade.TradeCloseReq;
import com.dj.protobuf.trade.TradeCloseRsp;
import com.dj.protobuf.trade.TradeDequeueReq;
import com.dj.protobuf.trade.TradeDequeueRsp;
import com.dj.protobuf.trade.TradeEnqueueReq;
import com.dj.protobuf.trade.TradeEnqueueRsp;
import com.dj.protobuf.trade.TradeHistoryReq;
import com.dj.protobuf.trade.TradeHistoryRsp;
import com.dj.protobuf.trade.TradeRoleReq;
import com.dj.protobuf.trade.TradeRoleRsp;
import com.dj.protobuf.trade.TradeTopNReq;
import com.dj.protobuf.trade.TradeTopNRsp;
import com.dj.protobuf.trade.TradeUseNtf;
//import com.dj.protobuf.trade.TradeUseReq;
//import com.dj.protobuf.trade.TradeUseRsp;
import com.dj.protobuf.verify.VerifiedQueueReq;
import com.dj.protobuf.verify.VerifiedQueueRsp;
import com.dj.protobuf.verify.VerifyDequeueReq;
import com.dj.protobuf.verify.VerifyDequeueRsp;
import com.dj.protobuf.verify.VerifyEnqueueReq;
import com.dj.protobuf.verify.VerifyEnqueueRsp;
import com.dj.protobuf.verify.VerifyItemReq;
import com.dj.protobuf.verify.VerifyItemRsp;
import com.dj.protobuf.verify.VerifyLeaveReq;
import com.dj.protobuf.verify.VerifyLeaveRsp;
import com.dj.protobuf.verify.VerifySpeedupReq;
import com.dj.protobuf.verify.VerifySpeedupRsp;
import com.dj.protobuf.verify.VerifyUseCardReq;
import com.dj.protobuf.verify.VerifyUseCardRsp;
import com.dj.protobuf.verify.VerifyingQueueReq;
import com.dj.protobuf.verify.VerifyingQueueRsp;
import com.dj.protobuf.wxpay.WxPayQueryReq;
import com.dj.protobuf.wxpay.WxPayQueryRsp;
import com.dj.protobuf.wxpay.WxPrePayReq;
import com.dj.protobuf.wxpay.WxPrePayRsp;
import com.google.protobuf.MessageLite;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("rawtypes")
public enum ProtobufCmdPool {
    INSTANCE;

    @Getter
    private Map<Class, Integer> cls2cmd = new HashMap<>();
    private Map<Integer, CmdUnit> cmd2Unit = new HashMap<>();

    {
        // ???????????????
        registerCmd(RegisterGate2PlayerReq.class, ProtobufCmd.SERVER_REGISTER_GATE2PLAYER_REQ, ServerType.PLAYER, Module.PLAYER_SERVER);
        registerCmd(RegisterGate2PlayerRsp.class, ProtobufCmd.SERVER_REGISTER_GATE2PLAYER_RSP, ServerType.GATE, Module.GATE_SERVER);

        // ???????????????
        registerCmd(KeepAlive4PlayerReq.class, ProtobufCmd.SERVER_KEEPALIVE4PLAYER_REQ, ServerType.PLAYER, Module.PLAYER_SERVER);
        registerCmd(KeepAlive4PlayerRsp.class, ProtobufCmd.SERVER_KEEPALIVE4PLAYER_RSP, ServerType.GATE, Module.GATE_SERVER);

        // ????????????
        registerCmd(LogoutReq.class, ProtobufCmd.SERVER_PLAYER_LOGOUT_REQ, ServerType.PLAYER, Module.PLAYER_INIT);
        // ????????????
        registerCmd(GameLogoutReq.class, ProtobufCmd.SERVER_GAME_LOGOUT_REQ, ServerType.PLAYER, Module.GAME_HOME);
        // ????????????
        registerCmd(ForwardChatSendNtf.class, ProtobufCmd.SERVER_FORWARD_CHAT_SEND_NTF, ServerType.GATE, Module.CHAT);

        // ?????????????????????
        registerCmd(ForwardPlayerInitReq.class, ProtobufCmd.SERVER_FORWARD_PLAYER_INIT_REQ, ServerType.PLAYER, Module.PLAYER_INIT);
        registerCmd(ForwardPlayerInitRsp.class, ProtobufCmd.SERVER_FORWARD_PLAYER_INIT_RSP, ServerType.GATE, Module.PLAYER_INIT);

        // ??????????????????
        registerCmd(ForwardPlayerBasicReq.class, ProtobufCmd.SERVER_FORWARD_PLAYER_BASIC_REQ, ServerType.PLAYER, Module.PLAYER_BASIC);
        registerCmd(ForwardPlayerBasicRsp.class, ProtobufCmd.SERVER_FORWARD_PLAYER_BASIC_RSP, ServerType.GATE, Module.PLAYER_BASIC);

        // ??????????????????
        registerCmd(ForwardPlayerFriendReq.class, ProtobufCmd.SERVER_FORWARD_PLAYER_FRIEND_REQ, ServerType.PLAYER, Module.PLAYER_FRIEND);
        registerCmd(ForwardPlayerFriendRsp.class, ProtobufCmd.SERVER_FORWARD_PLAYER_FRIEND_RSP, ServerType.GATE, Module.PLAYER_FRIEND);

        // ??????????????????
        registerCmd(ForwardPlayerHomeReq.class, ProtobufCmd.SERVER_FORWARD_PLAYER_HOME_REQ, ServerType.PLAYER, Module.PLAYER_HOME);
        registerCmd(ForwardPlayerHomeRsp.class, ProtobufCmd.SERVER_FORWARD_PLAYER_HOME_RSP, ServerType.GATE, Module.PLAYER_HOME);

        // ??????????????????
        registerCmd(ForwardPlayerSingleReq.class, ProtobufCmd.SERVER_FORWARD_PLAYER_SINGLE_REQ, ServerType.PLAYER, Module.PLAYER_SINGLE);
        registerCmd(ForwardPlayerSingleRsp.class, ProtobufCmd.SERVER_FORWARD_PLAYER_SINGLE_RSP, ServerType.GATE, Module.PLAYER_SINGLE);

        // ??????GM??????
        registerCmd(ForwardPlayerGmReq.class, ProtobufCmd.SERVER_FORWARD_PLAYER_GM_REQ, ServerType.PLAYER, Module.PLAYER_GM);
        registerCmd(ForwardPlayerGmRsp.class, ProtobufCmd.SERVER_FORWARD_PLAYER_GM_RSP, ServerType.GATE, Module.PLAYER_GM);

        // ????????????????????????
        //registerCmd(ForwardPlayerGmReq.class, ProtobufCmd.SERVER_FORWARD_PLAYER_WECHATPAY_REQ, ServerType.PLAYER, Module.WECHAT_PAY);
        //registerCmd(ForwardPlayerGmRsp.class, ProtobufCmd.SERVER_FORWARD_PLAYER_WECHATPAY_RSP, ServerType.GATE, Module.WECHAT_PAY);

        // ???????????????
        registerCmd(RegisterGate2GameReq.class, ProtobufCmd.SERVER_REGISTER_GATE2GAME_REQ, ServerType.GAME, Module.GAME_SERVER);
        registerCmd(RegisterGate2GameRsp.class, ProtobufCmd.SERVER_REGISTER_GATE2GAME_RSP, ServerType.GATE, Module.GATE_SERVER);

        // ???????????????
        registerCmd(KeepAlive4GameReq.class, ProtobufCmd.SERVER_KEEPALIVE4GAME_REQ, ServerType.GAME, Module.GAME_SERVER);
        registerCmd(KeepAlive4GameRsp.class, ProtobufCmd.SERVER_KEEPALIVE4GAME_RSP, ServerType.GATE, Module.GATE_SERVER);

        // ??????????????????
        registerCmd(ForwardGameHomeReq.class, ProtobufCmd.SERVER_FORWARD_GAMEHOME_REQ, ServerType.GAME, Module.GAME_HOME);
        registerCmd(ForwardGameHomeRsp.class, ProtobufCmd.SERVER_FORWARD_GAMEHOME_RSP, ServerType.GATE, Module.GAME_HOME);
        // ??????????????????
        registerCmd(ForwardGameMultiReq.class, ProtobufCmd.SERVER_FORWARD_GAMEMULTI_REQ, ServerType.GAME, Module.GAME_MULTI);
        registerCmd(ForwardGameMultiRsp.class, ProtobufCmd.SERVER_FORWARD_GAMEMULTI_RSP, ServerType.GATE, Module.GAME_MULTI);
        // ???????????????
        registerCmd(ForwardGameParkReq.class, ProtobufCmd.SERVER_FORWARD_GAMEPARK_REQ, ServerType.GAME, Module.GAME_PARK);
        registerCmd(ForwardGameParkRsp.class, ProtobufCmd.SERVER_FORWARD_GAMEPARK_RSP, ServerType.GATE, Module.GAME_PARK);
        // ???????????????
        registerCmd(ForwardGameMiniReq.class, ProtobufCmd.SERVER_FORWARD_GAMEMINI_REQ, ServerType.GAME, Module.GAME_MINI);
        registerCmd(ForwardGameMiniRsp.class, ProtobufCmd.SERVER_FORWARD_GAMEMINI_RSP, ServerType.GATE, Module.GAME_MINI);

        // ???????????????
        registerCmd(RegisterGate2GlobalReq.class, ProtobufCmd.SERVER_REGISTER_GATE2GLOBAL_REQ, ServerType.GLOBAL, Module.GLOBAL_SERVER);
        registerCmd(RegisterGate2GlobalRsp.class, ProtobufCmd.SERVER_REGISTER_GATE2GLOBAL_RSP, ServerType.GATE, Module.GATE_SERVER);

        // ???????????????
        registerCmd(KeepAlive4GlobalReq.class, ProtobufCmd.SERVER_KEEPALIVE4GLOBAL_REQ, ServerType.GLOBAL, Module.GLOBAL_SERVER);
        registerCmd(KeepAlive4GlobalRsp.class, ProtobufCmd.SERVER_KEEPALIVE4GLOBAL_RSP, ServerType.GATE, Module.GATE_SERVER);

        // ??????????????????
        registerCmd(ForwardGlobalRankReq.class, ProtobufCmd.SERVER_FORWARD_GLOBALRANK_REQ, ServerType.GLOBAL, Module.GLOBAL_RANK);
        registerCmd(ForwardGlobalRankRsp.class, ProtobufCmd.SERVER_FORWARD_GLOBALRANK_RSP, ServerType.GATE, Module.GLOBAL_RANK);
        // ??????????????????
        registerCmd(ForwardGlobalGuildReq.class, ProtobufCmd.SERVER_FORWARD_GLOBALGUILD_REQ, ServerType.GLOBAL, Module.GLOBAL_GUILD);
        registerCmd(ForwardGlobalGuildRsp.class, ProtobufCmd.SERVER_FORWARD_GLOBALGUILD_RSP, ServerType.GATE, Module.GLOBAL_GUILD);
        // ????????????????????????
        registerCmd(ForwardGlobalGuildBattleReq.class, ProtobufCmd.SERVER_FORWARD_GLOBALGUILDBATTLE_REQ, ServerType.GLOBAL, Module.GLOBAL_GUILD_BATTLE);
        registerCmd(ForwardGlobalGuildBattleRsp.class, ProtobufCmd.SERVER_FORWARD_GLOBALGUILDBATTLE_RSP, ServerType.GATE, Module.GLOBAL_GUILD_BATTLE);

        // ????????????
        registerCmd(UpdateConfigReq.class, ProtobufCmd.SERVER_UPDATE_CONFIG_REQ, ServerType.GATE, Module.GATE_SERVER);
        registerCmd(UpdateConfigRsp.class, ProtobufCmd.SERVER_UPDATE_CONFIG_RSP, ServerType.CLIENT, Module.CLIENT);
        // ?????????????????????
        registerCmd(UpdateConfig4PlayerReq.class, ProtobufCmd.SERVER_UPDATE_CONFIG_4PLAYER_REQ, ServerType.PLAYER, Module.PLAYER_SERVER);
        registerCmd(UpdateConfig4PlayerRsp.class, ProtobufCmd.SERVER_UPDATE_CONFIG_4PLAYER_RSP, ServerType.CLIENT, Module.CLIENT);
        // ?????????????????????
        registerCmd(UpdateConfig4GameReq.class, ProtobufCmd.SERVER_UPDATE_CONFIG_4GAME_REQ, ServerType.GAME, Module.GAME_SERVER);
        registerCmd(UpdateConfig4GameRsp.class, ProtobufCmd.SERVER_UPDATE_CONFIG_4GAME_RSP, ServerType.CLIENT, Module.CLIENT);
        // ?????????????????????
        registerCmd(UpdateConfig4GlobalReq.class, ProtobufCmd.SERVER_UPDATE_CONFIG_4GLOBAL_REQ, ServerType.GLOBAL, Module.GLOBAL_SERVER);
        registerCmd(UpdateConfig4GlobalRsp.class, ProtobufCmd.SERVER_UPDATE_CONFIG_4GLOBAL_RSP, ServerType.CLIENT, Module.CLIENT);

        // ?????????????????????
        registerCmd(UpdateConnectLogicReq.class, ProtobufCmd.SERVER_UPDATE_CONNECT_LOGIC_REQ, ServerType.GATE, Module.GATE_SERVER);
        registerCmd(UpdateConnectLogicRsp.class, ProtobufCmd.SERVER_UPDATE_CONNECT_LOGIC_RSP, ServerType.CLIENT, Module.CLIENT);

        // ??????????????????
        registerCmd(ReadPlayerItemReq.class, ProtobufCmd.SERVER_READ_PLAYER_ITEM_REQ, ServerType.PLAYER, Module.PLAYER_INIT);
        registerCmd(ReadPlayerItemRsp.class, ProtobufCmd.SERVER_READ_PLAYER_ITEM_RSP, ServerType.GATE, Module.GATE_SERVER);

        // ==================================client=========================================
        // ?????????????????????????????????????????????
        registerCmd(HeartbeatCfgNtf.class, ProtobufCmd.SERVER_HEARTBEATCFG_NTF, ServerType.CLIENT, Module.PLAYER_BASIC);
        // ????????????????????????
        registerCmd(HeartbeatInfo.class, ProtobufCmd.SERVER_HEARTBEAT_INFO, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(HeartbeatInfoRsp.class, ProtobufCmd.SERVER_HEARTBEAT_INFO_RSP, ServerType.CLIENT, Module.CLIENT);
        // ?????????????????????
        registerCmd(CreateSmsCodeReq.class, ProtobufCmd.CLIENT_CREATE_SMS_CODE_REQ, ServerType.GATE, Module.PLAYER_INIT);
        registerCmd(CreateSmsCodeRsp.class, ProtobufCmd.CLIENT_CREATE_SMS_CODE_RSP, ServerType.CLIENT, Module.CLIENT);
        // ?????????????????????
        registerCmd(VerifySmsCodeReq.class, ProtobufCmd.CLIENT_VERIFY_SMS_CODE_REQ, ServerType.GATE, Module.PLAYER_INIT);
        registerCmd(VerifySmsCodeRsp.class, ProtobufCmd.CLIENT_VERIFY_SMS_CODE_RSP, ServerType.CLIENT, Module.CLIENT);
        // ????????????
        registerCmd(ResetPasswordReq.class, ProtobufCmd.CLIENT_RESET_PASSWORD_REQ, ServerType.GATE, Module.PLAYER_INIT);
        registerCmd(ResetPasswordRsp.class, ProtobufCmd.CLIENT_RESET_PASSWORD_RSP, ServerType.CLIENT, Module.CLIENT);
        // ????????????
        registerCmd(CreateAccountReq.class, ProtobufCmd.CLIENT_CREATE_ACCOUNT_REQ, ServerType.GATE, Module.PLAYER_INIT);
        registerCmd(CreateAccountRsp.class, ProtobufCmd.CLIENT_CREATE_ACCOUNT_RSP, ServerType.CLIENT, Module.CLIENT);
        // ????????????
        registerCmd(UserLoginReq.class, ProtobufCmd.CLIENT_LOGIN_USERLOGIN_REQ, ServerType.GATE, Module.PLAYER_INIT);
        registerCmd(UserLoginRsp.class, ProtobufCmd.CLIENT_LOGIN_USERLOGIN_RSP, ServerType.CLIENT, Module.CLIENT);
        // ????????????
        registerCmd(ReloginReq.class, ProtobufCmd.CLIENT_LOGIN_RELOGIN_REQ, ServerType.GATE, Module.PLAYER_INIT);
        registerCmd(ReloginRsp.class, ProtobufCmd.CLIENT_LOGIN_RELOGIN_RSP, ServerType.CLIENT, Module.CLIENT);
        // ????????????????????????
        registerCmd(RoleLoginNtf.class, ProtobufCmd.CLIENT_LOGIN_ROLE_LOGIN_NTF, ServerType.CLIENT, Module.PLAYER_INIT);
        // ?????????????????????
        registerCmd(ServerStopNtf.class, ProtobufCmd.CLIENT_SERVER_STOP_NTF, ServerType.GATE, Module.GATE_SERVER);
        // ??????????????????
        registerCmd(ClosebbsNtf.class, ProtobufCmd.CLIENT_CLOSE_BBS_NTF, ServerType.GATE, Module.GATE_SERVER);
        // ?????????????????????
        registerCmd(KickOutGameNtf.class, ProtobufCmd.CLIENT_KICK_OUT_GAME_NTF, ServerType.GATE, Module.GATE_SERVER);
        // ????????????
        registerCmd(RealNameAuthReq.class, ProtobufCmd.REAL_NAME_AUTH_REQ, ServerType.GATE, Module.PLAYER_INIT);
        registerCmd(RealNameAuthRsp.class, ProtobufCmd.REAL_NAME_AUTH_RSP, ServerType.CLIENT, Module.CLIENT);
        // ??????????????????????????????
        registerCmd(PlayerAttrClientNtfFinish.class, ProtobufCmd.CLIENT_PLAYER_ATTR_CLIENT_NTF_FINISH, ServerType.CLIENT, Module.CLIENT);
        // ????????????????????????
        registerCmd(PlayerAttrClientNtf.class, ProtobufCmd.CLIENT_PLAYER_ATTR_CLIENT_NTF, ServerType.CLIENT, Module.CLIENT);

        // ????????????
        registerCmd(ChangeNameReq.class, ProtobufCmd.CLIENT_CHANGE_NAME_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(ChangeNameRsp.class, ProtobufCmd.CLIENT_CHANGE_NAME_RSP, ServerType.CLIENT, Module.CLIENT);
        // ??????????????????
        registerCmd(ChangeSignatureReq.class, ProtobufCmd.CLIENT_CHANGE_SIGNATURE_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(ChangeSignatureRsp.class, ProtobufCmd.CLIENT_CHANGE_SIGNATURE_RSP, ServerType.CLIENT, Module.CLIENT);
        // ?????????????????????
        registerCmd(ChangeClientDataReq.class, ProtobufCmd.CLIENT_CHANGE_CLIENT_DATA_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(ChangeClientDataRsp.class, ProtobufCmd.CLIENT_CHANGE_CLIENT_DATA_RSP, ServerType.CLIENT, Module.CLIENT);
        // ????????????????????????
        registerCmd(UsePowerBarAddStaminaReq.class, ProtobufCmd.CLIENT_USE_POWER_BAR_ADD_STAMINA_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(UsePowerBarAddStaminaRsp.class, ProtobufCmd.CLIENT_USE_POWER_BAR_ADD_STAMINA_RSP, ServerType.CLIENT, Module.CLIENT);
        // ???????????????
        registerCmd(CheckWordReq.class, ProtobufCmd.CLIENT_CHECK_WORD_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(CheckWordRsp.class, ProtobufCmd.CLIENT_CHECK_WORD_RSP, ServerType.CLIENT, Module.CLIENT);
        // ????????????????????????
        registerCmd(LeaveHistoryReq.class, ProtobufCmd.CLIENT_LEAVE_HISTORY_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(LeaveHistoryRsp.class, ProtobufCmd.CLIENT_LEAVE_HISTORY_RSP, ServerType.CLIENT, Module.CLIENT);
        // ??????
        registerCmd(MonthCardReq.class, ProtobufCmd.CLIENT_MONTH_CARD_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(MonthCardNtf.class, ProtobufCmd.CLIENT_MONTH_CARD_NTF, ServerType.CLIENT, Module.CLIENT);
        // ??????????????????
        registerCmd(MonthCardDrawReq.class, ProtobufCmd.CLIENT_MONTH_CARD_DRAW_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(MonthCardDrawRsp.class, ProtobufCmd.CLIENT_MONTH_CARD_DRAW_RSP, ServerType.CLIENT, Module.CLIENT);

        // ????????????
        registerCmd(ItemListReq.class, ProtobufCmd.CLIENT_ITEM_LIST_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(ItemListRsp.class, ProtobufCmd.CLIENT_ITEM_LIST_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ItemRemoveReq.class, ProtobufCmd.CLIENT_ITEM_REMOVE_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(ItemRemoveRsp.class, ProtobufCmd.CLIENT_ITEM_REMOVE_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????????????????
        registerCmd(ItemInteractReq.class, ProtobufCmd.CLIENT_ITEM_INTERACT_REQ, ServerType.GATE, Module.GAME_HOME);
        registerCmd(ItemInteractRsp.class, ProtobufCmd.CLIENT_ITEM_INTERACT_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(ItemUpdateNtf.class, ProtobufCmd.CLIENT_ITEM_UPDATE_NTF, ServerType.GATE, Module.PLAYER_BASIC);
        // ???????????????????????????
        registerCmd(ItemFriendReq.class, ProtobufCmd.CLIENT_ITEM_FRIEND_REQ, ServerType.GATE, Module.GAME_HOME);
        registerCmd(ItemFriendRsp.class, ProtobufCmd.CLIENT_ITEM_FRIEND_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????????????????????????????
        registerCmd(ItemInteractHistoryReq.class, ProtobufCmd.CLIENT_ITEM_INTERACT_HISTORY_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(ItemInteractHistoryRsp.class, ProtobufCmd.CLIENT_ITEM_INTERACT_HISTORY_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????????????????
        registerCmd(PlayerMapItemReq.class, ProtobufCmd.CLIENT_PLAYER_MAP_ITEM_REQ, ServerType.GATE, Module.GAME_HOME);
        registerCmd(PlayerMapItemRsp.class, ProtobufCmd.CLIENT_PLAYER_MAP_ITEM_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ScenePosReq.class, ProtobufCmd.CLIENT_SCENE_POS_REQ, ServerType.GATE, Module.GAME_HOME);
        registerCmd(ScenePosRsp.class, ProtobufCmd.CLIENT_SCENE_POS_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(ScenePosUpdateReq.class, ProtobufCmd.CLIENT_SCENE_POS_UPDATE_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(ScenePosUpdateRsp.class, ProtobufCmd.CLIENT_SCENE_POS_UPDATE_RSP, ServerType.GATE, Module.CLIENT);

        // ????????????
        registerCmd(FriendListReq.class, ProtobufCmd.CLIENT_FRIEND_LIST_REQ, ServerType.GATE, Module.PLAYER_FRIEND);
        registerCmd(FriendListRsp.class, ProtobufCmd.CLIENT_FRIEND_LIST_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(FriendApplyReq.class, ProtobufCmd.CLIENT_FRIEND_APPLY_REQ, ServerType.GATE, Module.PLAYER_FRIEND);
        registerCmd(FriendApplyRsp.class, ProtobufCmd.CLIENT_FRIEND_APPLY_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(FriendApplyNtf.class, ProtobufCmd.CLIENT_FRIEND_APPLY_NTF, ServerType.CLIENT, Module.CLIENT);
        // ????????????
        registerCmd(FriendApproveReq.class, ProtobufCmd.CLIENT_FRIEND_APPROVE_REQ, ServerType.GATE, Module.PLAYER_FRIEND);
        registerCmd(FriendApproveRsp.class, ProtobufCmd.CLIENT_FRIEND_APPROVE_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(FriendApproveNtf.class, ProtobufCmd.CLIENT_FRIEND_APPROVE_NTF, ServerType.CLIENT, Module.CLIENT);
        // ????????????
        registerCmd(RemoveFriendReq.class, ProtobufCmd.CLIENT_FRIEND_REMOVE_REQ, ServerType.GATE, Module.PLAYER_FRIEND);
        registerCmd(RemoveFriendRsp.class, ProtobufCmd.CLIENT_FRIEND_REMOVE_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(FriendSearchReq.class, ProtobufCmd.CLIENT_FRIEND_SEARCH_REQ, ServerType.GATE, Module.PLAYER_FRIEND);
        registerCmd(FriendSearchRsp.class, ProtobufCmd.CLIENT_FRIEND_SEARCH_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(FriendRecommendReq.class, ProtobufCmd.CLIENT_FRIEND_RECOMMEND_REQ, ServerType.GATE, Module.PLAYER_FRIEND);
        registerCmd(FriendRecommendRsp.class, ProtobufCmd.CLIENT_FRIEND_RECOMMEND_RSP, ServerType.GATE, Module.CLIENT);

        // gm??????
        registerCmd(GmCommandReq.class, ProtobufCmd.CLIENT_GM_COMMAND_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(GmCommandRsp.class, ProtobufCmd.CLIENT_GM_COMMAND_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(GmShutdownCmdReq.class, ProtobufCmd.CLIENT_GM_SHUTDOWN_CMD_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(GmShutdownCmdRsp.class, ProtobufCmd.CLIENT_GM_SHUTDOWN_CMD_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(ReadRoleReq.class, ProtobufCmd.CLIENT_READ_ROLE_REQ, ServerType.GATE, Module.PLAYER_GM);
        registerCmd(ReadRoleRsp.class, ProtobufCmd.CLIENT_READ_ROLE_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(WriteRoleReq.class, ProtobufCmd.CLIENT_WRITE_ROLE_REQ, ServerType.GATE, Module.PLAYER_GM);
        registerCmd(WriteRoleRsp.class, ProtobufCmd.CLIENT_WRITE_ROLE_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(ReadItemReq.class, ProtobufCmd.CLIENT_READ_ITEM_REQ, ServerType.GATE, Module.PLAYER_GM);
        registerCmd(ReadItemRsp.class, ProtobufCmd.CLIENT_READ_ITEM_RSP, ServerType.GATE, Module.CLIENT);

        // ??????-?????????????????????
        registerCmd(VerifiedQueueReq.class, ProtobufCmd.CLIENT_VERIFIED_QUEUE_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(VerifiedQueueRsp.class, ProtobufCmd.CLIENT_VERIFIED_QUEUE_RSP, ServerType.GATE, Module.CLIENT);

        // ??????-?????????????????????
        registerCmd(VerifyingQueueReq.class, ProtobufCmd.CLIENT_VERIFYING_QUEUE_REQ, ServerType.GATE, Module.GAME_HOME, true);
        registerCmd(VerifyingQueueRsp.class, ProtobufCmd.CLIENT_VERIFYING_QUEUE_RSP, ServerType.GATE, Module.CLIENT);

        // ?????????????????????????????????
        registerCmd(VerifyDequeueReq.class, ProtobufCmd.CLIENT_VERIFY_DEQUEUE_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(VerifyDequeueRsp.class, ProtobufCmd.CLIENT_VERIFY_DEQUEUE_RSP, ServerType.GATE, Module.CLIENT);

        // ?????????????????????????????????
        registerCmd(VerifyEnqueueReq.class, ProtobufCmd.CLIENT_VERIFY_ENQUEUE_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(VerifyEnqueueRsp.class, ProtobufCmd.CLIENT_VERIFY_ENQUEUE_RSP, ServerType.GATE, Module.CLIENT);

		// ?????????????????????
        registerCmd(VerifyUseCardReq.class, ProtobufCmd.CLIENT_VERIFY_USECARD_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(VerifyUseCardRsp.class, ProtobufCmd.CLIENT_VERIFY_USECARD_RSP, ServerType.GATE, Module.CLIENT);

        // ????????????
        registerCmd(VerifySpeedupReq.class, ProtobufCmd.CLIENT_VERIFY_SPEEDUP_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(VerifySpeedupRsp.class, ProtobufCmd.CLIENT_VERIFY_SPEEDUP_RSP, ServerType.GATE, Module.CLIENT);

        // ?????????????????????
        registerCmd(VerifyItemReq.class, ProtobufCmd.CLIENT_VERIFY_ITEM_REQ, ServerType.GATE, Module.GAME_HOME, true);
        registerCmd(VerifyItemRsp.class, ProtobufCmd.CLIENT_VERIFY_ITEM_RSP, ServerType.GATE, Module.CLIENT);

        // ?????????????????????
        registerCmd(VerifyLeaveReq.class, ProtobufCmd.CLIENT_VERIFY_LEAVE_REQ, ServerType.GATE, Module.GAME_HOME);
        registerCmd(VerifyLeaveRsp.class, ProtobufCmd.CLIENT_VERIFY_LEAVE_RSP, ServerType.GATE, Module.CLIENT);

        // ??????????????????
        registerCmd(ManufactureInfoReq.class, ProtobufCmd.CLIENT_MANUFACTURE_INFO_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(ManufactureInfoRsp.class, ProtobufCmd.CLIENT_MANUFACTURE_INFO_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ManufactureActionReq.class, ProtobufCmd.CLIENT_MANUFACTURE_ACTION_REQ, ServerType.GATE, Module.PLAYER_HOME, true);
        registerCmd(ManufactureActionRsp.class, ProtobufCmd.CLIENT_MANUFACTURE_ACTION_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ManufactureSpeedupReq.class, ProtobufCmd.CLIENT_MANUFACTURE_SPEEDUP_REQ, ServerType.GATE, Module.PLAYER_HOME, true);
        registerCmd(ManufactureSpeedupRsp.class, ProtobufCmd.CLIENT_MANUFACTURE_SPEEDUP_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????????????????
        registerCmd(ManufactureBatchPickupReq.class, ProtobufCmd.CLIENT_MANUFACTURE_BATCH_PICKUP_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(ManufactureBatchPickupRsp.class, ProtobufCmd.CLIENT_MANUFACTURE_BATCH_PICKUP_RSP, ServerType.GATE, Module.CLIENT);

        // ????????????
        registerCmd(ShowTableReq.class, ProtobufCmd.CLIENT_SHOW_TABLE_REQ, ServerType.GATE, Module.GAME_HOME);
        registerCmd(ShowTableRsp.class, ProtobufCmd.CLIENT_SHOW_TABLE_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(GetShowTableInfoReq.class, ProtobufCmd.CLIENT_GET_SHOW_TABLE_INFO_REQ, ServerType.GATE, Module.GAME_HOME);
        registerCmd(GetShowTableInfoRsp.class, ProtobufCmd.CLIENT_GET_SHOW_TABLE_INFO_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(SaveShowTableInfoReq.class, ProtobufCmd.CLIENT_SAVE_SHOW_TABLE_INFO_REQ, ServerType.GATE, Module.GAME_HOME);
        registerCmd(SaveShowTableInfoRsp.class, ProtobufCmd.CLIENT_SAVE_SHOW_TABLE_INFO_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ShowTablePutOnReq.class, ProtobufCmd.CLIENT_SHOW_TABLE_PUTON_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(ShowTablePutOnRsp.class, ProtobufCmd.CLIENT_SHOW_TABLE_PUTON_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(ShowTablePutDownReq.class, ProtobufCmd.CLIENT_SHOW_TABLE_PUTDOWN_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(ShowTablePutDownRsp.class, ProtobufCmd.CLIENT_SHOW_TABLE_PUTDOWN_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????????????????
        registerCmd(ShowTableAllPutDownReq.class, ProtobufCmd.CLIENT_SHOW_TABLE_ALL_PUTDOWN_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(ShowTableAllPutDownRsp.class, ProtobufCmd.CLIENT_SHOW_TABLE_ALL_PUTDOWN_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????????????????
        registerCmd(ShowTableDrawInfoReq.class, ProtobufCmd.CLIENT_SHOW_TABLE_DRAWINFO_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(ShowTableDrawInfoRsp.class, ProtobufCmd.CLIENT_SHOW_TABLE_DRAWINFO_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ShowTableDrawPrizeReq.class, ProtobufCmd.CLIENT_SHOW_TABLE_DRAWPRIZE_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(ShowTableDrawPrizeRsp.class, ProtobufCmd.CLIENT_SHOW_TABLE_DRAWPRIZE_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(ShowTableMoveReq.class, ProtobufCmd.CLIENT_SHOW_TABLE_MOVE_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(ShowTableMoveRsp.class, ProtobufCmd.CLIENT_SHOW_TABLE_MOVE_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????????????????
        registerCmd(ShowTableMoneyReq.class, ProtobufCmd.CLIENT_SHOW_TABLE_MONEY_REQ, ServerType.GATE, Module.PLAYER_HOME);
        // ???????????????????????????
        registerCmd(ShowTableMoneyNtf.class, ProtobufCmd.CLIENT_SHOW_TABLE_MONEY_NTF, ServerType.CLIENT, Module.CLIENT);
        // ????????????
        registerCmd(AntiqueComposeReq.class, ProtobufCmd.CLIENT_ANTIQUE_COMPOSE_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(AntiqueComposeRsp.class, ProtobufCmd.CLIENT_ANTIQUE_COMPOSE_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(ShowTableChangePositionReq.class, ProtobufCmd.CLIENT_SHOW_TABLE_CHANGE_POSITION_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(ShowTableChangePositionRsp.class, ProtobufCmd.CLIENT_SHOW_TABLE_CHANGE_POSITION_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(AntiqueSuitReq.class, ProtobufCmd.CLIENT_ANTIQUE_SUIT_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(AntiqueSuitRsp.class, ProtobufCmd.CLIENT_ANTIQUE_SUIT_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ShowTableSupportReq.class, ProtobufCmd.CLIENT_SHOW_TABLE_SUPPORT_REQ, ServerType.GATE, Module.GAME_HOME);
        registerCmd(ShowTableSupportRsp.class, ProtobufCmd.CLIENT_SHOW_TABLE_SUPPORT_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(ShowTableAutoPutDownNtf.class, ProtobufCmd.CLIENT_SHOW_TABLE_AUTO_PUTDOWN_NTF, ServerType.CLIENT, Module.CLIENT);

        // ????????????
        registerCmd(GuideInfoReq.class, ProtobufCmd.CLIENT_GUIDE_INFO_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(GuideInfoRsp.class, ProtobufCmd.CLIENT_GUIDE_INFO_RSP, ServerType.GATE, Module.CLIENT);
        registerCmd(UpdateGuideProcessReq.class, ProtobufCmd.CLIENT_GUIDE_PROCUPDATE_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(UpdateGuideProcessRsp.class, ProtobufCmd.CLIENT_GUIDE_PROCUPDATE_RSP, ServerType.GATE, Module.CLIENT);
        registerCmd(GetGuideRewardReq.class, ProtobufCmd.CLIENT_GUIDE_GETREWARD_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(GetGuideRewardRsp.class, ProtobufCmd.CLIENT_GUIDE_GETREWARD_RSP, ServerType.GATE, Module.CLIENT);

        // ????????????
        registerCmd(JoinSceneReq.class, ProtobufCmd.CLIENT_JOINSCENE_REQ, ServerType.GATE, Module.GAME_MULTI, true);
        registerCmd(JoinSceneRsp.class, ProtobufCmd.CLIENT_JOINSCENE_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(JoinSceneNtf.class, ProtobufCmd.CLIENT_JOINSCENE_NTF, ServerType.CLIENT, Module.CLIENT);

        // ??????????????????
        registerCmd(SceneMapNtf.class, ProtobufCmd.CLIENT_SCENE_MAP_NTF, ServerType.CLIENT, Module.CLIENT);

        // ????????????
        registerCmd(LeaveSceneReq.class, ProtobufCmd.CLIENT_LEAVESCENE_REQ, ServerType.GATE, Module.GAME_MULTI);
        registerCmd(LeaveSceneRsp.class, ProtobufCmd.CLIENT_LEAVESCENE_RSP, ServerType.GATE, Module.CLIENT);

        // ??????????????????
        registerCmd(LeaveSceneNtf.class, ProtobufCmd.CLIENT_LEAVE_SCENE_NTF, ServerType.CLIENT, Module.CLIENT);

        // ????????????
        registerCmd(SceneMovementReq.class, ProtobufCmd.CLIENT_SCENE_MOVEMENT_REQ, ServerType.GATE, Module.GAME_MULTI);
        registerCmd(SceneMovementRsp.class, ProtobufCmd.CLIENT_SCENE_MOVEMENT_RSP, ServerType.GATE, Module.CLIENT);

        // ??????????????????
        registerCmd(SceneMovementNtf.class, ProtobufCmd.CLIENT_SCENE_MOVEMENT_NTF, ServerType.CLIENT, Module.CLIENT);

        // ??????????????????
        registerCmd(SceneUseSkillReq.class, ProtobufCmd.CLIENT_SCENE_USESKILL_REQ, ServerType.GATE, Module.GAME_MULTI);
        registerCmd(SceneUseSkillRsp.class, ProtobufCmd.CLIENT_SCENE_USESKILL_RSP, ServerType.GATE, Module.CLIENT);

        // ????????????????????????
        registerCmd(SceneUseSkillNtf.class, ProtobufCmd.CLIENT_SCENE_USESKILL_NTF, ServerType.CLIENT, Module.CLIENT);

        // ?????????????????????????????????
        registerCmd(CheckSceneReq.class, ProtobufCmd.CLIENT_CHECKSCENE_REQ, ServerType.GATE, Module.GAME_MULTI);
        registerCmd(CheckSceneRsp.class, ProtobufCmd.CLIENT_CHECKSCENE_RSP, ServerType.GATE, Module.CLIENT);

        // ???????????????
        registerCmd(RankTopNReq.class, ProtobufCmd.CLIENT_RANK_TOPN_REQ, ServerType.GATE, Module.GLOBAL_RANK);
        // ???????????????????????????
        registerCmd(RoleRankCommonInfoNtf.class, ProtobufCmd.CLIENT_RANK_ROLE_COMMON_NTF, ServerType.GATE, Module.GLOBAL_RANK);
        // ?????????
        registerCmd(RankStockInfoNtf.class, ProtobufCmd.CLIENT_RANK_STOCK_INFO_NTF, ServerType.GATE, Module.GLOBAL_RANK);
        // ?????????????????????
        registerCmd(RankGuildInfoNtf.class, ProtobufCmd.CLIENT_RANK_GUILD_NTF, ServerType.GATE, Module.GLOBAL_RANK);

        // ???????????????????????????????????????
        registerCmd(RankSelfNearbyReq.class, ProtobufCmd.CLIENT_RANK_SELF_NEARBY_REQ, ServerType.GATE, Module.GLOBAL_RANK);
        registerCmd(RankSelfNearbyRsp.class, ProtobufCmd.CLIENT_RANK_SELF_NEARBY_RSP, ServerType.GATE, Module.CLIENT);

        // ????????????
        registerCmd(RobMapReq.class, ProtobufCmd.CLIENT_ROB_MAP_REQ, ServerType.GATE, Module.PLAYER_SINGLE, true);
        registerCmd(RobMapRsp.class, ProtobufCmd.CLIENT_ROB_MAP_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(RobMapNtf.class, ProtobufCmd.CLIENT_ROB_MAP_NTF, ServerType.CLIENT, Module.CLIENT);
        // ??????????????????
        registerCmd(RobUseSkillReq.class, ProtobufCmd.CLIENT_ROB_USE_SKILL_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(RobUseSkillRsp.class, ProtobufCmd.CLIENT_ROB_USE_SKILL_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(RobDistanceNtf.class, ProtobufCmd.CLIENT_ROB_DISTANCE_NTF, ServerType.CLIENT, Module.CLIENT);
        // ??????????????????
        registerCmd(RobMonsterOnCollisionReq.class, ProtobufCmd.CLIENT_ROB_MONSTER_ONCOLLISION_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(RobMonsterOnCollisionRsp.class, ProtobufCmd.CLIENT_ROB_MONSTER_ONCOLLISION_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(RobNewTreasureNtf.class, ProtobufCmd.CLIENT_ROB_NEW_TREASURE_NTF, ServerType.CLIENT, Module.CLIENT);
        // ????????????
        registerCmd(RobBombMonsterReq.class, ProtobufCmd.CLIENT_ROB_BOMB_MONSTER_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(RobBombMonsterRsp.class, ProtobufCmd.CLIENT_ROB_BOMB_MONSTER_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????????????????
        registerCmd(RobCompleteGuideReq.class, ProtobufCmd.CLIENT_ROB_COMPLETE_GUIDE_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(RobCompleteGuideRsp.class, ProtobufCmd.CLIENT_ROB_COMPLETE_GUIDE_RSP, ServerType.GATE, Module.CLIENT);
        // ???????????????????????????????????? ????????????????????????
        registerCmd(RobLookItemReq.class, ProtobufCmd.CLIENT_ROB_LOOK_ITEM_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(RobLookItemRsp.class, ProtobufCmd.CLIENT_ROB_LOOK_ITEM_RSP, ServerType.GATE, Module.CLIENT);
        // ??????
        registerCmd(OutsideReq.class, ProtobufCmd.CLIENT_OUTSIDE_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(OutsideRsp.class, ProtobufCmd.CLIENT_OUTSIDE_RSP, ServerType.GATE, Module.CLIENT);
        registerCmd(OutsideGuideReq.class, ProtobufCmd.CLIENT_OUTSIDE_GUIDE_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(OutsideGuideRsp.class, ProtobufCmd.CLIENT_OUTSIDE_GUIDE_RSP, ServerType.GATE, Module.CLIENT);
        registerCmd(OutsideBatchReq.class, ProtobufCmd.CLIENT_OUTSIDE_BATCH_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(OutsideBatchRsp.class, ProtobufCmd.CLIENT_OUTSIDE_BATCH_RSP, ServerType.GATE, Module.CLIENT);

        // ????????????
        registerCmd(CollectionListReq.class, ProtobufCmd.CLIENT_COLLECTION_LIST_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(CollectionListRsp.class, ProtobufCmd.CLIENT_COLLECTION_LIST_RSP, ServerType.GATE, Module.CLIENT);
        registerCmd(CollectionUpdateNtf.class, ProtobufCmd.CLIENT_COLLECTION_UPDATE_NTF, ServerType.CLIENT, Module.CLIENT);
        // ??????????????????
        registerCmd(CollectionExchangeRewardReq.class, ProtobufCmd.CLIENT_COLLECTION_EXCHANGE_REWARD_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(CollectionExchangeRewardRsp.class, ProtobufCmd.CLIENT_COLLECTION_EXCHANGE_REWARD_RSP, ServerType.GATE, Module.CLIENT);

        // ??????????????????
        registerCmd(ObstaclesListReq.class, ProtobufCmd.CLIENT_OBSTACLES_LIST_REQ, ServerType.GATE, Module.GAME_HOME);
        registerCmd(ObstaclesListRsp.class, ProtobufCmd.CLIENT_OBSTACLES_LIST_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ObstaclesOpenupReq.class, ProtobufCmd.CLIENT_OBSTACLES_OPENUP_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(ObstaclesOpenupRsp.class, ProtobufCmd.CLIENT_OBSTACLES_OPENUP_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(MallListReq.class, ProtobufCmd.CLIENT_MALL_LIST_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(MallListRsp.class, ProtobufCmd.CLIENT_MALL_LIST_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(MallBuyReq.class, ProtobufCmd.CLIENT_MALL_BUY_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(MallBuyRsp.class, ProtobufCmd.CLIENT_MALL_BUY_RSP, ServerType.GATE, Module.CLIENT);

        // -------------------????????????------------------------------------------------------------------
        // ????????????
        registerCmd(CreateGuildReq.class, ProtobufCmd.CLIENT_GUILD_CREATE_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(CreateGuildRsp.class, ProtobufCmd.CLIENT_GUILD_CREATE_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(GuildListReq.class, ProtobufCmd.CLIENT_GUILD_LIST_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildListRsp.class, ProtobufCmd.CLIENT_GUILD_LIST_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(GuildModifySummaryReq.class, ProtobufCmd.CLIENT_GUILD_MODIFYSUMMARY_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildModifySummaryRsp.class, ProtobufCmd.CLIENT_GUILD_MODIFYSUMMARY_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(GuildApplyReq.class, ProtobufCmd.CLIENT_GUILD_APPLY_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildApplyRsp.class, ProtobufCmd.CLIENT_GUILD_APPLY_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(GuildApplyNtf.class, ProtobufCmd.CLIENT_GUILD_APPLY_NTF, ServerType.CLIENT, Module.CLIENT);
        // ????????????
        registerCmd(GuildApproveReq.class, ProtobufCmd.CLIENT_GUILD_APPROVE_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildApproveRsp.class, ProtobufCmd.CLIENT_GUILD_APPROVE_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(GuildApproveNtf.class, ProtobufCmd.CLIENT_GUILD_APPROVE_NTF, ServerType.CLIENT, Module.CLIENT);
        // ????????????
        registerCmd(GuildApplyListReq.class, ProtobufCmd.CLIENT_GUILD_APPLYLIST_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildApplyListRsp.class, ProtobufCmd.CLIENT_GUILD_APPLYLIST_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(GuildMemberListReq.class, ProtobufCmd.CLIENT_GUILD_MEMBERLIST_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildMemberListRsp.class, ProtobufCmd.CLIENT_GUILD_MEMBERLIST_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(QuitGuildReq.class, ProtobufCmd.CLIENT_GUILD_QUIT_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(QuitGuildRsp.class, ProtobufCmd.CLIENT_GUILD_QUIT_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(GuildQuitNtf.class, ProtobufCmd.CLIENT_GUILD_QUIT_NTF, ServerType.CLIENT, Module.CLIENT);
        // ????????????
        registerCmd(GuildKickReq.class, ProtobufCmd.CLIENT_GUILD_KICK_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildKickRsp.class, ProtobufCmd.CLIENT_GUILD_KICK_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(GuildAdjustPostReq.class, ProtobufCmd.CLIENT_GUILD_ADJUSTPOST_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildAdjustPostRsp.class, ProtobufCmd.CLIENT_GUILD_ADJUSTPOST_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(GuildSearchReq.class, ProtobufCmd.CLIENT_GUILD_SEARCH_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildSearchRsp.class, ProtobufCmd.CLIENT_GUILD_SEARCH_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(GuildAttrClientNtf.class, ProtobufCmd.CLIENT_GUILD_ATTR_CLIENT_NTF, ServerType.CLIENT, Module.CLIENT);
        // ????????????
        registerCmd(ChangeGuildNameReq.class, ProtobufCmd.CLIENT_CHANGE_GUILD_NAME_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(ChangeGuildNameNtf.class, ProtobufCmd.CLIENT_CHANGE_GUILD_NAME_NTF, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(SignUpGuildBattleReq.class, ProtobufCmd.CLIENT_SIGNUP_GUILD_BATTLE_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(SignUpGuildBattleRsp.class, ProtobufCmd.CLIENT_SIGNUP_GUILD_BATTLE_RSP, ServerType.GATE, Module.CLIENT);

        // ----------------------------------------------------------------------------------------------------
        // ?????????????????????
        registerCmd(TradeTopNReq.class, ProtobufCmd.CLIENT_TRADE_TOPN_REQ, ServerType.GATE, Module.GLOBAL_RANK);
        registerCmd(TradeTopNRsp.class, ProtobufCmd.CLIENT_TRADE_TOPN_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(TradeEnqueueReq.class, ProtobufCmd.CLIENT_TRADE_ENQUEUE_REQ, ServerType.GATE, Module.GLOBAL_RANK);
        registerCmd(TradeEnqueueRsp.class, ProtobufCmd.CLIENT_TRADE_ENQUEUE_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(TradeDequeueReq.class, ProtobufCmd.CLIENT_TRADE_DEQUEUE_REQ, ServerType.GATE, Module.GLOBAL_RANK);
        registerCmd(TradeDequeueRsp.class, ProtobufCmd.CLIENT_TRADE_DEQUEUE_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        //registerCmd(TradeUseReq.class, ProtobufCmd.CLIENT_TRADE_USE_REQ, ServerType.GATE, Module.GLOBAL_RANK, true);
        //registerCmd(TradeUseRsp.class, ProtobufCmd.CLIENT_TRADE_USE_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????????????????
        registerCmd(TradeRoleReq.class, ProtobufCmd.CLIENT_TRADE_ROLE_REQ, ServerType.GATE, Module.GLOBAL_RANK);
        registerCmd(TradeRoleRsp.class, ProtobufCmd.CLIENT_TRADE_ROLE_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(StockListReq.class, ProtobufCmd.CLIENT_STOCK_LIST_REQ, ServerType.GATE, Module.GLOBAL_RANK);
        registerCmd(StockListRsp.class, ProtobufCmd.CLIENT_STOCK_LIST_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????????????????????????????
        registerCmd(TradeHistoryReq.class, ProtobufCmd.CLIENT_TRADE_HISTORY_REQ, ServerType.GATE, Module.GLOBAL_RANK);
        registerCmd(TradeHistoryRsp.class, ProtobufCmd.CLIENT_TRADE_HISTORY_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(TradeUseNtf.class, ProtobufCmd.CLIENT_TRADE_USE_NTF, ServerType.CLIENT, Module.CLIENT);
        // ??????????????????
        registerCmd(TradeCloseReq.class, ProtobufCmd.CLIENT_TRADE_CLOSE_REQ, ServerType.GATE, Module.GLOBAL_RANK);
        registerCmd(TradeCloseRsp.class, ProtobufCmd.CLIENT_TRADE_CLOSE_RSP, ServerType.GATE, Module.CLIENT);

        // ---------------------------------------------------------------------------------------------
        // ????????????
        registerCmd(TaskListReq.class, ProtobufCmd.CLIENT_TASK_LIST_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(TaskListRsp.class, ProtobufCmd.CLIENT_TASK_LIST_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????????????????
        registerCmd(TaskStateListReq.class, ProtobufCmd.CLIENT_TASK_STATE_LIST_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(TaskStateListRsp.class, ProtobufCmd.CLIENT_TASK_STATE_LIST_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(TaskUpdateNtf.class, ProtobufCmd.CLIENT_TASK_UPDATE_NTF, ServerType.CLIENT, Module.CLIENT);
        // ??????????????????
        registerCmd(TaskRewardReq.class, ProtobufCmd.CLIENT_TASK_REWARD_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(TaskRewardRsp.class, ProtobufCmd.CLIENT_TASK_REWARD_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(TaskAcceptReq.class, ProtobufCmd.CLIENT_TASK_ACCEPT_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(TaskAcceptRsp.class, ProtobufCmd.CLIENT_TASK_ACCEPT_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(TaskRemoveReq.class, ProtobufCmd.CLIENT_TASK_REMOVE_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(TaskRemoveRsp.class, ProtobufCmd.CLIENT_TASK_REMOVE_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(TaskFirstReq.class, ProtobufCmd.CLIENT_TASK_FIRST_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(TaskFirstRsp.class, ProtobufCmd.CLIENT_TASK_FIRST_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(TaskRefreshReq.class, ProtobufCmd.CLIENT_TASK_REFRESH_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(TaskRefreshRsp.class, ProtobufCmd.CLIENT_TASK_REFRESH_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(TaskPointReq.class, ProtobufCmd.CLIENT_TASK_POINT_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(TaskPointRsp.class, ProtobufCmd.CLIENT_TASK_POINT_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????????????????
        registerCmd(TaskFinishNtf.class, ProtobufCmd.CLIENT_TASK_FINISH_NTF, ServerType.CLIENT, Module.CLIENT);

        // ????????????????????????
        registerCmd(SummonInfoReq.class, ProtobufCmd.CLIENT_SUMMON_INFO_REQ, ServerType.GATE, Module.PLAYER_HOME, true);
        registerCmd(SummonInfoRsp.class, ProtobufCmd.CLIENT_SUMMON_INFO_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(SummonReq.class, ProtobufCmd.CLIENT_SUMMON_REQ, ServerType.GATE, Module.PLAYER_HOME, true);
        registerCmd(SummonRsp.class, ProtobufCmd.CLIENT_SUMMON_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(SummonRetainReq.class, ProtobufCmd.CLIENT_SUMMON_RETAIN_REQ, ServerType.GATE, Module.PLAYER_HOME, true);
        registerCmd(SummonRetainRsp.class, ProtobufCmd.CLIENT_SUMMON_RETAIN_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(SummonSendReq.class, ProtobufCmd.CLIENT_SUMMON_SEND_REQ, ServerType.GATE, Module.PLAYER_HOME, true);
        registerCmd(SummonSendRsp.class, ProtobufCmd.CLIENT_SUMMON_SEND_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????????????????
        registerCmd(SummonMailNtf.class, ProtobufCmd.CLIENT_SUMMON_MAIL_NTF, ServerType.CLIENT, Module.CLIENT);
        // ????????????????????????
        registerCmd(SummonMailRewardReq.class, ProtobufCmd.CLIENT_SUMMON_MAIL_REWARD_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(SummonMailRewardRsp.class, ProtobufCmd.CLIENT_SUMMON_MAIL_REWARD_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????????????????
        registerCmd(SummonAllMailRewardReq.class, ProtobufCmd.CLIENT_SUMMON_ALL_MAIL_REWARD_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(SummonAllMailRewardRsp.class, ProtobufCmd.CLIENT_SUMMON_ALL_MAIL_REWARD_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(SummonMailRefreshReq.class, ProtobufCmd.CLIENT_SUMMON_MAIL_REFRESH_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(SummonMailRefreshRsp.class, ProtobufCmd.CLIENT_SUMMON_MAIL_REFRESH_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????????????????
        registerCmd(SummonMailFirstReq.class, ProtobufCmd.CLIENT_SUMMON_MAIL_FIRST_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(SummonMailFirstRsp.class, ProtobufCmd.CLIENT_SUMMON_MAIL_FIRST_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(SummonInvestReq.class, ProtobufCmd.CLIENT_SUMMON_INVEST_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(SummonInvestRsp.class, ProtobufCmd.CLIENT_SUMMON_INVEST_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????????????????
        registerCmd(SummonNewMailReq.class, ProtobufCmd.CLIENT_SUMMON_NEW_MAIL_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(SummonNewMailRsp.class, ProtobufCmd.CLIENT_SUMMON_NEW_MAIL_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????????????????
        registerCmd(SummonPickupInvestRewardReq.class, ProtobufCmd.CLIENT_SUMMON_PICKUP_INVEST_REWARD_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(SummonPickupInvestRewardRsp.class, ProtobufCmd.CLIENT_SUMMON_PICKUP_INVEST_REWARD_RSP, ServerType.GATE, Module.CLIENT);
        //??????????????????
        registerCmd(SummonFastMailReq.class, ProtobufCmd.CLIENT_SUMMON_FAST_MAIL_REQ, ServerType.GATE, Module.PLAYER_HOME);
        registerCmd(SummonFastMailRsp.class, ProtobufCmd.CLIENT_SUMMON_FAST_MAIL_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????????????????
        registerCmd(ParkInfoReq.class, ProtobufCmd.CLIENT_PARK_INFO_REQ, ServerType.GATE, Module.GAME_PARK);
        registerCmd(ParkInfoRsp.class, ProtobufCmd.CLIENT_PARK_INFO_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ParkPlaceCropsReq.class, ProtobufCmd.CLIENT_PARK_PLACE_CROPS_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkPlaceCropsRsp.class, ProtobufCmd.CLIENT_PARK_PLACE_CROPS_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ParkPlacePlantReq.class, ProtobufCmd.CLIENT_PARK_PLACE_PLANT_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkPlacePlantRsp.class, ProtobufCmd.CLIENT_PARK_PLACE_PLANT_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ParkPlaceTreeReq.class, ProtobufCmd.CLIENT_PARK_PLACE_TREE_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkPlaceTreeRsp.class, ProtobufCmd.CLIENT_PARK_PLACE_TREE_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????????????????
        registerCmd(ParkPlaceAnimalReq.class, ProtobufCmd.CLIENT_PARK_PLACE_ANIMAL_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkPlaceAnimalRsp.class, ProtobufCmd.CLIENT_PARK_PLACE_ANIMAL_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????????????????
        registerCmd(ZooPlaceAnimalReq.class, ProtobufCmd.CLIENT_ZOO_PLACE_ANIMAL_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ZooPlaceAnimalRsp.class, ProtobufCmd.CLIENT_ZOO_PLACE_ANIMAL_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ParkHarvestCropsReq.class, ProtobufCmd.CLIENT_PARK_HARVEST_CROPS_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkHarvestCropsRsp.class, ProtobufCmd.CLIENT_PARK_HARVEST_CROPS_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ParkHarvestPlantReq.class, ProtobufCmd.CLIENT_PARK_HARVEST_PLANT_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkHarvestPlantRsp.class, ProtobufCmd.CLIENT_PARK_HARVEST_PLANT_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ParkHarvestTreeReq.class, ProtobufCmd.CLIENT_PARK_HARVEST_TREE_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkHarvestTreeRsp.class, ProtobufCmd.CLIENT_PARK_HARVEST_TREE_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ParkHarvestAnimalReq.class, ProtobufCmd.CLIENT_PARK_HARVEST_ANIMAL_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkHarvestAnimalRsp.class, ProtobufCmd.CLIENT_PARK_HARVEST_ANIMAL_RSP, ServerType.GATE, Module.CLIENT);
        // ???????????????????????????
        registerCmd(ParkCellNtf.class, ProtobufCmd.CLIENT_PARK_CELL_NTF, ServerType.CLIENT, Module.CLIENT);
        // ???????????????????????????
        registerCmd(ParkAnimalNtf.class, ProtobufCmd.CLIENT_PARK_ANIMAL_NTF, ServerType.CLIENT, Module.CLIENT);
        // ?????????????????????????????????
        registerCmd(ParkAnimalMatureNtf.class, ProtobufCmd.CLIENT_PARK_ANIMAL_MATURE_NTF, ServerType.CLIENT, Module.CLIENT);

        // ???????????????
        registerCmd(ParkPlaceFishReq.class, ProtobufCmd.CLIENT_PARK_PLACE_FISH_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkPlaceFishRsp.class, ProtobufCmd.CLIENT_PARK_PLACE_FISH_RSP, ServerType.GATE, Module.CLIENT);
        // ???????????????
        registerCmd(ParkHarvestFishReq.class, ProtobufCmd.CLIENT_PARK_HARVEST_FISH_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkHarvestFishRsp.class, ProtobufCmd.CLIENT_PARK_HARVEST_FISH_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????????????????????????????
        registerCmd(ParkFishNtf.class, ProtobufCmd.CLIENT_PARK_FISH_NTF, ServerType.CLIENT, Module.CLIENT);
        // ??????????????????
        registerCmd(ParkClearWitherPlantReq.class, ProtobufCmd.CLIENT_PARK_CLEAR_WITHER_PLANT_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkClearWitherPlantRsp.class, ProtobufCmd.CLIENT_PARK_CLEAR_WITHER_PLANT_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(ParkClearWitherAnimalReq.class, ProtobufCmd.CLIENT_PARK_CLEAR_WITHER_ANIMAL_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkClearWitherAnimalRsp.class, ProtobufCmd.CLIENT_PARK_CLEAR_WITHER_ANIMAL_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(ParkDrawHoneyReq.class, ProtobufCmd.CLIENT_PARK_DRAW_HONEY_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkDrawHoneyRsp.class, ProtobufCmd.CLIENT_PARK_DRAW_HONEY_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????????????????
        registerCmd(ParkAnimalFeedReq.class, ProtobufCmd.CLIENT_PARK_ANIMAL_FEED_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkAnimalFeedRsp.class, ProtobufCmd.CLIENT_PARK_ANIMAL_FEED_RSP, ServerType.GATE, Module.CLIENT);
        // ??????
        registerCmd(ParkDrawPrizeReq.class, ProtobufCmd.CLIENT_PARK_DRAW_PRIZE_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkDrawPrizeRsp.class, ProtobufCmd.CLIENT_PARK_DRAW_PRIZE_RSP, ServerType.GATE, Module.CLIENT);
        // ???????????????????????????
        registerCmd(ParkAnimalAutoLeaveNtf.class, ProtobufCmd.CLIENT_PARK_ANIMAL_AUTO_LEAVE_NTF, ServerType.CLIENT, Module.CLIENT);
        //???????????????????????????
        registerCmd(ParkAnimalSpeedupReq.class, ProtobufCmd.CLIENT_PARK_ANIMAL_SPEEDUP_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkAnimalSpeedupRsp.class, ProtobufCmd.CLIENT_PARK_ANIMAL_SPEEDUP_RSP, ServerType.GATE, Module.CLIENT);
        //????????????????????????
        registerCmd(ParkFishSpeedupReq.class, ProtobufCmd.CLIENT_PARK_FISH_SPEEDUP_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkFishSpeedupRsp.class, ProtobufCmd.CLIENT_PARK_FISH_SPEEDUP_RSP, ServerType.GATE, Module.CLIENT);
        //??????????????????/??????/??????
        registerCmd(ParkPlantSpeedupReq.class, ProtobufCmd.CLIENT_PARK_PLANT_SPEEDUP_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ParkPlantSpeedupRsp.class, ProtobufCmd.CLIENT_PARK_PLANT_SPEEDUP_RSP, ServerType.GATE, Module.CLIENT);
        // -------------------------------------------------------------------------------------------
        // ???????????????
        registerCmd(StartMeetEggReq.class, ProtobufCmd.CLIENT_START_MEET_EGG_REQ, ServerType.GATE, Module.PLAYER_SINGLE, true);
        registerCmd(StartMeetEggRsp.class, ProtobufCmd.CLIENT_START_MEET_EGG_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????????????????
        registerCmd(MeetEggDropNtf.class, ProtobufCmd.CLIENT_MEET_EGG_DROP_NTF, ServerType.CLIENT, Module.CLIENT);
        // ????????????????????????
        registerCmd(ChangeMeetXReq.class, ProtobufCmd.CLIENT_CHANGE_MEET_X_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ChangeMeetXRsp.class, ProtobufCmd.CLIENT_CHANGE_MEET_X_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(MeetDropReq.class, ProtobufCmd.CLIENT_MEET_DROP_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(MeetDropRsp.class, ProtobufCmd.CLIENT_MEET_DROP_RSP, ServerType.GATE, Module.CLIENT);
        // ???????????????
        registerCmd(ExitMeetEggReq.class, ProtobufCmd.CLIENT_EXIT_MEET_EGG_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(ExitMeetEggRsp.class, ProtobufCmd.CLIENT_EXIT_MEET_EGG_RSP, ServerType.GATE, Module.CLIENT);
        // ???????????????
        registerCmd(MeetEggStopNtf.class, ProtobufCmd.CLIENT_MEET_EGG_STOP_NTF, ServerType.CLIENT, Module.CLIENT);
        // ????????????
        registerCmd(MeetEggPauseStartReq.class, ProtobufCmd.CLIENT_MEET_EGG_PAUSE_START_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(MeetEggPauseStartRsp.class, ProtobufCmd.CLIENT_MEET_EGG_PAUSE_START_RSP, ServerType.GATE, Module.CLIENT);

        // -------------------------------------------------------------------------------------------
        // ??????
        registerCmd(ChatSendReq.class, ProtobufCmd.CLIENT_CHAT_SEND_REQ, ServerType.GATE, Module.CHAT);
        registerCmd(ChatSendRsp.class, ProtobufCmd.CLIENT_CHAT_SEND_RSP, ServerType.GATE, Module.CHAT);
        // ????????????
        registerCmd(ChatSendNtf.class, ProtobufCmd.CLIENT_CHAT_SEND_NTF, ServerType.CLIENT, Module.CLIENT);
        
        // -------------------------------------------------------------------------------------------
        // ????????????????????????
        registerCmd(BattleBuildListReq.class, ProtobufCmd.CLIENT_BATTLE_BUILD_LIST_REQ, ServerType.GATE, Module.GLOBAL_GUILD_BATTLE);
        registerCmd(BattleBuildListRsp.class, ProtobufCmd.CLIENT_BATTLE_BUILD_LIST_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(HoldBattleBuildReq.class, ProtobufCmd.CLIENT_HOLD_BATTLE_BUILD_REQ, ServerType.GATE, Module.GLOBAL_GUILD_BATTLE);
        registerCmd(HoldBattleBuildRsp.class, ProtobufCmd.CLIENT_HOLD_BATTLE_BUILD_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(CaptureBattleBuildReq.class, ProtobufCmd.CLIENT_CAPTURE_BATTLE_BUILD_REQ, ServerType.GATE, Module.GLOBAL_GUILD_BATTLE);
        registerCmd(CaptureBattleBuildRsp.class, ProtobufCmd.CLIENT_CAPTURE_BATTLE_BUILD_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????????????????
        registerCmd(CaptureBattleBuildNtf.class, ProtobufCmd.CLIENT_CAPTURE_BATTLE_BUILD_NTF, ServerType.GATE, Module.CLIENT);
        // ??????????????????????????????
        registerCmd(GuildBattleMatchSucessNtf.class, ProtobufCmd.CLIENT_GUILD_BATTLE_MATCH_SUCESS_NTF, ServerType.GATE, Module.CLIENT);
        // ??????????????????????????????
        registerCmd(ExitBattleBuildListReq.class, ProtobufCmd.CLIENT_EXIT_BATTLE_BUILD_LIST_REQ, ServerType.GATE, Module.GLOBAL_GUILD_BATTLE);
        registerCmd(ExitBattleBuildListRsp.class, ProtobufCmd.CLIENT_EXIT_BATTLE_BUILD_LIST_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????????????????
        registerCmd(BattleHoldScoreNtf.class, ProtobufCmd.CLIENT_BATTLE_HOLD_SCORE_NTF, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(BattleOverNtf.class, ProtobufCmd.CLIENT_BATTLE_OVER_NTF, ServerType.GATE, Module.CLIENT);
        // ?????????????????????
        registerCmd(StartBattleMeetEggReq.class, ProtobufCmd.CLIENT_START_BATTLE_MEET_EGG_REQ, ServerType.GATE, Module.GLOBAL_GUILD_BATTLE);
        registerCmd(StartBattleMeetEggNtf.class, ProtobufCmd.CLIENT_START_BATTLE_MEET_EGG_NTF, ServerType.GATE, Module.CLIENT);
        // ??????????????????????????????
        registerCmd(BattleMeetEggDropNtf.class, ProtobufCmd.CLIENT_BATTLE_MEET_EGG_DROP_NTF, ServerType.GATE, Module.CLIENT);
        // ????????????????????????
        registerCmd(BattleChangeMeetXReq.class, ProtobufCmd.CLIENT_BATTLE_CHANGE_MEET_X_REQ, ServerType.GATE, Module.GLOBAL_GUILD_BATTLE);
        registerCmd(BattleChangeMeetXRsp.class, ProtobufCmd.CLIENT_BATTLE_CHANGE_MEET_X_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(BattleMeetDropReq.class, ProtobufCmd.CLIENT_BATTLE_MEET_DROP_REQ, ServerType.GATE, Module.GLOBAL_GUILD_BATTLE);
        registerCmd(BattleMeetDropRsp.class, ProtobufCmd.CLIENT_BATTLE_MEET_DROP_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(BattleMeetScoreNtf.class, ProtobufCmd.CLIENT_BATTLE_MEET_SCORE_NTF, ServerType.GATE, Module.CLIENT);
        // ???????????????
        registerCmd(ExitBattleMeetEggReq.class, ProtobufCmd.CLIENT_EXIT_BATTLE_MEET_EGG_REQ, ServerType.GATE, Module.GLOBAL_GUILD_BATTLE);
        registerCmd(ExitBattleMeetEggRsp.class, ProtobufCmd.CLIENT_EXIT_BATTLE_MEET_EGG_RSP, ServerType.GATE, Module.CLIENT);
        // ???????????????
        registerCmd(BattleMeetEggStopNtf.class, ProtobufCmd.CLIENT_BATTLE_MEET_EGG_STOP_NTF, ServerType.GATE, Module.CLIENT);
        // ?????????????????????????????????
        registerCmd(BattleBuildUpdateNtf.class, ProtobufCmd.CLIENT_BATTLE_BUILD_UPDATE_NTF, ServerType.GATE, Module.CLIENT);
        
        //--------------------------------------------------------------------------------------------------------
    	// ????????????
    	// ????????????????????????
        registerCmd(GuildTaskListReq.class, ProtobufCmd.CLIENT_GUILD_TASK_LIST_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildTaskListRsp.class, ProtobufCmd.CLIENT_GUILD_TASK_LIST_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(GuildTaskAcceptReq.class, ProtobufCmd.CLIENT_GUILD_TASK_ACCEPT_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildTaskAcceptRsp.class, ProtobufCmd.CLIENT_GUILD_TASK_ACCEPT_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????????????????
        registerCmd(GuildTaskUpdateNtf.class, ProtobufCmd.CLIENT_GUILD_TASK_UPDATE_NTF, ServerType.GATE, Module.CLIENT);
        // ??????????????????????????????
        registerCmd(GuildTaskRemoveReq.class, ProtobufCmd.CLIENT_GUILD_TASK_REMOVE_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildTaskRemoveRsp.class, ProtobufCmd.CLIENT_GUILD_TASK_REMOVE_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(GuildTaskSpeedUpReq.class, ProtobufCmd.CLIENT_GUILD_TASK_SPEEDUP_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildTaskSpeedUpRsp.class, ProtobufCmd.CLIENT_GUILD_TASK_SPEEDUP_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(GuildTaskRewardReq.class, ProtobufCmd.CLIENT_GUILD_TASK_REWARD_REQ, ServerType.GATE, Module.GLOBAL_GUILD);
        registerCmd(GuildTaskRewardRsp.class, ProtobufCmd.CLIENT_GUILD_TASK_REWARD_RSP, ServerType.GATE, Module.CLIENT);
        //--------------------------------------------------------------------------------------------------------
    	// ??????
    	// ????????????????????????
        registerCmd(BookAllTypeReq.class, ProtobufCmd.CLIENT_BOOK_ALL_TYPE_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(BookAllTypeRsp.class, ProtobufCmd.CLIENT_BOOK_ALL_TYPE_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????????????????????????????
        registerCmd(BookInfoReq.class, ProtobufCmd.CLIENT_BOOK_INFO_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(BookInfoRsp.class, ProtobufCmd.CLIENT_BOOK_INFO_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????
        registerCmd(BookUpdateNtf.class, ProtobufCmd.CLIENT_BOOK_UPDATE_NTF, ServerType.GATE, Module.CLIENT);
        // ??????????????????????????????
        registerCmd(BookRewardReq.class, ProtobufCmd.CLIENT_BOOK_REWARD_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(BookRewardRsp.class, ProtobufCmd.CLIENT_BOOK_REWARD_RSP, ServerType.GATE, Module.CLIENT);
        //  ????????????
        registerCmd(BookTurnPagesReq.class, ProtobufCmd.CLIENT_BOOK_TURN_PAGES_REQ, ServerType.GATE, Module.PLAYER_BASIC);
        registerCmd(BookTurnPagesRsp.class, ProtobufCmd.CLIENT_BOOK_TURN_PAGES_RSP, ServerType.GATE, Module.CLIENT);
        //--------------------------------------------------------------------------------------------------------
    	// ??????
    	// ??????npc??????
        //registerCmd(NpcListReq.class, ProtobufCmd.CLIENT_NPC_LIST_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        //registerCmd(NpcListRsp.class, ProtobufCmd.CLIENT_NPC_LIST_RSP, ServerType.GATE, Module.CLIENT);
        // ??????npc
        registerCmd(NpcVisitReq.class, ProtobufCmd.CLIENT_NPC_VISIT_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(NpcVisitRsp.class, ProtobufCmd.CLIENT_NPC_VISIT_RSP, ServerType.GATE, Module.CLIENT);
        // npc????????????
        //registerCmd(NpcTriggerEventReq.class, ProtobufCmd.CLIENT_NPC_TRIGGER_EVENT_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        //registerCmd(NpcTriggerEventRsp.class, ProtobufCmd.CLIENT_NPC_TRIGGER_EVENT_RSP, ServerType.GATE, Module.CLIENT);
        // ???????????????????????????????????????
        //registerCmd(NpcOnPoetryInfoReq.class, ProtobufCmd.CLIENT_NPC_ON_POETRY_INFO_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        //registerCmd(NpcOnPoetryInfoRsp.class, ProtobufCmd.CLIENT_NPC_ON_POETRY_INFO_RSP, ServerType.GATE, Module.CLIENT);
        // ??????????????????????????????
        registerCmd(NpcOnPoetryReq.class, ProtobufCmd.CLIENT_NPC_ON_POETRY_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(NpcOnPoetryRsp.class, ProtobufCmd.CLIENT_NPC_ON_POETRY_RSP, ServerType.GATE, Module.CLIENT);
        // ?????????
        registerCmd(NpcWantThingReq.class, ProtobufCmd.CLIENT_NPC_WANT_THING_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(NpcWantThingRsp.class, ProtobufCmd.CLIENT_NPC_WANT_THING_RSP, ServerType.GATE, Module.CLIENT);
        // ????????????
        registerCmd(NpcRaceHorsesReq.class, ProtobufCmd.CLIENT_NPC_RACE_HORSES_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(NpcRaceHorsesRsp.class, ProtobufCmd.CLIENT_NPC_RACE_HORSES_RSP, ServerType.GATE, Module.CLIENT);
        // ???????????????
        registerCmd(NpcRobberyReq.class, ProtobufCmd.CLIENT_NPC_ROBBERY_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(NpcRobberyRsp.class, ProtobufCmd.CLIENT_NPC_ROBBERY_RSP, ServerType.GATE, Module.CLIENT);
        // ??????NPC
        registerCmd(NpcPraiseReq.class, ProtobufCmd.CLIENT_NPC_PRAISE_REQ, ServerType.GATE, Module.PLAYER_SINGLE);
        registerCmd(NpcPraiseRsp.class, ProtobufCmd.CLIENT_NPC_PRAISE_RSP, ServerType.GATE, Module.CLIENT);

        registerCmd(WxPrePayReq.class, ProtobufCmd.WX_PRE_PAY_REQ, ServerType.GATE, Module.PLAYER_INIT);
        registerCmd(WxPrePayRsp.class, ProtobufCmd.WX_PRE_PAY_RSP, ServerType.CLIENT, Module.CLIENT);

        registerCmd(WxPayQueryReq.class, ProtobufCmd.WX_PAY_QUERY_REQ, ServerType.GATE, Module.PLAYER_INIT);
        registerCmd(WxPayQueryRsp.class, ProtobufCmd.WX_PAY_QUERY_RSP, ServerType.CLIENT, Module.CLIENT);

        registerCmd(AliPayPreReq.class, ProtobufCmd.ALI_PAY_PRE_REQ, ServerType.GATE, Module.PLAYER_INIT);
        registerCmd(AliPayPreRsp.class, ProtobufCmd.ALI_PAY_PRE_RSP, ServerType.CLIENT, Module.CLIENT);

        registerCmd(AliPayQueryReq.class, ProtobufCmd.ALI_PAY_QUERY_REQ, ServerType.GATE, Module.PLAYER_INIT);
        registerCmd(AliPayQueryRsp.class, ProtobufCmd.ALI_PAY_QUERY_RSP, ServerType.CLIENT, Module.CLIENT);
    }

    /**
     * ????????????
     *
     * @param cls        protobuf???class
     * @param cmd        ?????????
     * @param serverType ???????????????
     * @param module     ??????
     */
    private void registerCmd(Class<? extends MessageLite> cls, int cmd, ServerType serverType, Module module) {
        if (cmd2Unit.containsKey(cmd)) {
            throw new RuntimeException("cmd " + cmd + ", cls " + cls.getName() + " ???????????????");
        }
        cls2cmd.put(cls, cmd);
        cmd2Unit.put(cmd, new CmdUnit(cls, serverType, module));
    }

    /**
     * ????????????
     *
     * @param cls        protobuf???class
     * @param cmd        ?????????
     * @param serverType ???????????????
     * @param module     ??????
     * @param record     ????????????
     */
    private void registerCmd(Class<? extends MessageLite> cls, int cmd, ServerType serverType, Module module, boolean record) {
        if (cmd2Unit.containsKey(cmd)) {
            throw new RuntimeException("cmd " + cmd + ", cls " + cls.getName() + " ???????????????");
        }
        cls2cmd.put(cls, cmd);
        cmd2Unit.put(cmd, new CmdUnit(cls, serverType, module, record));
    }

    /**
     * ??????
     *
     * @param cls
     * @return
     */
    public int getCmd(Class<? extends MessageLite> cls) {
        return cls2cmd.get(cls);
    }

    public <T extends MessageLite> Class getCls(int cmd) {
        CmdUnit unit = cmd2Unit.get(cmd);
        try {
            return unit.getCls();
        } catch (Exception e) {
            log.error("error cmd {}", cmd);
        }
        return null;
    }

    public ServerType getServerType(int cmd) {
        CmdUnit unit = cmd2Unit.get(cmd);
        return unit.getServerType();
    }

    public Module getModule(int cmd) {
        CmdUnit unit = cmd2Unit.get(cmd);
        return unit.getModule();
    }

    public CmdUnit getUnit(int cmd) {
        CmdUnit unit = cmd2Unit.get(cmd);
        return unit;
    }
}
