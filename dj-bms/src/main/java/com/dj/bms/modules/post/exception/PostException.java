package com.dj.bms.modules.post.exception;

import com.dj.bms.common.exception.BaseException;
import com.dj.bms.modules.post.enums.PostErrorCodeEnum;

/**
 * @author zcq
 * @date 2020-01-20
 */
public class PostException extends BaseException {
	
	private static final long serialVersionUID = 6328048966475096368L;
	
	public PostException(PostErrorCodeEnum topicErrorCodeEnum) {
		super(topicErrorCodeEnum.getHttpCode(), topicErrorCodeEnum.getErrorCode(), topicErrorCodeEnum.getMessage());
	}

	public PostException(int httpCode, String errorCode, String message) {
		super(httpCode, errorCode, message);
	}
	
}
