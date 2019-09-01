package com.egeo.back.user.business.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.user.business.UserRoleManage;
import com.egeo.back.user.converter.UserRoleConverter;
import com.egeo.back.user.facade.UserRoleFacade;
import com.egeo.back.user.model.vo.UserRoleVO;
@Service("userRole")
public class UserRoleManageImpl implements UserRoleManage {
    
    @Resource(name="userRoleFacade")
    private UserRoleFacade userRoleFacade;

    @Override
    public String save(UserRoleVO userRoleVO) {
        return userRoleFacade.save(UserRoleConverter.toDTO(userRoleVO));
    }

    @Override
    public String deleteWithTx(UserRoleVO userRoleVO) {
        
        return userRoleFacade.deleteWithTx(UserRoleConverter.toDTO(userRoleVO));
    }
}
