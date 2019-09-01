package com.egeo.back.user.business;

import java.util.List;
	
import com.egeo.basics.user.model.dto.DepartmentRelationDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface DepartmentRelationManage {

	public DepartmentRelationDTO findDepartmentRelationById(DepartmentRelationDTO dto);	

	public PageResult<DepartmentRelationDTO> findDepartmentRelationOfPage(DepartmentRelationDTO dto,Pagination page);

	public List<DepartmentRelationDTO> findDepartmentRelationAll(DepartmentRelationDTO dto);

	Long insertDepartmentRelationWithTx(DepartmentRelationDTO dto);

	int updateDepartmentRelationWithTx(DepartmentRelationDTO dto);

	int deleteDepartmentRelationWithTx(DepartmentRelationDTO dto);
}
	