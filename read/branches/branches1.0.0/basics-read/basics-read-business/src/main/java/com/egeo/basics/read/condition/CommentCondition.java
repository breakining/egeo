package com.egeo.basics.read.condition;

import com.egeo.basics.read.po.CommentPO;

/**
 * 
 * @author min
 * @date 2017-11-17 13:18:41
 */
public class CommentCondition extends CommentPO {
	private static final long serialVersionUID = 1L;
	/**
	 * 评论目标用户id
	 */
	private Long commentTargetUserId;
	/**
	 * 评论目标用户姓名
	 */
	private String commentTargetUserName;
	public Long getCommentTargetUserId() {
		return commentTargetUserId;
	}
	public void setCommentTargetUserId(Long commentTargetUserId) {
		this.commentTargetUserId = commentTargetUserId;
	}
	public String getCommentTargetUserName() {
		return commentTargetUserName;
	}
	public void setCommentTargetUserName(String commentTargetUserName) {
		this.commentTargetUserName = commentTargetUserName;
	}
	

}
	