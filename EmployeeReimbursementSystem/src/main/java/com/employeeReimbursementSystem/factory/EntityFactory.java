package com.employeeReimbursementSystem.factory;

import com.employeeReimbursementSystem.entity.AdminTicket;
import com.employeeReimbursementSystem.entity.UserDetails;
import com.employeeReimbursementSystem.entity.UserTicket;
import com.employeeReimbursementSystem.entity.UsersCreds;

public class EntityFactory {

	public EntityInterface getInstance(String instance)
	{
		if(instance.equals("userCreds"))
		{
			return new UsersCreds();
		}
		else if(instance.equals("userDetails"))
		{
			return new UserDetails();
		}
		else if(instance.equals("adminTicket"))
		{
			return new AdminTicket();
		}
		else if(instance.equals("userTicket"))
		{
			return new UserTicket();
		}
		else {
		return null;
	}
	}
}
