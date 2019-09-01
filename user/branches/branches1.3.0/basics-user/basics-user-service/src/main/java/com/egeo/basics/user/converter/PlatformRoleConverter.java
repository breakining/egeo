package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.PlatformRoleDTO;
import com.egeo.basics.user.po.PlatformRolePO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-08-12 19:17:06
 */
public class PlatformRoleConverter {
	
	public static PlatformRoleDTO toDTO(PlatformRolePO src) {
		PlatformRoleDTO tar = new PlatformRoleDTO();
		tar.setId(src.getId());
		tar.setPlatformId(src.getPlatformId());
		tar.setRoleId(src.getRoleId());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setCompanyId(src.getCompanyId());
		return tar;
	}

	public static PlatformRolePO toPO(PlatformRoleDTO src) {
		PlatformRolePO tar = new PlatformRolePO();
		tar.setId(src.getId());
		tar.setPlatformId(src.getPlatformId());
		tar.setRoleId(src.getRoleId());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setCompanyId(src.getCompanyId());
		return tar;
	}

	public static List<PlatformRoleDTO> toDTO(List<PlatformRolePO> srcs) {
		if (srcs == null)
			return null;
		List<PlatformRoleDTO> list = new ArrayList<PlatformRoleDTO>();
		for (PlatformRolePO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<PlatformRolePO> toPO(List<PlatformRoleDTO> srcs) {
		if (srcs == null)
			return null;
		List<PlatformRolePO> list = new ArrayList<PlatformRolePO>();
		for (PlatformRoleDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	