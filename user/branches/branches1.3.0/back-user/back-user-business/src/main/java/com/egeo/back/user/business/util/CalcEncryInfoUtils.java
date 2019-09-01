package com.egeo.back.user.business.util;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import com.egeo.back.user.model.entity.EncryptEntity;
import com.egeo.back.user.model.vo.UserVO;
import com.egeo.util.security.SaltUtils;


public class CalcEncryInfoUtils{

//	计算用户的加密算法版本跟盐值的信息
	public static EncryptEntity  calc(UserVO user){
		EncryptEntity encryptEntity=new EncryptEntity();
		if(user!=null){
				
//判断现在用户是否有盐，没有盐加盐，有盐大于7天，更新盐
	       	 if(StringUtils.isEmpty(user.getSalt())){
	       		 encryptEntity.setNewBSalt(SaltUtils.getRandomSalt(16));
	       	 }else{
	       		 if(null==user.getUpdateSalt()){
	       			 encryptEntity.setNewBSalt(SaltUtils.getRandomSalt(16));
	       			 encryptEntity.setOldBSalt(user.getSalt());
	
	       		 }else{
	       			 Date date=user.getUpdateSalt();
	       			 if((((new Date()).getTime()-date.getTime())/86400000)>=7){//这里默认7天
	           			 encryptEntity.setOldBSalt(user.getSalt());
	           			 encryptEntity.setNewBSalt(SaltUtils.getRandomSalt(16));
	
	       			 }else{
	           			 encryptEntity.setOldBSalt(user.getSalt());
	       			 }
	       		 }
	       	 }
	       	 	       	      	 
	       	 //返回user的id
	       	 encryptEntity.setUserId(user.getId());

		}
		return encryptEntity;
	}
}
