package com.egeo.basics.secondhand.business.write;

import com.egeo.basics.secondhand.po.PicturePO;


public interface PictureWriteManage {

	Long insertPictureWithTx(PicturePO po);

	int updatePictureWithTx(PicturePO po);

	int deletePictureWithTx(PicturePO po);
}
	