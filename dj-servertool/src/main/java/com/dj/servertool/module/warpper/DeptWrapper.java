package com.dj.servertool.module.warpper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.core.common.constant.factory.ConstantFactory;
import com.dj.servertool.core.util.DecimalUtil;

import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.page.PageResult;

/**
 * 部门列表的包装
 */
public class DeptWrapper extends BaseControllerWrapper {

	public DeptWrapper(Map<String, Object> single) {
		super(single);
	}

	public DeptWrapper(List<Map<String, Object>> multi) {
		super(multi);
	}

	public DeptWrapper(Page<Map<String, Object>> page) {
		super(page);
	}

	public DeptWrapper(PageResult<Map<String, Object>> pageResult) {
		super(pageResult);
	}

	@Override
	protected void wrapTheMap(Map<String, Object> map) {
		Long pid = DecimalUtil.getLong(map.get("pid"));

		if (ToolUtil.isEmpty(pid) || pid.equals(0L)) {
			map.put("pName", "--");
		} else {
			map.put("pName", ConstantFactory.me().getDeptName(pid));
		}
	}
}
