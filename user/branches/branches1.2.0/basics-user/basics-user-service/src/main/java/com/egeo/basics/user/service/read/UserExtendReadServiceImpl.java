package com.egeo.basics.user.service.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.read.UserExtendReadService;
import com.egeo.basics.user.business.read.UserExtendReadManage;
import com.egeo.basics.user.converter.UserExtendConverter;
import com.egeo.basics.user.model.dto.UserExtendDTO;

@Service("userExtendReadService")
public class UserExtendReadServiceImpl extends BaseService implements UserExtendReadService {
	@Autowired
	private UserExtendReadManage userExtendReadManage;

	@Override
	public UserExtendDTO findById(Long id) {
		// TODO Auto-generated method stub
		return UserExtendConverter.toDTO(userExtendReadManage.findById(id));
	}
}
	