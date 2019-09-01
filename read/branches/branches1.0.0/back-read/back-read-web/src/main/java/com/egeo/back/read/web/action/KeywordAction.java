package com.egeo.back.read.web.action;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.read.business.KeywordManage;
import com.egeo.back.read.converter.KeywordConverter;
import com.egeo.back.read.model.vo.KeywordVO;
import com.egeo.basics.read.model.dto.KeywordDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.utils.EmptyUtil;



@Controller
@RequestMapping("read/keyword")
public class KeywordAction extends BaseSpringController {
	
	@Resource(name="keyword")
	private KeywordManage keywordManage;


	// 业务方法：
	@RequestMapping(value = "/findKeywordById")
	@ResponseBody
	public JsonResult<KeywordVO> findKeywordById(Long id ) {
		
		KeywordDTO dto = new KeywordDTO();
		dto.setId(id);
		KeywordDTO rt = keywordManage.findKeywordById(dto);		
		return success(KeywordConverter.toVO(rt));
					 
	}



	// 业务方法：
	@RequestMapping(value = "/findKeywordAll")
	@ResponseBody
	public JsonResult<List<KeywordVO>> findKeywordAll(KeywordVO vo,HttpServletRequest req ) {
		KeywordDTO dto = KeywordConverter.toDTO(vo);
		List<KeywordDTO> rt = keywordManage.findKeywordAll(dto);	
		return success(KeywordConverter.toVO(rt));
					 
	}	

	// 业务方法：
	@RequestMapping(value = "/findKeywordOfPage")
	@ResponseBody
	public JsonResult<PageResult<KeywordVO>> findKeywordOfPage(KeywordVO vo,Pagination page,HttpServletRequest req ) {
		KeywordDTO dto = KeywordConverter.toDTO(vo);
		PageResult<KeywordDTO> rt = keywordManage.findKeywordOfPage(dto, page);
        List<KeywordVO> list = KeywordConverter.toVO(rt.getList());
        PageResult<KeywordVO> result = new PageResult<KeywordVO>();
        result.setList(list);
        result.setPageNo(rt.getPageNo());
        result.setPageSize(rt.getPageSize());
        result.setTotalSize(rt.getTotalSize());
		
		return success(result);
					 
	}


	// 业务方法：返回是插入行的id
	@RequestMapping(value = "/insertKeywordWithTx")
	@ResponseBody
	public JsonResult<Long> insertKeywordWithTx(KeywordVO vo,HttpServletRequest req ) {
		KeywordDTO dto = KeywordConverter.toDTO(vo);
		Long rt = keywordManage.insertKeywordWithTx(dto);	
		return success(rt);					 
	}
	
	// 业务方法：根据id更新数据
	@RequestMapping(value = "/updateKeywordByIdWithTx")
	@ResponseBody
	public JsonResult<Integer> updateKeywordByIdWithTx(KeywordVO vo,HttpServletRequest req ) {
		KeywordDTO dto = KeywordConverter.toDTO(vo);
		int rt = keywordManage.updateKeywordWithTx(dto);	
		return success(rt);					 
	}

	// 业务方法：
	@RequestMapping(value = "/deleteKeywordWithTx")
	@ResponseBody
	public JsonResult<Integer> deleteKeywordWithTx(KeywordVO vo,HttpServletRequest req ) {
		KeywordDTO dto = KeywordConverter.toDTO(vo);
		int rt = keywordManage.deleteKeywordWithTx(dto);	
		return success(rt);					 
	}
		
}
	