package com.dj.servergate.action;

import com.dj.protobuf.Module;
import com.dj.protobuf.ServerType;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.chat.ChatSendNtf;
import com.dj.protobuf.chat.ChatSendReq;
import com.dj.protobuf.chat.ChatSendRsp;
import com.dj.protobuf.chat.EChatChannel;
import com.dj.protobuf.forward.ForwardChatSendNtf;
import com.dj.protobuf.login.ClosebbsNtf;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.base.BaseGateAction;
import com.dj.servergate.manager.ChannelManager;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@IActionModule(module = Module.CHAT)
public class GateChatAction extends BaseGateAction {

	@IActionCmd(cmd = ProtobufCmd.CLIENT_CHAT_SEND_REQ)
	public void chatSendReq(MyMsg msg) {
		ChatSendReq content = msg.getContent(ChatSendReq.class);
		log.info("roleID {}, channel {}, content {}", content.getRoleID(), content.getChannel(), content.getContent());

		if (content.getChannel() == EChatChannel.Guild) {//商会
			ChannelManager.getInstance().sendToAllConnectServer(ServerType.GLOBAL, content);
		} else if (content.getChannel() == EChatChannel.Mine || content.getChannel() == EChatChannel.Verify) {//挖矿，鉴定
			ChannelManager.getInstance().sendToAllConnectServer(ServerType.GAME, content);
		}
	}

	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_CHAT_SEND_NTF)
	public void forwardChatSendNtf(MyMsg msg) {
		ForwardChatSendNtf forward = msg.getContent(ForwardChatSendNtf.class);
		GeneratedMessageV3 rspContent = getForwardRsp(forward.getRspClz(), forward.getRsp());
		if (rspContent instanceof ChatSendRsp) {
			// 聊天返回
			sendClient4Role(forward.getRoleID(), rspContent);
		} else if (rspContent instanceof ChatSendNtf) {
			// 聊天推送
			sendClient4Role(forward.getRoleID(), rspContent);
		} else if (rspContent instanceof ClosebbsNtf) {
			// 通知关闭论坛
			sendClient4Role(forward.getRoleID(), rspContent);
		}
	}

	@Override
	public void sendForward2Logic(long roleID, MessageLite content) {

	}
}
