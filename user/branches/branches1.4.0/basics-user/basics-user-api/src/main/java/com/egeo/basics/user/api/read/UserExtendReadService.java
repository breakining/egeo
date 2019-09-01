package com.egeo.basics.user.api.read;

import java.util.List;

import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface UserExtendReadService {

	UserExtendDTO findById(Long id);

	PageResult<UserExtendDTO> findProductUser(Pagination page, UserExtendDTO dto2);

	/**
	 * 批量查询用户
	 * @param userIds
	 * @return
	 */
	List<UserExtendDTO> queryUserExtendsByIds(List<Long> userIds);

	/**
	 * 查询即将生日的用户列表
	 * @param companyId
	 * @return
	 */
	List<UserExtendDTO> querySoonBirthdayUsers(Long companyId);

	/**
	 * 查询即将入职纪念日的用户列表
	 * @param companyId
	 * @return
	 */
	List<UserExtendDTO> querySoonEntrydayUsers(Long companyId);
	/**
     * 根据用户id查询福管+修改用户头像、真实姓名、公司等信息
     * @param dto
     * @return
     */
	UserExtendDTO userExtendByUserId(Long userId);
	/**
     * 根据用户id查询福管+个人信息接口
     * @param dto
     * @return
     */
	UserExtendDTO userByUserId(Long userId);
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
	PageResult<UserExtendDTO> userAllOfPage(UserExtendDTO dto, Pagination page);
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
	List<UserExtendDTO> userAll(UserExtendDTO dto);
}
	