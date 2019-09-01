package com.egeo.basics.user.business.read;

import java.util.List;

import com.egeo.basics.user.condition.UserCondition;
import com.egeo.basics.user.po.UserCookiePO;
import com.egeo.basics.user.po.UserExtendPO;
import com.egeo.basics.user.po.UserPO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface UserReadManage {

    UserPO findUniqueUser(UserPO po);

    UserPO findUserByID(Long userId);

    public PageResult<UserPO> findPage(Pagination page, UserPO po);

    PageResult<UserCondition> findPageUser(Pagination page, UserPO po, UserExtendPO po2,
            UserCookiePO userCookiePO);

    List<UserPO> userByloginName(UserPO po);

    UserPO userById(UserPO po);
}
