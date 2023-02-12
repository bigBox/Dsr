package com.dj.servertool.module.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.core.common.annotion.BussinessLog;
import com.dj.servertool.core.common.constant.dictmap.DeleteDict;
import com.dj.servertool.core.common.constant.dictmap.NoticeMap;
import com.dj.servertool.core.common.constant.factory.ConstantFactory;
import com.dj.servertool.core.common.exception.BizExceptionEnum;
import com.dj.servertool.core.common.page.LayuiPageFactory;
import com.dj.servertool.core.log.LogObjectHolder;
import com.dj.servertool.module.entity.SiteNotice;
import com.dj.servertool.module.service.SiteNoticeService;
import com.dj.servertool.module.warpper.NoticeWrapper;

import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.mutidatasource.annotion.DataSource;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;

/**
 * 公告控制器
 */
@Controller
@RequestMapping("/notice")
public class SiteNoticeController extends BaseController {

	private String PREFIX = "/modular/site/notice/";

	@Autowired
	private SiteNoticeService noticeService;

	/**
	 * 跳转到公告列表首页
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "notice.html";
	}

	/**
	 * 跳转到添加公告
	 */
	@RequestMapping("/notice_add")
	public String noticeAdd() {
		return PREFIX + "notice_add.html";
	}

	/**
	 * 跳转到修改公告
	 */
	@DataSource(name = "sitedb")
	@RequestMapping("/notice_update/{id}")
	public String noticeUpdate(@PathVariable Long id, Model model) {
		SiteNotice notice = this.noticeService.getById(id);
		model.addAllAttributes(BeanUtil.beanToMap(notice));
		LogObjectHolder.me().set(notice);
		return PREFIX + "notice_edit.html";
	}

	/**
	 * 获取公告列表
	 */
	@DataSource(name = "sitedb")
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(String condition) {
		Page<Map<String, Object>> list = this.noticeService.list(condition);
		Page<Map<String, Object>> wrap = new NoticeWrapper(list).wrap();
		return LayuiPageFactory.createPageInfo(wrap);
	}

	/**
	 * 新增公告
	 */
	@DataSource(name = "sitedb")
	@RequestMapping(value = "/add")
	@ResponseBody
	@BussinessLog(value = "新增公告", key = "title", dict = NoticeMap.class)
	public Object add(SiteNotice notice) {
		if (ToolUtil.isOneEmpty(notice, notice.getTitle(), notice.getContent())) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		notice.setTime(new Date());
		this.noticeService.save(notice);
		return SUCCESS_TIP;
	}

	/**
	 * 删除公告
	 */
	@DataSource(name = "sitedb")
	@RequestMapping(value = "/delete")
	@ResponseBody
	@BussinessLog(value = "删除公告", key = "id", dict = DeleteDict.class)
	public Object delete(@RequestParam Long id) {
		// 缓存公告名称
		LogObjectHolder.me().set(ConstantFactory.me().getNoticeTitle(id));
		this.noticeService.removeById(id);
		return SUCCESS_TIP;
	}

	/**
	 * 修改公告
	 */
	@DataSource(name = "sitedb")
	@RequestMapping(value = "/update")
	@ResponseBody
	@BussinessLog(value = "修改公告", key = "title", dict = NoticeMap.class)
	public Object update(SiteNotice notice) {
		if (ToolUtil.isOneEmpty(notice, notice.getId(), notice.getTitle(), notice.getContent())) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		SiteNotice old = this.noticeService.getById(notice.getId());
		old.setTitle(notice.getTitle());
		old.setContent(notice.getContent());
		this.noticeService.updateById(old);
		return SUCCESS_TIP;
	}

}
