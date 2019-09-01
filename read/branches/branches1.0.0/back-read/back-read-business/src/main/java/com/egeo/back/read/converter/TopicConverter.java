package com.egeo.back.read.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.back.read.model.vo.TopicVO;
import com.egeo.basics.read.model.dto.TopicDTO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author min
 * @date 2017-11-15 10:02:30
 */
public class TopicConverter {
	
	public static TopicDTO toDTO(TopicVO src) {
		if (src == null)
		return null;	
		TopicDTO tar = new TopicDTO();
		tar.setId(src.getId());
		tar.setCompanyId(src.getCompanyId());
		tar.setBooksName(src.getBooksName());
		tar.setAuthor(src.getAuthor());
		tar.setPublishingHouse(src.getPublishingHouse());
		tar.setTopicHeadline(src.getTopicHeadline());	
		tar.setTopicContent(src.getTopicContent());	
		tar.setTopicCover(src.getTopicCover());
		tar.setCommentNumber(src.getCommentNumber());
		tar.setPraiseNumber(src.getPraiseNumber());
		tar.setUserId(src.getUserId());	
		tar.setUserName(src.getUserName());
		tar.setPraiseType(src.getPraiseType());
		return tar;
	}

	public static TopicVO toVO(TopicDTO src) {
		if (src == null)
		return null;	
		TopicVO tar = new TopicVO();
		tar.setId(src.getId());
		tar.setCompanyId(src.getCompanyId());
		tar.setBooksName(src.getBooksName());
		tar.setAuthor(src.getAuthor());
		tar.setPublishingHouse(src.getPublishingHouse());
		tar.setTopicHeadline(src.getTopicHeadline());	
		tar.setTopicContent(src.getTopicContent());	
		tar.setTopicCover(src.getTopicCover());	
		tar.setCommentNumber(src.getCommentNumber());
		tar.setPraiseNumber(src.getPraiseNumber());
		tar.setUserId(src.getUserId());
		tar.setUserName(src.getUserName());
		tar.setPraiseType(src.getPraiseType());
		return tar;
	}

	public static List<TopicDTO> toDTO(List<TopicVO> srcs) {
		if (srcs == null)
			return null;
		List<TopicDTO> list = new ArrayList<TopicDTO>();
		for (TopicVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<TopicVO> toVO(List<TopicDTO> srcs) {
		if (srcs == null)
			return null;
		List<TopicVO> list = new ArrayList<TopicVO>();
		for (TopicDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	