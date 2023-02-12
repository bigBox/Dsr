package com.dj.bms.modules.role.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.common.util.CollectionUtils;
import com.dj.bms.modules.permission.dto.PermissionDTO;
import com.dj.bms.modules.permission.service.PermissionService;
import com.dj.bms.modules.role.dao.RoleDao;
import com.dj.bms.modules.role.dto.RoleDTO;
import com.dj.bms.modules.role.dto.RolePermissionRelDTO;
import com.dj.bms.modules.role.model.Role;
import com.dj.bms.modules.role.model.RolePermissionRel;
import com.dj.bms.modules.role.service.RolePermissionRelService;
import com.dj.bms.modules.role.service.RoleService;

/**
 * Role Service Impl
 * 
 * @author zcq
 * @date 2020-02-23
 */
@Service
public class RoleServiceImpl extends AbstractBaseServiceImpl<Role, RoleDTO> implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private RolePermissionRelService rolePermissionRelService;

	@Override
	public Function<? super RoleDTO, ? extends Role> getDTO2DOMapper() {
		return roleDTO -> (Role) BeanUtils.DTO2DO(roleDTO, Role.class);
	}

	@Override
	public Function<? super Role, ? extends RoleDTO> getDO2DTOMapper() {
		return role -> {
			RoleDTO roleDTO = (RoleDTO) BeanUtils.DO2DTO(role, RoleDTO.class);
			if (roleDTO != null) {
				QueryWrapper<RolePermissionRel> queryWrapper = new QueryWrapper<>();
				queryWrapper.eq("role_id", roleDTO.getRoleId());
				List<RolePermissionRelDTO> rolePermissionRelDTOs = this.rolePermissionRelService.list(queryWrapper);
				List<String> permissionIds = rolePermissionRelDTOs.stream().filter(Objects::nonNull)
						.map(dto -> dto.getPermissionId()).collect(Collectors.toList());
				if (CollectionUtils.isNotEmpty(permissionIds)) {
					List<PermissionDTO> permissionDTOs = this.permissionService.listBatchIds(permissionIds);
					roleDTO.setPermissionDTOs(permissionDTOs);
				}
			}
			return roleDTO;
		};
	}

	@Override
	public BaseDao<Role> getDao() {
		return roleDao;
	}

}
