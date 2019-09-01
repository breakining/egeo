package com.egeo.back.read.business.impl;
	

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.read.business.ParentChildrenManage;
import com.egeo.back.read.facade.ParentChildrenFacade;
import com.egeo.basics.read.model.dto.ParentChildrenDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("parentChildren")
public class ParentChildrenManageImpl implements ParentChildrenManage{

	
	@Resource(name="parentChildrenFacade")
	private ParentChildrenFacade parentChildrenFacade;

	@Override
	public ParentChildrenDTO findParentChildrenById(ParentChildrenDTO dto) {
		return parentChildrenFacade.findParentChildrenById(dto);
	}

	@Override
	public PageResult<ParentChildrenDTO> findParentChildrenOfPage(ParentChildrenDTO dto, Pagination page) {
		return parentChildrenFacade.findParentChildrenOfPage(dto, page);
	}

	@Override
	public List<ParentChildrenDTO> findParentChildrenAll(ParentChildrenDTO dto) {
		return parentChildrenFacade.findParentChildrenAll(dto);
	}

	@Override
	public Long insertParentChildrenWithTx(ParentChildrenDTO dto) {
		return parentChildrenFacade.insertParentChildrenWithTx(dto);
	}

	@Override
	public int updateParentChildrenWithTx(ParentChildrenDTO dto) {
		return parentChildrenFacade.updateParentChildrenWithTx(dto);
	}

	@Override
	public int deleteParentChildrenWithTx(ParentChildrenDTO dto) {
		return parentChildrenFacade.deleteParentChildrenWithTx(dto);
	}


}
	