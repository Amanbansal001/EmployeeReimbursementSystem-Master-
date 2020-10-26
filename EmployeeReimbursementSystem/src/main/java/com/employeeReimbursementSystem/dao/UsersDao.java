package com.employeeReimbursementSystem.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import com.employeeReimbursementSystem.entity.UserDetails;
import com.employeeReimbursementSystem.entity.UsersCreds;

public class UsersDao {

	@Autowired
	JdbcTemplate userDao;

	public UsersCreds fetchEmail(UsersCreds creds) {
		String sql = "select * from user_creds where emp_Id = ?";
		return userDao.queryForObject(sql, new Object[] { creds.getEmpId() },
				new BeanPropertyRowMapper<UsersCreds>(UsersCreds.class));
	}

	public int saveUserDetails(UserDetails details) {

		byte[] uploadFile = details.getUploadfile().getBytes();
		System.out.println(uploadFile);
		String sql = "insert into checkuser(name,email,file,mobileNo) values (?,?,?,?)";
		return userDao.update(sql,
				new Object[] { details.getName(), details.getEmail(), uploadFile , details.getMobileNo() });
	}

	public UserDetails getImage(String email) {
		String sql = "select * from checkuser where email = ?";
		return userDao.queryForObject(sql, new Object[] { email },
				new BeanPropertyRowMapper<UserDetails>(UserDetails.class));
	}
}
