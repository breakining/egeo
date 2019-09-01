package com.egeo.basics.user.service.write;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.write.RoleWriteService;
import com.egeo.basics.user.business.read.MenuReadManage;
import com.egeo.basics.user.business.read.UrlReadManage;
import com.egeo.basics.user.business.write.MenuWriteManage;
import com.egeo.basics.user.business.write.RoleUrlWriteManage;
import com.egeo.basics.user.business.write.RoleWriteManage;
import com.egeo.basics.user.converter.RoleConverter;
import com.egeo.basics.user.model.dto.RoleDTO;
import com.egeo.basics.user.po.MenuPO;
import com.egeo.basics.user.po.UrlPO;
import com.egeo.core.basics.service.BaseService;

@Service("roleWriteService")
public class RoleWriteServiceImpl extends BaseService implements RoleWriteService {
    @Autowired
    private RoleWriteManage roleWriteManage;

    @Autowired
    private MenuReadManage menuReadManage;
    
    @Autowired
    private MenuWriteManage menuWriteManage;
    
    @Autowired
    private UrlReadManage urlReadManage;
    
    @Autowired
    private RoleUrlWriteManage roleUrlWriteManage;
    
    @Override
    public Long saveRoleWithTx(RoleDTO roleDTO, String userName) {
 
        Long roleId = roleWriteManage.saveRoleWithTx(RoleConverter.toPO(roleDTO));
        return Long.valueOf(roleId);
    }

    @Override
    public int removeRoleWithTx(String name) {
        
        return roleWriteManage.removeRoleWithTx(name);

    }

    @Override
    public int updateRoleWithTx(RoleDTO dto) {
        
        return roleWriteManage.updateRoleWithTx(RoleConverter.toPO(dto));
    }

    @Override
    public int upDateUserWithTx(RoleDTO roleDTO, String userName) {


        return roleWriteManage.upDate(RoleConverter.toPO(roleDTO));
    }

    @Override
    public int upDateRoleWithTx(String menus, Long roleId) {
        int row = 0;
        List<String> menuList = null;
        StringBuffer delMenu = new StringBuffer();
        // 根据角色id查找menu集合
        List<MenuPO> list = menuReadManage.menuListByroleId(roleId);
        String substring = menus.substring(0);
        if(substring.equals("")){
            for (MenuPO menuDTO : list) {
                delMenu.append(menuDTO.getId()+",");
            }
        }else{
                // 根据字符串截取list
                menuList = Arrays.asList(menus.split(","));
                
                // 查找需要删除的menu关系
                for (MenuPO menuPO : list) {
                    if (!menuList.contains(menuPO.getId() + "")) {
                        delMenu.append(menuPO.getId() + ",");
                    }
                }
        }
        // 查找需要添加的menu关系
        List<String> ids = new ArrayList<String>();
        for (MenuPO menuPO : list) {
            ids.add(menuPO.getId() + "");
        }
        List<String> setMenu = new ArrayList<String>();
        //判断是否有需要添加的数据
        if(menuList != null){
            for (String string : menuList) {
                if (!ids.contains(string)) {
                    setMenu.add(string);
                }
            }
        }
        
        if (delMenu.length() > 0) {
            delMenu.deleteCharAt(delMenu.length() - 1);
        }

        if (delMenu.length() > 0) {
            // 调用批量删除的方法
            row = roleWriteManage.delMenu(delMenu, roleId);
        }

        if (setMenu.size() != 0) {
            // 调用批量添加的方法
            row = roleWriteManage.setMenu(setMenu, roleId);
        }

        return row;
    }

    @Override
    public int deleteByIdWithTx(RoleDTO roleDto) {
        //删除与菜单的关系
        List<MenuPO> list2 = menuReadManage.menuListByroleId(roleDto.getId());
        StringBuffer delMenu = new StringBuffer();
        for (MenuPO menuPO : list2) {
            delMenu.append(menuPO.getId() + ",");
        }
        if (delMenu.length() > 0) {
            delMenu.deleteCharAt(delMenu.length() - 1);
        }
        
        if (delMenu.length() > 0) {
            // 调用批量删除的方法
            roleWriteManage.delMenu(delMenu, roleDto.getId());
        }
        
        //删除与url的关系
        List<UrlPO> urlByRoleId = urlReadManage.getUrlByRoleId(roleDto.getId());
        StringBuffer delUrl = new StringBuffer();
        for (UrlPO urlPO : urlByRoleId) {
            delUrl.append(urlPO.getId()+",");
        }
        if(delUrl.length() > 0){
            delUrl.deleteCharAt(delUrl.length() - 1);
        }
        
        if (delUrl.length() > 0) {
            // 调用批量删除的方法
            roleUrlWriteManage.delUrl(delUrl,roleDto.getId());
        }
        
        return roleWriteManage.deleteByIdWithTx(RoleConverter.toPO(roleDto));
    }

}
