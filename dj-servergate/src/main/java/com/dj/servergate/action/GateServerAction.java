package com.dj.servergate.action;

import com.dj.domain.constant.ConstantServer;
import com.dj.protobuf.Module;
import com.dj.protobuf.ServerType;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.guild.GuildApplyReq;
import com.dj.protobuf.login.ServerStopNtf;
import com.dj.protobuf.scene.JoinSceneReq;
import com.dj.protobuf.server.ReadPlayerItemRsp;
import com.dj.protobuf.server.RegisterGate2GameRsp;
import com.dj.protobuf.server.RegisterGate2GlobalRsp;
import com.dj.protobuf.server.RegisterGate2PlayerRsp;
import com.dj.protobuf.server.UpdateConfig4GameReq;
import com.dj.protobuf.server.UpdateConfig4GlobalReq;
import com.dj.protobuf.server.UpdateConfig4PlayerReq;
import com.dj.protobuf.server.UpdateConfigReq;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.server.ConnectServer;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.servercore.server.config.ConnectServerConfig;
import com.dj.servercore.server.config.ServerConfigXmlLoader;
import com.dj.servercore.server.netty.channel.BaseChannel;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.game.GateGameMultiAction;
import com.dj.servergate.action.global.GateGlobalGuildAction;
import com.dj.servergate.manager.ActionManager;
import com.dj.servergate.manager.ChannelManager;
import com.dj.servergate.server.GateServer;
import com.dj.domain.util.GsonUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;

import lombok.extern.slf4j.Slf4j;

/**
 * @description 网关服务器
 * @author zcq
 * @date 2019年4月18日
 */
@Slf4j
@SuppressWarnings("deprecation")
@IActionModule(module = Module.GATE_SERVER)
public class GateServerAction extends BaseAction {

	@IActionCmd(cmd = ProtobufCmd.SERVER_REGISTER_GATE2PLAYER_RSP)
	public void registerGate2PlayerRsp(MyMsg msg) {
		RegisterGate2PlayerRsp content = msg.getContent(RegisterGate2PlayerRsp.class);
		ConnectServer.serverPlayerReady = true;
		ConnectServer.cdl.countDown();
		log.info("{}{} is ready!!! cdl {}", content.getServerName(), content.getServerId(), ConnectServer.cdl.getCount());
	}

	@IActionCmd(cmd = ProtobufCmd.SERVER_KEEPALIVE4PLAYER_RSP)
	public void keepAlive4PlayerRsp(MyMsg msg) {
//		ConnectServer.serverPlayerReady = true;
	}

	@IActionCmd(cmd = ProtobufCmd.SERVER_REGISTER_GATE2GAME_RSP)
	public void registerGate2GameRsp(MyMsg msg) {
		RegisterGate2GameRsp content = msg.getContent(RegisterGate2GameRsp.class);
		ConnectServer.serverGameReady = true;
		ConnectServer.cdl.countDown();
		log.info("{}{} is ready!!! cdl {}", content.getServerName(), content.getServerId(), ConnectServer.cdl.getCount());
	}

	@IActionCmd(cmd = ProtobufCmd.SERVER_KEEPALIVE4GAME_RSP)
	public void keepAlive4GameRsp(MyMsg msg) {
//		ConnectServer.serverGameReady = true;
	}

	@IActionCmd(cmd = ProtobufCmd.SERVER_REGISTER_GATE2GLOBAL_RSP)
	public void registerGate2GlobalRsp(MyMsg msg) {
		RegisterGate2GlobalRsp content = msg.getContent(RegisterGate2GlobalRsp.class);
		ConnectServer.serverGlobalReady = true;
		ConnectServer.cdl.countDown();
		log.info("{}{} is ready!!! cdl {}", content.getServerName(), content.getServerId(), ConnectServer.cdl.getCount());
	}

	@IActionCmd(cmd = ProtobufCmd.SERVER_KEEPALIVE4GLOBAL_RSP)
	public void keepAlive4GlobalRsp(MyMsg msg) {
//		ConnectServer.serverGlobalReady = true;
	}

	@IActionCmd(cmd = ProtobufCmd.SERVER_UPDATE_CONFIG_REQ)
	public void updateConfigReq(MyMsg msg) {
		UpdateConfigReq content = msg.getContent(UpdateConfigReq.class);
		log.info(content.getJsonConfigName());

		UpdateConfig4PlayerReq.Builder player = UpdateConfig4PlayerReq.newBuilder();
		player.setJsonConfigName(content.getJsonConfigName());
		ChannelManager.getInstance().sendToAllConnectServer(ServerType.PLAYER, player.build());

		UpdateConfig4GameReq.Builder game = UpdateConfig4GameReq.newBuilder();
		game.setJsonConfigName(content.getJsonConfigName());
		ChannelManager.getInstance().sendToAllConnectServer(ServerType.GAME, game.build());

		UpdateConfig4GlobalReq.Builder global = UpdateConfig4GlobalReq.newBuilder();
		global.setJsonConfigName(content.getJsonConfigName());
		ChannelManager.getInstance().sendToAllConnectServer(ServerType.GLOBAL, global.build());
	}

	@IActionCmd(cmd = ProtobufCmd.SERVER_UPDATE_CONNECT_LOGIC_REQ)
	public void updateConnectLogicReq(MyMsg msg) {
		log.info("更新连接逻辑服");
		String url = GateServer.getServerConfig().getServerCdnUrl() + ConstantServer.defaultConnectServerConfig;
		log.info(url);
		ConnectServerConfig connectServerConfig = ServerConfigXmlLoader.loadClient(url);
		log.info(GsonUtil.toJson(connectServerConfig));

		ConnectServer connectServer = GateServer.getInstance().getConnectServer();
		try {
			connectServer.connectServers(connectServerConfig.getPlayerServers(), ServerType.PLAYER);
			connectServer.connectServers(connectServerConfig.getGameServers(), ServerType.GAME);
			connectServer.connectServers(connectServerConfig.getGlobalServers(), ServerType.GLOBAL);
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
		}
	}

	
	@IActionCmd(cmd = ProtobufCmd.CLIENT_SERVER_STOP_NTF)
	public void serverStopNtf(MyMsg msg) {
		log.info("服务器停服维护");
		ConnectServer.serverPlayerReady = false;
		ServerStopNtf.Builder ntf = ServerStopNtf.newBuilder();
		ChannelManager.getInstance().sendClient4AllRole(ntf.build());
	}
	
	// 响应获取玩家道具
	@IActionCmd(cmd = ProtobufCmd.SERVER_READ_PLAYER_ITEM_RSP)
	public void readPlayerItemRsp(MyMsg msg) {
		ReadPlayerItemRsp rsp = msg.getContent(ReadPlayerItemRsp.class);
		BaseChannel channel = ChannelManager.getInstance().getChannel(rsp.getReq().getRoleID());
		GeneratedMessageV3 content = (GeneratedMessageV3) channel.getChannel().attr(ServerAttribute.req).get();
		log.info("cls {}, ps {}", content.getClass().getSimpleName(), rsp.getData());
		if(content instanceof JoinSceneReq) {
			long master = channel.getChannel().attr(ServerAttribute.master).get();
			GateGameMultiAction action = (GateGameMultiAction)ActionManager.getInstance().getAction(Module.GAME_MULTI);
			action.sendForward2Game(master, rsp.getReq().getRoleID(), content, rsp.getData());
		} else if(content instanceof GuildApplyReq) {
			GateGlobalGuildAction action = (GateGlobalGuildAction)ActionManager.getInstance().getAction(Module.GLOBAL_GUILD);
			action.sendForward2Global(rsp.getReq().getRoleID(), content, rsp.getData());
		}
	}

}
