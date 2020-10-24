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

import com.employeeReimbursementSystem.dao.LoginDao;
import com.employeeReimbursementSystem.entity.UsersCreds;
import com.employeeReimbursementSystem.factory.EntityFactory;
import com.mysql.cj.Session;

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
	@RequestMapping("/")
	public String getHome(Model m) {
		logger.info("return login Page");
		m.addAttribute("usercreds", factory.getInstance("userCreds"));
		return "loginNew";
	}

	/*
	 * checks credentials of users and if Valid then return the adminDashboard else
	 * redirect to same page or password can be sent to mail
	 */
	@RequestMapping("login")
	public String getLogin(@ModelAttribute("userCreds") UsersCreds creds, Model m, HttpSession session) {

		logger.info("login url hit");
		if (creds.getPassword().isEmpty()) {
			UsersCreds fetchDetails = loginDao.fetchEmail(creds);
			SimpleMailMessage mailMsg = new SimpleMailMessage();
			mailMsg.setTo(fetchDetails.getEmail());
			mailMsg.setSubject("Forget Password , Retrieve ");
			mailMsg.setText(fetchDetails.getPassword());

			mailSender.send(mailMsg);
			m.addAttribute("notFound", "Password Send to mail , registered with EmpID");
			m.addAttribute("usercreds", new UsersCreds());
			return "loginNew";
		}
		List<UsersCreds> checkUserCreds = loginDao.getUserCreds(creds);

		if (checkUserCreds.isEmpty()) {

			m.addAttribute("notFound", "Invalid credentials");
			m.addAttribute("usercreds", factory.getInstance("userCreds"));
			return "loginNew";
		}
		for (UsersCreds checkUser : checkUserCreds) {
			/* session starts when user authenticated */

			if (checkUser.getRole().equals("admin")) {
				session.setAttribute("sessionStarted", creds.getEmpId());
				return "redirect:/adminDashboard";
			}
			if (checkUser.getRole().equals("user")) {
				session.setAttribute("sessionStarted", creds.getEmpId());
				m.addAttribute("success", "Not Authenticated");
				return "redirect:/adminDashboard";
			}
		}
		m.addAttribute("notFound", "Invalid credentials");
		m.addAttribute("usercreds", factory.getInstance("userCreds"));
		return "loginNew";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";

	}

}
