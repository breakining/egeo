package com.egeo.back.user.model.entity;

import java.io.Serializable;

import com.egeo.back.user.model.vo.CacheUser;



public class Ticket implements Serializable {
	
/**  */
	private static final long serialVersionUID = 1L;
	
	private CacheUser userCache;
	
	private long time;
	
	private long timeout;
	
	private String ut;
	
	public CacheUser getUser() {
		return userCache;
	}
	
	public void setUser(CacheUser userCache) {
		this.userCache = userCache;
	}
	
	public long getTime() {
		return time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public String getUt() {
		return ut;
	}

	public void setUt(String ut) {
		this.ut = ut;
	}

	public CacheUser getUserCache() {
		return userCache;
	}

	public void setUserCache(CacheUser userCache) {
		this.userCache = userCache;
	}
	
	
}
