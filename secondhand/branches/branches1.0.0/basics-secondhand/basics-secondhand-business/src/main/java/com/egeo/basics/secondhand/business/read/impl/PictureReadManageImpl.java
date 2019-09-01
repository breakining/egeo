package com.egeo.basics.secondhand.business.read.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.secondhand.business.read.PictureReadManage;
import com.egeo.basics.secondhand.dao.read.PictureReadDAO;
import com.egeo.basics.secondhand.po.PicturePO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;


@Service
public class PictureReadManageImpl implements PictureReadManage {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PictureReadDAO pictureReadDAO;
	
	public PicturePO findPictureById(PicturePO po) {
		PicturePO picturepo = new PicturePO();
		picturepo.setId(po.getId());
		return pictureReadDAO.findById(picturepo);
	}

	public PageResult<PicturePO> findPictureOfPage(PicturePO po, Pagination page) {
		
		PageResult<PicturePO> pageResult = new PageResult<PicturePO>();
		List<PicturePO> list = null;

		int cnt = pictureReadDAO.countOfPage(po);

		if (cnt >= (page.getPageNo() - 1) * page.getPageSize()) {
			page.setLimitStart((page.getPageNo() - 1) * page.getPageSize());
			list = pictureReadDAO.findOfPage(po, page);
		} else {
			list = new ArrayList<PicturePO>();
		}
		pageResult.setList(list);
		pageResult.setTotalSize(cnt);
		pageResult.setPageNo(page.getPageNo());
		pageResult.setPageSize(page.getPageSize());
		return pageResult;

	}

	public List<PicturePO> findPictureAll(PicturePO po) {

		return pictureReadDAO.findAll(po);
	}
	
}
	