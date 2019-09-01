package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.CompanyPO;

public interface CompanyWriteManage {

	Long saveWithTx(CompanyPO po);

	Integer deleteById(CompanyPO po);
}
	