package com.dj.servertool.module.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.module.entity.LoginLog;

/**
 * <p>
 * 登录记录 Mapper 接口
 * </p>
 */
public interface LoginLogMapper extends BaseMapper<LoginLog> {

	/**
	 * 获取登录日志
	 */
	@SuppressWarnings("rawtypes")
	List<Map<String, Object>> getLoginLogs(@Param("page") Page page, @Param("beginTime") String beginTime,
			@Param("endTime") String endTime, @Param("logName") String logName);
}
