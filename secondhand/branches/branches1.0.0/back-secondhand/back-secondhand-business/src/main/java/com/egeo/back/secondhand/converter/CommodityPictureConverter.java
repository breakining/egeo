package com.egeo.back.secondhand.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.back.secondhand.model.vo.CommodityPictureVO;
import com.egeo.basics.secondhand.model.dto.CommodityPictureDTO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author min
 * @date 2017-11-15 10:31:09
 */
public class CommodityPictureConverter {
	
	public static CommodityPictureDTO toDTO(CommodityPictureVO src) {
		if (src == null)
		return null;	
		CommodityPictureDTO tar = new CommodityPictureDTO();
		tar.setId(src.getId());
		tar.setCommodityId(src.getCommodityId());	
		tar.setPictureId(src.getPictureId());	
		tar.setSortValue(src.getSortValue());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setUpdateTime(src.getUpdateTime());	
		tar.setPlatformId(src.getPlatformId());	
		return tar;
	}

	public static CommodityPictureVO toVO(CommodityPictureDTO src) {
		if (src == null)
		return null;	
		CommodityPictureVO tar = new CommodityPictureVO();
		tar.setId(src.getId());
		tar.setCommodityId(src.getCommodityId());	
		tar.setPictureId(src.getPictureId());	
		tar.setSortValue(src.getSortValue());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setUpdateTime(src.getUpdateTime());	
		tar.setPlatformId(src.getPlatformId());	
		return tar;
	}

	public static List<CommodityPictureDTO> toDTO(List<CommodityPictureVO> srcs) {
		if (srcs == null)
			return null;
		List<CommodityPictureDTO> list = new ArrayList<CommodityPictureDTO>();
		for (CommodityPictureVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<CommodityPictureVO> toVO(List<CommodityPictureDTO> srcs) {
		if (srcs == null)
			return null;
		List<CommodityPictureVO> list = new ArrayList<CommodityPictureVO>();
		for (CommodityPictureDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	