package com.egeo.basics.read.service.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.read.api.read.KeywordReadService;
import com.egeo.basics.read.business.read.KeywordReadManage;
import com.egeo.basics.read.converter.KeywordConverter;
import com.egeo.basics.read.model.dto.KeywordDTO;
import com.egeo.basics.read.po.KeywordPO;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("keywordReadService")
public class KeywordReadServiceImpl extends BaseService implements KeywordReadService {
	@Autowired
	private KeywordReadManage keywordReadManage;

	@Override
	public KeywordDTO findKeywordById(KeywordDTO dto) {
		KeywordPO po = KeywordConverter.toPO(dto);
		KeywordPO list = keywordReadManage.findKeywordById(po);		
		return KeywordConverter.toDTO(list);
	}

	@Override
	public PageResult<KeywordDTO> findKeywordOfPage(KeywordDTO dto, Pagination page) {
		KeywordPO po = KeywordConverter.toPO(dto);
        PageResult<KeywordPO> pageResult = keywordReadManage.findKeywordOfPage(po, page);
        
        List<KeywordDTO> list = KeywordConverter.toDTO(pageResult.getList());
        PageResult<KeywordDTO> result = new PageResult<KeywordDTO>();
        result.setList(list);
        result.setPageNo(pageResult.getPageNo());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalSize(pageResult.getTotalSize());
        return result;
	}

	@Override
	public List<KeywordDTO> findKeywordAll(KeywordDTO dto) {
		KeywordPO po = KeywordConverter.toPO(dto);
		List<KeywordPO> list = keywordReadManage.findKeywordAll(po);		
		return KeywordConverter.toDTO(list);
	}
}
	