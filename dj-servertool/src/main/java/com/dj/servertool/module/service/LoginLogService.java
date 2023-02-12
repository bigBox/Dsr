package com.dj.servertool.module.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.servertool.module.entity.LoginLog;
import com.dj.servertool.module.mapper.LoginLogMapper;

/**
 * <p>
 * 登录记录 服务实现类
 * </p>
 */
@Service
public class LoginLogService extends ServiceImpl<LoginLogMapper, LoginLog> {

	/**
	 * 获取登录日志列表
	 */
	@SuppressWarnings("rawtypes")
	public List<Map<String, Object>> getLoginLogs(Page page, String beginTime, String endTime, String logName) {
		return this.baseMapper.getLoginLogs(page, beginTime, endTime, logName);
	}
}
