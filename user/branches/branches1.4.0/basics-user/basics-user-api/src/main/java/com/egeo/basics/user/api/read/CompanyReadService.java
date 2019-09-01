package com.egeo.basics.user.api.read;


import java.util.List;
	
import com.egeo.basics.user.model.dto.CompanyDTO;
import com.egeo.basics.user.model.dto.DepartmentDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface CompanyReadService {

	public CompanyDTO findCompanyById(CompanyDTO dto);

	public PageResult<CompanyDTO> findCompanyOfPage(CompanyDTO dto,Pagination page);

	public List<CompanyDTO> findCompanyAll(CompanyDTO dto);
	/**
	 * 根据companyId查询部门列表
	 * @param companyId
	 * @return
	 */
	public List<DepartmentDTO> queryDepartmentListByCompanyId(Long companyId);
}
	