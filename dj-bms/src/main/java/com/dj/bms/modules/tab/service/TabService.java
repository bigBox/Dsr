package com.dj.bms.modules.tab.service;

import java.util.List;

import com.dj.bms.common.service.BaseService;
import com.dj.bms.modules.tab.dto.TabDTO;
import com.dj.bms.modules.tab.model.Tab;

public interface TabService extends BaseService<Tab, TabDTO>{

	/**
	 * 查询所有板块
	 * @return
	 */
	List<Tab> selectAll();
}
