package com.egeo.back.user.business;

import java.util.List;

public interface RoleMenuPlatformManage {

	List<String> getMenuList(Long userId, Long platformId);
	

}
	