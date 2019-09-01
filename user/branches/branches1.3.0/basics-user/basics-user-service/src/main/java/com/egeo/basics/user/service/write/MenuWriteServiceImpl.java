package com.egeo.basics.user.service.write;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.RoleReadService;
import com.egeo.basics.user.api.write.MenuWriteService;
import com.egeo.basics.user.api.write.RoleMenuWriteService;
import com.egeo.basics.user.business.read.MenuReadManage;
import com.egeo.basics.user.business.write.MenuWriteManage;
import com.egeo.basics.user.converter.MenuConverter;
import com.egeo.basics.user.model.dto.MenuDTO;
import com.egeo.basics.user.model.dto.RoleDTO;
import com.egeo.basics.user.model.dto.RoleMenuDTO;
import com.egeo.basics.user.po.MenuPO;
import com.egeo.core.Constant.PlatformKeyConstant;
import com.egeo.core.basics.service.BaseService;

@Service("menuWriteService")
public class MenuWriteServiceImpl extends BaseService implements MenuWriteService {
	@Autowired
	private MenuWriteManage menuWriteManage;
	
	@Autowired
	private MenuReadManage menuReadManage;
	
	@Autowired
	private RoleReadService roleReadService;
	
	@Autowired
	private RoleMenuWriteService roleMenuWriteService;
	
	@Override
	public String saveOrUpdateWithTx(MenuDTO dto,String userName) {
		String poId = null;
		MenuPO menuPO = null;
		MenuPO po = MenuConverter.toPO(dto);
		if(dto.getId() != null){
		    menuPO = menuReadManage.getMenuId(dto.getId());
		}
		
		if(menuPO != null){
			poId = menuWriteManage.Update(po);
		}else{
		    if(po.getPlatformId() == null){
		        po.setPlatformId(1L);
		    }
		    if(po.getParentId() == null){
                po.setParentId(1L);
            }
		    
		    //通过平台id和管理员名字来确定各个管理员id
			RoleDTO roleDTO = new RoleDTO();
			roleDTO.setName(PlatformKeyConstant.PLATFORMIDADMINUSER);
			roleDTO.setPlatformId(po.getPlatformId());
			//管理员角色肯定唯一
			List<RoleDTO> roleList = roleReadService.findAll(roleDTO);

			Long menuId = menuWriteManage.save(po);
			
			//保存菜单和管理员角色的关系
			RoleMenuDTO roleMenuDTO = new RoleMenuDTO();
			roleMenuDTO.setMenuId(menuId);
			roleMenuDTO.setRoleId(roleList.get(0).getId());
			roleMenuWriteService.saveWithTx(roleMenuDTO);
			
		}
		return poId;
	}

	@Override
	public void deleteWithTx(MenuDTO dto) {
		MenuPO po = MenuConverter.toPO(dto);
		menuWriteManage.deleteWithTx(po);
		
	}
}
	