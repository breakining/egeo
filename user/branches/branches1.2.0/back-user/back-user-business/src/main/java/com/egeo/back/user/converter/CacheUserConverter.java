package com.egeo.back.user.converter;

import com.egeo.back.user.model.vo.CacheUser;
import com.egeo.back.user.model.vo.UserVO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserExtendDTO;

/**
 * DTO和VO相互转换工具类
 * 
 * @author xiaping
 * @date 2017-05-08 17:38:48
 */
public class CacheUserConverter {
	



	public static void setCacheUserbyUser(CacheUser tar, UserVO src) {
		// TODO Auto-generated method stub
		
		tar.setId(src.getId());
		tar.setLoginName(src.getLoginName());
		tar.setName(src.getName());
		tar.setMobile(src.getMobile());
		tar.setMail(src.getMail());

		tar.setCompanyId(src.getCompanyId());
	
		
	}
	
	
	public static void setCacheUserbyUser(CacheUser tar, UserDTO src) {
		// TODO Auto-generated method stub
		
		tar.setId(src.getId());
		tar.setLoginName(src.getLoginName());
		tar.setMobile(src.getMobile());
		tar.setMail(src.getMail());
		tar.setCompanyId(src.getCompanyId());
	
		
	}





}
	