package com.egeo.back.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.back.user.model.vo.UserVO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-05-15 15:43:24
 */
public class UserConverter {
	
	public static UserDTO toDTO(UserVO src) {
		UserDTO tar = new UserDTO();
		tar.setId(src.getId());
		tar.setLoginName(src.getLoginName());
		tar.setPassword(src.getPassword());
		tar.setMobile(src.getMobile());
		tar.setMail(src.getMail());
		tar.setDelFlag(src.getDelFlag());
		tar.setQrcode(src.getQrcode());
		tar.setToken(src.getToken());
		tar.setSalt(src.getSalt());
		tar.setUpdateSalt(src.getUpdateSalt());
		tar.setCompanyId(src.getCompanyId());
		tar.setBeginTime(src.getBeginTime());
		tar.setFinishTime(src.getFinishTime());
		return tar;
	}

	public static UserVO toVO(UserDTO src) {
		UserVO tar = new UserVO();
		tar.setId(src.getId());
		tar.setLoginName(src.getLoginName());
		tar.setPassword(src.getPassword());
		tar.setMobile(src.getMobile());
		tar.setMail(src.getMail());
		tar.setDelFlag(src.getDelFlag());
		tar.setQrcode(src.getQrcode());
		tar.setToken(src.getToken());
		tar.setSalt(src.getSalt());
		tar.setUpdateSalt(src.getUpdateSalt());
		tar.setCompanyId(src.getCompanyId());
		tar.setBeginTime(src.getBeginTime());
                tar.setFinishTime(src.getFinishTime());
		return tar;
	}

	public static List<UserDTO> toDTO(List<UserVO> srcs) {
		if (srcs == null)
			return null;
		List<UserDTO> list = new ArrayList<UserDTO>();
		for (UserVO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserVO> toVO(List<UserDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserVO> list = new ArrayList<UserVO>();
		for (UserDTO src : srcs) {
			list.add(toVO(src));
		}
		return list;
	}
}
	