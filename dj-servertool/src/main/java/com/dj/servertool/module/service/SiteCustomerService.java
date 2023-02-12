package com.dj.servertool.module.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.servertool.core.common.page.LayuiPageFactory;
import com.dj.servertool.module.entity.SiteCustomer;
import com.dj.servertool.module.mapper.SiteCustomerMapper;

@Service
public class SiteCustomerService extends ServiceImpl<SiteCustomerMapper, SiteCustomer> {

	@SuppressWarnings("rawtypes")
	public Page<Map<String, Object>> list(String condition) {
		Page page = LayuiPageFactory.defaultPage();
		return this.baseMapper.list(page, condition);
	}
}
