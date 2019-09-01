package com.egeo.back.user.web.action;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.LoginManage;
import com.egeo.back.user.business.UserCookieManage;
import com.egeo.back.user.business.UserLoginManage;
import com.egeo.back.user.business.UserManage;
import com.egeo.back.user.business.util.SsoClientUtil;
import com.egeo.back.user.model.vo.ProductUser;
import com.egeo.back.user.model.vo.UserCookieVO;
import com.egeo.back.user.model.vo.UserExtendVO;
import com.egeo.back.user.model.vo.UserVO;
import com.egeo.basics.user.model.dto.User;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.common.PageResult;
import com.egeo.core.entity.CacheUser;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.util.cache.JedisUtil;
import com.egeo.utils.EmptyUtil;
import com.egeo.utils.MailUtil;
import com.egeo.utils.str.StringUtils;

/**
 * 用户控制层
 * @author 闵浮龙
 *
 */
@Controller
@RequestMapping("user/user")
public class UserAction extends BaseSpringController {
    
	@Resource(name="user")
	private UserManage userManage;
	
	@Resource(name="userCache")
	private  JedisUtil cache;
	
	@Resource(name="login")
	private LoginManage loginManage;
	
	@Resource(name="userLogin")
	private UserLoginManage userLoginManage;
	
	@Resource(name="userCookie")
	private UserCookieManage userCookieManage;
	
	@Resource(name="ssoClientUtil")
	private  SsoClientUtil ssoClientUtil;
	
	
	/**
	 * 分页查看所有用户
	 * @param page
	 * @param userVO
	 * @param userExtendVO
	 * @param userCookieVO
	 * @return
	 */
	@RequestMapping(value = "userList")
	@ResponseBody
	public JsonResult<PageResult<UserDTO>> findPage(Pagination page,UserVO userVO,UserExtendVO userExtendVO,UserCookieVO userCookieVO) {
	    JsonResult<PageResult<UserDTO>> result = new JsonResult<PageResult<UserDTO>>();
	    try {
                PageResult<UserDTO> pageResult = userManage.findPage(page, userVO,userExtendVO,userCookieVO);
                result.setData(pageResult);
                return result;
            } catch (Exception e) {
                logger.error("查询所有用户异常！", e);
                result.setCode(1);
                result.setError("查询所有用户失败:" + e.getMessage());
                return result;
            }
	}
	
	/**
	 * 分页查看所有产品平台用户
	 * @param page
	 * @param userVO
	 * @param userExtendVO
	 * @param userCookieVO
	 * @return
	 */
	@RequestMapping(value = "findProductUser")
	@ResponseBody
	public JsonResult<PageResult<ProductUser>> findProductUser(Pagination page,UserVO userVO,UserExtendVO userExtendVO) {
	    JsonResult<PageResult<ProductUser>> result = new JsonResult<PageResult<ProductUser>>();
	    try {
	    		logger.info("开始分页查看所有产品平台用户！");
                PageResult<ProductUser> pageResult = userManage.findProductUser(page, userVO,userExtendVO);
                result.setData(pageResult);
                return result;
            } catch (Exception e) {
                logger.error("分页查看所有产品平台用户异常！", e);
                result.setCode(1);
                result.setError("分页查看所有产品平台用户失败:" + e.getMessage());
                return result;
            }
	}
	
	
	/**
	 * 更新用户
	 * @param vo
	 * @param userExtendVO
	 * @param userCookieVO
	 * @return
	 */
	@RequestMapping(value = "saveOrUpdate")
	@ResponseBody
	public JsonResult<String> saveOrUpdate(@Valid UserVO vo,UserExtendVO userExtendVO,UserCookieVO userCookieVO,BindingResult br,HttpServletRequest req) {
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			vo.setPlatformId(platformId);
		}
		JsonResult<String> result = new JsonResult<String>();
        if (logger.isInfoEnabled()) {
            logger.info("更新用户, UserDTO = {}", vo);
                }
        String id = userManage.saveOrUpdate(vo,userExtendVO,userCookieVO);
        if (logger.isInfoEnabled()) {
            logger.info("更新用户成功, UserDTOLoginName = {}", vo.getLoginName());
        }
        result.setData(id);
        return result;
    	}
	
	
	/**
	 * 根据id删除用户
	 * @param dto
	 * @return
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public JsonResult<String> delete(UserDTO dto) {
	    JsonResult<String> result = new JsonResult<String>(); 
		try {
            userManage.deleteWithTx(dto);
            result.setData("删除用户成功");
            return result;
        } catch (Exception e) {
            logger.error("删除用户异常！", e);
            result.setCode(1);
            result.setError("删除用户失败:" + e.getMessage());
            return result;
        }
	}
	
		/**
         * 根据id查询用户
         * @param dto
         * @return
         */
        @RequestMapping(value = "userById")
        @ResponseBody
        public JsonResult<UserDTO> userById(UserVO vo) {
                JsonResult<UserDTO> result = new JsonResult<UserDTO>();
                try {
                    UserDTO userDTO = userManage.userById(vo);
                    result.setData(userDTO);
                    return result;
                } catch (Exception e) {
                    logger.error("根据id查询用户异常！", e);
                    result.setCode(1);
                    result.setError("根据id查询用户失败:" + e.getMessage());
                    return result;
                }
        }
        
        /**
         * 根据id查询产品用户
         * @param dto
         * @return
         */
        @RequestMapping(value = "productUserById")
        @ResponseBody
        public JsonResult<ProductUser> productUserById(ProductUser vo) {
                JsonResult<ProductUser> result = new JsonResult<ProductUser>();
                try {
                	logger.info("根据id查询产品用户!");
                	ProductUser productUser = userManage.productUserById(vo);
                    result.setData(productUser);
                    return result;
                } catch (Exception e) {
                    logger.error("根据id查询产品用户异常！", e);
                    result.setCode(1);
                    result.setError("根据id查询产品用户失败:" + e.getMessage());
                    return result;
                }
        }
        
        /**
         * 获取验证码
         * @param dto
         * @return
         */
        @RequestMapping(value = "gainVerificationode")
        @ResponseBody
        public JsonResult<String> gainVerificationode(String mail) {
        	JsonResult<String> result = new JsonResult<String>();
        	if(EmptyUtil.isEmpty(mail)){
        		throw new BusinessException(BusinessExceptionConstant.EMAIL_EMPTY,"邮箱为空");
        	}
        	//判断是否为邮箱
            if(!mail.contains("@")){  
                throw new BusinessException("请输入正确的邮箱");
            } 
        	String redisVerificationCode = StringUtils.getRandom();
        	//以邮箱为key将验证码放入缓存、设置60秒过期
        	cache.set(mail, 120, redisVerificationCode);
        	new Thread(new MailUtil(mail, redisVerificationCode)).start();
        	result.setData("请登录邮箱查看激活码,60m后需重新发送");
			return result;
        }
        
        /**
         * 福管+用户注册
         * @param dto
         * @return
         */
        @RequestMapping(value = "userRegister")
        @ResponseBody
        public JsonResult<User> userRegister(String mail,String verificationCode, String password,String confirmPassword,HttpServletRequest req, HttpServletResponse resp) {
        	logger.info("福管+用户注册");
        	String str = req.getHeader("platformId");
        	Long platformId = null;
    		if(EmptyUtil.isNotEmpty(str)){
    			platformId = Long.valueOf(str);
    		}
        	if(EmptyUtil.isEmpty(mail)){
        		throw new BusinessException(BusinessExceptionConstant.EMAIL_EMPTY,"邮箱为空");
        	}
        	//判断是否为邮箱
            if(!mail.contains("@")){
                throw new BusinessException("请输入正确的邮箱");
            } 
            if(EmptyUtil.isEmpty(password)){
        		throw new BusinessException(BusinessExceptionConstant.USER_PASSWORD_EMPTY, "用户密码为空");
        	}
        	if(!password.equals(confirmPassword)){
        		throw new BusinessException(BusinessExceptionConstant.USER_NEW_PASSWORD_NO_MATCH,"两次输入的密码不一致，请重新输入");
        	}
        	if(6 > password.length() &&  password.length() > 16){
        		throw new BusinessException(BusinessExceptionConstant.GREATERSIX_LESSSIXTEEN,"密码必须为6-16位");
        	}
            // 字符串是否与正则表达式相匹配
			/*if (!StringUtils.isNotPasswordMay(password)) {
				throw new BusinessException(BusinessExceptionConstant.LETTER_FIGURE_SYMBOL,
						"密码必须包含大写字母、小写字母、数字和符号其中三项！");
			}*/
        	//根据邮箱获取放入缓存中的验证码
        	String redisVerificationCode = (String) cache.get(mail);
        	if(!redisVerificationCode.equals(verificationCode)){
        		throw new BusinessException(BusinessExceptionConstant.VERIFICATIONcODE_WRONG,"输入的验证码不对");
        	}
        	UserVO vo = new UserVO();
        	vo.setMail(mail);        
        	vo.setPassword(password);
        	vo.setPlatformId(platformId);
        	Long userId = userManage.userRegister(vo);
        	
        	//登陆
        	if(EmptyUtil.isNotEmpty(userId)){
        		UserVO user = new UserVO();
        		user.setName(mail);
        		user.setPassword(password);
        		user.setPlatformId(platformId);
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
            }else{
            	throw new BusinessException("用户注册失败");
            }
        	
        	
            
        }
        
        /**
         * 福管+用户找回密码
         * @param dto
         * @return
         */
        @RequestMapping(value = "findUserPassword")
        @ResponseBody
        public JsonResult<String> findUserPassword(String mail,String verificationCode, String password,String confirmPassword) {
        	logger.info("福管+用户找回密码");
        	JsonResult<String> result = new JsonResult<String>();
        	if(EmptyUtil.isEmpty(mail)){
        		throw new BusinessException(BusinessExceptionConstant.EMAIL_EMPTY,"邮箱为空");
        	}
        	//判断是否为邮箱
            if(StringUtils.isNotEmail(mail)){
                throw new BusinessException("请输入正确的邮箱");
            } 
            if(EmptyUtil.isEmpty(password)){
        		throw new BusinessException(BusinessExceptionConstant.USER_PASSWORD_EMPTY, "用户密码为空");
        	}
        	if(!password.equals(confirmPassword)){
        		throw new BusinessException(BusinessExceptionConstant.USER_NEW_PASSWORD_NO_MATCH,"两次输入的密码不一致，请重新输入");
        	}
        	if(6 > password.length() &&  password.length() > 16){
        		throw new BusinessException(BusinessExceptionConstant.GREATERSIX_LESSSIXTEEN,"密码必须为6-16位");
        	}
            // 字符串是否与正则表达式相匹配
			if (!StringUtils.isNotPasswordMay(password)) {
				throw new BusinessException(BusinessExceptionConstant.LETTER_FIGURE_SYMBOL,
						"密码必须包含大写字母、小写字母、数字和符号其中三项！");
			}
        	//根据邮箱查询用户
        	UserVO userVO = userManage.userByMail(mail);
        	if(EmptyUtil.isEmpty(userVO)){
        		throw new BusinessException(BusinessExceptionConstant.EMAIL_NO_EXIST,"该邮箱不存在请重新注册");
        	}
        	//根据邮箱获取放入缓存中的验证码
        	String redisVerificationCode = (String) cache.get(mail);
        	if(!redisVerificationCode.equals(verificationCode)){
        		throw new BusinessException(BusinessExceptionConstant.VERIFICATIONcODE_WRONG,"输入的验证码不对");
        	}
        	int rows = userManage.updateUserPassword(mail,password);
        	if(rows == 0){
        		result.setData("找回密码失败");
        	}else{
        		result.setData("找回密码成功");
        	}
			return result;
        }
	
	
	
        /**
         * 根据公司查询部门列表
         * @param companyId
         * @param req
         * @return
         */
        @RequestMapping(value = "companyDepartmentList")
    	@ResponseBody
        public JsonResult<Map<String,Object>> companyDepartmentList(Long companyId){
//        	CacheUser userCache = (CacheUser) req.getAttribute("ut");
//    		if(EmptyUtil.isEmpty(userCache)){
//    			throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
//    		}
//    		if(EmptyUtil.isEmpty(userCache.getId())){
//    			throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
//    		}
//    		Long userId=userCache.getId();//用户id
//    		
//    		String platformId_=req.getHeader("platformId");
//    		if(EmptyUtil.isEmpty(platformId_))
//    			return fail("platformId为空");
//    		Long platformId=Long.parseLong(platformId_);
    		
    		return userManage.companyDepartmentList(companyId);
        }
        
        /**
         * 查询部门员工列表
         * @param departmentId
         * @return
         */
        @RequestMapping(value = "departMentMemberList")
    	@ResponseBody
        public JsonResult<Map<String,Object>> departMentMemberList(Long departmentId,Integer pageNo,Integer pageSize,HttpServletRequest req){
        	CacheUser userCache = (CacheUser) req.getAttribute("ut");
    		if(EmptyUtil.isEmpty(userCache)){
    			throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
    		}
    		if(EmptyUtil.isEmpty(userCache.getId())){
    			throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
    		}
    		Long companyId=userCache.getCompanyId();
        	return userManage.departMentMemberList(departmentId,companyId,pageNo,pageSize);
        }
        
        /**
         * 发送验证码信息，绑定手机
         * @return
         */
        @RequestMapping(value = "sendIdentifyingCode")
    	@ResponseBody
        public JsonResult<Void> sendIdentifyingCode(String mobile,HttpServletRequest req){
        	JsonResult<Void> result = new JsonResult<Void>();
        	if(StringUtils.isEmpty(mobile)){
        		//如果手机号码为空
            	logger.error("手机号码为空！");
                result.setCode(1);
                result.setError("手机号码为空");
                return result;
        	}
        	
        	//发送到手机4位验证码
        	Long count=userManage.sendIdentifyingCode(mobile, 4);
        	if(count==1L){
        		return  result;
        	}
        	logger.error("发送短信失败！");
            result.setCode(1);
            result.setError("发送短信失败");
            return result;
        }
        
        @RequestMapping(value = "bindingMobile")
    	@ResponseBody
        public JsonResult<Void> bindingMobile(String mobile,String identityCode,HttpServletRequest req){
        	CacheUser userCache = (CacheUser) req.getAttribute("ut");
    		if(EmptyUtil.isEmpty(userCache)){
    			throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
    		}
    		if(EmptyUtil.isEmpty(userCache.getId())){
    			throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
    		}
    		Long userId=userCache.getId();//用户id
    		
//    		String platformId_=req.getHeader("platformId");
//    		if(EmptyUtil.isEmpty(platformId_))
//    			return fail("platformId为空");
//    		Long platformId=Long.parseLong(platformId_);
    		
    		JsonResult<Void> result = new JsonResult<Void>();
    		//判断手机号和验证码
    		if(StringUtils.isEmpty(mobile)||StringUtils.isEmpty(identityCode)){
    	    	logger.error("手机号或者验证码不能为空！");
                result.setCode(1);
                result.setError("手机号或者验证码不能为空");
                return result;
    		}
    		
    		Long info=userManage.bindingMobile(mobile,identityCode,userId);
			return null;
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
}
	