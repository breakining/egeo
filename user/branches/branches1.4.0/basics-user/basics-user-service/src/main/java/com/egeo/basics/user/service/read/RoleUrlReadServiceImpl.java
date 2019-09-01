package com.egeo.basics.user.service.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.user.api.read.RoleUrlReadService;
import com.egeo.basics.user.business.read.RoleUrlReadManage;
import com.egeo.basics.user.business.read.UrlReadManage;
import com.egeo.basics.user.converter.UrlConverter;
import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.basics.user.po.UrlPO;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.web.JsonResult;

@Service("roleUrlReadService")
public class RoleUrlReadServiceImpl extends BaseService implements RoleUrlReadService {
    @Autowired
    private RoleUrlReadManage roleUrlReadManage;

    @Autowired
    private UrlReadManage urlReadManage;

    @Override
    public List<String> getUrlListByUserId(Long userId) {
        
        return roleUrlReadManage.getUrlListByUserId(userId);
    }

    @Override
    public JsonResult<List<UrlDTO>> showUrl(Long roleId,Long platformId) {
        //加载所有的url
        UrlPO po = new UrlPO();
        po.setPlatformId(platformId);
        List<UrlPO> list = urlReadManage.findAll(po);
        List<UrlDTO> dto = UrlConverter.toDTO(list);
        //加载该角色能够访问到的url
        List<UrlPO> urlByRoleId = urlReadManage.getUrlByRoleId(roleId);
        for (UrlDTO urlDTO : dto) {//遍历所有的权限
            for (UrlPO urlPO : urlByRoleId) {//遍历角色的权限
              //如果当前正在遍历的所有的权限中的该项是角色能够访问到的
                if(urlDTO.getId()==urlPO.getId()){
                    urlDTO.setChecked(true);
                }
            }
        }
        
        JsonResult<List<UrlDTO>> jsonResult = new JsonResult<List<UrlDTO>>();
        jsonResult.setData(dto);
        return jsonResult;
    }
}
