package com.egeo.basics.secondhand.service.read;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.secondhand.api.read.CommodityReadService;
import com.egeo.basics.secondhand.business.read.CommodityReadManage;
import com.egeo.basics.secondhand.condition.CommodityCondition;
import com.egeo.basics.secondhand.converter.CommodityConverter;
import com.egeo.basics.secondhand.model.dto.CommodityDTO;
import com.egeo.basics.secondhand.po.CommodityPO;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("commodityReadService")
public class CommodityReadServiceImpl extends BaseService implements CommodityReadService {
	@Autowired
	private CommodityReadManage commodityReadManage;

	@Override
	public CommodityDTO findCommodityById(CommodityDTO dto) {
		CommodityPO po = CommodityConverter.toPO(dto);
		CommodityPO list = commodityReadManage.findCommodityById(po);		
		return CommodityConverter.toDTO(list);
	}

	@Override
	public PageResult<CommodityDTO> findCommodityOfPage(CommodityDTO dto, Pagination page) {
		CommodityPO po = CommodityConverter.toPO(dto);
        PageResult<CommodityPO> pageResult = commodityReadManage.findCommodityOfPage(po, page);
        
        List<CommodityDTO> list = CommodityConverter.toDTO(pageResult.getList());
        PageResult<CommodityDTO> result = new PageResult<CommodityDTO>();
        result.setList(list);
        result.setPageNo(pageResult.getPageNo());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalSize(pageResult.getTotalSize());
        return result;
	}

	@Override
	public List<CommodityDTO> findCommodityAll(CommodityDTO dto) {
		CommodityPO po = CommodityConverter.toPO(dto);
		List<CommodityPO> list = commodityReadManage.findCommodityAll(po);		
		return CommodityConverter.toDTO(list);
	}
	/**
	 * 分页查询所有二手商品
	 * @param page
	 * @return
	 */
	@Override
	public PageResult<CommodityDTO> commodityOfPageApp(CommodityDTO dto,Pagination page) {
		PageResult<CommodityDTO> result = new PageResult<CommodityDTO>();
		List<CommodityDTO> list = new ArrayList<CommodityDTO>();
		PageResult<CommodityCondition> pageResult = commodityReadManage.commodityOfPageApp(CommodityConverter.toPO(dto),page);
		List<CommodityCondition> CommodityConditionList = pageResult.getList();
        for (CommodityCondition commodityCondition : CommodityConditionList) {
        	CommodityDTO commodityDTO = CommodityConverter.toDTO(commodityCondition);
        	commodityDTO.setPictureUrl(commodityCondition.getPictureUrl());
        	list.add(commodityDTO);
		}
        result.setList(list);
        result.setPageNo(pageResult.getPageNo());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalSize(pageResult.getTotalSize());
		return result;
	}
}
	