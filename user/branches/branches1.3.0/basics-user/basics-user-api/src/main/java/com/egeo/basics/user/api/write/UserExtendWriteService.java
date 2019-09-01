package com.egeo.basics.user.api.write;

import com.egeo.basics.user.model.dto.UserExtendDTO;

public interface UserExtendWriteService {

    int saveWithTx(UserExtendDTO userExtendDTO);

    int updateWithTx(UserExtendDTO userExtendDTO);

	int deleteWithTx(UserExtendDTO userExtendDTO);
}
	