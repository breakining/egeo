package com.egeo.basics.read.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.read.model.dto.ReadPraiseNumberDTO;
import com.egeo.basics.read.po.ReadPraiseNumberPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author ghw
 */
public class ReadPraiseNumberConverter {

	public static ReadPraiseNumberDTO toDTO(ReadPraiseNumberPO src) {
		if (src == null)
		return null;	
		ReadPraiseNumberDTO tar = new ReadPraiseNumberDTO();
		tar.setId(src.getId());
		tar.setTopicId(src.getTopicId());
		tar.setPraiseNumber(src.getPraiseNumber());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static ReadPraiseNumberPO toPO(ReadPraiseNumberDTO src) {
		if (src == null)
		return null;	
		ReadPraiseNumberPO tar = new ReadPraiseNumberPO();
		tar.setId(src.getId());
		tar.setTopicId(src.getTopicId());
		tar.setPraiseNumber(src.getPraiseNumber());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static List<ReadPraiseNumberDTO> toDTO(List<ReadPraiseNumberPO> srcs) {
		if (srcs == null)
			return null;
		List<ReadPraiseNumberDTO> list = new ArrayList<ReadPraiseNumberDTO>();
		for (ReadPraiseNumberPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<ReadPraiseNumberPO> toPO(List<ReadPraiseNumberDTO> srcs) {
		if (srcs == null)
			return null;
		List<ReadPraiseNumberPO> list = new ArrayList<ReadPraiseNumberPO>();
		for (ReadPraiseNumberDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
