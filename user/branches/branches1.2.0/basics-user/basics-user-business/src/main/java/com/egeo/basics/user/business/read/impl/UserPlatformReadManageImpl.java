package com.egeo.basics.user.business.read.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.UserPlatformReadManage;
import com.egeo.basics.user.dao.read.UserPlatformReadDAO;
import com.egeo.basics.user.po.UserPlatformPO;
import com.egeo.utils.EmptyUtil;

@Service
public class UserPlatformReadManageImpl implements UserPlatformReadManage {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserPlatformReadDAO userPlatformReadDAO;

    @Override
    public boolean userIsExitPlatform(UserPlatformPO po) {
        // TODO Auto-generated method stub
        return EmptyUtil.isNotEmpty(userPlatformReadDAO.userIsExitPlatform(po));
    }

}
