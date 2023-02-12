package com.dj.serverplayer.action;

import com.dj.protobuf.Module;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.server.KeepAlive4PlayerRsp;
import com.dj.protobuf.server.RegisterGate2PlayerReq;
import com.dj.protobuf.server.RegisterGate2PlayerRsp;
import com.dj.protobuf.server.UpdateConfig4PlayerReq;
import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.conf.base.BaseConfManager;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.serverplayer.manager.ChannelManager;
import com.dj.serverplayer.server.PlayerServer;
import com.dj.domain.util.GsonUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @description 玩家服务器
 * @author zcq
 * @date 2019年4月18日
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
@IActionModule(module = Module.PLAYER_SERVER)
public class PlayerServerAction extends BaseAction {

	@IActionCmd(cmd = ProtobufCmd.SERVER_REGISTER_GATE2PLAYER_REQ)
	public void registerGate2PlayerReq(MyMsg msg) {
		RegisterGate2PlayerReq content = msg.getContent(RegisterGate2PlayerReq.class);
		log.info("PlayerServer and GateServer channel:" + GsonUtil.toJson(content));
		ChannelManager.getInstance().addChannel(content.getServerId(), msg.getChannel());

		RegisterGate2PlayerRsp.Builder builder = msg.getResultBuilder(RegisterGate2PlayerRsp.class);
		builder.setServerId(PlayerServer.getServerConfig().getId());
		builder.setServerName(PlayerServer.getServerConfig().getName());
	}

	@IActionCmd(cmd = ProtobufCmd.SERVER_KEEPALIVE4PLAYER_REQ)
	public void keepAlive4Player(MyMsg msg) {
		msg.getResultBuilder(KeepAlive4PlayerRsp.class);
	}

	@IActionCmd(cmd = ProtobufCmd.SERVER_UPDATE_CONFIG_4PLAYER_REQ)
	public void updateConfig4PlayerReq(MyMsg msg) {
		UpdateConfig4PlayerReq content = msg.getContent(UpdateConfig4PlayerReq.class);
		BaseConfManager.getInstance().updateConfig(content.getJsonConfigName());
	}
}
