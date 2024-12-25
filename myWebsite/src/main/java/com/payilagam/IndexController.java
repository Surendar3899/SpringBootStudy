package com.payilagam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;


@Controller
public class IndexController {
	
	@RequestMapping("index")
	public ModelAndView index(@RequestParam("uname") String login, HttpSession session) {
		System.out.println("index called");
//		HttpSession session = request.getSession();
//		String name = request.getParameter("name");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("usern", login);
		mav.setViewName("index");
		session.setAttribute("usern", login);
		return mav;
		//return "index";
		
	}
	
	
//	@RequestMapping("demo")
//	public String demo() {
//		System.out.println("demo called");
//		return "index.jsp";
//		
//	}

}
