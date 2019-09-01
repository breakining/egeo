package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserLoginDTO;
import com.egeo.back.user.model.vo.UserLoginVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-08-12 19:16:15
 */
public class UserLoginConverter {
	
	public static UserLoginDTO toDTO(UserLoginVO src) {
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

	public static UserLoginVO toVO(UserLoginDTO src) {
		UserLoginVO tar = new UserLoginVO();
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

	public static List<UserLoginDTO> toDTO(List<UserLoginVO> srcs) {
		if (srcs == null)
			return null;
		List<UserLoginDTO> list = new ArrayList<UserLoginDTO>();
		for (UserLoginVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserLoginVO> toVO(List<UserLoginDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserLoginVO> list = new ArrayList<UserLoginVO>();
		for (UserLoginDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	