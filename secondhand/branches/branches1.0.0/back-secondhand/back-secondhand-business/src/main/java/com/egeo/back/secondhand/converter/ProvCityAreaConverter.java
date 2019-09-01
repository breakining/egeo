package com.egeo.back.secondhand.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.secondhand.model.dto.ProvCityAreaDTO;
import com.egeo.back.secondhand.model.vo.ProvCityAreaVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author min
 * @date 2017-11-29 15:37:10
 */
public class ProvCityAreaConverter {
	
	public static ProvCityAreaDTO toDTO(ProvCityAreaVO src) {
		if (src == null)
		return null;	
		ProvCityAreaDTO tar = new ProvCityAreaDTO();
		tar.setId(src.getId());
		tar.setAreaname(src.getAreaname());	
		tar.setParentno(src.getParentno());	
		tar.setAreacode(src.getAreacode());	
		tar.setArealevel(src.getArealevel());	
		tar.setTypename(src.getTypename());	
		return tar;
	}

	public static ProvCityAreaVO toVO(ProvCityAreaDTO src) {
		if (src == null)
		return null;	
		ProvCityAreaVO tar = new ProvCityAreaVO();
		tar.setId(src.getId());
		tar.setAreaname(src.getAreaname());	
		tar.setParentno(src.getParentno());	
		tar.setAreacode(src.getAreacode());	
		tar.setArealevel(src.getArealevel());	
		tar.setTypename(src.getTypename());	
		return tar;
	}

	public static List<ProvCityAreaDTO> toDTO(List<ProvCityAreaVO> srcs) {
		if (srcs == null)
			return null;
		List<ProvCityAreaDTO> list = new ArrayList<ProvCityAreaDTO>();
		for (ProvCityAreaVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<ProvCityAreaVO> toVO(List<ProvCityAreaDTO> srcs) {
		if (srcs == null)
			return null;
		List<ProvCityAreaVO> list = new ArrayList<ProvCityAreaVO>();
		for (ProvCityAreaDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	