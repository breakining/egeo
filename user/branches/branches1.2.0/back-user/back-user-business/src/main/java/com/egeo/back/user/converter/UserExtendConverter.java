package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.back.user.model.vo.UserExtendVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-05-15 15:43:24
 */
public class UserExtendConverter {
	
	public static UserExtendDTO toDTO(UserExtendVO src) {
		UserExtendDTO tar = new UserExtendDTO();
		tar.setId(src.getId());
		tar.setSex(src.getSex());
		tar.setNickname(src.getNickname());
		tar.setHeadPicUrl(src.getHeadPicUrl());
		tar.setName(src.getName());
		return tar;
	}

	public static UserExtendVO toVO(UserExtendDTO src) {
		UserExtendVO tar = new UserExtendVO();
		tar.setId(src.getId());
		tar.setSex(src.getSex());
		tar.setNickname(src.getNickname());
		tar.setHeadPicUrl(src.getHeadPicUrl());
		tar.setName(src.getName());
		return tar;
	}

	public static List<UserExtendDTO> toDTO(List<UserExtendVO> srcs) {
		if (srcs == null)
			return null;
		List<UserExtendDTO> list = new ArrayList<UserExtendDTO>();
		for (UserExtendVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserExtendVO> toVO(List<UserExtendDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserExtendVO> list = new ArrayList<UserExtendVO>();
		for (UserExtendDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	