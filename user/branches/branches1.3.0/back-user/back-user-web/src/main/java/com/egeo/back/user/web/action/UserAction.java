package com.egeo.back.user.web.action;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.UserManage;
import com.egeo.back.user.model.vo.ProductUser;
import com.egeo.back.user.model.vo.UserCookieVO;
import com.egeo.back.user.model.vo.UserExtendVO;
import com.egeo.back.user.model.vo.UserVO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.common.PageResult;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;

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
	public JsonResult<String> saveOrUpdate(@Valid UserVO vo,UserExtendVO userExtendVO,UserCookieVO userCookieVO,BindingResult br) {
		JsonResult<String> result = new JsonResult<String>();
        	try {
                    if (logger.isInfoEnabled()) {
                        logger.info("更新用户, UserDTO = {}", vo);
                            }
                    String id = userManage.saveOrUpdate(vo,userExtendVO,userCookieVO);
                    if (logger.isInfoEnabled()) {
                        logger.info("更新用户成功, UserDTOLoginName = {}", vo.getLoginName());
                    }
                    result.setData(id);
                    return result;
                } catch (Exception e) {
                    logger.error("更新用户异常！", e);
                    result.setCode(1);
                    result.setError("更新用户失败:" + e.getMessage());
                    return result;
                }
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
	
	
	
	/*
	
	@Resource(name="user")
	private UserManage userManage;
	
	
	@RequestMapping(value = "findUserId")
	@ResponseBody
	public JsonResult<String> findUserId(UserVO user) {
		
		JsonResult<String> result = new JsonResult<String>();
		String id = userManage.findUniqueUser(user).getId();
		result.setData(id);		
		return  result;
	}	
	
	*//**
	 *  更新用户密码
	 * @param user
	 * @return
	 *//*
	@RequestMapping(value = "updatePasswordById")
	@ResponseBody
	public JsonResult<Integer> updatePasswordById(PassWordVO  passWord,HttpServletRequest req) {
		
		JsonResult<Integer> result = new JsonResult<Integer>();
		if(StringUtils.isEmpty(passWord.getOldPassword()) || StringUtils.isEmpty(passWord.getNewPassword())){
			result.setCode(BusinessExceptionConstant.USER_PASSWORD_EMPTY);
			result.setError("密码不能为空");
			return result;
		}
		if(!passWord.getNewPassword().equals(passWord.getConfirmNewPassword())){			
			result.setCode(BusinessExceptionConstant.USER_NEW_PASSWORD_NO_MATCH);
			result.setError("两次输入的密码不一致，请重新输入");
			return result;
		}
		
		
		int id = userManage.updateEncryptByNewEncryptWithTx(passWord,req);
		result.setData(id);		
		return  result;
	}	
	
	*//**
	 * 根据用户Id
	 * @param user
	 * @return
	 *//*
	@RequestMapping(value = "findUserId")
	@ResponseBody
	public JsonResult<String> getUserId(String userId) {
		
		JsonResult<String> result = new JsonResult<String>();
		String id = userManage.findUserByID(userId).getId();
		result.setData(id);		
		return  result;
	}	
	
	*//**
	 *  更新用户信息
	 * @param user
	 * @return
	 *//*
	
	@RequestMapping(value = "updateUser")
	@ResponseBody
	public JsonResult<Integer> updateUser(UserDTO user) {
		
		JsonResult<Integer> result = new JsonResult<Integer>();
		int id = userManage.updateUserInfo(user);
		result.setData(id);	
		return  result;
	}	
	
	*//**
	 * 新增用户信息
	 * @param user
	 * @return
	 *//*
	
	@RequestMapping(value = "addUser")
	@ResponseBody
	public JsonResult<String> addUser(UserDTO  user) {
		
		JsonResult<String> result = new JsonResult<String>();
		String id =  userManage.saveUser(user);
		result.setData(id);		
		return  result;
	}	

	
	
	
	
	
	
	
*/}
	