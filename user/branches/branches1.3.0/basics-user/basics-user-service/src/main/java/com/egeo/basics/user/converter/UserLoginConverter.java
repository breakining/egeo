package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserLoginDTO;
import com.egeo.basics.user.po.UserLoginPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-08-12 19:17:06
 */
public class UserLoginConverter {
	
	public static UserLoginDTO toDTO(UserLoginPO src) {
		UserLoginDTO tar = new UserLoginDTO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setUsername(src.getUsername());
		tar.setLoginResult(src.getLoginResult());
		tar.setLoginTime(src.getLoginTime());
		tar.setIp(src.getIp());
		tar.setBrowser(src.getBrowser());
		tar.setCompanyId(src.getCompanyId());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static UserLoginPO toPO(UserLoginDTO src) {
		UserLoginPO tar = new UserLoginPO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setUsername(src.getUsername());
		tar.setLoginResult(src.getLoginResult());
		tar.setLoginTime(src.getLoginTime());
		tar.setIp(src.getIp());
		tar.setBrowser(src.getBrowser());
		tar.setCompanyId(src.getCompanyId());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static List<UserLoginDTO> toDTO(List<UserLoginPO> srcs) {
		if (srcs == null)
			return null;
		List<UserLoginDTO> list = new ArrayList<UserLoginDTO>();
		for (UserLoginPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserLoginPO> toPO(List<UserLoginDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserLoginPO> list = new ArrayList<UserLoginPO>();
		for (UserLoginDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	