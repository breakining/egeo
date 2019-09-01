package com.egeo.back.user.business;

import java.util.List;
import java.util.Map;

import com.egeo.back.user.model.vo.DepartmentVO;
import com.egeo.basics.user.model.dto.DepartmentDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface DepartmentManage {

	public Map<String, Object> findDepartmentById(DepartmentDTO dto);	

	public PageResult<DepartmentDTO> findDepartmentOfPage(DepartmentDTO dto,Pagination page);

	public List<DepartmentDTO> findDepartmentAll(DepartmentDTO dto);

	Long insertDepartmentWithTx(DepartmentDTO dto);

	int updateDepartmentWithTx(DepartmentDTO dto);

	int deleteDepartmentWithTx(DepartmentDTO dto);
	/**
	 * 根据公司id递归查询所有部门信息
	 * @param vo
	 * @param req
	 * @return
	 */
	public List<DepartmentVO> recursionDepartmentAll(DepartmentDTO dto);
	/**
	 * 根据公司id机构id查询子部门信息
	 * @param vo
	 * @param req
	 * @return
	 */
	public List<Map<String, Object>> departmentBydepartmentId(Long companyId, Long departmentId);
}
	