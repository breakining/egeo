package com.egeo.basics.user.api.read;

import com.egeo.basics.user.model.dto.UserExtendDTO;

public interface UserExtendReadService {

	UserExtendDTO findById(Long id);
}
	