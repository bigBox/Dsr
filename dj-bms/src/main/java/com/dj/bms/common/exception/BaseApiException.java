package com.dj.bms.common.exception;

import com.dj.bms.common.enums.BaseErrorCodeEnum;

/**
 * @author zcq
 * @date 2020-01-20
 */
public class BaseApiException extends BaseException {

	private static final long serialVersionUID = -8502351057054395297L;

	public BaseApiException(BaseErrorCodeEnum baseErrorCodeEnum) {
		super(baseErrorCodeEnum);
	}

	public BaseApiException(int httpCode, String errorCode, String message) {
		super(httpCode, errorCode, message);
	}

}
