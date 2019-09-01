package com.egeo.basics.user.business.read.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.RoleUrlReadManage;
import com.egeo.basics.user.dao.read.UrlReadDAO;

@Service
public class RoleUrlReadManageImpl implements RoleUrlReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UrlReadDAO urlReadDAO;
	@Override
	public List<String> getUrlListByUserId(Long userId) {
		// TODO Auto-generated method stub
		
		List<String> listUrl = urlReadDAO.getUrlListByUserId(userId);
		return listUrl;
	}
}
	