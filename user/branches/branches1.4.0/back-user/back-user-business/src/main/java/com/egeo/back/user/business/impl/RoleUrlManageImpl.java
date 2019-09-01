package com.egeo.back.user.business.impl;
	

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.user.business.RoleUrlManage;
import com.egeo.back.user.facade.RoleUrlFacade;
import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.core.web.JsonResult;

@Service("roleUrl")
public class RoleUrlManageImpl implements RoleUrlManage{

	
	@Resource(name="roleUrlFacade")
	private RoleUrlFacade roleUrlFacade;

	@Override
	public List<String> getUrlListByUserId(Long userId) {
		
		return roleUrlFacade.getUrlListByUserId(userId);
	}

    @Override
    public int upDate(String urls, Long roleId) {
        
        return roleUrlFacade.upDate(urls,roleId);
    }

    @Override
    public JsonResult<List<UrlDTO>> showUrl(Long roleId,Long platformId) {
        return roleUrlFacade.showUrl(roleId,platformId);
    }
	


}
	