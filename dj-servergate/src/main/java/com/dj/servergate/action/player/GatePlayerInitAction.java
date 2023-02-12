package com.dj.servergate.action.player;

import java.net.InetSocketAddress;

import com.dj.protobuf.Module;
import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.alipay.AliPayPreReq;
import com.dj.protobuf.alipay.AliPayPreRsp;
import com.dj.protobuf.alipay.AliPayQueryReq;
import com.dj.protobuf.alipay.AliPayQueryRsp;
import com.dj.protobuf.forward.ForwardPlayerInitReq;
import com.dj.protobuf.forward.ForwardPlayerInitRsp;
import com.dj.protobuf.login.*;
import com.dj.protobuf.wxpay.WxPayQueryReq;
import com.dj.protobuf.wxpay.WxPayQueryRsp;
import com.dj.protobuf.wxpay.WxPrePayReq;
import com.dj.protobuf.wxpay.WxPrePayRsp;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.server.ConnectServer;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.servercore.server.netty.channel.BaseChannel;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.base.GatePlayerAction;
import com.dj.servergate.manager.ChannelManager;
import com.dj.domain.util.StringUtil;
import com.dj.domain.util.Utility;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;

import lombok.extern.slf4j.Slf4j;

/**
 * @description 玩家初始化
 * @author zcq
 * @date 2019年5月24日
 */
@Slf4j
@IActionModule(module = Module.PLAYER_INIT)
public class GatePlayerInitAction extends GatePlayerAction {

	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_PLAYER_INIT_RSP)
	public void forwardPlayerInitRsp(MyMsg msg) {
		ForwardPlayerInitRsp forward = msg.getContent(ForwardPlayerInitRsp.class);
		GeneratedMessageV3 rspContent = getForwardRsp(forward.getRspClz(), forward.getRsp());
		if (rspContent instanceof CreateSmsCodeRsp) {
			// 获取短信验证码
			sendClient4Player(((CreateSmsCodeRsp) rspContent).getReq().getPhoneNum(), rspContent);
		}
		else if (rspContent instanceof VerifySmsCodeRsp) {
			// 验证短信验证码
			sendClient4Player(((VerifySmsCodeRsp) rspContent).getReq().getPhoneNum(), rspContent);
		}
		else if (rspContent instanceof ResetPasswordRsp) {
			// 重置密码
			sendClient4Player(((ResetPasswordRsp) rspContent).getReq().getAccount(), rspContent);
		}
		else if (rspContent instanceof CreateAccountRsp) {
			// 玩家注册
			sendClient4Player(((CreateAccountRsp) rspContent).getReq().getAccount(), rspContent);
		}
		else if (rspContent instanceof RealNameAuthRsp) {
			// 实名认证
			sendClient4Player(((RealNameAuthRsp) rspContent).getReq().getAccount(), rspContent);
		}
		else if (rspContent instanceof WxPrePayRsp) {
			// 微信预支付请求
			sendClient4Player(((WxPrePayRsp) rspContent).getReq().getAccount(), rspContent);
		}
		else if (rspContent instanceof WxPayQueryRsp) {
			// 微信支付结果查询
			sendClient4Player(((WxPayQueryRsp) rspContent).getReq().getAccount(), rspContent);
		}
		else if (rspContent instanceof AliPayPreRsp) {
			// 支付宝支付前请求
			sendClient4Player(((AliPayPreRsp) rspContent).getReq().getAccount(), rspContent);
		}
		else if (rspContent instanceof AliPayQueryRsp) {
			// 支付宝支付结果查询
			sendClient4Player(((AliPayQueryRsp) rspContent).getReq().getAccount(), rspContent);
		}
		else if (rspContent instanceof UserLoginRsp) {
			// 玩家登陆
			userLoginRsp((UserLoginRsp) rspContent);
		}
		else if (rspContent instanceof ReloginRsp) {
			// 重新登录
			reloginRsp((ReloginRsp) rspContent, forward.getPs());
		}
		else if (rspContent instanceof RoleLoginNtf) {
			// 推送登陆角色属性
			BaseChannel clientChannel = ChannelManager.getInstance().getChannel(forward.getRoleID());
			if(clientChannel.getChannelID().equals(forward.getChannelID()) || clientChannel.getChannel().hasAttr(ServerAttribute.master) == false) {
				roleLoginNtf(forward.getRoleID(), (RoleLoginNtf) rspContent);
			}
		}
	}

	@IActionCmd(cmd = ProtobufCmd.CLIENT_CREATE_SMS_CODE_REQ)
	public void createSmsCodeReq(MyMsg msg) {
		CreateSmsCodeReq content = msg.getContent(CreateSmsCodeReq.class);
		ChannelManager.getInstance().setPlayerServer(content.getPhoneNum(), msg.getChannel());
		if (!ConnectServer.isReady()) {
			CreateSmsCodeRsp.Builder builder = CreateSmsCodeRsp.newBuilder();
			builder.setErrorID(ErrorID.SYSTEM_SERVICE_DOWN);
			sendClient4Player(content.getPhoneNum(), builder.build());
			return;
		}
		String ip = ((InetSocketAddress) msg.getChannel().channel().remoteAddress()).getAddress().getHostAddress();
		sendForward2Player(content.getPhoneNum(), content, ip);
	}

	@IActionCmd(cmd = ProtobufCmd.CLIENT_VERIFY_SMS_CODE_REQ)
	public void verifySmsCodeReq(MyMsg msg) {
		VerifySmsCodeReq content = msg.getContent(VerifySmsCodeReq.class);
		ChannelManager.getInstance().setPlayerServer(content.getPhoneNum(), msg.getChannel());
		if (!ConnectServer.isReady()) {
			VerifySmsCodeRsp.Builder builder = VerifySmsCodeRsp.newBuilder();
			builder.setErrorID(ErrorID.SYSTEM_SERVICE_DOWN);
			sendClient4Player(content.getPhoneNum(), builder.build());
			return;
		}
		String ip = ((InetSocketAddress) msg.getChannel().channel().remoteAddress()).getAddress().getHostAddress();
		sendForward2Player(content.getPhoneNum(), content, ip);
	}

	@IActionCmd(cmd = ProtobufCmd.CLIENT_RESET_PASSWORD_REQ)
	public void resetPasswordReq(MyMsg msg) {
		ResetPasswordReq content = msg.getContent(ResetPasswordReq.class);
		ChannelManager.getInstance().setPlayerServer(content.getAccount(), msg.getChannel());
		if (!ConnectServer.isReady()) {
			ResetPasswordRsp.Builder builder = ResetPasswordRsp.newBuilder();
			builder.setErrorID(ErrorID.SYSTEM_SERVICE_DOWN);
			sendClient4Player(content.getAccount(), builder.build());
			return;
		}
		String ip = ((InetSocketAddress) msg.getChannel().channel().remoteAddress()).getAddress().getHostAddress();
		sendForward2Player(content.getAccount(), content, ip);
	}

	@IActionCmd(cmd = ProtobufCmd.CLIENT_CREATE_ACCOUNT_REQ)
	public void createAccountReq(MyMsg msg) {
		CreateAccountReq content = msg.getContent(CreateAccountReq.class);
		ChannelManager.getInstance().setPlayerServer(content.getAccount(), msg.getChannel());
		if (!ConnectServer.isReady()) {
			CreateAccountRsp.Builder builder = CreateAccountRsp.newBuilder();
			builder.setErrorID(ErrorID.SYSTEM_SERVICE_DOWN);
			sendClient4Player(content.getAccount(), builder.build());
			return;
		}
		String ip = ((InetSocketAddress) msg.getChannel().channel().remoteAddress()).getAddress().getHostAddress();
		sendForward2Player(content.getAccount(), content, ip);
	}

	@IActionCmd(cmd = ProtobufCmd.CLIENT_LOGIN_USERLOGIN_REQ)
	public void userLoginReq(MyMsg msg) {
		UserLoginReq content = msg.getContent(UserLoginReq.class);
		ChannelManager.getInstance().setPlayerServer(content.getAccount(), msg.getChannel());
		if (!ConnectServer.isReady()) {
			UserLoginRsp.Builder builder = UserLoginRsp.newBuilder();
			builder.setErrorID(ErrorID.SYSTEM_SERVICE_DOWN);
			sendClient4Player(content.getAccount(), builder.build());
			return;
		}
		String ip = ((InetSocketAddress) msg.getChannel().channel().remoteAddress()).getAddress().getHostAddress();
		String channelID = msg.getChannel().channel().id().toString();
		sendForward2Player(content.getAccount(), content, ip, channelID);
	}

	@IActionCmd(cmd = ProtobufCmd.CLIENT_LOGIN_RELOGIN_REQ)
	public void reloginReq(MyMsg msg) {
		try {
			ReloginReq content = msg.getContent(ReloginReq.class);
			if(StringUtil.isEmpty(content.getAccount())) {
				return;
			}
			ChannelManager.getInstance().setPlayerServer(content.getAccount(), msg.getChannel());
			if (!ConnectServer.isReady()) {
				ReloginRsp.Builder builder = ReloginRsp.newBuilder();
				builder.setErrorID(ErrorID.SYSTEM_SERVICE_DOWN);
				sendClient4Player(content.getAccount(), builder.build());
				return;
			}
			String ip = ((InetSocketAddress) msg.getChannel().channel().remoteAddress()).getAddress().getHostAddress();
			String channelID = msg.getChannel().channel().id().toString();
			sendForward2Player(content.getAccount(), content, ip, channelID);
		} catch (Exception e) {
			log.info(Utility.getTraceString(e));
		}
	}

	@IActionCmd(cmd = ProtobufCmd.REAL_NAME_AUTH_REQ)
	public void realNameAuthReq(MyMsg msg) {
		RealNameAuthReq content = msg.getContent(RealNameAuthReq.class);
		ChannelManager.getInstance().setPlayerServer(content.getAccount(), msg.getChannel());
		if (!ConnectServer.isReady()) {
			RealNameAuthRsp.Builder builder = RealNameAuthRsp.newBuilder();
			builder.setErrorID(ErrorID.SYSTEM_SERVICE_DOWN);
			sendClient4Player(content.getAccount(), builder.build());
			return;
		}
		String ip = ((InetSocketAddress) msg.getChannel().channel().remoteAddress()).getAddress().getHostAddress();
		String channelID = msg.getChannel().channel().id().toString();
		sendForward2Player(content.getAccount(), content, ip, channelID);
	}

	@IActionCmd(cmd = ProtobufCmd.WX_PRE_PAY_REQ)
	public void wechatPrePayReq(MyMsg msg) {
		WxPrePayReq content = msg.getContent(WxPrePayReq.class);
		ChannelManager.getInstance().setPlayerServer(content.getAccount(), msg.getChannel());
		if (!ConnectServer.isReady()) {
			WxPrePayRsp.Builder builder = WxPrePayRsp.newBuilder();
			builder.setErrorID(ErrorID.SYSTEM_SERVICE_DOWN);
			sendClient4Player(content.getAccount(), builder.build());
			return;
		}
		String ip = ((InetSocketAddress) msg.getChannel().channel().remoteAddress()).getAddress().getHostAddress();
		String channelID = msg.getChannel().channel().id().toString();
		sendForward2Player(content.getRoleID(), content, ip, channelID);
	}

	@IActionCmd(cmd = ProtobufCmd.WX_PAY_QUERY_REQ)
	public void wechatPayQueryReq(MyMsg msg) {
		WxPayQueryReq content = msg.getContent(WxPayQueryReq.class);
		ChannelManager.getInstance().setPlayerServer(content.getAccount(), msg.getChannel());
		if (!ConnectServer.isReady()) {
			WxPayQueryRsp.Builder builder = WxPayQueryRsp.newBuilder();
			builder.setErrorID(ErrorID.SYSTEM_SERVICE_DOWN);
			sendClient4Player(content.getAccount(), builder.build());
			return;
		}
		String ip = ((InetSocketAddress) msg.getChannel().channel().remoteAddress()).getAddress().getHostAddress();
		String channelID = msg.getChannel().channel().id().toString();
		sendForward2Player(content.getRoleID(), content, ip, channelID);
	}

	@IActionCmd(cmd = ProtobufCmd.ALI_PAY_PRE_REQ)
	public void aliPayPreReq(MyMsg msg) {
		AliPayPreReq content = msg.getContent(AliPayPreReq.class);
		ChannelManager.getInstance().setPlayerServer(content.getAccount(), msg.getChannel());
		if (!ConnectServer.isReady()) {
			AliPayPreRsp.Builder builder = AliPayPreRsp.newBuilder();
			builder.setErrorID(ErrorID.SYSTEM_SERVICE_DOWN);
			sendClient4Player(content.getAccount(), builder.build());
			return;
		}
		String ip = ((InetSocketAddress) msg.getChannel().channel().remoteAddress()).getAddress().getHostAddress();
		String channelID = msg.getChannel().channel().id().toString();
		sendForward2Player(content.getRoleID(), content, ip, channelID);
	}

	@IActionCmd(cmd = ProtobufCmd.ALI_PAY_QUERY_REQ)
	public void aliPayQueryReq(MyMsg msg) {
		AliPayQueryReq content = msg.getContent(AliPayQueryReq.class);
		ChannelManager.getInstance().setPlayerServer(content.getAccount(), msg.getChannel());
		if (!ConnectServer.isReady()) {
			AliPayQueryRsp.Builder builder = AliPayQueryRsp.newBuilder();
			builder.setErrorID(ErrorID.SYSTEM_SERVICE_DOWN);
			sendClient4Player(content.getAccount(), builder.build());
			return;
		}
		String ip = ((InetSocketAddress) msg.getChannel().channel().remoteAddress()).getAddress().getHostAddress();
		String channelID = msg.getChannel().channel().id().toString();
		sendForward2Player(content.getRoleID(), content, ip, channelID);
	}
	// 玩家登陆
	private void userLoginRsp(UserLoginRsp rspContent) {
		sendClient4Player(rspContent.getAccount(), rspContent);
		if (rspContent.getErrorID() == ErrorID.OK) {
			// 登录后的行为
			ChannelManager.getInstance().bindRoleChannel(rspContent.getRoleID(), rspContent.getAccount(), 
				clientChannel->{
					KickOutGameNtf.Builder kickOutGameNtf = KickOutGameNtf.newBuilder();
					clientChannel.sendMsg(kickOutGameNtf.build());
				});
		}
	}

	// 重新登录
	private void reloginRsp(ReloginRsp rspContent, String account) {
		if (rspContent.getErrorID() == ErrorID.OK) {
			// 登录后的行为
			ChannelManager.getInstance().bindRoleChannel(rspContent.getRoleId(), account, 
				clientChannel->{
					KickOutGameNtf.Builder kickOutGameNtf = KickOutGameNtf.newBuilder();
					clientChannel.sendMsg(kickOutGameNtf.build());
				});
			sendClient4Role(rspContent.getRoleId(), rspContent);
		}
	}

	// 推送登陆角色属性
	private void roleLoginNtf(long roleID, RoleLoginNtf rspContent) {
		sendClient4Role(roleID, rspContent);

		// 属性值同步客户端完成
		PlayerAttrClientNtfFinish.Builder playerAttrClientNtfFinish = PlayerAttrClientNtfFinish.newBuilder();
		sendClient4Role(roleID, playerAttrClientNtfFinish.build());
	}

	protected void sendForward2Player(long roleID, MessageLite content, String ps) {
		ForwardPlayerInitReq.Builder builder = ForwardPlayerInitReq.newBuilder();
		builder.setRoleID(roleID);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		sendMsg2Player(getServerID(roleID), builder.build());
	}

	protected void sendForward2Player(long roleID, MessageLite content, String ps, String channelID) {
		ForwardPlayerInitReq.Builder builder = ForwardPlayerInitReq.newBuilder();
		builder.setRoleID(roleID);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		builder.setChannelID(channelID);
		sendMsg2Player(getServerID(roleID), builder.build());
	}

	@Override
	protected void sendForward2Player(String account, MessageLite content, String ps) {
		ForwardPlayerInitReq.Builder builder = ForwardPlayerInitReq.newBuilder();
		builder.setRoleID(0);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		sendMsg2Player(getServerID(account), builder.build());
	}
	
	protected void sendForward2Player(String account, MessageLite content, String ps, String channelID) {
		ForwardPlayerInitReq.Builder builder = ForwardPlayerInitReq.newBuilder();
		builder.setRoleID(0);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		builder.setChannelID(channelID);
		sendMsg2Player(getServerID(account), builder.build());
	}
}
