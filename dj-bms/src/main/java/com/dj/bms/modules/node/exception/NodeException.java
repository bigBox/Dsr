package com.dj.bms.modules.node.exception;

import com.dj.bms.common.exception.BaseException;
import com.dj.bms.modules.node.enums.NodeErrorCodeEnum;

/**
 * @author zcq
 * @date 2020-02-16
 */
@SuppressWarnings("serial")
public class NodeException extends BaseException {

	/**
	 * @param httpCode
	 * @param errorCode
	 * @param message
	 */
	public NodeException(NodeErrorCodeEnum nodeErrorCodeEnum) {
		super(nodeErrorCodeEnum.getHttpCode(), nodeErrorCodeEnum.getErrorCode(), nodeErrorCodeEnum.getMessage());
	}

	/**
	 * @param httpCode
	 * @param errorCode
	 * @param message
	 */
	public NodeException(int httpCode, String errorCode, String message) {
		super(httpCode, errorCode, message);
	}

}
