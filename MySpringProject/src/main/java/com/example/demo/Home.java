package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.demo.service.BSNL;

@Component
//@Scope(value="prototype")
public class Home {
	@Autowired
	private InternetConnection modem;

	@Autowired
	@Qualifier("outside")
	private BSNL bsnl;
	
	public Home(){
		System.out.println("Home constructor");
	}
	private String customerName;
	private int doorNo;
	
	public void connect() {
		
		bsnl.switchOn();
		
		System.out.println("Net connected successfully");
	}

}
