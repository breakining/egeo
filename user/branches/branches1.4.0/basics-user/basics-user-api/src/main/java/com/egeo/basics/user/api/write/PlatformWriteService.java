package com.egeo.basics.user.api.write;

import com.egeo.basics.user.model.dto.PlatformDTO;

public interface PlatformWriteService {

    int upDateWithTx(PlatformDTO dto);

    Integer deleteByIdWithTx(PlatformDTO dto);

    String saveWithTx(PlatformDTO dto);
}
	