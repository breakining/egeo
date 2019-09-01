package com.egeo.back.read.web.action;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.egeo.back.read.business.ReadInformationManage;
import com.egeo.back.read.converter.ReadInformationConverter;
import com.egeo.back.read.model.vo.ReadInformationVO;
import com.egeo.basics.read.model.dto.ReadInformationDTO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.common.PageResult;
import com.egeo.core.entity.CacheUser;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.utils.EmptyUtil;



@Controller
@RequestMapping("read/readInformation")
public class ReadInformationAction extends BaseSpringController {
	
	@Resource(name="readInformation")
	private ReadInformationManage readInformationManage;


	// 业务方法：
	@RequestMapping(value = "/findReadInformationById")
	@ResponseBody
	public JsonResult<ReadInformationVO> findReadInformationById(Long id ) {
		
		ReadInformationDTO dto = new ReadInformationDTO();
		dto.setId(id);
		ReadInformationDTO rt = readInformationManage.findReadInformationById(dto);		
		return success(ReadInformationConverter.toVO(rt));
					 
	}



	// 业务方法：
	@RequestMapping(value = "/findReadInformationAll")
	@ResponseBody
	public JsonResult<List<ReadInformationVO>> findReadInformationAll(ReadInformationVO vo,HttpServletRequest req ) {
		ReadInformationDTO dto = ReadInformationConverter.toDTO(vo);
		List<ReadInformationDTO> rt = readInformationManage.findReadInformationAll(dto);	
		return success(ReadInformationConverter.toVO(rt));
					 
	}	

	// 业务方法：
	@RequestMapping(value = "/findReadInformationOfPage")
	@ResponseBody
	public JsonResult<PageResult<ReadInformationVO>> findReadInformationOfPage(ReadInformationVO vo,Pagination page,HttpServletRequest req ) {
		ReadInformationDTO dto = ReadInformationConverter.toDTO(vo);
		PageResult<ReadInformationDTO> rt = readInformationManage.findReadInformationOfPage(dto, page);
        List<ReadInformationVO> list = ReadInformationConverter.toVO(rt.getList());
        PageResult<ReadInformationVO> result = new PageResult<ReadInformationVO>();
        result.setList(list);
        result.setPageNo(rt.getPageNo());
        result.setPageSize(rt.getPageSize());
        result.setTotalSize(rt.getTotalSize());
		
		return success(result);
					 
	}


	// 业务方法：返回是插入行的id
	@RequestMapping(value = "/insertReadInformationWithTx")
	@ResponseBody
	public JsonResult<Long> insertReadInformationWithTx(ReadInformationVO vo,HttpServletRequest req ) {
		ReadInformationDTO dto = ReadInformationConverter.toDTO(vo);
		Long rt = readInformationManage.insertReadInformationWithTx(dto);	
		return success(rt);					 
	}
	
	// 业务方法：根据id更新数据
	@RequestMapping(value = "/updateReadInformationByIdWithTx")
	@ResponseBody
	public JsonResult<Integer> updateReadInformationByIdWithTx(ReadInformationVO vo,HttpServletRequest req ) {
		ReadInformationDTO dto = ReadInformationConverter.toDTO(vo);
		int rt = readInformationManage.updateReadInformationWithTx(dto);	
		return success(rt);					 
	}

	// 业务方法：
	@RequestMapping(value = "/deleteReadInformationWithTx")
	@ResponseBody
	public JsonResult<Integer> deleteReadInformationWithTx(ReadInformationVO vo,HttpServletRequest req ) {
		ReadInformationDTO dto = ReadInformationConverter.toDTO(vo);
		int rt = readInformationManage.deleteReadInformationWithTx(dto);	
		return success(rt);					 
	}
	
	/**
	 * 根据userId查询悦读未读消息数量
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/cntById")
	@ResponseBody
	public ModelAndView cntById(Long userId) {
		ModelAndView view = new ModelAndView();
		view.addObject("userId",userId);
		view.setViewName("chat.jsp");
		return view;
	}
	
	/**
	 * 根据userId查询所有悦读消息
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/readInformationByUserId")
	@ResponseBody
	public JsonResult<PageResult<ReadInformationVO>> readInformationById(ReadInformationVO vo,Pagination page,HttpServletRequest req) {
		CacheUser userCache = (CacheUser) req.getAttribute("ut");
		if(EmptyUtil.isEmpty(userCache)){
			throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
		}
		if(EmptyUtil.isEmpty(userCache.getId())){
			throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
		}
		vo.setUserId(userCache.getId());
		ReadInformationDTO dto = ReadInformationConverter.toDTO(vo);
		PageResult<ReadInformationDTO> rt = readInformationManage.readInformationByUserId(dto, page);
        List<ReadInformationVO> list = ReadInformationConverter.toVO(rt.getList());
        PageResult<ReadInformationVO> result = new PageResult<ReadInformationVO>();
        result.setList(list);
        result.setPageNo(rt.getPageNo());
        result.setPageSize(rt.getPageSize());
        result.setTotalSize(rt.getTotalSize());
		
		return success(result);
	}	
	
	/**
	 * 根据悦读主题id查询悦读信息、根据悦读消息id将其变成已读
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/clickReadInformation")
	@ResponseBody
	public JsonResult<Map<String, Object>> clickReadInformation(ReadInformationVO vo,HttpServletRequest req) {
		CacheUser userCache = (CacheUser) req.getAttribute("ut");
		if(EmptyUtil.isEmpty(userCache)){
			throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
		}
		if(EmptyUtil.isEmpty(userCache.getId())){
			throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
		}
		vo.setUserId(userCache.getId());
		ReadInformationDTO dto = ReadInformationConverter.toDTO(vo);
		Map<String, Object> map = readInformationManage.clickReadInformation(vo);
		
		return success(map);
	}	
}
	