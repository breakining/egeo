package com.egeo.basics.read.api.write;

import com.egeo.basics.read.model.dto.TopicDTO;


public interface TopicWriteService {

	public Long insertTopicWithTx(TopicDTO dto);

	public int updateTopicWithTx(TopicDTO dto);

	public int deleteTopicWithTx(TopicDTO dto);
}
	