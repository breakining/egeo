package com.egeo.back.read.web.action;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.read.business.TopicManage;
import com.egeo.back.read.converter.TopicConverter;
import com.egeo.back.read.model.vo.TopicVO;
import com.egeo.basics.read.model.dto.TopicDTO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.common.PageResult;
import com.egeo.core.entity.CacheUser;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.utils.EmptyUtil;



/**
 * 阅评
 * @author ghw
 *
 */
@Controller
@RequestMapping("read/topic")
public class TopicAction extends BaseSpringController {
	
	@Resource(name="topic")
	private TopicManage topicManage;


	// 业务方法：
	@RequestMapping(value = "/findTopicById")
	@ResponseBody
	public JsonResult<TopicVO> findTopicById(Long id ) {
		
		TopicDTO dto = new TopicDTO();
		dto.setId(id);
		TopicDTO rt = topicManage.findTopicById(dto);		
		return success(TopicConverter.toVO(rt));
					 
	}



	// 业务方法：
	@RequestMapping(value = "/findTopicAll")
	@ResponseBody
	public JsonResult<List<TopicVO>> findTopicAll(TopicVO vo,HttpServletRequest req ) {
		TopicDTO dto = TopicConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		List<TopicDTO> rt = topicManage.findTopicAll(dto);	
		return success(TopicConverter.toVO(rt));
					 
	}	

	// 业务方法：
	@RequestMapping(value = "/findTopicOfPage")
	@ResponseBody
	public JsonResult<PageResult<TopicVO>> findTopicOfPage(TopicVO vo,Pagination page,HttpServletRequest req ) {
		TopicDTO dto = TopicConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		PageResult<TopicDTO> rt = topicManage.findTopicOfPage(dto, page);
        List<TopicVO> list = TopicConverter.toVO(rt.getList());
        PageResult<TopicVO> result = new PageResult<TopicVO>();
        result.setList(list);
        result.setPageNo(rt.getPageNo());
        result.setPageSize(rt.getPageSize());
        result.setTotalSize(rt.getTotalSize());
		
		return success(result);
					 
	}


	// 业务方法：返回是插入行的id
	/**
	 * 保存悦评动态
	 * @param vo
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/insertTopicWithTx")
	@ResponseBody
	public JsonResult<Long> insertTopicWithTx(TopicVO vo,HttpServletRequest req ) {
		TopicDTO dto = TopicConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		Long rt = topicManage.insertTopicWithTx(dto);	
		return success(rt);					 
	}
	
	// 业务方法：根据id更新数据
	/**
	 * 根据ID更新悦评动态
	 * @param vo
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/updateTopicByIdWithTx")
	@ResponseBody
	public JsonResult<Integer> updateTopicByIdWithTx(TopicVO vo,HttpServletRequest req ) {
		TopicDTO dto = TopicConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		int rt = topicManage.updateTopicWithTx(dto);	
		return success(rt);					 
	}

	// 业务方法：
	/**
	 * 根据ID删除悦评动态
	 * @param vo
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/deleteTopicById")
	@ResponseBody
	public JsonResult<Integer> deleteTopicWithTx(TopicVO vo,HttpServletRequest req ) {
		TopicDTO dto = TopicConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		int rt = topicManage.deleteTopicWithTx(dto);	
		return success(rt);					 
	}
	
	
		/**
		 * 福管+app分页查询阅评
		 * @param vo
		 * @param page
		 * @param req
		 * @return
		 */
		@RequestMapping(value = "/topicOfPageApp")
		@ResponseBody
		public JsonResult<PageResult<TopicVO>> topicOfPageApp(TopicVO vo,Pagination page,HttpServletRequest req ) {
			logger.info("福管+app分页查询阅评");
			TopicDTO dto = TopicConverter.toDTO(vo);
			String str = req.getHeader("platformId");		
			if(EmptyUtil.isNotEmpty(str)){
				Long platformId = Long.valueOf(str);
				dto.setPlatformId(platformId);
			}
			PageResult<TopicDTO> rt = topicManage.topicOfPageApp(dto, page);
	        List<TopicVO> list = TopicConverter.toVO(rt.getList());
	        PageResult<TopicVO> result = new PageResult<TopicVO>();
	        result.setList(list);
	        result.setPageNo(rt.getPageNo());
	        result.setPageSize(rt.getPageSize());
	        result.setTotalSize(rt.getTotalSize());
			
			return success(result);
						 
		}
		
		/**
		 * 福管+app根据id查询悦评信息
		 * @param vo
		 * @param page
		 * @param req
		 * @return
		 */
		@RequestMapping(value = "/topicByIdApp")
		@ResponseBody
		public JsonResult<Map<String, Object>> topicOfPageApp(TopicVO vo,HttpServletRequest req ) {
			logger.info("福管+app根据id查询悦评信息");
			TopicDTO dto = TopicConverter.toDTO(vo);
			String str = req.getHeader("platformId");		
			if(EmptyUtil.isNotEmpty(str)){
				Long platformId = Long.valueOf(str);
				dto.setPlatformId(platformId);
			}
			CacheUser userCache = (CacheUser) req.getAttribute("ut");
			if(EmptyUtil.isEmpty(userCache)){
				throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
			}
			if(EmptyUtil.isEmpty(userCache.getId())){
				throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
			}
			dto.setUserId(userCache.getId());
			Map<String, Object> map = topicManage.topicByIdApp(dto);
			JsonResult<Map<String, Object>> result = new JsonResult<Map<String, Object>>();
	        result.setData(map);
			return result;
						 
		}
		
		/**
		 * 福管+app根据用户id分页查询悦评(查看自己的悦评)
		 * @param vo
		 * @param page
		 * @param req
		 * @return
		 */
		@RequestMapping(value = "/topicOfPageByUserIdApp")
		@ResponseBody
		public JsonResult<PageResult<TopicVO>> topicOfPageByUserIdApp(TopicVO vo,Pagination page,HttpServletRequest req ) {
			logger.info("福管+app根据用户id分页查询悦评");
			TopicDTO dto = TopicConverter.toDTO(vo);
			String str = req.getHeader("platformId");		
			if(EmptyUtil.isNotEmpty(str)){
				Long platformId = Long.valueOf(str);
				dto.setPlatformId(platformId);
			}
			CacheUser userCache = (CacheUser) req.getAttribute("ut");

			if(EmptyUtil.isEmpty(userCache)){
				throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
			}
			if(EmptyUtil.isEmpty(userCache.getId())){
				throw new BusinessException(BusinessExceptionConstant.USER_NOT_LOGIN, "未登录或已过期，请登录！");
			}
			dto.setUserId(userCache.getId());
			dto.setUserName(userCache.getName());
			PageResult<TopicDTO> rt = topicManage.topicOfPageApp(dto, page);
	        List<TopicVO> list = TopicConverter.toVO(rt.getList());
	        PageResult<TopicVO> result = new PageResult<TopicVO>();
	        result.setList(list);
	        result.setPageNo(rt.getPageNo());
	        result.setPageSize(rt.getPageSize());
	        result.setTotalSize(rt.getTotalSize());
			
			return success(result);
		}
		
}
	