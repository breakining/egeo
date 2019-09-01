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
		// TODO Auto-generated method stub
		userCookieWriteManage.saveUserCookieWithTx(UserCookieConverter.toPO(userCookieDTO));
	}

    @Override
    public int update(UserCookieDTO userCookieDTO) {
        UserCookiePO userCookiePO = UserCookieConverter.toPO(userCookieDTO);
        UserCookiePO po = userCookieReadManage.getbyUserId(userCookieDTO.getId());
        if(userCookiePO.getUserId() != null){
            po.setUserId(userCookiePO.getUserId());
        }
        if(userCookiePO.getCookieName() != null){
            po.setCookieName(userCookiePO.getCookieName());
        }
        if(userCookiePO.getCookieValue() != null){
            po.setCookieValue(userCookiePO.getCookieValue());
        }
        if(userCookiePO.getDomain() != null){
            po.setDomain(userCookiePO.getDomain());
        }
        if(userCookiePO.getPath() != null){
            po.setPath(userCookiePO.getPath());
        }
        if(userCookiePO.getExpirationTime() != null){
            po.setExpirationTime(userCookiePO.getExpirationTime());
        }
        if(userCookiePO.getIsAvailable() != null){
            po.setIsAvailable(userCookiePO.getIsAvailable());
        }
        if(userCookiePO.getIsDeleted() != null){
            po.setIsDeleted(userCookiePO.getIsDeleted());
        }
        if(userCookiePO.getVersionNo() != null){
            po.setVersionNo(userCookiePO.getVersionNo());
        }
        if(userCookiePO.getCreateUserid() != null){
            po.setCreateUserid(userCookiePO.getCreateUserid());
        }
        if(userCookiePO.getCreateUsername() != null){
            po.setCreateUsername(userCookiePO.getCreateUsername());
        }
        if(userCookiePO.getCreateUserip() != null){
            po.setCreateUserip(userCookiePO.getCreateUserip());
        }
        if(userCookiePO.getCreateUsermac() != null){
            po.setCreateUsermac(userCookiePO.getCreateUsermac());
        }
        if(userCookiePO.getCreateTime() != null){
            po.setCreateTime(userCookiePO.getCreateTime());
        }
        if(userCookiePO.getCreateTimeDb() != null){
            po.setCreateTimeDb(userCookiePO.getCreateTimeDb());
        }
        if(userCookiePO.getServerIp() != null){
            po.setServerIp(userCookiePO.getServerIp());
        }
        if(userCookiePO.getUpdateUserid() != null){
            po.setUpdateUserid(userCookiePO.getUpdateUserid());
        }
        if(userCookiePO.getUpdateUsername() != null){
            po.setUpdateUsername(userCookiePO.getUpdateUsername());
        }
        if(userCookiePO.getUpdateUserip() != null){
            po.setUpdateUserip(userCookiePO.getUpdateUserip());
        }
        if(userCookiePO.getUpdateUsermac() != null){
            po.setUpdateUsermac(userCookiePO.getUpdateUsermac());
        }
        if(userCookiePO.getUpdateTime() != null){
            po.setUpdateTime(userCookiePO.getUpdateTime());
        }
        if(userCookiePO.getUpdateTimeDb() != null){
            po.setUpdateTimeDb(userCookiePO.getUpdateTimeDb());
        }
        if(userCookiePO.getClientVersionno() != null){
            po.setClientVersionno(userCookiePO.getClientVersionno());
        }
        if(userCookiePO.getCompanyId() != null){
            po.setCompanyId(userCookiePO.getCompanyId());
        }
        if(userCookiePO.getPlatformId() != null){
            po.setPlatformId(userCookiePO.getPlatformId());
        }
        return userCookieWriteManage.update(po);
    }
}
	