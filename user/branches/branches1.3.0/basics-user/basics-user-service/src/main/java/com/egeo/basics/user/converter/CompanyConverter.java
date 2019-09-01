package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.CompanyDTO;
import com.egeo.basics.user.po.CompanyPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author min
 * @date 2017-08-15 15:29:16
 */
public class CompanyConverter {
	
	public static CompanyDTO toDTO(CompanyPO src) {
		CompanyDTO tar = new CompanyDTO();
		tar.setId(src.getId());
		tar.setName(src.getName());
		tar.setIsAvailable(src.getIsAvailable());
		tar.setRemark(src.getRemark());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		return tar;
	}

	public static CompanyPO toPO(CompanyDTO src) {
		CompanyPO tar = new CompanyPO();
		tar.setId(src.getId());
		tar.setName(src.getName());
		tar.setIsAvailable(src.getIsAvailable());
		tar.setRemark(src.getRemark());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		return tar;
	}

	public static List<CompanyDTO> toDTO(List<CompanyPO> srcs) {
		if (srcs == null)
			return null;
		List<CompanyDTO> list = new ArrayList<CompanyDTO>();
		for (CompanyPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<CompanyPO> toPO(List<CompanyDTO> srcs) {
		if (srcs == null)
			return null;
		List<CompanyPO> list = new ArrayList<CompanyPO>();
		for (CompanyDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	