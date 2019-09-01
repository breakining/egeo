package com.egeo.core.exception;

/**
 * @author shangguannan
 * @since 1.0
 * @version 1.0
 */
public class NoStackException extends BusinessException {
	private static final long serialVersionUID = 143416817263945478L;

	public NoStackException(String message) {
		super(-1, message, null);
	}

	public NoStackException(int code, String message) {
		super(code, message, null);
	}

	@Override
	public Throwable fillInStackTrace() {
		return this;
	}
}
