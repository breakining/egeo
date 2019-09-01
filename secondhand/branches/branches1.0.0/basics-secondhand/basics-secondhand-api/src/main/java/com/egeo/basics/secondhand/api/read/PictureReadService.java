package com.egeo.basics.secondhand.api.read;


import java.util.List;
	
import com.egeo.basics.secondhand.model.dto.PictureDTO;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface PictureReadService {

	public PictureDTO findPictureById(PictureDTO dto);

	public PageResult<PictureDTO> findPictureOfPage(PictureDTO dto,Pagination page);

	public List<PictureDTO> findPictureAll(PictureDTO dto);
}
	