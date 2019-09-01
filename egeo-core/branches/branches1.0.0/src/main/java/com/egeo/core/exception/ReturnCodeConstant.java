package com.egeo.core.exception;


public enum ReturnCodeConstant {
	
	//返回码
    SUCCESS("0","成功"),
    // 这里99
    NOT_LOGIN("99","未登录或已过期，请登录！"),
    FAIL("100","失败"),
    INVALID_PARAM("101", "参数不合法"),
    INVALID_PARAM_REQUIRED("102", "缺少参数"),
    NO_PERMISSION("103", "没有权限！"),
		
	
	RUNTIME_EXCEPTION("999","系统异常");
	
	
	private String code;
	private String msg;
	
	private ReturnCodeConstant(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	public String getMsg(String desc) {
		return msg+":"+desc;
	}

	
}
