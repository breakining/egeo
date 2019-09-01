package com.egeo.basics.user.dao.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.egeo.basics.user.condition.DepartmentCondition;
import com.egeo.basics.user.po.DepartmentPO;
import com.egeo.core.orm.BaseReadDAO;

public interface DepartmentReadDAO extends BaseReadDAO<DepartmentPO>{
	/**
	 * 根据公司id递归查询所有部门信息
	 * @param vo
	 * @param req
	 * @return
	 */
	List<DepartmentCondition> recursionDepartmentAll(@Param("po")DepartmentPO po);

	List<DepartmentPO> queryDepartmentListByCompanyId(Long companyId);
	/**
	 * 查询用户所在部门
	 * @param mpUserId
	 * @return
	 */
	DepartmentPO queryDepartmentByUserId(Long mpUserId);
	/**
	 * 根据公司id机构id查询子部门信息
	 * @param vo
	 * @param req
	 * @return
	 */
	List<DepartmentCondition> departmentBydepartmentId(@Param("companyId")Long companyId, @Param("departmentId")Long departmentId);
}
	