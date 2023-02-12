package com.dj.servertool.module.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.module.entity.SiteCustomer;

public interface SiteCustomerMapper extends BaseMapper<SiteCustomer> {

	@SuppressWarnings("rawtypes")
	Page<Map<String, Object>> list(@Param("page") Page page, @Param("condition") String condition);

}
