package com.egeo.back.user.business.impl;
	

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.user.business.RoleManage;
import com.egeo.back.user.converter.RoleConverter;
import com.egeo.back.user.facade.RoleFacade;
import com.egeo.back.user.model.vo.RoleVO;
import com.egeo.basics.user.model.dto.PlatformRole;
import com.egeo.basics.user.model.dto.RoleDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Service("role")
public class RoleManageImpl implements RoleManage{

	
	@Resource(name="roleFacade")
	private RoleFacade roleFacade;


	@Override
	public List<RoleDTO> findRoleListByUserId(Long id) {
		
		return roleFacade.findRoleListByUserId(id);
	}

	@Override
	public Long saveRoleWithTx(RoleDTO role, String userName) {
		

       return roleFacade.saveRoleWithTx(role,userName);
	
	 
	}

	@Override
	public int removeRoleWithTx(String  name) {
		
		return roleFacade.removeRoleWithTx(name);
	}





	@Override
	public RoleDTO findRoleByRoleName(String name) {
		
		return roleFacade.findRoleByRoleName(name);
	}

	@Override
	public List<RoleDTO> findAll(RoleDTO dto) {
		
		return roleFacade.findAll(dto);
	}

    @Override
    public int upDateUserWithTx(RoleDTO roleDTO, String userName) {
        
        return roleFacade.upDateUserWithTx(roleDTO,userName);
    }

    @Override
    public List<PlatformRole> roleByPlatformId(String platformId,Long id) {
        
        return roleFacade.roleByPlatformId(platformId,id);
    }

    @Override
    public int upDateRoleWithTx(String menus, Long roleId) {
        return roleFacade.upDateRoleWithTx(menus, roleId);
    }

    @Override
    public PageResult<RoleDTO> roleListPage(Pagination page, RoleVO roleVO) {
        
        return roleFacade.roleListPage(page, RoleConverter.toDTO(roleVO));
    }

    @Override
    public RoleDTO findById(RoleDTO roleDTO) {
        
        return roleFacade.findById(roleDTO);
    }

    @Override
    public int deleteByIdWithTx(RoleDTO roleDto) {
        
        return roleFacade.deleteByIdWithTx(roleDto);
    }
	
	
}
	