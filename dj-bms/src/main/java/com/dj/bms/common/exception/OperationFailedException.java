package com.dj.bms.common.exception;

/**
 * 操作失败异常
 * @author zcq
 * 2018年5月9日
 * 下午6:13:16
 * TODO
 */
public class OperationFailedException extends RuntimeException{

	public OperationFailedException(String message, Throwable cause) {
		super(message, cause);
	}

	public OperationFailedException(String message) {
		super(message);
	}

}
