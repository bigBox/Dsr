package com.dj.demo.thread;

import java.util.Date;
import java.util.concurrent.Callable;

import com.dj.domain.util.DateUtil;
import com.dj.domain.util.ThreadUtil;

public class XwCallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		int index = 0;
		while (true) {
			index++;
			System.out.println(DateUtil.formatDate(new Date(), DateUtil.STYLE4) + " => " + index);
			if(index >= 10) {
				break;
			}
			ThreadUtil.sleep(1000);
		}
		return index;
	}

}
