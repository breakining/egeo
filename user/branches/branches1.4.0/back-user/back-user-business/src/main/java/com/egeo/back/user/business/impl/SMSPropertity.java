package com.egeo.back.user.business.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service("sMSPropertity")
public class SMSPropertity {
	
	// 助信通账号
	@Value("${SHORT_MSG_ACCOUNT}")
	public static String SHORT_MSG_ACCOUNT;
	// 助信通密码
	@Value("${SHORT_MSG_ACCOUNT}")
	public static String SHORT_MSG_PWD;

}
