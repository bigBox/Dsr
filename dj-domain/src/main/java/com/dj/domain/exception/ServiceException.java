package com.dj.domain.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = -5091783078313747575L;

	private int errorCode;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable e) {
		super(e);
	}

	public ServiceException(String message, Throwable e) {
		super(message, e);
	}

	public ServiceException(String message, int errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public ServiceException(int errorCode) {
		this.errorCode = errorCode;
	}
}
