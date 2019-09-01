package com.egeo.core.exception;

/**
 * 
 * @author shangguannan
 * @since 1.0
 * @version 1.0
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 2955679021722967354L;
	protected int code;

	public BusinessException(){
		this(-1, "unknow exception", null);
	}

	public BusinessException(String message){
		this(-1, message, null);
	}

	public BusinessException(int code, String message){
		this(code, message, null);
	}

	public BusinessException(Throwable t){
		this(-1, null, t);
	}

	public BusinessException(int code, Throwable t){
		this(code, null, t);
	}

	public BusinessException(int code, String message, Throwable t){
		super(message, t);
		setCode(code);
	}

	public BusinessException(String message, Throwable t){
		super(message, t);
		setCode(-1);
	}

	@Override
	public String getMessage() {
		if (null == super.getMessage()) {
			if (super.getCause() != null)
				return super.getCause().getMessage();
		}
		return super.getMessage();
	}

	protected void setCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	@Override
	public String toString() {
		String message = getLocalizedMessage();
		StringBuilder s = new StringBuilder();
		s.append(getClass().getName());
		s.append(":");
		s.append(getCode());
		if (message != null) {
			s.append(", ");
			s.append(message);
		}
		return s.toString();
	}
}