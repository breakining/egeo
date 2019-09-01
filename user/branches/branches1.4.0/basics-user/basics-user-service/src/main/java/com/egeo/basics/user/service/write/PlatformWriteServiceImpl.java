package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.write.PlatformWriteService;
import com.egeo.basics.user.business.read.PlatformReadManage;
import com.egeo.basics.user.business.write.PlatformWriteManage;
import com.egeo.basics.user.converter.PlatformConverter;
import com.egeo.basics.user.model.dto.PlatformDTO;
import com.egeo.basics.user.po.PlatformPO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.exception.BusinessException;

@Service("platformWriteService")
public class PlatformWriteServiceImpl extends BaseService implements PlatformWriteService {
	@Autowired
	private PlatformWriteManage platformWriteManage;
	
	@Autowired
        private PlatformReadManage  platformReadManage;

    @Override
    public int upDateWithTx(PlatformDTO dto) {
        PlatformPO po = PlatformConverter.toPO(dto);
        int rows = 0;
            
        rows = platformWriteManage.upDate(po);
            
        return rows;
    }

    @Override
    public Integer deleteByIdWithTx(PlatformDTO dto) {
        
        return platformWriteManage.deleteById(PlatformConverter.toPO(dto));
    }

    @Override
    public String saveWithTx(PlatformDTO dto) {
        PlatformPO po = PlatformConverter.toPO(dto);
        PlatformPO platformPO = platformReadManage.findById(po);
        int rows = 0;
        if(platformPO != null){
            throw new BusinessException(BusinessExceptionConstant.PID_EXIST, "编号已经存在！");
        }
        PlatformPO po2 = new PlatformPO();
        po2.setName(po.getName());
        if(platformReadManage.findAll(po2) != null){
            throw new BusinessException(BusinessExceptionConstant.PNAME_EXIST, "平台名字已经存在");
        }else{
            rows = platformWriteManage.save(po);
        }
        return rows+"";
    }
}
	