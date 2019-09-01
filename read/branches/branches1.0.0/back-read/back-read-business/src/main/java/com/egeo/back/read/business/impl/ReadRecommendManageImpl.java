package com.egeo.back.read.business.impl;
	

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.read.business.ReadRecommendManage;
import com.egeo.back.read.facade.ReadRecommendFacade;
import com.egeo.basics.read.model.dto.ReadRecommendDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("readRecommend")
public class ReadRecommendManageImpl implements ReadRecommendManage{

	
	@Resource(name="readRecommendFacade")
	private ReadRecommendFacade readRecommendFacade;

	@Override
	public ReadRecommendDTO findReadRecommendById(ReadRecommendDTO dto) {
		return readRecommendFacade.findReadRecommendById(dto);
	}

	@Override
	public PageResult<ReadRecommendDTO> findReadRecommendOfPage(ReadRecommendDTO dto, Pagination page) {
		return readRecommendFacade.findReadRecommendOfPage(dto, page);
	}

	@Override
	public List<ReadRecommendDTO> findReadRecommendAll(ReadRecommendDTO dto) {
		return readRecommendFacade.findReadRecommendAll(dto);
	}

	@Override
	public Long insertReadRecommendWithTx(ReadRecommendDTO dto) {
		return readRecommendFacade.insertReadRecommendWithTx(dto);
	}

	@Override
	public int updateReadRecommendWithTx(ReadRecommendDTO dto) {
		return readRecommendFacade.updateReadRecommendWithTx(dto);
	}

	@Override
	public int deleteReadRecommendWithTx(ReadRecommendDTO dto) {
		return readRecommendFacade.deleteReadRecommendWithTx(dto);
	}


}
	