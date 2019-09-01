package com.egeo.basics.read.api.read;


import java.util.List;
	
import com.egeo.basics.read.model.dto.KeywordDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface KeywordReadService {

	public KeywordDTO findKeywordById(KeywordDTO dto);

	public PageResult<KeywordDTO> findKeywordOfPage(KeywordDTO dto,Pagination page);

	public List<KeywordDTO> findKeywordAll(KeywordDTO dto);
}
	