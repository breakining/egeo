package com.egeo.basics.user.business.read.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.read.UrlReadManage;
import com.egeo.basics.user.dao.read.UrlReadDAO;
import com.egeo.basics.user.po.UrlPO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.common.PageResult;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;

@Service
public class UrlReadManageImpl implements UrlReadManage {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UrlReadDAO urlReadDAO;

    @Override
    public List<String> findAll() {
        // TODO Auto-generated method stub
        List<UrlPO> poList = urlReadDAO.findAll(new UrlPO());
        List<String> ls = new ArrayList<String>();
        for (UrlPO po : poList) {
            ls.add(po.getUrl());
        }
        return ls;
    }

    @Override
    public List<UrlPO> getUrlByRoleId(Long roleId) {
        // TODO Auto-generated method stub
        return urlReadDAO.getUrlByRoleId(roleId);
    }

    @Override
    public PageResult<UrlPO> findPage(Pagination page, UrlPO po) {
        int cnt = urlReadDAO.countOfPage(po);
        List<UrlPO> list = new ArrayList<UrlPO>();
        if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
            page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
            list = urlReadDAO.findOfPage(po, page);
        }
        PageResult<UrlPO> pageResult = new PageResult<UrlPO>();
        pageResult.setList(list);
        pageResult.setTotalSize(cnt);
        pageResult.setPageNo(page.getPageNo());
        pageResult.setPageSize(page.getPageSize());
        return pageResult;
    }

    @Override
    public List<UrlPO> findAll(UrlPO urlPO) {

        return urlReadDAO.findAll(urlPO);
    }

    @Override
    public UrlPO findByName(String name) {
        UrlPO po = new UrlPO();
        po.setName(name);
        List<UrlPO> list = urlReadDAO.findAll(po);
        if (list.size() > 1) {
            throw new BusinessException(BusinessExceptionConstant.URL_NO_UNIQUE, "URL不唯一");
        }
        if(list.size() == 1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public UrlPO findById(Long id) {
        UrlPO po = new UrlPO();
        po.setId(id);
        return urlReadDAO.findById(po);
    }

}
