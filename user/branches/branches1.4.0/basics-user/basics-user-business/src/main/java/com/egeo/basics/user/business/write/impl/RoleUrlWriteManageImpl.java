package com.egeo.basics.user.business.write.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.business.write.RoleUrlWriteManage;
import com.egeo.basics.user.dao.write.RoleUrlWriteDAO;
import com.egeo.basics.user.po.RoleUrl;
import com.egeo.basics.user.po.RoleUrlPO;
import com.egeo.core.exception.BusinessException;

@Service
public class RoleUrlWriteManageImpl implements RoleUrlWriteManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RoleUrlWriteDAO roleUrlWriteDAO;
    @Override
    public int delUrl(StringBuffer delUrl, Long roleId) {
        String urls = delUrl.toString();
        RoleUrl roleUrl = new RoleUrl();
        roleUrl.setRoleId(roleId);
        roleUrl.setUrls(urls);
        int url = roleUrlWriteDAO.delUrl(roleUrl);
        return url;
    }
    @Override
    public int setUrl(List<String> setUrl, Long roleId) {
        
        int row = 0;
        for (String string : setUrl) {
            RoleUrlPO po = new RoleUrlPO();
            po.setRoleId(roleId);
            //long result = Long.parseLong(s); 返回long基本数据类型
            Long result = Long.valueOf(string);//返回Long包装类型
            po.setUrlId(result);
            row += roleUrlWriteDAO.insert(po);
        }
        return row;
    }
	@Override
	public String delRoleUrlByUrlId(Long urlId) {
		RoleUrlPO po = new RoleUrlPO();
		po.setUrlId(urlId);
		int i = roleUrlWriteDAO.deleteByPara(po);
		if(i != 0){
			return "根据urlId删除角色url关系成功";
		}else{
			throw new BusinessException("根据urlId删除角色url关系失败");
		}
	}
}
	