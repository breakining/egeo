package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserExtraInfoDTO;
import com.egeo.back.user.model.vo.UserExtraInfoVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-08-18 18:49:49
 */
public class UserExtraInfoConverter {
	
	public static UserExtraInfoDTO toDTO(UserExtraInfoVO src) {
		UserExtraInfoDTO tar = new UserExtraInfoDTO();
		tar.setId(src.getId());
		tar.setTableName(src.getTableName());	
		tar.setIsExist(src.getIsExist());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setUpdateTime(src.getUpdateTime());	
		return tar;
	}

	public static UserExtraInfoVO toVO(UserExtraInfoDTO src) {
		UserExtraInfoVO tar = new UserExtraInfoVO();
		tar.setId(src.getId());
		tar.setTableName(src.getTableName());		
		tar.setIsExist(src.getIsExist());		
		tar.setCreateTime(src.getCreateTime());		
		tar.setUpdateTime(src.getUpdateTime());		
		return tar;
	}

	public static List<UserExtraInfoDTO> toDTO(List<UserExtraInfoVO> srcs) {
		if (srcs == null)
			return null;
		List<UserExtraInfoDTO> list = new ArrayList<UserExtraInfoDTO>();
		for (UserExtraInfoVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserExtraInfoVO> toVO(List<UserExtraInfoDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserExtraInfoVO> list = new ArrayList<UserExtraInfoVO>();
		for (UserExtraInfoDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	