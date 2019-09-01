package com.egeo.back.user.business.impl;
	

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.egeo.back.user.business.UrlManage;
import com.egeo.back.user.facade.UrlFacade;

@Service("url")
public class UrlManageImpl implements UrlManage{

	
	@Resource(name="urlFacade")
	private UrlFacade urlFacade;
	
	
	@Override
	public List<String> getUrlList() {

		return urlFacade.findAll();
	}
	


}
	