package com.egeo.back.user.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.read.PlatformReadService;
import com.egeo.basics.user.api.write.PlatformWriteService;
import com.egeo.basics.user.model.dto.PlatformDTO;

@Component
public class PlatformFacade {

    @Reference
    private PlatformReadService platformReadService;
    @Reference
    private PlatformWriteService platformWriteService;

    public List<PlatformDTO> findAll(PlatformDTO dto) {
        // TODO Auto-generated method stub
        return platformReadService.findAll(dto);
    }

    public int upDate(PlatformDTO dto) {
        // TODO Auto-generated method stub
        return platformWriteService.upDateWithTx(dto);
    }

    public List<PlatformDTO> PlatformByUserId(String useId) {
        // TODO Auto-generated method stub
        return platformReadService.PlatformByUserId(useId);
    }

}
