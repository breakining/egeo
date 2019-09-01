package com.egeo.basics.read.api.write;

import com.egeo.basics.read.model.dto.ReadRecommendDTO;


public interface ReadRecommendWriteService {

	public Long insertReadRecommendWithTx(ReadRecommendDTO dto);

	public int updateReadRecommendWithTx(ReadRecommendDTO dto);

	public int deleteReadRecommendWithTx(ReadRecommendDTO dto);
}
	