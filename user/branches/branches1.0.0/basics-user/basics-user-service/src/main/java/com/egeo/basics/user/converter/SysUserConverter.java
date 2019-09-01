package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.SysUserDTO;
import com.egeo.basics.user.po.SysUserPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-05-03 17:36:42
 */
public class SysUserConverter {
	
	public static SysUserDTO toDTO(SysUserPO src) {
		SysUserDTO tar = new SysUserDTO();
		tar.setId(src.getId());
		tar.setCompanyId(src.getCompanyId());
		tar.setOfficeId(src.getOfficeId());
		tar.setLoginName(src.getLoginName());
		tar.setPassword(src.getPassword());
		tar.setNo(src.getNo());
		tar.setName(src.getName());
		tar.setEmail(src.getEmail());
		tar.setPhone(src.getPhone());
		tar.setMobile(src.getMobile());
		tar.setUserType(src.getUserType());
		tar.setPhoto(src.getPhoto());
		tar.setLoginIp(src.getLoginIp());
		tar.setLoginDate(src.getLoginDate());
		tar.setLoginFlag(src.getLoginFlag());
		tar.setCreateBy(src.getCreateBy());
		tar.setCreateDate(src.getCreateDate());
		tar.setUpdateBy(src.getUpdateBy());
		tar.setUpdateDate(src.getUpdateDate());
		tar.setRemarks(src.getRemarks());
		tar.setDelFlag(src.getDelFlag());
		tar.setQrcode(src.getQrcode());
		tar.setSign(src.getSign());
		return tar;
	}

	public static SysUserPO toPO(SysUserDTO src) {
		SysUserPO tar = new SysUserPO();
		tar.setId(src.getId());
		tar.setCompanyId(src.getCompanyId());
		tar.setOfficeId(src.getOfficeId());
		tar.setLoginName(src.getLoginName());
		tar.setPassword(src.getPassword());
		tar.setNo(src.getNo());
		tar.setName(src.getName());
		tar.setEmail(src.getEmail());
		tar.setPhone(src.getPhone());
		tar.setMobile(src.getMobile());
		tar.setUserType(src.getUserType());
		tar.setPhoto(src.getPhoto());
		tar.setLoginIp(src.getLoginIp());
		tar.setLoginDate(src.getLoginDate());
		tar.setLoginFlag(src.getLoginFlag());
		tar.setCreateBy(src.getCreateBy());
		tar.setCreateDate(src.getCreateDate());
		tar.setUpdateBy(src.getUpdateBy());
		tar.setUpdateDate(src.getUpdateDate());
		tar.setRemarks(src.getRemarks());
		tar.setDelFlag(src.getDelFlag());
		tar.setQrcode(src.getQrcode());
		tar.setSign(src.getSign());
		return tar;
	}

	public static List<SysUserDTO> toDTO(List<SysUserPO> srcs) {
		if (srcs == null)
			return null;
		List<SysUserDTO> list = new ArrayList<SysUserDTO>();
		for (SysUserPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<SysUserPO> toPO(List<SysUserDTO> srcs) {
		if (srcs == null)
			return null;
		List<SysUserPO> list = new ArrayList<SysUserPO>();
		for (SysUserDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	