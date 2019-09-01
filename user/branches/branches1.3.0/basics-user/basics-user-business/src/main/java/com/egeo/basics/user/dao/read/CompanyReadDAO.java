package com.egeo.basics.user.dao.read;

import java.util.List;

import com.egeo.basics.user.po.CompanyPO;
import com.egeo.core.orm.BaseReadDAO;

public interface CompanyReadDAO extends BaseReadDAO<CompanyPO>{

	List<CompanyPO> companyByUserId(Long userId);

	List<CompanyPO> companyByUid(Long userId);
}
	