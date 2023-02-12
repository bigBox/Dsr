package com.dj.servertool.module.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.domain.log.LogResource;

public interface LogResourceMapper extends BaseMapper<LogResource> {

	@SuppressWarnings("rawtypes")
	Page<Map<String, Object>> list(@Param("page") Page page, @Param("roleID") String roleID);

}
