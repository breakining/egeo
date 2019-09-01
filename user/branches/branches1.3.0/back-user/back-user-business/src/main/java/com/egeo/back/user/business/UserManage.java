package com.egeo.back.user.business;

import javax.servlet.http.HttpServletRequest;

import com.egeo.back.user.model.vo.PassWordVO;
import com.egeo.back.user.model.vo.ProductUser;
import com.egeo.back.user.model.vo.UserCookieVO;
import com.egeo.back.user.model.vo.UserExtendVO;
import com.egeo.back.user.model.vo.UserVO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface UserManage {

    UserVO findUniqueUser(UserVO user);

    /**
     * 根据id查用户信息
     * 
     * @param user
     * @return
     */
    UserDTO findUserByID(Long userId);

    /**
     * 修改用户密码
     * 
     * @param user
     */
    int updateEncryptInfoByUserWithTx(UserDTO updUser);

    /**
     * 修改用户
     * 
     * @param user
     * @return
     */
    int updateUserInfo(UserDTO user);

    int updateEncryptByNewEncryptWithTx(PassWordVO passWord, HttpServletRequest req);

    // 查询所有用户
    public PageResult<UserDTO> findPage(Pagination page, UserVO userVO, UserExtendVO userExtendVO,
            UserCookieVO userCookieVO);
    /* String saveUser(UserDTO user); */

    // 更新用户
    public String saveOrUpdate(UserVO userVO, UserExtendVO userExtendVO, UserCookieVO userCookieVO);

    // 根据id删除用户
    void deleteWithTx(UserDTO dto);

    UserDTO userById(UserVO vo);

	PageResult<ProductUser> findProductUser(Pagination page, UserVO userVO, UserExtendVO userExtendVO);

	ProductUser productUserById(ProductUser vo);

}
