package com.dj.bms.modules.security.service;

import com.dj.bms.common.beans.Page;
import com.dj.bms.common.service.BaseService;
import com.dj.bms.modules.security.dto.ResourceDTO;
import com.dj.bms.modules.security.model.Resource;

/**
 * 资源 Service
 * 
 * @author zcq
 * @date 2020-03-13
 */
public interface ResourceService extends BaseService<Resource, ResourceDTO> {

	/**
	 * 根据资源名称或者资源类别名称查找资源
	 * 
	 * @param pageNumber 第几页
	 * @param resourceName 资源名称
	 * @param resourceCategoryName 资源类别名称
	 * @return 资源 Page
	 */
	Page<ResourceDTO> pageByNameAndCategoryName(Integer pageNumber, String resourceName, String resourceCategoryName);
	
}
