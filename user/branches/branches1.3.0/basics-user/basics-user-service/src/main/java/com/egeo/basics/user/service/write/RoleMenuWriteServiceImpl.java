package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.write.RoleMenuWriteService;
import com.egeo.basics.user.business.write.RoleMenuWriteManage;
import com.egeo.basics.user.converter.RoleMenuConverter;
import com.egeo.basics.user.model.dto.RoleMenuDTO;
import com.egeo.core.basics.service.BaseService;

@Service("roleMenuWriteService")
public class RoleMenuWriteServiceImpl extends BaseService implements RoleMenuWriteService {
	@Autowired
	private RoleMenuWriteManage roleMenuWriteManage;
	
	 public String saveWithTx(RoleMenuDTO dto) {
		return roleMenuWriteManage.saveWithTx(RoleMenuConverter.toPO(dto));
	 }
}
	