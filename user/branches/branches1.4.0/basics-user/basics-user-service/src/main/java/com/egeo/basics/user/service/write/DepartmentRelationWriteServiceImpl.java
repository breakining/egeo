package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.write.DepartmentRelationWriteService;
import com.egeo.basics.user.business.write.DepartmentRelationWriteManage;
import com.egeo.basics.user.converter.DepartmentRelationConverter;
import com.egeo.basics.user.model.dto.DepartmentRelationDTO;
import com.egeo.basics.user.po.DepartmentRelationPO;

@Service("departmentRelationWriteService")
public class DepartmentRelationWriteServiceImpl extends BaseService implements DepartmentRelationWriteService {
	@Autowired
	private DepartmentRelationWriteManage departmentRelationWriteManage;

	@Override
	public Long insertDepartmentRelationWithTx(DepartmentRelationDTO dto) {
		DepartmentRelationPO po = DepartmentRelationConverter.toPO(dto);
		Long rt = departmentRelationWriteManage.insertDepartmentRelationWithTx(po);		
		return rt;
	}

	@Override
	public int updateDepartmentRelationWithTx(DepartmentRelationDTO dto) {
		DepartmentRelationPO po = DepartmentRelationConverter.toPO(dto);
		int rt = departmentRelationWriteManage.updateDepartmentRelationWithTx(po);		
		return rt;
	}

	@Override
	public int deleteDepartmentRelationWithTx(DepartmentRelationDTO dto) {
		DepartmentRelationPO po = DepartmentRelationConverter.toPO(dto);
		int rt = departmentRelationWriteManage.deleteDepartmentRelationWithTx(po);		
		return rt;
	}
	/**
	 * 根据部门id删除部门关系表
	 * @param departmentRelationDTO
	 * @return
	 */
	@Override
	public int deleteDepartmentRelationByDepartmentIdWithTx(DepartmentRelationDTO departmentRelationDTO) {
		
		return departmentRelationWriteManage.deleteDepartmentRelationByDepartmentIdWithTx(DepartmentRelationConverter.toPO(departmentRelationDTO));
	}
}
	