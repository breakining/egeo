package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserExtraInfoDTO;
import com.egeo.basics.user.po.UserExtraInfoPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-08-18 18:50:29
 */
public class UserExtraInfoConverter {
	
	public static UserExtraInfoDTO toDTO(UserExtraInfoPO src) {
		UserExtraInfoDTO tar = new UserExtraInfoDTO();
		tar.setId(src.getId());
		tar.setTableName(src.getTableName());
		tar.setIsExist(src.getIsExist());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		return tar;
	}

	public static UserExtraInfoPO toPO(UserExtraInfoDTO src) {
		UserExtraInfoPO tar = new UserExtraInfoPO();
		tar.setId(src.getId());
		tar.setTableName(src.getTableName());
		tar.setIsExist(src.getIsExist());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		return tar;
	}

	public static List<UserExtraInfoDTO> toDTO(List<UserExtraInfoPO> srcs) {
		if (srcs == null)
			return null;
		List<UserExtraInfoDTO> list = new ArrayList<UserExtraInfoDTO>();
		for (UserExtraInfoPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserExtraInfoPO> toPO(List<UserExtraInfoDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserExtraInfoPO> list = new ArrayList<UserExtraInfoPO>();
		for (UserExtraInfoDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	