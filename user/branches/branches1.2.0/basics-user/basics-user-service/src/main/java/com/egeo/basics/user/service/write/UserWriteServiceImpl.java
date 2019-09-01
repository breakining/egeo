package com.egeo.basics.user.service.write;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.rpc.filter.Assert;
import com.egeo.basics.user.api.write.UserCookieWriteService;
import com.egeo.basics.user.api.write.UserExtendWriteService;
import com.egeo.basics.user.api.write.UserWriteService;
import com.egeo.basics.user.business.read.UserReadManage;
import com.egeo.basics.user.business.write.UserWriteManage;
import com.egeo.basics.user.converter.UserConverter;
import com.egeo.basics.user.model.dto.UserCookieDTO;
import com.egeo.basics.user.model.dto.UserDTO;
import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.basics.user.po.UserPO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.exception.BusinessException;
import com.egeo.util.security.MD5Support;
import com.egeo.util.security.SaltUtils;

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
        private UserCookieWriteService userCookieWriteService;

	@Override
	public int updateEncryptInfoByUserWithTx(UserDTO updUser) {
		// TODO Auto-generated method stub
		return userWriteManage.updateEncryptInfoByUserWithTx(UserConverter.toPO(updUser));
	}

	@Override
	public int updateUserInfo(UserDTO user) {
		// TODO Auto-generated method stub
		return userWriteManage. updateUserInfo(UserConverter.toPO(user));
	}

	public String saveOrUpdateWithTx(UserDTO dto,UserExtendDTO userExtendDTO,UserCookieDTO userCookieDTO) {
		UserPO po = UserConverter.toPO(dto);
		UserPO tar = userWriteManage.getIdUser(po);
                int rows = 0;
                if(tar != null){
                        if(po.getLoginName() !=null){
                                tar.setLoginName(po.getLoginName());
                        }
                        if(po.getPassword() !=null){
                                tar.setPassword(MD5Support.MD5(po.getPassword(), SaltUtils.getRandomSalt(LENGTH)));     
                        }
                        if(po.getMobile() !=null){
                                tar.setMobile(po.getMobile());  
                        }
                        if(po.getMail() !=null){
                                tar.setMail(po.getMail());      
                        }
                        if(po.getDelFlag() !=null){
                                tar.setDelFlag(po.getDelFlag());        
                        }
                        if(po.getQrcode() !=null){
                                tar.setQrcode(po.getQrcode());
                        }
                        if(po.getToken() !=null){
                                tar.setToken(po.getToken());    
                        }
                        if(po.getSalt() !=null){
                                tar.setSalt(po.getSalt());      
                        }
                        if(po.getUpdateSalt() !=null){
                                tar.setUpdateSalt(po.getUpdateSalt());  
                        }
                        if(po.getCompanyId() !=null){
                                tar.setCompanyId(po.getCompanyId());
                        }
                        tar.setUpdateSalt(new Date());
                        rows = userWriteManage.update(tar);
                        //修改扩展表信息
                        rows += userExtendWriteService.update(userExtendDTO);
                        rows += userCookieWriteService.update(userCookieDTO);
                }else{
                        po.setUpdateSalt(new Date());
                        List<UserPO> list = userReadManage.userByloginName(po);
                        if(list != null){
                            throw new BusinessException(BusinessExceptionConstant.ROLE_EXIST,"用户以存在");
                        }else{
                            po.setPassword(MD5Support.MD5(po.getPassword(), SaltUtils.getRandomSalt(LENGTH)));
                            rows = userWriteManage.save(po);
                          //添加扩展表信息
                            rows += userExtendWriteService.save(userExtendDTO);
                            userCookieWriteService.saveUserCookieWithTx(userCookieDTO);
                        }
                }
                
                return rows+"";
                
	}
	
	@Override
	public void deleteWithTx(UserDTO dto) {
		Assert.notNull(dto, -1);
		Assert.notNull(dto.getId(), -1, "");
		userWriteManage.delete(dto.getId());
	}
}
	
