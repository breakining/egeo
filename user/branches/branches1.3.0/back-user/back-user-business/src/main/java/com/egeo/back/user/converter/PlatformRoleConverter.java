package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.PlatformRoleDTO;
import com.egeo.back.user.model.vo.PlatformRoleVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-08-12 19:16:15
 */
public class PlatformRoleConverter {
	
	public static PlatformRoleDTO toDTO(PlatformRoleVO src) {
		PlatformRoleDTO tar = new PlatformRoleDTO();
		tar.setId(src.getId());
		tar.setPlatformId(src.getPlatformId());	
		tar.setRoleId(src.getRoleId());	
		tar.setCreateTime(src.getCreateTime());	
		tar.setUpdateTime(src.getUpdateTime());	
		tar.setCompanyId(src.getCompanyId());	
		return tar;
	}

	public static PlatformRoleVO toVO(PlatformRoleDTO src) {
		PlatformRoleVO tar = new PlatformRoleVO();
		tar.setId(src.getId());
		tar.setPlatformId(src.getPlatformId());		
		tar.setRoleId(src.getRoleId());		
		tar.setCreateTime(src.getCreateTime());		
		tar.setUpdateTime(src.getUpdateTime());		
		tar.setCompanyId(src.getCompanyId());		
		return tar;
	}

	public static List<PlatformRoleDTO> toDTO(List<PlatformRoleVO> srcs) {
		if (srcs == null)
			return null;
		List<PlatformRoleDTO> list = new ArrayList<PlatformRoleDTO>();
		for (PlatformRoleVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<PlatformRoleVO> toVO(List<PlatformRoleDTO> srcs) {
		if (srcs == null)
			return null;
		List<PlatformRoleVO> list = new ArrayList<PlatformRoleVO>();
		for (PlatformRoleDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	