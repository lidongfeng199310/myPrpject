package com.ldf.java.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service(value = "springBootTestService")
public class SpringBootTestService  implements ISpringBootTestService{

	@Override
	public <T> T getOne(T param) {
		return null;
	}

	@Override
	public <T> List<T> getList(T params) {
		return null;
	}

	@Override
	public <T> int update(T param) {
		return 0;
	}

	@Override
	public <T> int insert(T param) {
		return 0;
	}

	@Override
	public <T> int delete(T param) {
		return 0;
	}
	
}

