package com.egeo.basics.user.dao.read;

import java.util.List;

import com.egeo.basics.user.condition.MenuCondition;
import com.egeo.basics.user.po.MenuPO;
import com.egeo.core.orm.BaseReadDAO;

public interface MenuReadDAO extends BaseReadDAO<MenuPO> {

    List<MenuCondition> getMenuListByUserId(Long userId);

    List<MenuPO> menuListByroleId(Long roleId);
}
