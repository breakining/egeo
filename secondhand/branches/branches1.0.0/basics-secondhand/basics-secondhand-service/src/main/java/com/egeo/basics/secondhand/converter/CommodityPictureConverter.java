package com.egeo.basics.secondhand.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.secondhand.model.dto.CommodityPictureDTO;
import com.egeo.basics.secondhand.po.CommodityPicturePO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author min
 * @date 2017-11-29 15:37:09
 */
public class CommodityPictureConverter {
	
	public static CommodityPictureDTO toDTO(CommodityPicturePO src) {
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

	public static CommodityPicturePO toPO(CommodityPictureDTO src) {
		if (src == null)
		return null;	
		CommodityPicturePO tar = new CommodityPicturePO();
		tar.setId(src.getId());
		tar.setCommodityId(src.getCommodityId());
		tar.setPictureId(src.getPictureId());
		tar.setSortValue(src.getSortValue());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static List<CommodityPictureDTO> toDTO(List<CommodityPicturePO> srcs) {
		if (srcs == null)
			return null;
		List<CommodityPictureDTO> list = new ArrayList<CommodityPictureDTO>();
		for (CommodityPicturePO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<CommodityPicturePO> toPO(List<CommodityPictureDTO> srcs) {
		if (srcs == null)
			return null;
		List<CommodityPicturePO> list = new ArrayList<CommodityPicturePO>();
		for (CommodityPictureDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	