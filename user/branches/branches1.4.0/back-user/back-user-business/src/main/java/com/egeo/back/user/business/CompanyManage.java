package com.egeo.back.user.business;

import java.util.List;
	
import com.egeo.basics.user.model.dto.CompanyDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface CompanyManage {

	public CompanyDTO findCompanyById(CompanyDTO dto);	

	public PageResult<CompanyDTO> findCompanyOfPage(CompanyDTO dto,Pagination page);

	public List<CompanyDTO> findCompanyAll(CompanyDTO dto);

	Long insertCompanyWithTx(CompanyDTO dto);

	int updateCompanyWithTx(CompanyDTO dto);

	int deleteCompanyWithTx(CompanyDTO dto);
}
	