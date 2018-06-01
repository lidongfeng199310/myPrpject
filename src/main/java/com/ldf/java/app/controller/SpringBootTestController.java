package com.ldf.java.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ldf.java.app.service.ISpringBootTestService;

@RestController
@RequestMapping("/springBootTestController")
public class SpringBootTestController {
	
	@Autowired
	ISpringBootTestService testService;
	
	 @RequestMapping("/index")
	 @ResponseBody
	  public String index(){
	    return testService.getList();
	  }
}

