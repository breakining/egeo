package com.egeo.basics.user.business.read.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.RoleReadManage;
import com.egeo.basics.user.dao.read.RoleReadDAO;
import com.egeo.basics.user.po.RolePO;
import com.egeo.core.common.PageResult;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;

@Service
public class RoleReadManageImpl implements RoleReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RoleReadDAO roleReadDAO;
	@Override
	public List<RolePO> findRoleListByUserId(Long id) {
		
		RolePO po = new RolePO();
		po.setId(id);
		return roleReadDAO.findRoleListByUserId(po);
	}

	@Override
	public RolePO findRoleByRoleName(String name) {
		
		RolePO po = new RolePO();
		po.setName(name);
		List<RolePO> poList = roleReadDAO.findAll(po);
		if(poList.size() == 1){
			return poList.get(0);
		}else if(poList.size() > 1){
			throw new BusinessException("role的名字不唯一");
		}else{
			return null;
					
			}
		
	}

	@Override
	public List<RolePO> findAll(RolePO po) {
		
		return roleReadDAO.findAll(po);
	}

    @Override
    public List<RolePO> roleByPlatformId(Long platformId) {
        return roleReadDAO.roleByPlatformId(platformId);
    }

    @Override
    public List<RolePO> roleListByUserId(Long id) {
        
        return roleReadDAO.roleListByUserId(id);
    }

    @Override
    public PageResult<RolePO> findPageUser(Pagination page, RolePO po) {
        int cnt = roleReadDAO.countOfPage(po);
        List<RolePO> list = new ArrayList<RolePO>();
        if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
            page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
            list = roleReadDAO.findOfPage(po, page);
        }
        PageResult<RolePO> pageResult = new PageResult<RolePO>();
        pageResult.setList(list);
        pageResult.setTotalSize(cnt);
        pageResult.setPageNo(page.getPageNo());
        pageResult.setPageSize(page.getPageSize());
        return pageResult;
    }

    @Override
    public RolePO findById(RolePO po) {
        
        return roleReadDAO.findById(po);
    }
	
}
	