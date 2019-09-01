package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.write.UserExtendWriteService;
import com.egeo.basics.user.business.read.UserExtendReadManage;
import com.egeo.basics.user.business.write.UserExtendWriteManage;
import com.egeo.basics.user.converter.UserExtendConverter;
import com.egeo.basics.user.model.dto.UserExtendDTO;
import com.egeo.basics.user.po.UserExtendPO;
import com.egeo.core.basics.service.BaseService;

@Service("userExtendWriteService")
public class UserExtendWriteServiceImpl extends BaseService implements UserExtendWriteService {
	@Autowired
	private UserExtendWriteManage userExtendWriteManage;
	
	@Autowired
        private UserExtendReadManage userExtendReadManage;

    @Override
    public int save(UserExtendDTO userExtendDTO) {
        return userExtendWriteManage.save(UserExtendConverter.toPO(userExtendDTO));
    }

    @Override
    public int update(UserExtendDTO userExtendDTO) {
        UserExtendPO extendPO = UserExtendConverter.toPO(userExtendDTO);
        UserExtendPO userExtendPO= userExtendReadManage.findById(userExtendDTO.getId());
        if(extendPO.getSex() != null){
            userExtendPO.setSex(extendPO.getSex());
        }
        if(extendPO.getNickname() != null){
            userExtendPO.setNickname(extendPO.getNickname());
        }
        if(extendPO.getHeadPicUrl() != null){
            userExtendPO.setHeadPicUrl(extendPO.getHeadPicUrl());
        }
        if(extendPO.getName() != null){
            userExtendPO.setName(extendPO.getName());
        }
        if(extendPO.getRegtime() != null){
            userExtendPO.setRegtime(extendPO.getRegtime());
        }
        if(extendPO.getBirthday() != null){
            userExtendPO.setBirthday(extendPO.getBirthday());
        }
        if(extendPO.getMobile() != null){
            userExtendPO.setMobile(extendPO.getMobile());
        }
        if(extendPO.getQq() != null){
            userExtendPO.setQq(extendPO.getQq());
        }
        if(extendPO.getMemberCode() != null){
            userExtendPO.setMemberCode(extendPO.getMemberCode());
        }
        if(extendPO.getRemark() != null){
            userExtendPO.setRemark(extendPO.getRemark());
        }
        if(extendPO.getLastlogin() != null){
            userExtendPO.setLastlogin(extendPO.getLastlogin());
        }
        if(extendPO.getActivityInfo() != null){
            userExtendPO.setActivityInfo(extendPO.getActivityInfo());
        }
        if(extendPO.getIsComplete() != null){
            userExtendPO.setIsComplete(extendPO.getIsComplete());
        }
        if(extendPO.getDeviceId() != null){
            userExtendPO.setDeviceId(extendPO.getDeviceId());
        }
        if(extendPO.getDeviceType() != null){
            userExtendPO.setDeviceType(extendPO.getDeviceType());
        }
        if(extendPO.getWeixin() != null){
            userExtendPO.setWeixin(extendPO.getWeixin());
        }
        if(extendPO.getWorkaddressId() != null){
            userExtendPO.setWorkaddressId(extendPO.getWorkaddressId());
        }
        if(extendPO.getStatus() != null){
            userExtendPO.setStatus(extendPO.getStatus());
        }
        if(extendPO.getAddress() != null){
            userExtendPO.setAddress(extendPO.getAddress());
        }
        return userExtendWriteManage.update(userExtendPO);
    }
}
	