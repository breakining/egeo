package com.egeo.basics.user.api.read;

import java.util.List;

import com.egeo.basics.user.model.dto.CompanyDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface CompanyReadService {

	PageResult<CompanyDTO> findPage(CompanyDTO dto, Pagination page);

	List<CompanyDTO> companyByUserId(Long userId);

	List<CompanyDTO> companyByUId(Long userId);
}
	