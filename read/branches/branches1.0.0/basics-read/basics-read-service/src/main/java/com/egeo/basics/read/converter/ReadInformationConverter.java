package com.egeo.basics.read.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.read.model.dto.ReadInformationDTO;
import com.egeo.basics.read.po.ReadInformationPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author min
 * @date 2017-11-27 18:45:26
 */
public class ReadInformationConverter {
	
	public static ReadInformationDTO toDTO(ReadInformationPO src) {
		if (src == null)
		return null;	
		ReadInformationDTO tar = new ReadInformationDTO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setFromUid(src.getFromUid());
		tar.setFromName(src.getFromName());
		tar.setTopicId(src.getTopicId());
		tar.setIsCommentPraise(src.getIsCommentPraise());
		tar.setType(src.getType());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		return tar;
	}

	public static ReadInformationPO toPO(ReadInformationDTO src) {
		if (src == null)
		return null;	
		ReadInformationPO tar = new ReadInformationPO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setFromUid(src.getFromUid());
		tar.setFromName(src.getFromName());
		tar.setTopicId(src.getTopicId());
		tar.setIsCommentPraise(src.getIsCommentPraise());
		tar.setType(src.getType());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		return tar;
	}

	public static List<ReadInformationDTO> toDTO(List<ReadInformationPO> srcs) {
		if (srcs == null)
			return null;
		List<ReadInformationDTO> list = new ArrayList<ReadInformationDTO>();
		for (ReadInformationPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<ReadInformationPO> toPO(List<ReadInformationDTO> srcs) {
		if (srcs == null)
			return null;
		List<ReadInformationPO> list = new ArrayList<ReadInformationPO>();
		for (ReadInformationDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	