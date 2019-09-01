package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.RoleMenuPlatformWriteManage;
import com.egeo.basics.user.dao.write.RoleMenuPlatformWriteDAO;

@Service
public class RoleMenuPlatformWriteManageImpl implements RoleMenuPlatformWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RoleMenuPlatformWriteDAO roleMenuPlatformWriteDAO;
}
	