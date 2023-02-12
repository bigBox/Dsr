package com.dj.bms.modules.menu.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.modules.menu.dao.MenuDao;
import com.dj.bms.modules.menu.dto.MenuDTO;
import com.dj.bms.modules.menu.model.Menu;
import com.dj.bms.modules.menu.service.MenuService;

/**
 * 菜单接口实现
 * 
 * @author zcq
 * @date 2020-03-06
 */
@Service
public class MenuServiceImpl extends AbstractBaseServiceImpl<Menu, MenuDTO> implements MenuService {

	@Autowired
	private MenuDao sidebarDao;
	
	@Override
	public Function<? super MenuDTO, ? extends Menu> getDTO2DOMapper() {
		return sidebarDTO -> (Menu) BeanUtils.DTO2DO(sidebarDTO, Menu.class);
	}

	
	@Override
	public Function<? super Menu, ? extends MenuDTO> getDO2DTOMapper() {
		return sidebar -> (MenuDTO) BeanUtils.DO2DTO(sidebar, MenuDTO.class);
	}

	@Override
	public BaseDao<Menu> getDao() {
		return sidebarDao;
	}
	
}
