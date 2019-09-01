package com.egeo.basics.user.business.write;

import com.egeo.basics.user.po.PlatformPO;

public interface PlatformWriteManage {

    int save(PlatformPO po);

    int upDate(PlatformPO po);

    Integer deleteById(PlatformPO po);
}
	