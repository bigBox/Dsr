package com.dj.servergate.action.global;

import com.dj.domain.constant.ConstantGame;
import com.dj.protobuf.Module;
import com.dj.protobuf.ServerType;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGlobalGuildReq;
import com.dj.protobuf.forward.ForwardGlobalGuildRsp;
import com.dj.protobuf.guild.GuildApplyReq;
import com.dj.protobuf.server.ReadPlayerItemReq;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.base.GateGlobalAction;
import com.dj.servergate.manager.ChannelManager;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;

/**
 * @description 商会
 * @author zcq
 * @date 2019年4月25日
 */
@SuppressWarnings("deprecation")
@IActionModule(module = Module.GLOBAL_GUILD)
public class GateGlobalGuildAction extends GateGlobalAction {

	@IActionCmd(cmd = ProtobufCmd.CLIENT_GUILD_APPLY_REQ)
	public void guildApplyReq(MyMsg msg) {
		GuildApplyReq content = msg.getContent(GuildApplyReq.class);
		msg.getChannel().attr(ServerAttribute.req).set(content);
		ReadPlayerItemReq.Builder builder = ReadPlayerItemReq.newBuilder();
		builder.setRoleID(msg.getRoleID());
		builder.setItemID(ConstantGame.TOKEN);
		ChannelManager.getInstance().sendToConnectServer(ServerType.PLAYER,getServerID(ServerType.PLAYER, msg.getRoleID()), builder.build());
	}
	
	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GLOBALGUILD_RSP)
	public void forwardGlobalGuildRsp(MyMsg msg) {
		ForwardGlobalGuildRsp forward = msg.getContent(ForwardGlobalGuildRsp.class);
		GeneratedMessageV3 rspContent = getForwardRsp(forward.getRspClz(), forward.getRsp());
		sendClient4Role(forward.getRoleID(), rspContent);
	}

	public void sendForward2Global(long roleID, MessageLite content, String ps) {
		ForwardGlobalGuildReq.Builder builder = ForwardGlobalGuildReq.newBuilder();
		builder.setRoleID(roleID);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		sendMsg2Global(getServerID(roleID), builder.build());
	}
}
