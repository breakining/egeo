package com.egeo.basics.user.service.write;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.filter.Assert;
import com.egeo.basics.user.api.write.UserExtendWriteService;
import com.egeo.basics.user.api.write.UserPlatformWriteService;
import com.egeo.basics.user.api.write.UserWriteService;
import com.egeo.basics.user.business.read.UserReadManage;
import com.egeo.basics.user.business.write.UserWriteManage;
import com.egeo.basics.user.converter.UserConverter;
import com.egeo.basics.user.model.dto.UserCookieDTO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.basics.user.model.dto.UserPlatformDTO;
import com.egeo.basics.user.po.UserPO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.exception.BusinessException;
import com.egeo.util.security.MD5Support;
import com.egeo.util.security.SaltUtils;
import com.egeo.utils.EmptyUtil;
import com.egeo.utils.str.StringUtils;

@Service("userWriteService")
public class UserWriteServiceImpl extends BaseService implements UserWriteService {
	private static final Integer LENGTH = 16;
	@Autowired
	private UserWriteManage userWriteManage;

	@Autowired
	private UserReadManage userReadManage;

	@Autowired
	private UserExtendWriteService userExtendWriteService;

	@Autowired
	private UserPlatformWriteService userPlatformWriteService;

	@Override
	public int updateEncryptInfoByUserWithTx(UserDTO updUser) {
		
		return userWriteManage.updateEncryptInfoByUserWithTx(UserConverter.toPO(updUser));
	}

	@Override
	public int updateUserInfoWithTx(UserDTO user) {
		
		return userWriteManage.updateUserInfo(UserConverter.toPO(user));
	}

	public String saveOrUpdateWithTx(UserDTO dto, UserExtendDTO userExtendDTO, UserCookieDTO userCookieDTO) {
		UserPO po = UserConverter.toPO(dto);
		UserPO tar = userWriteManage.getIdUser(po);
		if (tar != null) {
			// 强制用户不能修改账号
			po.setLoginName(null);
			
			if(EmptyUtil.isNotEmpty(po.getMobile())){
				// 根据手机查询用户
				List<UserPO> manageList = userReadManage.userByManage(po.getMobile());
				if (manageList.size() > 0 && !manageList.get(0).getId().equals(po.getId())) {
					throw new BusinessException("该手机已被注册");
				}
			}
			
			if(EmptyUtil.isNotEmpty(po.getMail())){
				// 根据邮箱查询用户
				UserPO mail = userReadManage.userByMail(po.getMail());
				if (mail != null && !mail.getId().equals(po.getId())) {
					throw new BusinessException("该邮箱已被注册");
				}
			}
			
			if (po.getPassword() != null && !po.getPassword().equals("")) {
				if (po.getPassword().length() < 6) {
					throw new BusinessException(BusinessExceptionConstant.GREATERSIX, "密码必须大于6位");
				}
				// 字符串是否与正则表达式相匹配
				if (!StringUtils.isNotPasswordMay(po.getPassword())) {
					throw new BusinessException(BusinessExceptionConstant.LETTER_FIGURE_SYMBOL,
							"密码必须包含大写字母、小写字母、数字和符号其中三项！");
				}
				String salt = SaltUtils.getRandomSalt(LENGTH);
				String md5 = MD5Support.MD5(po.getPassword(), salt);
				po.setPassword(md5);
				po.setSalt(salt);
			} else {
				po.setPassword(null);
			}

			userWriteManage.update(po);
			// 修改扩展表信息
			userExtendWriteService.updateWithTx(userExtendDTO);
			return "编辑用户成功";
		} else {
			if (po.getLoginName() == null) {
				throw new BusinessException(BusinessExceptionConstant.USER_NAME_NO_PASSWORD, "帐号不能为空！");
			}
			List<UserPO> list = userReadManage.userByloginName(po);
			if (list != null) {
				throw new BusinessException(BusinessExceptionConstant.ROLE_EXIST, "用户已存在");
			}
			if(EmptyUtil.isNotEmpty(po.getMobile())){
				// 根据手机查询用户
				List<UserPO> manageList = userReadManage.userByManage(po.getMobile());
				if (manageList.size() > 0 && !manageList.get(0).getId().equals(po.getId())) {
					throw new BusinessException("该手机已被注册");
				}
			}
			
			if(EmptyUtil.isNotEmpty(po.getMail())){
				// 根据邮箱查询用户
				UserPO mail = userReadManage.userByMail(po.getMail());
				if (mail != null && !mail.getId().equals(po.getId())) {
					throw new BusinessException("该邮箱已被注册");
				}
			}

			if (po.getPassword().length() < 6) {
				throw new BusinessException(BusinessExceptionConstant.GREATERSIX, "密码必须大于6位");
			}
			// 字符串是否与正则表达式相匹配
			if (!StringUtils.isNotPasswordMay(po.getPassword())) {
				throw new BusinessException(BusinessExceptionConstant.LETTER_FIGURE_SYMBOL,
						"密码必须包含大写字母、小写字母、数字和符号其中三项！");
			}

			String salt = SaltUtils.getRandomSalt(LENGTH);
			po.setPassword(MD5Support.MD5(po.getPassword(), salt));
			po.setSalt(salt);
			Long userId = userWriteManage.save(po);

			// 添加用户平台信息
			UserPlatformDTO userPlatformDTO = new UserPlatformDTO();
			userPlatformDTO.setUserId(userId);
			userPlatformDTO.setPlatformId(dto.getPlatformId());
			userPlatformWriteService.saveWithTx(userPlatformDTO);

			// 添加扩展表信息
			userExtendDTO.setId(userId);
			userExtendWriteService.saveWithTx(userExtendDTO);
			return "添加用户成功";
		}

	}

	@Override
	public void deleteWithTx(UserDTO dto) {
		Assert.notNull(dto, -1);
		Assert.notNull(dto.getId(), -1, "");
		userWriteManage.delete(dto.getId());
	}
	/**
     * 福管+用户注册
     * @param dto
     * @return
     */
	@Override
	public Long userRegisterWithTx(UserDTO dto) {
		UserPO po = UserConverter.toPO(dto);
		String salt = SaltUtils.getRandomSalt(LENGTH);
		po.setPassword(MD5Support.MD5(po.getPassword(), salt));
		po.setSalt(salt);
		return userWriteManage.userRegister(po);
	}
	/**
	 * 更新用户主表信息
	 */
	@Override
	public int updateUserWithTx(Long userId, Long companyId) {
		
		return userWriteManage.updateUserWithTx(userId, companyId);
	}
	/**
	 * 根据邮箱修改密码
	 * @param vo
	 * @return
	 */
	@Override
	public int updateUserPassword(String mail, String password) {
		
		return userWriteManage.updateUserPassword(mail, password);
	}
	/**
	 * 添加用户邮箱信息返回用户id
	 * @param mail
	 * @return
	 */
	@Override
	public Long saveUserMail(String mail,Long companyId) {
		
		return userWriteManage.saveUserMail(mail,companyId);
	}
}
