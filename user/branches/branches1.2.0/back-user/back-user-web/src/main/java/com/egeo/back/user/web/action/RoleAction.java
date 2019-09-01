package com.egeo.back.user.web.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.RoleManage;
import com.egeo.back.user.model.vo.CacheUser;
import com.egeo.basics.user.model.dto.RoleDTO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.utils.str.StringUtils;

@Controller
@RequestMapping("role")
public class RoleAction extends BaseSpringController {

    @Resource(name = "role")
    private RoleManage roleManage;

    /**
     * 新增角色
     * 
     * @param role
     * @return
     */
    @RequestMapping(value = "addRole")
    @ResponseBody
    public JsonResult<Integer> addRole(RoleDTO role, HttpServletRequest req) {
        CacheUser userCache = (CacheUser) req.getAttribute("ut");
        JsonResult<Integer> result = new JsonResult<Integer>();
        RoleDTO dto = roleManage.findRoleByRoleName(role.getName());
        if (dto == null) {
            int id = roleManage.saveRoleWithTx(role,role.getName());
            result.setData(id);
            return result;
        } else {
            result.setCode(BusinessExceptionConstant.ROLE_EXIST);
            result.setError("角色已经存在");
            return result;
        }
    }

    /**
     * 删除角色
     * 
     * @param role
     * @return
     */
    @RequestMapping(value = "deleteRole")
    @ResponseBody
    public JsonResult<Integer> deleteRole(RoleDTO roleDto) {

        JsonResult<Integer> result = new JsonResult<Integer>();
        int roleid = roleManage.removeRoleWithTx(roleDto.getName());
        result.setData(roleid);
        return result;
    }

    /**
     * 根据用户name
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "getRoleName")
    @ResponseBody
    public JsonResult<RoleDTO> getRoleId(String roleName) {

        JsonResult<RoleDTO> result = new JsonResult<RoleDTO>();
        RoleDTO roleDto = roleManage.findRoleByRoleName(roleName);
        result.setData(roleDto);
        return result;
    }

    /**
     * 更新角色
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "updateRoleById")
    @ResponseBody
    public JsonResult<Integer> updateRoleById(RoleDTO roleDTO, HttpServletRequest req) {
        CacheUser userCache = (CacheUser) req.getAttribute("ut");
        
        JsonResult<Integer> result = new JsonResult<Integer>();
        RoleDTO dto = roleManage.findRoleByRoleName(roleDTO.getName());
        if (dto == null) {
            int id = roleManage.saveRoleWithTx(roleDTO,roleDTO.getName());
            result.setData(id);
            return result;
        } else {
            if (StringUtils.isNotEmpty(roleDTO.getIsSys())) {
                dto.setIsSys(roleDTO.getIsSys());
            }
            if (StringUtils.isNotEmpty(roleDTO.getEnname())) {
                dto.setEnname(roleDTO.getEnname());
            }
            if (StringUtils.isNotEmpty(roleDTO.getRemarks())) {
                dto.setRemarks(roleDTO.getRemarks());
            }
            if (StringUtils.isNotEmpty(roleDTO.getRoleType())) {
                dto.setRoleType(roleDTO.getRoleType());
            }
            int id = roleManage.upDateUserWithTx(dto,roleDTO.getName());
            result.setData(id);
            return result;
        }

    }

    /**
     * 查询所有角色
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "findAll")
    @ResponseBody
    public JsonResult<List<RoleDTO>> findAll(RoleDTO dto) {
        JsonResult<List<RoleDTO>> result = new JsonResult<List<RoleDTO>>();
        result.setData(roleManage.findAll(dto));
        return result;
    }

    /**
     * 根据平台id查询角色
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "roleByPlatformId")
    @ResponseBody
    public JsonResult<List<RoleDTO>> roleByPlatformId(String PlatformId) {
        JsonResult<List<RoleDTO>> result = new JsonResult<List<RoleDTO>>();
        result.setData(roleManage.roleByPlatformId(PlatformId));
        return result;
    }
    
    /**
     * 更新角色的菜单
     */
    @RequestMapping(value = "upDate")
    @ResponseBody
    public int upDateRoleWithTx(String menus,Long roleId){
        return roleManage.upDateRoleWithTx(menus,roleId);
    }
    

}
