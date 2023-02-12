package com.dj.servergate.manager;

import java.lang.reflect.Method;

import com.dj.servercore.action.base.BaseAction;
import com.dj.servercore.action.base.BaseActionManager;
import com.dj.servercore.task.msg.MyMsg;
import com.dj.servergate.action.base.BaseGateAction;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ActionManager extends BaseActionManager {
	private static final ActionManager INSTANCE = new ActionManager();

	public static final ActionManager getInstance() {
		return INSTANCE;
	}

	public long doAction(MyMsg msg) throws Exception {
		if (msg.getContent() == null) {
			return 0;
		}
		BaseAction action = actionModule.get(msg.getModule());
		if (action == null) {
			log.error("error module {} cls {}", msg.getModule(), msg.getContent().getClass().getSimpleName());
			return 0l;
		}
		Method method = action.getMethod(msg.getCmd());
		if (method == null) {
			if (action instanceof BaseGateAction) {
				((BaseGateAction) action).sendForward2Logic(msg.getRoleID(), msg.getContent());
				return msg.getRoleID();
			}
			log.error("error method {} cls {}", msg.getCmd(), msg.getContent().getClass().getSimpleName());
			return 0l;
		}
		if (method.getReturnType() == Long.class) {
			return (long) method.invoke(action, msg);
		} else {
			method.invoke(action, msg);
			return 0;
		}
	}
}
