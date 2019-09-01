package com.egeo.back.read.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.read.api.read.KeywordReadService;
import com.egeo.basics.read.api.write.KeywordWriteService;
import com.egeo.basics.read.model.dto.KeywordDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Component
public class KeywordFacade {
	
	@Reference
	private KeywordReadService keywordReadService;
	
	@Reference
	private KeywordWriteService keywordWriteService;
	
	
	public KeywordDTO findKeywordById(KeywordDTO dto){
		
		return keywordReadService.findKeywordById(dto);
	}

	public PageResult<KeywordDTO> findKeywordOfPage(KeywordDTO dto,Pagination page){
		
		return keywordReadService.findKeywordOfPage(dto, page);
		
	}

	public List<KeywordDTO> findKeywordAll(KeywordDTO dto){
		
		return keywordReadService.findKeywordAll(dto);
		
	}

	public Long insertKeywordWithTx(KeywordDTO dto){
		
		return keywordWriteService.insertKeywordWithTx(dto);
	}

	public int updateKeywordWithTx(KeywordDTO dto){
		
		return keywordWriteService.updateKeywordWithTx(dto);
	}

	public int deleteKeywordWithTx(KeywordDTO dto){
		
		return keywordWriteService.deleteKeywordWithTx(dto);
		
	}

}
	