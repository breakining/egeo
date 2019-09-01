package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.po.UserPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-08-19 11:18:51
 */
public class UserConverter {
	
	public static UserDTO toDTO(UserPO src) {
		UserDTO tar = new UserDTO();
		tar.setId(src.getId());
		tar.setLoginName(src.getLoginName());
		tar.setName(src.getName());
		tar.setPassword(src.getPassword());
		tar.setMobile(src.getMobile());
		tar.setMail(src.getMail());
		tar.setQrcode(src.getQrcode());
		tar.setSalt(src.getSalt());
		tar.setUpdateSalt(src.getUpdateSalt());
		tar.setCompanyId(src.getCompanyId());
		tar.setBeginTime(src.getBeginTime());
		tar.setFinishTime(src.getFinishTime());
		tar.setIsAvailable(src.getIsAvailable());
		tar.setName(src.getName());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		return tar;
	}

	public static UserPO toPO(UserDTO src) {
		UserPO tar = new UserPO();
		tar.setId(src.getId());
		tar.setLoginName(src.getLoginName());
		tar.setName(src.getName());
		tar.setPassword(src.getPassword());
		tar.setMobile(src.getMobile());
		tar.setMail(src.getMail());
		tar.setQrcode(src.getQrcode());
		tar.setSalt(src.getSalt());
		tar.setUpdateSalt(src.getUpdateSalt());
		tar.setCompanyId(src.getCompanyId());
		tar.setBeginTime(src.getBeginTime());
        tar.setFinishTime(src.getFinishTime());
		tar.setIsAvailable(src.getIsAvailable());
		tar.setCreateTime(src.getCreateTime());
		tar.setName(src.getName());	
		tar.setUpdateTime(src.getUpdateTime());
		return tar;
	}

	public static List<UserDTO> toDTO(List<UserPO> srcs) {
		if (srcs == null)
			return null;
		List<UserDTO> list = new ArrayList<UserDTO>();
		for (UserPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserPO> toPO(List<UserDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserPO> list = new ArrayList<UserPO>();
		for (UserDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	