package com.egeo.basics.user.service.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.UserInformationReadService;
import com.egeo.basics.user.business.read.UserInformationReadManage;
import com.egeo.basics.user.converter.UserInformationConverter;
import com.egeo.basics.user.model.dto.UserInformationDTO;
import com.egeo.basics.user.po.UserInformationPO;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("userInformationReadService")
public class UserInformationReadServiceImpl extends BaseService implements UserInformationReadService {
	@Autowired
	private UserInformationReadManage userInformationReadManage;

	@Override
	public UserInformationDTO findUserInformationById(UserInformationDTO dto) {
		UserInformationPO po = UserInformationConverter.toPO(dto);
		UserInformationPO list = userInformationReadManage.findUserInformationById(po);		
		return UserInformationConverter.toDTO(list);
	}

	@Override
	public PageResult<UserInformationDTO> findUserInformationOfPage(UserInformationDTO dto, Pagination page) {
		UserInformationPO po = UserInformationConverter.toPO(dto);
        PageResult<UserInformationPO> pageResult = userInformationReadManage.findUserInformationOfPage(po, page);
        
        List<UserInformationDTO> list = UserInformationConverter.toDTO(pageResult.getList());
        PageResult<UserInformationDTO> result = new PageResult<UserInformationDTO>();
        result.setList(list);
        result.setPageNo(pageResult.getPageNo());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalSize(pageResult.getTotalSize());
        return result;
	}

	@Override
	public List<UserInformationDTO> findUserInformationAll(UserInformationDTO dto) {
		UserInformationPO po = UserInformationConverter.toPO(dto);
		List<UserInformationPO> list = userInformationReadManage.findUserInformationAll(po);		
		return UserInformationConverter.toDTO(list);
	}
	/**
	 * 根据userId查询未读用户消息数量
	 * @param vo
	 * @param req
	 * @return
	 */
	@Override
	public int cntByUserId(UserInformationDTO dto) {
		
		return userInformationReadManage.cntByUserId(UserInformationConverter.toPO(dto));
	}
}
	