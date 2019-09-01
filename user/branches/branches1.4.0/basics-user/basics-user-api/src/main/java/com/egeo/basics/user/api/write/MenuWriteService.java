package com.egeo.basics.user.api.write;

import com.egeo.basics.user.model.dto.MenuDTO;

public interface MenuWriteService {

	String saveOrUpdateWithTx(MenuDTO dto,String userName);

	public void deleteWithTx(MenuDTO dto);
}
	