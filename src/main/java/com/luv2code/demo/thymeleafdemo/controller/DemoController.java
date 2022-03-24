/**
 * 
 */
package com.luv2code.demo.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Abhishek
 *
 */
@Controller
public class DemoController {
	
	@GetMapping("/hello")
	public String sayHello(Model theModel) {
		theModel.addAttribute("theDate", new java.util.Date());
		return "hello-world";
	}

}
