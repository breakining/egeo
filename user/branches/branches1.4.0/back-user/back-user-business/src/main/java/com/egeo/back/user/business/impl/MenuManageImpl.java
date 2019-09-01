package com.egeo.back.user.business.impl;
	

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.user.business.MenuManage;
import com.egeo.back.user.converter.MenuConverter;
import com.egeo.back.user.facade.MenuFacade;
import com.egeo.back.user.model.vo.MenuVO;
import com.egeo.basics.user.model.dto.Menu;
import com.egeo.basics.user.model.dto.MenuDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.JsonResult;

@Service("menu")
public class MenuManageImpl implements MenuManage{

	
	@Resource(name="menuFacade")
	private MenuFacade menuFacade;
	
	@Override
	public JsonResult<PageResult<Menu>> find(Pagination page,MenuVO menuVO) {
		return menuFacade.find(page,MenuConverter.toDTO(menuVO));
		
	}

	@Override
	public MenuDTO getMenuId(Long menuId) {
		return menuFacade.getMenuId(menuId);
	}

	@Override
	public String saveOrUpdate(MenuVO vo,String userName) {
		return menuFacade.saveOrUpdate(MenuConverter.toDTO(vo),userName);
	}

	@Override
	public void deleteWithTx(MenuDTO dto) {
		menuFacade.deleteWithTx(dto);
		
	}

	@Override
	public List<Menu> getMenuListByUserId(Long UserId,Long platformId) {
		
		return menuFacade.getMenuListByUserId(UserId,platformId);
	}

	@Override
	public List<MenuDTO> getMenu(Long parentId) {
		
		return menuFacade.getMenu(parentId);
	}

    @Override
    public JsonResult<List<Menu>> showMenuWithTx(Long roleId,Long platformId) {
        
        return menuFacade.showMenuWithTx(roleId,platformId);
    }

    @Override
    public List<MenuDTO> menuByPlatformId(Long platformId) {
        return menuFacade.menuByPlatformId(platformId);
    }

    @Override
    public JsonResult<List<MenuDTO>> menuByRoleId(Long roleId) {
        
        return menuFacade.menuByRoleId(roleId);
    }

	}
	