package com.employeeReimbursementSystem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.employeeReimbursementSystem.entity.UsersCreds;

public class LoginDao {

	@Autowired
	JdbcTemplate loginDao;

	/* return the list of Users from database */
	public List<UsersCreds> getUserCreds(UsersCreds userCreds) {
		String sql = "select * from user_creds where emp_id =? and password =?";
		return loginDao.query(sql, new Object[] { userCreds.getEmpId(), userCreds.getPassword() },
				new RowMapper<UsersCreds>() {
					public UsersCreds mapRow(ResultSet rs, int rowNum) throws SQLException {
						UsersCreds usersCreds = new UsersCreds();
						usersCreds.setEmpId(rs.getString(1));
						usersCreds.setEmail(rs.getString(2));
						usersCreds.setPassword(rs.getString(3));
			           usersCreds.setRole(rs.getString(4));
						return usersCreds;
					}
				});
}

	public List<UsersCreds> fetchEmail(UsersCreds creds)
	{
		String sql = "select * from user_creds where emp_id =?";
		return loginDao.query(sql, new Object[] { creds.getEmpId()},
				new RowMapper<UsersCreds>() {
					public UsersCreds mapRow(ResultSet rs, int rowNum) throws SQLException {
						UsersCreds usersCreds = new UsersCreds();
						usersCreds.setEmpId(rs.getString(1));
						usersCreds.setEmail(rs.getString(2));
						usersCreds.setPassword(rs.getString(3));
			           usersCreds.setRole(rs.getString(4));
						return usersCreds;
					}
				}); 
	}

}