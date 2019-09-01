package com.egeo.basics.read.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.read.api.write.ReadRecommendWriteService;
import com.egeo.basics.read.business.write.ReadRecommendWriteManage;
import com.egeo.basics.read.converter.ReadRecommendConverter;
import com.egeo.basics.read.model.dto.ReadRecommendDTO;
import com.egeo.basics.read.po.ReadRecommendPO;
import com.egeo.core.basics.service.BaseService;

@Service("readRecommendWriteService")
public class ReadRecommendWriteServiceImpl extends BaseService implements ReadRecommendWriteService {
	@Autowired
	private ReadRecommendWriteManage readRecommendWriteManage;

	@Override
	public Long insertReadRecommendWithTx(ReadRecommendDTO dto) {
		ReadRecommendPO po = ReadRecommendConverter.toPO(dto);
		Long rt = readRecommendWriteManage.insertReadRecommendWithTx(po);		
		return rt;
	}

	@Override
	public int updateReadRecommendWithTx(ReadRecommendDTO dto) {
		ReadRecommendPO po = ReadRecommendConverter.toPO(dto);
		int rt = readRecommendWriteManage.updateReadRecommendWithTx(po);		
		return rt;
	}

	@Override
	public int deleteReadRecommendWithTx(ReadRecommendDTO dto) {
		ReadRecommendPO po = ReadRecommendConverter.toPO(dto);
		int rt = readRecommendWriteManage.deleteReadRecommendWithTx(po);		
		return rt;
	}
}
	