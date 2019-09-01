package com.egeo.basics.user.api.read;

import java.util.List;

import com.egeo.basics.user.model.dto.PlatformRole;
import com.egeo.basics.user.model.dto.RoleDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


public interface RoleReadService {

    List<RoleDTO> findRoleListByUserId(Long id);

    RoleDTO findRoleByRoleName(String name);

    List<RoleDTO> findAll(RoleDTO dto);

    List<PlatformRole> roleByPlatformIdWithTx(String platformId,Long id);
    
    List<RoleDTO> roleListByUserId(Long id);

    PageResult<RoleDTO> roleListPage(Pagination page, RoleDTO dto);

    RoleDTO findById(RoleDTO roleDTO);

}
