package com.egeo.back.secondhand.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.secondhand.api.read.CommodityPictureReadService;
import com.egeo.basics.secondhand.api.write.CommodityPictureWriteService;
import com.egeo.basics.secondhand.model.dto.CommodityPictureDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Component
public class CommodityPictureFacade {
	
	@Reference
	private CommodityPictureReadService commodityPictureReadService;
	
	@Reference
	private CommodityPictureWriteService commodityPictureWriteService;
	
	
	public CommodityPictureDTO findCommodityPictureById(CommodityPictureDTO dto){
		
		return commodityPictureReadService.findCommodityPictureById(dto);
	}

	public PageResult<CommodityPictureDTO> findCommodityPictureOfPage(CommodityPictureDTO dto,Pagination page){
		
		return commodityPictureReadService.findCommodityPictureOfPage(dto, page);
		
	}

	public List<CommodityPictureDTO> findCommodityPictureAll(CommodityPictureDTO dto){
		
		return commodityPictureReadService.findCommodityPictureAll(dto);
		
	}

	public Long insertCommodityPictureWithTx(CommodityPictureDTO dto){
		
		return commodityPictureWriteService.insertCommodityPictureWithTx(dto);
	}

	public int updateCommodityPictureWithTx(CommodityPictureDTO dto){
		
		return commodityPictureWriteService.updateCommodityPictureWithTx(dto);
	}

	public int deleteCommodityPictureWithTx(CommodityPictureDTO dto){
		
		return commodityPictureWriteService.deleteCommodityPictureWithTx(dto);
		
	}

}
	