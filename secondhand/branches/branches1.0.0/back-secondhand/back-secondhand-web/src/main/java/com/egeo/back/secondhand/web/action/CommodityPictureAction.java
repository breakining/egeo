package com.egeo.back.secondhand.web.action;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.secondhand.business.CommodityPictureManage;
import com.egeo.back.secondhand.converter.CommodityPictureConverter;
import com.egeo.back.secondhand.model.vo.CommodityPictureVO;
import com.egeo.basics.secondhand.model.dto.CommodityPictureDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.utils.EmptyUtil;



@Controller
@RequestMapping("secondhand/commodityPicture")
public class CommodityPictureAction extends BaseSpringController {
	
	@Resource(name="commodityPicture")
	private CommodityPictureManage commodityPictureManage;


	// 业务方法：
	@RequestMapping(value = "/findCommodityPictureById")
	@ResponseBody
	public JsonResult<CommodityPictureVO> findCommodityPictureById(Long id ) {
		
		CommodityPictureDTO dto = new CommodityPictureDTO();
		dto.setId(id);
		CommodityPictureDTO rt = commodityPictureManage.findCommodityPictureById(dto);		
		return success(CommodityPictureConverter.toVO(rt));
					 
	}



	// 业务方法：
	@RequestMapping(value = "/findCommodityPictureAll")
	@ResponseBody
	public JsonResult<List<CommodityPictureVO>> findCommodityPictureAll(CommodityPictureVO vo,HttpServletRequest req ) {
		CommodityPictureDTO dto = CommodityPictureConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		List<CommodityPictureDTO> rt = commodityPictureManage.findCommodityPictureAll(dto);	
		return success(CommodityPictureConverter.toVO(rt));
					 
	}	

	// 业务方法：
	@RequestMapping(value = "/findCommodityPictureOfPage")
	@ResponseBody
	public JsonResult<PageResult<CommodityPictureVO>> findCommodityPictureOfPage(CommodityPictureVO vo,Pagination page,HttpServletRequest req ) {
		CommodityPictureDTO dto = CommodityPictureConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		PageResult<CommodityPictureDTO> rt = commodityPictureManage.findCommodityPictureOfPage(dto, page);
        List<CommodityPictureVO> list = CommodityPictureConverter.toVO(rt.getList());
        PageResult<CommodityPictureVO> result = new PageResult<CommodityPictureVO>();
        result.setList(list);
        result.setPageNo(rt.getPageNo());
        result.setPageSize(rt.getPageSize());
        result.setTotalSize(rt.getTotalSize());
		
		return success(result);
					 
	}


	// 业务方法：返回是插入行的id
	@RequestMapping(value = "/insertCommodityPictureWithTx")
	@ResponseBody
	public JsonResult<Long> insertCommodityPictureWithTx(CommodityPictureVO vo,HttpServletRequest req ) {
		CommodityPictureDTO dto = CommodityPictureConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		Long rt = commodityPictureManage.insertCommodityPictureWithTx(dto);	
		return success(rt);					 
	}
	
	// 业务方法：根据id更新数据
	@RequestMapping(value = "/updateCommodityPictureByIdWithTx")
	@ResponseBody
	public JsonResult<Integer> updateCommodityPictureByIdWithTx(CommodityPictureVO vo,HttpServletRequest req ) {
		CommodityPictureDTO dto = CommodityPictureConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		int rt = commodityPictureManage.updateCommodityPictureWithTx(dto);	
		return success(rt);					 
	}

	// 业务方法：
	@RequestMapping(value = "/deleteCommodityPictureWithTx")
	@ResponseBody
	public JsonResult<Integer> deleteCommodityPictureWithTx(CommodityPictureVO vo,HttpServletRequest req ) {
		CommodityPictureDTO dto = CommodityPictureConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		int rt = commodityPictureManage.deleteCommodityPictureWithTx(dto);	
		return success(rt);					 
	}
		
}
	