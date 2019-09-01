package com.egeo.basics.user.business.read.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.PlatformReadManage;
import com.egeo.basics.user.dao.read.PlatformReadDAO;
import com.egeo.basics.user.po.PlatformPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;

@Service
public class PlatformReadManageImpl implements PlatformReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PlatformReadDAO platformReadDAO;
    @Override
    public List<PlatformPO> findAll(PlatformPO po) {
        List<PlatformPO> list = platformReadDAO.findAll(po);
        if(list.size() > 0){
            return list;
        }
        return null;
    }
    @Override
    public PlatformPO findRoleByRoleName(String name) {
        PlatformPO po = new PlatformPO();
        po.setName(name);
        List<PlatformPO> poList = platformReadDAO.findAll(po);
        if(poList.size() == 1){
                return poList.get(0);
        }else if(poList.size() > 1){
                throw new BusinessException("platform的名字不唯一");
        }else{
                return null;
                                
                }
    }
    @Override
    public List<PlatformPO> PlatformByUserId(Long useId) {
        
        return platformReadDAO.PlatformByUserId(useId);
    }
    @Override
    public PlatformPO find(Long pid) {
        return platformReadDAO.find(pid);
    }
    @Override
    public List<PlatformPO> PlatformByUid(Long userId) {
        
        return platformReadDAO.PlatformByUid(userId);
    }
    @Override
    public PlatformPO findById(PlatformPO po) {
        
        return platformReadDAO.findById(po);
    }
    @Override
    public PageResult<PlatformPO> findPage(Pagination page, PlatformPO po) {
        po.setIsAvailable(null);
        int cnt = platformReadDAO.countOfPage(po);
        List<PlatformPO> list = new ArrayList<PlatformPO>();
        if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
            page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
            list = platformReadDAO.findOfPage(po, page);
        }
        PageResult<PlatformPO> pageResult = new PageResult<PlatformPO>();
        pageResult.setList(list);
        pageResult.setTotalSize(cnt);
        pageResult.setPageNo(page.getPageNo());
        pageResult.setPageSize(page.getPageSize());
        return pageResult;
    }

	
}
	