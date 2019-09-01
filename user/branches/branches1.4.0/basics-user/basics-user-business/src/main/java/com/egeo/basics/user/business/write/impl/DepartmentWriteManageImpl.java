package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.DepartmentWriteManage;
import com.egeo.basics.user.dao.write.DepartmentWriteDAO;
import com.egeo.basics.user.po.DepartmentPO;
import com.egeo.core.exception.BusinessException;

@Service
public class DepartmentWriteManageImpl implements DepartmentWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DepartmentWriteDAO departmentWriteDAO;

	@Override
	public Long insertDepartmentWithTx(DepartmentPO po) {
		
		int i ;
		try {
				i = departmentWriteDAO.insert(po);
				if (i == 0)
					throw new BusinessException("未能成功插入数据!");
			} catch (DuplicateKeyException e) {
				logger.error("", e);
				throw new BusinessException("路径必须唯一!");
			}
		return po.getId();
	}

	@Override
	public int updateDepartmentWithTx(DepartmentPO po) {
		int i;
		i = departmentWriteDAO.update(po);
		if (i == 0)
			throw new BusinessException("未能成功更新数据!");
		return i;
	}

	@Override
	public int deleteDepartmentWithTx(DepartmentPO po) {
		int i;
		i = departmentWriteDAO.delete(po);
		if (i == 0)
			throw new BusinessException("未能成功删除数据!");
		return i;
	}	
}
	