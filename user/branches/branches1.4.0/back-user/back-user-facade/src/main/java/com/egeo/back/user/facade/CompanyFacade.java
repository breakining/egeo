package com.egeo.back.user.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.read.CompanyReadService;
import com.egeo.basics.user.api.write.CompanyWriteService;
import com.egeo.basics.user.model.dto.CompanyDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Component
public class CompanyFacade {
	
	@Reference
	private CompanyReadService companyReadService;
	
	@Reference
	private CompanyWriteService companyWriteService;
	
	
	public CompanyDTO findCompanyById(CompanyDTO dto){
		
		return companyReadService.findCompanyById(dto);
	}

	public PageResult<CompanyDTO> findCompanyOfPage(CompanyDTO dto,Pagination page){
		
		return companyReadService.findCompanyOfPage(dto, page);
		
	}

	public List<CompanyDTO> findCompanyAll(CompanyDTO dto){
		
		return companyReadService.findCompanyAll(dto);
		
	}

	public Long insertCompanyWithTx(CompanyDTO dto){
		
		return companyWriteService.insertCompanyWithTx(dto);
	}

	public int updateCompanyWithTx(CompanyDTO dto){
		
		return companyWriteService.updateCompanyWithTx(dto);
	}

	public int deleteCompanyWithTx(CompanyDTO dto){
		
		return companyWriteService.deleteCompanyWithTx(dto);
		
	}

}
	