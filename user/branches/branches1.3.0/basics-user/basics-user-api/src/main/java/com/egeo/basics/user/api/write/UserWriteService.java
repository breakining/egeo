package com.egeo.basics.user.api.write;


import com.egeo.basics.user.model.dto.UserCookieDTO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserExtendDTO;

public interface UserWriteService {

	int updateEncryptInfoByUserWithTx(UserDTO updUser);

	int updateUserInfoWithTx(UserDTO user);

	void deleteWithTx(UserDTO dto);
	
	String saveOrUpdateWithTx(UserDTO dto,UserExtendDTO userExtendDTO,UserCookieDTO userCookieDTO);

	

	
}
	