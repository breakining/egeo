package com.egeo.basics.user.api.read;

import java.util.List;

import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.core.web.JsonResult;

public interface RoleUrlReadService {

	List<String> getUrlListByUserId(Long userId);

    JsonResult<List<UrlDTO>> showUrl(Long roleId,Long platformId);

}
	