package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.RoleMenuDTO;
import com.egeo.basics.user.po.RoleMenuPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author minfulong
 * @date 2017-06-28 14:46:15
 */
public class RoleMenuConverter {
	
	public static RoleMenuDTO toDTO(RoleMenuPO src) {
		RoleMenuDTO tar = new RoleMenuDTO();
		tar.setId(src.getId());
		tar.setRoleId(src.getRoleId());
		tar.setMenuId(src.getMenuId());
		return tar;
	}

	public static RoleMenuPO toPO(RoleMenuDTO src) {
		RoleMenuPO tar = new RoleMenuPO();
		tar.setId(src.getId());
		tar.setRoleId(src.getRoleId());
		tar.setMenuId(src.getMenuId());
		return tar;
	}

	public static List<RoleMenuDTO> toDTO(List<RoleMenuPO> srcs) {
		if (srcs == null)
			return null;
		List<RoleMenuDTO> list = new ArrayList<RoleMenuDTO>();
		for (RoleMenuPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<RoleMenuPO> toPO(List<RoleMenuDTO> srcs) {
		if (srcs == null)
			return null;
		List<RoleMenuPO> list = new ArrayList<RoleMenuPO>();
		for (RoleMenuDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	