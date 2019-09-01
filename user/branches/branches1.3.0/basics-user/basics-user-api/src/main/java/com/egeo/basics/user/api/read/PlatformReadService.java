package com.egeo.basics.user.api.read;

import java.util.List;

import com.egeo.basics.user.model.dto.PlatformDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface PlatformReadService {

    PageResult<PlatformDTO> findAll(PlatformDTO dto,Pagination page);

    List<PlatformDTO> PlatformByUserId(Long useId);

    PlatformDTO find(Long long1);
    
    List<PlatformDTO> PlatformByUId(Long userId);

    List<PlatformDTO> PlatformByUid(Long userId);
}
	