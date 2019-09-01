package com.egeo.back.user.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.read.UrlReadService;
import com.egeo.basics.user.api.write.RoleUrlWriteService;
import com.egeo.basics.user.api.write.UrlWriteService;
import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Component
public class UrlFacade {
	
	@Reference
	private UrlReadService urlReadService;
	
	@Reference
	private UrlWriteService urlWriteService;
	
	@Reference
	private RoleUrlWriteService roleUrlWriteService;

	public List<String> findAll() {
		
		return urlReadService.findAll();
	}

	public int saveOrUpdate(UrlDTO dto) {
		return urlWriteService.saveOrUpdateWithTx(dto);
	}

	public void deleteWithTx(UrlDTO dto) {
		urlWriteService.deleteWithTx(dto);
	}

    public List<UrlDTO> getUrlByRoleId(Long roleId) {
        
        return urlReadService.getUrlByRoleId(roleId);
    }

    public PageResult<UrlDTO> findAll(Pagination page,UrlDTO urlDTO) {
        
        return urlReadService.findAll(page,urlDTO);
    }
    
    private String delRoleUrlByUrlId(Long urlId){
    	
		return roleUrlWriteService.delRoleUrlByUrlId(urlId);
    	
    }
	


}
	