package com.egeo.back.user.web.action;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.UrlManage;
import com.egeo.back.user.model.vo.UrlVO;
import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.core.Constant.BusinessExceptionConstant;
import com.egeo.core.Constant.CacheKeyConstant;
import com.egeo.core.common.PageResult;
import com.egeo.core.exception.BusinessException;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.util.cache.JedisUtil;
/**
 * url控制层
 * @author 闵浮龙
 *
 */
@Controller
@RequestMapping("user/url")
public class UrlAction extends BaseSpringController {

    @Resource(name = "url")
    private UrlManage urlManage;
    
    @Resource(name = "userCache")
    private JedisUtil cache;

    /**
     * 查询所有url
     * 
     * @return
     */
    @RequestMapping(value = "urlList")
    @ResponseBody
    public List<String> findAll() {
        return urlManage.getUrlList();

    }

    /**
     * 查询所有url信息
     */
    @RequestMapping(value = "lists")
    @ResponseBody
    public JsonResult<PageResult<UrlDTO>> findAll(Pagination page, UrlDTO urlDTO) {
        PageResult<UrlDTO> pageResult = urlManage.findAll(page, urlDTO);
        if(urlDTO.getPlatformId() == null){
            urlDTO.setPlatformId(1L);
        }
        return success(pageResult);

    }

    /**
     * 更新
     * 
     * @param dto
     * @return
     */
    @RequestMapping(value = "saveOrUpdate")
    @ResponseBody
    public JsonResult<String> saveOrUpdate(@Valid UrlVO vo, BindingResult br) {
        JsonResult<String> result = new JsonResult<String>();
        String url =vo.getUrl();
        boolean slash = false;
        if(!url.substring(0,1).equals("/")){
            throw new BusinessException(BusinessExceptionConstant.FIRST_TO_SLASH, "第一个字符必须为/");
        }
        char[] chars = url.toCharArray(); 
        if(chars[0]==chars[1]){
            throw new BusinessException(BusinessExceptionConstant.TWO_NO_SLASH, "第二个字符不能为/");
        }
        for (int i = 1;  i < chars.length-1; i++) {  
            if(chars[i]==chars[0]){
                slash = true;
            }
        }  
        if(slash == false){
            throw new BusinessException(BusinessExceptionConstant.TO_TWO_SLASH, "/一定要有2个");
        }
        if (br.hasErrors()) { // 如果实体类校验失败
            List<ObjectError> errors = br.getAllErrors();
            result.setError(errors.get(0).getDefaultMessage());
            return result;
        }else{
            try {
                if (logger.isInfoEnabled()) {
                    logger.info("更新url, UrlName = {}", vo.getName());
                }
                int id = urlManage.saveOrUpdate(vo);
                if (logger.isInfoEnabled()) {
                    logger.info("更新url成功, UrlName = {}", vo.getName());
                }
                result.setData("0");
                result.setError("更新url成功！");
                //清除缓存
                cache.del(CacheKeyConstant.MENU_CACHE_LIST_KEY);
                //添加需要拦截的url缓存
                cache.set(CacheKeyConstant.MENU_CACHE_LIST_KEY, urlManage.getUrlList());
                
                return result;
            } catch (Exception e) {
                logger.error("更新url异常！ name = " + vo.getName(), e);
                result.setError("更新url失败:" + e.getMessage()
                );
                result.setData("1");
                return result;
            }
        }
        
    }

    /**
     * 根据id删除
     * 
     * @param dto
     * @return
     */
    @RequestMapping(value = "delete")
    @ResponseBody
    public JsonResult<Object> delete(UrlDTO dto) {
        urlManage.deleteWithTx(dto);
        return success(null);
    }

    /*
     * @RequestMapping(value = "findUserId")
     * 
     * @ResponseBody public JsonResult<String> findUserId(UserVO user) {
     * 
     * JsonResult<String> result = new JsonResult<String>(); String id =
     * urlManage.findUniqueUser(user).getId(); result.setData(id); return result; }
     */

    /**
     * 根据roleid查询url
     */
    @RequestMapping(value = "findRoleId")
    @ResponseBody
    public List<UrlDTO> getUrlByRoleId(Long roleId) {

        return urlManage.getUrlByRoleId(roleId);
    }

}
