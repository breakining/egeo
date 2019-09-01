/*package com.egeo.back.user.web.action.auth.util;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import com.egeo.back.user.business.RoleManage;
import com.egeo.back.user.business.UserManage;





*//**
 * Shiro用户，主要是让Shiro能够支持多字段的方式登录系统。 目前实现账号、联系电话、和邮箱三种登录方式。 如果还不能满足需求可以扩展该类。
 * 
 * @author lucas
 *//*
public class ShiroUser  {

	@Resource(name="user")
	private UserManage userManage;
	
	@Resource(name="role")
	private RoleManage roleManage;
	
	public Set<String> getPermissions() {
		Set<String> results = new HashSet<String>();
		
		Set<PermissionDTO> permissions = getSecurityAccessFacade().findPermissionsByUserAccountAndRoleName(userAccount, roleName);
		for (PermissionDTO permission : permissions) {
			results.add(permission.getIdentifier());
		}
		return results;
	}
	
	@SuppressWarnings("unchecked")
	public String getRoleNameByUserAccount() {
		InvokeResult result = getSecurityAccessFacade().findRolesByUserAccount(userAccount);
		if (result.isSuccess()) {
			List<RoleDTO> roles = (List<RoleDTO>) result.getData();
			if (!roles.isEmpty()) {
				return roles.get(0).getName();
			}
			return "暂未分配角色"; 
		}
		return "暂未分配角色";
	}



	@Override
	public String toString() {
		return new ToStringBuilder(this).append(getUserAccount()).append(getName()).append(getRoleName()).append(getTelePhone()).append(getEmail()).build();
	}

	public SecurityAccessFacade getSecurityAccessFacade() {
		if (securityAccessFacade == null) {
			securityAccessFacade = InstanceFactory.getInstance(SecurityAccessFacade.class);
		}
		return securityAccessFacade;
	}
	
}
*/