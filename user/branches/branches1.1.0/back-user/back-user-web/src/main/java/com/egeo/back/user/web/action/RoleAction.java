package com.egeo.back.user.web.action;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.RoleManage;
import com.egeo.basics.user.model.dto.RoleDTO;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.util.cache.JedisUtil;



@Controller
@RequestMapping("role")
public class RoleAction extends BaseSpringController {
	
	@Resource(name="role")
	private RoleManage roleManage;
	
	@RequestMapping(value = "role1")
	@ResponseBody
	public JsonResult<String> role1() {
		
/*		JsonResult<List<RoleDTO>> result = new JsonResult<List<RoleDTO>>();
		List<RoleDTO> dto = roleManage.findRoleListByUserId(id);
		result.setData(dto);		
		return  result;*/
		return success("登录成功");
	}
	
	@RequestMapping(value = "role2")
	@ResponseBody
	public JsonResult<String> role2() {
		
/*		JsonResult<List<RoleDTO>> result = new JsonResult<List<RoleDTO>>();
		List<RoleDTO> dto = roleManage.findRoleListByUserId(id);
		result.setData(dto);		
		return  result;*/

		return success("登录成功");
	}
		
}
	