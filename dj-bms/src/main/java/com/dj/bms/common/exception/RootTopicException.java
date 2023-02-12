package com.dj.bms.common.exception;

/**
 * 发布话题系统异常
 * @author zcq
 * 2018年5月8日
 * 上午12:33:53
 * TODO
 */
public class RootTopicException extends RuntimeException{

	public RootTopicException(String message, Throwable cause) {
		super(message, cause);
	}

	public RootTopicException(String message) {
		super(message);
	}

}
