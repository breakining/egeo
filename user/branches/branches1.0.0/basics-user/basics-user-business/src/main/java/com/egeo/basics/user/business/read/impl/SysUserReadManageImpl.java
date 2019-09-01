package com.egeo.basics.user.business.read.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.SysUserReadManage;
import com.egeo.basics.user.dao.read.SysUserReadDAO;
import com.egeo.basics.user.po.SysUserPO;

@Service
public class SysUserReadManageImpl implements SysUserReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SysUserReadDAO sysUserReadDAO;
	@Override
	public List<SysUserPO> findAll(SysUserPO sysUserPO) {
		
		return sysUserReadDAO.findAll(sysUserPO);
	}
	
	
}
	