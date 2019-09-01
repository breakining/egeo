package com.egeo.basics.user.service.read;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.UserExtendReadService;
import com.egeo.basics.user.business.read.UserExtendReadManage;
import com.egeo.basics.user.condition.UserExtendCondition;
import com.egeo.basics.user.converter.UserExtendConverter;
import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.basics.user.po.UserExtendPO;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("userExtendReadService")
public class UserExtendReadServiceImpl extends BaseService implements UserExtendReadService {
	@Autowired
	private UserExtendReadManage userExtendReadManage;

	@Override
	public UserExtendDTO findById(Long id) {
		
		return UserExtendConverter.toDTO(userExtendReadManage.findById(id));
	}

	@Override
	public PageResult<UserExtendDTO> findProductUser(Pagination page, UserExtendDTO dto2) {
		UserExtendPO po = UserExtendConverter.toPO(dto2);
        PageResult<UserExtendPO> pageResult = userExtendReadManage.findPage(page, po);
        
        List<UserExtendDTO> list = new ArrayList<UserExtendDTO>();
        for (UserExtendPO tmp : pageResult.getList()) {
            UserExtendDTO userExtendDTO = UserExtendConverter.toDTO(tmp);
                list.add(userExtendDTO);
        }
        PageResult<UserExtendDTO> result = new PageResult<UserExtendDTO>();
        result.setList(list);
        result.setPageNo(pageResult.getPageNo());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalSize(pageResult.getTotalSize());
        return result;
	}

	@Override
	public List<UserExtendDTO> queryUserExtendsByIds(List<Long> userIds) {
		
		return UserExtendConverter.toDTO(userExtendReadManage.queryUserExtendsByIds(userIds));
	}

	@Override
	public List<UserExtendDTO> querySoonBirthdayUsers(Long companyId) {
		return UserExtendConverter.toDTO(userExtendReadManage.querySoonBirthdayUsers(companyId));
	}

	@Override
	public List<UserExtendDTO> querySoonEntrydayUsers(Long companyId) {
		return UserExtendConverter.toDTO(userExtendReadManage.querySoonEntrydayUsers(companyId));
	}
	/**
     * 根据用户id查询福管+修改用户头像、真实姓名、公司等信息
     * @param dto
     * @return
     */
	@Override
	public UserExtendDTO userExtendByUserId(Long userId) {
		UserExtendCondition userExtendCondition = userExtendReadManage.userExtendByUserId(userId);
		UserExtendDTO userExtendDTO = UserExtendConverter.toDTO(userExtendCondition);
		userExtendDTO.setCompanyId(userExtendCondition.getCompanyId());
		userExtendDTO.setCompanyName(userExtendCondition.getCompanyName());
		return userExtendDTO;
	}
	/**
     * 根据用户id查询福管+个人信息接口
     * @param dto
     * @return
     */
	@Override
	public UserExtendDTO userByUserId(Long userId) {
		UserExtendCondition userExtendCondition = userExtendReadManage.userByUserId(userId);
		UserExtendDTO userExtendDTO = UserExtendConverter.toDTO(userExtendCondition);
		userExtendDTO.setCompanyId(userExtendCondition.getCompanyId());
		userExtendDTO.setCompanyName(userExtendCondition.getCompanyName());
		userExtendDTO.setDepartmentId(userExtendCondition.getDepartmentId());
		userExtendDTO.setDepartmentName(userExtendCondition.getDepartmentName());
		userExtendDTO.setEntryTime(userExtendCondition.getEntryTime());
		return userExtendDTO;
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
	public PageResult<UserExtendDTO> userAllOfPage(UserExtendDTO dto, Pagination page) {
		UserExtendPO po = UserExtendConverter.toPO(dto);
        PageResult<UserExtendCondition> pageResult = userExtendReadManage.userAllOfPage(po,page);
        
        List<UserExtendDTO> list = new ArrayList<UserExtendDTO>();
        for (UserExtendCondition tmp : pageResult.getList()) {
            UserExtendDTO userExtendDTO = UserExtendConverter.toDTO(tmp);
            userExtendDTO.setCompanyId(tmp.getCompanyId());
    		userExtendDTO.setCompanyName(tmp.getCompanyName());
    		userExtendDTO.setDepartmentId(tmp.getDepartmentId());
    		userExtendDTO.setDepartmentName(tmp.getDepartmentName());
    		userExtendDTO.setEntryTime(tmp.getEntryTime());
    		userExtendDTO.setMail(tmp.getMail());
            list.add(userExtendDTO);
        }
        PageResult<UserExtendDTO> result = new PageResult<UserExtendDTO>();
        result.setList(list);
        result.setPageNo(pageResult.getPageNo());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalSize(pageResult.getTotalSize());
        return result;
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
	public List<UserExtendDTO> userAll(UserExtendDTO dto) {
		List<UserExtendCondition> userExtendList = userExtendReadManage.userAll(UserExtendConverter.toPO(dto));
		List<UserExtendDTO> list = new ArrayList<UserExtendDTO>();
        for (UserExtendCondition tmp : userExtendList) {
            UserExtendDTO userExtendDTO = UserExtendConverter.toDTO(tmp);
            userExtendDTO.setCompanyId(tmp.getCompanyId());
    		userExtendDTO.setCompanyName(tmp.getCompanyName());
    		userExtendDTO.setDepartmentId(tmp.getDepartmentId());
    		userExtendDTO.setDepartmentName(tmp.getDepartmentName());
    		userExtendDTO.setEntryTime(tmp.getEntryTime());
    		userExtendDTO.setMail(tmp.getMail());
            list.add(userExtendDTO);
        }
		return list;
	}
}
	