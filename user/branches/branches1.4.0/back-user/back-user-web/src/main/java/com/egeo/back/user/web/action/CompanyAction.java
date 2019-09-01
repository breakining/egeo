package com.egeo.back.user.web.action;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.CompanyManage;
import com.egeo.back.user.converter.CompanyConverter;
import com.egeo.back.user.model.vo.CompanyVO;
import com.egeo.basics.user.model.dto.CompanyDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.utils.EmptyUtil;



@Controller
@RequestMapping("user/company")
public class CompanyAction extends BaseSpringController {
	
	@Resource(name="company")
	private CompanyManage companyManage;


	// 业务方法：
	@RequestMapping(value = "/findCompanyById")
	@ResponseBody
	public JsonResult<CompanyVO> findCompanyById(Long companyId ) {
		
		CompanyDTO dto = new CompanyDTO();
		dto.setId(companyId);
		CompanyDTO rt = companyManage.findCompanyById(dto);		
		return success(CompanyConverter.toVO(rt));
					 
	}



	// 业务方法：
	@RequestMapping(value = "/findCompanyAll")
	@ResponseBody
	public JsonResult<List<CompanyVO>> findCompanyAll(CompanyVO vo,HttpServletRequest req ) {
		CompanyDTO dto = CompanyConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		List<CompanyDTO> rt = companyManage.findCompanyAll(dto);	
		return success(CompanyConverter.toVO(rt));
					 
	}	

	// 业务方法：
	@RequestMapping(value = "/findCompanyOfPage")
	@ResponseBody
	public JsonResult<PageResult<CompanyVO>> findCompanyOfPage(CompanyVO vo,Pagination page,HttpServletRequest req ) {
		CompanyDTO dto = CompanyConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		PageResult<CompanyDTO> rt = companyManage.findCompanyOfPage(dto, page);
        List<CompanyVO> list = CompanyConverter.toVO(rt.getList());
        PageResult<CompanyVO> result = new PageResult<CompanyVO>();
        result.setList(list);
        result.setPageNo(rt.getPageNo());
        result.setPageSize(rt.getPageSize());
        result.setTotalSize(rt.getTotalSize());
		
		return success(result);
					 
	}


	// 业务方法：返回是插入行的id
	@RequestMapping(value = "/insertCompanyWithTx")
	@ResponseBody
	public JsonResult<Long> insertCompanyWithTx(String companyName, Long companyCelebrateTime,String companyMailSuffix,HttpServletRequest req ) {
		SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );  
		CompanyVO vo = new CompanyVO();
		if(EmptyUtil.isEmpty(companyName)){
			throw new BusinessException("企业名称不能为空");
		}else{
			vo.setCompanyName(companyName);
		}
		if(EmptyUtil.isNotEmpty(companyCelebrateTime)){
			try {
				vo.setCompanyCelebrateTime(format.parse(format.format(companyCelebrateTime)));
			} catch (ParseException e) {
				throw new BusinessException("司庆时间数据转换异常");
			}
		}
		CompanyDTO dto = CompanyConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		if(EmptyUtil.isEmpty(companyMailSuffix)){
			throw new BusinessException("企业邮箱后缀不能为空");
		}else{
			dto.setCompanyMailSuffix(companyMailSuffix);
		}
		Long rt = companyManage.insertCompanyWithTx(dto);	
		return success(rt);					 
	}
	
	// 业务方法：根据id更新数据
	@RequestMapping(value = "/updateCompanyByIdWithTx")
	@ResponseBody
	public JsonResult<Integer> updateCompanyByIdWithTx(Long id, String companyName, Long companyCelebrateTime,String companyMailSuffix,HttpServletRequest req ) {
		SimpleDateFormat format =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );  
		CompanyVO vo = new CompanyVO();
		if(EmptyUtil.isEmpty(id)){
			if(EmptyUtil.isEmpty(companyMailSuffix)){
				throw new BusinessException("企业邮箱后缀不能为空");
			}else{
				vo.setCompanyMailSuffix(companyMailSuffix);
			}
		}else{
			vo.setId(id);
		}
		if(EmptyUtil.isEmpty(companyName)){
			throw new BusinessException("企业名称不能为空");
		}else{
			vo.setCompanyName(companyName);
		}
		vo.setCompanyMailSuffix(companyMailSuffix);
		if(EmptyUtil.isNotEmpty(companyCelebrateTime)){
			try {
				vo.setCompanyCelebrateTime(format.parse(format.format(companyCelebrateTime)));
			} catch (ParseException e) {
				throw new BusinessException("司庆时间数据转换异常");
			}
		}
		CompanyDTO dto = CompanyConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		int rt = companyManage.updateCompanyWithTx(dto);	
		return success(rt);					 
	}

	// 业务方法：
	@RequestMapping(value = "/deleteCompanyWithTx")
	@ResponseBody
	public JsonResult<Integer> deleteCompanyWithTx(CompanyVO vo,HttpServletRequest req ) {
		CompanyDTO dto = CompanyConverter.toDTO(vo);
		String str = req.getHeader("platformId");		
		if(EmptyUtil.isNotEmpty(str)){
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		int rt = companyManage.deleteCompanyWithTx(dto);	
		return success(rt);					 
	}
		
}
	