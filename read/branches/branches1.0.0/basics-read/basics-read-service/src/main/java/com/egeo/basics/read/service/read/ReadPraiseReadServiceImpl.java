package com.egeo.basics.read.service.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.read.api.read.ReadPraiseReadService;
import com.egeo.basics.read.business.read.ReadPraiseReadManage;
import com.egeo.basics.read.converter.ReadPraiseConverter;
import com.egeo.basics.read.model.dto.ReadPraiseDTO;
import com.egeo.basics.read.po.ReadPraisePO;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("readPraiseReadService")
public class ReadPraiseReadServiceImpl extends BaseService implements ReadPraiseReadService {
	@Autowired
	private ReadPraiseReadManage readPraiseReadManage;

	@Override
	public ReadPraiseDTO findReadPraiseById(ReadPraiseDTO dto) {
		ReadPraisePO po = ReadPraiseConverter.toPO(dto);
		ReadPraisePO list = readPraiseReadManage.findReadPraiseById(po);		
		return ReadPraiseConverter.toDTO(list);
	}

	@Override
	public PageResult<ReadPraiseDTO> findReadPraiseOfPage(ReadPraiseDTO dto, Pagination page) {
		ReadPraisePO po = ReadPraiseConverter.toPO(dto);
        PageResult<ReadPraisePO> pageResult = readPraiseReadManage.findReadPraiseOfPage(po, page);
        
        List<ReadPraiseDTO> list = ReadPraiseConverter.toDTO(pageResult.getList());
        PageResult<ReadPraiseDTO> result = new PageResult<ReadPraiseDTO>();
        result.setList(list);
        result.setPageNo(pageResult.getPageNo());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalSize(pageResult.getTotalSize());
        return result;
	}
 
	@Override
	public List<ReadPraiseDTO> findReadPraiseAll(ReadPraiseDTO dto) {
		ReadPraisePO po = ReadPraiseConverter.toPO(dto);
		List<ReadPraisePO> list = readPraiseReadManage.findReadPraiseAll(po);		
		return ReadPraiseConverter.toDTO(list);
	}
}
	