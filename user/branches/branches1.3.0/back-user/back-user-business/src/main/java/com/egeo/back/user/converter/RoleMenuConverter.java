package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.RoleMenuDTO;
import com.egeo.back.user.model.vo.RoleMenuVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-08-12 19:16:15
 */
public class RoleMenuConverter {
	
	public static RoleMenuDTO toDTO(RoleMenuVO src) {
		RoleMenuDTO tar = new RoleMenuDTO();
		tar.setId(src.getId());
		tar.setRoleId(src.getRoleId());	
		tar.setMenuId(src.getMenuId());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setUpdateTime(src.getUpdateTime());	
		tar.setCompanyId(src.getCompanyId());	
		return tar;
	}

	public static RoleMenuVO toVO(RoleMenuDTO src) {
		RoleMenuVO tar = new RoleMenuVO();
		tar.setId(src.getId());
		tar.setRoleId(src.getRoleId());		
		tar.setMenuId(src.getMenuId());		
		tar.setCreateTime(src.getCreateTime());		
		tar.setUpdateTime(src.getUpdateTime());		
		tar.setCompanyId(src.getCompanyId());		
		return tar;
	}

	public static List<RoleMenuDTO> toDTO(List<RoleMenuVO> srcs) {
		if (srcs == null)
			return null;
		List<RoleMenuDTO> list = new ArrayList<RoleMenuDTO>();
		for (RoleMenuVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<RoleMenuVO> toVO(List<RoleMenuDTO> srcs) {
		if (srcs == null)
			return null;
		List<RoleMenuVO> list = new ArrayList<RoleMenuVO>();
		for (RoleMenuDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	