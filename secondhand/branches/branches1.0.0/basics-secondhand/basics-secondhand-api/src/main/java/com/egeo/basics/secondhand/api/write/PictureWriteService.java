package com.egeo.basics.secondhand.api.write;

import com.egeo.basics.secondhand.model.dto.PictureDTO;


public interface PictureWriteService {

	public Long insertPictureWithTx(PictureDTO dto);

	public int updatePictureWithTx(PictureDTO dto);

	public int deletePictureWithTx(PictureDTO dto);
}
	