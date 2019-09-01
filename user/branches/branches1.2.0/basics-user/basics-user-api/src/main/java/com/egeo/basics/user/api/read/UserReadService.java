package com.egeo.basics.user.api.read;

import com.egeo.basics.user.model.dto.UserCookieDTO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface UserReadService {
	
	UserDTO findUniqueUser(UserDTO dto);

	UserDTO findUserByID(Long userId);
	
	public PageResult<UserDTO> findPage(Pagination page,UserDTO dto,UserExtendDTO userExtendDTO,UserCookieDTO userCookieDTO);

	
}
	