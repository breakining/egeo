package com.egeo.back.read.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.back.read.model.vo.PictureVO;
import com.egeo.basics.read.model.dto.PictureDTO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author min
 * @date 2017-11-15 10:31:08
 */
public class PictureConverter {
	
	public static PictureDTO toDTO(PictureVO src) {
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

	public static PictureVO toVO(PictureDTO src) {
		if (src == null)
		return null;	
		PictureVO tar = new PictureVO();
		tar.setId(src.getId());
		tar.setName(src.getName());	
		tar.setUrl(src.getUrl());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setUpdateTime(src.getUpdateTime());	
		tar.setPlatformId(src.getPlatformId());	
		return tar;
	}

	public static List<PictureDTO> toDTO(List<PictureVO> srcs) {
		if (srcs == null)
			return null;
		List<PictureDTO> list = new ArrayList<PictureDTO>();
		for (PictureVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<PictureVO> toVO(List<PictureDTO> srcs) {
		if (srcs == null)
			return null;
		List<PictureVO> list = new ArrayList<PictureVO>();
		for (PictureDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	