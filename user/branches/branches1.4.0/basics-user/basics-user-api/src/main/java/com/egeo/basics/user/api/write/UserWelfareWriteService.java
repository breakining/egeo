package com.egeo.basics.user.api.write;

import com.egeo.basics.user.model.dto.UserWelfareDTO;


public interface UserWelfareWriteService {

	public Long insertUserWelfareWithTx(UserWelfareDTO dto);

	public int updateUserWelfareWithTx(UserWelfareDTO dto);

	public int deleteUserWelfareWithTx(UserWelfareDTO dto);
	/**
	 * 福管+根据用户id修改用户扩展表信息(部门、入职时间)
	 * @param dto
	 * @return
	 */
	public int updateUserWelfareByUserIdWithTx(UserWelfareDTO dto);
}
	