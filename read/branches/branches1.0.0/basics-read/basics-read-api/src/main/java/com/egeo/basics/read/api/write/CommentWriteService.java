package com.egeo.basics.read.api.write;

import com.egeo.basics.read.model.dto.CommentDTO;


public interface CommentWriteService {

	public Long insertCommentWithTx(CommentDTO dto);

	public int updateCommentWithTx(CommentDTO dto);

	public int deleteCommentWithTx(CommentDTO dto);
}
	