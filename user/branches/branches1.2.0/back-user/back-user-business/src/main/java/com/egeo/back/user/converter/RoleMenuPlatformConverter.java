package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.RoleMenuPlatformDTO;
import com.egeo.back.user.model.vo.RoleMenuPlatformVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-05-15 15:43:24
 */
public class RoleMenuPlatformConverter {
	
	public static RoleMenuPlatformDTO toDTO(RoleMenuPlatformVO src) {
		RoleMenuPlatformDTO tar = new RoleMenuPlatformDTO();
		tar.setId(src.getId());
		tar.setPlatformId(src.getPlatformId());
		tar.setRoleId(src.getRoleId());
		tar.setMenuId(src.getMenuId());
		return tar;
	}

	public static RoleMenuPlatformVO toVO(RoleMenuPlatformDTO src) {
		RoleMenuPlatformVO tar = new RoleMenuPlatformVO();
		tar.setId(src.getId());
		tar.setPlatformId(src.getPlatformId());
		tar.setRoleId(src.getRoleId());
		tar.setMenuId(src.getMenuId());
		return tar;
	}

	public static List<RoleMenuPlatformDTO> toDTO(List<RoleMenuPlatformVO> srcs) {
		if (srcs == null)
			return null;
		List<RoleMenuPlatformDTO> list = new ArrayList<RoleMenuPlatformDTO>();
		for (RoleMenuPlatformVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<RoleMenuPlatformVO> toVO(List<RoleMenuPlatformDTO> srcs) {
		if (srcs == null)
			return null;
		List<RoleMenuPlatformVO> list = new ArrayList<RoleMenuPlatformVO>();
		for (RoleMenuPlatformDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	