package com.payilagam.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.payilagam.dao.UserDAO;
import com.payilagam.model.User;

@Controller
public class UserController {
	
	@Autowired
	UserDAO userdao;
	
	
	
	@RequestMapping("index")
	public String user() {
		System.out.println("index called");
		return "index";
		
	}
	
	@RequestMapping("addUser")
	public String addUser(User user) {
		System.out.println("addUser called");
		userdao.save(user);
		return "index";
		
	}
	
	
	@RequestMapping("getUser")
	public ModelAndView getUser(@RequestParam int id) {
		System.out.println("getUser called");
		ModelAndView mav = new ModelAndView("showUser");
		//Optional<User> user = userdao.findById(id);
		User user = userdao.findById(id).orElse(new User());
		mav.addObject(user);
		return mav;
		
		
	}
	
	
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(@RequestParam int id) {
		System.out.println("deleteUser called");
		ModelAndView mav = new ModelAndView("deleteUser");
		//Optional<User> user = userdao.findById(id);
		User user = userdao.findById(id).orElse(new User());
		userdao.deleteById(id);
		mav.addObject(user);
		return mav;
		
		
	}
	
	
	
	@RequestMapping("updateUser")
	public ModelAndView updateUser(User user) {
		System.out.println("updateUser called");
		ModelAndView mav = new ModelAndView("updateUser");
		//Optional<User> user = userdao.findById(id);
		user = userdao.findById(user.getId()).orElse(new User());
		userdao.deleteById(user.getId());
		mav.addObject(user);
		return mav;
		
		
	}
	

}
