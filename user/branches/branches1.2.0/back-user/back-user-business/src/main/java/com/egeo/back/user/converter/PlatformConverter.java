package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.PlatformDTO;
import com.egeo.back.user.model.vo.PlatformVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-05-15 15:43:23
 */
public class PlatformConverter {
	
	public static PlatformDTO toDTO(PlatformVO src) {
		PlatformDTO tar = new PlatformDTO();
		tar.setId(src.getId());
		tar.setName(src.getName());
		tar.setIsAvailable(src.getIsAvailable());
		tar.setDelFlag(src.getDelFlag());
		return tar;
	}

	public static PlatformVO toVO(PlatformDTO src) {
		PlatformVO tar = new PlatformVO();
		tar.setId(src.getId());
		tar.setName(src.getName());
		tar.setIsAvailable(src.getIsAvailable());
		tar.setDelFlag(src.getDelFlag());
		return tar;
	}

	public static List<PlatformDTO> toDTO(List<PlatformVO> srcs) {
		if (srcs == null)
			return null;
		List<PlatformDTO> list = new ArrayList<PlatformDTO>();
		for (PlatformVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<PlatformVO> toVO(List<PlatformDTO> srcs) {
		if (srcs == null)
			return null;
		List<PlatformVO> list = new ArrayList<PlatformVO>();
		for (PlatformDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	