package com.egeo.basics.user.service.write;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.write.RoleWriteService;
import com.egeo.basics.user.business.read.MenuReadManage;
import com.egeo.basics.user.business.write.RoleWriteManage;
import com.egeo.basics.user.converter.RoleConverter;
import com.egeo.basics.user.model.dto.RoleDTO;
import com.egeo.basics.user.po.MenuPO;
import com.egeo.core.basics.service.BaseService;

@Service("roleWriteService")
public class RoleWriteServiceImpl extends BaseService implements RoleWriteService {
    @Autowired
    private RoleWriteManage roleWriteManage;

    @Autowired
    private MenuReadManage menuReadManage;

    @Override
    public int saveRoleWithTx(RoleDTO roleDTO, String userName) {
        roleDTO.setCreateDate(new Date());
        roleDTO.setCreateBy(userName);
        roleDTO.setUpdateDate(roleDTO.getCreateDate());
        roleDTO.setUpdateBy(userName);
        return roleWriteManage.saveRoleWithTx(RoleConverter.toPO(roleDTO));
    }

    @Override
    public int removeRoleWithTx(String name) {
        // TODO Auto-generated method stub
        return roleWriteManage.removeRoleWithTx(name);

    }

    @Override
    public int updateRoleWithTx(RoleDTO dto) {
        // TODO Auto-generated method stub
        return roleWriteManage.updateRoleWithTx(RoleConverter.toPO(dto));
    }

    @Override
    public int upDateUserWithTx(RoleDTO roleDTO, String userName) {
        // TODO Auto-generated method stub
        roleDTO.setCreateDate(new Date());
        roleDTO.setUpdateBy(userName);
        return roleWriteManage.upDate(RoleConverter.toPO(roleDTO));
    }

    @Override
    public int upDateRoleWithTx(String menus, Long roleId) {
        // 根据角色id查找menu集合
        List<MenuPO> list = menuReadManage.menuListByroleId(roleId);
        // 根据字符串截取list
        List<String> menuList = Arrays.asList(menus.split(","));

        // 查找需要删除的menu关系
        StringBuffer delMenu = new StringBuffer();
        for (MenuPO menuPO : list) {
            if (!menuList.contains(menuPO.getId() + "")) {
                delMenu.append(menuPO.getId() + ",");
            }
        }
        // 查找需要添加的menu关系
        List<String> ids = new ArrayList<String>();
        for (MenuPO menuPO : list) {
            ids.add(menuPO.getId() + "");
        }
        List<String> setMenu = new ArrayList<String>();
        for (String string : menuList) {
            if (!ids.contains(string)) {
                setMenu.add(string);
            }
        }
        if (delMenu.length() > 0) {
            delMenu.deleteCharAt(delMenu.length() - 1);
        }

        int row = 0;
        if (delMenu.length() > 0) {
            // 调用批量删除的方法
            row = roleWriteManage.delMenu(delMenu, roleId);
        }

        if (setMenu != null) {
            // 调用批量添加的方法
            row = roleWriteManage.setMenu(setMenu, roleId);
        }

        return row;
    }

}
