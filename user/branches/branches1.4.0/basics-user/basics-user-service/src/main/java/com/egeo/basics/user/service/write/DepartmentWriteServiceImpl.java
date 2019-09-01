package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.write.DepartmentWriteService;
import com.egeo.basics.user.business.write.DepartmentWriteManage;
import com.egeo.basics.user.converter.DepartmentConverter;
import com.egeo.basics.user.model.dto.DepartmentDTO;
import com.egeo.basics.user.po.DepartmentPO;

@Service("departmentWriteService")
public class DepartmentWriteServiceImpl extends BaseService implements DepartmentWriteService {
	@Autowired
	private DepartmentWriteManage departmentWriteManage;

	@Override
	public Long insertDepartmentWithTx(DepartmentDTO dto) {
		DepartmentPO po = DepartmentConverter.toPO(dto);
		Long rt = departmentWriteManage.insertDepartmentWithTx(po);		
		return rt;
	}

	@Override
	public int updateDepartmentWithTx(DepartmentDTO dto) {
		DepartmentPO po = DepartmentConverter.toPO(dto);
		int rt = departmentWriteManage.updateDepartmentWithTx(po);		
		return rt;
	}

	@Override
	public int deleteDepartmentWithTx(DepartmentDTO dto) {
		DepartmentPO po = DepartmentConverter.toPO(dto);
		int rt = departmentWriteManage.deleteDepartmentWithTx(po);		
		return rt;
	}
}
	