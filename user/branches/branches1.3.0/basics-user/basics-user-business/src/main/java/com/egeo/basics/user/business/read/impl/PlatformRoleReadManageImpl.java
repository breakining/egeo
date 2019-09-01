package com.egeo.basics.user.business.read.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.PlatformRoleReadManage;
import com.egeo.basics.user.dao.read.PlatformRoleReadDAO;
import com.egeo.basics.user.po.PlatformRolePO;

@Service
public class PlatformRoleReadManageImpl implements PlatformRoleReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PlatformRoleReadDAO platformRoleReadDAO;
	@Override
	public List<PlatformRolePO> findAll(PlatformRolePO platformRolePO) {

		return platformRoleReadDAO.findAll(platformRolePO);
	}
	
}
	