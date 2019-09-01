package com.egeo.back.user.web.action;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.CompanyManage;
import com.egeo.back.user.model.vo.CompanyVO;
import com.egeo.basics.user.model.dto.CompanyDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;



@Controller
@RequestMapping("user/company")
public class CompanyAction extends BaseSpringController {
	
	@Resource(name="company")
	private CompanyManage companyManage;
	/**
	 * 分页查询公司
	 * @param dto
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "findPage")
    @ResponseBody
    public JsonResult<PageResult<CompanyDTO>> findPage(CompanyVO vo,Pagination page) {
        JsonResult<PageResult<CompanyDTO>> result = new JsonResult<PageResult<CompanyDTO>>();
        result.setData(companyManage.findPage(vo,page));
            return  result;
    }
	
	/**
     * 添加公司信息
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public JsonResult<Long> save(CompanyVO vo) {
        JsonResult<Long> result = new JsonResult<Long>();
        try {
            if (logger.isInfoEnabled()) {
                logger.info("添加公司信息, CompanyDTOName = {}", vo.getName());
            }
            
            result.setData(companyManage.save(vo));
            if (logger.isInfoEnabled()) {
                logger.info("添加公司信息成功, CompanyDTOName = {}", vo.getName());
            }
                return  result;
        } catch (Exception e) {
            logger.error("添加公司信息异常！ CompanyDTOName = " + vo.getName(), e);
            result.setCode(1);
            result.setError("添加公司信息异常:" + e.getMessage());
            return  result;
        }
    }
    
    /**
     * 修改公司信息
     * @return
     */
    @RequestMapping(value = "upDate")
    @ResponseBody
    public JsonResult<Long> upDate(CompanyVO vo) {
        JsonResult<Long> result = new JsonResult<Long>();
        if(vo.getSaveOrUpdate().equals("1")){
            return this.save(vo);
            
        }else{
            try {
                if (logger.isInfoEnabled()) {
                    logger.info("修改公司信息, CompanyDTOName = {}", vo.getName());
                }
                
                result.setData(companyManage.upDate(vo));
                if (logger.isInfoEnabled()) {
                    logger.info("修改公司成功, CompanyDTOName = {}", vo.getName());
                }
                    return  result;
            } catch (Exception e) {
                logger.error("修改公司异常！ CompanyDTOName = " + vo.getName(), e);
                result.setError("修改公司异常:" + e.getMessage());
                result.setCode(1);
                return  result;
            }
        }
        
    }
    
    /**
     * 根据UserId查询平台信息
     * @return
     */
    @RequestMapping(value = "companyByUserId")
    @ResponseBody
    public JsonResult<List<CompanyVO>> companyByUserId(Long userId){
        JsonResult<List<CompanyVO>> result = new JsonResult<List<CompanyVO>>();
        try {
            if (logger.isInfoEnabled()) {
                logger.info("根据UserId查询公司信息, useId = {}", userId);
            }
            List<CompanyVO> list = companyManage.companyByUserId(userId);
            if (logger.isInfoEnabled()) {
                logger.info("根据UserId查询公司信息成功, useId = {}", userId);
            }
            result.setData(list);
            return result;
        } catch (Exception e) {
            logger.error("根据UserId查询公司信息失败异常！ useId = " + userId, e);
            result.setCode(1);
            result.setError("根据UserId查询公司信息失败:" + e.getMessage());
            return result;
        }
    }
    
    /**
     * 根据UserId查询平台信息
     * @return
     */
    @RequestMapping(value = "CompanyByUId")
    @ResponseBody
    public JsonResult<List<CompanyDTO>> CompanyByUId(Long userId){
        JsonResult<List<CompanyDTO>> result = new JsonResult<List<CompanyDTO>>();
        try {
            if (logger.isInfoEnabled()) {
                logger.info("根据UserId查询平台信息, useId = {}", userId);
            }
            List<CompanyDTO> list = companyManage.companyByUId(userId);
            if (logger.isInfoEnabled()) {
                logger.info("根据UserId查询平台信息成功, useId = {}", userId);
            }
            result.setData(list);
            return result;
        } catch (Exception e) {
            logger.error("根据UserId查询平台信息失败异常！ useId = " + userId, e);
            result.setCode(1);
            result.setError("根据UserId查询平台信息失败:" + e.getMessage());
            return result;
        }
    }
    
    /**
     * 根据平台Id删除公司信息
     * @return
     */
    @RequestMapping(value = "deleteById")
    @ResponseBody
    public JsonResult<String> deleteById(CompanyVO CompanyVO){
        JsonResult<String> result = new JsonResult<String>();
        try {
            if (logger.isInfoEnabled()) {
                logger.info("根据平台Id删除公司信息, Id = {}", CompanyVO.getId());
            }
            Integer rows  = companyManage.deleteById(CompanyVO);
            if (logger.isInfoEnabled()) {
                logger.info("根据平台Id删除公司信息成功, Id = {}", CompanyVO.getId());
            }
            result.setData("删除"+rows+"条成功");
            return result;
        } catch (Exception e) {
            logger.error("根据平台Id删除公司信息异常！ Id = " + CompanyVO.getId(), e);
            result.setCode(1);
            result.setError("根据平台Id删除公司信息失败:" + e.getMessage());
            return result;
        }
    }

}
	