package com.egeo.basics.read.api.write;

import com.egeo.basics.read.model.dto.KeywordDTO;


public interface KeywordWriteService {

	public Long insertKeywordWithTx(KeywordDTO dto);

	public int updateKeywordWithTx(KeywordDTO dto);

	public int deleteKeywordWithTx(KeywordDTO dto);
}
	