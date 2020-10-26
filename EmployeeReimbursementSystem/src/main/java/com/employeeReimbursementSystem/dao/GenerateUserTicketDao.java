package com.employeeReimbursementSystem.dao;
/*
 * @Author: Shubham Mishra
 */
import com.employeeReimbursementSystem.entity.UserTicket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class GenerateUserTicketDao {
    @Autowired
	JdbcTemplate template;   

	public static int save(UserTicket data) {
		byte []image = data.getImage().getBytes();
		 String sql="insert into user_ticket(emp_id,name,amount,image,timestamp,approved_by,forwarded_to,remark,status) values('"+data.getEmpId()+"','"+data.getName()+"','"+data.getAmount()+"','"+image+"','"+data.getTimeStamp()+"','"+data.getApprovedBy()+"','"+data.getForwardedTo()+"','"+data.getRemark()+"','"+data.getStatus()+"')";	
		return template.update(sql);
		
	}
}
