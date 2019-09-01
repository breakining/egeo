package com.egeo.back.user.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.back.user.model.vo.ProductUser;
import com.egeo.basics.user.api.read.UserExtendReadService;
import com.egeo.basics.user.api.read.UserReadService;
import com.egeo.basics.user.api.write.UserExtendWriteService;
import com.egeo.basics.user.api.write.UserWriteService;
import com.egeo.basics.user.model.dto.UserCookieDTO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;



@Component
public class UserFacade {
	
	@Reference
	private static UserReadService userReadService;
	
	@Reference
	private UserWriteService userWriteService;
	
	@Reference
	private UserExtendReadService userExtendReadService;
	
	@Reference
	private UserExtendWriteService userExtendWriteService;
	

	public UserDTO findUniqueUser(UserDTO dto) {
		// TODO Auto-generated method stub
		return userReadService.findUniqueUser(dto);
	}

	public int updateEncryptInfoByUserWithTx(UserDTO updUser) {
		// TODO Auto-generated method stub
		return userWriteService.updateEncryptInfoByUserWithTx(updUser);
	}

	public UserDTO findUserByID(Long userId) {
		// TODO Auto-generated method stub
		return userReadService.findUserByID(userId);
	}

	

	
	public int updateUserInfo(UserDTO user) {
	
		return  userWriteService. updateUserInfoWithTx(user);
	}

	public static PageResult<UserDTO> findPage(Pagination page,UserDTO dto,UserExtendDTO userExtendDTO,UserCookieDTO userCookieDTO) {
		
		return userReadService.findPage(page,dto,userExtendDTO,userCookieDTO);
		
	}

	public String saveOrUpdate(UserDTO dto,UserExtendDTO userExtendDTO,UserCookieDTO userCookieDTO) {
		return userWriteService.saveOrUpdateWithTx(dto,userExtendDTO,userCookieDTO);
		
	}

	public void deleteWithTx(UserDTO dto) {
		UserExtendDTO userExtendDTO = new UserExtendDTO();
		userExtendDTO.setId(dto.getId());
		int rows = userExtendWriteService.deleteWithTx(userExtendDTO);
		userWriteService.deleteWithTx(dto);
		
	}

        public UserDTO userById(UserDTO dto) {
            // TODO Auto-generated method stub
            return userReadService.userById(dto);
        }

		public PageResult<ProductUser> findProductUser(Pagination page, UserDTO dto, UserExtendDTO dto2) {
			PageResult<ProductUser> pageResult = new PageResult<ProductUser>();
			List<ProductUser> lists = new ArrayList<ProductUser>();
			//查看用户信息
			PageResult<UserDTO> userList = userReadService.findProductUser(page,dto);
			List<UserDTO> list = userList.getList();
			for (UserDTO userDTO : list) {
				ProductUser productUser = new ProductUser();
				//根据用户id查询扩展信息
				UserExtendDTO userExtendDTO = userExtendReadService.findById(userDTO.getId());
				productUser.setId(userDTO.getId());
				productUser.setName(userExtendDTO.getName());
				productUser.setLoginName(userDTO.getLoginName());
				productUser.setSex(userExtendDTO.getSex());
				productUser.setBirthday(userExtendDTO.getBirthday());
				productUser.setMobile(userDTO.getMobile());
				productUser.setMail(userDTO.getMail());
				productUser.setStatus(userExtendDTO.getStatus());
				productUser.setCreateTime(userDTO.getCreateTime());
				lists.add(productUser);
			}
			pageResult.setList(lists);
			return pageResult;
		}

		public ProductUser productUserById(ProductUser vo) {
			//根据用户id查询用户信息
			UserDTO userDTO = userReadService.findUserByID(vo.getId());
			//根据用户id查询用户扩展信息
			UserExtendDTO userExtendDTO = userExtendReadService.findById(vo.getId());
			
			ProductUser productUser = new ProductUser();
			productUser.setId(userDTO.getId());
			productUser.setName(userExtendDTO.getName());
			productUser.setLoginName(userDTO.getLoginName());
			productUser.setSex(userExtendDTO.getSex());
			productUser.setBirthday(userExtendDTO.getBirthday());
			productUser.setMobile(userDTO.getMobile());
			productUser.setMail(userDTO.getMail());
			productUser.setStatus(userExtendDTO.getStatus());
			productUser.setCreateTime(userDTO.getCreateTime());
			return productUser;
		}
	

	

}
	