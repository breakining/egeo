package com.egeo.basics.user.dao.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.egeo.basics.user.condition.UserCondition;
import com.egeo.basics.user.po.UserPO;
import com.egeo.core.orm.BaseReadDAO;
import com.egeo.core.orm.Pagination;

public interface UserReadDAO extends BaseReadDAO<UserPO>{

    int countOfPageUser(@Param("userCondition") UserCondition userCondition);

    List<UserCondition> findOfPageUser(@Param("userCondition") UserCondition userCondition,@Param("page") Pagination page);

    List<UserPO> findUniqueUser(UserPO po);

	int count(@Param("po")UserPO po);

	List<UserPO> page(@Param("po")UserPO po, @Param("page")Pagination page);
	/**
	 * 通过用户id查询用户昵称和头像信息
	 * @return
	 */
	UserCondition userWelfareAppById(@Param("userId")Long userId);

	/**
	 * 批量查询用户信息
	 * @param userIdList
	 * @return
	 */
	List<UserPO> queryUserByIds(@Param("ids")List<Long> userIdList);
}
	