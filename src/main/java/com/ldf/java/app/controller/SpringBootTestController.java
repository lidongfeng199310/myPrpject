package com.ldf.java.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/springBootTestController")
public class SpringBootTestController {
	
	 @RequestMapping("/index")
	 @ResponseBody
	  public String index(){
	    return "index";
	  }
}

