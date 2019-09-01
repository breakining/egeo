package com.egeo.basics.user.service.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.UserWelfareReadService;
import com.egeo.basics.user.business.read.UserWelfareReadManage;
import com.egeo.basics.user.converter.UserWelfareConverter;
import com.egeo.basics.user.model.dto.UserWelfareDTO;
import com.egeo.basics.user.po.UserWelfarePO;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("userWelfareReadService")
public class UserWelfareReadServiceImpl extends BaseService implements UserWelfareReadService {
	@Autowired
	private UserWelfareReadManage userWelfareReadManage;

	@Override
	public UserWelfareDTO findUserWelfareById(UserWelfareDTO dto) {
		UserWelfarePO po = UserWelfareConverter.toPO(dto);
		UserWelfarePO list = userWelfareReadManage.findUserWelfareById(po);		
		return UserWelfareConverter.toDTO(list);
	}

	@Override
	public PageResult<UserWelfareDTO> findUserWelfareOfPage(UserWelfareDTO dto, Pagination page) {
		UserWelfarePO po = UserWelfareConverter.toPO(dto);
        PageResult<UserWelfarePO> pageResult = userWelfareReadManage.findUserWelfareOfPage(po, page);
        
        List<UserWelfareDTO> list = UserWelfareConverter.toDTO(pageResult.getList());
        PageResult<UserWelfareDTO> result = new PageResult<UserWelfareDTO>();
        result.setList(list);
        result.setPageNo(pageResult.getPageNo());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalSize(pageResult.getTotalSize());
        return result;
	}

	@Override
	public List<UserWelfareDTO> findUserWelfareAll(UserWelfareDTO dto) {
		UserWelfarePO po = UserWelfareConverter.toPO(dto);
		List<UserWelfarePO> list = userWelfareReadManage.findUserWelfareAll(po);		
		return UserWelfareConverter.toDTO(list);
	}

	@Override
	public List<UserWelfareDTO> queryUserWelfaresByUserIds(List<Long> userIdList) {
		return UserWelfareConverter.toDTO(userWelfareReadManage.queryUserWelfaresByUserIds(userIdList));
	}
}
	