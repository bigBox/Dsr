package com.dj.demo.thread;

import java.util.Date;

import com.dj.domain.util.DateUtil;
import com.dj.domain.util.ThreadUtil;

public class XwThread extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println(DateUtil.formatDate(new Date(), DateUtil.STYLE4));
			ThreadUtil.sleep(1000);
		}
	}
	
}
