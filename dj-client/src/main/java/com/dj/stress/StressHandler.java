package com.dj.stress;

import com.dj.protobuf.ProtobufCmdPool;
import com.dj.protobuf.login.UserLoginReq;
import com.dj.protobuf.meetEgg.StartMeetEggReq;
import com.dj.protobuf.scene.ESceneRebornPos;
import com.dj.protobuf.scene.ESceneUseSkillType;
import com.dj.protobuf.scene.JoinSceneReq;
import com.dj.protobuf.scene.OtomeVector3D;
import com.dj.protobuf.scene.SceneUseSkillReq;
import com.dj.domain.util.StringUtil;
import com.google.protobuf.GeneratedMessageV3;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class StressHandler {
	private StressSocket socketClient = null;

	public void initClient(StressSocket ss, String key) {
		socketClient = ss;
		if (socketClient != null) {
			try {
				socketClient.connectBlocking();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		socketClient.key = key;
		
//		CreateAccountReq.Builder builder2 = CreateAccountReq.newBuilder();
//		builder2.setAccount(key);
//		builder2.setPassword("1");
//		sendMsg(builder2.build());
//		ThreadUtil.sleep(1000);
		
		UserLoginReq.Builder login = UserLoginReq.newBuilder();
		login.setAccount(socketClient.key);
		login.setPassword("1");
		sendMsg(login.build());
	}

	public void sendMsg(GeneratedMessageV3 msg) {
		System.out.println(socketClient.key+"发送消息["+msg.getClass().getSimpleName()+"],"+StringUtil.msg2Json(msg));
		ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer();
		int cmd = ProtobufCmdPool.INSTANCE.getCmd(msg.getClass());
		byteBuf.writeShortLE(cmd);
		byte[] data = msg.toByteArray();
		byteBuf.writeIntLE(data.length);
		byteBuf.writeBytes(data);
		byte[] sendData = new byte[byteBuf.readableBytes()];
		byteBuf.readBytes(sendData);
		socketClient.send(sendData);
	}
	
	public void startMeetEgg() {
		StartMeetEggReq.Builder startMeetEggReq = StartMeetEggReq.newBuilder();
		startMeetEggReq.setBuildID(7101);
		startMeetEggReq.setPositionX(0);
		sendMsg(startMeetEggReq.build());
	}
	
	public void startMine() {
		JoinSceneReq.Builder builder = JoinSceneReq.newBuilder();
		builder.setId(socketClient.roleID);
		builder.setPos(ESceneRebornPos.RebornPos);
		builder.setPassword("");
		sendMsg(builder.build());
		
		startMineSkill();
	}
	
	public void startMineSkill() {
		OtomeVector3D.Builder otomeVector3D = OtomeVector3D.newBuilder();
		otomeVector3D.setX(22*120);
		otomeVector3D.setY(4*120);
		otomeVector3D.setZ(0);
		
		SceneUseSkillReq.Builder builder = SceneUseSkillReq.newBuilder();
		builder.setSkillId(1);
		builder.setTargetRoleId(socketClient.roleID);
		builder.setType(ESceneUseSkillType.Skill_Start);
		builder.setSrcRoleDirection(otomeVector3D.build());
		builder.setTargetRoleDirection(otomeVector3D.build());
		builder.setSkillCount(1);
		builder.setTargetPos(otomeVector3D.build());
		sendMsg(builder.build());
		
		for (int i = 0; i < 10; i++) {
			builder.setType(ESceneUseSkillType.Skill_Cancel);
			sendMsg(builder.build());
		}
	}
}
