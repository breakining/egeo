package com.egeo.back.user.web.action;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.RoleManage;
import com.egeo.back.user.business.RoleMenuPlatformManage;
import com.egeo.basics.user.model.dto.RoleDTO;
import com.egeo.core.web.BaseSpringController;



@Controller
@RequestMapping("roleMenuPlatform")
public class RoleMenuPlatformAction extends BaseSpringController {
	
	@Resource(name="roleMenuPlatform")
	private RoleMenuPlatformManage roleMenuPlatformManage;
	
	@Resource(name="role")
	private RoleManage  roleManage;
	
	@RequestMapping(value = "List")
	@ResponseBody
	public List<String> getMenuList(String userId, String checkedStr){
		//根据rid获取到role
		RoleDTO dto = roleManage.findRoleByRoleName(userId);
		//获取到被选中的权限的集合
		/*if("".equals(checkedStr)){//页面上没有选择权限
			dto.setPrivileges(null);
		}else{
			Set<Privilege> privileges = this.privilegeService.getEntriesByIds(this.checkedStr.split(","));
			//建立角色与权限之间的关系
			role.setPrivileges(privileges);
		}
		this.roleService.updateEntry(role);*/
		return null;
		
	}
	
}
	