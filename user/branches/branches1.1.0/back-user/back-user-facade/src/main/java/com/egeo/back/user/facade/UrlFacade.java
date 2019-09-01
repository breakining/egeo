package com.egeo.back.user.facade;

import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;
import com.egeo.basics.user.api.read.UrlReadService;


@Component
public class UrlFacade {
	
	@Reference
	private UrlReadService urlReadService;

	public List<String> findAll() {
		// TODO Auto-generated method stub
		return urlReadService.findAll();
	}
	


}
	