package com.egeo.basics.user.api.read;

import java.util.List;

import com.egeo.basics.user.model.dto.UserCookieDTO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.basics.user.model.dto.UserWelfareApp;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface UserReadService {
	
	UserDTO findUniqueUser(UserDTO dto);

	UserDTO findUserByID(Long userId);
	
	public PageResult<UserDTO> findPage(Pagination page,UserDTO dto,UserExtendDTO userExtendDTO,UserCookieDTO userCookieDTO);

	UserDTO userById(UserDTO dto);

	PageResult<UserDTO> findProductUser(Pagination page, UserDTO dto);
	/**
	 * 通过用户id查询用户昵称和头像信息
	 * @return
	 */
	UserWelfareApp userWelfareAppById(Long userId);
	/**
	 * 根据邮箱查询用户
	 * @param mail
	 * @return
	 */
	UserDTO userByMail(String mail);

	/**
	 * 分页查询公司用户列表
	 * @param companyId
	 * @param page
	 * @return
	 */
	PageResult<UserExtendDTO> queryUserListByCompanyId(Long companyId, Pagination page);

	/**
	 * 分页查询部门用户列表
	 * @param departmentId
	 * @param page
	 * @return
	 */
	PageResult<UserExtendDTO> queryUserListByDepartmentId(Long departmentId, Pagination page);

	/**
	 * 批量查询用户信息
	 * @param userIdList
	 * @return
	 */
	List<UserDTO> queryUserByIds(List<Long> userIdList);


	
}
	