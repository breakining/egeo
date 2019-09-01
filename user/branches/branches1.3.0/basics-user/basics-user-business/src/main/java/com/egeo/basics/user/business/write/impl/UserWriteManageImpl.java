package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.UserWriteManage;
import com.egeo.basics.user.dao.read.UserReadDAO;
import com.egeo.basics.user.dao.write.UserWriteDAO;
import com.egeo.basics.user.po.UserCookiePO;
import com.egeo.basics.user.po.UserExtendPO;
import com.egeo.basics.user.po.UserPO;
import com.egeo.core.exception.BusinessException;

@Service
public class UserWriteManageImpl implements UserWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserWriteDAO userWriteDAO;
	
	@Autowired
	private UserReadDAO userReadDAO;
	
	@Override
	public int updateEncryptInfoByUserWithTx(UserPO po) {
		// TODO Auto-generated method stub
		return userWriteDAO.update(po);
	}
	@Override
	public int updateUserInfo(UserPO po) {
		// TODO Auto-generated method stub
		return userWriteDAO.update(po);
	}
	
	@Override
	public Long save(UserPO po) {
	    userWriteDAO.insert(po);
	    return po.getId();
	}
	
	@Override
	public void delete(Long id) {
		UserPO po = new UserPO();
		po.setId(id);
		int i = userWriteDAO.delete(po);
		if (i == 0)
			throw new BusinessException("未能成功删除数据!");
	}
	
	public UserPO getIdUser(UserPO po){
		UserPO userPO = userReadDAO.findById(po);
		if(userPO != null){
			return userPO;
		}		
		return null;
		
		
	}
    @Override
    public String saveOrUpdateWithTx(UserPO po, UserExtendPO userExtendPO, UserCookiePO userCookiePO) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int update(UserPO tar) {
        // TODO Auto-generated method stub
        return userWriteDAO.update(tar);
    }
}
	