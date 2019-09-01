package com.egeo.back.user.facade;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.write.UserRoleWriteService;
import com.egeo.basics.user.model.dto.UserRoleDTO;

@Component
public class UserRoleFacade {

    @Reference
    private UserRoleWriteService userRoleWriteService;
    
    public String save(UserRoleDTO userRoleDTO) {
        // TODO Auto-generated method stub
        return userRoleWriteService.saveWithTx(userRoleDTO);
    }

    public String deleteWithTx(UserRoleDTO userRoleDTO) {
        // TODO Auto-generated method stub
        return userRoleWriteService.deleteWithTx(userRoleDTO);
    }

}
