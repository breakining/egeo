package com.egeo.back.user.facade;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.read.UserPlatformReadService;
import com.egeo.basics.user.api.write.UserPlatformWriteService;
import com.egeo.basics.user.model.dto.UserPlatformDTO;

@Component
public class UserPlatformFacade {

    @Reference
    private UserPlatformReadService userPlatformReadService;
    
    @Reference
    private UserPlatformWriteService userPlatformWriteService;

    public boolean userIsExitPlatform(UserPlatformDTO userPlatformDTO) {
        
        return userPlatformReadService.userIsExitPlatform(userPlatformDTO);
    }

    public String save(UserPlatformDTO dto) {
        
        return userPlatformWriteService.saveWithTx(dto);
    }

    public String update(UserPlatformDTO dto) {
        
        return userPlatformWriteService.updateWithTx(dto);
    }

    public String deleteByUserIdAndPid(UserPlatformDTO dto) {
        
        return userPlatformWriteService.deleteByUserIdAndPidWithTx(dto);
    }

    public String updateAll(UserPlatformDTO dto) {
        
        return userPlatformWriteService.updateAllWithTx(dto);
    }

}
