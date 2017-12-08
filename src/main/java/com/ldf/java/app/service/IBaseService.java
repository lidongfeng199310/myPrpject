package com.ldf.java.app.service;

import java.util.List;

public interface IBaseService {

	public <T> T getOne(T param);
	
	public <T> List<T> getList(T params);
	
	public <T> int update(T param);
	
	public <T> int insert(T param);
	
	public <T> int delete(T param);
	
}
