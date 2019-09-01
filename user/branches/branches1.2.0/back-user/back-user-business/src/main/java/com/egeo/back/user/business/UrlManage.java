package com.egeo.back.user.business;

import java.util.List;

import com.egeo.back.user.model.vo.UrlVO;
import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface UrlManage {

    public List<String> getUrlList();

    public int saveOrUpdate(UrlVO vo);

    public void deleteWithTx(UrlDTO dto);

    public List<UrlDTO> getUrlByRoleId(Long roleId);

    public PageResult<UrlDTO> findAll(Pagination page,UrlDTO urlDTO);

}
