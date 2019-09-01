package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.PlatformWriteManage;
import com.egeo.basics.user.dao.write.PlatformWriteDAO;

@Service
public class PlatformWriteManageImpl implements PlatformWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PlatformWriteDAO platformWriteDAO;
}
	