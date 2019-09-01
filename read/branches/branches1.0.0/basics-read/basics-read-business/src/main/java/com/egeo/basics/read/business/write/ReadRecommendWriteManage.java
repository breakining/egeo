package com.egeo.basics.read.business.write;

import com.egeo.basics.read.po.ReadRecommendPO;


public interface ReadRecommendWriteManage {

	Long insertReadRecommendWithTx(ReadRecommendPO po);

	int updateReadRecommendWithTx(ReadRecommendPO po);

	int deleteReadRecommendWithTx(ReadRecommendPO po);
}
	