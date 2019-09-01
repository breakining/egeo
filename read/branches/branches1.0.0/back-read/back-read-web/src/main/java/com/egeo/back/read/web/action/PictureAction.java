package com.egeo.back.read.web.action;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.read.business.PictureManage;
import com.egeo.back.read.converter.PictureConverter;
import com.egeo.back.read.model.vo.PictureVO;
import com.egeo.basics.read.model.dto.PictureDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.utils.EmptyUtil;



@Controller
@RequestMapping("read/picture")
public class PictureAction extends BaseSpringController {
	
	@Resource(name="picture")
	private PictureManage pictureManage;


	// 业务方法：
	@RequestMapping(value = "/findPictureById")
	@ResponseBody
	public JsonResult<PictureVO> findPictureById(Long id ) {
		
		PictureDTO dto = new PictureDTO();
		dto.setId(id);
		PictureDTO rt = pictureManage.findPictureById(dto);		
		return success(PictureConverter.toVO(rt));
					 
	}



	// 业务方法：
	@RequestMapping(value = "/findPictureAll")
	@ResponseBody
	public JsonResult<List<PictureVO>> findPictureAll(PictureVO vo,HttpServletRequest req ) {
		PictureDTO dto = PictureConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		List<PictureDTO> rt = pictureManage.findPictureAll(dto);	
		return success(PictureConverter.toVO(rt));
					 
	}	

	// 业务方法：
	@RequestMapping(value = "/findPictureOfPage")
	@ResponseBody
	public JsonResult<PageResult<PictureVO>> findPictureOfPage(PictureVO vo,Pagination page,HttpServletRequest req ) {
		PictureDTO dto = PictureConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		PageResult<PictureDTO> rt = pictureManage.findPictureOfPage(dto, page);
        List<PictureVO> list = PictureConverter.toVO(rt.getList());
        PageResult<PictureVO> result = new PageResult<PictureVO>();
        result.setList(list);
        result.setPageNo(rt.getPageNo());
        result.setPageSize(rt.getPageSize());
        result.setTotalSize(rt.getTotalSize());
		
		return success(result);
					 
	}


	// 业务方法：返回是插入行的id
	@RequestMapping(value = "/insertPictureWithTx")
	@ResponseBody
	public JsonResult<Long> insertPictureWithTx(PictureVO vo,HttpServletRequest req ) {
		PictureDTO dto = PictureConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		Long rt = pictureManage.insertPictureWithTx(dto);	
		return success(rt);					 
	}
	
	// 业务方法：根据id更新数据
	@RequestMapping(value = "/updatePictureByIdWithTx")
	@ResponseBody
	public JsonResult<Integer> updatePictureByIdWithTx(PictureVO vo,HttpServletRequest req ) {
		PictureDTO dto = PictureConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		int rt = pictureManage.updatePictureWithTx(dto);	
		return success(rt);					 
	}

	// 业务方法：
	@RequestMapping(value = "/deletePictureWithTx")
	@ResponseBody
	public JsonResult<Integer> deletePictureWithTx(PictureVO vo,HttpServletRequest req ) {
		PictureDTO dto = PictureConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		int rt = pictureManage.deletePictureWithTx(dto);	
		return success(rt);					 
	}
		
}
	