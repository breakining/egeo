package com.egeo.basics.user.dao.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.egeo.basics.user.condition.MenuCondition;
import com.egeo.basics.user.po.MenuPO;
import com.egeo.core.orm.BaseReadDAO;

public interface MenuReadDAO extends BaseReadDAO<MenuPO> {

    List<MenuCondition> getMenuListByUserId(@Param("userId")Long userId,@Param("companyId")Long companyId);

    List<MenuPO> menuListByroleId(Long roleId);

    List<MenuPO> menuByPlatformId(Long companyId);
}
