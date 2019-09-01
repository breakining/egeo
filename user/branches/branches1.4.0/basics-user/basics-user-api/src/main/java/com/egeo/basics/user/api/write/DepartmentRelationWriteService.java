package com.egeo.basics.user.api.write;

import com.egeo.basics.user.model.dto.DepartmentRelationDTO;


public interface DepartmentRelationWriteService {

	public Long insertDepartmentRelationWithTx(DepartmentRelationDTO dto);

	public int updateDepartmentRelationWithTx(DepartmentRelationDTO dto);

	public int deleteDepartmentRelationWithTx(DepartmentRelationDTO dto);
	/**
	 * 根据部门id删除部门关系表
	 * @param departmentRelationDTO
	 * @return
	 */
	public int deleteDepartmentRelationByDepartmentIdWithTx(DepartmentRelationDTO departmentRelationDTO);
}
	