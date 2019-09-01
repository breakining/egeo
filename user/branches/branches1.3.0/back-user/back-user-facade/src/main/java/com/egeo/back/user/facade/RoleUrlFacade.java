package com.egeo.back.user.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.read.RoleUrlReadService;
import com.egeo.basics.user.api.write.RoleUrlWriteService;
import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.core.web.JsonResult;


@Component
public class RoleUrlFacade {
	
	@Reference
	private RoleUrlReadService roleUrlReadService;
	
	@Reference
        private RoleUrlWriteService roleUrlWriteService;
	

	public List<String> getUrlListByUserId(Long userId) {
		// TODO Auto-generated method stub
		return roleUrlReadService.getUrlListByUserId(userId);
	}

    public int upDate(String urls, Long roleId) {
        // TODO Auto-generated method stub
        return roleUrlWriteService.upDateWithTx(urls,roleId);
    }

    public JsonResult<List<UrlDTO>> showUrl(Long roleId,Long platformId) {
        // TODO Auto-generated method stub
        return roleUrlReadService.showUrl(roleId,platformId);
    }
	


}
	