package com.dj.bms.common.exception;

/**
 * 在 {@link BeanUtils} 类中遇到错误时可以抛出此异常
 * 
 * @author zcq
 * @date 2020-02-08
 */
@SuppressWarnings("serial")
public class FatalBeanException extends RuntimeException {

	public FatalBeanException(String msg) {
		super(msg);
	}

	public FatalBeanException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
