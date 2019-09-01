package com.egeo.basics.user.business.read.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.UserExtendReadManage;
import com.egeo.basics.user.dao.read.UserExtendReadDAO;
import com.egeo.basics.user.po.UserExtendPO;

@Service
public class UserExtendReadManageImpl implements UserExtendReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserExtendReadDAO userExtendReadDAO;
	@Override
	public UserExtendPO findById(String id) {
		// TODO Auto-generated method stub
		UserExtendPO po = new UserExtendPO();
		po.setId(id);
		return userExtendReadDAO.findById(po);
	}
	
}
	