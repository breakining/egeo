package com.egeo.basics.secondhand.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.secondhand.api.write.PictureWriteService;
import com.egeo.basics.secondhand.business.write.PictureWriteManage;
import com.egeo.basics.secondhand.converter.PictureConverter;
import com.egeo.basics.secondhand.model.dto.PictureDTO;
import com.egeo.basics.secondhand.po.PicturePO;

@Service("pictureWriteService")
public class PictureWriteServiceImpl extends BaseService implements PictureWriteService {
	@Autowired
	private PictureWriteManage pictureWriteManage;

	@Override
	public Long insertPictureWithTx(PictureDTO dto) {
		PicturePO po = PictureConverter.toPO(dto);
		Long rt = pictureWriteManage.insertPictureWithTx(po);		
		return rt;
	}

	@Override
	public int updatePictureWithTx(PictureDTO dto) {
		PicturePO po = PictureConverter.toPO(dto);
		int rt = pictureWriteManage.updatePictureWithTx(po);		
		return rt;
	}

	@Override
	public int deletePictureWithTx(PictureDTO dto) {
		PicturePO po = PictureConverter.toPO(dto);
		int rt = pictureWriteManage.deletePictureWithTx(po);		
		return rt;
	}
}
	