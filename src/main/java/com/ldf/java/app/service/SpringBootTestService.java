package com.ldf.java.app.service;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldf.java.app.mapper.SpringBootTestMapper;
import com.ldf.java.app.model.User;

@Service(value = "springBootTestService")
public class SpringBootTestService  implements ISpringBootTestService{

	@Resource
	SpringBootTestMapper mapper;
	
	@Override
	public String getList() {
		User user = new User();
		user.setName("ldf");
		user.setPassword("123456");
		return mapper.getOne(user).toString();
	}
	
}
