package com.egeo.back.user.business.impl;
	

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.egeo.back.user.business.UserExtendManage;
import com.egeo.back.user.facade.UserExtendFacade;
import com.egeo.basics.user.model.dto.UserExtendDTO;

@Service("userExtend")
public class UserExtendManageImpl implements UserExtendManage{

	
	@Resource(name="userExtendFacade")
	private UserExtendFacade userExtendFacade;

	@Override
	public UserExtendDTO findById(Long id) {
		// TODO Auto-generated method stub
		return userExtendFacade.findById(id);
	}
	
	
	


}
	