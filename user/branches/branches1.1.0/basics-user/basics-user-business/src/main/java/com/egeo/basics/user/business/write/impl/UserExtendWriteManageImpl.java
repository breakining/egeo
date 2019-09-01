package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.UserExtendWriteManage;
import com.egeo.basics.user.dao.write.UserExtendWriteDAO;

@Service
public class UserExtendWriteManageImpl implements UserExtendWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserExtendWriteDAO userExtendWriteDAO;
}
	