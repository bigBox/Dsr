package com.dj.bms.modules.app.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.modules.app.dao.AppCategoryDao;
import com.dj.bms.modules.app.dto.AppCategoryDTO;
import com.dj.bms.modules.app.model.AppCategory;
import com.dj.bms.modules.app.service.AppCategoryService;

/**
 * 应用类别 Service Impl
 * 
 * @author zcq
 * @date 2020-03-08
 */
@Service
public class AppCategoryServiceImpl extends AbstractBaseServiceImpl<AppCategory, AppCategoryDTO> implements AppCategoryService {

	@Autowired
	private AppCategoryDao appCategoryDao;
	
	@Override
	public Function<? super AppCategoryDTO, ? extends AppCategory> getDTO2DOMapper() {
		return dto -> (AppCategory) BeanUtils.DTO2DO(dto, AppCategory.class);
	}

	@Override
	public Function<? super AppCategory, ? extends AppCategoryDTO> getDO2DTOMapper() {
		return entity -> (AppCategoryDTO) BeanUtils.DO2DTO(entity, AppCategoryDTO.class);
	}

	@Override
	public BaseDao<AppCategory> getDao() {
		return appCategoryDao;
	}

}
