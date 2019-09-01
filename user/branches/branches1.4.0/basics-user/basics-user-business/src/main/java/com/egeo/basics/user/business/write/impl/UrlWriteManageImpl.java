package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.UrlWriteManage;
import com.egeo.basics.user.dao.write.UrlWriteDAO;
import com.egeo.basics.user.po.UrlPO;

@Service
public class UrlWriteManageImpl implements UrlWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UrlWriteDAO urlWriteDAO;
	@Override
	public int save(UrlPO po) {
		
		return urlWriteDAO.insert(po);
	}
	public int Update(UrlPO po) {
		
		return urlWriteDAO.update(po);
	}
	@Override
	public void delete(UrlPO po) {
		urlWriteDAO.delete(po);
	}
}
	