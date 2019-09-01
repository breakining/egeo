package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.MenuDTO;
import com.egeo.basics.user.po.MenuPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author minfulong
 * @date 2017-06-28 14:46:14
 */
public class MenuConverter {
	
	public static MenuDTO toDTO(MenuPO src) {
		MenuDTO tar = new MenuDTO();
		tar.setId(src.getId());
		tar.setParentId(src.getParentId());
		tar.setName(src.getName());
		tar.setSort(src.getSort());
		tar.setHref(src.getHref());
		tar.setTarget(src.getTarget());
		tar.setIcon(src.getIcon());
		tar.setIsShow(src.getIsShow());
		tar.setPermission(src.getPermission());
		tar.setCreateBy(src.getCreateBy());
		tar.setCreateDate(src.getCreateDate());
		tar.setUpdateBy(src.getUpdateBy());
		tar.setUpdateDate(src.getUpdateDate());
		tar.setRemarks(src.getRemarks());
		tar.setDelFlag(src.getDelFlag());
		tar.setPid(src.getPid());
		return tar;
	}

	public static MenuPO toPO(MenuDTO src) {
		MenuPO tar = new MenuPO();
		tar.setId(src.getId());
		tar.setParentId(src.getParentId());
		tar.setName(src.getName());
		tar.setSort(src.getSort());
		tar.setHref(src.getHref());
		tar.setTarget(src.getTarget());
		tar.setIcon(src.getIcon());
		tar.setIsShow(src.getIsShow());
		tar.setPermission(src.getPermission());
		tar.setCreateBy(src.getCreateBy());
		tar.setCreateDate(src.getCreateDate());
		tar.setUpdateBy(src.getUpdateBy());
		tar.setUpdateDate(src.getUpdateDate());
		tar.setRemarks(src.getRemarks());
		tar.setDelFlag(src.getDelFlag());
		tar.setPid(src.getPid());
		return tar;
	}

	public static List<MenuDTO> toDTO(List<MenuPO> srcs) {
		if (srcs == null)
			return null;
		List<MenuDTO> list = new ArrayList<MenuDTO>();
		for (MenuPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<MenuPO> toPO(List<MenuDTO> srcs) {
		if (srcs == null)
			return null;
		List<MenuPO> list = new ArrayList<MenuPO>();
		for (MenuDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	