package com.egeo.basics.user.api.write;

import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserLoginDTO;

public interface UserLoginWriteService {

	void insertLoginLogWithTx(UserLoginDTO userLogin);

	
}
	