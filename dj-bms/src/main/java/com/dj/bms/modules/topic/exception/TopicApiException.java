package com.dj.bms.modules.topic.exception;

import com.dj.bms.common.exception.BaseApiException;
import com.dj.bms.modules.topic.enums.TopicErrorCodeEnum;

/**
 * @author zcq
 * @date 2020-01-20
 */
public class TopicApiException extends BaseApiException {

	private static final long serialVersionUID = 7898949975288079587L;

	public TopicApiException(TopicErrorCodeEnum topicErrorCodeEnum) {
		super(topicErrorCodeEnum.getHttpCode(), topicErrorCodeEnum.getErrorCode(), topicErrorCodeEnum.getMessage());
	}

	public TopicApiException(int httpCode, String errorCode, String message) {
		super(httpCode, errorCode, message);
	}
	
}
