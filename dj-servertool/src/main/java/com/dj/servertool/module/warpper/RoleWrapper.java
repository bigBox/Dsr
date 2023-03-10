package com.dj.servertool.module.warpper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.core.common.constant.factory.ConstantFactory;
import com.dj.servertool.core.util.DecimalUtil;

import cn.stylefeng.roses.core.base.warpper.BaseControllerWrapper;
import cn.stylefeng.roses.kernel.model.page.PageResult;

/**
 * 角色列表的包装类
 */
public class RoleWrapper extends BaseControllerWrapper {

	public RoleWrapper(Map<String, Object> single) {
		super(single);
	}

	public RoleWrapper(List<Map<String, Object>> multi) {
		super(multi);
	}

	public RoleWrapper(Page<Map<String, Object>> page) {
		super(page);
	}

	public RoleWrapper(PageResult<Map<String, Object>> pageResult) {
		super(pageResult);
	}

	@Override
	protected void wrapTheMap(Map<String, Object> map) {
		map.put("pName", ConstantFactory.me().getSingleRoleName(DecimalUtil.getLong(map.get("pid"))));
		map.put("deptName", ConstantFactory.me().getDeptName(DecimalUtil.getLong(map.get("deptId"))));
	}

}
