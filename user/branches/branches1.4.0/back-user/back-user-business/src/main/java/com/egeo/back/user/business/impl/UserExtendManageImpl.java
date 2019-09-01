package com.egeo.back.user.business.impl;
	

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.user.business.UserExtendManage;
import com.egeo.back.user.converter.UserExtendConverter;
import com.egeo.back.user.facade.UserExtendFacade;
import com.egeo.back.user.facade.UserFacade;
import com.egeo.back.user.facade.UserWelfareFacade;
import com.egeo.back.user.model.vo.UserExtendVO;
import com.egeo.back.user.model.vo.UserWelfare;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.basics.user.model.dto.UserWelfareDTO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.common.PageResult;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;
import com.egeo.utils.EmptyUtil;
import com.egeo.utils.str.StringUtils;

@Service("userExtend")
public class UserExtendManageImpl implements UserExtendManage{

	
	@Resource(name="userExtendFacade")
	private UserExtendFacade userExtendFacade;
	
	@Resource(name="userFacade")
	private UserFacade userFacade;
	
	@Resource(name="userWelfareFacade")
	private UserWelfareFacade userWelfareFacade;

	@Override
	public UserExtendDTO findById(Long id) {
		
		return userExtendFacade.findById(id);
	}
	/**
     * 福管+完善用户扩展表信息
     * @param dto
     * @return
     */
	@Override
	public int saveUserExtend(UserExtendVO userExtendVO) {
		
		return userExtendFacade.saveUserExtendWithTx(UserExtendConverter.toDTO(userExtendVO));
	}
	@Override
	public String ImproveUserInformation(Long userId, String headPicUrl, String name, Long departmentId, Integer sex,
			Long birthday, Long entryTime) {
		SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
    	
    	UserExtendVO userExtendVO = new UserExtendVO();
    	userExtendVO.setId(userId);
    	userExtendVO.setHeadPicUrl(headPicUrl);
    	userExtendVO.setName(name);
    	userExtendVO.setSex(sex);
    	try {
			userExtendVO.setBirthday(format.parse(format.format(birthday)));
		} catch (ParseException e) {
			throw new BusinessException("用户生日格式转换错误");
		}
    	//添加扩展表信息
    	int rows = this.saveUserExtend(userExtendVO);
    	//添加福管+扩展表信息
    	Long saveUserWelfareWithTx = this.saveUserWelfareWithTx(userId, departmentId, entryTime);
    	if(rows != 0 && EmptyUtil.isNotEmpty(saveUserWelfareWithTx)){
    		return "完善用户信息成功";
    	}else{
    		return "完善用户信息失败";
    	}
		
	}
	
	/**
	 * 添加福管+扩展表信息
	 */
	@Override
	public Long saveUserWelfareWithTx(Long userId, Long departmentId, Long entryTime) {
		SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		UserWelfareDTO userWelfareDTO = new UserWelfareDTO();
		userWelfareDTO.setUserId(userId);
		try {
			userWelfareDTO.setEntryTime(format.parse(format.format(entryTime)));
		} catch (ParseException e) {
			throw new BusinessException("用户入职时间格式转换错误");
		}
		userWelfareDTO.setDepartmentId(departmentId);
		return userExtendFacade.saveUserWelfareWithTx(userWelfareDTO);
	}
	/**
     * 福管+根据用户id修改用户扩展表信息(头像、真实姓名、性别、生日)
     * @param dto
     * @return
     */
	@Override
	public String updateUserExtend(Long userId, String headPicUrl, String name, Integer sex, Long birthday) {
		SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
    	
    	UserExtendVO userExtendVO = new UserExtendVO();
    	userExtendVO.setId(userId);
    	userExtendVO.setHeadPicUrl(headPicUrl);
    	userExtendVO.setName(name);
    	userExtendVO.setSex(sex);
    	if(EmptyUtil.isNotEmpty(birthday)){
    		try {
    			userExtendVO.setBirthday(format.parse(format.format(birthday)));
    		} catch (ParseException e) {
    			throw new BusinessException("用户生日格式转换错误");
    		}
    	}
    	
		return userExtendFacade.updateUserExtend(UserExtendConverter.toDTO(userExtendVO));
	}
	/**
     * 根据用户id查询福管+修改用户头像、真实姓名、公司等信息
     * @param dto
     * @return
     */
	@Override
	public Map<String, Object> userExtendByUserId(Long userId) {
		UserExtendDTO dto = userExtendFacade.userExtendByUserId(userId);
		Map<String, Object> map = new HashMap<>();
		map.put("userId", dto.getId());
		map.put("name", dto.getName());
		map.put("headPicUrl", dto.getHeadPicUrl());
		map.put("companyId", dto.getCompanyId());
		map.put("companyName", dto.getCompanyName());
		return map;
	}
	/**
     * 根据用户id查询福管+个人信息接口
     * @param dto
     * @return
     */
	@Override
	public Map<String, Object> userByUserId(Long userId) {
		UserExtendDTO dto = userExtendFacade.userByUserId(userId);
		Map<String, Object> map = new HashMap<>();
		map.put("userId", dto.getId());
		map.put("name", dto.getName());
		map.put("headPicUrl", dto.getHeadPicUrl());
		map.put("companyId", dto.getCompanyId());
		map.put("companyName", dto.getCompanyName());
		map.put("departmentId", dto.getDepartmentId());
		map.put("departmentName", dto.getDepartmentName());
		map.put("sex", dto.getSex());
		map.put("birthday", dto.getBirthday());
		map.put("entryTime", dto.getEntryTime());
		if(EmptyUtil.isEmpty(dto.getName())
		|| EmptyUtil.isEmpty(dto.getHeadPicUrl())
		|| EmptyUtil.isEmpty(dto.getCompanyId())
		|| EmptyUtil.isEmpty(dto.getDepartmentId())
		|| EmptyUtil.isEmpty(dto.getSex())
		|| EmptyUtil.isEmpty(dto.getBirthday())
		|| EmptyUtil.isEmpty(dto.getEntryTime())){
			map.put("isNotPerfect", 0);
		}else{
			map.put("isNotPerfect", 1);
		}
		
		return map;
	}
	/**
	 * 根据公司id按条件查询所有用户信息
	 * @param companyId
	 * @param name
	 * @param departmentId
	 * @param sex
	 * @param birthdayStartTime
	 * @param birthdayFinishTime
	 * @param entryStartTime
	 * @param entryFinishTime
	 * @param page
	 * @param req
	 * @return
	 */
	@Override
	public PageResult<Map<String, Object>> userAllOfPage(Long companyId, String name, Long departmentId, Integer sex,
			Long birthdayStartTime, Long birthdayFinishTime, Long entryStartTime, Long entryFinishTime,
			Long platformId,Pagination page) {
		SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );  
		UserExtendDTO dto = new UserExtendDTO();
		//set数据
		dto.setCompanyId(companyId);
		dto.setName(name);
		dto.setDepartmentId(departmentId);
		dto.setSex(sex);
		dto.setPlatformId(platformId);
		try {
			if(EmptyUtil.isNotEmpty(birthdayStartTime)){
				dto.setBirthdayStartTime(format.parse(format.format(birthdayStartTime)));
			}
			if(EmptyUtil.isNotEmpty(birthdayFinishTime)){
				dto.setBirthdayFinishTime(format.parse(format.format(birthdayFinishTime)));
			}
			if(EmptyUtil.isNotEmpty(entryStartTime)){
				dto.setEntryStartTime(format.parse(format.format(entryStartTime)));
			}
			if(EmptyUtil.isNotEmpty(entryFinishTime)){
				dto.setEntryFinishTime(format.parse(format.format(entryFinishTime)));
			}
		} catch (ParseException e) {
			throw new BusinessException("生日或入职时间搜索条件格式转换错误");
		}
		PageResult<UserExtendDTO> pageResult = userExtendFacade.userAllOfPage(dto,page);
		PageResult<Map<String, Object>> result = new PageResult<>();
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		List<UserExtendDTO> userExtendList = pageResult.getList();
		for (UserExtendDTO userExtendDTO : userExtendList) {
			Map<String, Object> map = new HashMap<>();
			map.put("userId", userExtendDTO.getId());
			map.put("name", userExtendDTO.getName());
			map.put("sex", userExtendDTO.getSex());
			map.put("birthday", userExtendDTO.getBirthday());
			map.put("entryTime", userExtendDTO.getEntryTime());
			map.put("mail", userExtendDTO.getMail());
			map.put("mobile", userExtendDTO.getMobile());
			map.put("departmentName", userExtendDTO.getDepartmentName());
			list.add(map);
		}
        result.setList(list);
        result.setPageNo(pageResult.getPageNo());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalSize(pageResult.getTotalSize());
		return result;
	}
	@Override
	public String saveUserBackground(String mail, String headPicUrl, String name,Long companyId, Long departmentId, Integer sex,
			Long birthday, Long entryTime) {
		if(StringUtils.isNotEmail(mail)){
			throw new BusinessException("该邮箱格式不对,请重新填写");
		}
		//添加主表信息
		UserDTO userDTO = userFacade.userByMail(mail);
		if(EmptyUtil.isNotEmpty(userDTO)){
			throw new BusinessException(BusinessExceptionConstant.EMAIL_NO_UNIQUE, "邮箱已存在");
		}
		if(EmptyUtil.isEmpty(companyId)){
			throw new BusinessException("公司编号不能为空");
		}
		//添加用户邮箱信息
		Long userId = saveUserMail(mail,companyId);
		SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
    	
    	UserExtendVO userExtendVO = new UserExtendVO();
    	userExtendVO.setId(userId);
    	userExtendVO.setHeadPicUrl(headPicUrl);
    	userExtendVO.setName(name);
    	userExtendVO.setSex(sex);
    	try {
			userExtendVO.setBirthday(format.parse(format.format(birthday)));
		} catch (ParseException e) {
			throw new BusinessException("用户生日格式转换错误");
		}
    	//添加扩展表信息
    	int rows = this.saveUserExtend(userExtendVO);
    	//添加福管+扩展表信息
    	Long saveUserWelfareWithTx = this.saveUserWelfareWithTx(userId, departmentId, entryTime);
    	if(rows != 0 && EmptyUtil.isNotEmpty(saveUserWelfareWithTx)){
    		return "新增用户信息成功";
    	}else{
    		return "新增用户信息失败";
    	}
	}
	//添加用户邮箱、公司信息返回用户id
	public Long saveUserMail(String mail,Long companyId){
		return userFacade.saveUserMail(mail,companyId);
	}
	@Override
	public String updateUserBackground(Long userId, String mail, String headPicUrl, String name,Long companyId, Long departmentId,
			Integer sex, Long birthday, Long entryTime) {
		int i= 0;
		SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		if(EmptyUtil.isEmpty(userId)){
			throw new BusinessException("用户id不能为空");
		}
		if(EmptyUtil.isNotEmpty(mail) || EmptyUtil.isNotEmpty(companyId)){
			updateUserMail(userId, mail, companyId);
		}
		if( EmptyUtil.isNotEmpty(headPicUrl) || EmptyUtil.isNotEmpty(name) || EmptyUtil.isNotEmpty(sex) || EmptyUtil.isNotEmpty(birthday)){
			updateUserExtend(userId, headPicUrl, name, sex, birthday);
		}
		if(EmptyUtil.isNotEmpty(departmentId) || EmptyUtil.isNotEmpty(entryTime)){
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
			i = userWelfareFacade.updateUserWelfareByUserIdWithTx(dto);
		}
		
		
		if(i == 0){
			return "修改用户信息失败";	
		}else{
			return "修改用户信息成功";	
		}
	}
	//根据用户id修改用户邮箱、公司信息
	public int updateUserMail(Long userId,String mail,Long companyId){
		UserDTO userDTO = new UserDTO();
		userDTO.setId(userId);
		userDTO.setMail(mail);
		userDTO.setCompanyId(companyId);
		return userFacade.updateEncryptInfoByUserWithTx(userDTO);
	}
	
	/**
	 * 根据公司id按条件查询所有用户信息
	 * @param companyId
	 * @param name
	 * @param departmentId
	 * @param sex
	 * @param birthdayStartTime
	 * @param birthdayFinishTime
	 * @param entryStartTime
	 * @param entryFinishTime
	 * @param page
	 * @param req
	 * @return
	 */
	@Override
	public List<UserWelfare> userAll(Long companyId, String name, Long departmentId, Integer sex,
			Long birthdayStartTime, Long birthdayFinishTime, Long entryStartTime, Long entryFinishTime, Long platformId) {
		SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );  
		UserExtendDTO dto = new UserExtendDTO();
		//set数据
		dto.setCompanyId(companyId);
		dto.setName(name);
		dto.setDepartmentId(departmentId);
		dto.setSex(sex);
		dto.setPlatformId(platformId);
		try {
			if(EmptyUtil.isNotEmpty(birthdayStartTime)){
				dto.setBirthdayStartTime(format.parse(format.format(birthdayStartTime)));
			}
			if(EmptyUtil.isNotEmpty(birthdayFinishTime)){
				dto.setBirthdayFinishTime(format.parse(format.format(birthdayFinishTime)));
			}
			if(EmptyUtil.isNotEmpty(entryStartTime)){
				dto.setEntryStartTime(format.parse(format.format(entryStartTime)));
			}
			if(EmptyUtil.isNotEmpty(entryFinishTime)){
				dto.setEntryFinishTime(format.parse(format.format(entryFinishTime)));
			}
		} catch (ParseException e) {
			throw new BusinessException("生日或入职时间搜索条件格式转换错误");
		}
		List<UserExtendDTO> userExtendList = userExtendFacade.userAll(dto);
		List<UserWelfare> list = new ArrayList<UserWelfare>();
		
		for (UserExtendDTO userExtendDTO : userExtendList) {
			UserWelfare userWelfare = new UserWelfare();
			userWelfare.setUserId(userExtendDTO.getId());
			userWelfare.setName(userExtendDTO.getName());
			userWelfare.setSex(String.valueOf(userExtendDTO.getSex()));
			//格式 24小时制：2016-07-06 09:39:58  
	        DateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //HH表示24小时制；  
	        if(EmptyUtil.isNotEmpty(userExtendDTO.getBirthday())){
	        	String birthday = dFormat.format(userExtendDTO.getBirthday());
				userWelfare.setBirthday(birthday);
	        }
	        if(EmptyUtil.isNotEmpty(userExtendDTO.getEntryTime())){
	        	String entryTime = dFormat.format(userExtendDTO.getEntryTime());
				userWelfare.setEntryTime(entryTime);
	        }
	        userWelfare.setMobile(userExtendDTO.getMobile());
			userWelfare.setMail(userExtendDTO.getMail());
			userWelfare.setDepartmentName(userExtendDTO.getDepartmentName());
			
			list.add(userWelfare);
		}
		return list;
	}
	


}
	