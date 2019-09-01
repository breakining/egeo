package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.DepartmentDTO;
import com.egeo.back.user.model.vo.DepartmentVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author min
 * @date 2017-11-17 18:10:53
 */
public class DepartmentConverter {
	
	public static DepartmentDTO toDTO(DepartmentVO src) {
		if (src == null)
		return null;	
		DepartmentDTO tar = new DepartmentDTO();
		tar.setId(src.getId());
		tar.setCompanyId(src.getCompanyId());
		tar.setDepartmentName(src.getDepartmentName());	
		tar.setpId(src.getpId());
		tar.setSortValue(src.getSortValue());	
		return tar;
	}

	public static DepartmentVO toVO(DepartmentDTO src) {
		if (src == null)
		return null;	
		DepartmentVO tar = new DepartmentVO();
		tar.setId(src.getId());
		tar.setCompanyId(src.getCompanyId());
		tar.setDepartmentName(src.getDepartmentName());	
		tar.setpId(src.getpId());
		tar.setSortValue(src.getSortValue());	
		return tar;
	}

	public static List<DepartmentDTO> toDTO(List<DepartmentVO> srcs) {
		if (srcs == null)
			return null;
		List<DepartmentDTO> list = new ArrayList<DepartmentDTO>();
		for (DepartmentVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<DepartmentVO> toVO(List<DepartmentDTO> srcs) {
		if (srcs == null)
			return null;
		List<DepartmentVO> list = new ArrayList<DepartmentVO>();
		for (DepartmentDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	