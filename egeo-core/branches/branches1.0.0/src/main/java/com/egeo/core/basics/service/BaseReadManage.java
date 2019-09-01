package com.egeo.core.basics.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.egeo.core.common.PageResult;
import com.egeo.core.orm.Pagination;

public interface BaseReadManage<T> {
	public T findById(T po);

	public PageResult<T> findOfPage(T po, Pagination page);

	public int countOfPage(T po);

	public List<T> findAll(T po);
}
