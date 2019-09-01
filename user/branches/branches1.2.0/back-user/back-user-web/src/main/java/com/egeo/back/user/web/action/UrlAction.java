package com.egeo.back.user.web.action;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.user.business.UrlManage;
import com.egeo.back.user.model.vo.UrlVO;
import com.egeo.basics.user.model.dto.UrlDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;

@Controller
@RequestMapping("url")
public class UrlAction extends BaseSpringController {

    @Resource(name = "url")
    private UrlManage urlManage;

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
                return result;
            } catch (Exception e) {
                logger.error("更新url失败！ name = " + vo.getName(), e);
            }
            result.setError("更新url失败！");
            result.setData("1");
            return result;
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
