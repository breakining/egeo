package com.egeo.back.user.business;

import java.util.List;

import com.egeo.back.user.model.vo.CompanyVO;
import com.egeo.basics.user.model.dto.CompanyDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface CompanyManage {

	PageResult<CompanyDTO> findPage(CompanyVO vo, Pagination page);

	Long save(CompanyVO vo);

	Long upDate(CompanyVO vo);

	List<CompanyVO> companyByUserId(Long userId);

	Integer deleteById(CompanyVO companyVO);

	List<CompanyDTO> companyByUId(Long userId);
	

}
	