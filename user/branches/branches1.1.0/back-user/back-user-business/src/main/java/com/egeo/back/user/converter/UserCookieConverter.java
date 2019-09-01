package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserCookieDTO;
import com.egeo.back.user.model.vo.UserCookieVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-05-11 20:02:25
 */
public class UserCookieConverter {
	
	public static UserCookieDTO toDTO(UserCookieVO src) {
		UserCookieDTO tar = new UserCookieDTO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setUserLoginId(src.getUserLoginId());
		tar.setType(src.getType());
		tar.setCookieName(src.getCookieName());
		tar.setCookieValue(src.getCookieValue());
		tar.setDomain(src.getDomain());
		tar.setPath(src.getPath());
		tar.setExpirationTime(src.getExpirationTime());
		tar.setIsAvailable(src.getIsAvailable());
		tar.setIsDeleted(src.getIsDeleted());
		tar.setVersionNo(src.getVersionNo());
		tar.setCreateUserid(src.getCreateUserid());
		tar.setCreateUsername(src.getCreateUsername());
		tar.setCreateUserip(src.getCreateUserip());
		tar.setCreateUsermac(src.getCreateUsermac());
		tar.setCreateTime(src.getCreateTime());
		tar.setCreateTimeDb(src.getCreateTimeDb());
		tar.setServerIp(src.getServerIp());
		tar.setUpdateUserid(src.getUpdateUserid());
		tar.setUpdateUsername(src.getUpdateUsername());
		tar.setUpdateUserip(src.getUpdateUserip());
		tar.setUpdateUsermac(src.getUpdateUsermac());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setUpdateTimeDb(src.getUpdateTimeDb());
		tar.setClientVersionno(src.getClientVersionno());
		tar.setCompanyId(src.getCompanyId());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static UserCookieVO toVO(UserCookieDTO src) {
		UserCookieVO tar = new UserCookieVO();
		tar.setId(src.getId());
		tar.setUserId(src.getUserId());
		tar.setUserLoginId(src.getUserLoginId());
		tar.setType(src.getType());
		tar.setCookieName(src.getCookieName());
		tar.setCookieValue(src.getCookieValue());
		tar.setDomain(src.getDomain());
		tar.setPath(src.getPath());
		tar.setExpirationTime(src.getExpirationTime());
		tar.setIsAvailable(src.getIsAvailable());
		tar.setIsDeleted(src.getIsDeleted());
		tar.setVersionNo(src.getVersionNo());
		tar.setCreateUserid(src.getCreateUserid());
		tar.setCreateUsername(src.getCreateUsername());
		tar.setCreateUserip(src.getCreateUserip());
		tar.setCreateUsermac(src.getCreateUsermac());
		tar.setCreateTime(src.getCreateTime());
		tar.setCreateTimeDb(src.getCreateTimeDb());
		tar.setServerIp(src.getServerIp());
		tar.setUpdateUserid(src.getUpdateUserid());
		tar.setUpdateUsername(src.getUpdateUsername());
		tar.setUpdateUserip(src.getUpdateUserip());
		tar.setUpdateUsermac(src.getUpdateUsermac());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setUpdateTimeDb(src.getUpdateTimeDb());
		tar.setClientVersionno(src.getClientVersionno());
		tar.setCompanyId(src.getCompanyId());
		tar.setPlatformId(src.getPlatformId());
		return tar;
	}

	public static List<UserCookieDTO> toDTO(List<UserCookieVO> srcs) {
		if (srcs == null)
			return null;
		List<UserCookieDTO> list = new ArrayList<UserCookieDTO>();
		for (UserCookieVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserCookieVO> toVO(List<UserCookieDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserCookieVO> list = new ArrayList<UserCookieVO>();
		for (UserCookieDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	