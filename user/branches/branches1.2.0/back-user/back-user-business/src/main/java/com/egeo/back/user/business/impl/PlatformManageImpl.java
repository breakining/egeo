package com.egeo.back.user.business.impl;
	

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.egeo.back.user.business.PlatformManage;
import com.egeo.back.user.facade.PlatformFacade;
import com.egeo.basics.user.model.dto.PlatformDTO;

@Service("platform")
public class PlatformManageImpl implements PlatformManage{

	
	@Resource(name="platformFacade")
	private PlatformFacade platformFacade;

    @Override
    public List<PlatformDTO> findAll(PlatformDTO dto) {
        // TODO Auto-generated method stub
        return platformFacade.findAll(dto);
    }

    @Override
    public int upDate(PlatformDTO dto) {
        // TODO Auto-generated method stub
        return platformFacade.upDate(dto);
    }

    @Override
    public List<PlatformDTO> PlatformByUserId(String useId) {
        // TODO Auto-generated method stub
        return platformFacade.PlatformByUserId(useId);
    }
	


}
	