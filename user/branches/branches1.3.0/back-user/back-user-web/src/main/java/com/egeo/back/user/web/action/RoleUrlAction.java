package com.egeo.back.user.web.action;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.RoleUrlManage;
import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;


/**
 * 角色与ur关系控制层
 * @author 闵浮龙
 *
 */
@Controller
@RequestMapping("user/roleUrl")
public class RoleUrlAction extends BaseSpringController {
	
	@Resource(name="roleUrl")
	private RoleUrlManage roleUrlManage;
	
	
	@RequestMapping(value = "getUrlListByUserId")
	@ResponseBody
	public JsonResult<List<String>> getUrlListByUserId(Long userId) {
		
		JsonResult<List<String>> result = new JsonResult<List<String>>();
		List<String> id = roleUrlManage.getUrlListByUserId(userId);
		result.setData(id);		
		return  result;
	}
	
	/**
         * 接收角色的url集合更新角色的url
         */
	@RequestMapping(value = "upDate")
        @ResponseBody
        public int upDate(String urls,Long roleId){
            return roleUrlManage.upDate(urls,roleId);
        }
	
	/**
         * 通过角色id查询所拥有的url进行url的回显，复选框是否选中
         */
        @RequestMapping(value = "showUrl")
        @ResponseBody
        public JsonResult<List<UrlDTO>> showUrl(Long roleId,Long platformId){
            return roleUrlManage.showUrl(roleId,platformId);
        }
}
	