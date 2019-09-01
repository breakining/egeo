package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserPlatformDTO;
import com.egeo.basics.user.po.UserPlatformPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author minfulong
 * @date 2017-06-28 14:46:16
 */
public class UserPlatformConverter {
	
	public static UserPlatformDTO toDTO(UserPlatformPO src) {
		UserPlatformDTO tar = new UserPlatformDTO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static UserPlatformPO toPO(UserPlatformDTO src) {
		UserPlatformPO tar = new UserPlatformPO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static List<UserPlatformDTO> toDTO(List<UserPlatformPO> srcs) {
		if (srcs == null)
			return null;
		List<UserPlatformDTO> list = new ArrayList<UserPlatformDTO>();
		for (UserPlatformPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserPlatformPO> toPO(List<UserPlatformDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserPlatformPO> list = new ArrayList<UserPlatformPO>();
		for (UserPlatformDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	