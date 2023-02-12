package com.dj.servercore.task;

import com.dj.servercore.task.msg.MsgDispatcher;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.domain.util.Utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public abstract class AbstractConnectTask extends AbstractTask{

	/**
	 * @Field msgDispatcher : 消息分发器
	 */
	@Getter
	protected static MsgDispatcher msgDispatcher;

	protected MyMsg msg;

	@Override
	public void run() {
		try {
			msgDispatcher.dispatch(msg);
		} catch (Exception e) {
			log.error(Utility.getTraceString(e));
		}
	}

	@Override
	protected void reset() {
		resetProperties();
	}
}
