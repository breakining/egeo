package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.write.UserWelfareWriteService;
import com.egeo.basics.user.business.write.UserWelfareWriteManage;
import com.egeo.basics.user.converter.UserWelfareConverter;
import com.egeo.basics.user.model.dto.UserWelfareDTO;
import com.egeo.basics.user.po.UserWelfarePO;

@Service("userWelfareWriteService")
public class UserWelfareWriteServiceImpl extends BaseService implements UserWelfareWriteService {
	@Autowired
	private UserWelfareWriteManage userWelfareWriteManage;

	@Override
	public Long insertUserWelfareWithTx(UserWelfareDTO dto) {
		UserWelfarePO po = UserWelfareConverter.toPO(dto);
		Long rt = userWelfareWriteManage.insertUserWelfareWithTx(po);		
		return rt;
	}

	@Override
	public int updateUserWelfareWithTx(UserWelfareDTO dto) {
		UserWelfarePO po = UserWelfareConverter.toPO(dto);
		int rt = userWelfareWriteManage.updateUserWelfareWithTx(po);		
		return rt;
	}

	@Override
	public int deleteUserWelfareWithTx(UserWelfareDTO dto) {
		UserWelfarePO po = UserWelfareConverter.toPO(dto);
		int rt = userWelfareWriteManage.deleteUserWelfareWithTx(po);		
		return rt;
	}
	/**
	 * 福管+根据用户id修改用户扩展表信息(部门、入职时间)
	 * @param dto
	 * @return
	 */
	@Override
	public int updateUserWelfareByUserIdWithTx(UserWelfareDTO dto) {
		
		return userWelfareWriteManage.updateUserWelfareByUserIdWithTx(UserWelfareConverter.toPO(dto));
	}
}
	