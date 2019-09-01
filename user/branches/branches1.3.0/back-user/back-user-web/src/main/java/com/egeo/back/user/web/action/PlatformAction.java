package com.egeo.back.user.web.action;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.PlatformManage;
import com.egeo.back.user.model.vo.PlatformVO;
import com.egeo.basics.user.model.dto.PlatformDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;

/**
 * 平台控制层
 * @author 闵浮龙
 *
 */

@Controller
@RequestMapping("user/platform")
public class PlatformAction extends BaseSpringController {
	
	@Resource(name="platform")
	private PlatformManage platformManage;
	
	/**
         * 查询所有平台
         * @return
         */
        @RequestMapping(value = "findAll")
        @ResponseBody
        public JsonResult<PageResult<PlatformDTO>> findAll(PlatformDTO dto,Pagination page) {
            JsonResult<PageResult<PlatformDTO>> result = new JsonResult<PageResult<PlatformDTO>>();
            result.setData(platformManage.findAll(dto,page));
                return  result;
        }
        
        /**
         * 更新平台信息
         * @return
         */
        @RequestMapping(value = "save")
        @ResponseBody
        public JsonResult<String> save(PlatformDTO dto) {
            JsonResult<String> result = new JsonResult<String>();
            try {
                if (logger.isInfoEnabled()) {
                    logger.info("添加平台信息, PlatformDTOName = {}", dto.getName());
                }
                
                result.setData(platformManage.save(dto)+"");
                if (logger.isInfoEnabled()) {
                    logger.info("添加平台信息成功, PlatformDTOName = {}", dto.getName());
                }
                    return  result;
            } catch (Exception e) {
                logger.error("添加平台信息异常！ PlatformDTOName = " + dto.getName(), e);
                result.setCode(1);
                result.setError("添加平台信息异常:" + e.getMessage());
                return  result;
            }
        }
        
        /**
         * 更新平台信息
         * @return
         */
        @RequestMapping(value = "upDate")
        @ResponseBody
        public JsonResult<String> upDate(PlatformDTO dto) {
            JsonResult<String> result = new JsonResult<String>();
            if(dto.getSaveOrUpdate().equals("1")){
                return this.save(dto);
                
            }else{
                try {
                    if (logger.isInfoEnabled()) {
                        logger.info("更新平台信息, PlatformDTOName = {}", dto.getName());
                    }
                    
                    result.setData(platformManage.upDate(dto)+"");
                    if (logger.isInfoEnabled()) {
                        logger.info("更新平台信息成功, PlatformDTOName = {}", dto.getName());
                    }
                        return  result;
                } catch (Exception e) {
                    logger.error("更新平台信息异常！ PlatformDTOName = " + dto.getName(), e);
                    result.setError("更新平台信息异常:" + e.getMessage());
                    result.setCode(1);
                    return  result;
                }
            }
            
        }
        
        /**
         * 根据UserId查询平台信息
         * @return
         */
        @RequestMapping(value = "PlatformByUserId")
        @ResponseBody
        public JsonResult<List<PlatformDTO>> PlatformByUserId(Long userId){
            JsonResult<List<PlatformDTO>> result = new JsonResult<List<PlatformDTO>>();
            try {
                if (logger.isInfoEnabled()) {
                    logger.info("根据UserId查询平台信息, useId = {}", userId);
                }
                List<PlatformDTO> list = platformManage.PlatformByUserId(userId);
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
         * 根据UserId查询平台信息
         * @return
         */
        @RequestMapping(value = "PlatformByUId")
        @ResponseBody
        public JsonResult<List<PlatformDTO>> PlatformByUId(Long userId){
            JsonResult<List<PlatformDTO>> result = new JsonResult<List<PlatformDTO>>();
            try {
                if (logger.isInfoEnabled()) {
                    logger.info("根据UserId查询平台信息, useId = {}", userId);
                }
                List<PlatformDTO> list = platformManage.PlatformByUId(userId);
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
         * 根据平台Id删除平台信息
         * @return
         */
        @RequestMapping(value = "deleteById")
        @ResponseBody
        public JsonResult<String> deleteById(PlatformVO platformVO){
            JsonResult<String> result = new JsonResult<String>();
            try {
                if (logger.isInfoEnabled()) {
                    logger.info("根据平台Id删除平台信息, Id = {}", platformVO.getId());
                }
                Integer rows  = platformManage.deleteById(platformVO);
                if (logger.isInfoEnabled()) {
                    logger.info("根据平台Id删除平台信息成功, Id = {}", platformVO.getId());
                }
                result.setData("删除"+rows+"条成功");
                return result;
            } catch (Exception e) {
                logger.error("根据平台Id删除平台信息异常！ Id = " + platformVO.getId(), e);
                result.setCode(1);
                result.setError("根据平台Id删除平台信息失败:" + e.getMessage());
                return result;
            }
        }
	
        
	 
}
	