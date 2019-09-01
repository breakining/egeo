package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.DepartmentRelationPO;


public interface DepartmentRelationWriteManage {

	Long insertDepartmentRelationWithTx(DepartmentRelationPO po);

	int updateDepartmentRelationWithTx(DepartmentRelationPO po);

	int deleteDepartmentRelationWithTx(DepartmentRelationPO po);
	/**
	 * 根据部门id删除部门关系表
	 * @param departmentRelationDTO
	 * @return
	 */
	int deleteDepartmentRelationByDepartmentIdWithTx(DepartmentRelationPO po);
}
	