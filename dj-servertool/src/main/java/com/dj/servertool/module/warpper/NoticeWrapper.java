package com.dj.servertool.module.warpper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;

public class NoticeWrapper extends BaseControllerWrapper {

	public NoticeWrapper(Map<String, Object> single) {
		super(single);
	}

	public NoticeWrapper(List<Map<String, Object>> multi) {
		super(multi);
	}

	public NoticeWrapper(Page<Map<String, Object>> page) {
		super(page);
	}

	public NoticeWrapper(PageResult<Map<String, Object>> pageResult) {
		super(pageResult);
	}

	@Override
	protected void wrapTheMap(Map<String, Object> map) {
//		Long creater = DecimalUtil.getLong(map.get("createUser"));
//		map.put("createrName", ConstantFactory.me().getUserNameById(creater));
	}
}
