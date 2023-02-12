package com.dj.bms.modules.security.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.modules.security.dao.ResourceCategoryDao;
import com.dj.bms.modules.security.dto.ResourceCategoryDTO;
import com.dj.bms.modules.security.model.ResourceCategory;
import com.dj.bms.modules.security.service.ResourceCategoryService;

/**
 * 资源类别 Service Impl
 * 
 * @author zcq
 * @date 2020-03-13
 */
@Service
public class ResourceCategoryServiceImpl extends AbstractBaseServiceImpl<ResourceCategory, ResourceCategoryDTO>
		implements ResourceCategoryService {

	@Autowired
	private ResourceCategoryDao resourceCategoryDao;

	@Override
	public Function<? super ResourceCategoryDTO, ? extends ResourceCategory> getDTO2DOMapper() {
		return dto -> (ResourceCategory) BeanUtils.DTO2DO(dto, ResourceCategory.class);
	}

	@Override
	public Function<? super ResourceCategory, ? extends ResourceCategoryDTO> getDO2DTOMapper() {
		return entity -> (ResourceCategoryDTO) BeanUtils.DO2DTO(entity, ResourceCategoryDTO.class);
	}

	@Override
	public BaseDao<ResourceCategory> getDao() {
		return resourceCategoryDao;
	}

}
