package com.egeo.basics.user.api.read;
import java.util.List;

import com.egeo.basics.user.model.dto.RoleMenuDTO;

public interface RoleMenuReadService {

	public List<RoleMenuDTO> findAll(RoleMenuDTO roleMenuDTO); 
	
}
	