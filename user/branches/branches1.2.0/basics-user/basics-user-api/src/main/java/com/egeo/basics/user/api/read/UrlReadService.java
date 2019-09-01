package com.egeo.basics.user.api.read;

import java.util.List;

import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface UrlReadService {

    List<String> findAll();

    List<UrlDTO> getUrlByRoleId(Long roleId);

    PageResult<UrlDTO> findAll(Pagination page,UrlDTO urlDTO);

}
	