package com.egeo.back.read.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.read.api.read.ReadInformationReadService;
import com.egeo.basics.read.api.write.ReadInformationWriteService;
import com.egeo.basics.read.model.dto.ReadInformationDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Component
public class ReadInformationFacade {
	
	@Reference
	private ReadInformationReadService readInformationReadService;
	
	@Reference
	private ReadInformationWriteService readInformationWriteService;
	
	
	public ReadInformationDTO findReadInformationById(ReadInformationDTO dto){
		
		return readInformationReadService.findReadInformationById(dto);
	}

	public PageResult<ReadInformationDTO> findReadInformationOfPage(ReadInformationDTO dto,Pagination page){
		
		return readInformationReadService.findReadInformationOfPage(dto, page);
		
	}

	public List<ReadInformationDTO> findReadInformationAll(ReadInformationDTO dto){
		
		return readInformationReadService.findReadInformationAll(dto);
		
	}

	public Long insertReadInformationWithTx(ReadInformationDTO dto){
		
		return readInformationWriteService.insertReadInformationWithTx(dto);
	}

	public int updateReadInformationWithTx(ReadInformationDTO dto){
		
		return readInformationWriteService.updateReadInformationWithTx(dto);
	}

	public int deleteReadInformationWithTx(ReadInformationDTO dto){
		
		return readInformationWriteService.deleteReadInformationWithTx(dto);
		
	}
	/**
	 * 根据条件添加悦读信息记录
	 * @param readInformationDTO
	 * @return
	 */
	public int insertReadInformationByPraiseWithTx(ReadInformationDTO readInformationDTO) {
		// TODO Auto-generated method stub
		return readInformationWriteService.insertReadInformationByPraiseWithTx(readInformationDTO);
	}
	/**
	 * 根据userId查询悦读未读消息数量
	 * @param userId
	 * @return
	 */
	public int cntById(Long userId) {
		// TODO Auto-generated method stub
		return readInformationReadService.cntById(userId);
	}
	/**
	 * 根据userId查询悦读消息
	 * @param userId
	 * @return
	 */
	public PageResult<ReadInformationDTO> readInformationByUserId(ReadInformationDTO dto, Pagination page) {
		// TODO Auto-generated method stub
		return readInformationReadService.readInformationByUserId(dto, page);
	}

}
	