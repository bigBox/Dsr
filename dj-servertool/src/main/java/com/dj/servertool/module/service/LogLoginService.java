package com.dj.servertool.module.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.domain.log.LogLogin;
import com.dj.servertool.core.common.page.LayuiPageFactory;
import com.dj.servertool.module.mapper.LogLoginMapper;

@Service
public class LogLoginService extends ServiceImpl<LogLoginMapper, LogLogin> {

	@SuppressWarnings("rawtypes")
	public Page<Map<String, Object>> list(String roleID) {
		Page page = LayuiPageFactory.defaultPage();
		return this.baseMapper.list(page, roleID);
	}
}
