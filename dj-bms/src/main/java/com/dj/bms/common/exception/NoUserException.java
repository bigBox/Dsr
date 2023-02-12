package com.dj.bms.common.exception;

/**
 * 注册失败异常
 * @author zcq
 * 2018年5月6日
 * 下午10:12:08
 * TODO
 */
public class NoUserException extends RuntimeException{

	public NoUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoUserException(String message) {
		super(message);
	}

}
