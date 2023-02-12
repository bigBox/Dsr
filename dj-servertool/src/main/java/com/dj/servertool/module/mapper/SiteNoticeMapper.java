package com.dj.servertool.module.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.module.entity.SiteNotice;

public interface SiteNoticeMapper extends BaseMapper<SiteNotice> {

	@SuppressWarnings("rawtypes")
	Page<Map<String, Object>> list(@Param("page") Page page, @Param("condition") String condition);

}
