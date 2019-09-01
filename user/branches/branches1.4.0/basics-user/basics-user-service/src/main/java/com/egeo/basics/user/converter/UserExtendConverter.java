package com.egeo.basics.user.converter;

import java.util.ArrayList;
import java.util.List;

import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.basics.user.po.UserExtendPO;

/**
 * DTO和PO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-08-18 18:50:29
 */
public class UserExtendConverter {
	
	public static UserExtendDTO toDTO(UserExtendPO src) {
		UserExtendDTO tar = new UserExtendDTO();
		tar.setId(src.getId());
		tar.setSex(src.getSex());
		tar.setNickname(src.getNickname());
		tar.setHeadPicUrl(src.getHeadPicUrl());
		tar.setName(src.getName());
		tar.setRegtime(src.getRegtime());
		tar.setBirthday(src.getBirthday());
		tar.setMobile(src.getMobile());
		tar.setQq(src.getQq());
		tar.setMemberCode(src.getMemberCode());
		tar.setRemark(src.getRemark());
		tar.setLastlogin(src.getLastlogin());
		tar.setActivityInfo(src.getActivityInfo());
		tar.setIsComplete(src.getIsComplete());
		tar.setDeviceId(src.getDeviceId());
		tar.setDeviceType(src.getDeviceType());
		tar.setWeixin(src.getWeixin());
		tar.setWorkaddressId(src.getWorkaddressId());
		tar.setStatus(src.getStatus());
		tar.setAddress(src.getAddress());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setPlatformId(src.getPlatformId());
		tar.setBirthdayStartTime(src.getBirthdayStartTime());
		tar.setBirthdayFinishTime(src.getBirthdayFinishTime());
		tar.setEntryStartTime(src.getEntryStartTime());
		tar.setEntryFinishTime(src.getEntryFinishTime());
		return tar;
	}

	public static UserExtendPO toPO(UserExtendDTO src) {
		UserExtendPO tar = new UserExtendPO();
		tar.setId(src.getId());
		tar.setSex(src.getSex());
		tar.setNickname(src.getNickname());
		tar.setHeadPicUrl(src.getHeadPicUrl());
		tar.setName(src.getName());
		tar.setRegtime(src.getRegtime());
		tar.setBirthday(src.getBirthday());
		tar.setMobile(src.getMobile());
		tar.setQq(src.getQq());
		tar.setMemberCode(src.getMemberCode());
		tar.setRemark(src.getRemark());
		tar.setLastlogin(src.getLastlogin());
		tar.setActivityInfo(src.getActivityInfo());
		tar.setIsComplete(src.getIsComplete());
		tar.setDeviceId(src.getDeviceId());
		tar.setDeviceType(src.getDeviceType());
		tar.setWeixin(src.getWeixin());
		tar.setWorkaddressId(src.getWorkaddressId());
		tar.setStatus(src.getStatus());
		tar.setAddress(src.getAddress());
		tar.setCreateTime(src.getCreateTime());
		tar.setUpdateTime(src.getUpdateTime());
		tar.setPlatformId(src.getPlatformId());
		tar.setBirthdayStartTime(src.getBirthdayStartTime());
		tar.setBirthdayFinishTime(src.getBirthdayFinishTime());
		tar.setEntryStartTime(src.getEntryStartTime());
		tar.setEntryFinishTime(src.getEntryFinishTime());
		return tar;
	}

	public static List<UserExtendDTO> toDTO(List<UserExtendPO> srcs) {
		if (srcs == null)
			return null;
		List<UserExtendDTO> list = new ArrayList<UserExtendDTO>();
		for (UserExtendPO src : srcs) {
			list.add(toDTO(src));
		}
		return list;
	}

	public static List<UserExtendPO> toPO(List<UserExtendDTO> srcs) {
		if (srcs == null)
			return null;
		List<UserExtendPO> list = new ArrayList<UserExtendPO>();
		for (UserExtendDTO src : srcs) {
			list.add(toPO(src));
		}
		return list;
	}
}
	