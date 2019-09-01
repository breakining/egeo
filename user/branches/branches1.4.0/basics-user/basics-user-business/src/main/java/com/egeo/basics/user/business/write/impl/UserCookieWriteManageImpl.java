package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.UserCookieWriteManage;
import com.egeo.basics.user.dao.write.UserCookieWriteDAO;
import com.egeo.basics.user.po.UserCookiePO;

@Service
public class UserCookieWriteManageImpl implements UserCookieWriteManage {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserCookieWriteDAO userCookieWriteDAO;

    @Override
    public void saveUserCookieWithTx(UserCookiePO po) {
        
        userCookieWriteDAO.insert(po);
    }

    @Override
    public int update(UserCookiePO po) {
        
        return userCookieWriteDAO.update(po);
    }

	@Override
	public void deleteCookieUserbyUserIdWithTx(Long userId) {
		UserCookiePO po = new UserCookiePO();
		po.setUserId(userId);
		userCookieWriteDAO.deleteByPara(po);
		
	}


}
