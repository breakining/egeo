package com.egeo.back.user.business;

import com.egeo.back.user.model.vo.UserRoleVO;

public interface UserRoleManage {

    String save(UserRoleVO userRoleVO);

    String deleteWithTx(UserRoleVO userRoleVO);

}
