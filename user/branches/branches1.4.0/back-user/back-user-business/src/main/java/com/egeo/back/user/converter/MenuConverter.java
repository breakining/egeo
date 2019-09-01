package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.MenuDTO;
import com.egeo.back.user.model.vo.MenuVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-08-18 18:49:48
 */
public class MenuConverter {
	
	public static MenuDTO toDTO(MenuVO src) {
		MenuDTO tar = new MenuDTO();
		tar.setId(src.getId());
		tar.setParentId(src.getParentId());	
		tar.setName(src.getName());	
		tar.setSort(src.getSort());	
		tar.setHref(src.getHref());	
		tar.setIcon(src.getIcon());	
		tar.setIsShow(src.getIsShow());	
		tar.setPermission(src.getPermission());	
		tar.setRemarks(src.getRemarks());	
		tar.setPlatformId(src.getPlatformId());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setUpdateTime(src.getUpdateTime());	
		return tar;
	}

	public static MenuVO toVO(MenuDTO src) {
		MenuVO tar = new MenuVO();
		tar.setId(src.getId());
		tar.setParentId(src.getParentId());		
		tar.setName(src.getName());		
		tar.setSort(src.getSort());		
		tar.setHref(src.getHref());		
		tar.setIcon(src.getIcon());		
		tar.setIsShow(src.getIsShow());		
		tar.setPermission(src.getPermission());		
		tar.setRemarks(src.getRemarks());		
		tar.setPlatformId(src.getPlatformId());		
		tar.setCreateTime(src.getCreateTime());		
		tar.setUpdateTime(src.getUpdateTime());		
		return tar;
	}

	public static List<MenuDTO> toDTO(List<MenuVO> srcs) {
		if (srcs == null)
			return null;
		List<MenuDTO> list = new ArrayList<MenuDTO>();
		for (MenuVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<MenuVO> toVO(List<MenuDTO> srcs) {
		if (srcs == null)
			return null;
		List<MenuVO> list = new ArrayList<MenuVO>();
		for (MenuDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	