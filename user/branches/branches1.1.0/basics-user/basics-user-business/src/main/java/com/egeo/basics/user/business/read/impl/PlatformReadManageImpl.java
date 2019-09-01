package com.egeo.basics.user.business.read.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.PlatformReadManage;
import com.egeo.basics.user.dao.read.PlatformReadDAO;

@Service
public class PlatformReadManageImpl implements PlatformReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PlatformReadDAO platformReadDAO;

	
}
	