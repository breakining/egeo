package com.egeo.back.user.web.action;

import javax.annotation.Resource;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.UserRoleManage;
import com.egeo.back.user.model.vo.UserRoleVO;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
/**
 * 用户角色控制层
 * @author 闵浮龙
 *
 */
@Controller
@RequestMapping("user/userRole")
public class UserRoleAction extends BaseSpringController{

    @Resource(name="userRole")
    private UserRoleManage userRoleManage;
    
    @RequestMapping(value = "updataUserRole")
    @ResponseBody
    public JsonResult<String> updataUserRole(UserRoleVO userRoleVO) {
        JsonResult<String> result = new JsonResult<String>();
        String rows = null;
        if(userRoleVO.getChecked().endsWith("1")){
            rows = userRoleManage.save(userRoleVO);
        }else{
            rows = userRoleManage.deleteWithTx(userRoleVO);
        }
        result.setSuccess("更新成功");
        result.setData(rows);
            return result;
    }
}
