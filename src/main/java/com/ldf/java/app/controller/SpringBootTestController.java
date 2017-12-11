package com.ldf.java.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldf.java.app.service.ISpringBootTestService;

@Controller
@RequestMapping("/springBootTestController")
public class SpringBootTestController {
	
	@Resource
	ISpringBootTestService testService;
	
	 @RequestMapping("/index")
	 @ResponseBody
	  public String index(){
	    return testService.getList();
	  }
}

