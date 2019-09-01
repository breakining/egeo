package com.egeo.back.user.business.impl;
	

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.egeo.back.user.business.UserLoginManage;
import com.egeo.back.user.business.util.CalcEncryInfoUtils;
import com.egeo.back.user.business.util.CommonUtils;
import com.egeo.back.user.facade.UserLoginFacade;
import com.egeo.back.user.model.entity.EncryptEntity;
import com.egeo.back.user.model.vo.CacheUser;
import com.egeo.back.user.model.vo.UserVO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserLoginDTO;
import com.egeo.core.web.JsonResult;
import com.egeo.util.security.MD5Support;
import com.egeo.utils.str.StringUtils;

@Service("userLogin")
public class UserLoginManageImpl implements UserLoginManage{

	
	private static final UserVO UserLoginDTO = null;
	@Resource(name="userLoginFacade")
	private UserLoginFacade userLoginFacade;

	@Override
	public void insertLoginLogWithTx(JsonResult<CacheUser> rt, HttpServletRequest req) {
		// TODO Auto-generated method stub
		UserLoginDTO userLogin = new UserLoginDTO();
        int code = rt.getCode();//code 等于 0表示登陆成功
        CacheUser cacheUser = rt.getData();
        userLogin.setCompanyId(cacheUser.getCompanyId());
        userLogin.setPlatformId(cacheUser.getPlatformId());
        userLogin.setLoginResult(code);
        userLogin.setUsername(cacheUser.getName());
        userLogin.setUserId(cacheUser.getId());
        userLogin.setIp(CommonUtils.getUserIp(req));
        userLogin.setBrowser(req.getHeader("User-Agent"));
        userLoginFacade.insertLoginLogWithTx(userLogin);
		
	}

	@Override
	public void insertLoginExceptionLogWithTx(int code, UserVO user, HttpServletRequest req) {
		// TODO Auto-generated method stub
		UserLoginDTO userLogin = new UserLoginDTO();
        userLogin.setLoginResult(code);
        userLogin.setUsername(user.getName());
        userLogin.setCompanyId(user.getCompanyId());
        userLogin.setPlatformId(user.getPlatformId());
        userLogin.setIp(CommonUtils.getUserIp(req));
        userLogin.setBrowser(req.getHeader("User-Agent"));
        userLoginFacade.insertLoginLogWithTx(userLogin);
		
	}

	

	


}
	