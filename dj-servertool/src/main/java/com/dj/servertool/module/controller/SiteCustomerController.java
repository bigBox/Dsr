package com.dj.servertool.module.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.core.common.page.LayuiPageFactory;
import com.dj.servertool.module.service.SiteCustomerService;
import com.dj.servertool.module.warpper.NoticeWrapper;

import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;

/**
 * 公告控制器
 */
@Controller
@RequestMapping("/customer")
public class SiteCustomerController extends BaseController {

	private String PREFIX = "/modular/site/customer/";

	@Autowired
	private SiteCustomerService customerService;

	@RequestMapping("")
	public String index() {
		return PREFIX + "customer.html";
	}

	@DataSource(name = "sitedb")
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(String condition) {
		Page<Map<String, Object>> list = this.customerService.list(condition);
		Page<Map<String, Object>> wrap = new NoticeWrapper(list).wrap();
		return LayuiPageFactory.createPageInfo(wrap);
	}

}
