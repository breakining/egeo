package com.egeo.basics.user.business.read;

import java.util.List;
	
import com.egeo.basics.user.po.DepartmentRelationPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface DepartmentRelationReadManage {

	public DepartmentRelationPO findDepartmentRelationById(DepartmentRelationPO po);

	public PageResult<DepartmentRelationPO> findDepartmentRelationOfPage(DepartmentRelationPO po,Pagination page);

	public List<DepartmentRelationPO> findDepartmentRelationAll(DepartmentRelationPO po);
}
	