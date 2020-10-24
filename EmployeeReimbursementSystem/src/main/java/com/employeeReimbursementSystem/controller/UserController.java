package com.employeeReimbursementSystem.controller;


//request mapping for user dashboard!
//comment 2
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	//Usr ontrollrrrr omt 1jvhjv
	@RequestMapping("/userDashboard")
	public String displayHome()
	{
		return "userDashboard";
	}
	
}
