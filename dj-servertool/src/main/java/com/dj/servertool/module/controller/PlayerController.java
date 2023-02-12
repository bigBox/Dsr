package com.dj.servertool.module.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dj.protobuf.gm.ReadItemReq;
import com.dj.protobuf.gm.ReadItemRsp;
import com.dj.protobuf.gm.ReadRoleReq;
import com.dj.protobuf.gm.ReadRoleRsp;
import com.dj.protobuf.gm.WriteRoleReq;
import com.dj.protobuf.gm.WriteRoleRsp;
import com.dj.servertool.core.common.exception.BizExceptionEnum;
import com.dj.servertool.core.common.page.LayuiPageFactory;
import com.dj.servertool.core.server.NettySocket;
import com.dj.servertool.module.model.PlayerRoleDto;
import com.dj.servertool.module.warpper.PlayerItemWrapper;

import cn.hutool.core.collection.CollectionUtil;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.reqres.response.ResponseData;
import cn.stylefeng.roses.core.util.ToolUtil;
import cn.stylefeng.roses.kernel.model.exception.RequestEmptyException;
import cn.stylefeng.roses.kernel.model.exception.ServiceException;

/**
 * @ClassName: PlayerController
 * @Description: 玩家管理控制器
 * @author zcq
 * @date 2019年7月17日
 */
@Controller
@RequestMapping("/player")
public class PlayerController extends BaseController {

	private String PREFIX = "/modular/player/";

	@RequestMapping("/role")
	public String role() {
		return PREFIX + "role.html";
	}

	@RequestMapping("/readRole")
	@ResponseBody
	public Object readRole(@RequestParam Long roleID) {
		if (ToolUtil.isEmpty(roleID)) {
			throw new RequestEmptyException();
		}
		ReadRoleReq.Builder req = ReadRoleReq.newBuilder();
		req.setRoleID(roleID);
		ReadRoleRsp rsp = (ReadRoleRsp) NettySocket.sendMsg(req.build());
		HashMap<Object, Object> hashMap = CollectionUtil.newHashMap(2);
		hashMap.put("roleInfo", NettySocket.parseMsg(rsp.getRoleInfo()));
		return ResponseData.success(hashMap);
	}

	@RequestMapping("/writeRole")
	@ResponseBody
	public Object writeRole(@Valid PlayerRoleDto dto, BindingResult result) {
		if (result.hasErrors()) {
			throw new ServiceException(BizExceptionEnum.REQUEST_NULL);
		}
		WriteRoleReq.Builder req = WriteRoleReq.newBuilder();
		req.setRoleID(dto.getRoleID());
		req.setRoleInfo(dto.toRoleInfo());
		WriteRoleRsp rsp = (WriteRoleRsp) NettySocket.sendMsg(req.build());
		HashMap<Object, Object> hashMap = CollectionUtil.newHashMap(2);
		hashMap.put("roleInfo", NettySocket.parseMsg(rsp.getRoleInfo()));
		return ResponseData.success(hashMap);
	}

	@RequestMapping("/item")
	public String item() {
		return PREFIX + "item.html";
	}

	@RequestMapping("/readItem")
	@ResponseBody
	public Object readItem(@RequestParam(required = false) Long roleID, @RequestParam(required = false) Integer col) {
		Page<Map<String, Object>> list = new Page<Map<String, Object>>();
		if (ToolUtil.isEmpty(roleID) || ToolUtil.isEmpty(col)) {
			return LayuiPageFactory.createPageInfo(list);
		}
		ReadItemReq.Builder req = ReadItemReq.newBuilder();
		req.setRoleID(roleID);
		req.setCol(col);
		ReadItemRsp rsp = (ReadItemRsp) NettySocket.sendMsg(req.build());
		List<Map<String, Object>> itemList = NettySocket.parseMsgs(rsp.getItemsList());
		list.setRecords(itemList);
		Page<Map<String, Object>> wrap = new PlayerItemWrapper(list).wrap();
		return LayuiPageFactory.createPageInfo(wrap);
	}
}
