package com.egeo.basics.user.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.write.UrlWriteService;
import com.egeo.basics.user.business.read.UrlReadManage;
import com.egeo.basics.user.business.write.UrlWriteManage;
import com.egeo.basics.user.converter.UrlConverter;
import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.basics.user.po.UrlPO;
import com.egeo.core.basics.service.BaseService;

@Service("urlWriteService")
public class UrlWriteServiceImpl extends BaseService implements UrlWriteService {
	@Autowired
	private UrlWriteManage urlWriteManage;
	
	@Autowired
	private UrlReadManage urlReadManage;
	
	@Override
	public int saveOrUpdateWithTx(UrlDTO dto) {
		int poId;
		UrlPO po = UrlConverter.toPO(dto);
		UrlPO findById = urlReadManage.findByName(po.getName());
		if(findById != null){
			if(po.getUrl() != null){
				findById.setUrl(po.getUrl());
			}
			if(po.getName() != null){
                            findById.setName(po.getName());
                        }
			if(po.getDescription() != null){
                            findById.setDescription(po.getDescription());
                        }
			poId = urlWriteManage.Update(findById);
		}else{
		        
			poId = urlWriteManage.save(po);
		}
		
		return poId;
	}

	@Override
	public void deleteWithTx(UrlDTO dto) {
		UrlPO po = UrlConverter.toPO(dto);
		urlWriteManage.delete(po);
	}

}
	