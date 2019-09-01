package com.egeo.basics.read.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.read.model.dto.ReadPraiseDTO;
import com.egeo.basics.read.po.ReadPraisePO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author min
 * @date 2017-11-16 13:07:20
 */
public class ReadPraiseConverter {
	
	public static ReadPraiseDTO toDTO(ReadPraisePO src) {
		if (src == null)
		return null;	
		ReadPraiseDTO tar = new ReadPraiseDTO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setTopicId(src.getTopicId());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static ReadPraisePO toPO(ReadPraiseDTO src) {
		if (src == null)
		return null;	
		ReadPraisePO tar = new ReadPraisePO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setTopicId(src.getTopicId());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static List<ReadPraiseDTO> toDTO(List<ReadPraisePO> srcs) {
		if (srcs == null)
			return null;
		List<ReadPraiseDTO> list = new ArrayList<ReadPraiseDTO>();
		for (ReadPraisePO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<ReadPraisePO> toPO(List<ReadPraiseDTO> srcs) {
		if (srcs == null)
			return null;
		List<ReadPraisePO> list = new ArrayList<ReadPraisePO>();
		for (ReadPraiseDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	