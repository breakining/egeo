package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.DepartmentRelationDTO;
import com.egeo.back.user.model.vo.DepartmentRelationVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author min
 * @date 2017-12-03 04:17:15
 */
public class DepartmentRelationConverter {
	
	public static DepartmentRelationDTO toDTO(DepartmentRelationVO src) {
		if (src == null)
		return null;	
		DepartmentRelationDTO tar = new DepartmentRelationDTO();
		tar.setId(src.getId());
		tar.setPid(src.getPid());	
		tar.setDepartmentId(src.getDepartmentId());	
		return tar;
	}

	public static DepartmentRelationVO toVO(DepartmentRelationDTO src) {
		if (src == null)
		return null;	
		DepartmentRelationVO tar = new DepartmentRelationVO();
		tar.setId(src.getId());
		tar.setPid(src.getPid());	
		tar.setDepartmentId(src.getDepartmentId());	
		return tar;
	}

	public static List<DepartmentRelationDTO> toDTO(List<DepartmentRelationVO> srcs) {
		if (srcs == null)
			return null;
		List<DepartmentRelationDTO> list = new ArrayList<DepartmentRelationDTO>();
		for (DepartmentRelationVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<DepartmentRelationVO> toVO(List<DepartmentRelationDTO> srcs) {
		if (srcs == null)
			return null;
		List<DepartmentRelationVO> list = new ArrayList<DepartmentRelationVO>();
		for (DepartmentRelationDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	