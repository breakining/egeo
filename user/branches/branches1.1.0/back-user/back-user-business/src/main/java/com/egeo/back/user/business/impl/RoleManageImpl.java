package com.egeo.back.user.business.impl;
	

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.egeo.back.user.business.RoleManage;
import com.egeo.back.user.facade.RoleFacade;
import com.egeo.basics.user.model.dto.RoleDTO;


@Service("role")
public class RoleManageImpl implements RoleManage{

	
	@Resource(name="roleFacade")
	private RoleFacade roleFacade;

	@Override
	public List<RoleDTO> findRoleListByUserId(String id) {
		// TODO Auto-generated method stub
		return roleFacade.findRoleListByUserId(id);
	}
	


}
	