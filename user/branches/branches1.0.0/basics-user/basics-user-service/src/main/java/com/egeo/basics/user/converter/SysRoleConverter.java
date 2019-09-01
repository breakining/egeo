package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.SysRoleDTO;
import com.egeo.basics.user.po.SysRolePO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-05-03 17:36:42
 */
public class SysRoleConverter {
	
	public static SysRoleDTO toDTO(SysRolePO src) {
		SysRoleDTO tar = new SysRoleDTO();
		tar.setId(src.getId());
		tar.setOfficeId(src.getOfficeId());
		tar.setName(src.getName());
		tar.setEnname(src.getEnname());
		tar.setRoleType(src.getRoleType());
		tar.setDataScope(src.getDataScope());
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

	public static SysRolePO toPO(SysRoleDTO src) {
		SysRolePO tar = new SysRolePO();
		tar.setId(src.getId());
		tar.setOfficeId(src.getOfficeId());
		tar.setName(src.getName());
		tar.setEnname(src.getEnname());
		tar.setRoleType(src.getRoleType());
		tar.setDataScope(src.getDataScope());
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

	public static List<SysRoleDTO> toDTO(List<SysRolePO> srcs) {
		if (srcs == null)
			return null;
		List<SysRoleDTO> list = new ArrayList<SysRoleDTO>();
		for (SysRolePO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<SysRolePO> toPO(List<SysRoleDTO> srcs) {
		if (srcs == null)
			return null;
		List<SysRolePO> list = new ArrayList<SysRolePO>();
		for (SysRoleDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	