package com.egeo.basics.user.service.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.PlatformRoleReadService;
import com.egeo.basics.user.business.read.PlatformRoleReadManage;
import com.egeo.basics.user.converter.PlatformRoleConverter;
import com.egeo.basics.user.model.dto.PlatformRoleDTO;
import com.egeo.basics.user.po.PlatformRolePO;
import com.egeo.core.basics.service.BaseService;

@Service("platformRoleReadService")
public class PlatformRoleReadServiceImpl extends BaseService implements PlatformRoleReadService {
	@Autowired
	private PlatformRoleReadManage platformRoleReadManage;
		
	@Override
	public List<PlatformRoleDTO> findAll(PlatformRoleDTO platformRoleDTO) {
		
		PlatformRolePO po = PlatformRoleConverter.toPO(platformRoleDTO);
		List<PlatformRolePO> poList = platformRoleReadManage.findAll(po);
		
		if(poList != null && poList.size() > 0){
			return  PlatformRoleConverter.toDTO(poList);
		}
		
		return null;
	}
	
}
	