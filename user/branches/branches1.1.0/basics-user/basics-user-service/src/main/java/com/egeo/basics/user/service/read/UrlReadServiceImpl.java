package com.egeo.basics.user.service.read;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egeo.core.basics.service.BaseService;
import com.egeo.basics.user.api.read.UrlReadService;
import com.egeo.basics.user.business.read.UrlReadManage;

@Service("urlReadService")
public class UrlReadServiceImpl extends BaseService implements UrlReadService {
	@Autowired
	private UrlReadManage urlReadManage;

	@Override
	public List<String> findAll() {
		// TODO Auto-generated method stub
		return urlReadManage.findAll();
	}
}
	