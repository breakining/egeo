package com.egeo.basics.user.service.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.DepartmentRelationReadService;
import com.egeo.basics.user.business.read.DepartmentRelationReadManage;
import com.egeo.basics.user.converter.DepartmentRelationConverter;
import com.egeo.basics.user.model.dto.DepartmentRelationDTO;
import com.egeo.basics.user.po.DepartmentRelationPO;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("departmentRelationReadService")
public class DepartmentRelationReadServiceImpl extends BaseService implements DepartmentRelationReadService {
	@Autowired
	private DepartmentRelationReadManage departmentRelationReadManage;

	@Override
	public DepartmentRelationDTO findDepartmentRelationById(DepartmentRelationDTO dto) {
		DepartmentRelationPO po = DepartmentRelationConverter.toPO(dto);
		DepartmentRelationPO list = departmentRelationReadManage.findDepartmentRelationById(po);		
		return DepartmentRelationConverter.toDTO(list);
	}

	@Override
	public PageResult<DepartmentRelationDTO> findDepartmentRelationOfPage(DepartmentRelationDTO dto, Pagination page) {
		DepartmentRelationPO po = DepartmentRelationConverter.toPO(dto);
        PageResult<DepartmentRelationPO> pageResult = departmentRelationReadManage.findDepartmentRelationOfPage(po, page);
        
        List<DepartmentRelationDTO> list = DepartmentRelationConverter.toDTO(pageResult.getList());
        PageResult<DepartmentRelationDTO> result = new PageResult<DepartmentRelationDTO>();
        result.setList(list);
        result.setPageNo(pageResult.getPageNo());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalSize(pageResult.getTotalSize());
        return result;
	}

	@Override
	public List<DepartmentRelationDTO> findDepartmentRelationAll(DepartmentRelationDTO dto) {
		DepartmentRelationPO po = DepartmentRelationConverter.toPO(dto);
		List<DepartmentRelationPO> list = departmentRelationReadManage.findDepartmentRelationAll(po);		
		return DepartmentRelationConverter.toDTO(list);
	}
}
	