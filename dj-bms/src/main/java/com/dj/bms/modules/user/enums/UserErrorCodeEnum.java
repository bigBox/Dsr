package com.dj.bms.modules.user.enums;

/**
 * @author zcq
 * @date 2020-02-07
 */
public enum UserErrorCodeEnum {

	INVALIDATE_USER(404, "User.InvalidateUser", "无效的用户"),
	
	NOT_FOUND(404, "User.NotFound", "用户不存在");
	
	private int httpCode;

	private String errorCode;

	private String message;

	private UserErrorCodeEnum(int httpCode, String errorCode, String message) {
		this.httpCode = httpCode;
		this.errorCode = errorCode;
		this.message = message;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}
}
