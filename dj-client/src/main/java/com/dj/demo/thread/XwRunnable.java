package com.dj.demo.thread;

import java.util.Date;

import com.dj.domain.util.DateUtil;
import com.dj.domain.util.ThreadUtil;

public class XwRunnable implements Runnable {

	@Override
	public void run() {
		int index = 0;
		while (true) {
			index++;
			System.out.println(DateUtil.formatDate(new Date(), DateUtil.STYLE4) + " => " + index);
			if(index >= 10) {
				break;
			}
			ThreadUtil.sleep(1000);
		}
	}

}
