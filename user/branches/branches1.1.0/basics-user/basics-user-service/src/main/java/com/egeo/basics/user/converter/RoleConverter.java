package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.RoleDTO;
import com.egeo.basics.user.po.RolePO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-05-05 09:20:24
 */
public class RoleConverter {
	
	public static RoleDTO toDTO(RolePO src) {
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

	public static RolePO toPO(RoleDTO src) {
		RolePO tar = new RolePO();
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

	public static List<RoleDTO> toDTO(List<RolePO> srcs) {
		if (srcs == null)
			return null;
		List<RoleDTO> list = new ArrayList<RoleDTO>();
		for (RolePO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<RolePO> toPO(List<RoleDTO> srcs) {
		if (srcs == null)
			return null;
		List<RolePO> list = new ArrayList<RolePO>();
		for (RoleDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	