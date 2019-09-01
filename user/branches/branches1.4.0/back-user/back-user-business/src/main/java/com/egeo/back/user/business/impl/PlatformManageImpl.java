package com.egeo.back.user.business.impl;
	

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.egeo.back.user.business.PlatformManage;
import com.egeo.back.user.converter.PlatformConverter;
import com.egeo.back.user.facade.PlatformFacade;
import com.egeo.back.user.model.vo.PlatformVO;
import com.egeo.basics.user.model.dto.PlatformDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("platform")
public class PlatformManageImpl implements PlatformManage{

	
	@Resource(name="platformFacade")
	private PlatformFacade platformFacade;

    @Override
    public PageResult<PlatformDTO> findAll(PlatformDTO dto,Pagination page) {
        
        return platformFacade.findAll(dto,page);
    }

    @Override
    public int upDate(PlatformDTO dto) {
        
        return platformFacade.upDate(dto);
    }

    @Override
    public List<PlatformDTO> PlatformByUserId(Long userId) {
        
        return platformFacade.PlatformByUserId(userId);
    }

    @Override
    public List<PlatformDTO> PlatformByUId(Long userId) {
        
        return platformFacade.PlatformByUId(userId);
    }

    @Override
    public Integer deleteById(PlatformVO platformVO) {
        return platformFacade.deleteById(PlatformConverter.toDTO(platformVO));
    }

    @Override
    public String save(PlatformDTO dto) {
        
        return platformFacade.save(dto);
    }
	


}
	