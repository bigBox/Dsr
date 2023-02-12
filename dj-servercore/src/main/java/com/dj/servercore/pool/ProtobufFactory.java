package com.dj.servercore.pool;

import com.dj.protobuf.ProtobufCmdPool;
import com.dj.servercore.task.AbstractClientTask;
import com.dj.servercore.task.AbstractConnectTask;
import com.dj.servercore.task.msg.MyMsg;
import com.google.protobuf.GeneratedMessageV3;

@SuppressWarnings("unchecked")
public final class ProtobufFactory {

	public static <T extends MyMsg> T borrowMyMsg(Class<? extends MyMsg> clz, int cmd, GeneratedMessageV3 content, long roleID) {
		T msg = (T) PooledMsgTaskFactory.getInstance().borrowObject(clz);
		msg.setModule(ProtobufCmdPool.INSTANCE.getModule(cmd));
		msg.setCmd(cmd);
		msg.setContent(content);
		msg.setRoleID(roleID);
		return msg;
	}

	public static <T extends AbstractConnectTask> T borrowMsgConnectTask(Class<? extends AbstractConnectTask> clz, MyMsg msg) {
		T task = (T) PooledMsgTaskFactory.getInstance().borrowObject(clz);
		task.setMsg(msg);
		return task;
	}

	public static <T extends AbstractClientTask> T borrowMsgClientTask(Class<? extends AbstractClientTask> clz, MyMsg msg) {
		T task = (T) PooledMsgTaskFactory.getInstance().borrowObject(clz);
		task.setMsg(msg);
		return task;
	}
}
