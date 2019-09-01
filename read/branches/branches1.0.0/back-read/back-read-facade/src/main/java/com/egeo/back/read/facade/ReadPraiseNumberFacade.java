package com.egeo.back.read.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.read.api.read.ReadPraiseNumberReadService;
import com.egeo.basics.read.api.write.ReadPraiseNumberWriteService;
import com.egeo.basics.read.model.dto.ReadPraiseNumberDTO;

@Component
public class ReadPraiseNumberFacade {

	@Reference
	private ReadPraiseNumberReadService readPraiseNumberReadService;
	
	@Reference
	private ReadPraiseNumberWriteService readPraiseNumberWriteService;



	/**
	 * 查找readPraiseNumberDTO
	 * @param readPraiseNumberDTO
	 * @return
	 */
	public List<ReadPraiseNumberDTO> findreadPraiseNumber(ReadPraiseNumberDTO readPraiseNumberDTO) {
		return readPraiseNumberReadService.findreadPraiseNumber(readPraiseNumberDTO);
	}

	/**
	 * 更新点赞表数据：取消点赞
	 * @param dto
	 * @return
	 */
	public int decreaseReadPraiseNumber(ReadPraiseNumberDTO readPraiseNumberDTO2, int i) {
		
		return readPraiseNumberWriteService.decreaseReadPraiseNumber(readPraiseNumberDTO2,-1);
	}
	/**
	 * 更新点赞表数据：点赞
	 * @param dto
	 * @return
	 */
	public int increaseReadPraiseNumber(ReadPraiseNumberDTO readPraiseNumberDTO2, int i) {
		return readPraiseNumberWriteService.increaseReadPraiseNumber(readPraiseNumberDTO2,1);
	}

	/**
	 * 保存点赞数据
	 * @param readPraiseNumberDTO
	 */
	public int savereadPraiseNumber(ReadPraiseNumberDTO readPraiseNumberDTO) {
		return readPraiseNumberWriteService.savereadPraiseNumber(readPraiseNumberDTO);
		
	}
}
