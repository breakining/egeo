package com.egeo.basics.user.api.write;

import com.egeo.basics.user.model.dto.UserInformationDTO;


public interface UserInformationWriteService {

	public Long insertUserInformationWithTx(UserInformationDTO dto);

	public int updateUserInformationWithTx(UserInformationDTO dto);

	public int deleteUserInformationWithTx(UserInformationDTO dto);
}
	