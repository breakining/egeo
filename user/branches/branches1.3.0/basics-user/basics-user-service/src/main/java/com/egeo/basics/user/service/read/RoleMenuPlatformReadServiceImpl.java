package com.egeo.basics.user.service.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.read.RoleMenuPlatformReadService;
import com.egeo.basics.user.business.read.RoleMenuPlatformReadManage;
import com.egeo.basics.user.po.UserPlatformPO;

@Service("roleMenuPlatformReadService")
public class RoleMenuPlatformReadServiceImpl extends BaseService implements RoleMenuPlatformReadService {
	@Autowired
	private RoleMenuPlatformReadManage roleMenuPlatformReadManage;

	@Override
	public List<String> getMenuList(Long userId, Long platformId) {
		// TODO Auto-generated method stub
		UserPlatformPO po = new UserPlatformPO();
		po.setUserId(userId);
		po.setPlatformId(platformId);
		return roleMenuPlatformReadManage.getMenuList(po);
	}
}
	