package com.egeo.back.user.business;

import com.egeo.basics.user.model.dto.UserExtendDTO;

public interface UserExtendManage {
	
	UserExtendDTO findById(String id);
}
	