package com.egeo.back.user.web.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.MenuManage;
import com.egeo.back.user.model.vo.CacheUser;
import com.egeo.back.user.model.vo.MenuVO;
import com.egeo.basics.user.model.dto.Menu;
import com.egeo.basics.user.model.dto.MenuDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;

@Controller
@RequestMapping("menu")
public class MenuAction extends BaseSpringController {
    private static final String ADMINUSER = "admin"; 
    @Resource(name = "menu")
    private MenuManage MenuManage;

    /**
     * 按条件查询所有菜单
     * 
     * @param dto
     * @return
     */
    @RequestMapping(value = "menuList")
    @ResponseBody
    public JsonResult<PageResult<Menu>> find(Pagination page) {
        return MenuManage.find(page);
    }

    /**
     * 根据用户id查询需要显示的菜单
     * 
     * @param dto
     * @return
     */
    @RequestMapping(value = "showList")
    @ResponseBody
    public JsonResult<List<Menu>> findShow(HttpServletRequest req, HttpServletResponse res) {
        CacheUser userCache = (CacheUser) req.getAttribute("ut");
        JsonResult<List<Menu>> lists = new JsonResult<List<Menu>>();
        Long id = null;
        if (userCache != null) {
            id = userCache.getId();
        }
        if (id != null) {
          //判断是否为admin，是返回所有
            if(userCache.getLoginName().equals(ADMINUSER)){
                JsonResult<PageResult<Menu>> jsonResult = find(new Pagination());
                PageResult<Menu> result = jsonResult.getData();
                JsonResult<List<Menu>> list = new JsonResult<List<Menu>>();
                list.setData(result.getList());
                return list;
            }
            if (logger.isInfoEnabled()) {
                logger.info("根据用户id查询菜单,  id = {}", id);
            }
            List<Menu> list = MenuManage.getMenuListByUserId(id);
            if (logger.isInfoEnabled()) {
                logger.info("根据用户id查询菜单成功,  id = {}", id);
            }
            lists.setData(list);
            return lists;
        }else{
            lists.setCode(1);
            lists.setError("系统出错,请联系管理员！");
            return lists;
        }
    }

    /**
     * 根据菜单Id查询菜单
     * @return
     */
    @RequestMapping(value = "getId")
    @ResponseBody
    public JsonResult<MenuDTO> getMenuId(Long menuId) {
        JsonResult<MenuDTO> result = new JsonResult<MenuDTO>();
        if(menuId != null){
            MenuDTO menuDTO = MenuManage.getMenuId(menuId);
            result.setData(menuDTO);
            return result;
        }else{
            result.setCode(1);
            result.setError("系统出错,请联系管理员！");
            return result;
        }
        
    }

    /**
     * 更新
     */
    @RequestMapping(value = "saveOrUpdate")
    @ResponseBody
    public JsonResult<String> saveOrUpdate(@Valid MenuVO vo, BindingResult br, HttpServletRequest req) {
        CacheUser userCache = (CacheUser) req.getAttribute("ut");       
        JsonResult<String> result = new JsonResult<String>();
        if (br.hasErrors()) { // 如果实体类校验失败
            List<ObjectError> errors = br.getAllErrors();
            result.setError(errors.get(0).getDefaultMessage());
            result.setCode(1);
            return result;
        }else{
            try {
                if (logger.isInfoEnabled()) {
                    logger.info("更新菜单, MenuDTO = {}", vo);
                }
                String id = MenuManage.saveOrUpdate(vo,vo.getName());
                if (logger.isInfoEnabled()) {
                    logger.info("更新菜单成功, MenuDTOName = {}", vo.getName());
                }
                result.setData(id);
                return result;
            } catch (Exception e) {
                logger.error("更新菜单异常！ MenuName = " + vo.getName(), e);
            }
            result.setCode(1);
            result.setError("更新菜单失败");
            return result;
        }
    }

    /**
     * 根据菜单id删除
     * 
     * @param dto
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public JsonResult<String> delete(MenuDTO dto) {
        if(dto.getId() != null){
            try {
                if (logger.isInfoEnabled()) {
                    logger.info("删除菜单, MenuDTOID = {}", dto.getId());
                }
                MenuManage.deleteWithTx(dto);
                if (logger.isInfoEnabled()) {
                    logger.info("删除菜单成功, MenuDTOID = {}", dto.getId());
                }
                return success(null);
            } catch (Exception e) {
                logger.error("删除菜单失败！ name = " + dto.getName() + ",mid = " + dto.getId(), e);
            }
            return success("删除菜单失败");
        }else{
            return success("系统出错,请联系管理员！");
        }
        
    }

    /**
     * 查询所有的菜单，通过角色所拥有的菜单判断是否选中
     */
    @RequestMapping(value = "showMenu", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult<List<MenuDTO>> showMenu(Long roleId) {
        return MenuManage.showMenuWithTx(roleId);
    }

}
