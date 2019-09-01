package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.RoleUrlDTO;
import com.egeo.basics.user.po.RoleUrlPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-05-09 18:46:54
 */
public class RoleUrlConverter {
	
	public static RoleUrlDTO toDTO(RoleUrlPO src) {
		RoleUrlDTO tar = new RoleUrlDTO();
		tar.setId(src.getId());
		tar.setRoleId(src.getRoleId());
		tar.setUrlId(src.getUrlId());
		return tar;
	}

	public static RoleUrlPO toPO(RoleUrlDTO src) {
		RoleUrlPO tar = new RoleUrlPO();
		tar.setId(src.getId());
		tar.setRoleId(src.getRoleId());
		tar.setUrlId(src.getUrlId());
		return tar;
	}

	public static List<RoleUrlDTO> toDTO(List<RoleUrlPO> srcs) {
		if (srcs == null)
			return null;
		List<RoleUrlDTO> list = new ArrayList<RoleUrlDTO>();
		for (RoleUrlPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<RoleUrlPO> toPO(List<RoleUrlDTO> srcs) {
		if (srcs == null)
			return null;
		List<RoleUrlPO> list = new ArrayList<RoleUrlPO>();
		for (RoleUrlDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	