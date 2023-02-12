package com.dj.bms.modules.visit.service;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.dto.DMLExecution;
import com.dj.bms.modules.user.model.User;
import com.dj.bms.modules.visit.model.Visit;

/**
 * 
 * @author zcq
 * 2018年8月4日
 * 下午3:11:54
 * TODO
 */
public interface VisitService {

	/**
	 * 分页查询访问记录
	 * @param vid 被访问者ID
	 * @param pageNumber 当前页
	 * @param pageSize 每页显示的数据量
	 * @return
	 */
	Page<User> page(Integer vid, Integer pageNumber, Integer pageSize);
	
	/**
	 * 添加访问记录
	 * @param visit
	 * @return
	 */
	DMLExecution save(Visit visit);
	
	/**
	 * 被访问的次数
	 * @param vid
	 * @return
	 */
	int count(Integer vid);
	
}
