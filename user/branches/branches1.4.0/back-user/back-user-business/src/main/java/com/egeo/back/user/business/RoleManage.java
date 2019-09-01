package com.egeo.back.user.business;

import java.util.List;

import com.egeo.back.user.model.vo.RoleVO;
import com.egeo.basics.user.model.dto.PlatformRole;
import com.egeo.basics.user.model.dto.RoleDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface RoleManage {

    List<RoleDTO> findRoleListByUserId(Long id);

    /**
     * 新增角色
     * 
     * @param role
     * @return
     */

    Long saveRoleWithTx(RoleDTO role, String UserName);

    /**
     * 删除角色
     * 
     * @param id
     * @return
     */
    int removeRoleWithTx(String name);

    /**
     * 根据Id查
     * 
     * @param id
     * @return
     */

    RoleDTO findRoleByRoleName(String name);

    List<RoleDTO> findAll(RoleDTO dto);

    int upDateUserWithTx(RoleDTO roleDTO,String userName);

    List<PlatformRole> roleByPlatformId(String platformId,Long id);

    int upDateRoleWithTx(String menus, Long roleId);

    PageResult<RoleDTO> roleListPage(Pagination page, RoleVO roleVO);

    RoleDTO findById(RoleDTO roleDTO);

    int deleteByIdWithTx(RoleDTO roleDto);

}
