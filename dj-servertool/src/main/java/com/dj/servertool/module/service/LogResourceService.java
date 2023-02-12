package com.dj.servertool.module.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.domain.log.LogResource;
import com.dj.servertool.core.common.page.LayuiPageFactory;
import com.dj.servertool.module.mapper.LogResourceMapper;

@Service
public class LogResourceService extends ServiceImpl<LogResourceMapper, LogResource> {

	
	@SuppressWarnings("rawtypes")
	public Page<Map<String, Object>> list(String roleID) {
		Page page = LayuiPageFactory.defaultPage();
		return this.baseMapper.list(page, roleID);
	}
}
