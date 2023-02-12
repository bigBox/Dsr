package com.dj.bms.common.exception;

/**
 * 注册用户系统异常
 * @author zcq
 * 2018年5月6日
 * 下午10:08:36
 * TODO
 */
public class RootUserException extends RuntimeException{

	public RootUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public RootUserException(String message) {
		super(message);
	}

}
