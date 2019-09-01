package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserWelfareDTO;
import com.egeo.basics.user.po.UserWelfarePO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author min
 * @date 2017-11-15 18:32:41
 */
public class UserWelfareConverter {
	
	public static UserWelfareDTO toDTO(UserWelfarePO src) {
		if (src == null)
		return null;	
		UserWelfareDTO tar = new UserWelfareDTO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setDepartmentId(src.getDepartmentId());
		tar.setEntryTime(src.getEntryTime());
		return tar;
	}

	public static UserWelfarePO toPO(UserWelfareDTO src) {
		if (src == null)
		return null;	
		UserWelfarePO tar = new UserWelfarePO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setDepartmentId(src.getDepartmentId());
		tar.setEntryTime(src.getEntryTime());
		return tar;
	}

	public static List<UserWelfareDTO> toDTO(List<UserWelfarePO> srcs) {
		if (srcs == null)
			return null;
		List<UserWelfareDTO> list = new ArrayList<UserWelfareDTO>();
		for (UserWelfarePO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserWelfarePO> toPO(List<UserWelfareDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserWelfarePO> list = new ArrayList<UserWelfarePO>();
		for (UserWelfareDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	