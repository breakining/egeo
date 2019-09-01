package com.egeo.basics.user.service.write;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.UrlReadService;
import com.egeo.basics.user.api.write.RoleUrlWriteService;
import com.egeo.basics.user.business.write.RoleUrlWriteManage;
import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.core.basics.service.BaseService;

@Service("roleUrlWriteService")
public class RoleUrlWriteServiceImpl extends BaseService implements RoleUrlWriteService {
	@Autowired
	private RoleUrlWriteManage roleUrlWriteManage;
	
	@Autowired
        private UrlReadService urlReadService;
	
	@Override
	    public int upDateWithTx(String urls, Long roleId) {
	        int row = 0;
	        List<String> urlList = null;
	        StringBuffer delUrl = new StringBuffer();
	        //根据角色id查找url集合
                List<UrlDTO> list = urlReadService.getUrlByRoleId(roleId);
	        String substring = urls.substring(0);
	        if(substring.equals("")){
	            for (UrlDTO urlDTO : list) {
                         delUrl.append(urlDTO.getId()+",");
                    }
	        }else{
    	            //根据字符串截取list
    	            urlList = Arrays.asList(urls.split(",")); 
	                
	                //查找需要删除的url关系
	                for (UrlDTO urlDTO : list) {
	                    if(!urlList.contains(urlDTO.getId()+"")){
	                        delUrl.append(urlDTO.getId()+",");
	                    }
	                }
	        }
	        
	           //查找需要添加的trl关系
	           List<String> ids = new ArrayList<String>();
	           for (UrlDTO urlDTO : list) {
	               ids.add(urlDTO.getId()+"");
                   }
	           List<String> setUrl = new ArrayList<String>();
	           if(urlList != null){
	               for (String string : urlList) {
	                       if(!ids.contains(string)){
	                           setUrl.add(string);
	                       }
	                   }
	           }
	           if(delUrl.length() > 0){
	               delUrl.deleteCharAt(delUrl.length() - 1);
	           }
	           
	           if(delUrl.length() > 0){
	             //调用批量删除的方法
	               row = roleUrlWriteManage.delUrl(delUrl,roleId);
	           }
	           
	           if(setUrl.size() != 0){
	               //调用批量添加的方法
	               row =  roleUrlWriteManage.setUrl(setUrl,roleId);
	           }
	           
	        return row;
	    }
}
	