package com.egeo.basics.user.business.read.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.UrlReadManage;
import com.egeo.basics.user.dao.read.UrlReadDAO;
import com.egeo.basics.user.po.UrlPO;

@Service
public class UrlReadManageImpl implements UrlReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UrlReadDAO urlReadDAO;
	@Override
	public List<String> findAll() {
		// TODO Auto-generated method stub
		List<UrlPO> poList = urlReadDAO.findAll(new UrlPO());
		List<String> ls = new ArrayList<String>();
		for (UrlPO po:poList){
			ls.add(po.getUrl());
		}
		 return ls;
	}
	
}
	