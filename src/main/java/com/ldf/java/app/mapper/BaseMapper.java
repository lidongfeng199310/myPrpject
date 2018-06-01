package com.ldf.java.app.mapper;

import java.util.List;

public interface BaseMapper<T> {

	int insert(T params);
	
	int delete(T params);
	
	T getOne(T params);
	
	List<T> getList(T params);
	
	int update(T params);
}
