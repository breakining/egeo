package com.egeo.back.user.business.impl;
	

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.egeo.back.user.business.UserWelfareManage;
import com.egeo.back.user.facade.UserWelfareFacade;
import com.egeo.basics.user.model.dto.UserWelfareDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("userWelfare")
public class UserWelfareManageImpl implements UserWelfareManage{

	
	@Resource(name="userWelfareFacade")
	private UserWelfareFacade userWelfareFacade;

	@Override
	public UserWelfareDTO findUserWelfareById(UserWelfareDTO dto) {
		return userWelfareFacade.findUserWelfareById(dto);
	}

	@Override
	public PageResult<UserWelfareDTO> findUserWelfareOfPage(UserWelfareDTO dto, Pagination page) {
		return userWelfareFacade.findUserWelfareOfPage(dto, page);
	}

	@Override
	public List<UserWelfareDTO> findUserWelfareAll(UserWelfareDTO dto) {
		return userWelfareFacade.findUserWelfareAll(dto);
	}

	@Override
	public Long insertUserWelfareWithTx(UserWelfareDTO dto) {
		return userWelfareFacade.insertUserWelfareWithTx(dto);
	}

	@Override
	public int updateUserWelfareWithTx(UserWelfareDTO dto) {
		return userWelfareFacade.updateUserWelfareWithTx(dto);
	}

	@Override
	public int deleteUserWelfareWithTx(UserWelfareDTO dto) {
		return userWelfareFacade.deleteUserWelfareWithTx(dto);
	}
	/**
	 * 福管+根据用户id修改用户扩展表信息(部门、入职时间)
	 * @param dto
	 * @return
	 */
	@Override
	public int updateUserWelfareByUserIdWithTx(UserWelfareDTO dto) {
		
		return userWelfareFacade.updateUserWelfareByUserIdWithTx(dto);
	}


}
	