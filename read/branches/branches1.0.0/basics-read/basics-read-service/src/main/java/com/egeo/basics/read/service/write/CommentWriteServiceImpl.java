package com.egeo.basics.read.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.basics.read.api.write.CommentWriteService;
import com.egeo.basics.read.business.write.CommentWriteManage;
import com.egeo.basics.read.converter.CommentConverter;
import com.egeo.basics.read.model.dto.CommentDTO;
import com.egeo.basics.read.po.CommentPO;
import com.egeo.core.basics.service.BaseService;

@Service("commentWriteService")
public class CommentWriteServiceImpl extends BaseService implements CommentWriteService {
	@Autowired
	private CommentWriteManage commentWriteManage;

	@Override
	public Long insertCommentWithTx(CommentDTO dto) {
		CommentPO po = CommentConverter.toPO(dto);
		Long rt = commentWriteManage.insertCommentWithTx(po);		
		return rt;
	}

	@Override
	public int updateCommentWithTx(CommentDTO dto) {
		CommentPO po = CommentConverter.toPO(dto);
		int rt = commentWriteManage.updateCommentWithTx(po);		
		return rt;
	}

	@Override
	public int deleteCommentWithTx(CommentDTO dto) {
		CommentPO po = CommentConverter.toPO(dto);
		int rt = commentWriteManage.deleteCommentWithTx(po);		
		return rt;
	}
}
	