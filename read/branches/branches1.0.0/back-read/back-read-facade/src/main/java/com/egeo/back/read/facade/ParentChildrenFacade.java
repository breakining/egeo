package com.egeo.back.read.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.read.api.read.ParentChildrenReadService;
import com.egeo.basics.read.api.write.ParentChildrenWriteService;
import com.egeo.basics.read.model.dto.ParentChildrenDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Component
public class ParentChildrenFacade {
	
	@Reference
	private ParentChildrenReadService parentChildrenReadService;
	
	@Reference
	private ParentChildrenWriteService parentChildrenWriteService;
	
	
	public ParentChildrenDTO findParentChildrenById(ParentChildrenDTO dto){
		
		return parentChildrenReadService.findParentChildrenById(dto);
	}

	public PageResult<ParentChildrenDTO> findParentChildrenOfPage(ParentChildrenDTO dto,Pagination page){
		
		return parentChildrenReadService.findParentChildrenOfPage(dto, page);
		
	}

	public List<ParentChildrenDTO> findParentChildrenAll(ParentChildrenDTO dto){
		
		return parentChildrenReadService.findParentChildrenAll(dto);
		
	}

	public Long insertParentChildrenWithTx(ParentChildrenDTO dto){
		
		return parentChildrenWriteService.insertParentChildrenWithTx(dto);
	}

	public int updateParentChildrenWithTx(ParentChildrenDTO dto){
		
		return parentChildrenWriteService.updateParentChildrenWithTx(dto);
	}

	public int deleteParentChildrenWithTx(ParentChildrenDTO dto){
		
		return parentChildrenWriteService.deleteParentChildrenWithTx(dto);
		
	}
	/**
	 * 根据子评论id删除关系
	 * @param id
	 * @return
	 */
	public int deleteByCommentIdWithTx(Long commentId) {
		// TODO Auto-generated method stub
		return parentChildrenWriteService.deleteByCommentIdWithTx(commentId);
	}

}
	