package com.egeo.back.read.business.impl;
	

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.read.business.TopicManage;
import com.egeo.back.read.facade.TopicFacade;
import com.egeo.basics.read.model.dto.TopicDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("topic")
public class TopicManageImpl implements TopicManage{

	
	@Resource(name="topicFacade")
	private TopicFacade topicFacade;

	@Override
	public TopicDTO findTopicById(TopicDTO dto) {
		return topicFacade.findTopicById(dto);
	}

	@Override
	public PageResult<TopicDTO> findTopicOfPage(TopicDTO dto, Pagination page) {
		return topicFacade.findTopicOfPage(dto, page);
	}

	@Override
	public List<TopicDTO> findTopicAll(TopicDTO dto) {
		return topicFacade.findTopicAll(dto);
	}

	@Override
	public Long insertTopicWithTx(TopicDTO dto) {
		return topicFacade.insertTopicWithTx(dto);
	}

	@Override
	public int updateTopicWithTx(TopicDTO dto) {
		return topicFacade.updateTopicWithTx(dto);
	}

	@Override
	public int deleteTopicWithTx(TopicDTO dto) {
		return topicFacade.deleteTopicWithTx(dto);
	}
	/**
	 * 福管+app分页查询悦评
	 * @param vo
	 * @param page
	 * @param req
	 * @return
	 */
	@Override
	public PageResult<TopicDTO> topicOfPageApp(TopicDTO dto, Pagination page) {
		
		return topicFacade.topicOfPageApp(dto, page);
	}
	/**
	 * 福管+app根据id查询悦评信息及评论信息
	 * @param vo
	 * @param page
	 * @param req
	 * @return
	 */
	@Override
	public Map<String, Object> topicByIdApp(TopicDTO dto) {
		Map<String, Object> map = new HashMap<>();
		TopicDTO topicDTO = topicFacade.topicByIdApp(dto);
		map.put("booksName", topicDTO.getBooksName());
		map.put("topicHeadline", topicDTO.getTopicHeadline());
		map.put("topicContent", topicDTO.getTopicContent());
		map.put("topicCover", topicDTO.getTopicCover());
		map.put("userName", topicDTO.getUserName());
		map.put("createTime", topicDTO.getCreateTime());
		map.put("commentNumber", topicDTO.getCommentNumber());
		map.put("praiseNumber", topicDTO.getPraiseNumber());
		map.put("praiseType", topicDTO.getPraiseType());
		return map;
	}


}
	