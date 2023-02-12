package com.dj.bms.modules.security.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.modules.security.dao.ResourceTypeDao;
import com.dj.bms.modules.security.dto.ResourceTypeDTO;
import com.dj.bms.modules.security.model.ResourceType;
import com.dj.bms.modules.security.service.ResourceTypeService;

/**
 * 资源类型 Service Impl
 * 
 * @author zcq
 * @date 2020-03-14
 */
@Service
public class ResourceTypeServiceImpl extends AbstractBaseServiceImpl<ResourceType, ResourceTypeDTO>
		implements ResourceTypeService {

	@Autowired
	private ResourceTypeDao resourceTypeDao;

	@Override
	public Function<? super ResourceTypeDTO, ? extends ResourceType> getDTO2DOMapper() {
		return dto -> (ResourceType) BeanUtils.DTO2DO(dto, ResourceType.class);
	}

	@Override
	public Function<? super ResourceType, ? extends ResourceTypeDTO> getDO2DTOMapper() {
		return entity -> (ResourceTypeDTO) BeanUtils.DO2DTO(entity, ResourceTypeDTO.class);
	}

	@Override
	public BaseDao<ResourceType> getDao() {
		return resourceTypeDao;
	}

}
