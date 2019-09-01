package com.egeo.basics.user.api.write;

import com.egeo.basics.user.model.dto.UserExtendDTO;

public interface UserExtendWriteService {

    int save(UserExtendDTO userExtendDTO);

    int update(UserExtendDTO userExtendDTO);
}
	