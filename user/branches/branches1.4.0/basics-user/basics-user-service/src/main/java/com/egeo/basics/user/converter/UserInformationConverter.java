package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserInformationDTO;
import com.egeo.basics.user.po.UserInformationPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author min
 * @date 2017-11-30 14:56:28
 */
public class UserInformationConverter {
	
	public static UserInformationDTO toDTO(UserInformationPO src) {
		if (src == null)
		return null;	
		UserInformationDTO tar = new UserInformationDTO();
		tar.setId(src.getId());
		tar.setHeadline(src.getHeadline());
		tar.setHeadlineContent(src.getHeadlineContent());
		tar.setUserId(src.getUserId());
		tar.setDispatchUserId(src.getDispatchUserId());
		tar.setType(src.getType());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static UserInformationPO toPO(UserInformationDTO src) {
		if (src == null)
		return null;	
		UserInformationPO tar = new UserInformationPO();
		tar.setId(src.getId());
		tar.setHeadline(src.getHeadline());
		tar.setHeadlineContent(src.getHeadlineContent());
		tar.setUserId(src.getUserId());
		tar.setDispatchUserId(src.getDispatchUserId());
		tar.setType(src.getType());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static List<UserInformationDTO> toDTO(List<UserInformationPO> srcs) {
		if (srcs == null)
			return null;
		List<UserInformationDTO> list = new ArrayList<UserInformationDTO>();
		for (UserInformationPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserInformationPO> toPO(List<UserInformationDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserInformationPO> list = new ArrayList<UserInformationPO>();
		for (UserInformationDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	