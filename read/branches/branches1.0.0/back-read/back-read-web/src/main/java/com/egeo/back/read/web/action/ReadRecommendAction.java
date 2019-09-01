package com.egeo.back.read.web.action;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.egeo.back.read.business.ReadRecommendManage;
import com.egeo.back.read.converter.ReadRecommendConverter;
import com.egeo.back.read.model.vo.ReadRecommendVO;
import com.egeo.basics.read.model.dto.ReadRecommendDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;
import com.egeo.core.web.BaseSpringController;
import com.egeo.core.web.JsonResult;
import com.egeo.utils.EmptyUtil;

@Controller
@RequestMapping("read/readRecommend")
public class ReadRecommendAction extends BaseSpringController {

	@Resource(name = "readRecommend")
	private ReadRecommendManage readRecommendManage;

	// 业务方法：
	/**
	 * 根据id查询所有阅读推荐信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findReadRecommendById")
	@ResponseBody
	public JsonResult<ReadRecommendVO> findReadRecommendById(Long id) {

		ReadRecommendDTO dto = new ReadRecommendDTO();
		dto.setId(id);
		ReadRecommendDTO rt = readRecommendManage.findReadRecommendById(dto);
		return success(ReadRecommendConverter.toVO(rt));

	}

	/**
	 * 查询所有悦读推荐信息
	 * 
	 * @param vo
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/findReadRecommendAll")
	@ResponseBody
	public JsonResult<List<ReadRecommendVO>> findReadRecommendAll(ReadRecommendVO vo, HttpServletRequest req) {
		ReadRecommendDTO dto = ReadRecommendConverter.toDTO(vo);
		String str = req.getHeader("platformId");
		if (EmptyUtil.isNotEmpty(str)) {
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		Long companyId = (dto.getCompanyId()== 0L) ? null : dto.getCompanyId();
		dto.setCompanyId(companyId);
		dto.setType(1);
		List<ReadRecommendDTO> rt = readRecommendManage.findReadRecommendAll(dto);
		return success(ReadRecommendConverter.toVO(rt));

	}

	/**
	 * 分页查询所有悦读推荐信息
	 * 
	 * @param vo
	 * @param page
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/findReadRecommendOfPage")
	@ResponseBody
	public JsonResult<PageResult<ReadRecommendVO>> findReadRecommendOfPage(ReadRecommendVO vo, Pagination page,
			HttpServletRequest req) {
		logger.info("分页查询所有悦读推荐信息");
		ReadRecommendDTO dto = ReadRecommendConverter.toDTO(vo);
		String str = req.getHeader("platformId");
		if (EmptyUtil.isNotEmpty(str)) {
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		Long companyId = (dto.getCompanyId()== 0L) ? null : dto.getCompanyId();
		dto.setCompanyId(companyId);
		dto.setType(1);
		PageResult<ReadRecommendDTO> rt = readRecommendManage.findReadRecommendOfPage(dto, page);
		List<ReadRecommendVO> list = ReadRecommendConverter.toVO(rt.getList());
		PageResult<ReadRecommendVO> result = new PageResult<ReadRecommendVO>();
		result.setList(list);
		result.setPageNo(rt.getPageNo());
		result.setPageSize(rt.getPageSize());
		result.setTotalSize(rt.getTotalSize());

		return success(result);

	}

	/**
	 * 添加阅读推荐信息 返回是插入行的id
	 * 
	 * @param vo
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/insertReadRecommendWithTx")
	@ResponseBody
	public JsonResult<Long> insertReadRecommendWithTx(ReadRecommendVO vo, HttpServletRequest req) {
		logger.info("添加阅读推荐信息");
		ReadRecommendDTO dto = ReadRecommendConverter.toDTO(vo);
		String str = req.getHeader("platformId");
		if (EmptyUtil.isNotEmpty(str)) {
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		dto.setType(1);
		Long rt = readRecommendManage.insertReadRecommendWithTx(dto);
		return success(rt);
	}

	/**
	 * 根据id修改阅读推荐信息
	 * 
	 * @param vo
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/updateReadRecommendByIdWithTx")
	@ResponseBody
	public JsonResult<Integer> updateReadRecommendByIdWithTx(ReadRecommendVO vo, HttpServletRequest req) {
		logger.info("根据id修改阅读推荐信息");
		ReadRecommendDTO dto = ReadRecommendConverter.toDTO(vo);
		String str = req.getHeader("platformId");

//		根据id查询推荐阅读信息
//		ReadRecommendDTO dto2 = new ReadRecommendDTO();
//		dto2.setId(dto.getId());
//		dto2.setType(1);
//		ReadRecommendDTO rDto = readRecommendManage.findReadRecommendById(dto2);
//		if (EmptyUtil.isNotEmpty(rDto.getBooksPicture()) && !rDto.getBooksPicture().equals(dto.getBooksPicture())) {
//			 如果查询出的之前的书图不为空，并且修改之前的书籍图片和现在的书籍图片地址不同，删除之前的图片
//			try {
//				// 删除之前的图片
//				FileUtil.deleteContents(new File(""+rDto.getBooksPicture()));
//			} catch (Exception e) {
//				e.printStackTrace();
//				logger.error("删除图片发生错误");
//			}
			if (EmptyUtil.isNotEmpty(str)) {
				Long platformId = Long.valueOf(str);
				dto.setPlatformId(platformId);
			}
			int rt = readRecommendManage.updateReadRecommendWithTx(dto);

			return success(rt);

	}

	/**
	 * 根据id删除悦读信息
	 * 
	 * @param vo
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/deleteReadRecommendWithTx")
	@ResponseBody
	public JsonResult<Integer> deleteReadRecommendWithTx(ReadRecommendVO vo, HttpServletRequest req) {
		logger.info("根据id删除阅读信息");
		ReadRecommendDTO dto = ReadRecommendConverter.toDTO(vo);
		String str = req.getHeader("platformId");
		if (EmptyUtil.isNotEmpty(str)) {
			Long platformId = Long.valueOf(str);
			dto.setPlatformId(platformId);
		}
		int rt = readRecommendManage.deleteReadRecommendWithTx(dto);
		return success(rt);
	}

}
