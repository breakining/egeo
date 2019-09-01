package com.egeo.back.read.business;

import java.util.List;

import com.egeo.basics.read.model.dto.ReadPraiseDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface ReadPraiseManage {

	public ReadPraiseDTO findReadPraiseById(ReadPraiseDTO dto);	

	public PageResult<ReadPraiseDTO> findReadPraiseOfPage(ReadPraiseDTO dto,Pagination page);

	public List<ReadPraiseDTO> findReadPraiseAll(ReadPraiseDTO dto);

	String insertReadPraiseWithTx(ReadPraiseDTO dto,Long commentTargetUserId);

	int updateReadPraiseWithTx(ReadPraiseDTO dto);

	int deleteReadPraiseWithTx(ReadPraiseDTO dto);
}
	