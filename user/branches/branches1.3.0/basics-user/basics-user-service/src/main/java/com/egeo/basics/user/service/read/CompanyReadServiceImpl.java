package com.egeo.basics.user.service.read;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.CompanyReadService;
import com.egeo.basics.user.business.read.CompanyReadManage;
import com.egeo.basics.user.converter.CompanyConverter;
import com.egeo.basics.user.model.dto.CompanyDTO;
import com.egeo.basics.user.po.CompanyPO;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("companyReadService")
public class CompanyReadServiceImpl extends BaseService implements CompanyReadService {
	@Autowired
	private CompanyReadManage companyReadManage;

	@Override
	public PageResult<CompanyDTO> findPage(CompanyDTO dto, Pagination page) {
		CompanyPO po = CompanyConverter.toPO(dto);
        PageResult<CompanyPO> pageResult = companyReadManage.findPage(page, po);
        
        List<CompanyDTO> list = new ArrayList<CompanyDTO>();
        for (CompanyPO tmp : pageResult.getList()) {
            CompanyDTO companyDTO = CompanyConverter.toDTO(tmp);
            companyDTO.setName(tmp.getName());
                list.add(companyDTO);
        }
        PageResult<CompanyDTO> result = new PageResult<CompanyDTO>();
        result.setList(list);
        result.setPageNo(pageResult.getPageNo());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalSize(pageResult.getTotalSize());
        return result;
	}

	@Override
	public List<CompanyDTO> companyByUserId(Long userId) {
		List<CompanyPO> list = companyReadManage.companyByUserId(userId);
        List<CompanyPO> allCompany=companyReadManage.findAll(new CompanyPO());
        List<CompanyDTO> dto = CompanyConverter.toDTO(allCompany);
        //赋值available
        for(CompanyDTO CompanyDTO:dto){
        	CompanyDTO.setIsAvailable(0);
        	for(CompanyPO myPf:list){
        		if(CompanyDTO.getId().equals(myPf.getId())){
        		    CompanyDTO.setChecked(true);
        		}
        	}
        }
        return dto;
	}

	@Override
	public List<CompanyDTO> companyByUId(Long userId) {
		List<CompanyPO> list = companyReadManage.companyByUId(userId);
		return CompanyConverter.toDTO(list);
	}
}
	