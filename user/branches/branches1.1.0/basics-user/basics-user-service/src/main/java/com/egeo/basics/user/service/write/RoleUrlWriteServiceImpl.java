package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.write.RoleUrlWriteService;
import com.egeo.basics.user.business.write.RoleUrlWriteManage;

@Service("roleUrlWriteService")
public class RoleUrlWriteServiceImpl extends BaseService implements RoleUrlWriteService {
	@Autowired
	private RoleUrlWriteManage roleUrlWriteManage;
}
	