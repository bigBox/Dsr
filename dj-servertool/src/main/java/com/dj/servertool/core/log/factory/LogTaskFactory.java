package com.dj.servertool.core.log.factory;

import java.util.TimerTask;
import com.dj.servertool.core.common.constant.state.LogSucceed;
import com.dj.servertool.core.common.constant.state.LogType;
import com.dj.servertool.module.entity.LoginLog;
import com.dj.servertool.module.entity.OperationLog;
import com.dj.servertool.module.mapper.LoginLogMapper;
import com.dj.servertool.module.mapper.OperationLogMapper;

import cn.stylefeng.roses.core.util.SpringContextHolder;
import cn.stylefeng.roses.core.util.ToolUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 日志操作任务创建工厂
 */
@Slf4j
public class LogTaskFactory {

	private static LoginLogMapper loginLogMapper = SpringContextHolder.getBean(LoginLogMapper.class);
	private static OperationLogMapper operationLogMapper = SpringContextHolder.getBean(OperationLogMapper.class);

	public static TimerTask loginLog(final Long userId, final String ip) {
		return new TimerTask() {
			@Override
			public void run() {
				try {
					LoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN, userId, null, ip);
					loginLogMapper.insert(loginLog);
				} catch (Exception e) {
					log.error("创建登录日志异常!", e);
				}
			}
		};
	}

	public static TimerTask loginLog(final String username, final String msg, final String ip) {
		return new TimerTask() {
			@Override
			public void run() {
				LoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN_FAIL, null, "账号:" + username + "," + msg,
						ip);
				try {
					loginLogMapper.insert(loginLog);
				} catch (Exception e) {
					log.error("创建登录失败异常!", e);
				}
			}
		};
	}

	public static TimerTask exitLog(final Long userId, final String ip) {
		return new TimerTask() {
			@Override
			public void run() {
				LoginLog loginLog = LogFactory.createLoginLog(LogType.EXIT, userId, null, ip);
				try {
					loginLogMapper.insert(loginLog);
				} catch (Exception e) {
					log.error("创建退出日志异常!", e);
				}
			}
		};
	}

	public static TimerTask bussinessLog(final Long userId, final String bussinessName, final String clazzName,
			final String methodName, final String msg) {
		return new TimerTask() {
			@Override
			public void run() {
				OperationLog operationLog = LogFactory.createOperationLog(LogType.BUSSINESS, userId, bussinessName,
						clazzName, methodName, msg, LogSucceed.SUCCESS);
				try {
					operationLogMapper.insert(operationLog);
				} catch (Exception e) {
					log.error("创建业务日志异常!", e);
				}
			}
		};
	}

	public static TimerTask exceptionLog(final Long userId, final Exception exception) {
		return new TimerTask() {
			@Override
			public void run() {
				String msg = ToolUtil.getExceptionMsg(exception);
				OperationLog operationLog = LogFactory.createOperationLog(LogType.EXCEPTION, userId, "", null, null,
						msg, LogSucceed.FAIL);
				try {
					operationLogMapper.insert(operationLog);
				} catch (Exception e) {
					log.error("创建异常日志异常!", e);
				}
			}
		};
	}
}
