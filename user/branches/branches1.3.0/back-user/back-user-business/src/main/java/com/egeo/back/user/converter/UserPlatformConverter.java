package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserPlatformDTO;
import com.egeo.back.user.model.vo.UserPlatformVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-08-12 19:16:15
 */
public class UserPlatformConverter {
	
	public static UserPlatformDTO toDTO(UserPlatformVO src) {
		UserPlatformDTO tar = new UserPlatformDTO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());	
		tar.setPlatformId(src.getPlatformId());	
		tar.setIsAvailable(src.getIsAvailable());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setUpdateTime(src.getUpdateTime());	
		tar.setCompanyId(src.getCompanyId());	
		return tar;
	}

	public static UserPlatformVO toVO(UserPlatformDTO src) {
		UserPlatformVO tar = new UserPlatformVO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());		
		tar.setPlatformId(src.getPlatformId());		
		tar.setIsAvailable(src.getIsAvailable());		
		tar.setCreateTime(src.getCreateTime());		
		tar.setUpdateTime(src.getUpdateTime());		
		tar.setCompanyId(src.getCompanyId());		
		return tar;
	}

	public static List<UserPlatformDTO> toDTO(List<UserPlatformVO> srcs) {
		if (srcs == null)
			return null;
		List<UserPlatformDTO> list = new ArrayList<UserPlatformDTO>();
		for (UserPlatformVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserPlatformVO> toVO(List<UserPlatformDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserPlatformVO> list = new ArrayList<UserPlatformVO>();
		for (UserPlatformDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	