package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.RoleDTO;
import com.egeo.back.user.model.vo.RoleVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-05-15 15:43:24
 */
public class RoleConverter {
	
	public static RoleDTO toDTO(RoleVO src) {
		RoleDTO tar = new RoleDTO();
		tar.setId(src.getId());
		tar.setName(src.getName());
		tar.setEnname(src.getEnname());
		tar.setRoleType(src.getRoleType());
		tar.setIsSys(src.getIsSys());
		tar.setUseable(src.getUseable());
		tar.setCreateBy(src.getCreateBy());
		tar.setCreateDate(src.getCreateDate());
		tar.setUpdateBy(src.getUpdateBy());
		tar.setUpdateDate(src.getUpdateDate());
		tar.setRemarks(src.getRemarks());
		tar.setDelFlag(src.getDelFlag());
		return tar;
	}

	public static RoleVO toVO(RoleDTO src) {
		RoleVO tar = new RoleVO();
		tar.setId(src.getId());
		tar.setName(src.getName());
		tar.setEnname(src.getEnname());
		tar.setRoleType(src.getRoleType());
		tar.setIsSys(src.getIsSys());
		tar.setUseable(src.getUseable());
		tar.setCreateBy(src.getCreateBy());
		tar.setCreateDate(src.getCreateDate());
		tar.setUpdateBy(src.getUpdateBy());
		tar.setUpdateDate(src.getUpdateDate());
		tar.setRemarks(src.getRemarks());
		tar.setDelFlag(src.getDelFlag());
		return tar;
	}

	public static List<RoleDTO> toDTO(List<RoleVO> srcs) {
		if (srcs == null)
			return null;
		List<RoleDTO> list = new ArrayList<RoleDTO>();
		for (RoleVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<RoleVO> toVO(List<RoleDTO> srcs) {
		if (srcs == null)
			return null;
		List<RoleVO> list = new ArrayList<RoleVO>();
		for (RoleDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	