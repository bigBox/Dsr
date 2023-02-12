package com.dj.bms.modules.permission.service.impl;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.modules.permission.dao.PermissionDao;
import com.dj.bms.modules.permission.dto.PermissionDTO;
import com.dj.bms.modules.permission.model.Permission;
import com.dj.bms.modules.permission.service.PermissionService;

/**
 * 权限 Service Impl
 * 
 * @author zcq
 * @date 2020-02-23
 */
@Service
public class PermissionServiceImpl extends AbstractBaseServiceImpl<Permission, PermissionDTO>
		implements PermissionService {

	@Autowired
	private PermissionDao permissionDao;

	@Override
	public Function<? super PermissionDTO, ? extends Permission> getDTO2DOMapper() {
		return permissionDTO -> (Permission) BeanUtils.DTO2DO(permissionDTO, Permission.class);
	}

	@Override
	public Function<? super Permission, ? extends PermissionDTO> getDO2DTOMapper() {
		return permission -> (PermissionDTO) BeanUtils.DO2DTO(permission, PermissionDTO.class);
	}

	@Override
	public BaseDao<Permission> getDao() {
		return permissionDao;
	}

}
