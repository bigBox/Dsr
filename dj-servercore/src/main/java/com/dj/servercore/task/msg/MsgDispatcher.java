package com.dj.servercore.task.msg;

import com.dj.servercore.action.adapter.IMsgAction;
import com.dj.servercore.executor.OrderedQueuePoolExecutor;

import lombok.Data;

@Data
public class MsgDispatcher {
	/**
	 * @Field action : Message消息处理器
	 */
	private final IMsgAction action;
	/**
	 * @Field workerExcutor : 消息有序处理线程池
	 */
	private final OrderedQueuePoolExecutor workerExcutor;
	
	public MsgDispatcher(IMsgAction action) {
		super();
		this.action = action;
		this.workerExcutor = new OrderedQueuePoolExecutor("MsgDispatchQueue");
	}

	public void dispatch(MyMsg msg){
		msg.setAction(action);
		workerExcutor.addTask(msg.getRoleID(), msg);
	}
}
