package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.UserRolePO;

public interface UserRoleWriteManage {

    String saveWithTx(UserRolePO po);

    String deleteWithTx(UserRolePO po);

}
	