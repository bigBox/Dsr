package com.dj.servertool.module.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.core.common.page.LayuiPageFactory;
import com.dj.servertool.module.service.LogLoginService;
import com.dj.servertool.module.service.LogResourceService;
import com.dj.servertool.module.warpper.LogLoginWrapper;
import com.dj.servertool.module.warpper.LogResourceWrapper;

import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;

/**
 * @ClassName: GameLogController
 * @Description: 游戏日志
 * @author zcq
 * @date 2019年7月25日
 */
@Controller
@RequestMapping("/gameLog")
public class GameLogController extends BaseController {

	private String PREFIX = "/modular/gameLog/";

	@Autowired
	private LogResourceService logResourceService;
	@Autowired
	private LogLoginService logLoginService;

	@RequestMapping("/resourceBill")
	public String resourceBill() {
		return PREFIX + "resourceBill.html";
	}

	@DataSource(name = "logdb")
	@RequestMapping(value = "/resourceBillList")
	@ResponseBody
	public Object resourceBillList(String roleID) {
		Page<Map<String, Object>> list = this.logResourceService.list(roleID);
		Page<Map<String, Object>> wrap = new LogResourceWrapper(list).wrap();
		return LayuiPageFactory.createPageInfo(wrap);
	}
	
	@RequestMapping("/loginDetail")
	public String loginDetail() {
		return PREFIX + "loginDetail.html";
	}
	
	@DataSource(name = "logdb")
	@RequestMapping(value = "/loginDetailList")
	@ResponseBody
	public Object loginDetailList(String roleID) {
		Page<Map<String, Object>> list = this.logLoginService.list(roleID);
		Page<Map<String, Object>> wrap = new LogLoginWrapper(list).wrap();
		return LayuiPageFactory.createPageInfo(wrap);
	}

}
