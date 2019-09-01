package com.egeo.back.user.web.action;


import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.UserPlatformManage;
import com.egeo.back.user.model.vo.UserPlatformVO;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;


/**
 * 用户平台控制层
 * @author 闵浮龙
 *
 */
@Controller
@RequestMapping("user/userPlatform")
public class UserPlatformAction extends BaseSpringController {
	
	@Resource(name="userPlatform")
	private UserPlatformManage userPlatformManage;
	
	/**
         *修改平台与用户关系信息
         * @return
         */
        @RequestMapping(value = "updataUserAndPlatform")
        @ResponseBody
        public JsonResult<String> PlatformByUserId(UserPlatformVO platformVO){
            String rows = null;
            if(platformVO.getChecked().equals("1")){
                rows = userPlatformManage.save(platformVO);
            }else{
                rows = userPlatformManage.deleteByUserIdAndPid(platformVO);
            }
            JsonResult<String> result = new JsonResult<String>();
            result.setData(rows);
            return result;
        }
        
        /**
         *修改平台与用户表信息
         * @return
         */
        @RequestMapping(value = "update")
        @ResponseBody
        public JsonResult<String> update(UserPlatformVO platformVO){
            String rows = userPlatformManage.update(platformVO);
            JsonResult<String> result = new JsonResult<String>();
            result.setData(rows);
            return result;
        }
        
        /**
         *修改平台与用户表信息
         * @return
         */
        @RequestMapping(value = "updateAll")
        @ResponseBody
        public JsonResult<String> updateAll(UserPlatformVO platformVO){
            String rows = userPlatformManage.updateAll(platformVO);
            JsonResult<String> result = new JsonResult<String>();
            result.setData(rows);
            return result;
        }
        
	
}
	