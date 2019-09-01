package com.egeo.basics.user.business.write.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.PlatformWriteManage;
import com.egeo.basics.user.dao.write.PlatformWriteDAO;
import com.egeo.basics.user.po.PlatformPO;

@Service
public class PlatformWriteManageImpl implements PlatformWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PlatformWriteDAO platformWriteDAO;
    @Override
    public int save(PlatformPO po) {
        return platformWriteDAO.insert(po);
    }
    @Override
    public int upDate(PlatformPO po) {
        // TODO Auto-generated method stub
        return platformWriteDAO.update(po);
    }
    @Override
    public Integer deleteById(PlatformPO po) {
        // TODO Auto-generated method stub
        return platformWriteDAO.delete(po);
    }
}
	