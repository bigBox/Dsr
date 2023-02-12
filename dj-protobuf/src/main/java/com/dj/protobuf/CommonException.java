package com.dj.protobuf;

import com.dj.protobuf.ErrorIDOuterClass.ErrorID;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CommonException extends RuntimeException {
	private static final long serialVersionUID = 4737362918831649913L;

	private ErrorID errorID;
	
	private String message;

	public CommonException(ErrorID errorID) {
		super(String.valueOf(errorID));
		this.errorID = errorID;
	}
	
	public CommonException(ErrorID errorID, String message) {
		super(String.valueOf(errorID));
		this.errorID = errorID;
		this.message = message;
	}

	public CommonException(ErrorID errorID, int value) {
		super(String.valueOf(errorID));
		this.errorID = errorID;
		this.message = String.valueOf(value);
	}

	public CommonException(ErrorID errorID, long value) {
		super(String.valueOf(errorID));
		this.errorID = errorID;
		this.message = String.valueOf(value);
	}

	public CommonException(Throwable t) {
		super(t);
	}
}
