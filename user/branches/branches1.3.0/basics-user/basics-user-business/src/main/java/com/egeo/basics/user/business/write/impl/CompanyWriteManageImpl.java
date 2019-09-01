package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.CompanyWriteManage;
import com.egeo.basics.user.dao.write.CompanyWriteDAO;
import com.egeo.basics.user.po.CompanyPO;

@Service
public class CompanyWriteManageImpl implements CompanyWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CompanyWriteDAO companyWriteDAO;
	
	@Override
	public Long saveWithTx(CompanyPO po) {
		companyWriteDAO.insert(po);
		return po.getId();
	}

	@Override
	public Integer deleteById(CompanyPO po) {
		// TODO Auto-generated method stub
		return companyWriteDAO.delete(po);
	}
}
	