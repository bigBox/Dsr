package com.dj.servergate.action.game;

import java.util.List;

import com.dj.domain.GlobalRoleID;
import com.dj.domain.constant.ConstantGame;
import com.dj.protobuf.Module;
import com.dj.protobuf.ServerType;
import com.dj.protobuf.ProtobufCmd;
import com.dj.protobuf.forward.ForwardGameMultiReq;
import com.dj.protobuf.forward.ForwardGameMultiRsp;
import com.dj.protobuf.scene.CheckSceneRsp;
import com.dj.protobuf.scene.JoinSceneReq;
import com.dj.protobuf.scene.LeaveSceneReq;
import com.dj.protobuf.scene.SceneDetailInfo;
import com.dj.protobuf.scene.SceneMovementReq;
import com.dj.protobuf.scene.SceneUseSkillReq;
import com.dj.protobuf.server.ReadPlayerItemReq;
import com.dj.servercore.action.base.IActionCmd;
import com.dj.servercore.action.base.IActionModule;
import com.dj.servercore.server.base.ServerAttribute;
import com.dj.servercore.server.netty.channel.BaseChannel;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.base.GateGameAction;
import com.dj.servergate.manager.ChannelManager;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.MessageLite;

/**
 * @description 多人游戏
 * @author zcq
 * @date 2019年4月18日
 */
@SuppressWarnings("deprecation")
@IActionModule(module = Module.GAME_MULTI)
public class GateGameMultiAction extends GateGameAction {

	// 加入场景
	// 1.先到玩家服读取挖矿需要的道具
	// 2.然后再到游戏服进入挖矿地图 @method readPlayerMineItemRsp
	@IActionCmd(cmd = ProtobufCmd.CLIENT_JOINSCENE_REQ)
	public void joinSceneReq(MyMsg msg) {
		JoinSceneReq content = msg.getContent(JoinSceneReq.class);
		long master = content.getId();
		msg.getChannel().attr(ServerAttribute.master).set(master);
		msg.getChannel().attr(ServerAttribute.req).set(content);
		ReadPlayerItemReq.Builder builder = ReadPlayerItemReq.newBuilder();
		builder.setRoleID(msg.getRoleID());
		builder.setItemID(ConstantGame.SHOVEL);
		ChannelManager.getInstance().sendToConnectServer(ServerType.PLAYER,getServerID(ServerType.PLAYER, msg.getRoleID()), builder.build());
	}

	// 离开场景
	@IActionCmd(cmd = ProtobufCmd.CLIENT_LEAVESCENE_REQ)
	public void leaveSceneReq(MyMsg msg) {
		LeaveSceneReq content = msg.getContent(LeaveSceneReq.class);
		long master = msg.getChannel().attr(ServerAttribute.master).get();
		sendForward2Game(master, msg.getRoleID(), content, "");
	}

	// 场景移动
	@IActionCmd(cmd = ProtobufCmd.CLIENT_SCENE_MOVEMENT_REQ)
	public void sceneMovementReq(MyMsg msg) {
		SceneMovementReq content = msg.getContent(SceneMovementReq.class);
		long master = msg.getChannel().attr(ServerAttribute.master).get();
		sendForward2Game(master, msg.getRoleID(), content, "");
	}

	// 场景使用技能
	@IActionCmd(cmd = ProtobufCmd.CLIENT_SCENE_USESKILL_REQ)
	public void sceneUseSkillReq(MyMsg msg) {
		SceneUseSkillReq content = msg.getContent(SceneUseSkillReq.class);
		long master = msg.getChannel().attr(ServerAttribute.master).get();
		sendForward2Game(master, msg.getRoleID(), content, "");
	}

	@IActionCmd(cmd = ProtobufCmd.SERVER_FORWARD_GAMEMULTI_RSP)
	public void forwardGameMultiRsp(MyMsg msg) {
		ForwardGameMultiRsp forward = msg.getContent(ForwardGameMultiRsp.class);
		GeneratedMessageV3 rspContent = getForwardRsp(forward.getRspClz(), forward.getRsp());
		sendClient4Role(forward.getRoleID(), rspContent);
		if (rspContent instanceof CheckSceneRsp) {
			// 检查当前是否在某个场景
			SceneDetailInfo sceneDetailInfo = ((CheckSceneRsp) rspContent).getSceneDetailInfo();
			if(sceneDetailInfo != null) {
				long master = sceneDetailInfo.getBriefInfo().getId();
				BaseChannel clientChannel = ChannelManager.getInstance().getChannel(forward.getRoleID());
				clientChannel.getChannel().attr(ServerAttribute.master).set(master);
			}
		}
	}

	public void sendForward2Game(long master, long roleID, MessageLite content, String ps) {
		if (master == GlobalRoleID.getXiaoXun()) {
			master = roleID;
		}
		if (master == roleID) {
			// 自己家
			sendForward2Game(roleID, content, ps);
			return;
		}
		// 好友家
		ForwardGameMultiReq.Builder builder = ForwardGameMultiReq.newBuilder();
		builder.setRoleID(roleID);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		sendMsg2Game(getMasterServerID(master), builder.build());
	}

	protected void sendForward2Game(long roleID, MessageLite content, String ps) {
		ForwardGameMultiReq.Builder builder = ForwardGameMultiReq.newBuilder();
		builder.setRoleID(roleID);
		builder.setReqClz(content.getClass().getName());
		builder.setReq(content.toByteString());
		builder.setPs(ps);
		sendMsg2Game(getServerID(roleID), builder.build());
	}

	/**
	 * 获取主人家的游戏服id
	 * 
	 * @param master
	 * @return
	 */
	private int getMasterServerID(long master) {
		List<Integer> serverList = ChannelManager.getInstance().getServerList(ServerType.GAME);
		int index = (int) (master % serverList.size());
		int serverID = serverList.get(index);
		return serverID;
	}
}
