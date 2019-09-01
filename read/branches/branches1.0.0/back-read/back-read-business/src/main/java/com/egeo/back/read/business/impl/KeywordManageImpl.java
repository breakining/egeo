package com.egeo.back.read.business.impl;
	

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.egeo.back.read.business.KeywordManage;
import com.egeo.back.read.facade.KeywordFacade;
import com.egeo.basics.read.model.dto.KeywordDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("keyword")
public class KeywordManageImpl implements KeywordManage{

	
	@Resource(name="keywordFacade")
	private KeywordFacade keywordFacade;

	@Override
	public KeywordDTO findKeywordById(KeywordDTO dto) {
		return keywordFacade.findKeywordById(dto);
	}

	@Override
	public PageResult<KeywordDTO> findKeywordOfPage(KeywordDTO dto, Pagination page) {
		return keywordFacade.findKeywordOfPage(dto, page);
	}

	@Override
	public List<KeywordDTO> findKeywordAll(KeywordDTO dto) {
		return keywordFacade.findKeywordAll(dto);
	}

	@Override
	public Long insertKeywordWithTx(KeywordDTO dto) {
		return keywordFacade.insertKeywordWithTx(dto);
	}

	@Override
	public int updateKeywordWithTx(KeywordDTO dto) {
		return keywordFacade.updateKeywordWithTx(dto);
	}

	@Override
	public int deleteKeywordWithTx(KeywordDTO dto) {
		return keywordFacade.deleteKeywordWithTx(dto);
	}


}
	