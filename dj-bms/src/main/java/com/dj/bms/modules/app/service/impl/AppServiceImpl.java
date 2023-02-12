package com.dj.bms.modules.app.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.modules.app.dao.AppDao;
import com.dj.bms.modules.app.dto.AppDTO;
import com.dj.bms.modules.app.model.App;
import com.dj.bms.modules.app.service.AppService;

/**
 * 应用 Service 实现
 * 
 * @author zcq
 * @date 2020-03-08
 */
@Service
public class AppServiceImpl extends AbstractBaseServiceImpl<App, AppDTO> implements AppService {

	@Autowired
	private AppDao appDao;
	
	@Override
	public Function<? super AppDTO, ? extends App> getDTO2DOMapper() {
		return dto -> (App) BeanUtils.DTO2DO(dto, App.class);
	}

	@Override
	public Function<? super App, ? extends AppDTO> getDO2DTOMapper() {
		return entity -> (AppDTO) BeanUtils.DO2DTO(entity, AppDTO.class);
	}

	@Override
	public BaseDao<App> getDao() {
		return appDao;
	}
	
}
