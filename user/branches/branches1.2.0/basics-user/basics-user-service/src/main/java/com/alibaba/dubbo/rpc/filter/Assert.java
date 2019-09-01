package com.alibaba.dubbo.rpc.filter;

import com.egeo.core.exception.IllegalParameterException;

public class Assert {
	public static void notNull(Object obj, int code) {
		notNull(obj, code, "对象不能为空");
	}

	public static void notNull(Object obj, int code, String message) {
		if (obj == null)
			throw new IllegalParameterException(code, message);
	}
}
