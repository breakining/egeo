package com.egeo.basics.read.business.read;

import java.util.List;

import com.egeo.basics.read.condition.ReadInformationCondition;
import com.egeo.basics.read.po.ReadInformationPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface ReadInformationReadManage {

	public ReadInformationPO findReadInformationById(ReadInformationPO po);

	public PageResult<ReadInformationPO> findReadInformationOfPage(ReadInformationPO po,Pagination page);

	public List<ReadInformationPO> findReadInformationAll(ReadInformationPO po);
	/**
	 * 根据userId查询悦读未读消息数量
	 * @param userId
	 * @return
	 */
	public int cntById(Long userId);
	/**
	 * 根据userId查询悦读消息
	 * @param userId
	 * @return
	 */
	public PageResult<ReadInformationCondition> readInformationByUserId(ReadInformationPO po, Pagination page);
}
	