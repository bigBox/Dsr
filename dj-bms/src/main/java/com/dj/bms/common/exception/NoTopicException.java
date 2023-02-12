package com.dj.bms.common.exception;

/**
 * 发布话题失败异常
 * @author zcq
 * 2018年5月8日
 * 上午12:17:54
 * TODO
 */
public class NoTopicException extends RuntimeException{

	public NoTopicException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoTopicException(String message) {
		super(message);
	}

}
