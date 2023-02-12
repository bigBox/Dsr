package com.dj.servertool.module.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.SqlRunner;
import com.dj.servertool.core.common.annotion.BussinessLog;
import com.dj.servertool.core.common.annotion.Permission;
import com.dj.servertool.core.common.constant.Const;
import com.dj.servertool.core.common.page.LayuiPageFactory;
import com.dj.servertool.module.service.LoginLogService;
import com.dj.servertool.module.warpper.LogWrapper;

import cn.stylefeng.roses.core.base.controller.BaseController;

/**
 * 日志管理的控制器
 */
@Controller
@RequestMapping("/loginLog")
public class LoginLogController extends BaseController {

	private static String PREFIX = "/modular/system/log/";

	@Autowired
	private LoginLogService loginLogService;

	/**
	 * 跳转到日志管理的首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "login_log.html";
	}

	/**
	 * 查询登录日志列表
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/list")
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public Object list(@RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,
			@RequestParam(required = false) String logName) {
		// 获取分页参数
		Page page = LayuiPageFactory.defaultPage();
		// 根据条件查询日志
		List<Map<String, Object>> result = loginLogService.getLoginLogs(page, beginTime, endTime, logName);
		page.setRecords(new LogWrapper(result).wrap());
		return LayuiPageFactory.createPageInfo(page);
	}

	/**
	 * 清空日志
	 */
	@BussinessLog("清空登录日志")
	@RequestMapping("/delLoginLog")
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public Object delLog() {
		SqlRunner.db().delete("delete from sys_login_log");
		return SUCCESS_TIP;
	}
}
