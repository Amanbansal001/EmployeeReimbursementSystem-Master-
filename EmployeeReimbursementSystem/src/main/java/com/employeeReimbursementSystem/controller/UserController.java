package com.employeeReimbursementSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
	
	//Usr ontrollrrrr omt 1
	@RequestMapping("/userDashboard")
	public String displayHome()
	{
		return "userDashboard";
	}
	
}
