package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.UrlPO;

public interface UrlWriteManage {

	int save(UrlPO dto);
	
	int Update(UrlPO dto);

	void delete(UrlPO po);

}
	