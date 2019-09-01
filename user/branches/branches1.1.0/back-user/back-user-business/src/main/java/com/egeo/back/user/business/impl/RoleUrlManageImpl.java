package com.egeo.back.user.business.impl;
	

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.egeo.back.user.business.RoleUrlManage;
import com.egeo.back.user.facade.RoleUrlFacade;

@Service("roleUrl")
public class RoleUrlManageImpl implements RoleUrlManage{

	
	@Resource(name="roleUrlFacade")
	private RoleUrlFacade roleUrlFacade;

	@Override
	public List<String> getUrlListByUserId(String userId) {
		// TODO Auto-generated method stub
		return roleUrlFacade.getUrlListByUserId(userId);
	}
	


}
	