package com.egeo.basics.read.business.read;

import java.util.List;

import com.egeo.basics.read.po.ReadPraisePO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface ReadPraiseReadManage {

	public ReadPraisePO findReadPraiseById(ReadPraisePO po);

	public PageResult<ReadPraisePO> findReadPraiseOfPage(ReadPraisePO po,Pagination page);

	public List<ReadPraisePO> findReadPraiseAll(ReadPraisePO po);
}
	