package com.dj.servertool.module.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dj.servertool.module.entity.OperationLog;
import com.dj.servertool.module.mapper.OperationLogMapper;

/**
 * <p>
 * 操作日志 服务实现类
 * </p>
 */
@Service
public class OperationLogService extends ServiceImpl<OperationLogMapper, OperationLog> {

	/**
	 * 获取操作日志列表
	 */
	@SuppressWarnings("rawtypes")
	public List<Map<String, Object>> getOperationLogs(Page page, String beginTime, String endTime, String logName,
			String s) {
		return this.baseMapper.getOperationLogs(page, beginTime, endTime, logName, s);
	}

}
