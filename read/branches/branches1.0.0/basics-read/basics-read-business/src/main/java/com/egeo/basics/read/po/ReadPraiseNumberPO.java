package com.egeo.basics.read.po;

/**
 * @author ghw
 *
 */
public class ReadPraiseNumberPO {
	//id
	private Long id;
	//主题id
	private Long topicId;
	//点赞数
	private Integer praiseNumber;
	//平台ID
	private Long platformId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Integer getPraiseNumber() {
		return praiseNumber;
	}

	public void setPraiseNumber(Integer praiseNumber) {
		this.praiseNumber = praiseNumber;
	}

	public Long getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Long platformId) {
		this.platformId = platformId;
	}
	
	

}
