package com.egeo.back.user.web.action;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.UserWelfareManage;
import com.egeo.back.user.converter.UserWelfareConverter;
import com.egeo.back.user.model.vo.UserWelfareVO;
import com.egeo.basics.user.model.dto.UserWelfareDTO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.common.PageResult;
import com.egeo.core.entity.CacheUser;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.utils.EmptyUtil;



@Controller
@RequestMapping("user/userWelfare")
public class UserWelfareAction extends BaseSpringController {
	
	@Resource(name="userWelfare")
	private UserWelfareManage userWelfareManage;


	// 业务方法：
	@RequestMapping(value = "/findUserWelfareById")
	@ResponseBody
	public JsonResult<UserWelfareVO> findUserWelfareById(Long id ) {
		
		UserWelfareDTO dto = new UserWelfareDTO();
		dto.setId(id);
		UserWelfareDTO rt = userWelfareManage.findUserWelfareById(dto);		
		return success(UserWelfareConverter.toVO(rt));
					 
	}



	// 业务方法：
	@RequestMapping(value = "/findUserWelfareAll")
	@ResponseBody
	public JsonResult<List<UserWelfareVO>> findUserWelfareAll(UserWelfareVO vo,HttpServletRequest req ) {
		UserWelfareDTO dto = UserWelfareConverter.toDTO(vo);
		List<UserWelfareDTO> rt = userWelfareManage.findUserWelfareAll(dto);	
		return success(UserWelfareConverter.toVO(rt));
					 
	}	

	// 业务方法：
	@RequestMapping(value = "/findUserWelfareOfPage")
	@ResponseBody
	public JsonResult<PageResult<UserWelfareVO>> findUserWelfareOfPage(UserWelfareVO vo,Pagination page,HttpServletRequest req ) {
		UserWelfareDTO dto = UserWelfareConverter.toDTO(vo);
		PageResult<UserWelfareDTO> rt = userWelfareManage.findUserWelfareOfPage(dto, page);
        List<UserWelfareVO> list = UserWelfareConverter.toVO(rt.getList());
        PageResult<UserWelfareVO> result = new PageResult<UserWelfareVO>();
        result.setList(list);
        result.setPageNo(rt.getPageNo());
        result.setPageSize(rt.getPageSize());
        result.setTotalSize(rt.getTotalSize());
		
		return success(result);
					 
	}


	// 业务方法：返回是插入行的id
	@RequestMapping(value = "/insertUserWelfareWithTx")
	@ResponseBody
	public JsonResult<Long> insertUserWelfareWithTx(UserWelfareVO vo,HttpServletRequest req ) {
		UserWelfareDTO dto = UserWelfareConverter.toDTO(vo);
		Long rt = userWelfareManage.insertUserWelfareWithTx(dto);	
		return success(rt);					 
	}
	
	// 业务方法：根据id更新数据
	@RequestMapping(value = "/updateUserWelfareByIdWithTx")
	@ResponseBody
	public JsonResult<Integer> updateUserWelfareByIdWithTx(UserWelfareVO vo,HttpServletRequest req ) {
		UserWelfareDTO dto = UserWelfareConverter.toDTO(vo);
		int rt = userWelfareManage.updateUserWelfareWithTx(dto);	
		return success(rt);					 
	}

	// 业务方法：
	@RequestMapping(value = "/deleteUserWelfareWithTx")
	@ResponseBody
	public JsonResult<Integer> deleteUserWelfareWithTx(UserWelfareVO vo,HttpServletRequest req ) {
		UserWelfareDTO dto = UserWelfareConverter.toDTO(vo);
		int rt = userWelfareManage.deleteUserWelfareWithTx(dto);	
		return success(rt);					 
	}
	
	/**
     * 福管+根据用户id修改用户扩展表信息(部门、入职时间)
     * @param dto
     * @return
     */
	@RequestMapping(value = "/updateUserWelfareByUserIdWithTx")
	@ResponseBody
	public JsonResult<String> updateUserWelfareByUserIdWithTx(Long departmentId,Long entryTime,HttpServletRequest req ) {
		logger.info("福管+根据用户id修改用户扩展表信息(部门、入职时间)");
		CacheUser userCache = (CacheUser) req.getAttribute("ut");
		if(EmptyUtil.isEmpty(userCache)){
			throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
		}
		if(EmptyUtil.isEmpty(userCache.getId())){
			throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
		}
		Long userId = userCache.getId();
		SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		UserWelfareDTO dto = new UserWelfareDTO();
		dto.setUserId(userId);
		dto.setDepartmentId(departmentId);
		if(EmptyUtil.isNotEmpty(entryTime)){
    		try {
    			dto.setEntryTime(format.parse(format.format(entryTime)));
    		} catch (ParseException e) {
    			throw new BusinessException("用户生日格式转换错误");
    		}
    	}
		
		int rt = userWelfareManage.updateUserWelfareByUserIdWithTx(dto);
		if(rt == 0){
			return success("修改用户信息失败");	
		}else{
			return success("修改用户信息成功");	
		}
						 
	}
}
	