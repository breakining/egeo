package com.egeo.basics.user.api.read;


import java.util.List;
	
import com.egeo.basics.user.model.dto.UserInformationDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface UserInformationReadService {

	public UserInformationDTO findUserInformationById(UserInformationDTO dto);

	public PageResult<UserInformationDTO> findUserInformationOfPage(UserInformationDTO dto,Pagination page);

	public List<UserInformationDTO> findUserInformationAll(UserInformationDTO dto);
	/**
	 * 根据userId查询未读用户消息数量
	 * @param vo
	 * @param req
	 * @return
	 */
	public int cntByUserId(UserInformationDTO dto);
}
	