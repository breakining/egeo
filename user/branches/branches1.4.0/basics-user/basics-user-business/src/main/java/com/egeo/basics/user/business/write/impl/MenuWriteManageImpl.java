package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.MenuWriteManage;
import com.egeo.basics.user.dao.write.MenuWriteDAO;
import com.egeo.basics.user.po.MenuPO;

@Service
public class MenuWriteManageImpl implements MenuWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MenuWriteDAO menuWriteDAO;
	@Override
	public Long save(MenuPO po) {
		menuWriteDAO.insert(po);
		return po.getId();
	}
	public String Update(MenuPO po) {
		
		return menuWriteDAO.update(po)+"";
	}
	@Override
	public void deleteWithTx(MenuPO po) {
		menuWriteDAO.delete(po);
	}
}
	