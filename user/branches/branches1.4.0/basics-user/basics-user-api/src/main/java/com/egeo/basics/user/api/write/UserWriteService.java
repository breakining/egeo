package com.egeo.basics.user.api.write;


import com.egeo.basics.user.model.dto.UserCookieDTO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserExtendDTO;

public interface UserWriteService {
	/**
	 * 修改用户密码
	 * @param updUser
	 * @return
	 */
	int updateEncryptInfoByUserWithTx(UserDTO updUser);

	int updateUserInfoWithTx(UserDTO user);

	void deleteWithTx(UserDTO dto);
	
	String saveOrUpdateWithTx(UserDTO dto,UserExtendDTO userExtendDTO,UserCookieDTO userCookieDTO);
	/**
     * 福管+用户注册
     * @param dto
     * @return
     */
	Long userRegisterWithTx(UserDTO dto);
	/**
	 * 更新用户主表信息
	 */
	int updateUserWithTx(Long userId, Long companyId);
	/**
	 * 根据邮箱修改密码
	 * @param vo
	 * @return
	 */
	int updateUserPassword(String mail, String password);
	/**
	 * 添加用户邮箱信息返回用户id
	 * @param mail
	 * @return
	 */
	Long saveUserMail(String mail,Long companyId);

	

	
}
	