package com.egeo.basics.read.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.read.model.dto.ParentChildrenDTO;
import com.egeo.basics.read.po.ParentChildrenPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author min
 * @date 2017-11-15 10:02:29
 */
public class ParentChildrenConverter {
	
	public static ParentChildrenDTO toDTO(ParentChildrenPO src) {
		if (src == null)
		return null;	
		ParentChildrenDTO tar = new ParentChildrenDTO();
		tar.setId(src.getId());
		tar.setParentId(src.getParentId());
		tar.setChildId(src.getChildId());
		return tar;
	}

	public static ParentChildrenPO toPO(ParentChildrenDTO src) {
		if (src == null)
		return null;	
		ParentChildrenPO tar = new ParentChildrenPO();
		tar.setId(src.getId());
		tar.setParentId(src.getParentId());
		tar.setChildId(src.getChildId());
		return tar;
	}

	public static List<ParentChildrenDTO> toDTO(List<ParentChildrenPO> srcs) {
		if (srcs == null)
			return null;
		List<ParentChildrenDTO> list = new ArrayList<ParentChildrenDTO>();
		for (ParentChildrenPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<ParentChildrenPO> toPO(List<ParentChildrenDTO> srcs) {
		if (srcs == null)
			return null;
		List<ParentChildrenPO> list = new ArrayList<ParentChildrenPO>();
		for (ParentChildrenDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	