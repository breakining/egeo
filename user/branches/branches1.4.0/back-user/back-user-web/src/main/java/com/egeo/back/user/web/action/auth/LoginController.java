package com.egeo.back.user.web.action.auth;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.LoginManage;
import com.egeo.back.user.business.UserCookieManage;
import com.egeo.back.user.business.UserLoginManage;
import com.egeo.back.user.business.util.SsoClientUtil;
import com.egeo.back.user.model.vo.UserCookieVO;
import com.egeo.back.user.model.vo.UserVO;
import com.egeo.basics.user.model.dto.User;
import com.egeo.core.entity.CacheUser;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.utils.GetToken;
import com.egeo.utils.str.StringUtils;
/**
 * 登陆用户控制器。
 *
 * @author xiaping
 *
 */

@Controller
@RequestMapping("auth/login")
public class LoginController extends BaseSpringController {

	

	
	@Resource(name="login")
	private LoginManage loginManage;
	
	@Resource(name="userLogin")
	private UserLoginManage userLoginManage;
	
	@Resource(name="userCookie")
	private UserCookieManage userCookieManage;
	
	@Resource(name="ssoClientUtil")
	private  SsoClientUtil ssoClientUtil;
	
	@RequestMapping(value = "login")
    @ResponseBody
	public JsonResult<User> login(UserVO user ,HttpServletRequest req, HttpServletResponse resp) {

            logger.info("登陆方法被调用,用户名称：" + user.getName());
            checkUserName(user);
            JsonResult<CacheUser> rt = loginManage.login(user);		
            int code = rt.getCode();// code 等于 0表示登陆成功
            
            if (code == 0) { // 登陆成功
            	UserCookieVO userCookie = null;
            	CacheUser cacheUser = (CacheUser) rt.getData();
            	
            	// 写缓存 cookie
            	 userCookie = ssoClientUtil.login(cacheUser, req, resp);
            	
            	// 写登陆日志
            	userLoginManage.insertLoginLogWithTx(rt, req);
            	
            	User userfz = new User();
            	userfz.setCookieValue(userCookie.getCookieValue());
            	userfz.setName(rt.getData().getName());
            	userfz.setId(rt.getData().getId());
            	
            	return success(userfz);
            }else{
            	userLoginManage.insertLoginExceptionLogWithTx(code,user, req);
            	return fail(code,rt.getError() );
            }
        }


	@RequestMapping(value = "mobileLogin")
    @ResponseBody
	public JsonResult<User> mobileLogin(UserVO user ,HttpServletRequest req, HttpServletResponse resp) {

            logger.info("登陆方法被调用,用户名称：" + user.getName());
            checkUserName(user);
            JsonResult<CacheUser> rt = loginManage.mobileLogin(user);		
            int code = rt.getCode();// code 等于 0表示登陆成功
            
            if (code == 0) { // 登陆成功
            	UserCookieVO userCookie = null;
            	CacheUser cacheUser = (CacheUser) rt.getData();           	
            	// 写缓存 cookie
            	 userCookie = ssoClientUtil.login(cacheUser, req, resp);
            	 
         		//对于会员，使ut和用户信息在cache中进行关联
         		loginManage.saveUttoCache(user,userCookie);
         		// 写登陆cookie表
         		userCookie.setUserId(cacheUser.getId());
         		userCookie.setCompanyId(cacheUser.getCompanyId());
         		userCookie.setPlatformId(cacheUser.getPlatformId());
         		userCookieManage.saveUserCookieWithTx(userCookie,req);

            	
            	// 写登陆日志
            	userLoginManage.insertLoginLogWithTx(rt, req);
            	
            	User userfz = new User();
            	userfz.setCookieValue(userCookie.getCookieValue());
            	userfz.setName(rt.getData().getName());
            	userfz.setId(rt.getData().getId());
            	
            	return success(userfz);
            }else{
            	userLoginManage.insertLoginExceptionLogWithTx(code,user, req);
            	return fail(code, rt.getError());
            }
        }
	private void checkUserName(UserVO user) {
		
		String name = user.getName();
		if(StringUtils.isEmpty(name)){
			throw new BusinessException("登录用户名不能为空");			
		}
		if (name.contains("@")) {// 邮箱登陆
			user.setMail(name);
			
		} else if (StringUtils.validMobile(name)) {// 手机号登陆
			user.setMobile(name);
		} else {// 用户名登陆
			user.setLoginName(name);
		}
		
	}
	
	@RequestMapping(value = "indexLogin")
        @ResponseBody
        public JsonResult<String> indexLogin(){
            return success("登录成功");
            
        }
	
	@RequestMapping(value = "signout")
        @ResponseBody
        public JsonResult<String> signout(HttpServletRequest req, HttpServletResponse res){
	    req.setAttribute("ut", null);
	    req.getSession().invalidate();
            return success("退出成功");
            
        }
	
	@RequestMapping(value = "getQiNiuToken")
        @ResponseBody
        public JsonResult<String> getQiNiuToken(){
	    JsonResult<String> result = new JsonResult<String>();
	    logger.error("获取七牛token！");
	    try {
            String string = GetToken.getToken();
            result.setData(string);
                return result;
            } catch (Exception e) {
                logger.error("获取七牛token异常！", e);
                result.setCode(1);
                result.setError("获取七牛token失败:" + e.getMessage());
                return result;
            }
	}
}
