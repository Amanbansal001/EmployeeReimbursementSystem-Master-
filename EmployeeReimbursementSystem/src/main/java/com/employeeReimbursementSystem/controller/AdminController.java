package com.employeeReimbursementSystem.controller;

import java.io.UnsupportedEncodingException;
import java.util.List



import javax.servlet.http.
import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

	@RequestMapping("/adminDashboard")
	public String adminDashboar(Model m, HttpSession session ) throws UnsupportedEncodingException {
		String checkSession = (String) session.getAttribute("sessionStarted");
		if (checkSession != null) {
			List<UserDetails> getUserDetails = userDetails.fetchUserImage(checkSession);
System.out.println(getUserDetails);
			for(UserDetails imageDetails : getUserDetails)
			{
				byte[] encodeBase64 = Base64.encodeBase64(imageDetails.getFile());
				String base64Enocoded = new String(encodeBase64, "UTF-8");
				imageDetails.setImageDisplay(base64Enocoded);
			}
			
			System.out.println(getUserDetails);
			m.addAttribute("userDetails", getUserDetails);
			return "adminDashboard";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping("showUsers")
	public String showUsers(Model m , HttpSession session ) throws UnsupportedEncodingException {
		
		String getSession= (String) session.getAttribute("sessionStarted");
		if(getSession != null)
		{
			List<UserDetails> userDetailss = userDetails.fetchUserDetails();
			if (userDetailss.isEmpty()) {
				m.addAttribute("notFound", "Users List are Empty");
				m.addAttribute("userImage", userDetailss);
				return "viewUsers";
			} else {
				for (UserDetails displayUsers : userDetailss) {
					byte[] encodeBase64 = Base64.encodeBase64(displayUsers.getFile());
					System.out.println(encodeBase64);
					String base64Enocoded = new String(encodeBase64, "UTF-8");
					System.out.println(base64Enocoded);
					displayUsers.setImageDisplay(base64Enocoded);
				}
				m.addAttribute("userImage", userDetailss);
				return "viewUsers";
			}
		}
		else
		{
			return "redirect:/";
		}
	}

	@RequestMapping("addUserRegis")
	public String uploadImage(Model m) {
		m.addAttribute("uploadImage", new UserDetails());
		return "userRegistrationForm";
	}

	@RequestMapping("saveUserDetails")
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
	@RequestMapping(value = "editUser/{empId}", method = RequestMethod.GET)
	public String editUserDetails(@PathVariable("empId") String empId, Model m) {
		UserDetails editUserDetails = userDetails.editUserDetail(empId);

		m.addAttribute("editUser", editUserDetails);
		return "editUserRegis";
	}

	@RequestMapping(value = "editUserDetails", method = RequestMethod.POST)
	public String saveEdituser(@ModelAttribute("editUser") UserDetails details, Model m) {
		int i = userDetails.saveEditUser(details);
		int j = userDetails.saveEditUser(details);
		if (i > 0) {
			m.addAttribute("saved", "data saved Successfully");
			m.addAttribute("uploadImage", new UserDetails());
			return "editUserRegis";
		} else {
			m.addAttribute("saved", "data  not saved Successfully");
			m.addAttribute("uploadImage", new UserDetails());
			
			m.addAttribute("saved", "data  not saved Successfully");
			m.addAttribute("uploadImage", new UserDetails())
			return "editUserRegis";
		}
	}

	@RequestMapping(value = "userProfile/{empId}", method = RequestMethod.GET)
	public String showUserProfile(@PathVariable("empId") String empId, Model m) throws UnsupportedEncodingException {
		UserDetails editUserDetails = userDetails.editUserDetail(empId);
		byte[] encodeBase64 = Base64.encodeBase64(editUserDetails.getFile());
		String base64Enocoded = new String(encodeBase64, "UTF-8");	
		editUserDetails.setImageDisplay(base64Enocoded);
		m.addAttribute("userProfile", editUserDetails);
		return "userProfile";
	}
}
