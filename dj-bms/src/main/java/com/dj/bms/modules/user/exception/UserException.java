package com.dj.bms.modules.user.exception;

import com.dj.bms.common.exception.BaseException;
import com.dj.bms.modules.user.enums.UserErrorCodeEnum;

/**
 * @author zcq
 * @date 2020-02-07
 */
public class UserException extends BaseException {

	private static final long serialVersionUID = 8338114801006949591L;

	public UserException(UserErrorCodeEnum topicErrorCodeEnum) {
		super(topicErrorCodeEnum.getHttpCode(), topicErrorCodeEnum.getErrorCode(), topicErrorCodeEnum.getMessage());
	}

	public UserException(int httpCode, String errorCode, String message) {
		super(httpCode, errorCode, message);
	}

}