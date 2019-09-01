package com.egeo.back.user.business.impl;
	

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.egeo.back.user.business.UserManage;
import com.egeo.back.user.converter.UserConverter;
import com.egeo.back.user.facade.UserFacade;
import com.egeo.back.user.model.vo.UserVO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.core.exception.BusinessException;
import com.egeo.utils.str.StringUtils;

@Service("user")
public class UserManageImpl implements UserManage{

	
	@Resource(name="userFacade")
	private UserFacade userFacade;

	@Override
	public UserVO findUniqueUser(UserVO user) {
		
		String id ;
		
		if (StringUtils.isNotEmpty(user.getLoginName())
				|| StringUtils.isNotEmpty(user.getMail())
				|| StringUtils.isNotEmpty(user.getMobile()))
		{
			UserDTO dto= UserConverter.toDTO(user);
			return UserConverter.toVO(userFacade.findUniqueUser(dto));
		}else
		{
			throw new BusinessException("账号，邮箱，电话号码必须有一个");
		}
		
		
	}

	@Override
	public int updateEncryptInfoByUserWithTx(UserDTO updUser) {
		// TODO Auto-generated method stub
		
		return userFacade.updateEncryptInfoByUserWithTx(updUser);
	}

	@Override
	public UserDTO findUserByID(String userId) {
		// TODO Auto-generated method stub
		return userFacade.findUserByID(userId);
	}
	


}
	