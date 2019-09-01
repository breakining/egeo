package com.egeo.basics.user.business.read.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.UserReadManage;
import com.egeo.basics.user.condition.UserCondition;
import com.egeo.basics.user.dao.read.UserExtendReadDAO;
import com.egeo.basics.user.dao.read.UserReadDAO;
import com.egeo.basics.user.po.UserCookiePO;
import com.egeo.basics.user.po.UserExtendPO;
import com.egeo.basics.user.po.UserPO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.common.PageResult;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;

@Service
public class UserReadManageImpl implements UserReadManage {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserReadDAO userReadDAO;
    @Autowired
    private UserExtendReadDAO uerDAO;

    @Override
    public UserPO findUniqueUser(UserPO po) {
        List<UserPO> rt = userReadDAO.findAll(po);
        if (rt.size() > 1) {
            throw new BusinessException(BusinessExceptionConstant.USER_NO_UNIQUE, "用户不唯一");
        } else if (rt.size() == 0) {
            throw new BusinessException(BusinessExceptionConstant.USER_NO_EXIST, "用户不存在");
        }
        return rt.get(0);
    }

    @Override
    public UserPO findUserByID(Long userId) {
        
        UserPO po = new UserPO();
        po.setId(userId);
        return userReadDAO.findById(po);
    }

    public PageResult<UserPO> findPage(Pagination page, UserPO po) {
        int cnt = userReadDAO.count(po);
        List<UserPO> list = new ArrayList<UserPO>();
        if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
            page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
            list = userReadDAO.page(po, page);
        }
        PageResult<UserPO> pageResult = new PageResult<UserPO>();
        pageResult.setList(list);
        pageResult.setTotalSize(cnt);
        pageResult.setPageNo(page.getPageNo());
        pageResult.setPageSize(page.getPageSize());
        return pageResult;

    }

    @Override
    public PageResult<UserCondition> findPageUser(Pagination page, UserPO po, UserExtendPO po2,
            UserCookiePO userCookiePO) {
        UserCondition userCondition = new UserCondition();
        userCondition.setId(po.getId());
        userCondition.setLoginName(po.getLoginName());
        userCondition.setPassword(po.getPassword());
        userCondition.setMobile(po.getMobile());
        userCondition.setMail(po.getMail());
        userCondition.setQrcode(po.getQrcode());
        userCondition.setSalt(po.getSalt());
        userCondition.setUpdateSalt(po.getUpdateSalt());
        userCondition.setCompanyId(po.getCompanyId());
        userCondition.setUxId(po2.getId());
        userCondition.setSex(po2.getSex());
        userCondition.setNickname(po2.getNickname());
        userCondition.setHeadPicUrl(po2.getHeadPicUrl());
        userCondition.setName(po2.getName());
        userCondition.setBeginTime(po.getBeginTime());
        userCondition.setFinishTime(po.getFinishTime());
        userCondition.setIsDeleted(po2.getIsDeleted());
        int cnt = userReadDAO.countOfPageUser(userCondition);
        List<UserCondition> list = new ArrayList<UserCondition>();
        if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
            page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
            list = userReadDAO.findOfPageUser(userCondition, page);
        }
        PageResult<UserCondition> pageResult = new PageResult<UserCondition>();
        pageResult.setList(list);
        pageResult.setTotalSize(cnt);
        pageResult.setPageNo(page.getPageNo());
        pageResult.setPageSize(page.getPageSize());
        return pageResult;
    }

    @Override
    public List<UserPO> userByloginName(UserPO po) {
        UserPO userPO = new UserPO();
        userPO.setLoginName(po.getLoginName());
        List<UserPO> list = userReadDAO.findAll(userPO);
        if(list.size() > 0){
            return list;
        }
        return null;
    }

    @Override
    public UserPO userById(UserPO po) {
        
        return userReadDAO.findById(po);
    }

	@Override
	public UserPO userByMail(String mail) {
		UserPO po = new UserPO();
        po.setMail(mail);
        List<UserPO> list = userReadDAO.findAll(po);
        if(list.size() > 0){
        	return list.get(0);
        }
        return null;
	}

	@Override
	public List<UserPO> userByManage(String mobile) {
		UserPO po = new UserPO();
        po.setMobile(mobile);
		return userReadDAO.findAll(po);
	}
	/**
	 * 通过用户id查询用户昵称和头像信息
	 * @return
	 */
	@Override
	public UserCondition userWelfareAppById(Long userId) {
		
		return userReadDAO.userWelfareAppById(userId);
	}

	@Override
	public PageResult<UserExtendPO> queryUserPageByCompanyId(Long companyId, Pagination page) {
		List<UserExtendPO> pos=uerDAO.queryUserPageByCompanyId(companyId,page);
		PageResult<UserExtendPO> result=new PageResult<>();
		result.setList(pos);
		result.setPageNo(page.getPageNo());
		result.setPageSize(page.getPageSize());
		Integer count=uerDAO.queryUserPageTotalCountByCompanyId(companyId);
		result.setTotalSize(count);
		return result; 
	}

	@Override
	public PageResult<UserExtendPO> queryUserPageByDepartmentId(Long departmentId, Pagination page) {
		List<UserExtendPO> pos=uerDAO.queryUserPageByDepartmentId(departmentId,page);
		PageResult<UserExtendPO> result=new PageResult<>();
		result.setList(pos);
		result.setPageNo(page.getPageNo());
		result.setPageSize(page.getPageSize());
		Integer count=uerDAO.queryUserPageTotalCountByDepartmentId(departmentId);
		result.setTotalSize(count);
		return result; 
	}

	@Override
	public List<UserPO> queryUserByIds(List<Long> userIdList) {
		return userReadDAO.queryUserByIds(userIdList);
	}

}
