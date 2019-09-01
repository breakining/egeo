package com.egeo.basics.user.dao.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.egeo.basics.user.po.MenuPO;
import com.egeo.core.orm.BaseReadDAO;

public interface MenuReadDAO extends BaseReadDAO<MenuPO> {

    List<MenuPO> getMenuListByUserId(@Param("userId")Long userId,@Param("platformId")Long platformId);

    List<MenuPO> menuListByroleId(Long roleId);

    List<MenuPO> menuByPlatformId(Long platformId);

	List<MenuPO> menuAllByMenuIds(@Param("menus")String menus);

	List<MenuPO> menuByMenuIds(@Param("menuIds")String menuIds);
}
