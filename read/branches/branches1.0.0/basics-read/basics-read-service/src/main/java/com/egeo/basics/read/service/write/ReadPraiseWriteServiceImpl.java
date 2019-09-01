package com.egeo.basics.read.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.read.api.write.ReadPraiseWriteService;
import com.egeo.basics.read.business.write.ReadPraiseWriteManage;
import com.egeo.basics.read.converter.ReadPraiseConverter;
import com.egeo.basics.read.model.dto.ReadPraiseDTO;
import com.egeo.basics.read.po.ReadPraisePO;
import com.egeo.core.basics.service.BaseService;

@Service("readPraiseWriteService")
public class ReadPraiseWriteServiceImpl extends BaseService implements ReadPraiseWriteService {
	@Autowired
	private ReadPraiseWriteManage readPraiseWriteManage;

	@Override
	public Long insertReadPraiseWithTx(ReadPraiseDTO dto) {
		ReadPraisePO po = ReadPraiseConverter.toPO(dto);
		Long rt = readPraiseWriteManage.insertReadPraiseWithTx(po);		
		return rt;
	}

	@Override
	public int updateReadPraiseWithTx(ReadPraiseDTO dto) {
		ReadPraisePO po = ReadPraiseConverter.toPO(dto);
		int rt = readPraiseWriteManage.updateReadPraiseWithTx(po);		
		return rt;
	}

	@Override
	public int deleteReadPraiseWithTx(ReadPraiseDTO dto) {
		ReadPraisePO po = ReadPraiseConverter.toPO(dto);
		int rt = readPraiseWriteManage.deleteReadPraiseWithTx(po);		
		return rt;
	}
}
	