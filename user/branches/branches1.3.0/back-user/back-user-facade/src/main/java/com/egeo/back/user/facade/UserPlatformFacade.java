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
        // TODO Auto-generated method stub
        return userPlatformReadService.userIsExitPlatform(userPlatformDTO);
    }

    public String save(UserPlatformDTO dto) {
        // TODO Auto-generated method stub
        return userPlatformWriteService.saveWithTx(dto);
    }

    public String update(UserPlatformDTO dto) {
        // TODO Auto-generated method stub
        return userPlatformWriteService.updateWithTx(dto);
    }

    public String deleteByUserIdAndPid(UserPlatformDTO dto) {
        // TODO Auto-generated method stub
        return userPlatformWriteService.deleteByUserIdAndPidWithTx(dto);
    }

    public String updateAll(UserPlatformDTO dto) {
        // TODO Auto-generated method stub
        return userPlatformWriteService.updateAllWithTx(dto);
    }

}
