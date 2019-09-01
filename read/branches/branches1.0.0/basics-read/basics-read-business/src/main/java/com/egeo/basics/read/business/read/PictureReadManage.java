package com.egeo.basics.read.business.read;

import java.util.List;

import com.egeo.basics.read.po.PicturePO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;	

public interface PictureReadManage {

	public PicturePO findPictureById(PicturePO po);

	public PageResult<PicturePO> findPictureOfPage(PicturePO po,Pagination page);

	public List<PicturePO> findPictureAll(PicturePO po);
}
	