package com.egeo.basics.user.service.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.read.RoleReadService;
import com.egeo.basics.user.business.read.RoleReadManage;
import com.egeo.basics.user.converter.RoleConverter;
import com.egeo.basics.user.model.dto.RoleDTO;
import com.egeo.basics.user.po.RolePO;

@Service("roleReadService")
public class RoleReadServiceImpl extends BaseService implements RoleReadService {
	@Autowired
	private RoleReadManage roleReadManage;

	@Override
	public List<RoleDTO> findRoleListByUserId(String id) {
		
		List<RolePO> poList = roleReadManage.findRoleListByUserId(id);
		if(poList != null && poList.size() > 0){
			return  RoleConverter.toDTO(poList);
		}
		return null;
	}
}
	