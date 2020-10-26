package com.employeeReimbursementSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.employeeReimbursementSystem.entity.UserDetails;
import com.employeeReimbursementSystem.entity.UsersCreds;

public class ViewUserDetails {

	@Autowired
	JdbcTemplate userDetailsDao;
	
	public List<UserDetails> fetchUserDetails()
	{
		String sql= "select * from user_details ";
		return userDetailsDao.query(sql, new RowMapper<UserDetails>() {

			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserDetails userDetails = new UserDetails();
				userDetails.setEmpId(rs.getString(1));
				userDetails.setRole(rs.getString(2));
				userDetails.setPassword(rs.getString(3));
				userDetails.setDesignation(rs.getString(4));
				userDetails.setFirstName(rs.getString(5));
				userDetails.setLastName(rs.getString(6));
				userDetails.setGender(rs.getString(7));
				userDetails.setMobileNo(rs.getString(8));
				userDetails.setEmail(rs.getString(9));
				userDetails.setCurrentAddress(rs.getString(10));
				userDetails.setFile(rs.getBytes(11));
				return userDetails;
			}
		});
	}
	public UserDetails getOneUser(String empId)
	{
		String sql = "select * from user_details where emp_id= ?";
		return userDetailsDao.queryForObject(sql, new Object[] {empId },
				new BeanPropertyRowMapper<UserDetails>(UserDetails.class));
	}
	public int  saveImage(UserDetails image) {
	byte []imageBytes  = image.getUploadfile().getBytes();
	     String sql= "insert into user_details(emp_id , role , password , designation , first_name , last_name ,gender,mobile,email,current_address , image) values (?,?,?,?,?,?,?,?,?,?,?)";
	   return userDetailsDao.update(sql, new Object[] {image.getEmpId() ,image.getRole() , image.getPassword() ,image.getDesignation() , image.getFirstName(), image.getLastName(), image.getGender(), image.getMobileNo(), image.getEmail(), image.getCurrentAddress(), imageBytes});
	}

	public UserDetails editUserDetails(String empId) {
		String sql = "select * from user_details where emp_id= ?";
		return userDetailsDao.queryForObject(sql, new Object[] {empId },
				new BeanPropertyRowMapper<UserDetails>(UserDetails.class));
	}
	public int  saveEditUser(UserDetails details) {
	
		byte []imageBytes  = details.getUploadfile().getBytes();
	     String sql= "update user_details set role=?,password=?, designation=?, first_name=?, last_name=?,gender=?,mobile=?,email=?,current_address=?, image=? where emp_id=?";
	   return userDetailsDao.update(sql, new Object[] {details.getRole() , details.getPassword() , details.getDesignation(), details.getFirstName() , details.getLastName(), details.getGender(), details.getMobileNo(), details.getEmail(), details.getCurrentAddress(), imageBytes , details.getEmpId()});
	
		
	}


}
