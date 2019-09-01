package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.UserExtendWriteManage;
import com.egeo.basics.user.dao.write.UserExtendWriteDAO;
import com.egeo.basics.user.po.UserExtendPO;

@Service
public class UserExtendWriteManageImpl implements UserExtendWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserExtendWriteDAO userExtendWriteDAO;
    @Override
    public int save(UserExtendPO userExtendPO) {
        return userExtendWriteDAO.insert(userExtendPO);
    }
    @Override
    public int update(UserExtendPO userExtendPO) {
        
        return userExtendWriteDAO.update(userExtendPO);
    }
	@Override
	public int deleteWithTx(UserExtendPO po) {
		
		return userExtendWriteDAO.delete(po);
	}
	/**
     * 福管+根据用户id修改用户扩展表信息(头像、真实姓名、性别、生日)
     * @param dto
     * @return
     */
	@Override
	public String updateUserExtendWithTx(UserExtendPO po) {
		int i = userExtendWriteDAO.update(po);
		if(i == 0){
			return "根据用户id修改用户信息失败";
		}
		return "根据用户id修改用户信息成功";
	}
}
	