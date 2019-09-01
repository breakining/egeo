package com.egeo.basics.user.util;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.egeo.core.common.SOAResult;
import com.egeo.core.exception.BusinessException;

/**
 * 
 * @author xiaping
 * @date 2016-08-18 18:00:02
 */
@Aspect
public class DubboAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());

	public DubboAspect(){
		logger.info("装载了dubbo切面程序");
	}

	@Around("execution(* com.egeo.basics.user.service.*..*.*(..))")
	public Object around(ProceedingJoinPoint jp) {
		boolean isSOAResult = false;
		try {
			logger.debug("", jp.getClass(), jp.getThis());
			MethodSignature signature = (MethodSignature) jp.getSignature();
			Method method = signature.getMethod();
			Class<?> clazz = method.getReturnType();
			if (SOAResult.class.equals(clazz)) {
				isSOAResult = true;
			}
			Object rs = jp.proceed();
			return rs;
		} catch (BusinessException e) {
			logger.error("" + jp.getTarget().getClass(), e);
			if (isSOAResult)
				return error(e.getCode(), e);
			else
				throw e;
		} catch (RuntimeException e) {
			logger.error("" + jp.getTarget().getClass(), e);
			if (isSOAResult)
				return error(-1, e);
			else
				throw e;
		} catch (Throwable e) {
			logger.error("" + jp.getTarget().getClass(), e);
			if (isSOAResult)
				return error(-1, e);
			else
				throw new RuntimeException(e.getMessage());
		}
	}

	private SOAResult<Object> error(int code, Throwable e) {
		SOAResult<Object> result = new SOAResult<Object>();
		result.setError(code, e.getMessage());
		return result;
	}
}

	