package com.egeo.basics.user.service.write;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.UserPlatformReadService;
import com.egeo.basics.user.api.write.UserPlatformWriteService;
import com.egeo.basics.user.business.write.UserPlatformWriteManage;
import com.egeo.basics.user.converter.UserPlatformConverter;
import com.egeo.basics.user.model.dto.UserPlatformDTO;
import com.egeo.basics.user.po.UserPlatformPO;
import com.egeo.core.basics.service.BaseService;

@Service("userPlatformWriteService")
public class UserPlatformWriteServiceImpl extends BaseService implements UserPlatformWriteService {
    @Autowired
    private UserPlatformWriteManage userPlatformWriteManage;
    
    @Autowired
    private UserPlatformReadService userPlatformReadService;

    @Override
    public String saveWithTx(UserPlatformDTO dto) {
        // TODO Auto-generated method stub
        return userPlatformWriteManage.save(UserPlatformConverter.toPO(dto));
    }

    @Override
    public String updateWithTx(UserPlatformDTO dto) {
        UserPlatformDTO userPlatformDTO = userPlatformReadService.findById(dto);
        if(userPlatformDTO != null){
            if(dto.getUserId() != null){
                userPlatformDTO.setUserId(dto.getUserId());
            }
            if(dto.getPlatformId() != null){
                userPlatformDTO.setPlatformId(dto.getPlatformId());
            }
            if(dto.getPlatformId() != null){
                userPlatformDTO.setPlatformId(dto.getPlatformId());
            }
            if(dto.getIsAvailable() != null){
                userPlatformDTO.setIsAvailable(dto.getIsAvailable());
            }
        }
        return userPlatformWriteManage.update(UserPlatformConverter.toPO(userPlatformDTO));
    }

    @Override
    public String deleteByUserIdAndPidWithTx(UserPlatformDTO dto) {
        return userPlatformWriteManage.deleteByUserIdAndPid(UserPlatformConverter.toPO(dto));
    }

    @Override
    public int delUserPlatformWithTx(UserPlatformDTO platformDTO) {
        UserPlatformPO po = UserPlatformConverter.toPO(platformDTO);
        return userPlatformWriteManage.delUserPlatform(po);
    }

    @Override
    public int setUserPlatformWithTx(List<String> setUserPlatform, Long id) {
        try {
            for (String string : setUserPlatform) {
                UserPlatformDTO userPlatformDTO = new UserPlatformDTO();
                userPlatformDTO.setIsAvailable(1);
                userPlatformDTO.setPlatformId(Long.valueOf(string));
                userPlatformDTO.setUserId(id);
                userPlatformWriteManage.save(UserPlatformConverter.toPO(userPlatformDTO));
            }
            return 1;
        } catch (NumberFormatException e) {
            logger.error("添加关系异常！ Userid = " + id, e);
        }
        return 0;
    }

    @Override
    public String updateAllWithTx(UserPlatformDTO dto) {
        try {
            UserPlatformDTO UserPlatformDTO = new UserPlatformDTO();
            UserPlatformDTO.setUserId(dto.getUserId());
            List<UserPlatformDTO> list = userPlatformReadService.findAll(UserPlatformDTO);
            List<UserPlatformPO> po = UserPlatformConverter.toPO(list);
            for (UserPlatformPO userPlatformPO : po) {
                userPlatformPO.setIsAvailable(dto.getIsAvailable());
                userPlatformWriteManage.update(userPlatformPO);
            }
            return "更新成功";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            logger.error("更新关系异常！ Userid = " + dto.getUserId(), e);
        }
        return null;
    }

}
