package com.payilagam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class IndexController {
	
	@RequestMapping("index")
	public String index(HttpServletRequest request) {
		System.out.println("index called");
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		session.setAttribute("usern", name);
		return "demo";
		
	}
	
	
//	@RequestMapping("demo")
//	public String demo() {
//		System.out.println("demo called");
//		return "index.jsp";
//		
//	}

}
