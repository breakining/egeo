package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserInformationDTO;
import com.egeo.back.user.model.vo.UserInformationVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author min
 * @date 2017-11-30 14:56:28
 */
public class UserInformationConverter {
	
	public static UserInformationDTO toDTO(UserInformationVO src) {
		if (src == null)
		return null;	
		UserInformationDTO tar = new UserInformationDTO();
		tar.setId(src.getId());
		tar.setHeadline(src.getHeadline());	
		tar.setHeadlineContent(src.getHeadlineContent());	
		tar.setUserId(src.getUserId());	
		tar.setDispatchUserId(src.getDispatchUserId());	
		tar.setType(src.getType());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setUpdateTime(src.getUpdateTime());	
		tar.setPlatformId(src.getPlatformId());	
		return tar;
	}

	public static UserInformationVO toVO(UserInformationDTO src) {
		if (src == null)
		return null;	
		UserInformationVO tar = new UserInformationVO();
		tar.setId(src.getId());
		tar.setHeadline(src.getHeadline());	
		tar.setHeadlineContent(src.getHeadlineContent());	
		tar.setUserId(src.getUserId());	
		tar.setDispatchUserId(src.getDispatchUserId());	
		tar.setType(src.getType());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setUpdateTime(src.getUpdateTime());	
		tar.setPlatformId(src.getPlatformId());	
		return tar;
	}

	public static List<UserInformationDTO> toDTO(List<UserInformationVO> srcs) {
		if (srcs == null)
			return null;
		List<UserInformationDTO> list = new ArrayList<UserInformationDTO>();
		for (UserInformationVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserInformationVO> toVO(List<UserInformationDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserInformationVO> list = new ArrayList<UserInformationVO>();
		for (UserInformationDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	