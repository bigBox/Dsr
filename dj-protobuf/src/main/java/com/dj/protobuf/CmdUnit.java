package com.dj.protobuf;

import com.google.protobuf.MessageLite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @ClassName: CmdUnit  
 * @Description: 消息单位
 * @author zcq 
 * @date 2020年4月21日
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CmdUnit {

	/**
	 * 消息类
	 */
	private Class<? extends MessageLite> cls;

	/**
	 * 服务器类型
	 */
	private ServerType serverType;

	/**
	 * 功能模块
	 */
	private Module module;

	/**
	 * 是否需要记录
	 */
	private boolean record = false;

	public CmdUnit(Class<? extends MessageLite> cls, ServerType serverType, Module module) {
		this.cls = cls;
		this.serverType = serverType;
		this.module = module;
	}
}
