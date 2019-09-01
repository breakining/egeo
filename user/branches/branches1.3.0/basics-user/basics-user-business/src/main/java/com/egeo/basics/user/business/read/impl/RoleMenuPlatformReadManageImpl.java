package com.egeo.basics.user.business.read.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.RoleMenuPlatformReadManage;
import com.egeo.basics.user.dao.read.RoleMenuPlatformReadDAO;
import com.egeo.basics.user.po.UserPlatformPO;

@Service
public class RoleMenuPlatformReadManageImpl implements RoleMenuPlatformReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RoleMenuPlatformReadDAO roleMenuPlatformReadDAO;
	@Override
	public List<String> getMenuList(UserPlatformPO po) {
		// TODO Auto-generated method stub
		return roleMenuPlatformReadDAO.getMenuList(po);
	}
	
}
	