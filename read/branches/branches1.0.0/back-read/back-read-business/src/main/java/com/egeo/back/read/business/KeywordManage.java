package com.egeo.back.read.business;

import java.util.List;
	
import com.egeo.basics.read.model.dto.KeywordDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface KeywordManage {

	public KeywordDTO findKeywordById(KeywordDTO dto);	

	public PageResult<KeywordDTO> findKeywordOfPage(KeywordDTO dto,Pagination page);

	public List<KeywordDTO> findKeywordAll(KeywordDTO dto);

	Long insertKeywordWithTx(KeywordDTO dto);

	int updateKeywordWithTx(KeywordDTO dto);

	int deleteKeywordWithTx(KeywordDTO dto);
}
	