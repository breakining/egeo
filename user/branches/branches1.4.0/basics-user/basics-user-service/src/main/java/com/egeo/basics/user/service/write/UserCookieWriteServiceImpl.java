package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.write.UserCookieWriteService;
import com.egeo.basics.user.business.read.UserCookieReadManage;
import com.egeo.basics.user.business.write.UserCookieWriteManage;
import com.egeo.basics.user.converter.UserCookieConverter;
import com.egeo.basics.user.model.dto.UserCookieDTO;
import com.egeo.basics.user.po.UserCookiePO;
import com.egeo.core.basics.service.BaseService;

@Service("userCookieWriteService")
public class UserCookieWriteServiceImpl extends BaseService implements UserCookieWriteService {
	@Autowired
	private UserCookieWriteManage userCookieWriteManage;
	
	@Autowired
        private UserCookieReadManage userCookieReadManage;

	@Override
	public void saveUserCookieWithTx(UserCookieDTO userCookieDTO) {
		
		userCookieWriteManage.saveUserCookieWithTx(UserCookieConverter.toPO(userCookieDTO));
	}

    @Override
    public int updateWithTx(UserCookieDTO userCookieDTO) {
        UserCookiePO userCookiePO = UserCookieConverter.toPO(userCookieDTO);
        
        return userCookieWriteManage.update(userCookiePO);
    }

	@Override
	public void deleteCookieUserbyUserIdWithTx(Long userId) {
		userCookieWriteManage.deleteCookieUserbyUserIdWithTx(userId);
		
	}
}
	