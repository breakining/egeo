package com.egeo.back.user.business.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.egeo.back.user.business.LoginManage;
import com.egeo.back.user.business.RoleMenuPlatformManage;
import com.egeo.back.user.business.RoleUrlManage;
import com.egeo.back.user.business.UserExtendManage;
import com.egeo.back.user.business.UserManage;
import com.egeo.back.user.business.UserPlatformManage;
import com.egeo.back.user.businiess.util.CalcEncryInfoUtils;
import com.egeo.back.user.converter.CacheUserConverter;
import com.egeo.back.user.converter.UserConverter;
import com.egeo.back.user.model.entity.EncryptEntity;
import com.egeo.back.user.model.vo.CacheUser;
import com.egeo.back.user.model.vo.UserVO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.basics.user.model.dto.UserPlatformDTO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.web.JsonResult;
import com.egeo.util.security.MD5Support;
import com.egeo.utils.str.StringUtils;

@Service("login")
public class LoginManageImpl implements LoginManage{
	
	public Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	@Resource(name="user")
	private UserManage userManage;
	
	@Resource(name="userExtend")
	private UserExtendManage userExtendManage;
	
	@Resource(name="userPlatform")
	private UserPlatformManage userPlatformManage;
	
	@Resource(name="roleUrl")
	private RoleUrlManage roleUrlManage;
	
	@Resource(name="roleMenuPlatform")
	private RoleMenuPlatformManage roleMenuPlatformManage;
	

	@Override
	public JsonResult<CacheUser> login(UserVO user) {//added by xiaping，这里暂时没有增加 前端加密的修改

		JsonResult<CacheUser> rt = new JsonResult<CacheUser>();
		UserVO userVo = null;
		String platformId = null;
		
		if(!StringUtils.isNotEmpty(user.getPassword())){
			rt.setCode(BusinessExceptionConstant.USER_LOGIN_NO_PASSWORD);
			rt.setError("用户登录密码为空");	
			return rt;
		}
		if(StringUtils.isNotEmpty(user.getCompanyId()) && StringUtils.isNotEmpty(user.getPlatformId())){
			userVo = userManage.findUniqueUser(user);
			UserPlatformDTO userPlatformDTO = new UserPlatformDTO();
			userPlatformDTO.setPlatformId(user.getPlatformId());
			userPlatformDTO.setUserId(userVo.getId());
			if(!userPlatformManage.userIsExitPlatform(userPlatformDTO)){
				rt.setCode(BusinessExceptionConstant.USER_NOT_EXIST_PLATFORM);
				rt.setError("该平台没有这个用户");	
				return rt;
			}
			platformId = user.getPlatformId();

		}else{
			rt.setCode(BusinessExceptionConstant.USER_LOGIN_NOCOMPANYID_OR_NOPLATFORMID);
			rt.setError("用户登录没有带company_id或者platform_id");	
			return rt;
		}
		if(userVo == null){
			rt.setCode(BusinessExceptionConstant.USER_NO_EXIST);
			rt.setError("用户不存在");	
			return rt;
		}
		
		boolean validateFlag=false;//user这边验证通过标志
	
		
    	EncryptEntity encryptEntity=new EncryptEntity();
    	encryptEntity=CalcEncryInfoUtils.calc(userVo);
		
    	//没有盐值,是修改之前的用户,原密码md5加密一次
        String passWordNullSalt= MD5Support.MD5(user.getPassword());
        //有old盐值,就用old盐值跟old算法加密
        String passWordWithSalt=MD5Support.MD5(user.getPassword(), (null==encryptEntity.getOldBSalt())?"":encryptEntity.getOldBSalt());
        
        if(StringUtils.isEmpty(encryptEntity.getOldBSalt())){//没有old盐值,是修改之前的用户,原密码md5加密一次
        	if(userVo.getPassword().equals(passWordNullSalt)){
        		validateFlag=true;
        	}
        }else{//有old盐值,就用old盐值跟old算法加密  
    		if(userVo.getPassword().equals(passWordWithSalt)){
    			validateFlag=true;
        	
        	}
        }		
		
 
            if(true==validateFlag){
            	try {
            		CacheUser cacheUser = this.setCacheUser(userVo,platformId);
            		
            		rt.setCode(0);
            		rt.setData(cacheUser);
            		rt.setSuccess( "登录成功！");
					
	            	try{//更新加密信息的操作不能影响正常的登录
	                	String userId=userVo.getId();
	                	
	                	if(StringUtils.isNotEmpty(encryptEntity.getNewBSalt())){
	                    	String salt=StringUtils.isEmpty(encryptEntity.getNewBSalt())?encryptEntity.getOldBSalt():encryptEntity.getNewBSalt();
	                    	
	                    	UserDTO updUser=UserConverter.toDTO(userVo);
	                    	                    	
	                        String password=MD5Support.MD5(user.getPassword(),salt);               
	                        Date now=new Date();                    
	                        if(StringUtils.isNotEmpty(encryptEntity.getNewBSalt())){
	                        	updUser.setSalt(encryptEntity.getNewBSalt());
	                        	updUser.setUpdateSalt(now);
	                        }

	                        updUser.setPassword(password);	
	                        
	                        int cnt=userManage.updateEncryptInfoByUserWithTx(updUser);
	                        
	                        if(0==cnt){
	                        	logger.error("更新用户加密密码失败");
	                        	rt.setError("更新用户加密密码失败");
	                        }
	                        
	                	}
	                }catch(Exception e1){
	                	logger.error("更新用户加密密码失败");
	                	rt.setError("更新用户加密密码失败");
	                	}	
	            	
	            	return rt;
	            	
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error(e.getMessage());
					rt.setError(e.getMessage());
		            return rt;
				}
            }else{
            	rt.setCode(BusinessExceptionConstant.USER_PASSWORD_OR_USERNAME_WRONG);
            	rt.setError("用户登录的账号或者密码错误");
                return rt;
            }
        }

		
		public CacheUser setCacheUser (UserVO user, String platformId){
			String userId = user.getId();
			UserExtendDTO userExtendDTO = userExtendManage.findById(userId);
			CacheUser cacheUser = new CacheUser();
			CacheUserConverter.setCacheUserbyUser(cacheUser,user);
			CacheUserConverter.setCacheUserbyUserExtend(cacheUser,userExtendDTO);	
			List<String> urlPath = roleUrlManage.getUrlListByUserId(userId);
			List<String> menulist = roleMenuPlatformManage.getMenuList(userId,platformId); 
			cacheUser.setUrlPath(urlPath);
			cacheUser.setMenuList(menulist);
			
			return cacheUser;
			
		}
		
		public CacheUser setCacheUser (String userId, String platformId){
			UserDTO userDto = userManage.findUserByID(userId);
			UserExtendDTO userExtendDTO = userExtendManage.findById(userId);
			CacheUser cacheUser = new CacheUser();
			CacheUserConverter.setCacheUserbyUser(cacheUser,userDto);
			CacheUserConverter.setCacheUserbyUserExtend(cacheUser,userExtendDTO);	
			List<String> urlPath = roleUrlManage.getUrlListByUserId(userId);
			List<String> menulist = roleMenuPlatformManage.getMenuList(userId,platformId); 
			cacheUser.setUrlPath(urlPath);
			cacheUser.setMenuList(menulist);
			
			return cacheUser;
			
		}

}
