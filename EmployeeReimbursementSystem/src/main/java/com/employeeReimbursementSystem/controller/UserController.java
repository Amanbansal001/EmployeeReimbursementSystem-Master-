package com.employeeReimbursementSystem.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.employeeReimbursementSystem.dao.GenerateUserTicketDao;
import com.employeeReimbursementSystem.entity.UserDetails;
import com.employeeReimbursementSystem.entity.UserTicket;

@Controller
public class UserController {

	
	
	@RequestMapping("/userDashboard")
	public String displayHome()


    @Autowired
    GenerateUserTicketDao userTicketDao;
    
    @RequestMapping("userDashboard")
    public String displayUserDashboard(HttpSession session , Model m) throws UnsupportedEncodingException
    {
    	String getSession = (String) session.getAttribute("sessionStarted");
   
    	if(session != null)
    	{
    		List<UserDetails> getUserImage = userTicketDao.fetchUserDetails(getSession);
    		for(UserDetails getUserDetails : getUserImage)
    		{
    			byte []base64encode = Base64.encodeBase64(getUserDetails.getFile());
    			String encodedByte = new String(base64encode , "UTF-8");
    			getUserDetails.setImageDisplay(encodedByte);

    		}
    		m.addAttribute("userDetails" , getUserImage);
    		return "UserDashboard";
    	}
    	else {
    		return "redirect:/";
    	}
  
    }
    @RequestMapping("/generateuserticket")
	public String showform(Model m){    
        m.addAttribute("userTicketCreds", new UserTicket());  
        return "generateuserticket";   
    }
    
    @RequestMapping(value="GenerateUserTicketDao",method = RequestMethod.POST)    
    public String save(@ModelAttribute("userTicketCreds") UserTicket data , Model m){    
    	userTicketDao.saveUserTicket(data);       
        return "redirect:/generateuserticketNew";
    }

    @RequestMapping("generateuserticketNew")
	public String displayHome( Model m)


	{
		//returning html content as a success message
		 m.addAttribute("success" , "<div class=\"w3-panel w3-border w3-border-blue w3-display-container\">\r\n"
	        		+ "  <span onclick=\"this.parentElement.style.display='none'\"\r\n"
	        		+ "  class=\"w3-button  w3-large w3-display-topright\">x</span>\r\n"
	        		+ "  <p><span style=\\\"font-size:100%;line-height:0.6em;\\\">&#10004;</span> Bill uploaded successfully</p>\r\n"
	        		+ "</div>");
		  m.addAttribute("userTicketCreds", new UserTicket()); 	
		return "generateuserticket";
	}
}
