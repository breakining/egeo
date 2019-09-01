package com.egeo.basics.read.dao.write;

import com.egeo.basics.read.po.ReadInformationPO;
import com.egeo.core.orm.BaseWriteDAO;

public interface ReadInformationWriteDAO extends BaseWriteDAO<ReadInformationPO> {
	/**
	 * 根据条件添加悦读信息记录
	 * @param readInformationDTO
	 * @return
	 */
	int insertReadInformationByPraiseWithTx(ReadInformationPO po);
}
	