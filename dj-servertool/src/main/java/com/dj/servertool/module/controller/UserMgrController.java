package com.dj.servertool.module.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.servertool.config.properties.ToolProperties;
import com.dj.servertool.core.common.annotion.BussinessLog;
import com.dj.servertool.core.common.annotion.Permission;
import com.dj.servertool.core.common.constant.Const;
import com.dj.servertool.core.common.constant.dictmap.UserDict;
import com.dj.servertool.core.common.constant.factory.ConstantFactory;
import com.dj.servertool.core.common.constant.state.ManagerStatus;
import com.dj.servertool.core.common.exception.BizExceptionEnum;
import com.dj.servertool.core.common.page.LayuiPageFactory;
import com.dj.servertool.core.log.LogObjectHolder;
import com.dj.servertool.core.shiro.ShiroKit;
import com.dj.servertool.module.entity.User;
import com.dj.servertool.module.factory.UserFactory;
import com.dj.servertool.module.model.UserDto;
import com.dj.servertool.module.service.UserService;
import com.dj.servertool.module.warpper.UserWrapper;

import cn.hutool.core.collection.CollectionUtil;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.datascope.DataScope;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;

/**
 * ????????????????????????
 */
@Controller
@RequestMapping("/mgr")
public class UserMgrController extends BaseController {

	private static String PREFIX = "/modular/system/user/";

	@Autowired
	private ToolProperties toolProperties;

	@Autowired
	private UserService userService;

	/**
	 * ???????????????????????????????????????
	 */
	@RequestMapping("")
	public String index() {
		return PREFIX + "user.html";
	}

	/**
	 * ???????????????????????????????????????
	 */
	@RequestMapping("/user_add")
	public String addView() {
		return PREFIX + "user_add.html";
	}

	/**
	 * ???????????????????????????
	 */
	@Permission
	@RequestMapping("/role_assign")
	public String roleAssign(@RequestParam Long userId, Model model) {
		if (ToolUtil.isEmpty(userId)) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		model.addAttribute("userId", userId);
		return PREFIX + "user_roleassign.html";
	}

	/**
	 * ??????????????????????????????
	 */
	@Permission
	@RequestMapping("/user_edit")
	public String userEdit(@RequestParam Long userId) {
		if (ToolUtil.isEmpty(userId)) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		User user = this.userService.getById(userId);
		LogObjectHolder.me().set(user);
		return PREFIX + "user_edit.html";
	}

	/**
	 * ??????????????????
	 */
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public Object getUserInfo(@RequestParam Long userId) {
		if (ToolUtil.isEmpty(userId)) {
			throw new RequestEmptyException();
		}
		this.userService.assertAuth(userId);
		User user = this.userService.getById(userId);
		Map<String, Object> map = UserFactory.removeUnSafeFields(user);
		HashMap<Object, Object> hashMap = CollectionUtil.newHashMap();
		hashMap.putAll(map);
		hashMap.put("roleName", ConstantFactory.me().getRoleName(user.getRoleId()));
		hashMap.put("deptName", ConstantFactory.me().getDeptName(user.getDeptId()));
		return ResponseData.success(hashMap);
	}

	/**
	 * ???????????????????????????
	 */
	@RequestMapping("/changePwd")
	@ResponseBody
	public Object changePwd(@RequestParam("oldPassword") String oldPassword,
			@RequestParam("newPassword") String newPassword) {
		if (ToolUtil.isOneEmpty(oldPassword, newPassword)) {
			throw new RequestEmptyException();
		}
		this.userService.changePwd(oldPassword, newPassword);
		return SUCCESS_TIP;
	}

	/**
	 * ?????????????????????
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/list")
	@Permission
	@ResponseBody
	public Object list(@RequestParam(required = false) String name, @RequestParam(required = false) String timeLimit,
			@RequestParam(required = false) Long deptId) {
		// ??????????????????
		String beginTime = "";
		String endTime = "";
		if (ToolUtil.isNotEmpty(timeLimit)) {
			String[] split = timeLimit.split(" - ");
			beginTime = split[0];
			endTime = split[1];
		}
		if (ShiroKit.isAdmin()) {
			Page<Map<String, Object>> users = userService.selectUsers(null, name, beginTime, endTime, deptId);
			Page wrapped = new UserWrapper(users).wrap();
			return LayuiPageFactory.createPageInfo(wrapped);
		} else {
			DataScope dataScope = new DataScope(ShiroKit.getDeptDataScope());
			Page<Map<String, Object>> users = userService.selectUsers(dataScope, name, beginTime, endTime, deptId);
			Page wrapped = new UserWrapper(users).wrap();
			return LayuiPageFactory.createPageInfo(wrapped);
		}
	}

	/**
	 * ???????????????
	 */
	@RequestMapping("/add")
	@BussinessLog(value = "???????????????", key = "account", dict = UserDict.class)
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public ResponseData add(@Valid UserDto user, BindingResult result) {
		if (result.hasErrors()) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		this.userService.addUser(user);
		return SUCCESS_TIP;
	}

	/**
	 * ???????????????
	 */
	@RequestMapping("/edit")
	@BussinessLog(value = "???????????????", key = "account", dict = UserDict.class)
	@ResponseBody
	public ResponseData edit(@Valid UserDto user, BindingResult result) {
		if (result.hasErrors()) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		this.userService.editUser(user);
		return SUCCESS_TIP;
	}

	/**
	 * ?????????????????????????????????
	 */
	@RequestMapping("/delete")
	@BussinessLog(value = "???????????????", key = "userId", dict = UserDict.class)
	@Permission
	@ResponseBody
	public ResponseData delete(@RequestParam Long userId) {
		if (ToolUtil.isEmpty(userId)) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		this.userService.deleteUser(userId);
		return SUCCESS_TIP;
	}

	/**
	 * ?????????????????????
	 */
	@RequestMapping("/view/{userId}")
	@ResponseBody
	public User view(@PathVariable Long userId) {
		if (ToolUtil.isEmpty(userId)) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		this.userService.assertAuth(userId);
		return this.userService.getById(userId);
	}

	/**
	 * ????????????????????????
	 */
	@RequestMapping("/reset")
	@BussinessLog(value = "?????????????????????", key = "userId", dict = UserDict.class)
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public ResponseData reset(@RequestParam Long userId) {
		if (ToolUtil.isEmpty(userId)) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		this.userService.assertAuth(userId);
		User user = this.userService.getById(userId);
		user.setSalt(ShiroKit.getRandomSalt(5));
		user.setPassword(ShiroKit.md5(Const.DEFAULT_PWD, user.getSalt()));
		this.userService.updateById(user);
		return SUCCESS_TIP;
	}

	/**
	 * ????????????
	 */
	@RequestMapping("/freeze")
	@BussinessLog(value = "????????????", key = "userId", dict = UserDict.class)
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public ResponseData freeze(@RequestParam Long userId) {
		if (ToolUtil.isEmpty(userId)) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		// ???????????????????????????
		if (userId.equals(Const.ADMIN_ID)) {
			throw new ServiceException(BizExceptionEnum.CANT_FREEZE_ADMIN);
		}
		this.userService.assertAuth(userId);
		this.userService.setStatus(userId, ManagerStatus.FREEZED.getCode());
		return SUCCESS_TIP;
	}

	/**
	 * ??????????????????
	 */
	@RequestMapping("/unfreeze")
	@BussinessLog(value = "??????????????????", key = "userId", dict = UserDict.class)
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public ResponseData unfreeze(@RequestParam Long userId) {
		if (ToolUtil.isEmpty(userId)) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		this.userService.assertAuth(userId);
		this.userService.setStatus(userId, ManagerStatus.OK.getCode());
		return SUCCESS_TIP;
	}

	/**
	 * ????????????
	 */
	@RequestMapping("/setRole")
	@BussinessLog(value = "????????????", key = "userId,roleIds", dict = UserDict.class)
	@Permission(Const.ADMIN_NAME)
	@ResponseBody
	public ResponseData setRole(@RequestParam("userId") Long userId, @RequestParam("roleIds") String roleIds) {
		if (ToolUtil.isOneEmpty(userId, roleIds)) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		// ???????????????????????????
		if (userId.equals(Const.ADMIN_ID)) {
			throw new ServiceException(BizExceptionEnum.CANT_CHANGE_ADMIN);
		}
		this.userService.assertAuth(userId);
		this.userService.setRoles(userId, roleIds);
		return SUCCESS_TIP;
	}

	/**
	 * ????????????
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/upload")
	@ResponseBody
	public String upload(@RequestPart("file") MultipartFile picture) {
		String pictureName = UUID.randomUUID().toString() + "." + ToolUtil.getFileSuffix(picture.getOriginalFilename());
		try {
			String fileSavePath = toolProperties.getFileUploadPath();
			picture.transferTo(new File(fileSavePath + pictureName));
		} catch (Exception e) {
			throw new ServiceException(BizExceptionEnum.UPLOAD_ERROR);
		}
		return pictureName;
	}
}
