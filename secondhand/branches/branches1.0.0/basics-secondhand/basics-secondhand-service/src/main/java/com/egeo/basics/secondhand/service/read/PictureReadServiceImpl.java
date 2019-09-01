package com.egeo.basics.secondhand.service.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.secondhand.api.read.PictureReadService;
import com.egeo.basics.secondhand.business.read.PictureReadManage;
import com.egeo.basics.secondhand.converter.PictureConverter;
import com.egeo.basics.secondhand.model.dto.PictureDTO;
import com.egeo.basics.secondhand.po.PicturePO;
import com.egeo.core.basics.service.BaseService;
import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

@Service("pictureReadService")
public class PictureReadServiceImpl extends BaseService implements PictureReadService {
	@Autowired
	private PictureReadManage pictureReadManage;

	@Override
	public PictureDTO findPictureById(PictureDTO dto) {
		PicturePO po = PictureConverter.toPO(dto);
		PicturePO list = pictureReadManage.findPictureById(po);		
		return PictureConverter.toDTO(list);
	}

	@Override
	public PageResult<PictureDTO> findPictureOfPage(PictureDTO dto, Pagination page) {
		PicturePO po = PictureConverter.toPO(dto);
        PageResult<PicturePO> pageResult = pictureReadManage.findPictureOfPage(po, page);
        
        List<PictureDTO> list = PictureConverter.toDTO(pageResult.getList());
        PageResult<PictureDTO> result = new PageResult<PictureDTO>();
        result.setList(list);
        result.setPageNo(pageResult.getPageNo());
        result.setPageSize(pageResult.getPageSize());
        result.setTotalSize(pageResult.getTotalSize());
        return result;
	}

	@Override
	public List<PictureDTO> findPictureAll(PictureDTO dto) {
		PicturePO po = PictureConverter.toPO(dto);
		List<PicturePO> list = pictureReadManage.findPictureAll(po);		
		return PictureConverter.toDTO(list);
	}
}
	