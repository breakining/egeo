package com.egeo.basics.user.dao.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.egeo.basics.user.po.RoleMenuPlatformPO;
import com.egeo.basics.user.po.UserPlatformPO;
import com.egeo.core.orm.BaseReadDAO;

public interface RoleMenuPlatformReadDAO extends BaseReadDAO<RoleMenuPlatformPO>{

	List<String> getMenuList(@Param("po") UserPlatformPO po);
}
	