package com.egeo.basics.user.api.write;

import com.egeo.basics.user.model.dto.UserRoleDTO;

public interface UserRoleWriteService {

    String saveWithTx(UserRoleDTO userRoleDTO);

    String deleteWithTx(UserRoleDTO userRoleDTO);

}
	