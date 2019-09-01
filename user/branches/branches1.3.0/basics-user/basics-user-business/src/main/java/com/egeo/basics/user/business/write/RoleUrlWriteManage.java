package com.egeo.basics.user.business.write;

import java.util.List;

public interface RoleUrlWriteManage {

    int delUrl(StringBuffer delUrl, Long roleId);

    int setUrl(List<String> delUrl, Long roleId);
}
	