package com.employeeReimbursementSystem.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employeeReimbursementSystem.dao.UsersDao;
import com.employeeReimbursementSystem.entity.UserDetails;
import com.employeeReimbursementSystem.entity.UsersCreds;
import com.employeeReimbursementSystem.factory.EntityFactory;

@Controller
public class AdminController {

	/* using Logger object errors can be logged or statement should be displayed */
	private static final Logger logger = Logger.getLogger(AdminController.class);
	/*  inject dao from xml file   */
	@Autowired
	UsersDao userDao;
	
	@Autowired
	EntityFactory factory;
	/* inject mailSender from xml file and send mail to users*/ 
	@Autowired
	JavaMailSender mailSender;

	@RequestMapping("/adminDashboard")
	public String adminDashboar(Model m , HttpSession session)
	{
		String  checkSession = (String) session.getAttribute("sessionStarted");
		if(checkSession != null)
		{
			m.addAttribute("success" ,"Admin Dashboard");
			m.addAttribute("usersuccess" , "User Dsashboard");
			return "UserDashboard";	
		}
		else
		{
			return "redirect:/";
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("showUsers")
	public String showUsers()
	{
		return "Users";
	}
	
	@RequestMapping("showImage")
	public String getImage(Model m ) throws UnsupportedEncodingException
	{
		
		UserDetails details = userDao.getImage("ad0785409@gmail.com");
		   byte[] encodeBase64 = Base64.encodeBase64(details.getFile());
           String base64Encoded = new String(encodeBase64, "UTF-8");
           details.setImageDisplay(base64Encoded);
		m.addAttribute("showImag" , details);
		
		return "showImage";
	}
	@RequestMapping("userDetails")
	public String getUserDetails(Model m)
	{
		m.addAttribute("userDetails" , new UserDetails());
		return "userRegis";
	}
	
	@RequestMapping("saveUserDetails")
	public String savUserDetails(@ModelAttribute("userDetails") UserDetails details ,  Model m)
	{
	
		System.out.println(details);
		int i=userDao.saveUserDetails(details);
		System.out.println(i);
		if(i>0)
		{
		m.addAttribute("Details" , "successfully Saved");
		m.addAttribute("userDetails" , new UserDetails());
		return  "userRegis";
	}
		else
		{
			m.addAttribute("Details" ,  " Details Not  Saved");
			m.addAttribute("userDetails" , new UserDetails());
			return  "userRegis";
		}
	}
}
