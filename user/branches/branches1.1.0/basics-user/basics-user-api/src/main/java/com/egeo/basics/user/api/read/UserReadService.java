package com.egeo.basics.user.api.read;

import com.egeo.basics.user.model.dto.UserDTO;

public interface UserReadService {
	
	UserDTO findUniqueUser(UserDTO dto);

	UserDTO findUserByID(String userId);
}
	