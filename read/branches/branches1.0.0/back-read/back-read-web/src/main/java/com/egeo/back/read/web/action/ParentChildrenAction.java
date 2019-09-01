package com.egeo.back.read.web.action;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.read.business.ParentChildrenManage;
import com.egeo.back.read.converter.ParentChildrenConverter;
import com.egeo.back.read.model.vo.ParentChildrenVO;
import com.egeo.basics.read.model.dto.ParentChildrenDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;



@Controller
@RequestMapping("read/parentChildren")
public class ParentChildrenAction extends BaseSpringController {
	
	@Resource(name="parentChildren")
	private ParentChildrenManage parentChildrenManage;


	// 业务方法：
	@RequestMapping(value = "/findParentChildrenById")
	@ResponseBody
	public JsonResult<ParentChildrenVO> findParentChildrenById(Long id ) {
		
		ParentChildrenDTO dto = new ParentChildrenDTO();
		dto.setId(id);
		ParentChildrenDTO rt = parentChildrenManage.findParentChildrenById(dto);		
		return success(ParentChildrenConverter.toVO(rt));
					 
	}



	// 业务方法：
	@RequestMapping(value = "/findParentChildrenAll")
	@ResponseBody
	public JsonResult<List<ParentChildrenVO>> findParentChildrenAll(ParentChildrenVO vo,HttpServletRequest req ) {
		ParentChildrenDTO dto = ParentChildrenConverter.toDTO(vo);
		List<ParentChildrenDTO> rt = parentChildrenManage.findParentChildrenAll(dto);	
		return success(ParentChildrenConverter.toVO(rt));
					 
	}	

	// 业务方法：
	@RequestMapping(value = "/findParentChildrenOfPage")
	@ResponseBody
	public JsonResult<PageResult<ParentChildrenVO>> findParentChildrenOfPage(ParentChildrenVO vo,Pagination page,HttpServletRequest req ) {
		ParentChildrenDTO dto = ParentChildrenConverter.toDTO(vo);
		PageResult<ParentChildrenDTO> rt = parentChildrenManage.findParentChildrenOfPage(dto, page);
        List<ParentChildrenVO> list = ParentChildrenConverter.toVO(rt.getList());
        PageResult<ParentChildrenVO> result = new PageResult<ParentChildrenVO>();
        result.setList(list);
        result.setPageNo(rt.getPageNo());
        result.setPageSize(rt.getPageSize());
        result.setTotalSize(rt.getTotalSize());
		
		return success(result);
					 
	}


	// 业务方法：返回是插入行的id
	@RequestMapping(value = "/insertParentChildrenWithTx")
	@ResponseBody
	public JsonResult<Long> insertParentChildrenWithTx(ParentChildrenVO vo,HttpServletRequest req ) {
		ParentChildrenDTO dto = ParentChildrenConverter.toDTO(vo);
		Long rt = parentChildrenManage.insertParentChildrenWithTx(dto);	
		return success(rt);					 
	}
	
	// 业务方法：根据id更新数据
	@RequestMapping(value = "/updateParentChildrenByIdWithTx")
	@ResponseBody
	public JsonResult<Integer> updateParentChildrenByIdWithTx(ParentChildrenVO vo,HttpServletRequest req ) {
		ParentChildrenDTO dto = ParentChildrenConverter.toDTO(vo);
		int rt = parentChildrenManage.updateParentChildrenWithTx(dto);	
		return success(rt);					 
	}

	// 业务方法：
	@RequestMapping(value = "/deleteParentChildrenWithTx")
	@ResponseBody
	public JsonResult<Integer> deleteParentChildrenWithTx(ParentChildrenVO vo,HttpServletRequest req ) {
		ParentChildrenDTO dto = ParentChildrenConverter.toDTO(vo);
		int rt = parentChildrenManage.deleteParentChildrenWithTx(dto);	
		return success(rt);					 
	}
		
}
	