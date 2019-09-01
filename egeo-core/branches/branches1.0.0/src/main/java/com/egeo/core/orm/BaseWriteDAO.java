package com.egeo.core.orm;

public interface BaseWriteDAO<T> {
	int insert(T po);

	int update(T po);

	int delete(T po);
	
	int deleteByPara(T po);
	
	
}
