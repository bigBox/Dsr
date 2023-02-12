package com.dj.bms.common.dao.jdbc.exceptions;

import com.dj.bms.core.io.Resource;
import com.dj.bms.common.dao.jdbc.util.ScriptUtils;

/**
 * 如果无法读取 SQL 脚本，则由 {@link ScriptUtils} 抛出此异常。
 * @author: zcq
 * @date: 2019-12-07
 */
@SuppressWarnings("serial")
public class CannotReadScriptException extends ScriptException {

	/**
	 * 创建新的实例 {@code CannotReadScriptException}
	 * @param resource 读取 SQL 脚本的资源
	 * @param cause 导致资源访问失败的根本原因
	 */
	public CannotReadScriptException(Resource resource, Throwable cause) {
		super("Cannot read SQL script from " + resource, cause);
	}

}
