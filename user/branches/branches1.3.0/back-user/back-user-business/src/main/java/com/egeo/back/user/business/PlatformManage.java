package com.egeo.back.user.business;

import java.util.List;

import com.egeo.back.user.model.vo.PlatformVO;
import com.egeo.basics.user.model.dto.PlatformDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface PlatformManage {

    PageResult<PlatformDTO> findAll(PlatformDTO dto,Pagination page);

    int upDate(PlatformDTO dto);

    List<PlatformDTO> PlatformByUserId(Long useId);

    List<PlatformDTO> PlatformByUId(Long userId);

    Integer deleteById(PlatformVO platformVO);

    String save(PlatformDTO dto);
	

}
	