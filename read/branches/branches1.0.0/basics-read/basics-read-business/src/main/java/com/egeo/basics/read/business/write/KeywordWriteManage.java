package com.egeo.basics.read.business.write;

import com.egeo.basics.read.po.KeywordPO;


public interface KeywordWriteManage {

	Long insertKeywordWithTx(KeywordPO po);

	int updateKeywordWithTx(KeywordPO po);

	int deleteKeywordWithTx(KeywordPO po);
}
	