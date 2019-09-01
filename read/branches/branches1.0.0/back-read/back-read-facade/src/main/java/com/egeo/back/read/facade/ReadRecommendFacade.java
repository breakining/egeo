package com.egeo.back.read.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.read.api.read.ReadRecommendReadService;
import com.egeo.basics.read.api.write.ReadRecommendWriteService;
import com.egeo.basics.read.model.dto.ReadRecommendDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Component
public class ReadRecommendFacade {
	
	@Reference
	private ReadRecommendReadService readRecommendReadService;
	
	@Reference
	private ReadRecommendWriteService readRecommendWriteService;
	
	
	public ReadRecommendDTO findReadRecommendById(ReadRecommendDTO dto){
		
		return readRecommendReadService.findReadRecommendById(dto);
	}

	public PageResult<ReadRecommendDTO> findReadRecommendOfPage(ReadRecommendDTO dto,Pagination page){
		
		return readRecommendReadService.findReadRecommendOfPage(dto, page);
		
	}

	public List<ReadRecommendDTO> findReadRecommendAll(ReadRecommendDTO dto){
		
		return readRecommendReadService.findReadRecommendAll(dto);
		
	}

	public Long insertReadRecommendWithTx(ReadRecommendDTO dto){
		
		return readRecommendWriteService.insertReadRecommendWithTx(dto);
	}

	public int updateReadRecommendWithTx(ReadRecommendDTO dto){
		
		return readRecommendWriteService.updateReadRecommendWithTx(dto);
	}

	public int deleteReadRecommendWithTx(ReadRecommendDTO dto){
		
		return readRecommendWriteService.deleteReadRecommendWithTx(dto);
		
	}

}
	