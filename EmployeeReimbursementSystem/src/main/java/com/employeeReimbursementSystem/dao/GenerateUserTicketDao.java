package com.employeeReimbursementSystem.dao;
import com.employeeReimbursementSystem.entity.UserDetails;
/*
 * @Author: Shubham Mishra
 */
import com.employeeReimbursementSystem.entity.UserTicket;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class GenerateUserTicketDao {
    @Autowired
	JdbcTemplate generateUserTicketDao;   

	public  int saveUserTicket(UserTicket data) {
		byte []image = data.getImage().getBytes();
		 String sql="insert into user_ticket(emp_id,name,amount,image,timestamp,approved_by,forwarded_to,remark,status) values(?,?,?,?,?,?,?,?,?)";
		return generateUserTicketDao.update(sql, new Object[] {data.getEmpId() , data.getName() , data.getAmount() ,image ,data.getTimeStamp() , data.getApprovedBy() , data.getForwardedTo() , data.getRemark() , data.getStatus()});
		
	}

	public List<UserDetails> fetchUserDetails(String getSession) {
		String sql = "select * from user_details where emp_id =?";
return generateUserTicketDao.query(sql, new Object[] {getSession} , new RowMapper<UserDetails>() {


	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
	  UserDetails getUserDetails = new UserDetails();
	  getUserDetails.setEmpId(rs.getString(1));
	  getUserDetails.setFirstName(rs.getString(5));
	  getUserDetails.setLastName(rs.getString(6));
	  getUserDetails.setFile(rs.getBytes(11));
		
		return getUserDetails;
	}
	
});
	
	}
}
