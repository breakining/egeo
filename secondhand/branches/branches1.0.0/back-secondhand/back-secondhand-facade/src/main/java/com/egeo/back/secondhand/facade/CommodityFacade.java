package com.egeo.back.secondhand.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.secondhand.api.read.CommodityReadService;
import com.egeo.basics.secondhand.api.write.CommodityWriteService;
import com.egeo.basics.secondhand.model.dto.CommodityDTO;
import com.egeo.basics.user.api.read.UserReadService;
import com.egeo.basics.user.model.dto.UserWelfareApp;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Component
public class CommodityFacade {
	
	@Reference
	private CommodityReadService commodityReadService;
	
	@Reference
	private CommodityWriteService commodityWriteService;
	
	@Reference
	private static UserReadService userReadService;
	
	
	public CommodityDTO findCommodityById(CommodityDTO dto){
		
		return commodityReadService.findCommodityById(dto);
	}

	public PageResult<CommodityDTO> findCommodityOfPage(CommodityDTO dto,Pagination page){
		
		return commodityReadService.findCommodityOfPage(dto, page);
		
	}

	public List<CommodityDTO> findCommodityAll(CommodityDTO dto){
		
		return commodityReadService.findCommodityAll(dto);
		
	}

	public Long insertCommodityWithTx(CommodityDTO dto){
		
		return commodityWriteService.insertCommodityWithTx(dto);
	}

	public int updateCommodityWithTx(CommodityDTO dto){
		
		return commodityWriteService.updateCommodityWithTx(dto);
	}

	public int deleteCommodityWithTx(CommodityDTO dto){
		
		return commodityWriteService.deleteCommodityWithTx(dto);
		
	}
	/**
	 * 根据用户id查询用户信息
	 * @param userId
	 * @return
	 */
	public UserWelfareApp userWelfareAppById(Long userId) {
		// TODO Auto-generated method stub
		return userReadService.userWelfareAppById(userId);
	}
	/**
	 * 分页查询所有二手商品
	 * @param page
	 * @return
	 */
	public PageResult<CommodityDTO> commodityOfPageApp(CommodityDTO dto,Pagination page) {
		// TODO Auto-generated method stub
		return commodityReadService.commodityOfPageApp(dto,page);
	}

}
	