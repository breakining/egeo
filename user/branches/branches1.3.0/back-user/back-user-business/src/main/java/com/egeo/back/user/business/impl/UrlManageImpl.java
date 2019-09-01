package com.egeo.back.user.business.impl;
	

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.user.business.UrlManage;
import com.egeo.back.user.converter.UrlConverter;
import com.egeo.back.user.facade.UrlFacade;
import com.egeo.back.user.model.vo.UrlVO;
import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("url")
public class UrlManageImpl implements UrlManage{

	
	@Resource(name="urlFacade")
	private UrlFacade urlFacade;
	
	
	@Override
	public List<String> getUrlList() {

		return urlFacade.findAll();
	}


	@Override
	public int saveOrUpdate(UrlVO vo) {
		return urlFacade.saveOrUpdate(UrlConverter.toDTO(vo));
	}


	@Override
	public void deleteWithTx(UrlDTO dto) {
		urlFacade.deleteWithTx(dto);
	}


    @Override
    public List<UrlDTO> getUrlByRoleId(Long roleId) {
        // TODO Auto-generated method stub
        return urlFacade.getUrlByRoleId(roleId);
    }


    @Override
    public PageResult<UrlDTO> findAll(Pagination page,UrlDTO urlDTO) {
        // TODO Auto-generated method stub
        return urlFacade.findAll(page,urlDTO);
    }





	


}
	