package com.egeo.basics.user.business.read;

import java.util.List;

import com.egeo.basics.user.po.CompanyPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface CompanyReadManage {

	PageResult<CompanyPO> findPage(Pagination page, CompanyPO po);

	List<CompanyPO> findAll(CompanyPO companyPO);

	List<CompanyPO> companyByUserId(Long userId);

	List<CompanyPO> companyByUId(Long userId);
}
	