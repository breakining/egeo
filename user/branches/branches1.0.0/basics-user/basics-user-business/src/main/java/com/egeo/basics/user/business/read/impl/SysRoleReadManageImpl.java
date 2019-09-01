package com.egeo.basics.user.business.read.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.SysRoleReadManage;
import com.egeo.basics.user.dao.read.SysRoleReadDAO;
import com.egeo.basics.user.po.SysRolePO;

@Service
public class SysRoleReadManageImpl implements SysRoleReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SysRoleReadDAO sysRoleReadDAO;
	@Override
	public List<SysRolePO> findAll(SysRolePO sysRolePO) {
		
		return sysRoleReadDAO.findAll(sysRolePO);
	}
	
}

	