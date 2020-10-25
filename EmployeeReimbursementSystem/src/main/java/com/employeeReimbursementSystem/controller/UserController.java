package com.employeeReimbursementSystem.controller;

import com.employeeReimbursementSystem.dao.GenerateUserTicketDao;
import com.employeeReimbursementSystem.entity.UserTicket;

/*
 * @Author: Shubham Mishra
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserController {
    @Autowired
    GenerateUserTicketDao userTicketDao;
    
    @RequestMapping("/generateuserticket")
	public String showform(Model m){    
        m.addAttribute("UserTicketCreds", new UserTicket());  
        return "generateuserticket";   
    }
    
    @RequestMapping(value="GenerateUserTicketDao",method = RequestMethod.POST)    
    public String save(@ModelAttribute("UserTicketCreds") UserTicket data , Model m){    
		GenerateUserTicketDao.save(data);       
        return "redirect:/generateuserticketNew";
    }

    @RequestMapping("generateuserticketNew")
	public String uploadNew(Model m)
	{
		//returning html content as a success message
		 m.addAttribute("success" , "<div class=\"w3-panel w3-border w3-border-blue w3-display-container\">\r\n"
	        		+ "  <span onclick=\"this.parentElement.style.display='none'\"\r\n"
	        		+ "  class=\"w3-button  w3-large w3-display-topright\">x</span>\r\n"
	        		+ "  <p><span style=\\\"font-size:100%;line-height:0.6em;\\\">&#10004;</span> Bill uploaded successfully</p>\r\n"
	        		+ "</div>");
		  m.addAttribute("UserTicketCreds", new UserTicket()); 	
		return "generateuserticket";
	}
}
