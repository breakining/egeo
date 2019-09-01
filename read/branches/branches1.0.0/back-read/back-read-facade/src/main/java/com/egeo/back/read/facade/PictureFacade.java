package com.egeo.back.read.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.read.api.read.PictureReadService;
import com.egeo.basics.read.api.write.PictureWriteService;
import com.egeo.basics.read.model.dto.PictureDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Component
public class PictureFacade {
	
	@Reference
	private PictureReadService pictureReadService;
	
	@Reference
	private PictureWriteService pictureWriteService;
	
	
	public PictureDTO findPictureById(PictureDTO dto){
		
		return pictureReadService.findPictureById(dto);
	}

	public PageResult<PictureDTO> findPictureOfPage(PictureDTO dto,Pagination page){
		
		return pictureReadService.findPictureOfPage(dto, page);
		
	}

	public List<PictureDTO> findPictureAll(PictureDTO dto){
		
		return pictureReadService.findPictureAll(dto);
		
	}

	public Long insertPictureWithTx(PictureDTO dto){
		
		return pictureWriteService.insertPictureWithTx(dto);
	}

	public int updatePictureWithTx(PictureDTO dto){
		
		return pictureWriteService.updatePictureWithTx(dto);
	}

	public int deletePictureWithTx(PictureDTO dto){
		
		return pictureWriteService.deletePictureWithTx(dto);
		
	}

}
	