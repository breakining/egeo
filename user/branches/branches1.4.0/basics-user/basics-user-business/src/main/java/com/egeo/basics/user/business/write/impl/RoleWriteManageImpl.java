package com.egeo.basics.user.business.write.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.RoleWriteManage;
import com.egeo.basics.user.dao.write.RoleMenuWriteDAO;
import com.egeo.basics.user.dao.write.RoleWriteDAO;
import com.egeo.basics.user.po.RoleMenuPO;
import com.egeo.basics.user.po.RolePO;
import com.egeo.basics.user.po.RoleUrl;

@Service
public class RoleWriteManageImpl implements RoleWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RoleWriteDAO roleWriteDAO;
	@Autowired
        private RoleMenuWriteDAO roleMenuWriteDAO;
	@Override
	public Long saveRoleWithTx(RolePO po) {
	    int i = roleWriteDAO.insert(po);
		return po.getId();
	}
	@Override
	public int removeRoleWithTx(String name) {
		
		RolePO po = new RolePO();
		po.setName(name);
		return roleWriteDAO.delete(po);
		
	}
	@Override
	public int updateRoleWithTx(RolePO po) {
		
		return roleWriteDAO.update(po);
	}
        @Override
        public int upDate(RolePO po) {
            
            return roleWriteDAO.update(po);
        }
        @Override
        public int delMenu(StringBuffer delMenu, Long roleId) {
            String menus = delMenu.toString();
            RoleUrl roleMenu = new RoleUrl();
            roleMenu.setRoleId(roleId);
            roleMenu.setUrls(menus);
            return roleWriteDAO.delMenu(roleMenu);
        }
        @Override
        public int setMenu(List<String> setMenu, Long roleId) {
            int row = 0;
            for (String s : setMenu) {
                RoleMenuPO po = new RoleMenuPO();
                po.setRoleId(roleId);
                //long result = Long.parseLong(s); 返回long基本数据类型
                Long result = Long.valueOf(s);//返回Long包装类型
                po.setMenuId(result);
                row += roleMenuWriteDAO.insert(po);
            }
            return row;
        }
        @Override
        public int deleteByIdWithTx(RolePO po) {
            
            return roleWriteDAO.delete(po);
        }
	
}
	