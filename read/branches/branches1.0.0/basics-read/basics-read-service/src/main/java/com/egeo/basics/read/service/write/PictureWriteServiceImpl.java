package com.egeo.basics.read.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.read.api.write.PictureWriteService;
import com.egeo.basics.read.business.write.PictureWriteManage;
import com.egeo.basics.read.converter.PictureConverter;
import com.egeo.basics.read.model.dto.PictureDTO;
import com.egeo.basics.read.po.PicturePO;
import com.egeo.core.basics.service.BaseService;

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
	