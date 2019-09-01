package com.egeo.back.read.business.impl;
	

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.read.business.ReadPraiseManage;
import com.egeo.back.read.facade.ReadInformationFacade;
import com.egeo.back.read.facade.ReadPraiseFacade;
import com.egeo.back.read.facade.ReadPraiseNumberFacade;
import com.egeo.basics.read.model.dto.ReadInformationDTO;
import com.egeo.basics.read.model.dto.ReadPraiseDTO;
import com.egeo.basics.read.model.dto.ReadPraiseNumberDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;
import com.egeo.utils.EmptyUtil;

@Service("readPraise")
public class ReadPraiseManageImpl implements ReadPraiseManage{

	
	@Resource(name="readPraiseFacade")
	private ReadPraiseFacade readPraiseFacade;
	
	@Resource(name="readPraiseNumberFacade")
	private ReadPraiseNumberFacade readPraiseNumberFacade;
	
	@Resource(name="readInformationFacade")
	private ReadInformationFacade readInformationFacade;

	@Override
	public ReadPraiseDTO findReadPraiseById(ReadPraiseDTO dto) {
		return readPraiseFacade.findReadPraiseById(dto);
	}

	@Override
	public PageResult<ReadPraiseDTO> findReadPraiseOfPage(ReadPraiseDTO dto, Pagination page) {
		return readPraiseFacade.findReadPraiseOfPage(dto, page);
	}

	@Override
	public List<ReadPraiseDTO> findReadPraiseAll(ReadPraiseDTO dto) {
		return readPraiseFacade.findReadPraiseAll(dto);
	}

	@Override
	public String insertReadPraiseWithTx(ReadPraiseDTO dto,Long commentTargetUserId) {
		//根据topic_id查询readPraiseNumber对象
		ReadPraiseNumberDTO readPraiseNumberDTO = new ReadPraiseNumberDTO();
		readPraiseNumberDTO.setTopicId(dto.getTopicId());
		List<ReadPraiseNumberDTO> ReadPraiseNumberDTOList =readPraiseNumberFacade.findreadPraiseNumber(readPraiseNumberDTO);
		ReadPraiseNumberDTO readPraiseNumberDTO2=null;
		
		//根据userId查询悦读主题id查询zan信息
		List<ReadPraiseDTO> findReadPraiseAll = readPraiseFacade.findReadPraiseAll(dto);
		//如果有进行删除操作
		if(findReadPraiseAll.size() != 0){
			//根据id删除点赞信息
			readPraiseFacade.deleteReadPraiseWithTx(findReadPraiseAll.get(0));
			
			if(EmptyUtil.isNotEmpty(ReadPraiseNumberDTOList)){
				readPraiseNumberDTO2 = ReadPraiseNumberDTOList.get(0);
				//更新点赞表数据：取消点赞
				readPraiseNumberFacade.decreaseReadPraiseNumber(readPraiseNumberDTO2,-1);
			}else{
				//此时read_praise_number里面还没有关于topic点赞的记录。此时不需要取消赞
				return null;
			}
			
			return "取消点赞成功";
		}else{
			//添加点赞信息
			readPraiseFacade.insertReadPraiseWithTx(dto);
			
			//更新点赞表数据：点赞
			if(EmptyUtil.isNotEmpty(ReadPraiseNumberDTOList)){
				readPraiseNumberDTO2 = ReadPraiseNumberDTOList.get(0);
				//更新点赞表数据：点赞
				readPraiseNumberFacade.increaseReadPraiseNumber(readPraiseNumberDTO2,1);
			}else{
				//此时read_praise_number里面还没有关于topic点赞的记录。此时需要增加一条数据
				readPraiseNumberDTO.setPlatformId(dto.getPlatformId());
				readPraiseNumberFacade.savereadPraiseNumber(readPraiseNumberDTO);
			}
			try {
				//添加悦读信息记录（Beta1.0暂时没有此功能）
				ReadInformationDTO readInformationDTO = new ReadInformationDTO();
				readInformationDTO.setUserId(commentTargetUserId);
				readInformationDTO.setFromUid(dto.getUserId());
				readInformationDTO.setFromName(dto.getUserName());
				readInformationDTO.setTopicId(dto.getTopicId());
				readInformationDTO.setIsCommentPraise(1);
				readInformationDTO.setType(0);
				
				if(EmptyUtil.isEmpty(readInformationDTO.getUserId())){
					throw new BusinessException("目标用户id不能为空");
				}
				if(EmptyUtil.isEmpty(readInformationDTO.getTopicId())){
					throw new BusinessException("悦评主题id不能为空");
				}
				readInformationFacade.insertReadInformationByPraiseWithTx(readInformationDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				new BusinessException(e.toString());
			}
			return "点赞成功";
		}
		
	}

	@Override
	public int updateReadPraiseWithTx(ReadPraiseDTO dto) {
		return readPraiseFacade.updateReadPraiseWithTx(dto);
	}

	@Override
	public int deleteReadPraiseWithTx(ReadPraiseDTO dto) {
		return readPraiseFacade.deleteReadPraiseWithTx(dto);
	}


}
	