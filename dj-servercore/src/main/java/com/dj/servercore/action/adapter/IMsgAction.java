package com.dj.servercore.action.adapter;

import com.dj.servercore.task.msg.MyMsg;

public interface IMsgAction {
	
	void handler(MyMsg msg) throws Exception;
}
