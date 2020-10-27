package com.employeeReimbursementSystem.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employeeReimbursementSystem.dao.LoginDao;
import com.employeeReimbursementSystem.entity.UsersCreds;
import com.employeeReimbursementSystem.factory.EntityFactory;

@Controller
public class LoginController {
	/* using Logger object errors can be logged or statement should be displayed */
	private static final Logger logger = Logger.getLogger(AdminController.class);
	/* inject dao from xml file */
	@Autowired
	LoginDao loginDao;
	/* inject factory from xml file */
	@Autowired
	EntityFactory factory;

	/* inject mailSender from xml file and send mail to users */
	@Autowired
	JavaMailSender mailSender;

	/* return the home page */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getHome() {
		ModelAndView modelandview = new ModelAndView("loginNew");
		modelandview.addObject("usercreds", factory.getInstance("userCreds"));
		return modelandview;
	}

	/*
	 * checks credentials of users and if Valid then return the adminDashboard else
	 * redirect to same page or password can be sent to mail
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String getLogin(@ModelAttribute("userCreds") UsersCreds creds, Model m, HttpSession session) {

		List<UsersCreds> checkUserCreds = loginDao.getUserCreds(creds);

		if (checkUserCreds.isEmpty()) {

			m.addAttribute("notFound", "Invalid credentials");
			m.addAttribute("usercreds", factory.getInstance("userCreds"));
			return "loginNew";
		}
		for (UsersCreds checkUser : checkUserCreds) {
			/* session starts when user authenticated */

			if (checkUser.getRole().equals("Admin")) {
				session.setAttribute("sessionStarted", creds.getEmpId());
				return "redirect:/adminDashboard";
			}
			if (checkUser.getRole().equals("User")) {
				session.setAttribute("sessionStarted", creds.getEmpId());
				return "redirect:/userDashboard";
			}
		}
		m.addAttribute("notFound", "Invalid credentials");
		m.addAttribute("usercreds", factory.getInstance("userCreds"));
		return "loginNew";
	}

	/* return the forget Page */
	@RequestMapping(value = "forgetPassword", method = RequestMethod.GET)
	public String displayForgetPassword(Model m) {
		m.addAttribute("forgetPassword", factory.getInstance("userCreds"));
		return "forgetPassword";
	}

	/* mail send to user if empID is correct */
	@RequestMapping(value = "sendEmail", method = RequestMethod.POST)
	public String sendEmail(@ModelAttribute("forgetPassword") UsersCreds creds, Model m, HttpSession session) {

		List<UsersCreds> fetchDetails = loginDao.fetchEmail(creds);
		if (fetchDetails.isEmpty()) {
			m.addAttribute("notFound", "EmpID is Not Valid");
			m.addAttribute("forgetPassword", factory.getInstance("userCreds"));
			return "forgetPassword";
		} else {

			for (UsersCreds sendEMail : fetchDetails) {
				SimpleMailMessage mailMsg = new SimpleMailMessage();
				mailMsg.setTo(sendEMail.getEmail());
				mailMsg.setSubject("Forget Password , Retrieve ");
				mailMsg.setText(sendEMail.getPassword());
				mailSender.send(mailMsg);
			}
			m.addAttribute("notFound", "Password Send to mail , registered with EmpID");
			m.addAttribute("usercreds", factory.getInstance("userCreds"));
			return "loginNew";
		}
	}

	/* when user logout , login page returns */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";

	}

}
