package com.egeo.basics.user.service.read;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.DepartmentReadService;
import com.egeo.basics.user.business.read.DepartmentReadManage;
import com.egeo.basics.user.condition.DepartmentCondition;
import com.egeo.basics.user.converter.DepartmentConverter;
import com.egeo.basics.user.model.dto.DepartmentDTO;
import com.egeo.basics.user.po.DepartmentPO;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("departmentReadService")
public class DepartmentReadServiceImpl extends BaseService implements DepartmentReadService {
	@Autowired
	private DepartmentReadManage departmentReadManage;

	@Override
	public DepartmentDTO findDepartmentById(DepartmentDTO dto) {
		DepartmentPO po = DepartmentConverter.toPO(dto);
		DepartmentPO list = departmentReadManage.findDepartmentById(po);		
		return DepartmentConverter.toDTO(list);
	}

	@Override
	public PageResult<DepartmentDTO> findDepartmentOfPage(DepartmentDTO dto, Pagination page) {
		DepartmentPO po = DepartmentConverter.toPO(dto);
        PageResult<DepartmentPO> pageResult = departmentReadManage.findDepartmentOfPage(po, page);
        
        List<DepartmentDTO> list = DepartmentConverter.toDTO(pageResult.getList());
        PageResult<DepartmentDTO> result = new PageResult<DepartmentDTO>();
        result.setList(list);
        result.setPageNo(pageResult.getPageNo());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalSize(pageResult.getTotalSize());
        return result;
	}

	@Override
	public List<DepartmentDTO> findDepartmentAll(DepartmentDTO dto) {
		DepartmentPO po = DepartmentConverter.toPO(dto);
		List<DepartmentPO> list = departmentReadManage.findDepartmentAll(po);		
		return DepartmentConverter.toDTO(list);
	}
	/**
	 * 根据公司id递归查询所有部门信息
	 * @param vo
	 * @param req
	 * @return
	 */
	@Override
	public List<DepartmentDTO> recursionDepartmentAll(DepartmentDTO dto) {
		List<DepartmentDTO> DepartmentList = new ArrayList<DepartmentDTO>();
		List<DepartmentCondition> list = departmentReadManage.recursionDepartmentAll(DepartmentConverter.toPO(dto));
		for (DepartmentCondition departmentCondition : list) {
			DepartmentDTO departmentDTO = DepartmentConverter.toDTO(departmentCondition);
			departmentDTO.setpId(departmentCondition.getpId());
			DepartmentList.add(departmentDTO);
		}
		return DepartmentList;
	}
	/**
	 * 查询用户所在部门
	 * @param mpUserId
	 * @return
	 */
	@Override
	public DepartmentDTO queryDepartmentByUserId(Long mpUserId) {
		DepartmentPO departmentPO = departmentReadManage.queryDepartmentByUserId(mpUserId);
		return DepartmentConverter.toDTO(departmentPO);
	}

	@Override
	public List<DepartmentDTO> queryDepartmentByCompanyId(Long companyId) {
		return DepartmentConverter.toDTO(departmentReadManage.queryDepartmentByCompanyId(companyId));
	}
		
	/**
	 * 根据公司id机构id查询子部门信息
	 * @param vo
	 * @param req
	 * @return
	 */
	@Override
	public List<DepartmentDTO> departmentBydepartmentId(Long companyId, Long departmentId) {
		List<DepartmentDTO> DepartmentList = new ArrayList<DepartmentDTO>();
		List<DepartmentCondition> list = departmentReadManage.departmentBydepartmentId(companyId, departmentId);
		for (DepartmentCondition departmentCondition : list) {
			DepartmentDTO departmentDTO = DepartmentConverter.toDTO(departmentCondition);
			departmentDTO.setpId(departmentCondition.getpId());
			DepartmentList.add(departmentDTO);
		}
		return DepartmentList;
	}
}
	