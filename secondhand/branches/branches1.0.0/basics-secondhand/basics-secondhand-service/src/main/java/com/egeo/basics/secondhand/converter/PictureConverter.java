package com.egeo.basics.secondhand.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.secondhand.model.dto.PictureDTO;
import com.egeo.basics.secondhand.po.PicturePO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author min
 * @date 2017-11-29 15:37:09
 */
public class PictureConverter {
	
	public static PictureDTO toDTO(PicturePO src) {
		if (src == null)
		return null;	
		PictureDTO tar = new PictureDTO();
		tar.setId(src.getId());
		tar.setName(src.getName());
		tar.setUrl(src.getUrl());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static PicturePO toPO(PictureDTO src) {
		if (src == null)
		return null;	
		PicturePO tar = new PicturePO();
		tar.setId(src.getId());
		tar.setName(src.getName());
		tar.setUrl(src.getUrl());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static List<PictureDTO> toDTO(List<PicturePO> srcs) {
		if (srcs == null)
			return null;
		List<PictureDTO> list = new ArrayList<PictureDTO>();
		for (PicturePO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<PicturePO> toPO(List<PictureDTO> srcs) {
		if (srcs == null)
			return null;
		List<PicturePO> list = new ArrayList<PicturePO>();
		for (PictureDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	