package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserRoleDTO;
import com.egeo.back.user.model.vo.UserRoleVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-05-15 15:43:24
 */
public class UserRoleConverter {
	
	public static UserRoleDTO toDTO(UserRoleVO src) {
		UserRoleDTO tar = new UserRoleDTO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setRoleId(src.getRoleId());
		return tar;
	}

	public static UserRoleVO toVO(UserRoleDTO src) {
		UserRoleVO tar = new UserRoleVO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setRoleId(src.getRoleId());
		return tar;
	}

	public static List<UserRoleDTO> toDTO(List<UserRoleVO> srcs) {
		if (srcs == null)
			return null;
		List<UserRoleDTO> list = new ArrayList<UserRoleDTO>();
		for (UserRoleVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserRoleVO> toVO(List<UserRoleDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserRoleVO> list = new ArrayList<UserRoleVO>();
		for (UserRoleDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	