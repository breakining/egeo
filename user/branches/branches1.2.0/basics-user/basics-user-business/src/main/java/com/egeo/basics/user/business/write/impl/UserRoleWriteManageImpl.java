package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.UserRoleWriteManage;
import com.egeo.basics.user.dao.write.UserRoleWriteDAO;
import com.egeo.basics.user.po.UserPO;
import com.egeo.core.exception.BusinessException;

@Service
public class UserRoleWriteManageImpl implements UserRoleWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserRoleWriteDAO userRoleWriteDAO;
}
	