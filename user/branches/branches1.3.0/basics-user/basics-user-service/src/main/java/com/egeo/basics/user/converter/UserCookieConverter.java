package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserCookieDTO;
import com.egeo.basics.user.po.UserCookiePO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-08-12 19:17:06
 */
public class UserCookieConverter {
	
	public static UserCookieDTO toDTO(UserCookiePO src) {
		UserCookieDTO tar = new UserCookieDTO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setCookieName(src.getCookieName());
		tar.setCookieValue(src.getCookieValue());
		tar.setDomain(src.getDomain());
		tar.setPath(src.getPath());
		tar.setExpirationTime(src.getExpirationTime());
		tar.setCompanyId(src.getCompanyId());
		tar.setPlatformId(src.getPlatformId());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		return tar;
	}

	public static UserCookiePO toPO(UserCookieDTO src) {
		UserCookiePO tar = new UserCookiePO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setCookieName(src.getCookieName());
		tar.setCookieValue(src.getCookieValue());
		tar.setDomain(src.getDomain());
		tar.setPath(src.getPath());
		tar.setExpirationTime(src.getExpirationTime());
		tar.setCompanyId(src.getCompanyId());
		tar.setPlatformId(src.getPlatformId());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		return tar;
	}

	public static List<UserCookieDTO> toDTO(List<UserCookiePO> srcs) {
		if (srcs == null)
			return null;
		List<UserCookieDTO> list = new ArrayList<UserCookieDTO>();
		for (UserCookiePO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserCookiePO> toPO(List<UserCookieDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserCookiePO> list = new ArrayList<UserCookiePO>();
		for (UserCookieDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	