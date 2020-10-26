package com.employeeReimbursementSystem.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.employeeReimbursementSystem.dao.ViewUserDetails;
import com.employeeReimbursementSystem.entity.UserDetails;
import com.employeeReimbursementSystem.factory.EntityFactory;

@Controller
public class AdminController {

	/* using Logger object errors can be logged or statement should be displayed */
	private static final Logger logger = Logger.getLogger(AdminController.class);
	/* inject dao from xml file */


	@Autowired
	ViewUserDetails userDetails;

	@Autowired
	EntityFactory factory;
	/* inject mailSender from xml file and send mail to users */
	@Autowired
	JavaMailSender mailSender;

	@RequestMapping("/adminDashboard")
	public String adminDashboar(Model m, HttpSession session) {
		String checkSession = (String) session.getAttribute("sessionStarted");
		if (checkSession != null) {
			m.addAttribute("success", "Admin Dashboard");
			return "adminDashboard";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping("showUsers")
	public String showUsers(Model m) throws UnsupportedEncodingException {
		List<UserDetails> userDetailss = userDetails.fetchUserDetails();
		if(userDetailss.isEmpty())
		{
			m.addAttribute("notFound","Users List are Empty");
			m.addAttribute("userImage", userDetailss);
			return "Users";
		}
		else {
			for (UserDetails displayUsers : userDetailss) {
				byte[] encodeBase64 = Base64.encodeBase64(displayUsers.getFile());
				System.out.println(encodeBase64);
				String base64Enocoded = new String(encodeBase64, "UTF-8");
				System.out.println(base64Enocoded);
				displayUsers.setImageDisplay(base64Enocoded);
			}
			m.addAttribute("userImage", userDetailss);
			return "Users";
		}
	
	}

	@RequestMapping("/addUserRegis")
	public String uploadImage(Model m) {
		m.addAttribute("uploadImage", new UserDetails());
		return "userRegis";
	}

	@RequestMapping( "saveUserDetails")
	public String saveImagee(@ModelAttribute("uploadImage") UserDetails image, Model m) {
		int i = userDetails.saveImage(image);
		if (i > 0) {
			m.addAttribute("saved", "image Save Sucessfully");
			m.addAttribute("uploadImage", new UserDetails());
			return "userRegis";
		} else {
			m.addAttribute("saved", "image not saved");
			m.addAttribute("uploadImage", new UserDetails());
			return "userRegis";

		}

	}
	
	@RequestMapping(value = "editUser/{empId}" ,method = RequestMethod.GET)
	public String editUserDetails(@PathVariable("empId") String empId , Model m)
	{
		UserDetails editUserDetails = userDetails.editUserDetails(empId);
		m.addAttribute("uploadImage" , editUserDetails);
		return "editUserRegis";
	}
	@RequestMapping(value = "editUserDetails" , method = RequestMethod.POST)
	public String saveEdituser(@ModelAttribute("uploadImage") UserDetails details ,Model m)
	{
	int i=	userDetails.saveEditUser(details);
		if(i>0)
		{
			m.addAttribute("saved" , "data saved Successfully");
			m.addAttribute("uploadImage" , new UserDetails());
	return "editUserRegis";
	}
		else
		{
			m.addAttribute("saved" , "data  not saved Successfully");
			m.addAttribute("uploadImage" , new UserDetails());
			return "editUserRegis";
		}
	}
	@RequestMapping(value = "userProfile/{empId}" ,method = RequestMethod.GET)
	public String showUserProfile(@PathVariable("empId") String empId , Model m)
	{
		UserDetails editUserDetails = userDetails.editUserDetails(empId);
		m.addAttribute("userProfile" , editUserDetails);
		return "userProfile";
	}
}
