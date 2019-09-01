package com.egeo.basics.user.business.read;

import java.util.List;

import com.egeo.basics.user.condition.MenuCondition;
import com.egeo.basics.user.po.MenuPO;

public interface MenuReadManage {

    public List<MenuPO> find(MenuPO po);

    public MenuPO getMenuId(Long menuId);

    public List<MenuCondition> getMenuListByUserId(Long UserId,Long platformId);

    public List<MenuPO> getMenu(Long parentId);

    public List<MenuPO> menuListByroleId(Long roleId);

    public List<MenuPO> menuByPlatformId(Long platformId);
}
