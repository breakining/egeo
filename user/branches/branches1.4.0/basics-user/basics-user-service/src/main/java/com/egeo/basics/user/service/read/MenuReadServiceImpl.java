package com.egeo.basics.user.service.read;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.MenuReadService;
import com.egeo.basics.user.api.read.PlatformReadService;
import com.egeo.basics.user.business.read.MenuReadManage;
import com.egeo.basics.user.converter.MenuConverter;
import com.egeo.basics.user.model.dto.Menu;
import com.egeo.basics.user.model.dto.MenuDTO;
import com.egeo.basics.user.model.dto.PlatformDTO;
import com.egeo.basics.user.po.MenuPO;
import com.egeo.core.Constant.PlatformKeyConstant;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.JsonResult;

@Service("menuReadService")
public class MenuReadServiceImpl extends BaseService implements MenuReadService {
    @Autowired
    private MenuReadManage menuReadManage;
    
    @Autowired
    private PlatformReadService platformReadService;

    @Override
    public JsonResult<PageResult<Menu>> findWithTx(Pagination page,MenuDTO menuDTO) {
        PlatformDTO platformDTO = null;
        //判断平台id是否为空，如果为空则默认为迩格员工
        if(menuDTO.getPlatformId().equals(PlatformKeyConstant.PLATFORMID)){
            platformDTO = new PlatformDTO();
            platformDTO.setName("迩格");
        }else{
            platformDTO = platformReadService.find(menuDTO.getPlatformId());
        }
        
        List<MenuPO> list = menuReadManage.find(MenuConverter.toPO(menuDTO));
        
        //递规list结构转树结构
        List<Menu> menuList = new ArrayList<Menu>();
        for (MenuPO menuPO : list) {
            Menu menu = new Menu();
            menu.setId(menuPO.getId());
            menu.setTitle(menuPO.getName());
            menu.setIndex(menuPO.getHref());
            menu.setIcon(menuPO.getIcon());
            menu.setIsShow(menuPO.getIsShow());
            menu.setParentId(menuPO.getParentId());
            menu.setSort(menuPO.getSort());
            menuList.add(menu);
        }

        List<Menu> sortList = new ArrayList<Menu>();
        for (Menu tree : menuList) {
            for (Menu t : menuList) {
                if (t.getParentId().equals(tree.getId())) {
                    if (tree.getChildren() == null) {
                        List<Menu> myChildrens = new ArrayList<Menu>();
                        myChildrens.add(t);
                        tree.setChildren(myChildrens);
                    } else {
                        tree.getChildren().add(t);
                    }
                }
            }
            if (tree.getParentId().equals(PlatformKeyConstant.PLATFORMID)) {
                sortList.add(tree);
            }
        }
        
        List<Menu> Lists = new ArrayList<Menu>();
        for (int i = 0; i < page.getPageSize(); i++) {
            if ((((page.getPageNo() - 1) * page.getPageSize()) + i) == sortList.size()) {
                break;
            }
            Lists.add(sortList.get((((page.getPageNo() - 1) * page.getPageSize()) + i)));
        }

        PageResult<Menu> result = new PageResult<Menu>();
        result.setList(Lists);
        result.setPageNo(page.getPageNo());
        result.setPageSize(page.getPageSize());
        result.setTotalSize(sortList.size());

        JsonResult<PageResult<Menu>> lists = new JsonResult<PageResult<Menu>>();
        lists.setData(result);
        return lists;

    }

    @Override
    public MenuDTO getMenuIdWithTx(Long menuId) {
        MenuPO menuPO = menuReadManage.getMenuId(menuId);
        MenuPO po = this.getPId(menuPO,menuPO);
        return MenuConverter.toDTO(po);
    }

    // 循环获取pid
    public MenuPO getPId(MenuPO menuPO,MenuPO menupo) {
        if(!menuPO.getParentId().equals(PlatformKeyConstant.PLATFORMID)){
            if (menupo.getPid() == null) {
                List<Long> pid = new ArrayList<Long>();
                pid.add(0, menuPO.getParentId());
                menupo.setPid(pid);
            } else {
                List<Long> list = menupo.getPid();
                list.add(0, menuPO.getParentId());
                menupo.setPid(list);
            }
            MenuPO menu = menuReadManage.getMenuId(menuPO.getParentId());
            getPId(menu,menupo);
        }
        return menupo;
    }

    @Override
    public List<Menu> getMenuListByUserIdWithTx(Long UserId,Long platformId) {
        List<MenuPO> list = menuReadManage.getMenuListByUserId(UserId,platformId);
        
        List<Menu> menuList = new ArrayList<Menu>();
        for (MenuPO menuPO : list) {
            Menu menu = new Menu();
            menu.setId(menuPO.getId());
            menu.setTitle(menuPO.getName());
            menu.setIndex(menuPO.getHref());
            menu.setIcon(menuPO.getIcon());
            menu.setIsShow(menuPO.getIsShow());
            menu.setParentId(menuPO.getParentId());
            menu.setSort(menuPO.getSort());
            menuList.add(menu);
        }

        return menuList;
    }

    @Override
    public List<MenuDTO> getMenu(Long parentId) {
        List<MenuPO> list = menuReadManage.getMenu(parentId);
        return MenuConverter.toDTO(list);
    }

    @Override
    public JsonResult<List<Menu>> showMenuWithTx(Long roleId,Long platformId) {
        // 加载所有菜单
        MenuPO po = new MenuPO();
        po.setPlatformId(platformId);
        List<MenuPO> list = menuReadManage.find(po);
        List<MenuDTO> dto = MenuConverter.toDTO(list);
        // 加载角色所能访问的菜单
        List<MenuPO> list2 = menuReadManage.menuListByroleId(roleId);
        for (MenuDTO menuDTO : dto) {// 遍历所有的菜单
            for (MenuPO menuPO : list2) {// 遍历角色的菜单
                // 如果当前正在遍历的所有的菜单中的该项是角色能够访问到的
                if (menuDTO.getId().equals(menuPO.getId())) {
                    menuDTO.setChecked(true);
                }
            }
        }
        
        //递规list结构转树结构
        List<Menu> menuList = new ArrayList<Menu>();
        for (MenuPO menuPO : list) {
            Menu menu = new Menu();
            menu.setId(menuPO.getId());
            menu.setTitle(menuPO.getName());
            menu.setIndex(menuPO.getHref());
            menu.setIcon(menuPO.getIcon());
            menu.setIsShow(menuPO.getIsShow());
            menu.setParentId(menuPO.getParentId());
            menu.setSort(menuPO.getSort());
            menuList.add(menu);
        }

        List<Menu> sortList = new ArrayList<Menu>();
        for (Menu tree : menuList) {
            for (Menu t : menuList) {
                if (t.getParentId().equals(tree.getId())) {
                    if (tree.getChildren() == null) {
                        List<Menu> myChildrens = new ArrayList<Menu>();
                        myChildrens.add(t);
                        tree.setChildren(myChildrens);
                    } else {
                        tree.getChildren().add(t);
                    }
                }
            }
            if (tree.getParentId().equals(PlatformKeyConstant.PLATFORMID)) {
                sortList.add(tree);
            }
        }
        JsonResult<List<Menu>> jsonResult = new JsonResult<List<Menu>>();
        jsonResult.setData(sortList);
        return jsonResult;
    }

    @Override
    public List<MenuDTO> menuByPlatformId(Long platformId) {
        List<MenuPO> list = menuReadManage.menuByPlatformId(platformId);
        return MenuConverter.toDTO(list);
    }

    @Override
    public JsonResult<List<MenuDTO>> menuByRoleId(Long roleId) {
        JsonResult<List<MenuDTO>> jsonResult = new JsonResult<List<MenuDTO>>();
        List<MenuPO> list = menuReadManage.menuListByroleId(roleId);
        
        jsonResult.setData(MenuConverter.toDTO(list));
        return jsonResult;
    }
    
    //递规list结构转树结构
    public List<Menu> MenuPOTOMenu(List<MenuPO> list){
        List<Menu> menuList = new ArrayList<Menu>();
        for (MenuPO menuPO : list) {
            Menu menu = new Menu();
            menu.setId(menuPO.getId());
            menu.setTitle(menuPO.getName());
            menu.setIndex(menuPO.getHref());
            menu.setIcon(menuPO.getIcon());
            menu.setIsShow(menuPO.getIsShow());
            menu.setParentId(menuPO.getParentId());
            menu.setSort(menuPO.getSort());
            menuList.add(menu);
        }

        List<Menu> sortList = new ArrayList<Menu>();
        for (Menu tree : menuList) {
            for (Menu t : menuList) {
                if (t.getParentId().equals(tree.getId())) {
                    if (tree.getChildren() == null) {
                        List<Menu> myChildrens = new ArrayList<Menu>();
                        myChildrens.add(t);
                        tree.setChildren(myChildrens);
                    } else {
                        tree.getChildren().add(t);
                    }
                }
            }
            if (tree.getParentId().equals(PlatformKeyConstant.PLATFORMID)) {
                sortList.add(tree);
            }
        }
        return sortList;
    }

	@Override
	public List<Menu> menuAllByMenuIds(String menus) {
		List<MenuPO> menuAll = menuReadManage.menuAllByMenuIds(menus);
		List<Menu> menuList = new ArrayList<Menu>();
        for (MenuPO menuPO : menuAll) {
            Menu menu = new Menu();
            menu.setId(menuPO.getId());
            menu.setTitle(menuPO.getName());
            menu.setIndex(menuPO.getHref());
            menu.setIcon(menuPO.getIcon());
            menu.setIsShow(menuPO.getIsShow());
            menu.setParentId(menuPO.getParentId());
            menu.setSort(menuPO.getSort());
            menuList.add(menu);
        }
		return menuList;
	}

	@Override
	public List<Menu> menuByMenuIds(String menuIds) {
		List<MenuPO> menuAll = menuReadManage.menuByMenuIds(menuIds);
		List<Menu> menuList = new ArrayList<Menu>();
        for (MenuPO menuPO : menuAll) {
            Menu menu = new Menu();
            menu.setId(menuPO.getId());
            menu.setTitle(menuPO.getName());
            menu.setIndex(menuPO.getHref());
            menu.setIcon(menuPO.getIcon());
            menu.setIsShow(menuPO.getIsShow());
            menu.setParentId(menuPO.getParentId());
            menu.setSort(menuPO.getSort());
            menuList.add(menu);
        }
		return menuList;
	}

}
