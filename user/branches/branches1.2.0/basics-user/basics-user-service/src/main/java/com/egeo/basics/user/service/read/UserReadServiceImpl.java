package com.egeo.basics.user.service.read;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.UserReadService;
import com.egeo.basics.user.business.read.UserReadManage;
import com.egeo.basics.user.condition.UserCondition;
import com.egeo.basics.user.converter.UserConverter;
import com.egeo.basics.user.converter.UserCookieConverter;
import com.egeo.basics.user.converter.UserExtendConverter;
import com.egeo.basics.user.model.dto.UserCookieDTO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.basics.user.po.UserCookiePO;
import com.egeo.basics.user.po.UserExtendPO;
import com.egeo.basics.user.po.UserPO;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("userReadService")
public class UserReadServiceImpl extends BaseService implements UserReadService {
	@Autowired
	private UserReadManage userReadManage;
	
	@Override
	public UserDTO findUniqueUser(UserDTO dto) {
		// TODO Auto-generated method stub		
		UserPO	po = userReadManage.findUniqueUser(UserConverter.toPO(dto));
		return UserConverter.toDTO(po);
	}

	@Override
	public UserDTO findUserByID(Long userId) {
		// TODO Auto-generated method stub
		UserPO	po =userReadManage.findUserByID(userId);
		return UserConverter.toDTO(po);
	}
	
	@Override
	public PageResult<UserDTO> findPage(Pagination page,UserDTO dto,UserExtendDTO userExtendDTO,UserCookieDTO userCookieDTO) {
		UserPO po = UserConverter.toPO(dto);
		UserExtendPO po2 = UserExtendConverter.toPO(userExtendDTO);
		UserCookiePO userCookiePO = UserCookieConverter.toPO(userCookieDTO);
		PageResult<UserCondition> pageResult = userReadManage.findPageUser(page, po,po2,userCookiePO);
		
		List<UserDTO> list = new ArrayList<UserDTO>();
		for (UserCondition tmp : pageResult.getList()) {
		    UserDTO userDTO = UserConverter.toDTO(tmp);
		    userDTO.setName(tmp.getName());
			list.add(userDTO);
		}
		PageResult<UserDTO> result = new PageResult<UserDTO>();
		result.setList(list);
		result.setPageNo(pageResult.getPageNo());
		result.setPageSize(pageResult.getPageSize());
		result.setTotalSize(pageResult.getTotalSize());
		return result;
		
	}

}
	