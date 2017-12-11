package com.ldf.java.app.service;


import org.springframework.stereotype.Service;

@Service(value = "springBootTestService")
public class SpringBootTestService  implements ISpringBootTestService{

	@Override
	public String getList() {
		return "ok";
	}
	
}

