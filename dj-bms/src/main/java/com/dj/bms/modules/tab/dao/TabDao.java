package com.dj.bms.modules.tab.dao;

import java.util.List;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.modules.tab.model.Tab;

/**
 * 父板块数据接口
 * @author zcq
 * 2018年7月15日
 * 下午8:57:48
 * TODO
 */
public interface TabDao extends BaseDao<Tab>{

	/**
	 * 查询所有板块
	 * @return
	 */
	List<Tab> selectAll();
}
