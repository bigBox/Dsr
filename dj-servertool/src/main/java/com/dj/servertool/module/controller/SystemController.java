package com.dj.servertool.module.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollectionUtil;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;
import cn.stylefeng.roses.kernel.model.exception.enums.CoreExceptionEnum;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.dj.define.ErrorIDOuterClass;
import com.dj.protobuf.gm.GmShutdownCmdReq;
import com.dj.protobuf.gm.GmShutdownCmdRsp;
import com.dj.servertool.config.properties.ToolProperties;
import com.dj.servertool.core.common.constant.DefaultAvatar;
import com.dj.servertool.core.common.constant.factory.ConstantFactory;
import com.dj.servertool.core.common.exception.BizExceptionEnum;
import com.dj.servertool.core.log.LogObjectHolder;
import com.dj.servertool.core.server.NettySocket;
import com.dj.servertool.core.shiro.ShiroKit;
import com.dj.servertool.core.shiro.ShiroUser;
import com.dj.servertool.module.entity.FileInfo;
import com.dj.servertool.module.entity.SiteNotice;
import com.dj.servertool.module.entity.User;
import com.dj.servertool.module.factory.UserFactory;
import com.dj.servertool.module.service.FileInfoService;
import com.dj.servertool.module.service.SiteNoticeService;
import com.dj.servertool.module.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * ???????????????
 */
@Controller
@RequestMapping("/system")
@Slf4j
public class SystemController extends BaseController {

	@Autowired
	private UserService userService;

	@Autowired
	private FileInfoService fileInfoService;

	@Autowired
	private SiteNoticeService noticeService;

	@Autowired
	private ToolProperties toolProperties;

	/**
	 * ???????????????
	 */
	@RequestMapping("/console")
	public String console() {
		return "/modular/frame/console.html";
	}

	/**
	 * ????????????
	 */
	@RequestMapping("/console2")
	public String console2() {
		return "/modular/frame/console2.html";
	}

	/**
	 * ????????????
	 */
	//@RequestMapping("/shutdown")
	//public String shutdown() {
	//	return "/modular/frame/shutdown.html";
	//}

	/**
	 * ?????????????????????
	 */
	@RequestMapping("/notice")
	public String hello() {
		List<SiteNotice> notices = noticeService.list();
		super.setAttr("noticeList", notices);
		return "/modular/frame/notice.html";
	}

	/**
	 * ?????????
	 */
	@RequestMapping("/welcome")
	public String welcome() {
		return "/modular/frame/welcome.html";
	}

	/**
	 * ????????????
	 */
	@RequestMapping("/theme")
	public String theme() {
		return "/modular/frame/theme.html";
	}

	/**
	 * ???????????????????????????
	 */
	@RequestMapping("/user_chpwd")
	public String chPwd() {
		return "/modular/frame/password.html";
	}

	/**
	 * ??????????????????
	 */
	@RequestMapping("/message")
	public String message() {
		return "/modular/frame/message.html";
	}

	/**
	 * ?????????????????????????????????
	 */
	@RequestMapping("/user_info")
	public String userInfo(Model model) {
		Long userId = ShiroKit.getUserNotNull().getId();
		User user = this.userService.getById(userId);
		model.addAllAttributes(BeanUtil.beanToMap(user));
		model.addAttribute("roleName", ConstantFactory.me().getRoleName(user.getRoleId()));
		model.addAttribute("deptName", ConstantFactory.me().getDeptName(user.getDeptId()));
		LogObjectHolder.me().set(user);
		return "/modular/frame/user_info.html";
	}

	/**
	 * ???????????????????????????
	 */
	@RequestMapping("/commonTree")
	public String deptTreeList(@RequestParam("formName") String formName, @RequestParam("formId") String formId,
			@RequestParam("treeUrl") String treeUrl, Model model) {
		if (ToolUtil.isOneEmpty(formName, formId, treeUrl)) {
			throw new RequestEmptyException("????????????????????????");
		}
		try {
			model.addAttribute("formName", URLDecoder.decode(formName, StandardCharsets.UTF_8.toString()));
			model.addAttribute("formId", URLDecoder.decode(formId, StandardCharsets.UTF_8.toString()));
			model.addAttribute("treeUrl", URLDecoder.decode(treeUrl, StandardCharsets.UTF_8.toString()));
		}catch (UnsupportedEncodingException ex){
			log.error(ex.toString());
		}
        return "/common/tree_dlg.html";
	}

	/**
	 * ????????????
	 */
	@RequestMapping("/uploadAvatar")
	@ResponseBody
	public Object uploadAvatar(@RequestParam String avatar) {
		if (ToolUtil.isEmpty(avatar)) {
			throw new RequestEmptyException("??????????????????");
		}
		avatar = avatar.substring(avatar.indexOf(",") + 1);
		fileInfoService.uploadAvatar(avatar);
		return SUCCESS_TIP;
	}

	/**
	 * ????????????
	 */
	@RequestMapping("/previewAvatar")
	@ResponseBody
	public Object previewAvatar(HttpServletResponse response) {
		ShiroUser currentUser = ShiroKit.getUser();
		if (currentUser == null) {
			throw new ServiceException(CoreExceptionEnum.NO_CURRENT_USER);
		}
		// ???????????????????????????id
		User user = userService.getById(currentUser.getId());
		String avatar = user.getAvatar();
		// ????????????id????????????????????????
		if (ToolUtil.isEmpty(avatar)) {
			avatar = DefaultAvatar.BASE_64_AVATAR;
		} else {
			FileInfo fileInfo = fileInfoService.getById(avatar);
			if (fileInfo == null) {
				avatar = DefaultAvatar.BASE_64_AVATAR;
			} else {
				avatar = fileInfo.getFileData();
			}
		}
		// ????????????????????????
		try {
			response.setContentType("image/jpeg");
			byte[] decode = Base64.decode(avatar);
			response.getOutputStream().write(decode);
		} catch (IOException e) {
			log.error("???????????????????????????", avatar);
			throw new ServiceException(CoreExceptionEnum.SERVICE_ERROR);
		}
		return null;
	}

	/**
	 * ????????????????????????
	 */
	@RequestMapping("/currentUserInfo")
	@ResponseBody
	public ResponseData getUserInfo() {
		ShiroUser currentUser = ShiroKit.getUser();
		if (currentUser == null) {
			throw new ServiceException(CoreExceptionEnum.NO_CURRENT_USER);
		}
		User user = userService.getById(currentUser.getId());
		Map<String, Object> map = UserFactory.removeUnSafeFields(user);
		HashMap<Object, Object> hashMap = CollectionUtil.newHashMap();
		hashMap.putAll(map);
		hashMap.put("roleName", ConstantFactory.me().getRoleName(user.getRoleId()));
		hashMap.put("deptName", ConstantFactory.me().getDeptName(user.getDeptId()));
		return ResponseData.success(hashMap);
	}

	/**
	 * layui???????????? ????????????????????????
	 */
	@RequestMapping(method = RequestMethod.POST, path = "/upload")
	@ResponseBody
	public ResponseData layuiUpload(@RequestPart("file") MultipartFile picture) {
		String pictureName = UUID.randomUUID().toString() + "." + ToolUtil.getFileSuffix(picture.getOriginalFilename());
		try {
			String fileSavePath = toolProperties.getFileUploadPath();
			picture.transferTo(new File(fileSavePath + pictureName));
		} catch (Exception e) {
			throw new ServiceException(BizExceptionEnum.UPLOAD_ERROR);
		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("fileId", IdWorker.getIdStr());
		return ResponseData.success(0, "????????????", map);
	}

	//@RequestMapping("/shutdown_server")
	//@ResponseBody
	//public ResponseData shutdownServer() {
	//	GmShutdownCmdReq.Builder req = GmShutdownCmdReq.newBuilder();
	//	req.setUser("admin");
	//	req.setPwd("123456");
	//	GmShutdownCmdRsp rsp = (GmShutdownCmdRsp) NettySocket.sendMsg(req.build());
	//	if(rsp.getErrorID() == ErrorIDOuterClass.ErrorID.OK) {
	//		return ResponseData.success("OK");
	//	}else {
	//		return ResponseData.error(rsp.getErrorID().toString());
	//	}
	//}
}
