package com.egeo.basics.user.business.read;

import java.util.List;

import com.egeo.basics.user.po.UrlPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface UrlReadManage {

    List<String> findAll();

    List<UrlPO> getUrlByRoleId(Long roleId);

    PageResult<UrlPO> findPage(Pagination page, UrlPO po);
    
    List<UrlPO> findAll(UrlPO urlPO);

    UrlPO findByName(String name);

    UrlPO findById(Long id);

}
