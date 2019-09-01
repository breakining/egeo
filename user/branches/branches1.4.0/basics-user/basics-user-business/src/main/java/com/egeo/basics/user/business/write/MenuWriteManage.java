package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.MenuPO;

public interface MenuWriteManage {

	Long save(MenuPO dto);
	
	String Update(MenuPO dto);

	void deleteWithTx(MenuPO po);
}
	