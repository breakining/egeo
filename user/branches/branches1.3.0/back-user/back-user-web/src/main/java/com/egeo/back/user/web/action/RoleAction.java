package com.egeo.back.user.web.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.MenuManage;
import com.egeo.back.user.business.RoleManage;
import com.egeo.back.user.business.RoleMenuPlatformManage;
import com.egeo.back.user.business.RoleUrlManage;
import com.egeo.back.user.business.UrlManage;
import com.egeo.back.user.business.UserManage;
import com.egeo.back.user.business.util.TicketUtils;
import com.egeo.back.user.converter.CacheUserConverter;
import com.egeo.back.user.converter.UserConverter;
import com.egeo.back.user.model.vo.RoleVO;
import com.egeo.back.user.model.vo.UserVO;
import com.egeo.basics.user.model.dto.MenuDTO;
import com.egeo.basics.user.model.dto.PlatformRole;
import com.egeo.basics.user.model.dto.RoleDTO;
import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.common.PageResult;
import com.egeo.core.entity.CacheUser;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.util.cache.JedisUtil;
import com.egeo.utils.str.StringUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 角色控制层
 * @author 闵浮龙
 *
 */

@Controller
@RequestMapping("user/role")
public class RoleAction extends BaseSpringController {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Long PLATFORMID = 1L;

    @Resource(name = "role")
    private RoleManage roleManage;
    
    @Resource(name="roleUrl")
    private RoleUrlManage roleUrlManage;
    
    @Resource(name="userCache")
    private JedisUtil cache;
    
    @Resource(name="url")
    private UrlManage urlManage;
    
    @Resource(name = "menu")
    private MenuManage MenuManage;
    
    @Resource(name="user")
    private UserManage userManage;
    
    @Resource(name="ticketUtils")
    private TicketUtils ticketUtils; 
    
    @Resource(name="roleMenuPlatform")
    private RoleMenuPlatformManage roleMenuPlatformManage;

    /**
     * 新增角色
     * 
     * @param role
     * @return
     */
    @RequestMapping(value = "addRole")
    @ResponseBody
    public JsonResult<String> addRole(RoleDTO role, HttpServletRequest req) {
        CacheUser userCache = (CacheUser) req.getAttribute("ut");
        JsonResult<String> result = new JsonResult<String>();
        RoleDTO dto = roleManage.findRoleByRoleName(role.getName());
        if (dto == null) {
            Long id = roleManage.saveRoleWithTx(role,role.getName());
            result.setData("添加成功");
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
     * 删除角色
     * 
     * @param role
     * @return
     */
    @RequestMapping(value = "deleteById")
    @ResponseBody
    public JsonResult<Integer> deleteById(RoleDTO roleDto) {

        JsonResult<Integer> result = new JsonResult<Integer>();
        int roleid = roleManage.deleteByIdWithTx(roleDto);
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
    public JsonResult<String> updateRoleById(RoleDTO roleDTO, HttpServletRequest req) {
        CacheUser userCache = (CacheUser) req.getAttribute("ut");
        String ut = null;
        CacheUser cacheuser = null;
        JsonResult<String> result = new JsonResult<String>();
        
            try {
                //通过缓存用户id获取用户信息
                UserVO userVO = new UserVO();
                userVO.setCompanyId(userCache.getCompanyId());
                userVO.setId(userCache.getId());
                UserDTO userDTO = userManage.userById(userVO);
                
                    RoleDTO dto = roleManage.findById(roleDTO);
                    if (dto == null) {
                        Long id = roleManage.saveRoleWithTx(roleDTO,roleDTO.getName());
                        
                        //更新角色的菜单
                        upDateRoleWithTx(roleDTO.getMenus(),id);
                        
                        //更新角色的url
                        roleUrlManage.upDate(roleDTO.getUrls(),id);
                        
                        //更新用户缓存里的菜单集合和url集合
                        String utKey = "getUserUTKey" + "companyID:" +userDTO.getCompanyId() + "userName:" + userDTO.getName()+"userPassword:"+userDTO.getPassword();
                        ut =  ticketUtils.getUt(utKey);
                        if(StringUtils.isNotEmpty(ut)){
                            cacheuser = ticketUtils.getUser(ut);
                        }else{
                            cacheuser = new CacheUser();
                        }
                        
                        CacheUser setCacheUser = setCacheUser(UserConverter.toVO(userDTO),userVO.getPlatformId());
                        cache.set(ut, setCacheUser);
                        
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
                        if (StringUtils.isNotEmpty(roleDTO.getName())) {
                            dto.setName(roleDTO.getName());
                        }
                    
                        //更新角色的菜单
                        upDateRoleWithTx(roleDTO.getMenus(),roleDTO.getId());
                        
                        //更新角色的url
                        roleUrlManage.upDate(roleDTO.getUrls(),roleDTO.getId());
                        
                        int id = roleManage.upDateUserWithTx(dto,roleDTO.getName());
                        result.setData("修改成功"+id+"条");
                        
                        //更新用户缓存里的菜单集合和url集合
                        String utKey = "getUserUTKey" + "companyID:" +userDTO.getCompanyId() + "userName:" + userDTO.getName()+"userPassword:"+userDTO.getPassword();
                        ut =  ticketUtils.getUt(utKey);
                        if(StringUtils.isNotEmpty(ut)){
                            cacheuser = ticketUtils.getUser(ut);
                        }else{
                            cacheuser = new CacheUser();
                        }
                        
                        CacheUser setCacheUser = setCacheUser(UserConverter.toVO(userDTO),userVO.getPlatformId());
                        cache.set(ut, setCacheUser);
                        
                        return result;
                }
            } catch (Exception e) {
                logger.error("更新角色异常！", e);
                result.setCode(1);
                result.setError("更新角色失败:" + e.getMessage());
                return result;
            }


    }
    
        public CacheUser setCacheUser (UserVO user, Long platformId){
            Long userId = user.getId();
            CacheUser cacheUser = new CacheUser();
            cacheUser.setPlatformId(platformId);
            CacheUserConverter.setCacheUserbyUser(cacheUser,user);
            List<String> urlPath = roleUrlManage.getUrlListByUserId(userId);
            List<String> menulist = roleMenuPlatformManage.getMenuList(userId,platformId); 
            cacheUser.setUrlPath(urlPath);
            cacheUser.setMenuList(menulist);
            
            return cacheUser;
            
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
    public JsonResult<List<PlatformRole>> roleByPlatformId(String PlatformId,Long id) {
        String string = PlatformId.substring(1, PlatformId.length()-1);
        JsonResult<List<PlatformRole>> result = new JsonResult<List<PlatformRole>>();
        result.setData(roleManage.roleByPlatformId(string,id));
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
    
    /**
     * 分页查询所有角色
     * @param page
     * @param roleVO
     * @return
     */
    @RequestMapping(value = "roleListPage")
    @ResponseBody
    public JsonResult<PageResult<RoleDTO>> roleListPage(Pagination page,RoleVO roleVO) {
        JsonResult<PageResult<RoleDTO>> jsonResult = new JsonResult<PageResult<RoleDTO>>();
        if(roleVO.getPlatformId() == null){
            roleVO.setPlatformId(1L);
        }
            PageResult<RoleDTO> pageResult = roleManage.roleListPage(page, roleVO);
            jsonResult.setData(pageResult);
            return jsonResult;
    }
    
    /**
     * 根据角色id查询角色
     * 
     * @param user
     * @return
     */
    @RequestMapping(value = "findById")
    @ResponseBody
    public JsonResult<RoleDTO> findById(RoleDTO dto) {
        
        JsonResult<RoleDTO> result = new JsonResult<RoleDTO>();
        try {
            RoleDTO roleDTO = roleManage.findById(dto);
            //获得menu集合
            JsonResult<List<MenuDTO>> menuList = MenuManage.menuByRoleId(dto.getId());
            List<MenuDTO> data = menuList.getData();
            List<String> list = new ArrayList<String>();
            for (MenuDTO menuDTO : data) {
                list.add(String.valueOf(menuDTO.getId()));
            }
            String menuString = MAPPER.writeValueAsString(list).replace("\"","");
            //获得url集合
            List<UrlDTO> roleList = urlManage.getUrlByRoleId(dto.getId());
            List<String> lists = new ArrayList<String>();
            for (UrlDTO urlDTO : roleList) {
                lists.add(String.valueOf(urlDTO.getId()));
            }
            String urlString = MAPPER.writeValueAsString(lists).replace("\"","");
            roleDTO.setMenus(menuString);
            roleDTO.setUrls(urlString);
            result.setData(roleDTO);
            return result;
        } catch (Exception e) {
            logger.error("根据角色id查询角色异常！", e);
            result.setCode(1);
            result.setError("根据角色id查询角色失败:" + e.getMessage());
            return result;
        }
    }
    
}
