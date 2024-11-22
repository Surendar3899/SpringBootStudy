package com.payilagam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
	
	@RequestMapping("index")
	public String index() {
		System.out.println("index called");
		return "demo.jsp";
		
	}
	
	
	@RequestMapping("/demo")
	public String demo() {
		System.out.println("demo called");
		return "index.jsp";
		
	}

}
