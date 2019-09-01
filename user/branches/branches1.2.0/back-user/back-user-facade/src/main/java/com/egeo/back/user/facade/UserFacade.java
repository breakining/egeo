package com.egeo.back.user.facade;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.read.UserReadService;
import com.egeo.basics.user.api.write.UserWriteService;
import com.egeo.basics.user.model.dto.UserCookieDTO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;



@Component
public class UserFacade {
	
	@Reference
	private static UserReadService userReadService;
	
	@Reference
	private UserWriteService userWriteService;
	

	public UserDTO findUniqueUser(UserDTO dto) {
		// TODO Auto-generated method stub
		return userReadService.findUniqueUser(dto);
	}

	public int updateEncryptInfoByUserWithTx(UserDTO updUser) {
		// TODO Auto-generated method stub
		return userWriteService.updateEncryptInfoByUserWithTx(updUser);
	}

	public UserDTO findUserByID(Long userId) {
		// TODO Auto-generated method stub
		return userReadService.findUserByID(userId);
	}

	

	
	public int updateUserInfo(UserDTO user) {
	
		return  userWriteService. updateUserInfo(user);
	}

	public static PageResult<UserDTO> findPage(Pagination page,UserDTO dto,UserExtendDTO userExtendDTO,UserCookieDTO userCookieDTO) {
		
		return userReadService.findPage(page,dto,userExtendDTO,userCookieDTO);
		
	}

	public String saveOrUpdate(UserDTO dto,UserExtendDTO userExtendDTO,UserCookieDTO userCookieDTO) {
		return userWriteService.saveOrUpdateWithTx(dto,userExtendDTO,userCookieDTO);
		
	}

	public void deleteWithTx(UserDTO dto) {
		userWriteService.deleteWithTx(dto);
		
	}
	

	

}
	