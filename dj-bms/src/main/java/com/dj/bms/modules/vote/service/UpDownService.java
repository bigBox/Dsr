package com.dj.bms.modules.vote.service;

import com.dj.bms.common.dto.DMLExecution;
import com.dj.bms.modules.vote.model.UpDown;

/**
 * 
 * @author zcq
 * 2018年8月11日
 * 上午11:45:13
 * TODO
 */
public interface UpDownService {

	/**
	 * 添加赞同或者反对的记录
	 * @param upDown
	 * @return
	 */
	DMLExecution save(UpDown upDown);
	
	/**
	 * 更新状态
	 * @param upDown
	 * @return
	 */
	DMLExecution update(UpDown upDown);
	
	/**
	 * 统计赞同或者反对的数量
	 * @param tid:主题ID
	 * @param upDown:0 反对 1 赞同
	 * @return
	 */
	int countUpOrDown(Integer tid,Integer upDown);
	
}
