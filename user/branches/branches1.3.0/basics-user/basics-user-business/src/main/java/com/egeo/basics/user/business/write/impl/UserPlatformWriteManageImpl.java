package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.UserPlatformWriteManage;
import com.egeo.basics.user.dao.write.UserPlatformWriteDAO;
import com.egeo.basics.user.po.UserPlatformPO;

@Service
public class UserPlatformWriteManageImpl implements UserPlatformWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserPlatformWriteDAO userPlatformWriteDAO;
    @Override
    public String save(UserPlatformPO po) {
        // TODO Auto-generated method stub
        return userPlatformWriteDAO.insert(po)+"";
    }
    @Override
    public String update(UserPlatformPO po) {
        // TODO Auto-generated method stub
        return userPlatformWriteDAO.update(po)+"";
    }
    @Override
    public String deleteByUserIdAndPid(UserPlatformPO po) {
        // TODO Auto-generated method stub
        return userPlatformWriteDAO.deleteByUserIdAndPid(po)+"";
    }
    @Override
    public int delUserPlatform(UserPlatformPO platformPO) {
        // TODO Auto-generated method stub
        return userPlatformWriteDAO.delUserPlatform(platformPO);
    }
}
	