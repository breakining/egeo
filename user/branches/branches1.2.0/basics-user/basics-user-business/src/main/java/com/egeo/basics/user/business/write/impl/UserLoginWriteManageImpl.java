package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.UserLoginWriteManage;
import com.egeo.basics.user.dao.write.UserLoginWriteDAO;
import com.egeo.basics.user.po.UserLoginPO;

@Service
public class UserLoginWriteManageImpl implements UserLoginWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserLoginWriteDAO userLoginWriteDAO;
	@Override
	public void insertLoginLogWithTx(UserLoginPO po) {
		// TODO Auto-generated method stub
		userLoginWriteDAO.insert(po);
		
	}
	@Override
	public int updatePasswordUser(UserLoginPO po) {
		
		return userLoginWriteDAO.update(po);
	}
}
	