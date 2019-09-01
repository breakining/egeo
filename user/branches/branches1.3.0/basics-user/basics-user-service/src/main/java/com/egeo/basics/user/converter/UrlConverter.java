package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.basics.user.po.UrlPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-08-12 19:17:06
 */
public class UrlConverter {
	
	public static UrlDTO toDTO(UrlPO src) {
		UrlDTO tar = new UrlDTO();
		tar.setId(src.getId());
		tar.setUrl(src.getUrl());
		tar.setName(src.getName());
		tar.setDescription(src.getDescription());
		tar.setPlatformId(src.getPlatformId());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setCompanyId(src.getCompanyId());
		return tar;
	}

	public static UrlPO toPO(UrlDTO src) {
		UrlPO tar = new UrlPO();
		tar.setId(src.getId());
		tar.setUrl(src.getUrl());
		tar.setName(src.getName());
		tar.setDescription(src.getDescription());
		tar.setPlatformId(src.getPlatformId());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setCompanyId(src.getCompanyId());
		return tar;
	}

	public static List<UrlDTO> toDTO(List<UrlPO> srcs) {
		if (srcs == null)
			return null;
		List<UrlDTO> list = new ArrayList<UrlDTO>();
		for (UrlPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UrlPO> toPO(List<UrlDTO> srcs) {
		if (srcs == null)
			return null;
		List<UrlPO> list = new ArrayList<UrlPO>();
		for (UrlDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	