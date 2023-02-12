package com.dj.bms.modules.security.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.dao.BaseDao;
import com.dj.bms.common.dao.mapper.wrapper.query.QueryWrapper;
import com.dj.bms.common.service.impl.AbstractBaseServiceImpl;
import com.dj.bms.common.util.BeanUtils;
import com.dj.bms.common.util.CollectionUtils;
import com.dj.bms.common.util.StringUtils;
import com.dj.bms.modules.permission.dto.PermissionDTO;
import com.dj.bms.modules.permission.service.PermissionService;
import com.dj.bms.modules.security.dao.ResourceDao;
import com.dj.bms.modules.security.dto.PermissionResourceRelDTO;
import com.dj.bms.modules.security.dto.ResourceCategoryDTO;
import com.dj.bms.modules.security.dto.ResourceDTO;
import com.dj.bms.modules.security.model.Resource;
import com.dj.bms.modules.security.model.ResourceCategory;
import com.dj.bms.modules.security.model.PermissionResourceRel;
import com.dj.bms.modules.security.service.PermissionResourceRelService;
import com.dj.bms.modules.security.service.ResourceCategoryService;
import com.dj.bms.modules.security.service.ResourceService;

/**
 * 资源 Service Impl
 * 
 * @author zcq
 * @date 2020-03-13
 */
@Service
public class ResourceServiceImpl extends AbstractBaseServiceImpl<Resource, ResourceDTO> implements ResourceService {

	@Autowired
	private ResourceDao resourceDao;

	@Autowired
	private ResourceCategoryService resourceCategoryService;

	@Autowired
	private PermissionService permissionService;

	@Autowired
	private PermissionResourceRelService permissionResourceRelService;

	@Override
	public Function<? super ResourceDTO, ? extends Resource> getDTO2DOMapper() {
		return resourceDTO -> (Resource) BeanUtils.DTO2DO(resourceDTO, Resource.class);
	}

	@Override
	public Function<? super Resource, ? extends ResourceDTO> getDO2DTOMapper() {
		return resource -> {
			ResourceDTO resourceDTO = (ResourceDTO) BeanUtils.DO2DTO(resource, ResourceDTO.class);
			if (resourceDTO != null) {
				QueryWrapper<PermissionResourceRel> queryWrapper = new QueryWrapper<>();
				queryWrapper.eq("resource_id", resourceDTO.getResourceId());
				List<PermissionResourceRelDTO> permissionResourceRelDTOList = permissionResourceRelService
						.list(queryWrapper);
				List<String> permissionIdList = permissionResourceRelDTOList.stream().filter(Objects::nonNull)
						.map(p -> p.getPermissionId()).collect(Collectors.toList());
				if (CollectionUtils.isNotEmpty(permissionIdList)) {
					List<PermissionDTO> permissionDTOList = permissionService.listBatchIds(permissionIdList);
					resourceDTO.setPermissionDTOList(permissionDTOList);
				}
			}
			return resourceDTO;
		};
	}

	@Override
	public BaseDao<Resource> getDao() {
		return resourceDao;
	}

	@Override
	public Page<ResourceDTO> pageByNameAndCategoryName(Integer pageNumber, String resourceName,
			String resourceCategoryName) {
		Page<ResourceDTO> page = new Page<>(new ArrayList<>(), pageNumber, 25, 0);
		QueryWrapper<Resource> q1 = new QueryWrapper<>();
		if (StringUtils.notEmpty(resourceCategoryName)) {
			QueryWrapper<ResourceCategory> q2 = new QueryWrapper<>();
			q2.like("resource_category_name", resourceCategoryName);
			ResourceCategoryDTO resourceCategoryDTO = resourceCategoryService.getOne(q2);
			if (resourceCategoryDTO == null) {
				return null;
			}
			q1.eq("resource_category_id", resourceCategoryDTO.getResourceCategoryId());
		}
		if (StringUtils.notEmpty(resourceName)) {
			q1.like("resource_name", resourceName);
		}
		page = page(pageNumber, 25, q1);
		return page;
	}

}
