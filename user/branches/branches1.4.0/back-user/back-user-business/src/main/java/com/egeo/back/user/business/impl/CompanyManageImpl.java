package com.egeo.back.user.business.impl;
	

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.user.business.CompanyManage;
import com.egeo.back.user.facade.CompanyFacade;
import com.egeo.basics.user.model.dto.CompanyDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;
import com.egeo.utils.EmptyUtil;

@Service("company")
public class CompanyManageImpl implements CompanyManage{

	
	@Resource(name="companyFacade")
	private CompanyFacade companyFacade;

	@Override
	public CompanyDTO findCompanyById(CompanyDTO dto) {
		return companyFacade.findCompanyById(dto);
	}

	@Override
	public PageResult<CompanyDTO> findCompanyOfPage(CompanyDTO dto, Pagination page) {
		return companyFacade.findCompanyOfPage(dto, page);
	}

	@Override
	public List<CompanyDTO> findCompanyAll(CompanyDTO dto) {
		return companyFacade.findCompanyAll(dto);
	}

	@Override
	public Long insertCompanyWithTx(CompanyDTO dto) {
		CompanyDTO companyDTO = new CompanyDTO();
		companyDTO.setCompanyName(dto.getCompanyName());
		List<CompanyDTO> list = companyFacade.findCompanyAll(companyDTO);
		if(EmptyUtil.isNotEmpty(list)){
			throw new BusinessException("公司名称以存在");
		}
		return companyFacade.insertCompanyWithTx(dto);
	}

	@Override
	public int updateCompanyWithTx(CompanyDTO dto) {
		int i = 0;
		if(EmptyUtil.isEmpty(dto.getId())){
			insertCompanyWithTx(dto);
		}else{
			i = companyFacade.updateCompanyWithTx(dto);
		}
		return i;
	}

	@Override
	public int deleteCompanyWithTx(CompanyDTO dto) {
		return companyFacade.deleteCompanyWithTx(dto);
	}


}
	