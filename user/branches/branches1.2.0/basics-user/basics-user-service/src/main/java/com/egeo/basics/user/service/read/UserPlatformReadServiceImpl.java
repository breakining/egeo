package com.egeo.basics.user.service.read;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.UserPlatformReadService;
import com.egeo.basics.user.business.read.UserPlatformReadManage;
import com.egeo.basics.user.converter.UserPlatformConverter;
import com.egeo.basics.user.model.dto.UserPlatformDTO;
import com.egeo.core.basics.service.BaseService;

@Service("userPlatformReadService")
public class UserPlatformReadServiceImpl extends BaseService implements UserPlatformReadService {
    @Autowired
    private UserPlatformReadManage userPlatformReadManage;

    @Override
    public boolean userIsExitPlatform(UserPlatformDTO userPlatformDTO) {
        // TODO Auto-generated method stub
        return userPlatformReadManage.userIsExitPlatform(UserPlatformConverter.toPO(userPlatformDTO));
    }
}
