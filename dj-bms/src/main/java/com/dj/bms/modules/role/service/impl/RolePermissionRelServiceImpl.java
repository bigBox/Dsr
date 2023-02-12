package com.dj.bms.modules.role.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.modules.role.dao.RolePermissionRelDao;
import com.dj.bms.modules.role.dto.RolePermissionRelDTO;
import com.dj.bms.modules.role.model.RolePermissionRel;
import com.dj.bms.modules.role.service.RolePermissionRelService;

/**
 * 角色权限关联关系 Service Impl
 * 
 * @author zcq
 * @date 2020-02-23
 */
@Service
public class RolePermissionRelServiceImpl extends AbstractBaseServiceImpl<RolePermissionRel, RolePermissionRelDTO>
		implements RolePermissionRelService {

	@Autowired
	private RolePermissionRelDao rolePermissionRelDao;

	@Override
	public Function<? super RolePermissionRelDTO, ? extends RolePermissionRel> getDTO2DOMapper() {
		return dto -> (RolePermissionRel) BeanUtils.DTO2DO(dto, RolePermissionRel.class);
	}

	@Override
	public Function<? super RolePermissionRel, ? extends RolePermissionRelDTO> getDO2DTOMapper() {
		return entity -> (RolePermissionRelDTO) BeanUtils.DO2DTO(entity, RolePermissionRelDTO.class);
	}

	@Override
	public BaseDao<RolePermissionRel> getDao() {
		return rolePermissionRelDao;
	}

}
