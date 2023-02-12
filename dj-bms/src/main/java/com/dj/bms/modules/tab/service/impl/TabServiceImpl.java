package com.dj.bms.modules.tab.service.impl;

import java.util.List;
import java.util.function.Function;

import com.dj.bms.modules.tab.service.TabService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.modules.tab.dao.TabDao;
import com.dj.bms.modules.tab.dto.TabDTO;
import com.dj.bms.modules.tab.model.Tab;

@Service
public class TabServiceImpl extends AbstractBaseServiceImpl<Tab, TabDTO> implements TabService {

	@Autowired
	private TabDao tabDao;
	
	/**
	 * 查询所有板块
	 */
	@Override
	public List<Tab> selectAll() {
		return tabDao.selectAll();
	}
	
	@Override
	public Function<? super TabDTO, ? extends Tab> getDTO2DOMapper() {
		return tabDTO -> {
			Tab tab = new Tab();
			BeanUtils.copyProperties(tabDTO, tab);
			return tab;
		};
	}
	
	@Override
	public Function<? super Tab, ? extends TabDTO> getDO2DTOMapper() {
		return tab -> {
			TabDTO tabDTO = new TabDTO();
			BeanUtils.copyProperties(tab, tabDTO);
			return tabDTO;
		};
	}

	@Override
	public BaseDao<Tab> getDao() {
		return tabDao;
	}

}
