package com.egeo.basics.user.api.write;

import com.egeo.basics.user.model.dto.RoleMenuDTO;

public interface RoleMenuWriteService {
	public String saveWithTx(RoleMenuDTO dto);
}
	