package com.egeo.basics.user.api.write;

import com.egeo.basics.user.model.dto.UrlDTO;

public interface UrlWriteService {

	int saveOrUpdateWithTx(UrlDTO dto);

	void deleteWithTx(UrlDTO dto);

}
	