package com.dj.servertool.module.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.module.entity.OperationLog;

/**
 * <p>
 * 操作日志 Mapper 接口
 * </p>
 */
public interface OperationLogMapper extends BaseMapper<OperationLog> {

	/**
	 * 获取操作日志
	 */
	@SuppressWarnings("rawtypes")
	List<Map<String, Object>> getOperationLogs(@Param("page") Page page, @Param("beginTime") String beginTime,
			@Param("endTime") String endTime, @Param("logName") String logName, @Param("logType") String logType);

}
