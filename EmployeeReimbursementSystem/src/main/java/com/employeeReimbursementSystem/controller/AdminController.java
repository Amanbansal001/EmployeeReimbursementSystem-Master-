package com.employeeReimbursementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employeeReimbursementSystem.dao.UsersDao;
import com.employeeReimbursementSystem.entity.UsersCreds;

@Controller
public class AdminController {

	/*  inject dao from xml file   */
	@Autowired
	UsersDao userDao;
	
	/* inject mailSender from xml file*/ 
	@Autowired
	JavaMailSender mailSender;
	
	/* return the home page */
	@RequestMapping("/")
	public String getHome(Model m)
	{
		m.addAttribute("usercreds" , new UsersCreds());
			return "loginNew";
	}
	/*checks credentials and return the page */
	@RequestMapping("login")
	public String getLogin(@ModelAttribute("userCreds") UsersCreds creds ,Model m)
	{
		if(creds.getPassword().isEmpty())
		{
			UsersCreds fetchDetails = userDao.fetchEmail(creds);
			SimpleMailMessage mailMsg = new SimpleMailMessage();
			mailMsg.setTo(fetchDetails.getEmail());
			mailMsg.setSubject("Forget Password , Retrieve ");
			mailMsg.setText(fetchDetails.getPassword());
			mailSender.send(mailMsg);
			m.addAttribute("notFound" , "Password Send to mail , registered with EmpID");
			m.addAttribute("usercreds" , new UsersCreds());
			return "loginNew";
		}
			List<UsersCreds> checkUserCreds = userDao.getUserCreds(creds);
		if(checkUserCreds.isEmpty())
		{
			m.addAttribute("notFound" , "Invalid Credentials");
			m.addAttribute("usercreds" , new UsersCreds());
			return "loginNew";
		}
	return "UserDashboard";
	}
}
