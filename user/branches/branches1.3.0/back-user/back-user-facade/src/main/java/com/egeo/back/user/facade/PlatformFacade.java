package com.egeo.back.user.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.read.PlatformReadService;
import com.egeo.basics.user.api.write.PlatformWriteService;
import com.egeo.basics.user.model.dto.PlatformDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Component
public class PlatformFacade {

    @Reference
    private PlatformReadService platformReadService;
    @Reference
    private PlatformWriteService platformWriteService;

    public PageResult<PlatformDTO> findAll(PlatformDTO dto,Pagination page) {
        // TODO Auto-generated method stub
        return platformReadService.findAll(dto,page);
    }

    public int upDate(PlatformDTO dto) {
        // TODO Auto-generated method stub
        return platformWriteService.upDateWithTx(dto);
    }

    public List<PlatformDTO> PlatformByUserId(Long userId) {
        // TODO Auto-generated method stub
        return platformReadService.PlatformByUserId(userId);
    }

    public List<PlatformDTO> PlatformByUId(Long userId) {
        // TODO Auto-generated method stub
        return platformReadService.PlatformByUid(userId);
    }

    public Integer deleteById(PlatformDTO dto) {
        // TODO Auto-generated method stub
        return platformWriteService.deleteByIdWithTx(dto);
    }

    public String save(PlatformDTO dto) {
        // TODO Auto-generated method stub
        return platformWriteService.saveWithTx(dto);
    }

}
