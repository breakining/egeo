package com.egeo.back.read.business.impl;
	

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.read.business.ReadInformationManage;
import com.egeo.back.read.business.TopicManage;
import com.egeo.back.read.facade.ReadInformationFacade;
import com.egeo.back.read.model.vo.ReadInformationVO;
import com.egeo.basics.read.model.dto.ReadInformationDTO;
import com.egeo.basics.read.model.dto.TopicDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("readInformation")
public class ReadInformationManageImpl implements ReadInformationManage{

	
	@Resource(name="readInformationFacade")
	private ReadInformationFacade readInformationFacade;
	
	@Resource(name="topic")
	private TopicManage topicManage;

	@Override
	public ReadInformationDTO findReadInformationById(ReadInformationDTO dto) {
		return readInformationFacade.findReadInformationById(dto);
	}

	@Override
	public PageResult<ReadInformationDTO> findReadInformationOfPage(ReadInformationDTO dto, Pagination page) {
		return readInformationFacade.findReadInformationOfPage(dto, page);
	}

	@Override
	public List<ReadInformationDTO> findReadInformationAll(ReadInformationDTO dto) {
		return readInformationFacade.findReadInformationAll(dto);
	}

	@Override
	public Long insertReadInformationWithTx(ReadInformationDTO dto) {
		return readInformationFacade.insertReadInformationWithTx(dto);
	}

	@Override
	public int updateReadInformationWithTx(ReadInformationDTO dto) {
		return readInformationFacade.updateReadInformationWithTx(dto);
	}

	@Override
	public int deleteReadInformationWithTx(ReadInformationDTO dto) {
		return readInformationFacade.deleteReadInformationWithTx(dto);
	}
	/**
	 * 根据userId查询悦读未读消息数量
	 * @param userId
	 * @return
	 */
	@Override
	public int cntById(Long userId) {
		// TODO Auto-generated method stub
		return readInformationFacade.cntById(userId);
	}
	/**
	 * 根据userId查询悦读消息
	 * @param userId
	 * @return
	 */
	@Override
	public PageResult<ReadInformationDTO> readInformationByUserId(ReadInformationDTO dto, Pagination page) {
		// TODO Auto-generated method stub
		return readInformationFacade.readInformationByUserId(dto, page);
	}
	/**
	 * 根据悦读主题id查询悦读信息、根据悦读消息id将其变成已读
	 * @param userId
	 * @return
	 */
	@Override
	public Map<String, Object> clickReadInformation(ReadInformationVO vo) {
		//根据悦读消息id将其变成已读
		ReadInformationDTO readInformationDTO = new ReadInformationDTO();
		readInformationDTO.setId(vo.getId());
		readInformationDTO.setType(1);
		readInformationFacade.updateReadInformationWithTx(readInformationDTO);
		
		//根据悦读主题id查询悦读信息
		TopicDTO dto = new TopicDTO();
		dto.setId(vo.getTopicId());
		dto.setUserId(vo.getUserId());
		return topicManage.topicByIdApp(dto);
	}


}
	