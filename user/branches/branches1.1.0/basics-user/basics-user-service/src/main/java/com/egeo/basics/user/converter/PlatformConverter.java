package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.PlatformDTO;
import com.egeo.basics.user.po.PlatformPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-05-05 09:20:24
 */
public class PlatformConverter {
	
	public static PlatformDTO toDTO(PlatformPO src) {
		PlatformDTO tar = new PlatformDTO();
		tar.setId(src.getId());
		tar.setName(src.getName());
		tar.setIsAvailable(src.getIsAvailable());
		tar.setDelFlag(src.getDelFlag());
		return tar;
	}

	public static PlatformPO toPO(PlatformDTO src) {
		PlatformPO tar = new PlatformPO();
		tar.setId(src.getId());
		tar.setName(src.getName());
		tar.setIsAvailable(src.getIsAvailable());
		tar.setDelFlag(src.getDelFlag());
		return tar;
	}

	public static List<PlatformDTO> toDTO(List<PlatformPO> srcs) {
		if (srcs == null)
			return null;
		List<PlatformDTO> list = new ArrayList<PlatformDTO>();
		for (PlatformPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<PlatformPO> toPO(List<PlatformDTO> srcs) {
		if (srcs == null)
			return null;
		List<PlatformPO> list = new ArrayList<PlatformPO>();
		for (PlatformDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	