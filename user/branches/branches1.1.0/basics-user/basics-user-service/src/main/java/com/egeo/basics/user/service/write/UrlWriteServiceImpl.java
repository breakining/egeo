package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.write.UrlWriteService;
import com.egeo.basics.user.business.write.UrlWriteManage;

@Service("urlWriteService")
public class UrlWriteServiceImpl extends BaseService implements UrlWriteService {
	@Autowired
	private UrlWriteManage urlWriteManage;
}
	