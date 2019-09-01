package com.egeo.basics.user.api.read;


import java.util.List;
	
import com.egeo.basics.user.model.dto.DepartmentDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface DepartmentReadService {

	public DepartmentDTO findDepartmentById(DepartmentDTO dto);

	public PageResult<DepartmentDTO> findDepartmentOfPage(DepartmentDTO dto,Pagination page);

	public List<DepartmentDTO> findDepartmentAll(DepartmentDTO dto);
	/**
	 * 根据公司id递归查询所有部门信息
	 * @param vo
	 * @param req
	 * @return
	 */
	public List<DepartmentDTO> recursionDepartmentAll(DepartmentDTO dto);
	/**
	 * 查询用户所在部门
	 * @param mpUserId
	 * @return
	 */
	public DepartmentDTO queryDepartmentByUserId(Long mpUserId);
	/**
	 * 根据公司id机构id查询子部门信息
	 * @param vo
	 * @param req
	 * @return
	 */
	public List<DepartmentDTO> departmentBydepartmentId(Long companyId, Long departmentId);

	/**
	 * 根据公司所有部门
	 * @param companyId
	 * @return
	 */
	public List<DepartmentDTO> queryDepartmentByCompanyId(Long companyId);
}
	