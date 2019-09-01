package com.egeo.back.user.business.impl;
	

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.user.business.UserPlatformManage;
import com.egeo.back.user.converter.UserPlatformConverter;
import com.egeo.back.user.facade.UserPlatformFacade;
import com.egeo.back.user.model.vo.UserPlatformVO;
import com.egeo.basics.user.model.dto.UserPlatformDTO;

@Service("userPlatform")
public class UserPlatformManageImpl implements UserPlatformManage{

	
	@Resource(name="userPlatformFacade")
	private UserPlatformFacade userPlatformFacade;

	@Override
	public boolean userIsExitPlatform(UserPlatformDTO userPlatformDTO) {
		
		return userPlatformFacade.userIsExitPlatform(userPlatformDTO);
	}

    @Override
    public String save(UserPlatformVO userPlatformVO) {
        
        
        return userPlatformFacade.save(UserPlatformConverter.toDTO(userPlatformVO));
    }

    @Override
    public String update(UserPlatformVO platformVO) {
        
        return userPlatformFacade.update(UserPlatformConverter.toDTO(platformVO));
    }

    @Override
    public String deleteByUserIdAndPid(UserPlatformVO platformVO) {
        return userPlatformFacade.deleteByUserIdAndPid(UserPlatformConverter.toDTO(platformVO));
    }

    @Override
    public String updateAll(UserPlatformVO platformVO) {
        
        return userPlatformFacade.updateAll(UserPlatformConverter.toDTO(platformVO));
    }
}
	