package com.egeo.back.user.business;

import java.util.List;

import com.egeo.basics.user.model.dto.PlatformDTO;

public interface PlatformManage {

    List<PlatformDTO> findAll(PlatformDTO dto);

    int upDate(PlatformDTO dto);

    List<PlatformDTO> PlatformByUserId(String useId);
	

}
	