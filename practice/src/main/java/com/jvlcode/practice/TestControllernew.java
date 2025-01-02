
package com.jvlcode.practice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/controllerA")	
public class TestControllernew {

	@PostMapping("/test")
	public String test() {
		System.out.println("test1 called");
		return "Helloqss World1";
	}
	
	@GetMapping("/test")
	public String test1() {
		System.out.println("test1 called");
		return "Helloqss World1";
	}

}
