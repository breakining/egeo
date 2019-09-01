package com.egeo.core.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThrowUtils {
	private static Logger logger = LoggerFactory.getLogger(ThrowUtils.class);

	public static void throwNoStackException(int code) throws NoStackException {
		throwNoStackException(code, "");
	}

	public static void throwNoStackException(int code, String message) throws NoStackException {
		logger.error("throw BusinessException with errorCode '" + code + "'");
		throw new NoStackException(code, "");
	}

	public static void throwBusinessException(int code) throws BusinessException {
		throwBusinessException(code, "");
	}

	public static void throwBusinessException(int code, String message) throws BusinessException {
		logger.error("throw BusinessException with errorCode '" + code + "'");
		throw new BusinessException(code, "");
	}

	public static void throwIllegalParameterException(int code) throws IllegalParameterException {
		throwIllegalParameterException(code, "");
	}

	public static void throwIllegalParameterException(int code, String message) throws IllegalParameterException {
		logger.error("throw IllegalParameterException with errorCode '" + code + "'");
		throw new IllegalParameterException(code, "");
	}
}
