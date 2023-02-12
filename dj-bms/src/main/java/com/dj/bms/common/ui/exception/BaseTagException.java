package com.dj.bms.common.ui.exception;

import com.dj.bms.common.exception.BaseException;

/**
 * @author zcq
 * @date 2020-03-11
 */
@SuppressWarnings("serial")
public class BaseTagException extends BaseException {

	/**
	 * @param httpCode
	 * @param errorCode
	 * @param message
	 */
	public BaseTagException(int httpCode, String errorCode, String message) {
		super(httpCode, errorCode, message);
	}

}
