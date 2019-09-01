package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.RoleMenuWriteManage;
import com.egeo.basics.user.dao.write.RoleMenuWriteDAO;
import com.egeo.basics.user.po.RoleMenuPO;

@Service
public class RoleMenuWriteManageImpl implements RoleMenuWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RoleMenuWriteDAO roleMenuWriteDAO;
	@Override
	public String saveWithTx(RoleMenuPO po) {
		// TODO Auto-generated method stub
		return roleMenuWriteDAO.insert(po)+"";
	}
}
	