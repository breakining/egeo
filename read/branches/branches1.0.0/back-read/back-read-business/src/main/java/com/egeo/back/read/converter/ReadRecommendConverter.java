package com.egeo.back.read.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.read.model.dto.ReadRecommendDTO;
import com.egeo.back.read.model.vo.ReadRecommendVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author min
 * @date 2017-12-05 11:59:00
 */
public class ReadRecommendConverter {
	
	public static ReadRecommendDTO toDTO(ReadRecommendVO src) {
		if (src == null)
		return null;	
		ReadRecommendDTO tar = new ReadRecommendDTO();
		tar.setId(src.getId());
		tar.setCompanyId(src.getCompanyId());
		tar.setBooksName(src.getBooksName());	
		tar.setBooksPicture(src.getBooksPicture());	
		tar.setAuthor(src.getAuthor());	
		tar.setPublishingHouse(src.getPublishingHouse());	
		tar.setSkipUrl(src.getSkipUrl());	
		tar.setSortValue(src.getSortValue());	
		tar.setRecommendLanguage(src.getRecommendLanguage());	
		tar.setType(src.getType());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setUpdateTime(src.getUpdateTime());	
		tar.setPlatformId(src.getPlatformId());	
		return tar;
	}

	public static ReadRecommendVO toVO(ReadRecommendDTO src) {
		if (src == null)
		return null;	
		ReadRecommendVO tar = new ReadRecommendVO();
		tar.setId(src.getId());
		tar.setCompanyId(src.getCompanyId());
		tar.setBooksName(src.getBooksName());	
		tar.setBooksPicture(src.getBooksPicture());	
		tar.setAuthor(src.getAuthor());	
		tar.setPublishingHouse(src.getPublishingHouse());	
		tar.setSkipUrl(src.getSkipUrl());	
		tar.setSortValue(src.getSortValue());	
		tar.setRecommendLanguage(src.getRecommendLanguage());	
		tar.setType(src.getType());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setUpdateTime(src.getUpdateTime());	
		tar.setPlatformId(src.getPlatformId());	
		return tar;
	}

	public static List<ReadRecommendDTO> toDTO(List<ReadRecommendVO> srcs) {
		if (srcs == null)
			return null;
		List<ReadRecommendDTO> list = new ArrayList<ReadRecommendDTO>();
		for (ReadRecommendVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<ReadRecommendVO> toVO(List<ReadRecommendDTO> srcs) {
		if (srcs == null)
			return null;
		List<ReadRecommendVO> list = new ArrayList<ReadRecommendVO>();
		for (ReadRecommendDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	