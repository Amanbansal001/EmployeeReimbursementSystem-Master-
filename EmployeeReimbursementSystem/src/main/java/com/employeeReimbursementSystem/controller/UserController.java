package com.employeeReimbursementSystem.controller;
 rabbit
//request mapping for user dashboard!
public class UserController {
=======

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
 dhakk-Champion

@Controller
public class UserController {
	
	@RequestMapping("/userDashboard")
	public String displayHome()
	{
		return "userDashboard";
	}
	
}
