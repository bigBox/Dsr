package com.dj.bms.modules.topic.exception;

import com.dj.bms.common.exception.BaseException;
import com.dj.bms.modules.topic.enums.TopicErrorCodeEnum;

/**
 * @author zcq
 * @date 2020-01-20
 */
public class TopicException extends BaseException {
	
	private static final long serialVersionUID = 6328048966475096368L;
	
	public TopicException(TopicErrorCodeEnum topicErrorCodeEnum) {
		super(topicErrorCodeEnum.getHttpCode(), topicErrorCodeEnum.getErrorCode(), topicErrorCodeEnum.getMessage());
	}

	public TopicException(int httpCode, String errorCode, String message) {
		super(httpCode, errorCode, message);
	}
	
}
