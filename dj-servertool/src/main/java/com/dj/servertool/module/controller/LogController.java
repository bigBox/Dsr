package com.dj.servertool.module.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.toolkit.SqlRunner;
import com.dj.servertool.core.common.annotion.BussinessLog;
import com.dj.servertool.core.common.annotion.Permission;
import com.dj.servertool.core.common.constant.Const;
import com.dj.servertool.core.common.constant.state.BizLogType;
import com.dj.servertool.core.common.page.LayuiPageFactory;
import com.dj.servertool.module.entity.OperationLog;
import com.dj.servertool.module.service.OperationLogService;
import com.dj.servertool.module.warpper.LogWrapper;

import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.roses.core.base.controller.BaseController;

/**
 * 日志管理的控制器
 */
@Controller
@RequestMapping("/log")
public class LogController extends BaseController {

	private static String PREFIX = "/modular/system/log/";

	@Autowired
	private OperationLogService operationLogService;

	/**
	 * 跳转到日志管理的首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "log.html";
	}

	/**
	 * 查询操作日志列表
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/list")
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public Object list(@RequestParam(required = false) String beginTime, @RequestParam(required = false) String endTime,
			@RequestParam(required = false) String logName, @RequestParam(required = false) Integer logType) {
		// 获取分页参数
		Page page = LayuiPageFactory.defaultPage();
		// 根据条件查询操作日志
		List<Map<String, Object>> result = operationLogService.getOperationLogs(page, beginTime, endTime, logName,
				BizLogType.valueOf(logType));
		page.setRecords(new LogWrapper(result).wrap());
		return LayuiPageFactory.createPageInfo(page);
	}

	/**
	 * 查询操作日志详情
	 */
	@RequestMapping("/detail/{id}")
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public Object detail(@PathVariable Long id) {
		OperationLog operationLog = operationLogService.getById(id);
		Map<String, Object> stringObjectMap = BeanUtil.beanToMap(operationLog);
		return super.warpObject(new LogWrapper(stringObjectMap));
	}

	/**
	 * 清空日志
	 */
	@BussinessLog(value = "清空业务日志")
	@RequestMapping("/delLog")
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public Object delLog() {
		SqlRunner.db().delete("delete from sys_operation_log");
		return SUCCESS_TIP;
	}
}
